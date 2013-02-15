Narrative:
As a speaker 
I want to add my bio to the conference application
so that other participants can see my biography


Scenario: Add data of my biography with correct e-mail-adress

Given a user is in the conference application
And user adds forename
And user adds last name
And user adds e-mail-adress 'max.mustermann@web.de'
And user adds short info about himself
When user saves data
Then e-mail-adress is valid
And forename is saved
And last name is saved
And e-mail-adress is saved
And short info is saved

Scenario: Add data of my biography

Given a user is in the conference application
And user adds forename
And user adds last name
And user adds e-mail-adress 'max.mustermann@web'
And user adds short info about himself
When user saves data
Then e-mail-adress is not valid
And error message is shown
And forename is not saved
And last name is not saved
And short info is not saved


Scenario: Look at the biography of a speaker

Given a user is in biography section
When he selects a specific speaker
Then the data of his biography is shown