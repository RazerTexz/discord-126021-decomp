package b.o.a.n;

import java.util.Comparator;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Comparator<int[]> {
    public a(b bVar) {
    }

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return (iArr4[1] - iArr4[0]) - (iArr3[1] - iArr3[0]);
    }
}
