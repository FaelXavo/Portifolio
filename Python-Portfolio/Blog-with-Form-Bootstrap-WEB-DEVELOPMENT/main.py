import datetime

from flask import Flask, render_template, request
import requests
import smtplib

'''
This programm is a better version of the "simple-blog" project. Here I learned to use Bootstrap to actually make the blog
look better (and to create the formular for the contact page).
'''

posts = requests.get("https://api.npoint.io/bcfeb4ab137c2c593c78").json() #The posts were taken by this api
email = EMAIL #this email is used to access the smtplib ( a library used to send emails automatically)
password = PASSWORD #this password is used to access the smtplib ( a library used to send emails automatically)


app = Flask(__name__)

#Homepage
@app.route('/')
def get_all_posts():
    return render_template("index.html", all_posts=posts)

#Page about me
@app.route("/about")
def about():
    return render_template("about.html")

#Contact page
@app.route("/contact")
def contact():
    return render_template("contact.html")

#Here the posts are shown
@app.route("/post/<int:index>")
def show_post(index):
    requested_post = None
    for blog_post in posts:
        if blog_post["id"] == index:
            requested_post = blog_post
    return render_template("post.html", post=requested_post)

#When the "send" button is pressed, this function is called to send an email to the blog's owner with the message that the user wants to say.
@app.route("/form-entry", methods=["GET", "POST"])
def receive_data():
    if request.method == "POST":
        user_name = request.form['name']
        user_email = request.form['email']
        user_phone = request.form['phone']
        user_message = request.form['message']

        with smtplib.SMTP("smtp.gmail.com") as connection:
            connection.starttls()
            connection.login(user=email, password=password)
            connection.sendmail(from_addr=email, to_addrs=user_email, msg="Subject: User Contacting\n\n"
                                                                        f"Name: {user_name}\nEmail: {user_email}\n"
                                                                        f"Phone: {user_phone}\n"
                                                                        f"Message:\n{user_message}")

        return "<h1> Successfully sent your message! </h1>"
    else:
        return "ops nao rolou"


if __name__ == "__main__":
    app.run(debug=True, port=5001)
