package displaylist.collectionbdclient.utils;

/**
 * Created by b.bassac on 21/03/2017.
 */

public class MockDemo {

    public String getMockManquante(){
        String mock="[\n" +
                "{\n" +
                "\"serieId\": 817,\n" +
                "\"bdid\": 6644,\n" +
                "\"serieName\": \"La licorne\",\n" +
                "\"numero\": \"HS1\",\n" +
                "\"titre\": \"Le Grimoire de La Licorne 12/2010\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6674,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"2\",\n" +
                "\"titre\": \"Pièges\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6675,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"3\",\n" +
                "\"titre\": \"Emprises\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6676,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"4\",\n" +
                "\"titre\": \"Expériences\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6677,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"5\",\n" +
                "\"titre\": \"Vestiges\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6678,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"6\",\n" +
                "\"titre\": \"Existences\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6679,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"7\",\n" +
                "\"titre\": \"Rencontres\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"serieId\": 825,\n" +
                "\"bdid\": 6680,\n" +
                "\"serieName\": \"Le chant des Stryges\",\n" +
                "\"numero\": \"8\",\n" +
                "\"titre\": \"Défis\",\n" +
                "\"editeur\": \"Delcourt\",\n" +
                "\"urlImage\": \"\"\n" +
                "}\n" +
                "]";
        return mock;
    }

    public String getMockDemoCollection(){
        String mock = "{\n" +
                "\t\"id\": 17,\n" +
                "\t\"listeSerie\": [{\n" +
                "\t\t\"id\": 814,\n" +
                "\t\t\"nom\": \"Arawn\",\n" +
                "\t\t\"fini\": false,\n" +
                "\t\t\"imageUrl\": \"\",\n" +
                "\t\t\"listPossede\": [{\n" +
                "\t\t\t\"id\": 6625,\n" +
                "\t\t\t\"titre\": \"Bran le Maudit\",\n" +
                "\t\t\t\"numero\": \"1\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6626,\n" +
                "\t\t\t\"titre\": \"Les liens du sang\",\n" +
                "\t\t\t\"numero\": \"2\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6627,\n" +
                "\t\t\t\"titre\": \"La Bataille de Cad Goddun\",\n" +
                "\t\t\t\"numero\": \"3\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6628,\n" +
                "\t\t\t\"titre\": \"Le chaudron de sang\",\n" +
                "\t\t\t\"numero\": \"4\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6629,\n" +
                "\t\t\t\"titre\": \"Résurrection\",\n" +
                "\t\t\t\"numero\": \"5\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6630,\n" +
                "\t\t\t\"titre\": \"La terre brulée\",\n" +
                "\t\t\t\"numero\": \"6\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t}],\n" +
                "\t\t\"listManquante\": [],\n" +
                "\t\t\"editeur\": \"Soleil Celtic\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": 819,\n" +
                "\t\t\"nom\": \"Chroniques de la guerre des Fees avec un titre super long\",\n" +
                "\t\t\"fini\": true,\n" +
                "\t\t\"imageUrl\": \"\",\n" +
                "\t\t\"listPossede\": [{\n" +
                "\t\t\t\"id\": 6659,\n" +
                "\t\t\t\"titre\": \"Dans la gueule du loup\",\n" +
                "\t\t\t\"numero\": \"1\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6660,\n" +
                "\t\t\t\"titre\": \"Aedlyn\",\n" +
                "\t\t\t\"numero\": \"2\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t}],\n" +
                "\t\t\"listManquante\": [],\n" +
                "\t\t\"editeur\": \"Soleil Celtic\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": 847,\n" +
                "\t\t\"nom\": \"Atalantes La légende\",\n" +
                "\t\t\"fini\": false,\n" +
                "\t\t\"imageUrl\": \"\",\n" +
                "\t\t\"listPossede\": [{\n" +
                "\t\t\t\"id\": 6893,\n" +
                "\t\t\t\"titre\": \"Le pacte\",\n" +
                "\t\t\t\"numero\": \"1\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6894,\n" +
                "\t\t\t\"titre\": \"Nautiliaa\",\n" +
                "\t\t\t\"numero\": \"2\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t}],\n" +
                "\t\t\"listManquante\": [{\n" +
                "\t\t\t\"id\": 6886,\n" +
                "\t\t\t\"titre\": \"Les mystères de Samothrace\",\n" +
                "\t\t\t\"numero\": \"3\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6887,\n" +
                "\t\t\t\"titre\": \"L'envol des Boréades\",\n" +
                "\t\t\t\"numero\": \"4\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6888,\n" +
                "\t\t\t\"titre\": \"Calaïs et Zétès\",\n" +
                "\t\t\t\"numero\": \"5\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6889,\n" +
                "\t\t\t\"titre\": \"Le labyrinthe d'Hadès \",\n" +
                "\t\t\t\"numero\": \"6\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6890,\n" +
                "\t\t\t\"titre\": \"Le Dernier des Grands Anciens\",\n" +
                "\t\t\t\"numero\": \"7\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6891,\n" +
                "\t\t\t\"titre\": \"Les Taureaux de Colchide\",\n" +
                "\t\t\t\"numero\": \"8\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6892,\n" +
                "\t\t\t\"titre\": \"Les amis d'Atalantes\",\n" +
                "\t\t\t\"numero\": \"HS 1\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t}],\n" +
                "\t\t\"editeur\": \"Soleil\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": 848,\n" +
                "\t\t\"nom\": \"Les 4 As\",\n" +
                "\t\t\"fini\": false,\n" +
                "\t\t\"imageUrl\": \"\",\n" +
                "\t\t\"listPossede\": [{\n" +
                "\t\t\t\"id\": 6920,\n" +
                "\t\t\t\"titre\": \"La Saucisse volante\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6921,\n" +
                "\t\t\t\"titre\": \"Le diamant bleu\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6922,\n" +
                "\t\t\t\"titre\": \"Le magicien\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6923,\n" +
                "\t\t\t\"titre\": \"et la bombe F\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6924,\n" +
                "\t\t\t\"titre\": \"Hold up big bank\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6925,\n" +
                "\t\t\t\"titre\": \"Et le couroucoucou\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6926,\n" +
                "\t\t\t\"titre\": \"Le chateau malefique\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6927,\n" +
                "\t\t\t\"titre\": \"La licorne\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6928,\n" +
                "\t\t\t\"titre\": \"L'atlantide\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6929,\n" +
                "\t\t\t\"titre\": \"La ruee vers l'or\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6930,\n" +
                "\t\t\t\"titre\": \"Le visiteur de minuit\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6931,\n" +
                "\t\t\t\"titre\": \"Le secret de la montagne\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6932,\n" +
                "\t\t\t\"titre\": \"Le serpent de mer\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6933,\n" +
                "\t\t\t\"titre\": \"Les 4 as et la vache sacree\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6934,\n" +
                "\t\t\t\"titre\": \"Les 4 as et la coupe d'or\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6935,\n" +
                "\t\t\t\"titre\": \"Les 4 as et l'île du robinson\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6936,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le gang des chapeaux blancs\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6937,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le vaisseau fantôme\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t}],\n" +
                "\t\t\"listManquante\": [{\n" +
                "\t\t\t\"id\": 6895,\n" +
                "\t\t\t\"titre\": \"Les 4 as et l'aeroglisseur\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6896,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le dragon des neiges\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6897,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le rallye olympique\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6898,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le tyran\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6899,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le Picasso vole\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6900,\n" +
                "\t\t\t\"titre\": \"Les 4 as et l'iceberg\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6901,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le tresor des tsars\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6902,\n" +
                "\t\t\t\"titre\": \"Les 4 as et la deesse des mers\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6903,\n" +
                "\t\t\t\"titre\": \"Les 4 as et la navette spatiale\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6904,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le requin geant\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6905,\n" +
                "\t\t\t\"titre\": \"Les 4 as et l'empire cache\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6906,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le mystere de la jungle\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6907,\n" +
                "\t\t\t\"titre\": \"Les 4 as et les extraterrestres\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6908,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le fantôme du Mont Saint-Michel\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6909,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le robot vandale\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6910,\n" +
                "\t\t\t\"titre\": \"Les 4 as et les sorcieres\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6911,\n" +
                "\t\t\t\"titre\": \"Les 4 as et les dinosaures\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6912,\n" +
                "\t\t\t\"titre\": \"Les 4 as et la momie\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6913,\n" +
                "\t\t\t\"titre\": \"Les 4 as et les fantômes\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6914,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le monstre des oceans\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6915,\n" +
                "\t\t\t\"titre\": \"Les 4 As et Halloween\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6916,\n" +
                "\t\t\t\"titre\": \"Le loup de Tasmanie\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6917,\n" +
                "\t\t\t\"titre\": \"Les 4 as et le grand supreme\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6918,\n" +
                "\t\t\t\"titre\": \"Mission Mars\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 6919,\n" +
                "\t\t\t\"titre\": \"La balade des 4 as\",\n" +
                "\t\t\t\"numero\": \"\",\n" +
                "\t\t\t\"couvertureUrl\": \"\"\n" +
                "\t\t}],\n" +
                "\t\t\"editeur\": \"Casterman\"\n" +
                "\t}\n" +
                "]\n" +
                "}";

        return mock;
    }
}
