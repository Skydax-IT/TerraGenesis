package menu;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MenuFrame {

    // Constructeur par défaut
    public MenuFrame() {
        this.WIDTH = 1200;
        this.HEIGHT = 600;

    }

    //Variables
    Scene scene;
    private int WIDTH;
    private int HEIGHT;
    DropShadow shadow = new DropShadow();
    private MenuController menuController;
    private Button startButton = new Button("START");
    private Button registerButton = new Button("REGISTER");
    private final Sphere sphere = new Sphere(170);
    int temperature = 0;
    int pression = 20;
    int oxygene = 40;
    int eau = 5;
    int biomasse = 45;
    int population = 100;
    String reponse = new String();
    Label nomJoueur = new Label();
    Label nomPlanete = new Label();


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
        Label Oxygene = new Label();
        Oxygene.setText("Oxygène : " + String.valueOf(oxygene));
        Label Temperature = new Label();
        Temperature.setText("Température : " + String.valueOf(temperature));
        Label Biomasse = new Label();
        Biomasse.setText("Biomasse : " + String.valueOf(biomasse));
        Label Pression = new Label();
        Pression.setText("Pression : " + String.valueOf(pression));

        Button backButton3 = new Button("RETOUR");

        ArrayList<Button> listStatsButtons = new ArrayList<>();
        listStatsButtons.add(backButton3);

        ArrayList<Label> listLabelsStats = new ArrayList<>();
        listLabelsStats.add(Oxygene);
        listLabelsStats.add(Temperature);
        listLabelsStats.add(Pression);
        listLabelsStats.add(Biomasse);

        //SCENE MENU>POPULATION>GESTION
        Button creerVilleButton = new Button("CREER UNE VILLE");
        Button supprimerVilleButton = new Button("SUPPRIMER UNE VILLE");
        Button backPopulationButton = new Button("RETOUR");

        ArrayList<Button> listGestionButton = new ArrayList<>();
        listGestionButton.add(creerVilleButton);
        listGestionButton.add(supprimerVilleButton);
        listGestionButton.add(backPopulationButton);

        ArrayList<Label> listeIdentite = new ArrayList<>();
        listeIdentite.add(nomJoueur);
        listeIdentite.add(nomPlanete);

        //MENU>POPULATION>GESTION
        String ville1 = new String("Ville1");
        String ville2 = new String("Ville2");

        ArrayList<String> listeVilles = new ArrayList<>();
        listeVilles.add(ville1);
        listeVilles.add(ville2);

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
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, null, listeIdentite));
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
                primaryStage.setScene(createScene("MENU POPULATION", listButtonPopulation, null, null, listeIdentite));
            }
        });

        techButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU TECHNOLOGIES", listButtonTech, null, null, listeIdentite));
            }
        });

        statsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("STATISTIQUES", listStatsButtons, listLabelsStats, null, listeIdentite));
            }
        });

        //MENU POPULATION
        gestionVilleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("GERER LES VILLES", listGestionButton, null, listeVilles, listeIdentite));                }
        });

        gestionPosteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //entrer une action ici
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, null, listeIdentite));
            }
        });

        //MENU POPULATION GESTION
        backPopulationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU POPULATION", listButtonPopulation, null, null, listeIdentite));                }
        });

            /*creerVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    listeVilles.add(creerVille(listeVilles));              }
            });

            supprimerVilleButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    supprimerVille(listeVilles);              }
            });*/

        //MENU TECHNOLOGIES
        ameliorerTechButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // entrer une action ici
            }
        });

        backButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, null, listeIdentite));
            }
        });

        //MENU STATISTIQUES
        backButton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene("MENU PRINCIPAL", listButton, null, null, listeIdentite));
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
    Scene createScene (String name, ArrayList<Button> listButtons, ArrayList<Label> listLabels, ArrayList<String> listStrings, ArrayList<Label> listeIdentite){
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
        ComboBox menuDeroulant = new ComboBox();


        // configurer l'alignment
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(WIDTH/2-100);
        vbox.setLayoutY(50);

        //Créer les labels
        if (listLabels != null) {
            for (Label label : listLabels) {
                designLabel(label);//Designer le boutton
                vbox.getChildren().add(label);//Ajouter à vbox
            }
        }

        //Créer les bouttons
        for (Button button : listButtons) {
            designButton(button);//Designer le boutton
            setShadow(button);
            vbox.getChildren().add(button);//Ajouter à vbox
        }

        //Créer la combo box menu déroulant
        if (listStrings != null) {
            for (String string : listStrings) {
                menuDeroulant.getItems().add(string);
            }
            root.getChildren().addAll(menuDeroulant);
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

        //Ajouter labelArgent
        root.getChildren().add(getLabelArgent(24000));

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

