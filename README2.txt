GROUP:g3B

TITLE:biAct

PROJECT DESCRIPTION:In Bilkent University, there are a few places that we can see the 
announcements of club events such as BAIS, STARS, and wallpapers. However, students 
don’t like reading such a tedious list of activities through BAIS mails or STARS. They 
can only see these activities on wall announcements in certain department buildings 
here and almost every time they do not even read these announcements. Therefore, students 
can miss events and may not complete GE250/1 points. Besides, they may not do their 
interested out-lesson activities, so they may not learn any skills except their major 
lessons and they are not enjoyed in university. Thus, it would be better if students read 
these activities from their phones without having to log in to their STARS or mail accounts. 
We are developing the mobile app named BiAct that shows upcoming activities, seminars from 
wanted clubs and departments lists. The target aim of this app is to provide a more easily 
tracked list of events such as seminars, club activities and researches, in Bilkent University 
created by clubs, departments with making the environment where users can interact with each 
other. We are expecting that this app is used by all Bilkent University students.

WORKING PARTS: The application works in general. When a new event is created, photos and 
event information are saved to the database and data from the database is taken and displayed 
on the feed pages. There is also no problem in user registration, login and logout processes. 
There are minor problems on profile pages. There is no problem in transitions between pages.

NOT WORKING PARTS:After logging out of the application and after the application is closed, 
registered users cannot log in again. But there is no need to log out because the application 
does not ask for email and password every time. After selecting the profile photo on the profile 
pages, the photo is saved in the database, but I had trouble getting the data from the database 
and the photo does not stay there permanently. Also, the biggest problem of the application is 
that my upcoming events page and attend buttons are not working. Our application, which has a 
purpose that the user can see the activities that he / she will attend in the future, has not 
succeeded. Also, although the search page was under the responsibility of Mikail, it was not 
done and the settings page is the same.
---------------------------------------------------------------------------------------------------
Utku Gökçen: He did everything in the project except the 'create event' page. 

Arda Akdeniz: He made the 'create event' page. But Utku Gökçen helped the majority of the class.

---------------------------------------------------------------------------------------------------
We use Google Firebase Database System and Android Stuido version 3.6.3 in our project. We use Firebase
libraries in our project and also mostly use Java 8 libraries. The application can be easily run by 
pressing the run button after an android emulator has been downloaded to the computer. However, since 
Utku Gökçen can only see the database, you may not be able to access the database.
