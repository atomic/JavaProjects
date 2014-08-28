"""
File: interest.py
Author: Tony Lim
Email: atomictheorist@gmail.com
Github: https://github.com/gunlockz
Description: redo of project in python
"""


def getNewBalance(balance, month, interest):
    newBalance = balance
    for month in xrange(month):
        newBalance += (interest/12.0) * newBalance*(1.0/100.0)
    return float(newBalance)

balance = float(raw_input("Please input your balance? "))
interest = float(raw_input("Please input your interest? "))

for month in xrange(12):
    print "For month %d : %.2f" % (month + 1, getNewBalance(balance, month+1, interest))
