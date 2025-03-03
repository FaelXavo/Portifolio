from menu import Menu
from coffee_maker import CoffeeMaker
from money_machine import MoneyMachine

waiter = Menu()
caixa = MoneyMachine()
chef = CoffeeMaker()
operation = 1

while operation == 1:
    order_name = input(f"What would you like to drink? {waiter.get_items()}")
    if order_name == "report":
        chef.report()
        caixa.report()
    elif order_name == "off":
        operation = 0


    # caixa.make_payment(order.cost)
    if order_name != "report":
        if order_name != "off":
            order = waiter.find_drink(order_name)
            if chef.is_resource_sufficient(order):
                if caixa.make_payment(order.cost) and chef.is_resource_sufficient(order):
                    chef.make_coffee(order)

