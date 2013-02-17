Narrative:
In order to give the conference atendees the possibility to contact the speaker via e-mail
As a speaker 
I want to add my e-mail-adress to my biography

Scenario: Add correct e-mail-adress

Given user is on the speaker creation page
And user adds e-mail-adress 'max.mustermann@web.de'
When user saves data
Then e-mail-adress is valid
And e-mail-adress is saved

Scenario: Add incorrect e-mail-adress

Given user is on the speaker creation page
And user adds e-mail-adress 'max.mustermann@web'
When user saves data
Then e-mail-adress is not valid
And error message is shown
And e-mail-adress is not saved