package androidx.room.util;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo$SQLiteTypeAffinity;
import b.d.b.a.a;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TableInfo$Column {

    @ColumnInfo$SQLiteTypeAffinity
    public final int affinity;
    public final String defaultValue;
    private final int mCreatedFrom;
    public final String name;
    public final boolean notNull;
    public final int primaryKeyPosition;
    public final String type;

    @Deprecated
    public TableInfo$Column(String str, String str2, boolean z2, int i) {
        this(str, str2, z2, i, null, 0);
    }

    @ColumnInfo$SQLiteTypeAffinity
    private static int findAffinity(@Nullable String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.US);
        if (upperCase.contains("INT")) {
            return 3;
        }
        if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
            return 2;
        }
        if (upperCase.contains("BLOB")) {
            return 5;
        }
        return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo$Column tableInfo$Column = (TableInfo$Column) obj;
        if (this.primaryKeyPosition != tableInfo$Column.primaryKeyPosition || !this.name.equals(tableInfo$Column.name) || this.notNull != tableInfo$Column.notNull) {
            return false;
        }
        if (this.mCreatedFrom == 1 && tableInfo$Column.mCreatedFrom == 2 && (str3 = this.defaultValue) != null && !str3.equals(tableInfo$Column.defaultValue)) {
            return false;
        }
        if (this.mCreatedFrom == 2 && tableInfo$Column.mCreatedFrom == 1 && (str2 = tableInfo$Column.defaultValue) != null && !str2.equals(this.defaultValue)) {
            return false;
        }
        int i = this.mCreatedFrom;
        return (i == 0 || i != tableInfo$Column.mCreatedFrom || ((str = this.defaultValue) == null ? tableInfo$Column.defaultValue == null : str.equals(tableInfo$Column.defaultValue))) && this.affinity == tableInfo$Column.affinity;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
    }

    public boolean isPrimaryKey() {
        return this.primaryKeyPosition > 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Column{name='");
        sbU.append(this.name);
        sbU.append('\'');
        sbU.append(", type='");
        sbU.append(this.type);
        sbU.append('\'');
        sbU.append(", affinity='");
        sbU.append(this.affinity);
        sbU.append('\'');
        sbU.append(", notNull=");
        sbU.append(this.notNull);
        sbU.append(", primaryKeyPosition=");
        sbU.append(this.primaryKeyPosition);
        sbU.append(", defaultValue='");
        sbU.append(this.defaultValue);
        sbU.append('\'');
        sbU.append('}');
        return sbU.toString();
    }

    public TableInfo$Column(String str, String str2, boolean z2, int i, String str3, int i2) {
        this.name = str;
        this.type = str2;
        this.notNull = z2;
        this.primaryKeyPosition = i;
        this.affinity = findAffinity(str2);
        this.defaultValue = str3;
        this.mCreatedFrom = i2;
    }
}
