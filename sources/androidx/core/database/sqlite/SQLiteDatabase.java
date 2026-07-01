package androidx.core.database.sqlite;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.database.sqlite.SQLiteDatabaseKt, reason: use source file name */
/* JADX INFO: compiled from: SQLiteDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabase {
    public static final <T> T transaction(android.database.sqlite.SQLiteDatabase sQLiteDatabase, boolean z2, Function1<? super android.database.sqlite.SQLiteDatabase, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(sQLiteDatabase, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "body");
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
            InlineMarker.finallyStart(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object transaction$default(android.database.sqlite.SQLiteDatabase sQLiteDatabase, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        Intrinsics3.checkNotNullParameter(sQLiteDatabase, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "body");
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
            InlineMarker.finallyStart(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd(1);
        }
    }
}
