Narrative:
As a user 
I want to add a session on the marketplace
so that other participants can see my proposal for a session

Scenario: Add session to the marketplace

Given a user is on the marketplace
When user adds the session
Then the session data is saved
And the session data is shown


Scenario: Add link to biography of the speaker

Given a user is in one session of the marketplace
When he adds a link to a his biography
Then the link is saved


Scenario: Modify session in the marketplace

Given a user is in one session of the marketplace
When user changes data
Then changed sessions data is saved
And changed session data is shown