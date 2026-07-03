package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.f */
/* JADX INFO: compiled from: Flash.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5119f implements InterfaceC5116c {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);

    private int value;

    EnumC5119f(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static EnumC5119f m7174f(int i) {
        EnumC5119f[] enumC5119fArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            EnumC5119f enumC5119f = enumC5119fArrValues[i2];
            if (enumC5119f.value == i) {
                return enumC5119f;
            }
        }
        return OFF;
    }

    /* JADX INFO: renamed from: g */
    public int m7175g() {
        return this.value;
    }
}
