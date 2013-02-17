Narrative:
In order to publish the speaker profile for the conference atendees
As a speaker 
I want to add my speaker profile

Scenario: Create speaker

Given user is on the speaker creation page
And user adds forename 'David'
And user adds last name 'Völkel'
And user adds the bio 'David's bio'
When user saves the speaker
Then a speaker exists with forename 'David', last name 'Völkel' and bio 'David's bio'


Scenario: Look at the biography of a speaker

Given a user is on speakers site
When he selects the speaker 'David' 'Völkel'
Then the speaker data is shown