package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class TableInfo$ForeignKeyWithSequence implements Comparable<TableInfo$ForeignKeyWithSequence> {
    public final String mFrom;
    public final int mId;
    public final int mSequence;
    public final String mTo;

    public TableInfo$ForeignKeyWithSequence(int i, int i2, String str, String str2) {
        this.mId = i;
        this.mSequence = i2;
        this.mFrom = str;
        this.mTo = str2;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull TableInfo$ForeignKeyWithSequence tableInfo$ForeignKeyWithSequence) {
        return compareTo2(tableInfo$ForeignKeyWithSequence);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull TableInfo$ForeignKeyWithSequence tableInfo$ForeignKeyWithSequence) {
        int i = this.mId - tableInfo$ForeignKeyWithSequence.mId;
        return i == 0 ? this.mSequence - tableInfo$ForeignKeyWithSequence.mSequence : i;
    }
}
