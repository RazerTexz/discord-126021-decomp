package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.h, reason: use source file name */
/* JADX INFO: compiled from: Hdr.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Hdr implements Control {
    OFF(0),
    ON(1);

    private int value;

    Hdr(int i) {
        this.value = i;
    }

    @NonNull
    public static Hdr f(int i) {
        Hdr[] hdrArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Hdr hdr = hdrArrValues[i2];
            if (hdr.value == i) {
                return hdr;
            }
        }
        return OFF;
    }

    public int g() {
        return this.value;
    }
}
