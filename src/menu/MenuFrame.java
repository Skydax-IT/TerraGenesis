package menu;
import batiments.Batiment;
import batiments.Mine;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Callback;
import jeu.Joueur;
import planete.*;
import technologies.Technologie;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MenuFrame {

    // Constructeur par défaut
    public MenuFrame(Joueur j1) {
        this.WIDTH = 1200;
        this.HEIGHT = 600;
        this.joueur = j1;

    }

    //Variables
    Scene scene;
    private int WIDTH;
    private int HEIGHT;
    DropShadow shadow = new DropShadow();
    private Button startButton = new Button("START");
    private Button registerButton = new Button("REGISTER");
    private final Sphere sphere = new Sphere(170);
    String reponse = new String();
    Label nomJoueur = new Label();
    Label nomPlanete = new Label();
    Joueur joueur;
    ComboBox menuDeroulantVille;
    ComboBox menuDeroulantPoste;
    ComboBox menuDeroulantBatimentVille = new ComboBox();
    ComboBox menuDeroulantBatiment = new ComboBox();
    ComboBox menuDeroulantMinePoste = new ComboBox();
    ComboBox menuDeroulantMine = new ComboBox();
    ComboBox menuDeroulantTechnologie = new ComboBox();
    Ville memoireVille;
    Poste memoirePoste;
    ArrayList<Label> listLabelsStatistiques;

    public void start(Stage primaryStage) {

        startButton.setVisible(false);

        //SCENE ACCUEIL
        primaryStage.setScene(createMainScene());
        primaryStage.setTitle("TerraGenesis");
        primaryStage.show();

        prepareAnimation();

        //SCENE MENU
        Button populationButton = new Button("POPULATION");
        Button techButton = new Button("TECHNOLOGIES");
        Button statsButton = new Button("STATISTIQUES");
        Button exitButton = new Button("QUITTER");

        ArrayList<Button> listButton = new ArrayList<>();
        listButton.add(populationButton);
        listButton.add(techButton);
        listButton.add(statsButton);
        listButton.add(exitButton);

        //SCENE MENU>POPULATION
        Button gestionVilleButton = new Button("GÉRER VILLES");
        Button gestionPosteButton = new Button("GÉRER POSTES");
        Button backButton = new Button("RETOUR");

        ArrayList<Button> listButtonPopulation = new ArrayList<>();
        listButtonPopulation.add(gestionVilleButton);
        listButtonPopulation.add(gestionPosteButton);
        listButtonPopulation.add(backButton);

        //SCENE MENU>TECHNOLOGIES
        Button ameliorerTechButton = new Button("AMELIORER");
        Button backButton2 = new Button("RETOUR");

        ArrayList<Button> listButtonTech = new ArrayList<>();
        listButtonTech.add(ameliorerTechButton);
        listButtonTech.add(backButton2);

        //SCENE MENU>STATISTIQUES
        Button backButton3 = new Button("RETOUR");

        ArrayList<Button> listStatsButtons = new ArrayList<>();
        listStatsButtons.add(backButton3);

        //SCENE MENU>POPULATION>GESTION VILLE
        Button creerVilleButton = new Button("CREER UNE VILLE");
        Button supprimerVilleButton = new Button("SUPPRIMER UNE VILLE");
        Button modifierVilleButton = new Button("MODIFIER LA VILLE");

        Button backPopulationButton = new Button("RETOUR");

        ArrayList<Button> listGestionVilleButton = new ArrayList<>();
        listGestionVilleButton.add(creerVilleButton);
        listGestionVilleButton.add(supprimerVilleButton);
        listGestionVilleButton.add(modifierVilleButton);
        listGestionVilleButton.add(backPopulationButton);

        ArrayList<Label> listeIdentite = new ArrayList<>();
        listeIdentite.add(nomJoueur);
        listeIdentite.add(nomPlanete);

            //SCENE MENU>POPULATION>GESTION VILLE
            Button ajouterBatimentButton = new Button("AJOUTER UN BATIMENT");
            Button supprimerBatimentButton = new Button("SUPPRIMER UN BATIMENT");
            Button backButtonGererVilleButton = new Button("RETOUR");

            ArrayList<Button> listModifierVilleButton = new ArrayList<>();
            listModifierVilleButton.add(ajouterBatimentButton);
            listModifierVilleButton.add(supprimerBatimentButton);
            listModifierVilleButton.add(backButtonGererVilleButton);

            //SCENE MENU>POPULATION>GESTION VILLE
            Button ajouterMineButton = new Button("AJOUTER UNE MINE");
            Button supprimerMineButton = new Button("SUPPRIMER UNE MINE");
            Button backButtonGererPosteButton = new Button("RETOUR");

            ArrayList<Button> listModifierPosteButton = new ArrayList<>();
            listModifierPosteButton.add(ajouterMineButton);
            listModifierPosteButton.add(supprimerMineButton);
            listModifierPosteButton.add(backButtonGererPosteButton);

        //SCENE MENU>POPULATION>GESTION POSTE
        Button creerPosteButton = new Button("CREER UN POSTE");
        Button supprimerPosteButton = new Button("SUPPRIMER UN POSTE");
        Button modifierPosteButton = new Button("MODIFIER LE POSTE");


        ArrayList<Button> listGestionPosteButton = new ArrayList<>();
        listGestionPosteButton.add(creerPosteButton);
        listGestionPosteButton.add(supprimerPosteButton);
        listGestionPosteButton.add(modifierPosteButton);
        listGestionPosteButton.add(backPopulationButton);

        

        // ACTION BUTTONS

        //MENU ACCUEIL
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                generatePopUpWindow("Votre nom de planète?", "Votre nom de joueur?");
                startButton.setVisible(true);
                registerButton.setVisible(false);
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false, false, listeIdentite, -1, -1));
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(1);
            }
        });

        //MENU PRINCIPAL
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
            }
        });

        //MENU POPULATION
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

        gestionPosteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("GERER LES POSTES", listGestionPosteButton, null, false, true, false, listeIdentite,-1,1));                }
        });

            //MENU POPULATION GERER POSTE

            creerPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    joueur.construirePoste();              }
            });

            supprimerPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    joueur.supprimerPoste((Poste) menuDeroulantPoste.getSelectionModel().getSelectedItem());
                }
            });

            modifierPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    memoirePoste = (Poste)menuDeroulantPoste.getSelectionModel().getSelectedItem();
                    primaryStage.setScene(createScene("MENU MODIFICATION POSTE", listModifierPosteButton, null, false, false,false, listeIdentite, -1, menuDeroulantPoste.getItems().indexOf(menuDeroulantPoste.getSelectionModel().getSelectedItem())));
                }
            });

                //Modifier le poste
                ajouterMineButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    if(menuDeroulantMine.getSelectionModel().getSelectedItem() != null){
                        joueur.construireMinePoste(memoirePoste, (Mine) menuDeroulantMine.getSelectionModel().getSelectedItem());
                    }
                }
            });

            supprimerMineButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    if(menuDeroulantMinePoste.getSelectionModel().getSelectedItem() != null){
                        joueur.supprimerMinePoste(memoirePoste, (Mine) menuDeroulantMinePoste.getSelectionModel().getSelectedItem());
                    }
                }
            });

            backButtonGererPosteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    primaryStage.setScene(createScene("GERER LES POSTES", listGestionPosteButton, null, false, true, false, listeIdentite,-1,1));
                }
            });




        //MENU POPULATION GESTION
        backPopulationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU POPULATION", listButtonPopulation, null, false, false,false, listeIdentite,-1,-1));                }
        });

            creerVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    joueur.constuireVille();              }
            });

            supprimerVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    joueur.supprimerVille((Ville) menuDeroulantVille.getSelectionModel().getSelectedItem());
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
                    }
                });

            supprimerBatimentButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    if(menuDeroulantBatimentVille.getSelectionModel().getSelectedItem() != null){
                        joueur.supprimerBatiment(memoireVille, (Batiment) menuDeroulantBatimentVille.getSelectionModel().getSelectedItem());
                    }
                }
            });

                backButtonGererVilleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("GERER LES VILLES", listGestionVilleButton, null, true, false,false, listeIdentite,-1,-1));                }
        });


        //MENU TECHNOLOGIES
        ameliorerTechButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                joueur.ameliorerTechnologie((Technologie)menuDeroulantTechnologie.getSelectionModel().getSelectedItem());
            }
        });

        backButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false, false,listeIdentite,-1, -1));
            }
        });

        //MENU STATISTIQUES
        backButton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, false, false,false, listeIdentite,-1, -1));
            }
        });
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

    //Créer la scène d'acceuil (planète qui tourne)
    private Scene createMainScene() {
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(10000);
        camera.translateZProperty().set(-1000);

        startButton.setLayoutX(-48);
        startButton.setLayoutY(200);
        designButton(startButton);

        registerButton.setLayoutX(-55);
        registerButton.setLayoutY(200);
        designButton(registerButton);

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

    //Faire tourner la planète
    private void prepareAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                sphere.rotateProperty().set(sphere.getRotate() + 0.2);
            }
        };
        timer.start();
    }

    //Ajouter le fond écran menu d'accueil
    private ImageView prepareImageView() {
        Image image = new Image(getClass().getResourceAsStream("/resources/galaxy.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 700));
        return imageView;
    }

    //Ajouter texture planète
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

    //Générer une nouvelle scène
    Scene createScene (String name, ArrayList<Button> listButtons,ArrayList<Label> listLabels, boolean bool, boolean bool2, boolean boolTech, ArrayList<Label> listeIdentite, int indexVille, int indexPoste ){
        //Créer group root
        Group root = new Group();

        //root récupère le fond écran
        root.getChildren().add(setBackground());

        //Créer vbox des labels principaux
        VBox vbox = new VBox(50);
        Label labelMenu = new Label(name);
        labelMenu = designLabel(labelMenu); //Designer le label principal
        vbox.getChildren().add(labelMenu);//Ajouter le label principal
        Label labelArgent = new Label(name);
        labelArgent = designLabel(labelArgent); //Designer le label principal


        // configurer l'alignment
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(WIDTH/2-100);
        vbox.setLayoutY(50);

        //Créer les labels
        VBox vbox3 = new VBox(10);
        if (listLabels != null) {
            for (Label label : listLabels) {
                designLabel(label);//Designer le boutton
                vbox3.getChildren().add(label);//Ajouter à vbox
            }
        }

        // configurer l'alignment
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setLayoutX(350);
        vbox3.setLayoutY(250);

        //Créer les bouttons
        if (listButtons != null) {
            for (Button button : listButtons) {
                designButton(button);//Designer le boutton
                setShadow(button);
                vbox.getChildren().add(button);//Ajouter à vbox
            }
        }

        //Créer la combo box menu déroulant Ville et Batiment
        if (bool) {
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

        if(indexVille != -1) {
            if (menuDeroulantVille.getSelectionModel().getSelectedItem() != null) {

                menuDeroulantBatiment = new ComboBox();
                menuDeroulantBatimentVille = new ComboBox();

                menuDeroulantBatiment = designCombox(menuDeroulantBatiment);
                menuDeroulantBatimentVille = designCombox(menuDeroulantBatimentVille);

                menuDeroulantBatiment.setLayoutX(150);
                menuDeroulantBatiment.setLayoutY(250);

                menuDeroulantBatimentVille.setLayoutX(900);
                menuDeroulantBatimentVille.setLayoutY(250);

                for (Batiment batiment : joueur.getPlanete().getVilles().get(indexVille).getBatiments()) {
                    menuDeroulantBatimentVille.getItems().add(batiment);
                }
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
                            if (technologie.isDebloquer()){
                                menuDeroulantBatiment.getItems().add(technologie.getBatiment());
                            }
                        }
                    }
                }
                root.getChildren().addAll(menuDeroulantBatiment);
                root.getChildren().addAll(menuDeroulantBatimentVille);
            }
        }


        if(bool2){
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
                        if (!technologie.isDebloquer()){
                            menuDeroulantTechnologie.getItems().add(technologie);
                        }
                    }
                }
            }
            root.getChildren().addAll(menuDeroulantTechnologie);
            menuDeroulantTechnologie = designCombox(menuDeroulantTechnologie);
            menuDeroulantTechnologie.setLayoutX(300);
            menuDeroulantTechnologie.setLayoutY(250);
        }

        //Créer les labels identités
        VBox vbox2 = new VBox();
        if (listeIdentite != null) {
            for (Label label : listeIdentite) {
                designLabelArgent(label);
                vbox2.getChildren().add(label);//Ajouter à vbox2
            }
            vbox2.setLayoutX(30);
            vbox2.setLayoutY(75);
        }

        //Ajouter vbox à root
        root.getChildren().addAll(vbox);
        root.getChildren().addAll(vbox2);
        root.getChildren().addAll(vbox3);



        //Ajouter labelArgent
        root.getChildren().add(getLabelArgent(this.joueur.getArgent()));

        //Générer la nouvelle scène et la retourner
        scene = new Scene(root,WIDTH,HEIGHT);
        return scene;
    }

    private Label getLabelArgent(int argent) {
        Label labelArgent = new Label();
        labelArgent.setText("SOLDE : " + String.valueOf(argent) + "c");
        labelArgent.setLayoutX(30);
        labelArgent.setLayoutY(48);
        designLabelArgent(labelArgent);
        return labelArgent;
    }
    
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
        /*comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(item);
                        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                        setTextFill(Color.BLUE);
                    }
                };
            }
        });*/
        return comboBox;
    }
    

    public void afficherPopUp(String phrase){
        Stage newStage = new Stage();
        VBox comp = new VBox(30);

        Label label = new Label();
        label.setText(phrase);
        comp.getChildren().add(label);

        TextField input = new TextField();
        comp.getChildren().add(input);

        Button validerButton = new Button("VALIDER");
        comp.getChildren().add(validerButton);

        comp.setAlignment(Pos.CENTER);

        Scene stageScene = new Scene(comp, 200, 300);
        newStage.setScene(stageScene);
        newStage.show();

        validerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                newStage.close();
            }
        });
    }

    public void generateAnswerPopUpWindow(String question){
        Stage newStage = new Stage();
        VBox comp = new VBox(30);

        Label label = new Label();
        label.setText(question);
        comp.getChildren().add(label);

        TextField input = new TextField();
        comp.getChildren().add(input);

        Button validerButton = new Button("VALIDER");
        comp.getChildren().add(validerButton);

        comp.setAlignment(Pos.CENTER);

        Scene stageScene = new Scene(comp, 200, 300);
        newStage.setScene(stageScene);
        newStage.show();

        validerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                reponse = input.getText();
                newStage.close();
            }
        });
    }

    public void generatePopUpWindow(String questionPlanete, String questionJoueur ){
        Stage newStage = new Stage();
        VBox comp = new VBox(30);

        Label labelPlanete = new Label();
        labelPlanete.setText(questionPlanete);
        comp.getChildren().add(labelPlanete);

        TextField inputPlanete = new TextField();
        comp.getChildren().add(inputPlanete);

        Label labelJoueur = new Label();
        labelJoueur.setText(questionJoueur);
        comp.getChildren().add(labelJoueur);

        TextField inputJoueur = new TextField();
        comp.getChildren().add(inputJoueur);

        Button validerButton = new Button("VALIDER");
        comp.getChildren().add(validerButton);

        comp.setAlignment(Pos.CENTER);

        Scene stageScene = new Scene(comp, 200, 300);
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
}
   /* private ArrayList<String> supprimerVille(ArrayList<String> listeVilles) {
        //R
    }
    private String creerVille(ArrayList<String> listeVilles) {
        //R
    }*/

