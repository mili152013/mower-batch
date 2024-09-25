Feature: Job de traitement de la tondeuse
  Scenario: Traiter les données de la tondeuse et les enregistrer
    Given le fichier d'entrée "input.txt" est disponible
    When le job de traitement de la tondeuse est lancé
    Then les données doivent être traitées et enregistrées dans "output.txt"
