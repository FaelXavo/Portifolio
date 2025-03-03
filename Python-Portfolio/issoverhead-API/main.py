import requests
from datetime import datetime
import smtplib
import time

'''@Rafael Xavier de Queiroga
    The idea of this programm was to learn more about requests and the use of APIs. The programm checks the location of the
    satellite ISS and sends and email to the user telling him that the satellite is above them in the sky (since you can see it
    with your eyes)
'''

MY_LAT = "YOUR LATITUDE(as float)"
MY_LONG = "YOUR LONGITUDE(as float)"


response = requests.get(url="http://api.open-notify.org/iss-now.json")
response.raise_for_status()
data = response.json()

iss_latitude = float(data["iss_position"]["latitude"])
iss_longitude = float(data["iss_position"]["longitude"])

print(iss_latitude)
print(iss_longitude)

ISS_is_close = False
if (MY_LONG - 5) <= iss_longitude <= (MY_LONG + 5) or (MY_LAT - 5) <= iss_latitude <= (MY_LAT + 5):
    ISS_is_close = True
print(ISS_is_close) #if the ISS is close, print True, otherwise it's false
parameters = {
    "lat": MY_LAT,
    "lng": MY_LONG,
    "formatted": 0,
}

#Now we check the time of the sunset and sunrise of your current location (parameters created on line 24)
response = requests.get("https://api.sunrise-sunset.org/json", params=parameters)
response.raise_for_status()
data = response.json()


sunrise = int(data["results"]["sunrise"].split("T")[1].split(":")[0])
sunset = int(data["results"]["sunset"].split("T")[1].split(":")[0])


time_now = datetime.now()
hour_now = time_now.hour

#after checking where the satellite ISS is, it uses the smtp library to send the user an email to tell them if.
'''All the variables ahead must contain the real email, password, password and master-password of the user to work, so 
you can use the library of the SMTP.'''
gmail = "EMAIL"
password = "PASSWORD"
master_password = "MASTER-PASSWORD"


while ISS_is_close is True:
    if sunrise > hour_now or hour_now > sunset:
        with smtplib.SMTP("smtp.gmail.com") as connection:
            connection.starttls()
            connection.login(user= gmail,
                             password= password)
            connection.sendmail(from_addr= gmail,
                                to_addrs= "EMAIL-RECIPIENT",
                                msg= "Look at the sky!\n\nThe ISS satellite is above you right now!!")

    time.sleep(10)






