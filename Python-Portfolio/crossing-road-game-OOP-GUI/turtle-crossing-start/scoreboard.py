from turtle import Turtle
FONT = ("Courier", 24, "normal")


class Scoreboard(Turtle):
    def __init__(self):
        super().__init__()
        self.level = 1
        self.color("black")
        self.hideturtle()
        self.penup()
        self.final_lane()

        self.goto(x=-230, y=270)

        self.update_score()

    def update_score(self):
        self.write(f"Level:{self.level}", align="center", font=FONT)

    def level_up(self):
        self.clear()
        self.level += 1

    def final_lane(self):
        self.goto(-55, 285)
        self.pendown()
        self.fd(100)
        self.lt(90)
        self.fd(30)
        self.lt(90)
        self.fd(100)
        self.lt(90)
        self.fd(30)
        self.lt(90)
        self.penup()
        self.goto(x=-230, y=270)

    def game_over(self):
        self.goto(0, 0)
        self.write(f"Game Over", align="center", font=FONT)
