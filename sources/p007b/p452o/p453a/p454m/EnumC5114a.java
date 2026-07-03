package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.a */
/* JADX INFO: compiled from: Audio.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5114a implements InterfaceC5116c {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);

    private int value;

    EnumC5114a(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5114a m7166f(int i) {
        EnumC5114a[] enumC5114aArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            EnumC5114a enumC5114a = enumC5114aArrValues[i2];
            if (enumC5114a.value == i) {
                return enumC5114a;
            }
        }
        return ON;
    }

    /* JADX INFO: renamed from: g */
    public int m7167g() {
        return this.value;
    }
}
