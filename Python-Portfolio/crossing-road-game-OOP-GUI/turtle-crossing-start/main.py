import time
from turtle import Screen
from player import Player
from car_manager import CarManager
from scoreboard import Scoreboard

sleep = 0.019

screen = Screen()
screen.setup(width=600, height=600)
screen.tracer(0)
screen.listen()
screen.bgcolor("white")

t = Player()
screen.listen()
screen.bgcolor("white")

car_manager = CarManager()
score = Scoreboard()

screen.onkeypress(t.go_up, "Up")
screen.onkeypress(t.go_down, "Down")
screen.onkeypress(t.go_right, "Right")
screen.onkeypress(t.go_left, "Left")

game_is_on = True
while game_is_on:
    time.sleep(sleep)
    screen.update()
    car_manager.car_spawn()
    car_manager.car_move()
    score.update_score()
    for car in car_manager.cars:
        if t.distance(car) <= 20:
            score.game_over()
            game_is_on = False
    if t.ycor() >= 280:
        t.reset_t()
        score.level_up()
        score.final_lane()
        sleep *= 0.80

screen.exitonclick()
