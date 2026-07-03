package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.p006db.SupportSQLiteDatabase;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String str, String str2) {
        this.name = str;
        this.sql = str2;
    }

    public static ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor cursorQuery = supportSQLiteDatabase.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + "'");
        try {
            return cursorQuery.moveToFirst() ? new ViewInfo(cursorQuery.getString(0), cursorQuery.getString(1)) : new ViewInfo(str, null);
        } finally {
            cursorQuery.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        String str = this.name;
        if (str == null ? viewInfo.name == null : str.equals(viewInfo.name)) {
            String str2 = this.sql;
            if (str2 != null) {
                if (str2.equals(viewInfo.sql)) {
                    return true;
                }
            } else if (viewInfo.sql == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sql;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ViewInfo{name='");
        sbM833U.append(this.name);
        sbM833U.append('\'');
        sbM833U.append(", sql='");
        sbM833U.append(this.sql);
        sbM833U.append('\'');
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
