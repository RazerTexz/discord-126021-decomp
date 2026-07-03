package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.k */
/* JADX INFO: compiled from: Preview.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5124k implements InterfaceC5116c {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);

    private int value;

    EnumC5124k(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5124k m7184f(int i) {
        EnumC5124k[] enumC5124kArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            EnumC5124k enumC5124k = enumC5124kArrValues[i2];
            if (enumC5124k.value == i) {
                return enumC5124k;
            }
        }
        return GL_SURFACE;
    }

    /* JADX INFO: renamed from: g */
    public int m7185g() {
        return this.value;
    }
}
