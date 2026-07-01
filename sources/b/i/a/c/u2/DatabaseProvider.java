package b.i.a.c.u2;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: renamed from: b.i.a.c.u2.a, reason: use source file name */
/* JADX INFO: compiled from: DatabaseProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DatabaseProvider {
    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
