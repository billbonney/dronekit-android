package org.droidplanner.services.android.databases;

import android.content.Context;
import android.provider.BaseColumns;

import java.io.File;

/**
 * Defines the schema for the Session database.
 */
public final class SessionContract {

    private static final String DB_NAME = "session";
    public static final int DB_VERSION = 1;

    //Private constructor to prevent instantiation.
    private SessionContract(){}

    public static String getDbPath(Context context){
        File externalDir = context.getExternalFilesDir(null);
        if(externalDir == null)
            return DB_NAME;

        return externalDir.getAbsolutePath() + "/db/" + DB_NAME;
    }

    public static String getSqlCreateEntries(){
        return SessionData.SQL_CREATE_ENTRIES;
    }

    public static String getSqlDeleteEntries(){
        return SessionData.SQL_DELETE_ENTRIES;
    }

    /**
     * Defines the schema for the SessionData table.
     */
    public static final class SessionData implements BaseColumns {
        public static final String TABLE_NAME = "session_data";

        public static final String COLUMN_NAME_START_TIME ="start_time";
        public static final String COLUMN_NAME_END_TIME = "end_time";
        public static final String COLUMN_NAME_CONNECTION_TYPE = "connection_type";
        public static final String COLUMN_NAME_DSHARE_UPLOAD_TIME = "dshare_upload_time";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_START_TIME + " INTEGER NOT NULL," +
                        COLUMN_NAME_END_TIME + " INTEGER," +
                        COLUMN_NAME_CONNECTION_TYPE + " TEXT," +
                        COLUMN_NAME_DSHARE_UPLOAD_TIME + " INTEGER" +
                        " )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
