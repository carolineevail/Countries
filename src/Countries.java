import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    public static HashMap<String, ArrayList<Country>> alphabeticalCountries = new HashMap<String, ArrayList<Country>>();

    public static void main(String[] args) throws Exception {
        readFile("countries.txt");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a letter to produce a list of country names beginning with that letter.");
        String selectedLetter = userInput.nextLine().toLowerCase().trim();
        if (selectedLetter.equals("")) {
            throw new Exception();
        }
        ArrayList<Country> usersCountries = alphabeticalCountries.get(selectedLetter);
        printArrayList(usersCountries);
        String fileName = selectedLetter + "_countries.txt";
        writeFile(fileName,arrayListToString(usersCountries));

    }

    static void printArrayList(ArrayList<Country> countriesToPrint) {
        for (int i = 0; i < countriesToPrint.size(); i++) {
            System.out.println(countriesToPrint.get(i));
        }

    }

    static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }

    static String arrayListToString (ArrayList<Country> countries) {
        StringBuilder resultingString = new StringBuilder();
        for (int i = 0; i < countries.size(); i++) {
            resultingString.append(countries.get(i));
            resultingString.append("\n");
        }
        return resultingString.toString();
    }

    static void readFile(String fileName) throws IOException {
        File f = new File(fileName);

        Scanner scanner = new Scanner(f);



        /*alphabeticalCountries.put("a", new ArrayList<Country>());
        alphabeticalCountries.put("b", new ArrayList<Country>());
        alphabeticalCountries.put("c", new ArrayList<Country>());
        alphabeticalCountries.put("d", new ArrayList<Country>());
        alphabeticalCountries.put("e", new ArrayList<Country>());
        alphabeticalCountries.put("f", new ArrayList<Country>());
        alphabeticalCountries.put("g", new ArrayList<Country>());
        alphabeticalCountries.put("h", new ArrayList<Country>());
        alphabeticalCountries.put("i", new ArrayList<Country>());
        alphabeticalCountries.put("j", new ArrayList<Country>());
        alphabeticalCountries.put("k", new ArrayList<Country>());
        alphabeticalCountries.put("l", new ArrayList<Country>());
        alphabeticalCountries.put("m", new ArrayList<Country>());
        alphabeticalCountries.put("n", new ArrayList<Country>());
        alphabeticalCountries.put("o", new ArrayList<Country>());
        alphabeticalCountries.put("p", new ArrayList<Country>());
        alphabeticalCountries.put("q", new ArrayList<Country>());
        alphabeticalCountries.put("r", new ArrayList<Country>());
        alphabeticalCountries.put("s", new ArrayList<Country>());
        alphabeticalCountries.put("t", new ArrayList<Country>());
        alphabeticalCountries.put("u", new ArrayList<Country>());
        alphabeticalCountries.put("v", new ArrayList<Country>());
        alphabeticalCountries.put("w", new ArrayList<Country>());
        alphabeticalCountries.put("x", new ArrayList<Country>());
        alphabeticalCountries.put("y", new ArrayList<Country>());
        alphabeticalCountries.put("z", new ArrayList<Country>());*/


        while (scanner.hasNext()) {
            String totalLine = scanner.nextLine();
            String countryName = totalLine.substring(3);
            String countryPrefix = totalLine.substring(0,2);
            Country country = new Country(countryName, countryPrefix);
            //alphabeticalCountries.get(countryName.substring(0, 1)).add(country);
            String firstLetter = String.valueOf(countryName.charAt(0));
            ArrayList<Country> list = alphabeticalCountries.get(firstLetter);
            if (list == null) {
                list = new ArrayList<>();
                alphabeticalCountries.put(firstLetter, list);
            }
            list.add(country);

        }

        //for (int i = 0; alphabeticalCountries.size() > i; i++); {
            //System.out.println(alphabeticalCountries);

        //}


    }


}



/*Description

Fork the Countries project. Parse each line and store the contents into a data structure.
Ask the user to type a letter and save a file that lists only the countries starting with it.

Requirements

Create a Country class to store both the name and abbreviation.
Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>>
    where the key is a single letter and the value is a list of countries whose names start
    with that letter.
Ask the user to type a letter (if they don't type a single letter, throw an exception).
Save an "X_countries.txt" file, where X is the letter they typed, which only lists the
    countries starting with that letter.
Optional tasks
Break your code into separate methods, especially the for loop that loops over each line
    in the file, and the code under it that reads the user's input and writes the file.
Encode the output as JSON instead of building a string manually. You should be able to
    take the ArrayList you pulled out of your HashMap and directly pass it to the serialize
    method. Remember to add getters to your Country class.
Override the toString method in your Country class so when you print your HashMap you can
    see the country abbreviations and names. Recall that, by default, Java prints out
    objects like this: Country@21345362.*/