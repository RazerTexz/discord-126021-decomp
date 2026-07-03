package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.b */
/* JADX INFO: compiled from: AudioCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5115b implements InterfaceC5116c {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);

    private int value;

    EnumC5115b(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5115b m7168f(int i) {
        EnumC5115b[] enumC5115bArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            EnumC5115b enumC5115b = enumC5115bArrValues[i2];
            if (enumC5115b.value == i) {
                return enumC5115b;
            }
        }
        return DEVICE_DEFAULT;
    }

    /* JADX INFO: renamed from: g */
    public int m7169g() {
        return this.value;
    }
}
