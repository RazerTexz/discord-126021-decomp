package androidx.room;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class InvalidationTracker$ObservedTableTracker {
    public static final int ADD = 1;
    public static final int NO_OP = 0;
    public static final int REMOVE = 2;
    public boolean mNeedsSync;
    public boolean mPendingSync;
    public final long[] mTableObservers;
    public final int[] mTriggerStateChanges;
    public final boolean[] mTriggerStates;

    public InvalidationTracker$ObservedTableTracker(int i) {
        long[] jArr = new long[i];
        this.mTableObservers = jArr;
        boolean[] zArr = new boolean[i];
        this.mTriggerStates = zArr;
        this.mTriggerStateChanges = new int[i];
        Arrays.fill(jArr, 0L);
        Arrays.fill(zArr, false);
    }

    @Nullable
    public int[] getTablesToSync() {
        synchronized (this) {
            if (this.mNeedsSync && !this.mPendingSync) {
                int length = this.mTableObservers.length;
                int i = 0;
                while (true) {
                    int i2 = 1;
                    if (i >= length) {
                        this.mPendingSync = true;
                        this.mNeedsSync = false;
                        return this.mTriggerStateChanges;
                    }
                    boolean z2 = this.mTableObservers[i] > 0;
                    boolean[] zArr = this.mTriggerStates;
                    if (z2 != zArr[i]) {
                        int[] iArr = this.mTriggerStateChanges;
                        if (!z2) {
                            i2 = 2;
                        }
                        iArr[i] = i2;
                    } else {
                        this.mTriggerStateChanges[i] = 0;
                    }
                    zArr[i] = z2;
                    i++;
                }
            }
            return null;
        }
    }

    public boolean onAdded(int... iArr) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            for (int i : iArr) {
                long[] jArr = this.mTableObservers;
                long j = jArr[i];
                jArr[i] = 1 + j;
                if (j == 0) {
                    this.mNeedsSync = true;
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public boolean onRemoved(int... iArr) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            for (int i : iArr) {
                long[] jArr = this.mTableObservers;
                long j = jArr[i];
                jArr[i] = j - 1;
                if (j == 1) {
                    this.mNeedsSync = true;
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public void onSyncCompleted() {
        synchronized (this) {
            this.mPendingSync = false;
        }
    }
}
