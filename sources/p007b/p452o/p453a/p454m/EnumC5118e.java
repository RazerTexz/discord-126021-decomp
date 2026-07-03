package p007b.p452o.p453a.p454m;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.o.a.m.e */
/* JADX INFO: compiled from: Facing.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5118e implements InterfaceC5116c {
    BACK(0),
    FRONT(1);

    private int value;

    EnumC5118e(int i) {
        this.value = i;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public static EnumC5118e m7172f(int i) {
        EnumC5118e[] enumC5118eArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            EnumC5118e enumC5118e = enumC5118eArrValues[i2];
            if (enumC5118e.value == i) {
                return enumC5118e;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public int m7173g() {
        return this.value;
    }
}
