package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.j */
/* JADX INFO: compiled from: PictureFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5123j implements InterfaceC5116c {
    JPEG(0),
    DNG(1);

    private int value;

    EnumC5123j(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5123j m7182f(int i) {
        EnumC5123j[] enumC5123jArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            EnumC5123j enumC5123j = enumC5123jArrValues[i2];
            if (enumC5123j.value == i) {
                return enumC5123j;
            }
        }
        return JPEG;
    }

    /* JADX INFO: renamed from: g */
    public int m7183g() {
        return this.value;
    }
}
