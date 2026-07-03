package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.d */
/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5117d implements InterfaceC5116c {
    CAMERA1(0),
    CAMERA2(1);

    private int value;

    EnumC5117d(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5117d m7170f(int i) {
        EnumC5117d[] enumC5117dArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            EnumC5117d enumC5117d = enumC5117dArrValues[i2];
            if (enumC5117d.value == i) {
                return enumC5117d;
            }
        }
        return CAMERA1;
    }

    /* JADX INFO: renamed from: g */
    public int m7171g() {
        return this.value;
    }
}
