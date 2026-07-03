package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.i */
/* JADX INFO: compiled from: Mode.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5122i implements InterfaceC5116c {
    PICTURE(0),
    VIDEO(1);

    private int value;

    EnumC5122i(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5122i m7180f(int i) {
        EnumC5122i[] enumC5122iArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            EnumC5122i enumC5122i = enumC5122iArrValues[i2];
            if (enumC5122i.value == i) {
                return enumC5122i;
            }
        }
        return PICTURE;
    }

    /* JADX INFO: renamed from: g */
    public int m7181g() {
        return this.value;
    }
}
