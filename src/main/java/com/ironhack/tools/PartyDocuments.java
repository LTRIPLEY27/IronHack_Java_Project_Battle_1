package com.ironhack.tools;

import com.ironhack.Party;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class PartyDocuments {

    /** takes a String partyName and a Party-Object party as arguments
     * and write the Characters of that Party-Object into a .csv document.
     * The document gets named after the fileName argument.
     * @param partyName
     * @param party
     * @throws IOException
     */
    public static void writeToFile(String partyName, Party party) throws IOException {
        File file = new File("src/main/java/com/ironhack/files/"+partyName);
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);

        // adding header to csv
        String[] header = {
                "characterType", // index 0
                "Name", // index 1
                "id", // index 2
                "hp", // index 3
                "isAlive", // index 4
                "mana", // index 5
                "intelligence", // index 6
                "stamina", // index 7
                "strength" // index 8
        };
        writer.writeNext(header);

        String[] data = new String[9];

        for (Character member: party.getMembers()){
            data[0] = member instanceof Warrior? "Warrior": "Wizard";
            data[1] = member.getName();
            data[2] = member.getId();
            data[3] = String.valueOf(member.getHp());
            data[4] = String.valueOf(member.isAlive());
            data[5] = member instanceof Warrior? String.valueOf(((Warrior) member).getStamina()):"";
            data[6] = member instanceof Warrior? String.valueOf(((Warrior) member).getStrength()):"";
            data[7] = member instanceof Wizard? String.valueOf(((Wizard) member).getMana()):"";
            data[8] = member instanceof Wizard? String.valueOf(((Wizard) member).getIntelligence()):"";

            writer.writeNext(data);
        }
        writer.close();
    }

    /**
     * Takes a String partyName as argument and looks for a document
     * with that name. If the file exists, getPartyFromFile returns a
     * Party object from that document.
     * @param  partyName (the name of the document)
     * @return Party Object
     * @throws IOException
     * @throws CsvValidationException
     */
    public static Party getPartyFromFile (String partyName) throws IOException, CsvValidationException {
        Party party = new Party();
        File file = new File("src/main/java/com/ironhack/files/" + partyName);

        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReader(filereader);

        String[] values;

        values = csvReader.readNext();

        while ((values = csvReader.readNext()) != null) {
            Character member;
            //in case of warrior:
           if (values[0] == "Warrior"){
               member = new Warrior(
                       values[1], //name
                       values[2], //id
                       Double.parseDouble(values[3]), //age
                       Integer.parseInt(values[7]), //stamina
                       Integer.parseInt(values[8])); //Strength

               party.addCharacter(member);
           }

           // in case of wizard:
            if (values[0] == "Wizard"){
                member = new Wizard(
                        values[1], //name
                        values[2], //id
                        Double.parseDouble(values[3]), //age
                        Integer.parseInt(values[5]), //mana
                        Integer.parseInt(values[6])); //Intelligence
                party.addCharacter(member);
            }
        }
        return party;
    }

    /**
     * Shows a list of all party documents available.
     */
    public static void showFiles(){
        File file = new File("src/main/java/com/ironhack/files");
        if(file.list().length == 0){
            System.out.println("no parties have been saved:");
        }else{
            System.out.println("following parties have been saved:");
            for(String s: file.list()){
                System.out.println("+ "+s);
            }
        }
    }

    /**
     * Takes a file name as argument and deletes that file
     * @param fileName
     */
    public static void deleteFile(String fileName){
        Path path = FileSystems.getDefault().getPath("src/main/java/com/ironhack/files/"+fileName);
        try {
            Files.deleteIfExists(path);
            System.out.println("Following file has been deleted");
            System.out.println("- "+fileName);
        } catch (IOException x) {
            System.out.println(x);
        }
    }
}
