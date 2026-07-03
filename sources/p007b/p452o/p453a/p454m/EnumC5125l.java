package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.l */
/* JADX INFO: compiled from: VideoCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5125l implements InterfaceC5116c {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;

    EnumC5125l(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5125l m7186f(int i) {
        EnumC5125l[] enumC5125lArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            EnumC5125l enumC5125l = enumC5125lArrValues[i2];
            if (enumC5125l.value == i) {
                return enumC5125l;
            }
        }
        return DEVICE_DEFAULT;
    }

    /* JADX INFO: renamed from: g */
    public int m7187g() {
        return this.value;
    }
}
