package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Mode.java */
/* JADX INFO: loaded from: classes3.dex */
public enum i implements c {
    PICTURE(0),
    VIDEO(1);

    private int value;

    i(int i) {
        this.value = i;
    }

    @NonNull
    public static i f(int i) {
        i[] iVarArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            i iVar = iVarArrValues[i2];
            if (iVar.value == i) {
                return iVar;
            }
        }
        return PICTURE;
    }

    public int g() {
        return this.value;
    }
}
