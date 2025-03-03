from flask import Flask, render_template
from flask_bootstrap import Bootstrap
from flask_wtf import FlaskForm
from werkzeug.utils import redirect
from wtforms import StringField, SubmitField, URLField
from wtforms.fields.choices import SelectField
from wtforms.validators import DataRequired
import csv

'''
This is a website that has a table of some Cafes with the URL for their address in Google Maps and other information about
each of them, the idea was initialy to categorize good Cafes where you can study, relax or even work. The user can type 
the url to access the "add" page, so they can give the Cafe that they visited.
'''

app = Flask(__name__)
app.config['SECRET_KEY'] = '8BYkEfBA6O6donzWlSihBXox7C0sKR6b'
Bootstrap(app)


class CafeForm(FlaskForm):
    cafe = StringField('Cafe name', validators=[DataRequired()])
    location = URLField('Cafe Location on Google Maps (URL)', validators=[DataRequired()])
    open_time = StringField('Opening time e.g. 8AM', validators=[DataRequired()])
    closing_time = StringField('Closing time e.g 6PM', validators=[DataRequired()])
    coffee_rating = SelectField('Coffee Rating', validators=[DataRequired()], choices=[
        ("1", "☕️"), ("2", "☕️☕️"), ("3", "☕️☕️☕️"), ("4", "☕️☕️☕️☕️"), ("5", "☕️☕️☕️☕️☕️")])
    wifi_rating = SelectField('Wifi Strength Rating', validators=[DataRequired()], choices=[
        ("1", "💪"), ("2", "💪💪"), ("3", "💪💪💪"), ("4", "💪💪💪💪"),("6", "✘")])
    power_outlet_rating_fields = SelectField('Power Socket Availability', validators=[DataRequired()], choices=[
        ("1", "🔌"), ("2", "🔌🔌"), ("3", "🔌🔌🔌"), ("6", "✘")])
    submit = SubmitField('Submit')


# all Flask routes below
@app.route("/")
def home():
    return render_template("index.html")


@app.route('/add', methods=["GET", "POST"])
def add_cafe():
    form = CafeForm()
    if form.validate_on_submit():
        print("True")
        with open('cafe-data.csv', "a", newline='') as csv_file:
            csv_file.write(f"\n{form.cafe.data},{form.location.data},{form.open_time.data},"
                           f"{form.closing_time.data},{form.coffee_rating.data},{form.wifi_rating.data},"
                           f"{form.power_outlet_rating_fields.data}")
        return redirect('/cafes')

    return render_template('add.html', form=form)


@app.route('/cafes')
def cafes():
    with open('cafe-data.csv', newline='', encoding='utf-8') as csv_file:
        csv_data = csv.reader(csv_file, delimiter=',')
        list_of_rows = []
        for row in csv_data:
            list_of_rows.append(row)
    return render_template('cafes.html', cafes=list_of_rows)


if __name__ == '__main__':
    app.run(debug=True)
