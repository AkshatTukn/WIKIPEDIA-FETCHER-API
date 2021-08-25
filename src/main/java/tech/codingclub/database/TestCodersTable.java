package tech.codingclub.database;

import tech.codingclub.entity.Coders;

public class TestCodersTable {

    public static void main(String[] args) {

        Coders shreyansh = new Coders("Shreyansh jain", 20L );
        //Insert this object into DB !
//       < ENTITY CLASS>
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS, shreyansh);
         //curd operation
    }
}
