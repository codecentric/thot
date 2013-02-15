Narrative:
In order to make my biography visible for the conference atendees
As a speaker 
I want to add my bio to the conference application

Scenario: Add data of my biography

Given a user is on the speaker site
And user adds forename
And user adds last name
And user adds short info about himself
When user saves data
And forename is saved
And last name is saved
And short info is saved


Scenario: Look at the biography of a speaker

Given a user is on speaker site
When he selects a specific speaker
Then the data of his biography is shown