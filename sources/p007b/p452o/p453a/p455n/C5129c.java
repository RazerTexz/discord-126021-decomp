package p007b.p452o.p453a.p455n;

import java.util.Comparator;

/* JADX INFO: renamed from: b.o.a.n.c */
/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5129c implements Comparator<int[]> {
    public C5129c(C5128b c5128b) {
    }

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return (iArr3[1] - iArr3[0]) - (iArr4[1] - iArr4[0]);
    }
}
