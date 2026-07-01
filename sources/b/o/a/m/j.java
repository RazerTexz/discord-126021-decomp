package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: PictureFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public enum j implements c {
    JPEG(0),
    DNG(1);

    private int value;

    j(int i) {
        this.value = i;
    }

    @NonNull
    public static j f(int i) {
        j[] jVarArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            j jVar = jVarArrValues[i2];
            if (jVar.value == i) {
                return jVar;
            }
        }
        return JPEG;
    }

    public int g() {
        return this.value;
    }
}
