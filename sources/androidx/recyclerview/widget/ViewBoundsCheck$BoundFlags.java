package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewBoundsCheck$BoundFlags {
    public int mBoundFlags = 0;
    public int mChildEnd;
    public int mChildStart;
    public int mRvEnd;
    public int mRvStart;

    public void addFlags(int i) {
        this.mBoundFlags = i | this.mBoundFlags;
    }

    public boolean boundsMatch() {
        int i = this.mBoundFlags;
        if ((i & 7) != 0 && (i & (compare(this.mChildStart, this.mRvStart) << 0)) == 0) {
            return false;
        }
        int i2 = this.mBoundFlags;
        if ((i2 & 112) != 0 && (i2 & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
            return false;
        }
        int i3 = this.mBoundFlags;
        if ((i3 & 1792) != 0 && (i3 & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
            return false;
        }
        int i4 = this.mBoundFlags;
        return (i4 & 28672) == 0 || (i4 & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0;
    }

    public int compare(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i == i2 ? 2 : 4;
    }

    public void resetFlags() {
        this.mBoundFlags = 0;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.mRvStart = i;
        this.mRvEnd = i2;
        this.mChildStart = i3;
        this.mChildEnd = i4;
    }
}
