from turtle import Turtle
STARTING_POSITION = (0, -280)
MOVE_DISTANCE = 15
FINISH_LINE_Y = 280


class Player(Turtle):
    def __init__(self):
        super().__init__()
        self.penup()
        self.shape("turtle")
        self.color("green")
        self.goto(STARTING_POSITION)
        self.setheading(90)

    def go_up(self):
        self.setheading(90)
        new_y = self.ycor() + MOVE_DISTANCE
        self.goto(self.xcor(), new_y)

    def go_down(self):
        self.setheading(270)
        new_y = self.ycor() - MOVE_DISTANCE
        self.goto(self.xcor(), new_y)

    def go_right(self):
        self.setheading(0)
        new_x = self.xcor() + MOVE_DISTANCE
        self.goto(new_x, self.ycor())

    def go_left(self):
        self.setheading(180)
        new_x = self.xcor() - MOVE_DISTANCE
        self.goto(new_x, self.ycor())

    def reset_t(self):
        self.goto(STARTING_POSITION)

