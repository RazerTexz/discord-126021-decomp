package b.o.a.m;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.o.a.m.e, reason: use source file name */
/* JADX INFO: compiled from: Facing.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Facing implements Control {
    BACK(0),
    FRONT(1);

    private int value;

    Facing(int i) {
        this.value = i;
    }

    @Nullable
    public static Facing f(int i) {
        Facing[] facingArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Facing facing = facingArrValues[i2];
            if (facing.value == i) {
                return facing;
            }
        }
        return null;
    }

    public int g() {
        return this.value;
    }
}
