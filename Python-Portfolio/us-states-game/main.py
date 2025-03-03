import turtle
import pandas

# Screen-->
screen = turtle.Screen()
screen.title("U.S. States Game")
image = "blank_states_img.gif"
screen.addshape(image)

# Writer -->
writer = turtle.Turtle()
writer.hideturtle()
writer.penup()
writer.pencolor("Black")

turtle.shape(image)

data = pandas.read_csv("50_states.csv")
all_states = data.state.to_list()
xcors = data.x.to_list()
ycors = data.y.to_list()

said_before = []



correct_states = 0
game = True
while game is True:
    answer_state = screen.textinput(title="Guess the State", prompt="What's another state's name?").title()
    if answer_state in all_states:
        if answer_state not in said_before:
            index = all_states.index(answer_state)
            said_before.append(answer_state)
            correct_states += 1
            writer.goto(xcors[index], ycors[index])
            writer.write(answer_state)
        else:
            print("You tried already this one!")
    else:
        print(f'There is no State called "{answer_state}" in the USA!')
    if correct_states >= 50:
        game = False
screen.exitonclick()
