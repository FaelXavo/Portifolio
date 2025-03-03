from tkinter import *
import math

# ---------------------------- CONSTANTS ------------------------------- #
PINK = "#e2979c"
RED = "#e7305b"
GREEN = "#9bdeac"
YELLOW = "#f7f5dd"
FONT_NAME = "Courier"
WORK_MIN = 25
SHORT_BREAK_MIN = 5
LONG_BREAK_MIN = 20
CHECKMARK = "✔"
reps = 0
timer = None
# ---------------------------- TIMER RESET ------------------------------- # 


def reset_timer():
    window.after_cancel(timer)

    canvas.itemconfig(timer_text, text= "00:00")
    title.config(text= "Timer")
    check.config(text= "")
    global reps
    reps = 0
# ---------------------------- TIMER MECHANISM ------------------------------- # 


def start_timer():

    global reps
    reps += 1

    print(reps)
    work_sec = WORK_MIN * 60
    short_break_sec = SHORT_BREAK_MIN * 60
    long_break_sec = LONG_BREAK_MIN * 60

    if reps % 8 == 0:
        countdown(long_break_sec)
        title.config(text="Brake", fg= RED)
    elif reps % 2 == 0:
        countdown(short_break_sec)
        title.config(text="Brake", fg= PINK)
    else:
        countdown(work_sec)
        title.config(text="Work", fg= GREEN)


# ---------------------------- COUNTDOWN MECHANISM ------------------------------- # 


def countdown(count):


    count_min = math.floor(count/60)
    count_sec = count % 60
    if count_sec < 10:
        count_sec = f"0{count_sec}"

    canvas.itemconfig(timer_text, text=f"{count_min}:{count_sec}")
    if count > 0:
        global timer
        timer = window.after(1000, countdown, count-1)
    else:
        start_timer()
        mark = ""
        work_sessions= math.floor(reps/2)
        for i in range(work_sessions):
            mark += CHECKMARK
        check.config(text= mark)
# ---------------------------- UI SETUP ------------------------------- #


window = Tk()
window.title("Pomodoro")
window.config(padx=100, pady=50, bg= YELLOW)

tomato_img = PhotoImage(file="tomato.png")

canvas = Canvas(width= 200, height= 224, bg= YELLOW, highlightthickness= 0)
canvas.create_image(100, 112, image=tomato_img)
timer_text = canvas.create_text(100, 130, text= "00:00", fill= "white", font=(FONT_NAME, 35, "bold"))
canvas.grid(column=1, row= 1)

title = Label(text="TIMER", fg=GREEN, font=(FONT_NAME, 35, "bold"), highlightthickness= 0, bg= YELLOW)
title.grid(column= 1, row= 0)

start = Button(text="Start", highlightthickness= 0, command=start_timer)
start.grid(column=0, row=2)

reset = Button(text="Reset", highlightthickness= 0, command=reset_timer)
reset.grid(column=2, row=2)

check = Label(fg=GREEN, bg= YELLOW, highlightthickness= 0)
check.grid(column=1, row= 3)













window.mainloop()



