from flask import Flask, render_template, redirect
from flask_bootstrap import Bootstrap5
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField
from wtforms.fields.simple import EmailField
from wtforms.validators import DataRequired, Email, Length


app = Flask(__name__)
bootstrap = Bootstrap5(app)
app.config.update(dict(
    SECRET_KEY="powerful secretkey",
    WTF_CSRF_SECRET_KEY="a csrf secret key"
))


class MyForm(FlaskForm):
    email = EmailField(
        label='Email',
        validators=[DataRequired(), Email(), Length(min=5)],
    )
    password = PasswordField(
        label='Password',
        validators=[DataRequired(), Length(min=8)]
    )
    submit = SubmitField(label="Log in")


@app.route("/")
def home():
    return render_template('index.html')


@app.route("/success")
def success():
    return render_template('success.html')


@app.route("/login", methods=['GET', 'POST'])
def login():
    form = MyForm()
    if form.validate_on_submit():
        if form.email.data == "adm@amil.com" and form.password.data == "12345678":
            return redirect('/success')
        else:
            return render_template("denied.html")
    return render_template('login.html', form=form)


if __name__ == '__main__':
    app.run(debug=True)
