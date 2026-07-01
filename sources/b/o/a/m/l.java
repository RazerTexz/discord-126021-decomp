package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: VideoCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public enum l implements c {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;

    l(int i) {
        this.value = i;
    }

    @NonNull
    public static l f(int i) {
        l[] lVarArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            l lVar = lVarArrValues[i2];
            if (lVar.value == i) {
                return lVar;
            }
        }
        return DEVICE_DEFAULT;
    }

    public int g() {
        return this.value;
    }
}
