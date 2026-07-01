package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class TableInfo$Index {
    public static final String DEFAULT_PREFIX = "index_";
    public final List<String> columns;
    public final String name;
    public final boolean unique;

    public TableInfo$Index(String str, boolean z2, List<String> list) {
        this.name = str;
        this.unique = z2;
        this.columns = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo$Index tableInfo$Index = (TableInfo$Index) obj;
        if (this.unique == tableInfo$Index.unique && this.columns.equals(tableInfo$Index.columns)) {
            return this.name.startsWith(DEFAULT_PREFIX) ? tableInfo$Index.name.startsWith(DEFAULT_PREFIX) : this.name.equals(tableInfo$Index.name);
        }
        return false;
    }

    public int hashCode() {
        return this.columns.hashCode() + ((((this.name.startsWith(DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Index{name='");
        sbU.append(this.name);
        sbU.append('\'');
        sbU.append(", unique=");
        sbU.append(this.unique);
        sbU.append(", columns=");
        sbU.append(this.columns);
        sbU.append('}');
        return sbU.toString();
    }
}
