package androidx.core.database;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.database.CursorKt, reason: use source file name */
/* JADX INFO: compiled from: Cursor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Cursor {
    public static final byte[] getBlobOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }

    public static final Double getDoubleOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    public static final Float getFloatOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    public static final Integer getIntOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    public static final Long getLongOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    public static final Short getShortOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i));
    }

    public static final String getStringOrNull(android.database.Cursor cursor, int i) {
        Intrinsics3.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }
}
