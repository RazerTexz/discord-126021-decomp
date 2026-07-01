package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: WhiteBalance.java */
/* JADX INFO: loaded from: classes3.dex */
public enum m implements c {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);

    private int value;

    m(int i) {
        this.value = i;
    }

    @NonNull
    public static m f(int i) {
        m[] mVarArrValues = values();
        for (int i2 = 0; i2 < 5; i2++) {
            m mVar = mVarArrValues[i2];
            if (mVar.value == i) {
                return mVar;
            }
        }
        return AUTO;
    }

    public int g() {
        return this.value;
    }
}
