package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Audio.java */
/* JADX INFO: loaded from: classes3.dex */
public enum a implements c {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);

    private int value;

    a(int i) {
        this.value = i;
    }

    @NonNull
    public static a f(int i) {
        a[] aVarArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            a aVar = aVarArrValues[i2];
            if (aVar.value == i) {
                return aVar;
            }
        }
        return ON;
    }

    public int g() {
        return this.value;
    }
}
