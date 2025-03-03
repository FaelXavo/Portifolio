from question_model import Question
from data import question_data
from quiz_brain import QuizBrain

question_bank = []

for i in question_data:
    index = question_data.index(i)
    q_text = question_data[index]["text"]
    q_answer = question_data[index]["answer"]
    stored = Question(q_text, q_answer)

    question_bank.append(stored)

quiz = QuizBrain(question_bank)

while quiz.still_has_questions():
    quiz.next_question()

print("You completed the quiz")
print(f"Your final score is: {quiz.score} / {quiz.question_number}")
