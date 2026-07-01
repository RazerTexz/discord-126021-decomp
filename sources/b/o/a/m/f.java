package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Flash.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f implements c {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);

    private int value;

    f(int i) {
        this.value = i;
    }

    @NonNull
    public static f f(int i) {
        f[] fVarArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            f fVar = fVarArrValues[i2];
            if (fVar.value == i) {
                return fVar;
            }
        }
        return OFF;
    }

    public int g() {
        return this.value;
    }
}
