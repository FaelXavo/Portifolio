import requests
from twilio.rest import Client

'''
@Rafael Xavier de Queiroga
  This programm uses the openweathermap API to check the weather of the day and sends a message via to the recipient's 
telephone using the Twilio API telling them if it is hot and if they should bring an umbrella when leaving home or not. 
  When this programm was done it was hosted in a website that runned the programm everyday at 6:00am .
'''

OWM_endpoint = "https://api.openweathermap.org/data/2.8/onecall"
api_key = "API-KEY"

account_sid = 'ACOUNT SID'
auth_token = 'AUTHENTICATION TOKE '


parameters = {
    "lat": "52.520008",
    "lon": "13.404954",
    "appid": api_key,
    "exclude": "current,minutely,daily"
}

response = requests.get(OWM_endpoint, params=parameters)
response.raise_for_status()
warning = response.status_code
data = response.json()

hourly = [data["hourly"][n] for n in range(13)] #the API return a JSON data type, so the programm takes the current and for the next 12 hours values and saves them in a list.
temp_now = round(hourly[0]["temp"] - 273.15, 1)#temperature at 6am (current)
max_temp = round(hourly[6]["temp"] - 273.15, 1)#temperature at 12pm (normally the hottest time of the day)

cold_now = False
mild_now = False
very_cold_now = False

#defining if the temperature is cold/mild or very cold
if 4 < temp_now <= 11:
    cold_now = True
if temp_now > 11 <= 20:
    mild_now = True
if temp_now <= 4:
    very_cold_now = True

print(hourly)
print(warning)

will_rain = "n/a"

#Checking if it is going to rain
for i in hourly:
    hourly_id = i["weather"][0]["id"]
    if hourly_id < 700:
        will_rain = "y"
    else:
        will_rain = "n"

#sending the messages
if will_rain == "y":
    client = Client(account_sid, auth_token)
    if very_cold_now:
        message = client.messages.create(
            from_='NUMBER FROM TWILIO',
            body=f"\nThe temperature right now is: {temp_now}°C!\n - 🥶 VERY COLD 🥶 - \nThe max temperature of today is: {max_temp}°C\nLBring an Umbrella! ☂️",
            to="RECIPIENT'S FULL NUMBER"
        )

    if cold_now:
        message = client.messages.create(
            from_='+NUMBER FROM TWILIO',
            body=f"\nThe temperature right now is: {temp_now}°C!\n - ❄️ COLD ❄️ - \nThe max temperature of today is: {max_temp}°C\nLBring an Umbrella! ☂️",
            to="RECIPIENT'S FULL NUMBER"
        )

    if mild_now:
        message = client.messages.create(
            from_='+NUMBER FROM TWILIO',
            body=f"\nThe temperature right now is: {temp_now}°C!\n - 😌 MILD 😌 - \nThe max temperature of today is: {max_temp}°C\nLBring an Umbrella! ☂️",
            to="RECIPIENT'S FULL NUMBER"
        )

if will_rain == "n":
    client = Client(account_sid, auth_token)
    if very_cold_now:
        message = client.messages.create(
            from_='+NUMBER FROM TWILIO',
            body=f"\nThe temperature right now is: {temp_now}°C!\n - 🥶 VERY COLD 🥶 - \nThe max temperature of today is: {max_temp}°C\nIt's not going to rain today ✌️",
            to="RECIPIENT'S FULL NUMBER"
        )


    if cold_now:
        message = client.messages.create(
            from_='+NUMBER FROM TWILIO',
            body=f"\nThe temperature right now is: {temp_now}°C!\n - ❄️ COLD ❄️ - \nThe max temperature of today is: {max_temp}°C\nIt's not going to rain today ✌️",
            to="RECIPIENT'S FULL NUMBER"
        )

    if mild_now:
        message = client.messages.create(
            from_='+NUMBER FROM TWILIO',
            body=f"\nThe temperature right now is: {temp_now}°C!\n - 😌 MILD 😌 - \nThe max temperature of today is: {max_temp}°C\nIt's not going to rain today ✌️",
            to="RECIPIENT'S FULL NUMBER"
        )
