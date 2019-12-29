import db.DatabaseHelper;
import db.Entity;
import lombok.SneakyThrows;

import static db.DatabaseContract.TABLE_NAME;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        DatabaseHelper databaseHelper = new DatabaseHelper();

        for (Entity entity : databaseHelper.query("select * from " + TABLE_NAME)) {
            System.out.println(entity.getId());
            System.out.println(entity.getName());
        }
    }
}
