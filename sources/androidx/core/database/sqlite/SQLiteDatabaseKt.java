package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.l;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SQLiteDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z2, Function1<? super SQLiteDatabase, ? extends T> function1) {
        m.checkNotNullParameter(sQLiteDatabase, "<this>");
        m.checkNotNullParameter(function1, "body");
        if (z2) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tInvoke;
        } finally {
            l.finallyStart(1);
            sQLiteDatabase.endTransaction();
            l.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        m.checkNotNullParameter(sQLiteDatabase, "<this>");
        m.checkNotNullParameter(function1, "body");
        if (z2) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            l.finallyStart(1);
            sQLiteDatabase.endTransaction();
            l.finallyEnd(1);
        }
    }
}
