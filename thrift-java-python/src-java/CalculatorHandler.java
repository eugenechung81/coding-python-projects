/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;

import shared.SharedStruct;
// Generated code
import tutorial.Calculator;
import tutorial.InvalidOperation;
import tutorial.Row;
import tutorial.Work;

import com.mezocliq.looqs.pagez.appserver.data.DataExtractor;
import com.mezocliq.looqs.pagez.appserver.data.DataFormatter;
import com.mezocliq.utils.DataUtils;

public class CalculatorHandler implements Calculator.Iface
{

	private HashMap<Integer, SharedStruct> log;

	public CalculatorHandler()
	{
		log = new HashMap<Integer, SharedStruct>();
	}

	public void ping()
	{
		System.out.println("ping()");
	}

	public int add(int n1, int n2)
	{
		System.out.println("add(" + n1 + "," + n2 + ")");
		return n1 + n2;
	}

	public int calculate(int logid, Work work) throws InvalidOperation
	{
		System.out.println("calculate(" + logid + ", {" + work.op + "," + work.num1 + "," + work.num2 + "})");
		int val = 0;
		switch (work.op)
		{
			case ADD:
				val = work.num1 + work.num2;
				break;
			case SUBTRACT:
				val = work.num1 - work.num2;
				break;
			case MULTIPLY:
				val = work.num1 * work.num2;
				break;
			case DIVIDE:
				if (work.num2 == 0)
				{
					InvalidOperation io = new InvalidOperation();
					io.what = work.op.getValue();
					io.why = "Cannot divide by 0";
					throw io;
				}
				val = work.num1 / work.num2;
				break;
			default:
				InvalidOperation io = new InvalidOperation();
				io.what = work.op.getValue();
				io.why = "Unknown operation";
				throw io;
		}

		SharedStruct entry = new SharedStruct();
		entry.key = logid;
		entry.value = Integer.toString(val);
		log.put(logid, entry);

		return val;
	}

	public SharedStruct getStruct(int key)
	{
		System.out.println("getStruct(" + key + ")");
		return log.get(key);
	}

	public void zip()
	{
		System.out.println("zip()");
	}

	private Row convertToThrift(DatabaseRow row) throws Exception
	{
		Row tRow = new Row();
		tRow.rowKey = row.getKey();
		tRow.table = row.getTable();
		Set<String> groupNames = row.getGroups();
		tRow.groups = new HashMap<>();
		for (String groupName : groupNames)
		{
			Map<Long, Map<String, String>> tGroup = new HashMap<>();
			HashMap<Long, DatabaseGroup> groups = row.getGroupAcrossSections(groupName);
			for (DatabaseGroup group : groups.values())
			{
				Map<String, String> tVariables = new HashMap<>();
				Long groupSerial = group.getSerial();
				// List<Var> tVars = new ArrayList<>();
				Set<String> variableIds = group.getVariables();
				for (String varId : variableIds)
				{
					DatabaseVariable variable = group.getVariable(varId);
					Serializable value = variable.getValue();
					// Var tVar = new Var();
					String format = DataExtractor.getFormat(varId);
					// tVar.varId = varId;
					// tVar.value = DataFormatter.convertForRead(format, value);
					// tVars.add(tVar);
					String stringValue = DataFormatter.convertForRead(format, value);
					tVariables.put(varId, stringValue);
				}
				tGroup.put(groupSerial, tVariables);
			}

			tRow.groups.put(groupName, tGroup);
		}
		return tRow;
	}

	@Override
	public List<Row> getRows(String tbl)
	{
		try
		{
			List<Row> tRows = new ArrayList<>();
			// List<DatabaseRow> rows = DataUtils.getRows("CANDIDATE");
			List<DatabaseRow> rows = DataUtils.getRows(tbl);
			long start = System.currentTimeMillis();
			for (DatabaseRow row : rows)
			{
				tRows.add(convertToThrift(row));
			}
			long end = System.currentTimeMillis();
			System.out.println("time: " + (end - start));
			return tRows;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Row getRow(String tbl, String key) throws TException
	{
		try
		{
			// DatabaseRow row = DataUtils.getRow("CANDIDATE", "e5af7810-23f1-11e4-a305-002590c0b6c6");
			DatabaseRow row = DataUtils.getRow(tbl, key);
			Row tRow = convertToThrift(row);
			return tRow;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
