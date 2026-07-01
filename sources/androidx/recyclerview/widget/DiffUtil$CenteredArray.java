package androidx.recyclerview.widget;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$CenteredArray {
    private final int[] mData;
    private final int mMid;

    public DiffUtil$CenteredArray(int i) {
        int[] iArr = new int[i];
        this.mData = iArr;
        this.mMid = iArr.length / 2;
    }

    public int[] backingData() {
        return this.mData;
    }

    public void fill(int i) {
        Arrays.fill(this.mData, i);
    }

    public int get(int i) {
        return this.mData[i + this.mMid];
    }

    public void set(int i, int i2) {
        this.mData[i + this.mMid] = i2;
    }
}
