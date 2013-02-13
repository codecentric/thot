Narrative:
As a user 
I want to add a session on the marketplace
so that other participants can see my proposal for a session

Scenario: Add session to the marketplace

Given a user is on the marketplace
When user adds the session
Then the session data is saved
And the session data is shown


Scenario: Modify session in the marketplace

Given a user is on the marketplace
When some session data is already in the marketplace
And user changes data
Then changed sessions data is saved
And changed session data is shown