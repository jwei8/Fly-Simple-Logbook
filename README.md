# My Personal Project

## FlySimpleLogbook


***Who will use it?***

*FlySimpleLogbook* is an electronic Logbook designed for General Aviation pilots which help them to record the
information for each flight. It's suitable for student pilots and licensed pilots to log their flying hours on a
digital platform. The fundamentals of this logbook program is transferable, and can be adapted easily to other 
professions, such as recording flying hours of an aircraft for maintenance purpose, recording work experience 
for aircraft maintenance engineers, and so much more. 
<br>
<br>
***What will it do?***


The pilot can enter the information for each flight into the program. The application will be able to 
record important flight information such as Date, Aircraft information, flight time during day or night and the 
route of the flight. It can sort the entries by specific filter items to categorize their flights. The user can save
and create aircraft profile in the program to include information about each specific airplane.
<br>
<br>
***Why is this project of interest to you?***


Pilots are responsible for keeping track of their flying hours and keep their logbooks up to date. A logbook 
contains crucial information of the pilot which should contain accurate flying hours with accurate calculations. 
However, it is a repetitive process to write down hours by hand each time after a flight and calculating the flying hours by hand
introduces the possibility of making algebra mistakes. As a private pilot myself, I have been researching for a way to 
digitalis my paper logbook using a simple and user-friendly program. Therefore, it inspired me to use this opportunity
to create an electronic logbook to simplify the process of logging flying hours for pilots. Computers are good at executing
the same commands repeatedly, which makes it a good tool for pilots to maintain their personal logbooks.  
<br>
<br>
## User Stories
A *bulleted* list:
- As a user, I want to be able to add an entry to the logbook.
- As a user, I want to be able to view all the entries in the logbook.
- As a user, I want to be able to filter the entries time when the flight was done or the minimum flight time.
- As a user, I want to be able to create a new aircraft profile.
- As a user, I want to be able to view the aircraft profiles stored on file.
- As a user, I want to be able to remove a specific aircraft profile on file.
- As a user, I want to be able to save my new entries to the logbook record.
- As a user, I want to be able to load my saved entries when starting the application.

## Phase Four Task Three
- I can improve the design of my program by creating an Interface that specifies the behavior of creating a new log entry.
There are some semantic coupling in my program right now, where the GUI relies on the LogBook Entry class to implement the methods related to create
a new log entry. Using an Interface can reduce the coupling in my program.
- I can also extract an abstract Interface from my LogbookRecord class. It can reduce coupling in my program and improve its cohesion. 
