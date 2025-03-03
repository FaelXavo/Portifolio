'''
After collecting all the apartment's information with bf4, the programm stores all of them in lists and after applying
for all the offers (in a given range) it goes to a Google-forms website and fills all entries, so the user can access the
price, area, number of rooms, address, link and other information of each page visited (when it wasn't possible to save
apply for an offer, the offer is marked as "not applied" in the table.

!! (some offers didnt have an apply button, but a
button that redirects the user to another webpage with different structure etc., so the programm just saves the information
of these kind of offers and look for the next one.)

'''

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import time

chrome_options = webdriver.ChromeOptions()
chrome_options.add_experimental_option("detach", True)
chrome_options.add_argument("start-maximized")
chrome_options.add_argument("--disable-notifications")
chrome_options.add_argument("--disable-infobars")
chrome_options.add_argument("--disable-extensions")

prices = ["500"]
areas = ["40m²"]
rooms = ["1"]
available = ["20.08.2024"]
addresses = ["Examples 74"]
links = ["https://www.youtube.com/watch?v=eFtc_ylldYI"]
offerers = ["Baco"]
applied = ["ja"]

FORMS_LINK = "https://docs.google.com/forms/d/e/1FAIpQLSeeX66DvPLwCYiX1pIMfSQHjVIX1GCLSVSyCxDevfXgf17H6A/viewform?usp=sf_link"
driver = webdriver.Chrome(options=chrome_options)
driver.get(FORMS_LINK)
time.sleep(2)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(addresses[0], Keys.TAB)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(prices[0], Keys.TAB)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(areas[0], Keys.TAB)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(rooms[0], Keys.TAB)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(available[0], Keys.TAB)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(offerers[0], Keys.TAB)
driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(applied[0], Keys.TAB)
driver.find_element(By.XPATH,
                    '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div[1]/div[2]/textarea').send_keys(
    links[0], Keys.TAB)

driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[3]/div[1]/div[1]/div').click()


