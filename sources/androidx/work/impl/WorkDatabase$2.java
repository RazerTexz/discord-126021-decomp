package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase$Callback;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class WorkDatabase$2 extends RoomDatabase$Callback {
    @Override // androidx.room.RoomDatabase$Callback
    public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        supportSQLiteDatabase.beginTransaction();
        try {
            supportSQLiteDatabase.execSQL(WorkDatabase.getPruneSQL());
            supportSQLiteDatabase.setTransactionSuccessful();
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
