package b.o.a.m;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Facing.java */
/* JADX INFO: loaded from: classes3.dex */
public enum e implements c {
    BACK(0),
    FRONT(1);

    private int value;

    e(int i) {
        this.value = i;
    }

    @Nullable
    public static e f(int i) {
        e[] eVarArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            e eVar = eVarArrValues[i2];
            if (eVar.value == i) {
                return eVar;
            }
        }
        return null;
    }

    public int g() {
        return this.value;
    }
}
