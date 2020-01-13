Feature: Modifier l'adresse d'un abonné
    
   Scenario: Modification de l'adresse d'un abonné
      Given  Un abonné avec une adresse principale
      When   Le conseiller connecté à canal modifie l'adresse de l'abonné
      Then   L'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné