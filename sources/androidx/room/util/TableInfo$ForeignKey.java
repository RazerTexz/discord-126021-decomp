package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class TableInfo$ForeignKey {

    @NonNull
    public final List<String> columnNames;

    @NonNull
    public final String onDelete;

    @NonNull
    public final String onUpdate;

    @NonNull
    public final List<String> referenceColumnNames;

    @NonNull
    public final String referenceTable;

    public TableInfo$ForeignKey(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<String> list, @NonNull List<String> list2) {
        this.referenceTable = str;
        this.onDelete = str2;
        this.onUpdate = str3;
        this.columnNames = Collections.unmodifiableList(list);
        this.referenceColumnNames = Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo$ForeignKey tableInfo$ForeignKey = (TableInfo$ForeignKey) obj;
        if (this.referenceTable.equals(tableInfo$ForeignKey.referenceTable) && this.onDelete.equals(tableInfo$ForeignKey.onDelete) && this.onUpdate.equals(tableInfo$ForeignKey.onUpdate) && this.columnNames.equals(tableInfo$ForeignKey.columnNames)) {
            return this.referenceColumnNames.equals(tableInfo$ForeignKey.referenceColumnNames);
        }
        return false;
    }

    public int hashCode() {
        return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + a.m(this.onUpdate, a.m(this.onDelete, this.referenceTable.hashCode() * 31, 31), 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ForeignKey{referenceTable='");
        sbU.append(this.referenceTable);
        sbU.append('\'');
        sbU.append(", onDelete='");
        sbU.append(this.onDelete);
        sbU.append('\'');
        sbU.append(", onUpdate='");
        sbU.append(this.onUpdate);
        sbU.append('\'');
        sbU.append(", columnNames=");
        sbU.append(this.columnNames);
        sbU.append(", referenceColumnNames=");
        sbU.append(this.referenceColumnNames);
        sbU.append('}');
        return sbU.toString();
    }
}
