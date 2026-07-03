package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.m */
/* JADX INFO: compiled from: WhiteBalance.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5126m implements InterfaceC5116c {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);

    private int value;

    EnumC5126m(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5126m m7188f(int i) {
        EnumC5126m[] enumC5126mArrValues = values();
        for (int i2 = 0; i2 < 5; i2++) {
            EnumC5126m enumC5126m = enumC5126mArrValues[i2];
            if (enumC5126m.value == i) {
                return enumC5126m;
            }
        }
        return AUTO;
    }

    /* JADX INFO: renamed from: g */
    public int m7189g() {
        return this.value;
    }
}
