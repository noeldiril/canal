# canal

To launch and make test on app, we must :

  - Run the app like a sprinbootapp.
  - Import the postman configuration to get the diffirente request to laucnh with :        
      https://www.getpostman.com/collections/045d43a939562588f692

On the App, we can :

  - Create, Update , List Subscriber.
  - Create, List Contracts.
  - An Subscribers house is composed of a firstname, a lastname, an adress,  an id and a list of Contracts.
  - An Contract is composed of an id, adress a description, a creation time.


# Steps

To create Subscriber, you have to give a valid Subscriber and post at /addsubscriber.
To find all of the subscriber you have to get at /subscribers.
To update one , you have to give an adress (string) and post at : /subscriber/{id}/editadress. The update will update the adress on contracts too.
To find all of the contract of a subscribers you have to get at l/subscriber/{id}/contracts
