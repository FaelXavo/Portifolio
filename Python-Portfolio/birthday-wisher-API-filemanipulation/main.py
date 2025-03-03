import smtplib
import random
import pandas
import datetime as dt

gmail = "xevprogrammer@gmail.com"
password = "cevx sprd pbjy zwmc"
master_password = "4E#+AtFq6CswNQ"

now = dt.datetime.now()
month = now.month
day = now.day
today_tuple = (month, day)

data = pandas.read_csv("birthdays.csv")

birthday_dict = {(data_row["month"], data_row["day"]): data_row for (index, data_row) in data.iterrows()}


if today_tuple in birthday_dict:
    birthday_person = birthday_dict[today_tuple]
    file_path = f"letter_templates/letter_{random.randint(1,3)}.txt"
    with open(file_path) as letter_file:
        contents = letter_file.read()
        new_contents = contents.replace("[NAME]", birthday_person["name"])

    with smtplib.SMTP("smtp.gmail.com") as connection:
        connection.starttls()
        connection.login(user= gmail, password= password)
        connection.sendmail(from_addr= gmail,
                            to_addrs= birthday_person["email"],
                            msg= f"Subject: Mensagem de Rafinha\n\n{new_contents}")






