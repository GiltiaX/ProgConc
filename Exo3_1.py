# -*- coding: utf-8 -*-
"""
Created on Sat Oct  7 18:17:57 2017

@author: Giltia
"""

from sys import argv
import time
from threading import Thread,Condition
import queue
from tkinter import *
import random

class Producteur(Thread):
    def __init__(self, q,l, temps,interrupted):
        Thread.__init__(self)
        self.q=q
        self.l = l
        self.temps = temps
        self.interrupted = interrupted
    def interrupt(self):
        self.interrupted=True
    def run(self):
        while not self.interrupted:
            n = random.randint(1,100)
            time.sleep(self.temps)
            
class Consommateur1(Thread):
    def __init__(self, q, temps,interrupted):
        Thread.__init__(self)
        self.q=q
        self.temps = temps
        self.interrupted = interrupted
    def interrupt(self):
        self.interrupted=True
    def run(self):
        while not self.interrupted:
            time.sleep(self.temps)
            
class Consommateur2(Thread):
    def __init__(self, m, temps,interrupted):
        Thread.__init__(self)
        self.m=m
        self.temps = temps
        self.interrupted = interrupted
    def interrupt(self):
        self.interrupted=True
    def run(self):
        while not self.interrupted:
            time.sleep(self.temps)
            
def empile(fifo, liste, valeur):
    fifo.put(valeur)
    liste.append(valeur)

def depile(fifo, liste):
    fifo.get()
    return liste.pop(0)

class Application(Frame):
    def start(self):
        #th_prod = Producteur(q,l,100,False)
        l.append(40)

    def createWidgets(self):
        self.label_File = Label(self,textvariable=l)
        self.label_File.pack()

        self.start = Button(self)
        self.start["text"] = "Start",
        self.start["command"] = self.start

        self.start.pack({"side": "left"})
        self.QUIT = Button(self)
        self.QUIT["text"] = "QUIT"
        self.QUIT["fg"]   = "red"
        self.QUIT["command"] =  self.quit

        self.QUIT.pack({"side": "left"})

    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.pack()
        self.createWidgets()


q = queue.Queue(20)
l = {40}
root = Tk()
app = Application(master=root)
app.mainloop()
root.destroy()
file = queue.Queue(20)
file.put(40)
list = []
list.append(40)