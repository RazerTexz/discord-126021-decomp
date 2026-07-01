package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public enum d implements c {
    CAMERA1(0),
    CAMERA2(1);

    private int value;

    d(int i) {
        this.value = i;
    }

    @NonNull
    public static d f(int i) {
        d[] dVarArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            d dVar = dVarArrValues[i2];
            if (dVar.value == i) {
                return dVar;
            }
        }
        return CAMERA1;
    }

    public int g() {
        return this.value;
    }
}
