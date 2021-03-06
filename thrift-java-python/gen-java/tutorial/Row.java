/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package tutorial;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Row implements org.apache.thrift.TBase<Row, Row._Fields>, java.io.Serializable, Cloneable, Comparable<Row> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Row");

  private static final org.apache.thrift.protocol.TField TABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("table", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ROW_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("rowKey", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("groups", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RowStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RowTupleSchemeFactory());
  }

  public String table; // required
  public String rowKey; // required
  public Map<String,Map<Long,Map<String,String>>> groups; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLE((short)1, "table"),
    ROW_KEY((short)2, "rowKey"),
    GROUPS((short)3, "groups");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TABLE
          return TABLE;
        case 2: // ROW_KEY
          return ROW_KEY;
        case 3: // GROUPS
          return GROUPS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.GROUPS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLE, new org.apache.thrift.meta_data.FieldMetaData("table", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ROW_KEY, new org.apache.thrift.meta_data.FieldMetaData("rowKey", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GROUPS, new org.apache.thrift.meta_data.FieldMetaData("groups", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64), 
                new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Row.class, metaDataMap);
  }

  public Row() {
  }

  public Row(
    String table,
    String rowKey)
  {
    this();
    this.table = table;
    this.rowKey = rowKey;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Row(Row other) {
    if (other.isSetTable()) {
      this.table = other.table;
    }
    if (other.isSetRowKey()) {
      this.rowKey = other.rowKey;
    }
    if (other.isSetGroups()) {
      Map<String,Map<Long,Map<String,String>>> __this__groups = new HashMap<String,Map<Long,Map<String,String>>>(other.groups.size());
      for (Map.Entry<String, Map<Long,Map<String,String>>> other_element : other.groups.entrySet()) {

        String other_element_key = other_element.getKey();
        Map<Long,Map<String,String>> other_element_value = other_element.getValue();

        String __this__groups_copy_key = other_element_key;

        Map<Long,Map<String,String>> __this__groups_copy_value = new HashMap<Long,Map<String,String>>(other_element_value.size());
        for (Map.Entry<Long, Map<String,String>> other_element_value_element : other_element_value.entrySet()) {

          Long other_element_value_element_key = other_element_value_element.getKey();
          Map<String,String> other_element_value_element_value = other_element_value_element.getValue();

          Long __this__groups_copy_value_copy_key = other_element_value_element_key;

          Map<String,String> __this__groups_copy_value_copy_value = new HashMap<String,String>(other_element_value_element_value);

          __this__groups_copy_value.put(__this__groups_copy_value_copy_key, __this__groups_copy_value_copy_value);
        }

        __this__groups.put(__this__groups_copy_key, __this__groups_copy_value);
      }
      this.groups = __this__groups;
    }
  }

  public Row deepCopy() {
    return new Row(this);
  }

  @Override
  public void clear() {
    this.table = null;
    this.rowKey = null;
    this.groups = null;
  }

  public String getTable() {
    return this.table;
  }

  public Row setTable(String table) {
    this.table = table;
    return this;
  }

  public void unsetTable() {
    this.table = null;
  }

  /** Returns true if field table is set (has been assigned a value) and false otherwise */
  public boolean isSetTable() {
    return this.table != null;
  }

  public void setTableIsSet(boolean value) {
    if (!value) {
      this.table = null;
    }
  }

  public String getRowKey() {
    return this.rowKey;
  }

  public Row setRowKey(String rowKey) {
    this.rowKey = rowKey;
    return this;
  }

  public void unsetRowKey() {
    this.rowKey = null;
  }

  /** Returns true if field rowKey is set (has been assigned a value) and false otherwise */
  public boolean isSetRowKey() {
    return this.rowKey != null;
  }

  public void setRowKeyIsSet(boolean value) {
    if (!value) {
      this.rowKey = null;
    }
  }

  public int getGroupsSize() {
    return (this.groups == null) ? 0 : this.groups.size();
  }

  public void putToGroups(String key, Map<Long,Map<String,String>> val) {
    if (this.groups == null) {
      this.groups = new HashMap<String,Map<Long,Map<String,String>>>();
    }
    this.groups.put(key, val);
  }

  public Map<String,Map<Long,Map<String,String>>> getGroups() {
    return this.groups;
  }

  public Row setGroups(Map<String,Map<Long,Map<String,String>>> groups) {
    this.groups = groups;
    return this;
  }

  public void unsetGroups() {
    this.groups = null;
  }

  /** Returns true if field groups is set (has been assigned a value) and false otherwise */
  public boolean isSetGroups() {
    return this.groups != null;
  }

  public void setGroupsIsSet(boolean value) {
    if (!value) {
      this.groups = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TABLE:
      if (value == null) {
        unsetTable();
      } else {
        setTable((String)value);
      }
      break;

    case ROW_KEY:
      if (value == null) {
        unsetRowKey();
      } else {
        setRowKey((String)value);
      }
      break;

    case GROUPS:
      if (value == null) {
        unsetGroups();
      } else {
        setGroups((Map<String,Map<Long,Map<String,String>>>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLE:
      return getTable();

    case ROW_KEY:
      return getRowKey();

    case GROUPS:
      return getGroups();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TABLE:
      return isSetTable();
    case ROW_KEY:
      return isSetRowKey();
    case GROUPS:
      return isSetGroups();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Row)
      return this.equals((Row)that);
    return false;
  }

  public boolean equals(Row that) {
    if (that == null)
      return false;

    boolean this_present_table = true && this.isSetTable();
    boolean that_present_table = true && that.isSetTable();
    if (this_present_table || that_present_table) {
      if (!(this_present_table && that_present_table))
        return false;
      if (!this.table.equals(that.table))
        return false;
    }

    boolean this_present_rowKey = true && this.isSetRowKey();
    boolean that_present_rowKey = true && that.isSetRowKey();
    if (this_present_rowKey || that_present_rowKey) {
      if (!(this_present_rowKey && that_present_rowKey))
        return false;
      if (!this.rowKey.equals(that.rowKey))
        return false;
    }

    boolean this_present_groups = true && this.isSetGroups();
    boolean that_present_groups = true && that.isSetGroups();
    if (this_present_groups || that_present_groups) {
      if (!(this_present_groups && that_present_groups))
        return false;
      if (!this.groups.equals(that.groups))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Row other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTable()).compareTo(other.isSetTable());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table, other.table);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRowKey()).compareTo(other.isSetRowKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRowKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rowKey, other.rowKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGroups()).compareTo(other.isSetGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groups, other.groups);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Row(");
    boolean first = true;

    sb.append("table:");
    if (this.table == null) {
      sb.append("null");
    } else {
      sb.append(this.table);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rowKey:");
    if (this.rowKey == null) {
      sb.append("null");
    } else {
      sb.append(this.rowKey);
    }
    first = false;
    if (isSetGroups()) {
      if (!first) sb.append(", ");
      sb.append("groups:");
      if (this.groups == null) {
        sb.append("null");
      } else {
        sb.append(this.groups);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (table == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'table' was not present! Struct: " + toString());
    }
    if (rowKey == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'rowKey' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RowStandardSchemeFactory implements SchemeFactory {
    public RowStandardScheme getScheme() {
      return new RowStandardScheme();
    }
  }

  private static class RowStandardScheme extends StandardScheme<Row> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Row struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.table = iprot.readString();
              struct.setTableIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ROW_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.rowKey = iprot.readString();
              struct.setRowKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.groups = new HashMap<String,Map<Long,Map<String,String>>>(2*_map0.size);
                for (int _i1 = 0; _i1 < _map0.size; ++_i1)
                {
                  String _key2;
                  Map<Long,Map<String,String>> _val3;
                  _key2 = iprot.readString();
                  {
                    org.apache.thrift.protocol.TMap _map4 = iprot.readMapBegin();
                    _val3 = new HashMap<Long,Map<String,String>>(2*_map4.size);
                    for (int _i5 = 0; _i5 < _map4.size; ++_i5)
                    {
                      long _key6;
                      Map<String,String> _val7;
                      _key6 = iprot.readI64();
                      {
                        org.apache.thrift.protocol.TMap _map8 = iprot.readMapBegin();
                        _val7 = new HashMap<String,String>(2*_map8.size);
                        for (int _i9 = 0; _i9 < _map8.size; ++_i9)
                        {
                          String _key10;
                          String _val11;
                          _key10 = iprot.readString();
                          _val11 = iprot.readString();
                          _val7.put(_key10, _val11);
                        }
                        iprot.readMapEnd();
                      }
                      _val3.put(_key6, _val7);
                    }
                    iprot.readMapEnd();
                  }
                  struct.groups.put(_key2, _val3);
                }
                iprot.readMapEnd();
              }
              struct.setGroupsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Row struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.table != null) {
        oprot.writeFieldBegin(TABLE_FIELD_DESC);
        oprot.writeString(struct.table);
        oprot.writeFieldEnd();
      }
      if (struct.rowKey != null) {
        oprot.writeFieldBegin(ROW_KEY_FIELD_DESC);
        oprot.writeString(struct.rowKey);
        oprot.writeFieldEnd();
      }
      if (struct.groups != null) {
        if (struct.isSetGroups()) {
          oprot.writeFieldBegin(GROUPS_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, struct.groups.size()));
            for (Map.Entry<String, Map<Long,Map<String,String>>> _iter12 : struct.groups.entrySet())
            {
              oprot.writeString(_iter12.getKey());
              {
                oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.MAP, _iter12.getValue().size()));
                for (Map.Entry<Long, Map<String,String>> _iter13 : _iter12.getValue().entrySet())
                {
                  oprot.writeI64(_iter13.getKey());
                  {
                    oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, _iter13.getValue().size()));
                    for (Map.Entry<String, String> _iter14 : _iter13.getValue().entrySet())
                    {
                      oprot.writeString(_iter14.getKey());
                      oprot.writeString(_iter14.getValue());
                    }
                    oprot.writeMapEnd();
                  }
                }
                oprot.writeMapEnd();
              }
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RowTupleSchemeFactory implements SchemeFactory {
    public RowTupleScheme getScheme() {
      return new RowTupleScheme();
    }
  }

  private static class RowTupleScheme extends TupleScheme<Row> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Row struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.table);
      oprot.writeString(struct.rowKey);
      BitSet optionals = new BitSet();
      if (struct.isSetGroups()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetGroups()) {
        {
          oprot.writeI32(struct.groups.size());
          for (Map.Entry<String, Map<Long,Map<String,String>>> _iter15 : struct.groups.entrySet())
          {
            oprot.writeString(_iter15.getKey());
            {
              oprot.writeI32(_iter15.getValue().size());
              for (Map.Entry<Long, Map<String,String>> _iter16 : _iter15.getValue().entrySet())
              {
                oprot.writeI64(_iter16.getKey());
                {
                  oprot.writeI32(_iter16.getValue().size());
                  for (Map.Entry<String, String> _iter17 : _iter16.getValue().entrySet())
                  {
                    oprot.writeString(_iter17.getKey());
                    oprot.writeString(_iter17.getValue());
                  }
                }
              }
            }
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Row struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.table = iprot.readString();
      struct.setTableIsSet(true);
      struct.rowKey = iprot.readString();
      struct.setRowKeyIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map18 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, iprot.readI32());
          struct.groups = new HashMap<String,Map<Long,Map<String,String>>>(2*_map18.size);
          for (int _i19 = 0; _i19 < _map18.size; ++_i19)
          {
            String _key20;
            Map<Long,Map<String,String>> _val21;
            _key20 = iprot.readString();
            {
              org.apache.thrift.protocol.TMap _map22 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.MAP, iprot.readI32());
              _val21 = new HashMap<Long,Map<String,String>>(2*_map22.size);
              for (int _i23 = 0; _i23 < _map22.size; ++_i23)
              {
                long _key24;
                Map<String,String> _val25;
                _key24 = iprot.readI64();
                {
                  org.apache.thrift.protocol.TMap _map26 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
                  _val25 = new HashMap<String,String>(2*_map26.size);
                  for (int _i27 = 0; _i27 < _map26.size; ++_i27)
                  {
                    String _key28;
                    String _val29;
                    _key28 = iprot.readString();
                    _val29 = iprot.readString();
                    _val25.put(_key28, _val29);
                  }
                }
                _val21.put(_key24, _val25);
              }
            }
            struct.groups.put(_key20, _val21);
          }
        }
        struct.setGroupsIsSet(true);
      }
    }
  }

}

