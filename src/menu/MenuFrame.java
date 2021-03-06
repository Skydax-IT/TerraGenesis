package menu;
import batiments.Batiment;
import batiments.Mine;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import jeu.Joueur;
import planete.*;
import technologies.Technologie;

import java.util.ArrayList;


public class MenuFrame {

    // Constructeur par défaut
    public MenuFrame(Joueur j1) {
        this.WIDTH = 1200;
        this.HEIGHT = 600;
        this.joueur = j1;

    }

    //Variables globales
    Scene scene;
    Joueur joueur;

    //Dimensions de la fenêtre principal
    private int WIDTH;
    private int HEIGHT;

    //Objet 3D Sphère pour modéliser la planète
    private final Sphere sphere = new Sphere(170);

    //Boutons globaux
    private Button startButton = new Button("START");
    private Button registerButton = new Button("REGISTER");
    private Button creerVilleButton = new Button("CREER MA VILLE");
    private Button creerPosteButton = new Button("CREER MON POSTE");

    //Variables pour les ombres des boutons
    DropShadow shadow = new DropShadow();

    //Labels globaux
    Label nomJoueur = new Label();
    Label nomPlanete = new Label();

    //Input du joueur pour fenêtres PopUps
    String reponse = new String();

    //ComboBox globales
    ComboBox menuDeroulantVille;
    ComboBox menuDeroulantPoste;
    ComboBox menuDeroulantBatimentVille = new ComboBox();
    ComboBox menuDeroulantBatiment = new ComboBox();
    ComboBox menuDeroulantMinePoste = new ComboBox();
    ComboBox menuDeroulantMine = new ComboBox();
    ComboBox menuDeroulantTechnologie = new ComboBox();

    //Mémoires tampons des Ville & Poste séléctionnés dans les listes
    Ville memoireVille;
    Poste memoirePoste;

    //Liste des labels Statistiques
    ArrayList<Label> listLabelsStatistiques;

    //Fonction start appelé par le main au début
    public void start(Stage primaryStage) {

        //Bouton start invisible au début
        startButton.setVisible(false);

        //Construction de la scène d'accueil
        primaryStage.setScene(createMainScene());
        primaryStage.setTitle("TerraGenesis");
        primaryStage.show();
        prepareAnimation();
        generateSimplePopUp("Bienvenue sur TerraGenesis !\nIl est maintenant temps de fonder\nvotre colonie afin de terraformer\nvotre planète...", 320, 270);


        //SCENE MENU : Eléments
        Button populationButton = new Button("POPULATION");
        Button techButton = new Button("TECHNOLOGIES");
        Button statsButton = new Button("STATISTIQUES");
        Button tutorielButton = new Button("TUTORIEL");
        Button exitButton = new Button("QUITTER");
        ArrayList<Button> listButton = new ArrayList<>();
        listButton.add(populationButton);
        listButton.add(techButton);
        listButton.add(statsButton);
        listButton.add(tutorielButton);
        listButton.add(exitButton);

            //SCENE MENU>POPULATION : Eléments
            Button gestionVilleButton = new Button("GÉRER VILLES");
            Button gestionPosteButton = new Button("GÉRER POSTES");
            Button backButton = new Button("RETOUR");
            ArrayList<Button> listButtonPopulation = new ArrayList<>();
            listButtonPopulation.add(gestionVilleButton);
            listButtonPopulation.add(gestionPosteButton);
            listButtonPopulation.add(backButton);

                //SCENE MENU>POPULATION>GESTION VILLE :Elements
                Button donnerUnNomVilleButton = new Button("DONNER UN NOM A MA VILLE");
                creerVilleButton.setVisible(false);
                Button supprimerVilleButton = new Button("SUPPRIMER MA VILLE");
                Button modifierVilleButton = new Button("MODIFIER MA VILLE");
                Button backPopulationButton = new Button("RETOUR");
                ArrayList<Button> listGestionVilleButton = new ArrayList<>();
                listGestionVilleButton.add(donnerUnNomVilleButton);
                listGestionVilleButton.add(creerVilleButton);
                listGestionVilleButton.add(supprimerVilleButton);
                listGestionVilleButton.add(modifierVilleButton);
                listGestionVilleButton.add(backPopulationButton);
                ArrayList<Label> listeIdentite = new ArrayList<>();
                listeIdentite.add(nomJoueur);
                listeIdentite.add(nomPlanete);

                    //SCENE MENU>POPULATION>GESTION VILLE>MODIFIER VILLE
                    Button ajouterBatimentButton = new Button("AJOUTER UN BATIMENT");
                    Button supprimerBatimentButton = new Button("SUPPRIMER UN BATIMENT");
                    Button backButtonGererVilleButton = new Button("RETOUR");
                    ArrayList<Button> listModifierVilleButton = new ArrayList<>();
                    listModifierVilleButton.add(ajouterBatimentButton);
                    listModifierVilleButton.add(supprimerBatimentButton);
                    listModifierVilleButton.add(backButtonGererVilleButton);

                //SCENE MENU>POPULATION>GESTION POSTE
                Button donnerNomPosteButton = new Button("DONNER UN NOM A MON POSTE");
                creerPosteButton.setVisible(false);
                Button supprimerPosteButton = new Button("SUPPRIMER MON POSTE");
                Button modifierPosteButton = new Button("MODIFIER MON POSTE");
                ArrayList<Button> listGestionPosteButton = new ArrayList<>();
                listGestionPosteButton.add(donnerNomPosteButton);
                listGestionPosteButton.add(creerPosteButton);
                listGestionPosteButton.add(supprimerPosteButton);
                listGestionPosteButton.add(modifierPosteButton);
                listGestionPosteButton.add(backPopulationButton);

                    //SCENE MENU>POPULATION>GESTION POSTE>MODIFIER POSTE
                    Button ajouterMineButton = new Button("AJOUTER UNE MINE");
                    Button supprimerMineButton = new Button("SUPPRIMER UNE MINE");
                    Button backButtonGererPosteButton = new Button("RETOUR");
                    ArrayList<Button> listModifierPosteButton = new ArrayList<>();
                    listModifierPosteButton.add(ajouterMineButton);
                    listModifierPosteButton.add(supprimerMineButton);
                    listModifierPosteButton.add(backButtonGererPosteButton);

            //SCENE MENU>TECHNOLOGIES
            Button rechercherTechButton = new Button("RECHERCHER");
            Button backButton2 = new Button("RETOUR");
            ArrayList<Button> listButtonTech = new ArrayList<>();
            listButtonTech.add(rechercherTechButton);
            listButtonTech.add(backButton2);

            //SCENE MENU>STATISTIQUES
            Button backButton3 = new Button("RETOUR");
            ArrayList<Button> listStatsButtons = new ArrayList<>();
            listStatsButtons.add(backButton3);


        //DEFINITIONS DES ACTIONS BOUTONS

        //ACCUEIL : Actions Boutons
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                generateTwoAskPopUp("Quel sera votre nom d'aventurier?", "Quel sera le nom de votre planète?");
                startButton.setVisible(true);
                registerButton.setVisible(false);
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                joueur.initialiserJoueur(nomJoueur.getText(), nomPlanete.getText());
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false, false, listeIdentite, -1, -1));
                generateSimplePopUp("                             AIDE\nAfin d'appréhender les règles du jeu\net d'en comprendre le fonctionnement,\nveuillez cliquer sur le bouton Tutoriel", 390, 250);
            }
        });

            //MENU PRINCIPAL: Actions Boutons
            exitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    System.exit(1);
                }
            });

            populationButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    primaryStage.setScene(createScene("MENU POPULATION", listButtonPopulation, null, false, false,false, listeIdentite, -1, -1));
                }
            });

            techButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    primaryStage.setScene(createScene("MENU TECHNOLOGIES", listButtonTech, null, false, false, true, listeIdentite,-1, -1));
                }
            });

            statsButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    getListStats();
                    primaryStage.setScene(createScene("STATISTIQUES", listStatsButtons, listLabelsStatistiques, false, false,false, listeIdentite,-1,-1));
                    if (joueur.verifierVictoire() == true){
                        generateSimplePopUp("BRAVO VOUS AVEZ GAGNE!", 300, 270);
                    }
                }
            });

            tutorielButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    generateSimplePopUp("Votre objectif dans terra Genesis est de terraformater votre planète pour la rendre habitable et viable pour l'espèce humain.\n" +
                            "Il s'agira dans cette simulation d'effectuer des constructions et des améliorations afin de vous rapprocher le plus possible \n" +
                            "des constantes de la terre.\n" +
                            "\n" +
                            "Plusieurs constantes rentrent en jeu:\n" +
                            "-Température : Il est important pour les humains d'obtenir une température stable et viable. Elle est mesurée en millikelvins.\n" +
                            "-Pression : Il est important pour une planète d'avoir une atmosphère. \n" +
                            "\tIl faut essayer de se rapprocher de la pression atmosphérique de la terre.\n" +
                            "-Oxygène : Pour permettre à un humain de survivre, il faut entre 18 à 24% d'oxygène respirable dans l'air.\n" +
                            "-Eau: Principal ingrédient de la vie. Elle garantit la prospérité des écosystèmes sous-marins.\n" +
                            "-Biomasse: Pour accueillir une population humaine, il est important de faire pousser une flore et de développer un écosystème planétaire.\n" +
                            "-Population: La population provient principalement de l'immigration, cependant les naissances se multiplieront avec le temps.\n" +
                            "\tL'apparition d'une faune permettra à votre peuple de vivre à la surface.\n" +
                            "-Finance: Permet d'effectuer des constructions et des améliorations.",1200,550);
                }
            });

                //MENU POPULATION : actions boutons
                backButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false, false, listeIdentite,-1, -1));
                    }
                });

                gestionVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        primaryStage.setScene(createScene("GERER LES VILLES", listGestionVilleButton, null, true, false, false, listeIdentite,-1,-1));                }
                });

                    //Gérer villes : actions boutons
                    backPopulationButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            primaryStage.setScene(createScene("MENU POPULATION", listButtonPopulation, null, false, false,false, listeIdentite,-1,-1));
                        }
                    });

                    donnerUnNomVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            generateAskPopUp("Quel sera le nom de votre Ville?", 280, 260);
                        }
                    });

                    creerVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            joueur.constuireVille(reponse);
                            creerVilleButton.setVisible(false);
                            creerPosteButton.setVisible(false);
                            generateSimplePopUp("Félicitations!\nVotre ville est en construction\nFaites retour pour actualiser votre liste.", 370, 220);
                        }
                    });

                    supprimerVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            joueur.supprimerVille((Ville) menuDeroulantVille.getSelectionModel().getSelectedItem());
                            generateSimplePopUp("Félicitations!\nVotre ville a été supprimé.", 250, 200 );
                        }
                    });

                    modifierVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            memoireVille = (Ville)menuDeroulantVille.getSelectionModel().getSelectedItem();
                            primaryStage.setScene(createScene("MENU MODIFICATION VILLE", listModifierVilleButton, null, false, false,false, listeIdentite, menuDeroulantVille.getItems().indexOf(menuDeroulantVille.getSelectionModel().getSelectedItem()), -1));
                        }
                    });

                        //Modifier ville boutons
                        ajouterBatimentButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                
                                if(menuDeroulantBatiment.getSelectionModel().getSelectedItem() != null){
                                    joueur.construireBatiment(memoireVille, (Batiment) menuDeroulantBatiment.getSelectionModel().getSelectedItem());
                                }
                                generateSimplePopUp("Félicitations!\nVotre bâtiment a été ajouté.", 350, 200);
                            }
                        });
                
                        supprimerBatimentButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                
                                if(menuDeroulantBatimentVille.getSelectionModel().getSelectedItem() != null){
                                    joueur.supprimerBatiment(memoireVille, (Batiment) menuDeroulantBatimentVille.getSelectionModel().getSelectedItem());
                                }
                                generateSimplePopUp("Félicitations!\nVotre bâtiment a été supprimé.", 350, 200);
                
                            }
                        });
                
                        backButtonGererVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                primaryStage.setScene(createScene("GERER LES VILLES", listGestionVilleButton, null, true, false,false, listeIdentite,-1,-1));                }
                        });

                gestionPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        primaryStage.setScene(createScene("GERER LES POSTES", listGestionPosteButton, null, false, true, false, listeIdentite,-1,1));                }
                });

                    //GERER LES POSTES : actions boutons
                    donnerNomPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            generateAskPopUp("Quel sera le nom de votre nouveau poste?", 350, 300);
                        }
                    });
            
                    creerPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            joueur.construirePoste(reponse);
                            creerPosteButton.setVisible(false);
                            creerVilleButton.setVisible(false);
                            generateSimplePopUp("Félicitations!\nVotre poste est en construction\nFaites retour pour actualiser votre liste.", 370, 220);
                        }
                    });
            
                    supprimerPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            joueur.supprimerPoste((Poste) menuDeroulantPoste.getSelectionModel().getSelectedItem());
                            generateSimplePopUp("Félicitations!\nVotre poste a été supprimé.", 250, 200 );
                        }
                    });
            
                    modifierPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            memoirePoste = (Poste)menuDeroulantPoste.getSelectionModel().getSelectedItem();
                            primaryStage.setScene(createScene("MENU MODIFICATION POSTE", listModifierPosteButton, null, false, false,false, listeIdentite, -1, menuDeroulantPoste.getItems().indexOf(menuDeroulantPoste.getSelectionModel().getSelectedItem())));
                        }
                    });
                    
                        //MODIFIER POSTE : actions boutons
                        ajouterMineButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
        
                            if(menuDeroulantMine.getSelectionModel().getSelectedItem() != null){
                                joueur.construireMinePoste(memoirePoste, (Mine) menuDeroulantMine.getSelectionModel().getSelectedItem());
                                generateSimplePopUp("Félicitations!\nVotre mine a été ajoutée.", 350, 200);
                            }
                            }
                        });
        
                        supprimerMineButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
            
                                if(menuDeroulantMinePoste.getSelectionModel().getSelectedItem() != null){
                                    joueur.supprimerMinePoste(memoirePoste, (Mine) menuDeroulantMinePoste.getSelectionModel().getSelectedItem());
                                    generateSimplePopUp("Félicitations!\nVotre mine a été supprimée.", 350, 200);
                                }
                            }
                        });
        
                        backButtonGererPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                primaryStage.setScene(createScene("GERER LES POSTES", listGestionPosteButton, null, false, true, false, listeIdentite,-1,1));
                            }
                        });
                        
        //MENU TECHNOLOGIES : actions boutons
        rechercherTechButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Technologie techno = (Technologie)menuDeroulantTechnologie.getSelectionModel().getSelectedItem();
                joueur.ameliorerTechnologie(getMemoireListeTechnologie(techno), techno);
                generateSimplePopUp("Félicitations!\nVotre recherche est en cours.", 350, 200);

            }
        });

        backButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false, false,listeIdentite,-1, -1));
            }
        });

        //MENU STATISTIQUES : actions boutons
        backButton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false,false, listeIdentite,-1, -1));
            }
        });
    }


    //LES FONCTIONS
    
    //FONCTION : Créer la scène d'acceuil (planète qui tourne)
    private Scene createMainScene() {
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(10000);
        camera.translateZProperty().set(-1000);

        startButton.setLayoutX(-48);
        startButton.setLayoutY(200);
        startButton.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-background-color: black;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 22;" +
                "-fx-border-radius: 80;" +
                "-fx-background-radius: 80;" +
                "-fx-border-color: #ebba71;"
        );

        registerButton.setLayoutX(-55);
        registerButton.setLayoutY(200);
        registerButton.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-background-color: black;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 22;" +
                "-fx-border-radius: 80;" +
                "-fx-background-radius: 80;" +
                "-fx-border-color: #ebba71;"
        );

        Group world = new Group();
        world.getChildren().add(prepareEarth());

        Group root = new Group();
        root.getChildren().add(world);
        root.getChildren().add(prepareImageView());
        root.getChildren().add(startButton);
        root.getChildren().add(registerButton);

        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        return scene;
    }


    //FONCTION : Générer une nouvelle scène
    Scene createScene (String name, ArrayList<Button> listButtons,ArrayList<Label> listLabels, boolean boolVille, boolean boolPoste, boolean boolTech, ArrayList<Label> listeIdentite, int indexVille, int indexPoste ){
        //Créer group root
        Group root = new Group();

        //root récupère le fond écran
        root.getChildren().add(setBackground());

        //Créer vbox principal et labels principaux
        VBox vbox = new VBox(50);
        Label labelMenu = new Label(name);//Label titre des menus
        labelMenu = designLabel(labelMenu); //Designer le label titre
        vbox.getChildren().add(labelMenu);//Ajouter le label titre à vbox
        //Configurer position et alignment de vbox
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(WIDTH/2-100);
        vbox.setLayoutY(50);

        //Créer un label argent/solde disponible
        Label labelArgent = new Label(name);
        labelArgent = designLabel(labelArgent); //Designer le label

        //Créer les labels identités (nomJoueur + nomPlanete)
        VBox vboxIdentite = new VBox();
        if (listeIdentite != null) {
            for (Label label : listeIdentite) {
                designLabelArgent(label);
                vboxIdentite.getChildren().add(label);//Ajouter à vboxIdentite
            }
            vboxIdentite.setLayoutX(30);
            vboxIdentite.setLayoutY(75);
        }

        //Créer les labels de vbox3
        VBox vbox3 = new VBox(10);
        if (listLabels != null) {
            for (Label label : listLabels) {
                designLabel(label);//Designer le boutton
                vbox3.getChildren().add(label);//Ajouter à vbox3
            }
        }
        //Configurer position et alignment de vbox3
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setLayoutX(350);
        vbox3.setLayoutY(250);

        //Créer les bouttons de la vbox
        if (listButtons != null) {
            for (Button button : listButtons) {
                designButton(button);//Designer le boutton
                setShadow(button);
                vbox.getChildren().add(button);//Ajouter à vbox
            }
        }

        //Créer la liste déroulante menuDeroulantVille
        if (boolVille) {
            this.menuDeroulantVille = new ComboBox();
            menuDeroulantVille.setPromptText("Villes");
            for (Ville ville : joueur.getPlanete().getVilles()) {
                menuDeroulantVille.getItems().add(ville);
            }
            root.getChildren().addAll(menuDeroulantVille);
            menuDeroulantVille = designCombox(menuDeroulantVille);
            menuDeroulantVille.setLayoutX(300);
            menuDeroulantVille.setLayoutY(250);
        }

        //Créer les listes déroulantes menuDeroulantBatiment et menuDeroulantBatimentVilles si nécessaires
        if(indexVille != -1) {
            //S'il y'a une ville de séléctionnée
            if (menuDeroulantVille.getSelectionModel().getSelectedItem() != null) {

                menuDeroulantBatiment = new ComboBox(); // comboBox des bâtiments construisables
                menuDeroulantBatimentVille = new ComboBox(); //comboBox des bâtiments actuels de notre ville

                menuDeroulantBatiment = designCombox(menuDeroulantBatiment); //Designer la comboBox
                menuDeroulantBatimentVille = designCombox(menuDeroulantBatimentVille); //Designer la comboBox

                //Position des comboBox
                menuDeroulantBatiment.setLayoutX(150);
                menuDeroulantBatiment.setLayoutY(250);

                menuDeroulantBatimentVille.setLayoutX(900);
                menuDeroulantBatimentVille.setLayoutY(250);

                //Ajout des batiments construits à notre liste des bâtiments de notre ville
                for (Batiment batiment : joueur.getPlanete().getVilles().get(indexVille).getBatiments()) {
                    menuDeroulantBatimentVille.getItems().add(batiment);
                }

                //Créer une liste de liste de liste des Technologies
                ArrayList<ArrayList<ArrayList<Technologie>>> listeTechnologies = new ArrayList<>() {
                    {
                        add(joueur.getTechnologieOxygene());
                        add(joueur.getTechnologieBiomasse());
                        add(joueur.getTechnologieEau());
                        add(joueur.getTechnologieTemperature());
                        add(joueur.getTechnologiePression());
                        add(joueur.getTechnologiePopulation());
                    }
                };

                //Ajout des bâtiments construisables dans notre liste déroulante
                for (ArrayList<ArrayList<Technologie>> liste : listeTechnologies){
                    for (ArrayList<Technologie> listeTechnologie : liste){
                        for (Technologie technologie : listeTechnologie){
                            if (technologie.isDebloquer()){
                                menuDeroulantBatiment.getItems().add(technologie.getBatiment());
                            }
                        }
                    }
                }

                root.getChildren().addAll(menuDeroulantBatiment);//
                root.getChildren().addAll(menuDeroulantBatimentVille);
            }
        }


        if(boolPoste){
            this.menuDeroulantPoste = new ComboBox();
            menuDeroulantPoste.setPromptText("Postes");
            for (Poste poste : joueur.getPlanete().getPostes()) {
                menuDeroulantPoste.getItems().add(poste);
            }
            root.getChildren().addAll(menuDeroulantPoste);
            menuDeroulantPoste = designCombox(menuDeroulantPoste);
            menuDeroulantPoste.setLayoutX(300);
            menuDeroulantPoste.setLayoutY(250);
        }

        if(indexPoste != -1) {
            if (menuDeroulantPoste.getSelectionModel().getSelectedItem() != null) {

                menuDeroulantMine = new ComboBox();
                menuDeroulantMinePoste = new ComboBox();

                menuDeroulantMine = designCombox(menuDeroulantMine);
                menuDeroulantMinePoste = designCombox(menuDeroulantMinePoste);

                menuDeroulantMine.setLayoutX(150);
                menuDeroulantMine.setLayoutY(250);

                menuDeroulantMinePoste.setLayoutX(900);
                menuDeroulantMinePoste.setLayoutY(250);

                for (Mine mine : joueur.getPlanete().getPostes().get(indexPoste).getMines()) {
                    menuDeroulantMinePoste.getItems().add(mine);
                }

                for (Technologie technologie : joueur.getTechnologieMine()){
                    if (technologie.isDebloquer()){
                        menuDeroulantMine.getItems().add(technologie.getMine());
                    }
                }

                root.getChildren().addAll(menuDeroulantMine);
                root.getChildren().addAll(menuDeroulantMinePoste);
            }
        }

        //Création menuDeoulantTechnologie
        if (boolTech){
            this.menuDeroulantTechnologie = new ComboBox();
            menuDeroulantTechnologie.setPromptText("Technologies");
            ArrayList<ArrayList<ArrayList<Technologie>>> listeTechnologies = new ArrayList<>() {
                {
                    add(joueur.getTechnologieOxygene());
                    add(joueur.getTechnologieBiomasse());
                    add(joueur.getTechnologieEau());
                    add(joueur.getTechnologieTemperature());
                    add(joueur.getTechnologiePression());
                    add(joueur.getTechnologiePopulation());
                }
            };

            for (ArrayList<ArrayList<Technologie>> liste : listeTechnologies){
                for (ArrayList<Technologie> listeTechnologie : liste){
                    for (Technologie technologie : listeTechnologie){
                        if (!technologie.isDebloquer() && joueur.estRecherchable(listeTechnologie) == listeTechnologie.indexOf(technologie)){
                            menuDeroulantTechnologie.getItems().add(technologie);
                        }
                    }
                }
            }

            //Ajout des technologies mines construisables à notre liste déroulante
            for(Technologie technologie : joueur.getTechnologieMine()){
                if (!technologie.isDebloquer() && joueur.estRecherchable(joueur.getTechnologieMine()) == joueur.getTechnologieMine().indexOf(technologie)){
                    menuDeroulantTechnologie.getItems().add(technologie.getMine());
                }
            }
            root.getChildren().addAll(menuDeroulantTechnologie); //Ajout du menu des technologies recherchables à root
            menuDeroulantTechnologie = designCombox(menuDeroulantTechnologie); //Designer la comboBox
            //Position de la comboBox
            menuDeroulantTechnologie.setLayoutX(300); 
            menuDeroulantTechnologie.setLayoutY(250);
        }

        //Ajouter les vboxs à root
        root.getChildren().addAll(vbox);
        root.getChildren().addAll(vboxIdentite);
        root.getChildren().addAll(vbox3);

        //Ajouter labelArgent
        root.getChildren().add(getLabelArgent(this.joueur.getArgent()));

        //Générer la nouvelle scène et la retourner
        scene = new Scene(root,WIDTH,HEIGHT);
        return scene;
    }

    //ECRAN D'ACCUEIL : Faire tourner la planète
    private void prepareAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                sphere.rotateProperty().set(sphere.getRotate() + 0.2);
            }
        };
        timer.start();
    }

    //ECRAN D'ACCUEIL : Ajouter le fond écran
    private ImageView prepareImageView() {
        Image image = new Image(getClass().getResourceAsStream("/resources/galaxy.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 700));
        return imageView;
    }

    //ECRAN D'ACCEUIL : Ajouter texture planète
    private Node prepareEarth() {
        PhongMaterial earthMaterial = new PhongMaterial();
        earthMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/resources/planet.jpg")));
        sphere.setRotationAxis(Rotate.Y_AXIS);
        sphere.setMaterial(earthMaterial);
        return sphere;
    }

    //Designer les boutons
    private Button designButton(Button button) {
        button.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-background-color: black;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 22;" +
                "-fx-border-radius: 80;" +
                "-fx-background-radius: 80;" +
                "-fx-border-color: #ebba71;"
        );
        setShadow(button);//Appel de la fonction d'ombre
        return button;
    }

    //Appliquer une ombre aux boutons
    public Button setShadow(Button button) {
        //Paramétrer le style de l'ombre
        shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setColor(Color.ROSYBROWN);
        shadow.setHeight(20);
        shadow.setWidth(20);
        shadow.setRadius(20);
        //Ajouter l'ombre
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        button.setEffect(shadow);
                    }
                });
        //Enlever l'ombre
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });
        return button;
    }

    //Designer les labels
    private Label designLabel(Label label) {
        label.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 25;"
        );
        return label;
    }

    //Designer le labelArgent
    private Label designLabelArgent(Label labelArgent) {
        labelArgent.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 20;"
        );
        return labelArgent;
    }

    //Ajouter le fond d'écran des sous-menus
    private ImageView setBackground() {
        final DoubleProperty zoomProperty = new SimpleDoubleProperty(200);
        Image image = new Image(getClass().getResourceAsStream("/resources/galaxy.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(zoomProperty.get() * 8);
        imageView.setFitHeight(zoomProperty.get() * 8);
        return imageView;
    }

    //Créer le label argent
    private Label getLabelArgent(int argent) {
        Label labelArgent = new Label();
        labelArgent.setText("SOLDE : " + String.valueOf(argent) + "c");
        labelArgent.setLayoutX(30);
        labelArgent.setLayoutY(48);
        designLabelArgent(labelArgent);
        return labelArgent;
    }

    //Créer la liste des statistiques de notre planète et des objectifs
    public void getListStats(){
        Label Oxygene = new Label();
        Oxygene.setText("Oxygène : " + joueur.getPlanete().getOxygene() + " -- Objectif : " + joueur.getObjectifOxygene());
        Label Temperature = new Label();
        Temperature.setText("Température : " + joueur.getPlanete().getTemperature() + " -- Objectif : " + joueur.getObjectifTemperature());
        Label Biomasse = new Label();
        Biomasse.setText("Biomasse : " + joueur.getPlanete().getBiomasse() + " -- Objectif : " + joueur.getObjectifBiomasse());
        Label Pression = new Label();
        Pression.setText("Pression : " + joueur.getPlanete().getPression() + " -- Objectif : " + joueur.getObjectifPression());
        Label Population  = new Label();
        Population.setText("Population : " + joueur.getPlanete().getPopulation() + " -- Objectif : " + joueur.getObjectifPopulation());
        Label Eau = new Label();
        Eau.setText("Eau : " + joueur.getPlanete().getEau() + " -- Objectif : " + joueur.getObjectifEau());

        this.listLabelsStatistiques = new ArrayList<>();
        this.listLabelsStatistiques.add(Oxygene);
        this.listLabelsStatistiques.add(Temperature);
        this.listLabelsStatistiques.add(Pression);
        this.listLabelsStatistiques.add(Biomasse);
        this.listLabelsStatistiques.add(Eau);
        this.listLabelsStatistiques.add(Population);
    }

    //Designer les comboBox
    public ComboBox designCombox (ComboBox comboBox){
        comboBox.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-background-color: black;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 22;" +
                "-fx-border-radius: 80;" +
                "-fx-background-radius: 80;" +
                "-fx-border-color: #ebba71;"
        );
        comboBox.setMaxWidth(200);
        return comboBox;
    }

    //Afficher une fenêtre PopUp simple
    public void generateSimplePopUp(String phrase, int width, int height){
        Stage newStage = new Stage();
        VBox comp = new VBox(30);
        Group root = new Group();

        Label label = new Label();
        label.setText(phrase);
        label.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15;");
        comp.getChildren().addAll(label);

        Button validerButton = new Button("Continuer");
        designButton(validerButton);
        comp.getChildren().addAll(validerButton);

        comp.setLayoutX(width/2 - 0.35*width);
        comp.setLayoutY(height/2 - 0.2*height);
        comp.setAlignment(Pos.CENTER);

        root.getChildren().addAll(comp);

        Scene stageScene = new Scene(root, width, height, Color.BLACK);
        newStage.setScene(stageScene);
        newStage.show();

        validerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                newStage.close();
            }
        });
    }


   //Afficher fenêtre PopUp demandant un retour utilisateur
    public void generateAskPopUp(String question, int width, int height){
        Stage newStage = new Stage();
        VBox comp = new VBox(30);
        Group root = new Group();

        Label label = new Label();
        label.setText(question);
        label.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15;");
        comp.getChildren().add(label);

        TextField input = new TextField();
        comp.getChildren().add(input);

        Button validerButton = new Button("VALIDER");
        designButton(validerButton);
        comp.getChildren().add(validerButton);

        comp.setLayoutX(30);
        comp.setLayoutY(30);
        comp.setAlignment(Pos.CENTER);
        root.getChildren().addAll(comp);


        Scene stageScene = new Scene(root, width, height, Color.BLACK);
        newStage.setScene(stageScene);
        newStage.show();

        validerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                reponse = input.getText();
                creerVilleButton.setVisible(true);
                creerPosteButton.setVisible(true);
                newStage.close();
            }
        });
    }

    //Générer une fenêtre PopUp à double entrées
    public void generateTwoAskPopUp(String questionPlanete, String questionJoueur ){
        Stage newStage = new Stage();
        VBox comp = new VBox(30);
        Group root = new Group();

        Label labelPlanete = new Label();
        labelPlanete.setText(questionPlanete);
        labelPlanete.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15;");
        comp.getChildren().add(labelPlanete);

        TextField inputPlanete = new TextField();
        comp.getChildren().add(inputPlanete);

        Label labelJoueur = new Label();
        labelJoueur.setText(questionJoueur);
        labelJoueur.setStyle("-fx-text-fill: #ebba71;" +
                "-fx-font-family: Courier New;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15;");
        comp.getChildren().add(labelJoueur);

        TextField inputJoueur = new TextField();
        comp.getChildren().add(inputJoueur);

        Button validerButton = new Button("VALIDER");
        designButton(validerButton);
        comp.getChildren().add(validerButton);

        comp.setLayoutX(30);
        comp.setLayoutY(30);
        comp.setAlignment(Pos.CENTER);

        root.getChildren().add(comp);

        Scene stageScene = new Scene(root, 300, 350, Color.BLACK);
        newStage.setScene(stageScene);
        newStage.show();

        validerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                nomJoueur.setText(inputJoueur.getText());
                nomPlanete.setText(inputPlanete.getText());
                newStage.close();

            }
        });
    }

    //Renvoie la liste dans laquelle se trouve la technologie séléctionnée par l'utilisateur
    public ArrayList<Technologie> getMemoireListeTechnologie(Technologie tech){
        ArrayList<ArrayList<ArrayList<Technologie>>> listeTechnologies = new ArrayList<>() {
            {
                add(joueur.getTechnologieOxygene());
                add(joueur.getTechnologieBiomasse());
                add(joueur.getTechnologieEau());
                add(joueur.getTechnologieTemperature());
                add(joueur.getTechnologiePression());
                add(joueur.getTechnologiePopulation());
            }
        };
        for (ArrayList<ArrayList<Technologie>> liste : listeTechnologies){
            for (ArrayList<Technologie> listeTechnologie : liste){
                for (Technologie technologie : listeTechnologie){
                    if(technologie.equals(tech)){
                        return listeTechnologie;
                    }

                }
            }
        }
        return null;
    }
}

