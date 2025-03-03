from tkinter import *
import pandas
import random


BACKGROUND_COLOR = "#B1DDC6"


try:
    data = pandas.read_csv("data/not_learned.csv")
except FileNotFoundError:
    data = pandas.read_csv("data/french_words.csv")
    data_dict = data.to_dict(orient= "records")

else:
    data_dict = data.to_dict(orient= "records")


current_card = {}



# ----------------- Functions ----------------- #
def next_card():
    global current_card


    current_card = random.choice(data_dict)
    canvas.itemconfig(canvas_image, image = CARDS_FRONT)
    canvas.itemconfig(card_title, text= "French", fill= "black")
    canvas.itemconfig(card_word, text= current_card["French"], fill = "black")


def flip_card():
    global current_card

    canvas.itemconfig(canvas_image, image = CARDS_BACK)
    canvas.itemconfig(card_title, text = "English", fill= "white")
    canvas.itemconfig(card_word, text = current_card["English"], fill= "white")
    window.after(30)
    window.after(3000, next_card)


def already_known():
    not_learned = data_dict
    not_learned.remove(current_card)
    print(f"There are {len(not_learned)} more cards!")
    new_csv = pandas.DataFrame(not_learned)
    new_csv.to_csv("data/not_learned.csv")

    next_card()
# ----------------- UI SETUP ----------------- #


#Window
window = Tk()
window.title("Flash Cards Game")
window.config(padx= 50, pady= 50, bg= BACKGROUND_COLOR)

#Images
CARDS_BACK = PhotoImage(file="./images/card_back.png")
CARDS_FRONT = PhotoImage(file="./images/card_front.png")
RIGHT_ANSWER = PhotoImage(file="./images/right.png")
WRONG_ANSWER = PhotoImage(file="./images/wrong.png")

#Canvas
canvas = Canvas(width= 800, height = 526, highlightthickness=0, bg= BACKGROUND_COLOR)
canvas_image = canvas.create_image(400, 263, image= CARDS_FRONT)
card_title = canvas.create_text(400, 150, text= "Title", font=("Arial", 40, "italic"))
card_word = canvas.create_text(400, 263, text= "word", font= ("Arial", 60, "bold"))
canvas.grid(row=0, column= 0, columnspan=2)


#Button
unknown_button = Button(image= WRONG_ANSWER, highlightthickness= 0, command= flip_card)
unknown_button.grid(row=1, column=0)

known_button = Button(image= RIGHT_ANSWER, highlightthickness= 0, command= already_known)
known_button.grid(row=1, column=1)


next_card()








window.mainloop()