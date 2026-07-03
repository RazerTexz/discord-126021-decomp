package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.h */
/* JADX INFO: compiled from: Hdr.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5121h implements InterfaceC5116c {
    OFF(0),
    ON(1);

    private int value;

    EnumC5121h(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5121h m7178f(int i) {
        EnumC5121h[] enumC5121hArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            EnumC5121h enumC5121h = enumC5121hArrValues[i2];
            if (enumC5121h.value == i) {
                return enumC5121h;
            }
        }
        return OFF;
    }

    /* JADX INFO: renamed from: g */
    public int m7179g() {
        return this.value;
    }
}
