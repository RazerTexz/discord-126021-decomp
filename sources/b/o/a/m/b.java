package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AudioCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public enum b implements c {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);

    private int value;

    b(int i) {
        this.value = i;
    }

    @NonNull
    public static b f(int i) {
        b[] bVarArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            b bVar = bVarArrValues[i2];
            if (bVar.value == i) {
                return bVar;
            }
        }
        return DEVICE_DEFAULT;
    }

    public int g() {
        return this.value;
    }
}
