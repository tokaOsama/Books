package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.magic.books.ModelList;

import java.util.ArrayList;


public class SQLite extends SQLiteOpenHelper {

    private static final String DATABASR_NAME = "bookStore" ;
    private static final int DATABASE_VERSION = 3 ;


    public SQLite(Context context) {

        //create Database
        super(context , DATABASR_NAME , null , DATABASE_VERSION);
    }

       //execute only one
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table books (id integer primary key AUTOINCREMENT, nameBook text , authorBook text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "drop table books" ;
        db.execSQL(sql);
        this.onCreate(db);
    }

    public  void addBook(String name,String author){

        SQLiteDatabase sqLiteDatabase =  getWritableDatabase();
        ContentValues  contentValues  = new ContentValues();
        contentValues.put("nameBook" , name);
        contentValues.put("authorBook" , author);
        sqLiteDatabase.insert("books" , null , contentValues);
    }

   public ArrayList<ModelList>  allBooks(){

        ArrayList<ModelList> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from books" , null);
        ModelList modelList ;
        if(cursor.moveToFirst()){
            do{
                modelList = new ModelList() ;
                modelList.setEdittext1(cursor.getString(1));
                modelList.setEdittext2(cursor.getString(2));
                arrayList.add(modelList);
            }while(cursor.moveToNext());

        }


        return arrayList ;
    }

}
