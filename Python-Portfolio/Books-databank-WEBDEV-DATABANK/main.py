from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column
from sqlalchemy import Integer, String, Float
#initilizing Flask's app
app = Flask(__name__)


#Creating our base to work with the data
class Base(DeclarativeBase):
    pass


#defining the name of our database
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///book-collection.db"

db = SQLAlchemy(model_class=Base)
db.init_app(app)


#creating the model of our table
class Book(db.Model):
    id: Mapped[int] = mapped_column(Integer, primary_key=True)
    title: Mapped[str] = mapped_column(String(250), unique=True, nullable=False)
    author: Mapped[str] = mapped_column(String(250), nullable=False)
    rating: Mapped[float] = mapped_column(Float, nullable=False)


#creates a new database
with app.app_context():
    db.create_all()


def add_book(title, author, rating):
    with app.app_context():
        # Verificar se o livro já existe
        existing_book = Book.query.filter_by(title=title).first()
        if existing_book:
            print(f"O livro '{title}' já existe no banco de dados!")
            return

        # Criar e adicionar o novo livro
        new_book = Book(title=title, author=author, rating=rating)
        db.session.add(new_book)
        try:
            db.session.commit()
            print(f"O livro '{title}' foi adicionado com sucesso!")
        except Exception as e:
            db.session.rollback()
            print(f"Erro ao adicionar o livro: {e}")


#encontrar o livro escolhido usando o ID(único para cada) e alterar o valor do rating dele
def edit_rating(id, new_rating):
    book_id = id
    with app.app_context():
        book_to_update = db.get_or_404(Book, book_id)
        book_to_update.rating = new_rating
        db.session.commit()


#encontrar o livro escolhido usando o ID(único para cada) e apagar ele
def delete_book(id):
    book_id = id
    with app.app_context():
        book_to_delete = db.get_or_404(Book, book_id)
        db.session.delete(book_to_delete)
        db.session.commit()


@app.route('/')
def home():
    #read all-books object
    with app.app_context():
        result = db.session.execute(db.select(Book).order_by(Book.title))
        all_books = result.scalars().all()
    return render_template('index.html', all_books=all_books)


@app.route("/add", methods=["GET", "POST"])
def add():
    if request.method == "POST":
        book = {
            "title": request.form["title"],
            "author": request.form["author"],
            "rating": request.form["rating"]
        }
        add_book(book["title"], book["author"], book["rating"])
        print(book)
        return redirect(url_for('home'))
    return render_template('add.html')


@app.route("/edit", methods=["GET", "POST"])
def edit():
    if request.method == "POST":
        book_id = request.form["id"]
        new_rating = request.form["rating"]
        edit_rating(book_id, new_rating)
        return redirect(url_for('home'))
    book_id = request.args.get('id')
    book_selected = db.get_or_404(Book, book_id)
    return render_template('edit.html', book=book_selected)


@app.route("/delete", methods=["GET", "POST"])
def delete():
    book_id = request.args.get("id")
    delete_book(book_id)
    return redirect(url_for('home'))


if __name__ == "__main__":
    app.run(debug=True)
