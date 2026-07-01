package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Preview.java */
/* JADX INFO: loaded from: classes3.dex */
public enum k implements c {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);

    private int value;

    k(int i) {
        this.value = i;
    }

    @NonNull
    public static k f(int i) {
        k[] kVarArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            k kVar = kVarArrValues[i2];
            if (kVar.value == i) {
                return kVar;
            }
        }
        return GL_SURFACE;
    }

    public int g() {
        return this.value;
    }
}
