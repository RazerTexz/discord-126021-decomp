package androidx.core.text.util;

/* JADX INFO: loaded from: classes.dex */
public class FindAddress$ZipRange {
    public int mException1;
    public int mException2;
    public int mHigh;
    public int mLow;

    public FindAddress$ZipRange(int i, int i2, int i3, int i4) {
        this.mLow = i;
        this.mHigh = i2;
        this.mException1 = i3;
        this.mException2 = i4;
    }

    public boolean matches(String str) {
        int i = Integer.parseInt(str.substring(0, 2));
        return (this.mLow <= i && i <= this.mHigh) || i == this.mException1 || i == this.mException2;
    }
}
