package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12237l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SQLiteDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z2, Function1<? super SQLiteDatabase, ? extends T> function1) {
        C12238m.checkNotNullParameter(sQLiteDatabase, "<this>");
        C12238m.checkNotNullParameter(function1, "body");
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
            C12237l.finallyStart(1);
            sQLiteDatabase.endTransaction();
            C12237l.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        C12238m.checkNotNullParameter(sQLiteDatabase, "<this>");
        C12238m.checkNotNullParameter(function1, "body");
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
            C12237l.finallyStart(1);
            sQLiteDatabase.endTransaction();
            C12237l.finallyEnd(1);
        }
    }
}
