package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Grid.java */
/* JADX INFO: loaded from: classes3.dex */
public enum g implements c {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);

    private int value;

    g(int i) {
        this.value = i;
    }

    @NonNull
    public static g f(int i) {
        g[] gVarArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            g gVar = gVarArrValues[i2];
            if (gVar.value == i) {
                return gVar;
            }
        }
        return OFF;
    }

    public int g() {
        return this.value;
    }
}
