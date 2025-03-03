'''
This file was only created to test the BeautifulSoup4 library used in the main file to store the information of the apar-
tment's page that was being visited.
'''

from bs4 import BeautifulSoup
import requests

response = requests.get("https://www.immowelt.de/expose/2es795n")
web_page = response.text

soup = BeautifulSoup(web_page, "html.parser")

area = []
rooms = []
available = []
prices = soup.select_one(selector="div[class='has-font-300'] strong").getText()
outhers = [i.getText() for i in soup.select(selector="div span[class='has-font-300']")]
area.append(outhers[0])
rooms.append(outhers[1])
available.append(outhers[2])

anbieter = soup.find(name="p", class_="offerer").getText()
print(anbieter)

print(prices, area, rooms, available)
street = soup.select_one(selector="sd-cell-col span[class='has-font-100']").getText()
mores = soup.select(selector="sd-cell-col span div")

address = street
for i in mores:
    address += i.getText()
    print(address)

