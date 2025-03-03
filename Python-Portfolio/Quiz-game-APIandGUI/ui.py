from tkinter import *
from quiz_brain import QuizBrain


THEME_COLOR = "#375362"

# correct_img = PhotoImage(file ="images/true.png")
# false_img = PhotoImage(file = "images/false.png")



class QuizInterface:

    def __init__(self, quiz_brain: QuizBrain):
        self.quiz = quiz_brain

        self.window = Tk()
        self.window.title("Quizzler")
        self.window.config(padx= 20, pady= 20, bg= THEME_COLOR)

        self.canvas = Canvas()
        self.canvas.config(height= 250, width= 300, bg= "White")
        self.question_text = self.canvas.create_text(150,
                                                     125,
                                                     text= "Here it comes the text",
                                                     font= ("Arial", 20, "italic"), width=280)

        self.canvas.grid(row=1,
                         column=0,
                         columnspan= 2,
                         pady= 50)


        self.SCORE = 0
        self.score = Label(text= "Score: " + str(self.SCORE), highlightthickness=0, bg= THEME_COLOR, fg= "white")
        self.score.grid(row= 0, column= 1)

        self.correct_img = PhotoImage(file="images/true.png")
        self.false_img = PhotoImage(file="images/false.png")

        self.true = Button(image= self.correct_img, highlightthickness= 0, command= self.user_answer_true)
        self.true.grid(row=2, column=0)

        self.false = Button(image= self.false_img, highlightthickness= 0, command= self.user_answer_false)
        self.false.grid(row=2, column= 1)

        self.get_next_question()

        self.window.mainloop()

    def get_next_question(self):
        self.canvas.config(bg="white")
        if self.quiz.still_has_questions():
            self.score.config(text="Score: " + str(self.SCORE))
            q_text = self.quiz.next_question()
            self.canvas.itemconfig(self.question_text, text= q_text)
        else:
            self.canvas.itemconfig(self.question_text,
                                   text= f"You've reached the end of the quiz.\n\nFinal Score: {self.quiz.score}")
            self.score.grid_remove()
            self.true.config(state= "disabled")
            self.false.config(state="disabled")

    def user_answer_true(self):
        self.give_feedback(self.quiz.check_answer("True"))


    def user_answer_false(self):
        self.give_feedback(self.quiz.check_answer("False"))


    def give_feedback(self, is_right):
        if is_right:
            self.canvas.config(bg="green")
            self.SCORE += 1

        else:
            self.canvas.config(bg="red")
        self.window.after(1000, self.get_next_question)