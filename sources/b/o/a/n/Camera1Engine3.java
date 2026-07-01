package b.o.a.n;

import java.util.Comparator;

/* JADX INFO: renamed from: b.o.a.n.c, reason: use source file name */
/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1Engine3 implements Comparator<int[]> {
    public Camera1Engine3(Camera1Engine2 camera1Engine2) {
    }

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return (iArr3[1] - iArr3[0]) - (iArr4[1] - iArr4[0]);
    }
}
