package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class ChildHelper$Bucket {
    public static final int BITS_PER_WORD = 64;
    public static final long LAST_BIT = Long.MIN_VALUE;
    public long mData = 0;
    public ChildHelper$Bucket mNext;

    private void ensureNext() {
        if (this.mNext == null) {
            this.mNext = new ChildHelper$Bucket();
        }
    }

    public void clear(int i) {
        if (i < 64) {
            this.mData &= ~(1 << i);
            return;
        }
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket != null) {
            childHelper$Bucket.clear(i - 64);
        }
    }

    public int countOnesBefore(int i) {
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket == null) {
            return i >= 64 ? Long.bitCount(this.mData) : Long.bitCount(this.mData & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.mData & ((1 << i) - 1));
        }
        return Long.bitCount(this.mData) + childHelper$Bucket.countOnesBefore(i - 64);
    }

    public boolean get(int i) {
        if (i < 64) {
            return (this.mData & (1 << i)) != 0;
        }
        ensureNext();
        return this.mNext.get(i - 64);
    }

    public void insert(int i, boolean z2) {
        if (i >= 64) {
            ensureNext();
            this.mNext.insert(i - 64, z2);
            return;
        }
        long j = this.mData;
        boolean z3 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.mData = ((j & (~j2)) << 1) | (j & j2);
        if (z2) {
            set(i);
        } else {
            clear(i);
        }
        if (z3 || this.mNext != null) {
            ensureNext();
            this.mNext.insert(0, z3);
        }
    }

    public boolean remove(int i) {
        if (i >= 64) {
            ensureNext();
            return this.mNext.remove(i - 64);
        }
        long j = 1 << i;
        long j2 = this.mData;
        boolean z2 = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.mData = j3;
        long j4 = j - 1;
        this.mData = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket != null) {
            if (childHelper$Bucket.get(0)) {
                set(63);
            }
            this.mNext.remove(0);
        }
        return z2;
    }

    public void reset() {
        this.mData = 0L;
        ChildHelper$Bucket childHelper$Bucket = this.mNext;
        if (childHelper$Bucket != null) {
            childHelper$Bucket.reset();
        }
    }

    public void set(int i) {
        if (i < 64) {
            this.mData |= 1 << i;
        } else {
            ensureNext();
            this.mNext.set(i - 64);
        }
    }

    public String toString() {
        if (this.mNext == null) {
            return Long.toBinaryString(this.mData);
        }
        return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
    }
}
