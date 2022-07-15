package com.ironhack.tools;

import com.ironhack.Party;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import com.ironhack.ui.ConsoleColors;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class PartyDocuments {

    public static final String CSV_FILES_DIR = "files/";
    public static final String CSV_FILE_EXTENSION = ".csv";

    /**
     * takes a String partyName and a Party-Object party as arguments
     * and write the Characters of that Party-Object into a .csv document.
     * The document gets named after the fileName argument.
     *
     * @param party
     * @throws IOException
     */
    public static String writeToFile(Party party) throws IOException {
                        File file = new File(CSV_FILES_DIR + party.getName() + CSV_FILE_EXTENSION);

        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);

        // adding header to csv
        String[] header = {
                "characterType", // index 0
                "Name", // index 1
                "id", // index 2
                "hp", // index 3
                "mana", // index 5
                "intelligence", // index 6
                "stamina", // index 7
                "strength" // index 8
        };
        writer.writeNext(header);

        String[] data = new String[9];

        for (Character member : party.getMembers()) {
            data[0] = member instanceof Warrior ? "Warrior" : "Wizard";
            data[1] = member.getName();
            data[2] = member.getId();
            data[3] = String.valueOf(member.getHp());

            if (member instanceof Warrior) {
                data[4] = "";
                data[5] = "";
                data[6] = String.valueOf(((Warrior) member).getStamina());
                data[7] = String.valueOf(((Warrior) member).getStrength());
            }

            if (member instanceof Wizard) {
                data[4] = String.valueOf(((Wizard) member).getMana());
                data[5] = String.valueOf(((Wizard) member).getIntelligence());
                data[6] = "";
                data[7] = "";
            }

            writer.writeNext(data);
        }
        writer.close();
        outputfile.close();
        return file.getPath();
    }

    public static Party getPartyFromFile() {
        File file = new File(CSV_FILES_DIR);
        HashMap<Integer, String> files = new HashMap<>();
        Party party = null;

        if (file.exists()) {
            Scanner scanner = new Scanner(System.in);
            files = getFiles();
            System.out.println("What Party do you want to Copy? \nPlease enter Number: ");
            String fileName = "";

            try {
                fileName = files.get(scanner.nextInt());
                System.out.println("you selected: " + fileName);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            try {
                file = new File(CSV_FILES_DIR + fileName);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            FileReader filereader = null;
            try {
                party = new Party();
                party.setName(file.getName().replaceFirst(CSV_FILE_EXTENSION, ""));
                filereader = new FileReader(file);
                CSVReader csvReader = new CSVReader(filereader);

                String[] values;
                values = csvReader.readNext();

                while ((values = csvReader.readNext()) != null) {
                    Character member;

                    //in case of warrior:
                    if (values[0].equals("Warrior")) {
                        member = new Warrior(
                                values[1], //name
                                values[2], //id
                                Double.parseDouble(values[3]), //age
                                Integer.parseInt(values[6]), //stamina
                                Integer.parseInt(values[7])  //Strength
                        );

                        party.addCharacter(member);
                    }

                    // in case of wizard:
                    if (values[0].equals("Wizard")) {
                        member = new Wizard(
                                values[1], //name
                                values[2], //id
                                Double.parseDouble(values[3]), //age
                                Integer.parseInt(values[4]), //mana
                                Integer.parseInt(values[5])  //Intelligence
                        );
                        party.addCharacter(member);
                    }
                }
                filereader.close();
                csvReader.close();

            } catch (IOException | CsvValidationException ignored) {

            }
        } else {
            ConsoleColors.printWithColor("No files available", ConsoleColors.RED_BACKGROUND);
        }
        return party;
    }

    /**
     * Shows a list of all party documents available.
     */
    public static HashMap<Integer, String> getFiles() {
        File file = new File(CSV_FILES_DIR);
        HashMap<Integer, String> files = new HashMap<>();

        if (file.list().length == 0) {
            System.out.println("x - no parties have been saved - x");
        } else {
            System.out.println("following parties are available:");
            int i = 1;
            for (String s : file.list()) {
                files.put(i, s);
                System.out.println(i + " " + s);
                i++;
            }
        }
        return files;
    }

    /**
     * Takes a file name as argument and deletes that file
     *
     * @param fileName
     */
    public static void deleteFile(String fileName) {
        Path path = FileSystems.getDefault().getPath(CSV_FILES_DIR + fileName);
        try {
            Files.deleteIfExists(path);
            System.out.println("Following file has been deleted");
            System.out.println("- " + fileName);
        } catch (IOException x) {
            System.out.println(x);
        }
    }
}