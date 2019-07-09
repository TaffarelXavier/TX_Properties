package TX_Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Propriedades {

    public static String filePath = "";

    /**
     *
     * @return <p style="font:16px arial">O Caminho do arquivo.</p>
     */
    public static String getFilePath() {
        return filePath;
    }

    /**
     *
     * @param filePath <p style="font:16px arial">Define o caminho do
     * arquivo.</p>
     */
    public static void setFilePath(String filePath) {
        Propriedades.filePath = filePath;
    }

    /**
     *
     * Exemplo:
     *
     * Map<String, String> example =
     * Propriedades.readPropertiesFile("src\\config\\config.properties");
     * example.keySet().forEach((key) -> { //Capturamos o valor a partir da
     * chave String value = example.get(key); System.out.println(key + " = " +
     * value); });
     *
     * @return
     * @throws Exception
     *
     */
    public static Map<String, String> readAllPropertiesFile() throws Exception {

        Map<String, String> properties = new HashMap<>();

        Properties props = new Properties();

        props.load(new FileInputStream(new File(getFilePath())));

        props.forEach((key, value) -> {

            properties.put(key.toString(), value.toString());

        });

        return properties;

    }

    /**
     * <p>
     * Lê todas propriedades e seus respectivos valores.</p>
     */
    public static void readPropertiesFileDois() {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            properties.stringPropertyNames().forEach((key) -> {

                String value = properties.getProperty(key);

            });

            properties.forEach((key, value) -> {

                properties.put(key.toString(), value.toString());

            });

        } catch (IOException e) {

        }

    }

    /**
     * <p>
     * Verifica se uma chave existe</p>
     *
     * @param key
     * @return
     */
    public static boolean keyExists(String key) {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            return properties.getProperty(key) != null;

        } catch (IOException e) {

        }

        return false;

    }

    /**
     *
     * @param newKey <p style="font:16px arial">A nova chave</p>
     * @param newValue <p style="font:16px arial">O novo valor</p>
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void addItem(String newKey, String newValue) throws FileNotFoundException, IOException {

        Properties prop1 = new Properties();

        prop1.load(new java.io.FileInputStream(getFilePath()));

        Properties prop2 = new Properties();

        prop1.load(new java.io.FileInputStream(getFilePath()));

        File f = new File(filePath);

        for (String key : prop1.stringPropertyNames()) {

            String value = prop1.getProperty(key);

            prop2.setProperty(key, value);

        }

        prop2.setProperty(newKey, newValue);

        OutputStream out = new FileOutputStream(f);

        prop2.store(out, "Arquivo de configuração da classe de Propriedade Java.");

    }

    /**
     * @param key <p style="font:16px arial">A chave para procurar</p>
     * @return
     */
    public static String getProp(String key) {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            return keyExists(key) ? properties.getProperty(key) : "";

        } catch (IOException e) {

        }

        return null;

    }

}
