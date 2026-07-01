package androidx.recyclerview.widget;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$1 implements Comparator<DiffUtil$Diagonal> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(DiffUtil$Diagonal diffUtil$Diagonal, DiffUtil$Diagonal diffUtil$Diagonal2) {
        return compare2(diffUtil$Diagonal, diffUtil$Diagonal2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(DiffUtil$Diagonal diffUtil$Diagonal, DiffUtil$Diagonal diffUtil$Diagonal2) {
        return diffUtil$Diagonal.f36x - diffUtil$Diagonal2.f36x;
    }
}
