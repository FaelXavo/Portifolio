from flask import Flask, render_template
import requests

app = Flask(__name__)


@app.route('/')
def home():
    ap_url = "https://api.npoint.io/d015619eba38f834853e"
    response = requests.get(ap_url)
    posts = response.json()
    return render_template("index.html", posts=posts)

@app.route('/post/<int:blog_id>')
def get_post(blog_id):
    ap_url = "https://api.npoint.io/d015619eba38f834853e"
    response = requests.get(ap_url)
    posts = response.json()
    return render_template("post.html", blog_id=blog_id, posts=posts)


if __name__ == "__main__":
    app.run(debug=True)
