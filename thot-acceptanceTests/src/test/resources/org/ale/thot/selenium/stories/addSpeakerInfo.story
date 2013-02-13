Narrative:
As a speaker 
I want to add my bio to the conference application
so that other participants can see my biography

Scenario: Add data of my biography

Given a speaker is in the conference application
When speaker adds forename
And speaker adds last name
And speaker adds short info about himself
Then forename is saved
And last name is saved
And short info is saved

Scenario: Add link to picture

Given a speaker has saved his bio
When speaker adds a URL to a picture of himself
Then the URL is saved

Scenario: Look at the biography of a speaker

Given a user is in biography section
When he selects a specific speaker
Then the data of his biography is shown

Scenario: Show picture of speaker

Given a user is in biography section of a specific speaker
When he selects the URL of the photo
Then the photo is shown