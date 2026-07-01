package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Hdr.java */
/* JADX INFO: loaded from: classes3.dex */
public enum h implements c {
    OFF(0),
    ON(1);

    private int value;

    h(int i) {
        this.value = i;
    }

    @NonNull
    public static h f(int i) {
        h[] hVarArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            h hVar = hVarArrValues[i2];
            if (hVar.value == i) {
                return hVar;
            }
        }
        return OFF;
    }

    public int g() {
        return this.value;
    }
}
