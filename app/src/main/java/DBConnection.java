import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
public class DBConnection extends SQLiteOpenHelper {
    public static String DBName="MedicineReminder";
    SQLiteDatabase MedicineReminder;
    String UserTable="CREATE TABLE IF NOT EXISTS user"+
            "(name INTEGER NOT NULL , Age INTEGER , "+"gender TEXT , id INTEGER , PRIMARY  KEY(id));";
    String MedicineTable="CREATE TABLE IF NOT EXISTS medicine ("+
            "id INTEGER,"+
            "name	TEXT NOT NULL,"+
            "kind	TEXT NOT NULL,"+
            "startTime	TEXT NOT NULL,"+
            "duration	REAL,"+
            "endDate	TEXT,"+
            "dosage	  REAL,"+
            "dosageUnit	TEXT,"+
            "image BLOB,"+
            "note TEXT,"+
            "stock	REAL,"+
            "minmumStock	INTEGER,"+
            "acountId	INTEGER NOT NULL,"+
            "dayInWeak	TEXT,"+
            "dateOfChangeDosage 	TEXT, PRIMARY KEY(id)," +
            "FOREIGN KEY(acountId) REFERENCES user(id) ON DELETE SET NULL);";
    String ArchiveTable="CREATE TABLE IF NOT EXISTS Archive (" +
            "time TEXT," +
            "note TEXT," +
            "medicineID INTEGER," +
            "userId INTEGER," +
            "take INTEGER," +
            "intime INTEGER," +
            "FOREIGN KEY(medicineID) REFERENCES medicine(id) ON DELETE SET NULL," +
            "FOREIGN KEY(userId) REFERENCES user(id) ON DELETE SET NULL);";
    String Days="CREATE TABLE IF NOT EXISTS Days (" +
            "Date TEXT," +
            "medisineId INTEGER," +
            "FOREIGN KEY(medisineId) REFERENCES medicine(id) ON DELETE SET NULL" +
            ");";
    String Time="CREATE TABLE IF NOT EXISTS Time_hours (" +
            "time TEXT," +
            "medicineId INTEGER" +
            ");";
    public DBConnection(Context context) {
        super(context,DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserTable);
        sqLiteDatabase.execSQL(MedicineTable);
        sqLiteDatabase.execSQL(Days);
        sqLiteDatabase.execSQL(Time);
        sqLiteDatabase.execSQL(ArchiveTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists user");
        sqLiteDatabase.execSQL("Drop table if exists user");
        sqLiteDatabase.execSQL("Drop table if exists Days");
        sqLiteDatabase.execSQL("Drop table if exists Archive");
        sqLiteDatabase.execSQL("Drop table if exists Time_hourse");
        sqLiteDatabase.execSQL("Drop table if exists medicine");
        onCreate(sqLiteDatabase);
    }
    public void insertUser(String name, int age, String gender, int id) {

        ContentValues row = new ContentValues();
        row.put("name", name);
        row.put("Age", age);
        row.put("gender", gender);
        row.put("id", id);
        MedicineReminder = getWritableDatabase();
        MedicineReminder.insert("user", null, row);
        MedicineReminder.close();
    }

    public void insertMadicine(int id, String name, String kind, String startTime, float duration, String endDate,
                               float dosage, String dosageUnit, byte[] image, String note
            , float stock, int minmumStock, int acountId, String dayInWeak, String dateOfChangeDosage) {

        ContentValues row = new ContentValues();
        row.put("id", id);
        row.put("name", name);
        row.put("kind", kind);
        row.put("startTime", startTime);
        row.put("duration", duration);
        row.put("endDate", endDate);
        row.put("dosage", dosage);
        row.put("dosageUnit", dosageUnit);
        row.put("image", image);
        row.put("note", note);
        row.put("stock", stock);
        row.put("minmumStock", minmumStock);
        row.put("acountId", acountId);
        row.put("dayInWeak", dayInWeak);
        row.put("dateOfChangeDosage", dateOfChangeDosage);
        MedicineReminder = getWritableDatabase();
        MedicineReminder.insert("medicine", null, row);
        MedicineReminder.close();
    }

    public void insertArchive(String time, String note, int medicineID, int userId, int take, int intime) {

        ContentValues row = new ContentValues();
        row.put("time", time);
        row.put("note", note);
        row.put("medicineID", medicineID);
        row.put("userId", userId);
        row.put("take", take);
        row.put("intime", intime);
        MedicineReminder = getWritableDatabase();
        MedicineReminder.insert("Archive", null, row);
        MedicineReminder.close();
    }

    public void insertDays(String Date, int medisineId) {

        ContentValues row = new ContentValues();
        row.put("Date", Date);
        row.put("medisineId", medisineId);


        MedicineReminder = getWritableDatabase();
        MedicineReminder.insert("Days", null, row);
        MedicineReminder.close();
    }

    public void insertTime(String Time, int medicineId) {
        ContentValues row = new ContentValues();
        row.put("time", Time);
        row.put("medicineId", medicineId);
        MedicineReminder = getWritableDatabase();
        MedicineReminder.insert("Time_hours", null, row);
        MedicineReminder.close();

    }

    public void updateUser(int Oldid, int newid, String name, int age, String gender) {
        MedicineReminder = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("name", name);
        row.put("Age", age);
        row.put("gender", gender);
        row.put("id", newid);

        MedicineReminder.update("user", row, "id=" + Oldid, null);
        MedicineReminder.close();
    }

    public void updatemedicine(int Oldid, int id, String name, String kind, String startTime, float duration, String endDate,
                               float dosage, String dosageUnit, byte[] image, String note
            , float stock, int minmumStock, int acountId, String dayInWeak, String dateOfChangeDosage) {
        MedicineReminder = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("id", id);
        row.put("name", name);
        row.put("kind", kind);
        row.put("startTime", startTime);
        row.put("duration", duration);
        row.put("endDate", endDate);
        row.put("dosage", dosage);
        row.put("dosageUnit", dosageUnit);
        row.put("image", image);
        row.put("note", note);
        row.put("stock", stock);
        row.put("minmumStock", minmumStock);
        row.put("acountId", acountId);
        row.put("dayInWeak", dayInWeak);
        row.put("dateOfChangeDosage", dateOfChangeDosage);
        MedicineReminder = getWritableDatabase();
        MedicineReminder.update("medicine", row, "id=" + Oldid, null);
        MedicineReminder.close();
    }

    public void updateDays(String Date, int medisineId) {
        ContentValues row = new ContentValues();
        row.put("Date", Date);
        row.put("medisineId", medisineId);
        MedicineReminder = getWritableDatabase();
        MedicineReminder.update("Days", row, "medisineId=" + medisineId, null);
        MedicineReminder.close();
    }

    public void deleteUser(int Oldid) {
        MedicineReminder = getWritableDatabase();
        MedicineReminder.delete("user", "id='" + Oldid + "'", null);
        MedicineReminder.close();
    }

    public void deleteMedicine(int Oldid) {
        MedicineReminder = getWritableDatabase();
        MedicineReminder.delete("medicine", "id='" + Oldid + "'", null);
        MedicineReminder.close();
    }

    public void deleteDays(int medisineId) {
        MedicineReminder = getWritableDatabase();
        MedicineReminder.delete("medicine", "medicineId='" + medisineId + "'", null);
        MedicineReminder.close();
    }

    public void deleteTime(int medicineId) {
        MedicineReminder = getWritableDatabase();
        MedicineReminder.delete("medicine", "medicineId='" + medicineId + "'", null);
        MedicineReminder.close();

    }
}