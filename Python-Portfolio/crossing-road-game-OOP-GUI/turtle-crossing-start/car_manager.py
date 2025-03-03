from turtle import Turtle
import random

# "brown"
# "red", "orange", "yellow", "green", "blue", "purple"
COLORS = ["red", "orange", "yellow", "green", "blue", "purple"]
STARTING_MOVE_DISTANCE = 5
MOVE_INCREMENT = 10



class CarManager:

    def __init__(self):
        self.cars = []
        self.move_speed = STARTING_MOVE_DISTANCE

    def car_spawn(self):
        random_chance = random.randint(1,6)
        if random_chance == 1:
            car = Turtle("square")
            car.shapesize(stretch_wid=1, stretch_len=2)
            car.penup()
            car.color(random.choice(COLORS))
            car.goto(300, random.randint(-240, 240))
            self.cars.append(car)

    def car_move(self):
        for car in self.cars:
            car.backward(self.move_speed)


