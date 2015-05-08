from time import sleep
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

# WORKING WITH CHROME
import os
chromedriver = "c:/tmp/chromedriver.exe"
os.environ["webdriver.chrome.driver"] = chromedriver
driver = webdriver.Chrome(chromedriver)
driver.get("http://10.1.64.20:8080/looqs-web/looqs.html")


# driver = webdriver.Firefox()
# driver.get("http://10.1.64.20:8080/looqs-web/looqs.html")

# landing page
elem = driver.find_element_by_class_name("DEMOLANDINGPAGELOGO")
elem.click()
sleep(7)

# sitez
def login_sites():
    global elem
    elem = driver.find_element_by_id("LOCALROOTPANEL")  # test / not needed
    elem = driver.find_element_by_xpath("//input[@class='LOGINGWT-TEXTBOX LOGINGWT-TEXTBOX-USER']")
    elem.send_keys("EUGENE.CHUNG")
    elem = driver.find_element_by_xpath("//input[@class='LOGINGWT-TEXTBOX LOGINGWT-TEXTBOX-PASSWORD']")
    elem.send_keys("PIZZA")
    elem.send_keys(Keys.RETURN)
    sleep(3)


login_sites()

# go to pagez
driver.find_element_by_xpath("//div[@class='TOGGLETRG APPS_TRIGGER']").click()

# test 1
def goto(screen):
    elem = driver.find_element_by_xpath("//input[@class='SEARCHWTG-ENTRYFIELD SEARCHWTG-ENTRYFIELD-PAGEZ_SEARCH']")
    elem.send_keys("GO " + screen)
    elem.send_keys(Keys.RETURN)
    sleep(2)

# goto("SCREENS")
goto("SPECIFICS")

elem = driver.find_element_by_xpath("//input[@class='SEARCHWTG-ENTRYFIELD SEARCHWTG-ENTRYFIELD-PAGEZ_SEARCH']")
elem.clear()



# elem = driver.find_element_by_xpath("//input[@class='GRIDHEADERFILTERTEXTFIELD']")
elems = driver.find_elements_by_xpath("//input[@class='GRIDHEADERFILTERTEXTFIELD']")
elems[1].send_keys("TEST")
elems[1].send_keys(Keys.RETURN)


driver.find_element_by_xpath("//button[@class='VZGRIDFILTERBUTTONON']").click()
