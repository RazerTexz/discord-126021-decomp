package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.i, reason: use source file name */
/* JADX INFO: compiled from: Mode.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Mode3 implements Control {
    PICTURE(0),
    VIDEO(1);

    private int value;

    Mode3(int i) {
        this.value = i;
    }

    @NonNull
    public static Mode3 f(int i) {
        Mode3[] mode3ArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Mode3 mode3 = mode3ArrValues[i2];
            if (mode3.value == i) {
                return mode3;
            }
        }
        return PICTURE;
    }

    public int g() {
        return this.value;
    }
}
