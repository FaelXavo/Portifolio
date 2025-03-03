from tkinter import *
from tkinter import ttk
from tkinter import messagebox
import json
import pyperclip
'''
This was the first GUI that I developed for this project using tkinter. Later I saw the need of creating a scroll bar, so 
I updated the structure of the GUI. 
'''
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
            print("ok")

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
    message = message_entry.get("1.0",'end-1c')
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

    user_info = {
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
                json.dump(new_data, data_file, indent= 4)
        else:
            #Updating old data with new data
            data.update(new_data)
            with open("data.json", "w") as data_file:
                #Saving updated data
                json.dump(data, data_file, indent=4)
        finally:
            clean_camps()

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
                start = Button(text="RUN", command=RUN, width=50)
                start.grid(row=26, column=1, columnspan=1)
            else:
                messagebox.showinfo(title="Error", message=f"No details for this account.")


window = Tk()
window.title("Rent Finder")
window.config(padx=50, pady=50, width=400, height=1000)
#Logo
canvas = Canvas(height=300, width=300)
logo_img = PhotoImage(file="rentfinder logo.png")
canvas.create_image(150, 150,image=logo_img)
canvas.grid(row=0, column=1, columnspan=1)

#space
space1 = Label()
space1.grid(row=1, column=0, columnspan=2)

#Loggin credentials
email_label = Label(text="Email/Username:")
email_label.grid(row=2, column=0)
password_label = Label(text="Password:")
password_label.grid(row=3, column=0)

email_entry = Entry(width=35)
email_entry.grid(row=2, column=1, columnspan=1)
email_entry.insert(0, "")
password_entry = Entry(width=35, show="*")
password_entry.grid(row=3, column=1)

#space
space2 = Label()
space2.grid(row=4, column=1, columnspan=1)

#Gender
gender_label = Label(text="Gender:")
gender_label.grid(row=5, column=0)
gender_entry = ttk.Combobox(width=34)

gender_entry.bind('<<ComboboxSelected>>')
gender_entry['values'] = ('Herr', 'Frau', 'Divers')
gender_entry.state(['readonly'])
gender_entry.grid(row=5, column=1)

space3 = Label()
space3.grid(row=6, column=0)
#vorname/nachname
vorname_label = Label(text="Vorname:")
vorname_label.grid(row=7, column=0)
vorname_entry = Entry(width=35)
vorname_entry.grid(row=7, column=1, columnspan=1)
nachname_label = Label(text="Nachname:")
nachname_label.grid(row=8, column=0)
nachname_entry = Entry(width=35)
nachname_entry.grid(row=8, column=1, columnspan=1)

#telefon
tel_label = Label(text="Telephone:")
tel_label.grid(row=9, column=0)
tel_entry = Entry(width=35)
tel_entry.grid(row=9, column=1, columnspan=1)

#Straße
Strasse_Nmr_label = Label(text="Straße & Nmr:")
Strasse_Nmr_label.grid(row=10, column=0)
Strasse_Nmr_entry = Entry(width=35)
Strasse_Nmr_entry.grid(row=10, column=1, columnspan=1)

PLZ_label = Label(text="PLZ:")
PLZ_label.grid(row=11, column=0)
PLZ_entry = Entry(width=35)
PLZ_entry.grid(row=11, column=1, columnspan=1)

ort_label = Label(text="Ort:")
ort_label.grid(row=12, column=0)
ort_entry = Entry(width=35)
ort_entry.grid(row=12, column=1, columnspan=1)

space4 = Label()
space4.grid(row=13, column=0)

message_label = Label(text="Message:")
message_label.grid(row=14, column=0)
message_entry = Text(height=5, width=60)
message_entry.grid(row=14, column=1, columnspan=1)

space5 = Label()
space5.grid(row=15, column=0)


gesucht_ort_label = Label(text="Gesucht Ort:")
gesucht_ort_label.grid(row=16, column=0)
gesucht_ort_entry = Entry(width=35)
gesucht_ort_entry.grid(row=16, column=1, columnspan=1)

price_label = Label(text="Prices -- ")
price_label.grid(row=17, column=0)
min_price_label = Label(text="Min:")
min_price_label.grid(row=18, column=0)

min_price_entry = Entry(width=35)
min_price_entry.grid(row=18, column=1)

max_price_label = Label(text="Max:")
max_price_label.grid(row=19, column=0)

max_price_entry = Entry(width=35)
max_price_entry.grid(row=19, column=1)

rooms_label = Label(text="Rooms -- ")
rooms_label.grid(row=20, column=0)

min_rooms_label = Label(text="Min:")
min_rooms_label.grid(row=21, column=0)

min_rooms_entry = Entry(width=35)
min_rooms_entry.grid(row=21, column=1, columnspan=1)

max_rooms_label = Label(text="Max:")
max_rooms_label.grid(row=22, column=0)
max_rooms_entry = Entry(width=35)
max_rooms_entry.grid(row=22, column=1, columnspan=1)

space6 = Label()
space6.grid(row=23, column=1, columnspan=1)

signin = Button(text="sign in", command=save, width=50)
signin.grid(row=24, column=1, columnspan=1)
login = Button(text="login", command=find_user, width=50)
login.grid(row=25, column=1, columnspan=1)


window.mainloop()
