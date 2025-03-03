from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.common.exceptions import NoSuchElementException
from bs4 import BeautifulSoup
from tkinter import *
from tkinter import ttk
from tkinter import messagebox
import json
import requests
import time

'''
@Rafael Xavier
- This programm is a mix of a lot of things that were used and studied before, it's a bot that goes to the IMO-WELT 
website, searches for rents based on the user's choices using the website filters, clicks on all the offers, saves it's 
infos in a list with BeautifulSoup4 and applies for it using the user's data that were previously given. In case there 
is only a  button that redirects the user in the offer's page, the offer recieves the tag of "not applied" and goes back.
- At the end of each page of offers the program goes to the next one, so it (should) continue until there are no offers
anymore in the website. 
- The user writes his data on the form of the GUI and saves them by pressing "sign in", all the data is saved in a extern 
.json file. 
- They can login by only typing their email and password correctly and pressing run the bot starts to work.
- At the end, the programm takes all the infos of the rent offers saved and create an Excell table with all of them.
password correctly.

 !!! IT CAN HAPPEN, THE PROGRAMM STOPS WORKING BECAUSE OF THE WEBSITES'S STRUCTURE. It's common that a website (specially
 one that is big like Immowelt) make changes in their HTML structure, and as this is a simple programm based on HTML, the
 selenium wont be able to find elements, if the path to them isn't perfectly given !!!
'''

# Wir fügen zunächst die gewünschten Einstellungen für Chrome hinzu
chrome_options = webdriver.ChromeOptions()
chrome_options.add_experimental_option("detach", True)
chrome_options.add_argument("start-maximized")
chrome_options.add_argument("--disable-notifications")
chrome_options.add_argument("--disable-infobars")
chrome_options.add_argument("--disable-extensions")

#Daten, die für die Datenbank verwendet werden sollen


def noNulls(dict):
    if dict["MIN_PRICE"] == "0":
        dict["MIN_PRICE"] = ""
    if dict["MAX_PRICE"] == "0":
        dict["MAX_PRICE"] = ""
    if dict["MIN_ZIMMER"] == "0":
        dict["MIN_ZIMMER"] = ""
    if dict["MAX_ZIMMER"] == "0":
        dict["MAX_ZIMMER"] = ""
    return dict


# Hier erstellen wir unseren „Webbrowser“, der in der Lage sein wird, auf der gewählten Website zu navigieren und mit Elementen und Objekten zu interagieren


def finding_wohnung(dics):
    prices = []
    areas = []
    rooms = []
    available = []
    addresses = []
    links = []
    offerers = []
    applied = []

    data_dict = noNulls(dics)
    driver = webdriver.Chrome(options=chrome_options)
    driver.get(
        "https://signin.immowelt.de/u/login?state=hKFo2SBaMlU2X29WbGJRUm9QVEU0d19mVWZ3OVJndnRNUmRvUKFur3VuaXZlcnNhbC1sb2dpbqN0aWTZIEY5SHhVZlJGUF9pOFpkTThwNFBZNFpaYXFlV0NMNVdSo2NpZNkgQ2tBbG1wTmlqTlZ4U0RpNEpYOFNoQTNSZHV2SU1RVmc")
    actions = ActionChains(driver)
    time.sleep(2)

    #Dictionaries mit vom Benutzer ausgewählten Daten

    RANGE = 1

    def get_shadow_root(element):
        return driver.execute_script('return arguments[0].shadowRoot', element)

    def fill_form(data_dict):
        driver.find_element(By.XPATH, '//*[@id="salutation"]').click()
        driver.find_element(By.CSS_SELECTOR, f'sd-menu div ul sd-dropdown-item[text="{data_dict["GENDER"]}"]').click()
        driver.find_element(By.XPATH, '//*[@id="firstname"]').send_keys(data_dict["FIRST_NAME"], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="lastname"]').send_keys(data_dict["LAST_NAME"], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="email"]').send_keys(data_dict["EMAIL"], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="tel"]').send_keys(data_dict["TELEPHONE"], Keys.TAB)
        try:
            driver.find_element(By.XPATH, '//*[@id="street"]').send_keys(data_dict["Strasse & Nr."], Keys.TAB)
            driver.find_element(By.XPATH, '//*[@id="zipcode"]').send_keys(data_dict["PLZ"], Keys.TAB)
            driver.find_element(By.XPATH, '//*[@id="city"]').send_keys(data_dict["ORT"])
        except NoSuchElementException:
            pass
        finally:
            if data_dict["MESSAGE"] != "":
                msg = driver.find_element(By.XPATH, '//*[@id="message"]')
                actions.move_to_element(msg).perform()
                msg.send_keys(data_dict["MESSAGE"], Keys.TAB)
        submit = driver.find_element(By.XPATH, '//*[@id="btnSubmitCR"]/button')
        actions.move_to_element(submit).perform()
        submit.click()

        #Hier schließen wir die Browser-Registerkarte
        driver.forward()

    def filter_config():
        driver.find_element(By.XPATH,
                            value='//*[@id="refiner-form-id"]/div/div[2]/div[5]/button').click() #find the filter
        time.sleep(2)

        driver.find_element(By.XPATH, value='/html/body/div[4]/div[2]/div/div[2]/div/div[2]/button/div/span[2]').click() #click to the location page
        time.sleep(2)
        driver.find_element(By.XPATH, value='/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/button').click() #click to close the current locatoion
        time.sleep(2)
        driver.find_element(By.XPATH, value='/html/body').click() #type the users location
        driver.find_element(By.XPATH, value='/html/body/div[6]/div[2]/div/div[2]/div/div/div/div/input').send_keys(data_dict['ORT'])
        time.sleep(2)
        driver.find_element(By.XPATH, value='/html/body/div[7]/div[1]/ul/li[1]').click() #select the first one
        time.sleep(1)
        driver.find_element(By.XPATH, value='/html/body/div[6]/div[2]/div/div[3]/button').click() # go back to the searching area
        time.sleep(1)
        driver.find_element(By.XPATH, value='//p[text()="Kaltmiete"]').click()
        time.sleep(2)
        driver.find_element(By.XPATH, value='//*[@id="react-aria8910212303-:r1j:"]').send_keys(data_dict['MIN_PRICE'])
        driver.find_element(By.XPATH, value='//*[@id="react-aria8910212303-:r1o:"]').send_keys(data_dict['MAX_PRICE'])
        driver.find_element(By.XPATH, value=f'/html/body/div[5]/div[2]/div/div[2]/div/div[7]/div[2]/div[1]/div/button').click()
        driver.find_element(By.XPATH, value=f'/html/body/div[7]/div[2]/ul/li[{data_dict['MIN_ZIMMER']}]/div[1]').click()
        driver.find_element(By.XPATH, value=f'/html/body/div[5]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/div/button').click()
        driver.find_element(By.XPATH, value=f'/html/body/div[7]/div[2]/ul/li[{data_dict['MAX_ZIMMER']}]/div[1]').click()
        driver.find_element(By.XPATH, value='/html/body/div[7]/div/div/footer/button[2]').click()

        driver.find_element(By.CSS_SELECTOR, value='/html/body/div[5]/div[2]/div/div[3]/button').click()

    #hier verlagern wir den Schwerpunkt von Selenium auf die neue Registerkarte
    def change_focus():
        all_windows = driver.window_handles
        for w in all_windows:
            if w != main_w:
                driver.switch_to.window(w)

    #anmeldung
    time.sleep(2)
    shadow_host = driver.find_element(By.ID, 'usercentrics-root')
    button = get_shadow_root(shadow_host).find_element(By.CSS_SELECTOR, '[data-testid=uc-accept-all-button]').click()

    #E-mail einfügen
    driver.find_element(By.ID, value="username").send_keys(data_dict['EMAIL'])

    #Passwort einfügen
    driver.find_element(By.ID, value="password").send_keys(data_dict['PASS'])
    driver.find_element(By.XPATH,
                        value='/html/body/div[1]/div[1]/div/main/section/div/div/div/form/div[2]/button').click()

    #zur mieten homepage gehen
    driver.get(
        f"https://www.immowelt.de/classified-search?distributionTypes=Rent&estateTypes=House,Apartment&locations=AD08DE8634&order=Default&m=homepage_new_search_classified_search_result")
    main_w = driver.current_window_handle

    time.sleep(1)
    #Put all user's configs in the filter
    filter_config()
    time.sleep(2)

    for card in range(RANGE):
        angebots = driver.find_elements(By.XPATH, '//div[@class="EstateItem-4409d"]/a')
        for angebot in angebots:
            driver.switch_to.window(main_w)
            actions.move_to_element(angebot).perform()
            link = angebot.get_attribute("href")
            angebot.click()
            time.sleep(2)

            #Dateien Scraping
            response = requests.get(link).text
            soup = BeautifulSoup(response, 'html.parser')
            price = soup.select_one(selector="div[class='has-font-300'] strong").getText().replace("\xa0", "")
            others = [i.getText() for i in soup.select(selector="div span[class='has-font-300']")]
            anbieter = soup.find(name="p", class_="offerer").getText()
            street = soup.select_one(selector="sd-cell-col span[data-cy='address-street']").getText()
            mores = soup.select(selector="sd-cell-col span[data-cy='address-city'] div")
            address = street + " "
            for i in mores:
                address += i.getText().replace("\xa0", "")

            # Hinzufügen aller Daten zu unseren Wörterbüchern
            try:
                prices.append(price)
                areas.append(others[0])
                rooms.append(others[1])
                addresses.append(address)
                links.append(link)
                offerers.append(anbieter)
                available.append(others[2])
            except IndexError:
                available.append("indeterminate")
                pass
            time.sleep(1)
            change_focus()
            # wir prüfen, ob die Schaltfläche auf der Seite für die Registrierung auf der Website ist, und wenn ja, rufen wir die
            # Funktion „fill_form“ auf, um das Formular auszufüllen.
            button = driver.find_element(By.XPATH, value='//*[@id="btnContactBroker"]/button/span')
            if button.text == 'Anbieter kontaktieren':
                driver.find_element(By.XPATH, value='//*[@id="btnContactBroker"]/button').click()
                time.sleep(2)
                fill_form(data_dict)
                time.sleep(3)
                driver.close()
                applied.append("ja")
            else:
                applied.append("nein")
                driver.close()
            time.sleep(2)
            print(prices, areas, rooms, addresses, offerers, links, available)

        driver.switch_to.window(main_w)
        actions.move_to_element(
            driver.find_element(By.XPATH, '/html/body/div[1]/main/div[1]/div[1]/div/div[6]')).perform()

        if card == 1:
            driver.find_element(By.XPATH,
                                value=f'/html/body/div[1]/main/div[1]/div[1]/div/div[6]/div/button[{str(card + 2)}]').click()
            time.sleep(3)

        if card < 4 and card > 1:
            driver.find_element(By.XPATH,
                                value=f'/html/body/div[1]/main/div[1]/div[1]/div/div[6]/div/button[{str(card + 1)}]').click()
            time.sleep(3)
        else:
            driver.find_element(By.XPATH, '/html/body/div[1]/main/div[1]/div[1]/div/div[6]/div/button[5]').click()
            time.sleep(3)


    FORMS_LINK = "https://docs.google.com/forms/d/e/1FAIpQLSeeX66DvPLwCYiX1pIMfSQHjVIX1GCLSVSyCxDevfXgf17H6A/viewform?usp=sf_link"
    for i in range(len(prices)):
        driver.get(FORMS_LINK)
        time.sleep(2)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(addresses[i], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(
            prices[i], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(
            areas[i], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(
            rooms[i], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(
            available[i], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(
            offerers[i], Keys.TAB)
        try:
            driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys(applied[i], Keys.TAB)
        except IndexError:
            driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div/div[1]/input').send_keys("", Keys.TAB)

        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div[1]/div[2]/textarea').send_keys(links[i], Keys.TAB)
        driver.find_element(By.XPATH, '//*[@id="mG61Hd"]/div[2]/div/div[3]/div[1]/div[1]/div').click()

    driver.close()

#Diese Methode startet alle den Bot
def RUN():
    email = email_entry.get()
    if len(email) == 0:
        messagebox.showinfo(message="Please, make sure that you have inserted the email", title="error")
    else:
        password = password_entry.get()
        with open("data.json") as data_file:
            data = json.load(data_file)
        if email == data[email]["EMAIL"] and password != data[email]["PASS"]:
            messagebox.showinfo(title="Error", message=f"No details for this account.")
        else:
            finding_wohnung(data[email])


def clean_camps():
    email_entry.delete(0, END)
    password_entry.delete(0, END)
    gender_entry.set("")
    vorname_entry.delete(0, END)
    nachname_entry.delete(0, END)
    tel_entry.delete(0, END)
    ort_entry.delete(0, END)
    gesucht_ort_entry.delete(0, END)
    Strasse_Nmr_entry.delete(0, END)
    PLZ_entry.delete(0, END)
    message_entry.delete("1.0", 'end-1c')
    min_price_entry.delete(0, END)
    max_price_entry.delete(0, END)
    min_rooms_entry.delete(0, END)
    max_rooms_entry.delete(0, END)


#Diese Methode Speichert alle die Informationen, die im Formular eingegeben werden und herstellt ein neues .json Datei
def save():
    email = email_entry.get()
    password = password_entry.get()
    gender = gender_entry.get()
    vorname = vorname_entry.get()
    nachname = nachname_entry.get()
    telefon = tel_entry.get()
    ORT = ort_entry.get()
    strasse = Strasse_Nmr_entry.get()
    PLZ = PLZ_entry.get()
    message = message_entry.get("1.0", 'end-1c')
    ort = gesucht_ort_entry.get()
    min_p = min_price_entry.get()
    max_p = max_price_entry.get()
    min_z = min_rooms_entry.get()
    max_z = max_rooms_entry.get()

    name = email

    wohnungs_options = {
        "GESUCHT ORT": ort,
        "MIN_PRICE": min_p,
        "MAX_PRICE": max_p,
        "MIN_ZIMMER": min_z,
        "MAX_ZIMMER": max_z,
    }

    data = {
        "EMAIL": email,
        "PASS": password,
        "GENDER": gender,
        "FIRST_NAME": vorname,
        "LAST_NAME": nachname,
        "TELEPHONE": telefon,
        "ORT": ORT,
        "Strasse & Nr.": strasse,
        "PLZ": PLZ,
        "ort": ort,
    }

    new_data = {
        name: {
            "EMAIL": email,
            "PASS": password,
            "GENDER": gender,
            "FIRST_NAME": vorname,
            "LAST_NAME": nachname,
            "TELEPHONE": telefon,
            "ORT": ORT,
            "Strasse & Nr.": strasse,
            "PLZ": PLZ,
            "MESSAGE": message,
            "GESUCHT ORT": ort,
            "MIN_PRICE": min_p,
            "MAX_PRICE": max_p,
            "MIN_ZIMMER": min_z,
            "MAX_ZIMMER": max_z,
        }
    }

    for i in wohnungs_options:
        if wohnungs_options[i] == "0":
            wohnungs_options[i] = ""

    nbr = 0
    for item in data:
        if len(data[item]) == 0:
            nbr += 1

    if nbr > 0:
        messagebox.showinfo(message="Please, make sure that you have inserted all the camps", title="error")

    else:
        try:
            with open("data.json", "r") as data_file:
                #Reading old data
                data = json.load(data_file)
        except FileNotFoundError:

            with open("data.json", "w") as data_file:
                json.dump(new_data, data_file, indent=4)
        else:
            #Updating old data with new data
            data.update(new_data)
            with open("data.json", "w") as data_file:
                #Saving updated data
                json.dump(data, data_file, indent=4)
        finally:
            clean_camps()


#Diese Methode checks, ob die Login informationen richtig sind, und ob alle die Data-entries ausgefüllt sind.
def find_user():
    email = email_entry.get()
    password = password_entry.get()
    if password == "":
        messagebox.showinfo(title="error", message="insert your password first")
    else:
        try:
            with open("data.json") as data_file:
                data = json.load(data_file)
        except FileNotFoundError:
            messagebox.showinfo(title="Error", message="No Data File Found.")
        else:
            clean_camps()
            try:
                if email in data:
                    if email == data[email]["EMAIL"] and password == data[email]["PASS"]:
                        email_entry.insert("end", data[email]["EMAIL"])
                        password_entry.insert("end", data[email]["PASS"])
                        gender_entry.set(data[email]["GENDER"])
                        vorname_entry.insert("end", data[email]["FIRST_NAME"])
                        nachname_entry.insert("end", data[email]["LAST_NAME"])
                        tel_entry.insert("end", data[email]["TELEPHONE"])
                        ort_entry.insert("end", data[email]["ORT"])
                        Strasse_Nmr_entry.insert("end", data[email]["Strasse & Nr."])
                        PLZ_entry.insert("end", data[email]["PLZ"])
                        message_entry.insert("1.0", data[email]["MESSAGE"])
                        gesucht_ort_entry.insert("end", data[email]["GESUCHT ORT"])
                        min_price_entry.insert("end", data[email]["MIN_PRICE"])
                        max_price_entry.insert("end", data[email]["MAX_PRICE"])
                        min_rooms_entry.insert("end", data[email]["MIN_ZIMMER"])
                        max_rooms_entry.insert("end", data[email]["MAX_ZIMMER"])

                        #Wenn alle die data entries ausgefüllt sind, Der 'run' button wird verfügbar
                        start = Button(content_frame, text="RUN", command=RUN, width=50)
                        start.grid(row=26, column=1, columnspan=1)
                        content_frame.update_idletasks()
                        canvas.config(scrollregion=canvas.bbox("all"))
                    else:
                        messagebox.showinfo(title="Error", message=f"No details for this account.")
            except KeyError:
                messagebox.showinfo(title="Error", message=f"No details for this account.")

#GUI -------------------------------------------------------------------------------------

#windowScrollbar
window = Tk()
window.title("Rent Finder")
window.config(padx=50, pady=50, width=400, height=1000)
window.resizable(False, True)# only resizable to to the vertical

main_frame = Frame(window)
main_frame.pack(fill=BOTH, expand=1)

# Canvas to suport the scrollable content
canvas = Canvas(main_frame, width=700, height=1000)
canvas.pack(side=LEFT, fill=BOTH, expand=1)

# Vertical Scrollbar
scrollbar = Scrollbar(main_frame, orient=VERTICAL, command=canvas.yview)
scrollbar.pack(side=RIGHT, fill=Y)

# Canvas of the scrollbar config
canvas.configure(yscrollcommand=scrollbar.set)
canvas.bind('<Configure>', lambda e: canvas.configure(scrollregion=canvas.bbox("all")))

# intern frame
content_frame = Frame(canvas)
canvas.create_window((0, 0), window=content_frame, anchor="nw")

#Logo
logo_img = PhotoImage(file="rentfinder logo.png")
canvas_logo = Canvas(content_frame, height=300, width=300)
canvas_logo.create_image(150, 150, image=logo_img)
canvas_logo.grid(row=0, column=1)

#space
Label(content_frame).grid(row=1, column=0, columnspan=2)

#Loggin credentials
Label(content_frame, text="Email/Username:").grid(row=2, column=0)
email_entry = Entry(content_frame, width=35,)
email_entry.grid(row=2, column=1)
email_entry.insert(0, "xevprogrammer@gmail.com")

Label(content_frame, text="Password:").grid(row=3, column=0)
password_entry = Entry(content_frame, width=35, show="*")
password_entry.grid(row=3, column=1)
password_entry.insert(0, "B3d5BC1a!")

#space
Label(content_frame).grid(row=4, column=1, columnspan=1)

#Gender
Label(content_frame, text="Gender:").grid(row=5, column=0)
gender_entry = ttk.Combobox(content_frame, width=34)
gender_entry['values'] = ('Herr', 'Frau', 'Divers')
gender_entry.state(['readonly'])
gender_entry.grid(row=5, column=1)

space3 = Label(content_frame)
space3.grid(row=6, column=0)

#vorname/nachname
Label(content_frame, text="Vorname").grid(row=7, column=0)
vorname_entry = Entry(content_frame, width=35)
vorname_entry.grid(row=7, column=1, columnspan=1)

Label(content_frame, text="Nachname:").grid(row=8, column=0)
nachname_entry = Entry(content_frame, width=35)
nachname_entry.grid(row=8, column=1, columnspan=1)

#telefon
Label(content_frame, text="Telephone:").grid(row=9, column=0)
tel_entry = Entry(content_frame, width=35)
tel_entry.grid(row=9, column=1, columnspan=1)

#Straße
Label(content_frame,text="Straße & Nmr:").grid(row=10, column=0)
Strasse_Nmr_entry = Entry(content_frame, width=35)
Strasse_Nmr_entry.grid(row=10, column=1, columnspan=1)

#PLZ
Label(content_frame, text="PLZ:").grid(row=11, column=0)
PLZ_entry = Entry(content_frame, width=35)
PLZ_entry.grid(row=11, column=1, columnspan=1)

#Ort
Label(content_frame, text="Ort:").grid(row=12, column=0)
ort_entry = Entry(content_frame, width=35)
ort_entry.grid(row=12, column=1, columnspan=1)

Label(content_frame).grid(row=13, column=0)

#Vorstellung zum Anbieter
Label(content_frame, text="Message:").grid(row=14, column=0)
message_entry = Text(content_frame, height=5, width=60)
message_entry.grid(row=14, column=1, columnspan=1)

space5 = Label(content_frame)
space5.grid(row=15, column=0)

#Gesucht Ort
Label(content_frame, text="Gesucht Ort:").grid(row=16, column=0)
gesucht_ort_entry = Entry(content_frame, width=35)
gesucht_ort_entry.grid(row=16, column=1, columnspan=1)

Label(content_frame, text="Prices -- ").grid(row=17, column=0)

#min preis
Label(content_frame, text="Min:").grid(row=18, column=0)
min_price_entry = Entry(content_frame, width=35)
min_price_entry.grid(row=18, column=1)

#max preis
Label(content_frame, text="Max:").grid(row=19, column=0)
max_price_entry = Entry(content_frame, width=35)
max_price_entry.grid(row=19, column=1)

Label(content_frame, text="Rooms -- ").grid(row=20, column=0)

Label(content_frame, text="Min:").grid(row=21, column=0)

#min anzahl von Zimmern
min_rooms_entry = Entry(content_frame, width=35)
min_rooms_entry.grid(row=21, column=1, columnspan=1)

Label(content_frame, text="Max:").grid(row=22, column=0)

#Max anzahl von Zimmern
max_rooms_entry = Entry(content_frame, width=35)
max_rooms_entry.grid(row=22, column=1, columnspan=1)

Label(content_frame).grid(row=23, column=1, columnspan=1)

#Sign in button
signin = Button(content_frame, text="sign in", command=save, width=50)
signin.grid(row=24, column=1)

#Log in button
login = Button(content_frame, text="login", command=find_user, width=50)
login.grid(row=25, column=1)

content_frame.update_idletasks()
canvas.config(scrollregion=canvas.bbox("all"))

window.mainloop()
