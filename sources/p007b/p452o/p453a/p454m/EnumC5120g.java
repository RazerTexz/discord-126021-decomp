package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.g */
/* JADX INFO: compiled from: Grid.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5120g implements InterfaceC5116c {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);

    private int value;

    EnumC5120g(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5120g m7176f(int i) {
        EnumC5120g[] enumC5120gArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            EnumC5120g enumC5120g = enumC5120gArrValues[i2];
            if (enumC5120g.value == i) {
                return enumC5120g;
            }
        }
        return OFF;
    }

    /* JADX INFO: renamed from: g */
    public int m7177g() {
        return this.value;
    }
}
