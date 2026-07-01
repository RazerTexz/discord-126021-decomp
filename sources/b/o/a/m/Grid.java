package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.g, reason: use source file name */
/* JADX INFO: compiled from: Grid.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Grid implements Control {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);

    private int value;

    Grid(int i) {
        this.value = i;
    }

    @NonNull
    public static Grid f(int i) {
        Grid[] gridArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            Grid grid = gridArrValues[i2];
            if (grid.value == i) {
                return grid;
            }
        }
        return OFF;
    }

    public int g() {
        return this.value;
    }
}
