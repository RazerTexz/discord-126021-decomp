package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterHelper implements OpReorderer$Callback {
    private static final boolean DEBUG = false;
    public static final int POSITION_TYPE_INVISIBLE = 0;
    public static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    public final AdapterHelper$Callback mCallback;
    public final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    public Runnable mOnItemProcessedCallback;
    public final OpReorderer mOpReorderer;
    public final ArrayList<AdapterHelper$UpdateOp> mPendingUpdates;
    public final ArrayList<AdapterHelper$UpdateOp> mPostponedList;
    private Pools$Pool<AdapterHelper$UpdateOp> mUpdateOpPool;

    public AdapterHelper(AdapterHelper$Callback adapterHelper$Callback) {
        this(adapterHelper$Callback, false);
    }

    private void applyAdd(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
    }

    private void applyMove(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
    }

    private void applyRemove(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        boolean z2;
        byte b2;
        int i = adapterHelper$UpdateOp.positionStart;
        int i2 = adapterHelper$UpdateOp.itemCount + i;
        byte b3 = -1;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.mCallback.findViewHolder(i3) != null || canFindInPreLayout(i3)) {
                if (b3 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, i4, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b2 = 1;
            } else {
                if (b3 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i, i4, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b2 = 0;
            }
            if (z2) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b3 = b2;
        }
        if (i4 != adapterHelper$UpdateOp.itemCount) {
            recycleUpdateOp(adapterHelper$UpdateOp);
            adapterHelper$UpdateOp = obtainUpdateOp(2, i, i4, null);
        }
        if (b3 == 0) {
            dispatchAndUpdateViewHolders(adapterHelper$UpdateOp);
        } else {
            postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
        }
    }

    private void applyUpdate(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        int i = adapterHelper$UpdateOp.positionStart;
        int i2 = adapterHelper$UpdateOp.itemCount + i;
        int i3 = i;
        byte b2 = -1;
        int i4 = 0;
        while (i < i2) {
            if (this.mCallback.findViewHolder(i) != null || canFindInPreLayout(i)) {
                if (b2 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i3, i4, adapterHelper$UpdateOp.payload));
                    i3 = i;
                    i4 = 0;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i3, i4, adapterHelper$UpdateOp.payload));
                    i3 = i;
                    i4 = 0;
                }
                b2 = 0;
            }
            i4++;
            i++;
        }
        if (i4 != adapterHelper$UpdateOp.itemCount) {
            Object obj = adapterHelper$UpdateOp.payload;
            recycleUpdateOp(adapterHelper$UpdateOp);
            adapterHelper$UpdateOp = obtainUpdateOp(4, i3, i4, obj);
        }
        if (b2 == 0) {
            dispatchAndUpdateViewHolders(adapterHelper$UpdateOp);
        } else {
            postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
        }
    }

    private boolean canFindInPreLayout(int i) {
        int size = this.mPostponedList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.mPostponedList.get(i2);
            int i3 = adapterHelper$UpdateOp.cmd;
            if (i3 == 8) {
                if (findPositionOffset(adapterHelper$UpdateOp.itemCount, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = adapterHelper$UpdateOp.positionStart;
                int i5 = adapterHelper$UpdateOp.itemCount + i4;
                while (i4 < i5) {
                    if (findPositionOffset(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        int i;
        int i2 = adapterHelper$UpdateOp.cmd;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iUpdatePositionWithPostponed = updatePositionWithPostponed(adapterHelper$UpdateOp.positionStart, i2);
        int i3 = adapterHelper$UpdateOp.positionStart;
        int i4 = adapterHelper$UpdateOp.cmd;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + adapterHelper$UpdateOp);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < adapterHelper$UpdateOp.itemCount; i6++) {
            int iUpdatePositionWithPostponed2 = updatePositionWithPostponed((i * i6) + adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.cmd);
            int i7 = adapterHelper$UpdateOp.cmd;
            if (i7 == 2 ? iUpdatePositionWithPostponed2 == iUpdatePositionWithPostponed : i7 == 4 && iUpdatePositionWithPostponed2 == iUpdatePositionWithPostponed + 1) {
                i5++;
            } else {
                AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp = obtainUpdateOp(i7, iUpdatePositionWithPostponed, i5, adapterHelper$UpdateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp, i3);
                recycleUpdateOp(adapterHelper$UpdateOpObtainUpdateOp);
                if (adapterHelper$UpdateOp.cmd == 4) {
                    i3 += i5;
                }
                iUpdatePositionWithPostponed = iUpdatePositionWithPostponed2;
                i5 = 1;
            }
        }
        Object obj = adapterHelper$UpdateOp.payload;
        recycleUpdateOp(adapterHelper$UpdateOp);
        if (i5 > 0) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp2 = obtainUpdateOp(adapterHelper$UpdateOp.cmd, iUpdatePositionWithPostponed, i5, obj);
            dispatchFirstPassAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp2, i3);
            recycleUpdateOp(adapterHelper$UpdateOpObtainUpdateOp2);
        }
    }

    private void postponeAndUpdateViewHolders(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        this.mPostponedList.add(adapterHelper$UpdateOp);
        int i = adapterHelper$UpdateOp.cmd;
        if (i == 1) {
            this.mCallback.offsetPositionsForAdd(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            return;
        }
        if (i == 2) {
            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            return;
        }
        if (i == 4) {
            this.mCallback.markViewHoldersUpdated(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount, adapterHelper$UpdateOp.payload);
        } else {
            if (i == 8) {
                this.mCallback.offsetPositionsForMove(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + adapterHelper$UpdateOp);
        }
    }

    private int updatePositionWithPostponed(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.mPostponedList.get(size);
            int i5 = adapterHelper$UpdateOp.cmd;
            if (i5 == 8) {
                int i6 = adapterHelper$UpdateOp.positionStart;
                int i7 = adapterHelper$UpdateOp.itemCount;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            adapterHelper$UpdateOp.positionStart = i6 + 1;
                            adapterHelper$UpdateOp.itemCount = i7 + 1;
                        } else if (i2 == 2) {
                            adapterHelper$UpdateOp.positionStart = i6 - 1;
                            adapterHelper$UpdateOp.itemCount = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        adapterHelper$UpdateOp.itemCount = i7 + 1;
                    } else if (i2 == 2) {
                        adapterHelper$UpdateOp.itemCount = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        adapterHelper$UpdateOp.positionStart = i6 + 1;
                    } else if (i2 == 2) {
                        adapterHelper$UpdateOp.positionStart = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = adapterHelper$UpdateOp.positionStart;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= adapterHelper$UpdateOp.itemCount;
                    } else if (i5 == 2) {
                        i += adapterHelper$UpdateOp.itemCount;
                    }
                } else if (i2 == 1) {
                    adapterHelper$UpdateOp.positionStart = i8 + 1;
                } else if (i2 == 2) {
                    adapterHelper$UpdateOp.positionStart = i8 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp2 = this.mPostponedList.get(size2);
            if (adapterHelper$UpdateOp2.cmd == 8) {
                int i9 = adapterHelper$UpdateOp2.itemCount;
                if (i9 == adapterHelper$UpdateOp2.positionStart || i9 < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(adapterHelper$UpdateOp2);
                }
            } else if (adapterHelper$UpdateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(adapterHelper$UpdateOp2);
            }
        }
        return i;
    }

    public AdapterHelper addUpdateOp(AdapterHelper$UpdateOp... adapterHelper$UpdateOpArr) {
        Collections.addAll(this.mPendingUpdates, adapterHelper$UpdateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.mPendingUpdates.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.mPendingUpdates.get(i2);
            int i3 = adapterHelper$UpdateOp.cmd;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = adapterHelper$UpdateOp.positionStart;
                    if (i4 <= i) {
                        int i5 = adapterHelper$UpdateOp.itemCount;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = adapterHelper$UpdateOp.positionStart;
                    if (i6 == i) {
                        i = adapterHelper$UpdateOp.itemCount;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (adapterHelper$UpdateOp.itemCount <= i) {
                            i++;
                        }
                    }
                }
            } else if (adapterHelper$UpdateOp.positionStart <= i) {
                i += adapterHelper$UpdateOp.itemCount;
            }
        }
        return i;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i = 0; i < size; i++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i = 0; i < size; i++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.mPendingUpdates.get(i);
            int i2 = adapterHelper$UpdateOp.cmd;
            if (i2 == 1) {
                this.mCallback.onDispatchSecondPass(adapterHelper$UpdateOp);
                this.mCallback.offsetPositionsForAdd(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            } else if (i2 == 2) {
                this.mCallback.onDispatchSecondPass(adapterHelper$UpdateOp);
                this.mCallback.offsetPositionsForRemovingInvisible(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            } else if (i2 == 4) {
                this.mCallback.onDispatchSecondPass(adapterHelper$UpdateOp);
                this.mCallback.markViewHoldersUpdated(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount, adapterHelper$UpdateOp.payload);
            } else if (i2 == 8) {
                this.mCallback.onDispatchSecondPass(adapterHelper$UpdateOp);
                this.mCallback.offsetPositionsForMove(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public void dispatchFirstPassAndUpdateViewHolders(AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i) {
        this.mCallback.onDispatchFirstPass(adapterHelper$UpdateOp);
        int i2 = adapterHelper$UpdateOp.cmd;
        if (i2 == 2) {
            this.mCallback.offsetPositionsForRemovingInvisible(i, adapterHelper$UpdateOp.itemCount);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.mCallback.markViewHoldersUpdated(i, adapterHelper$UpdateOp.itemCount, adapterHelper$UpdateOp.payload);
        }
    }

    public int findPositionOffset(int i) {
        return findPositionOffset(i, 0);
    }

    public boolean hasAnyUpdateTypes(int i) {
        return (i & this.mExistingUpdateTypes) != 0;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public boolean hasUpdates() {
        return (this.mPostponedList.isEmpty() || this.mPendingUpdates.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer$Callback
    public AdapterHelper$UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        AdapterHelper$UpdateOp adapterHelper$UpdateOpAcquire = this.mUpdateOpPool.acquire();
        if (adapterHelper$UpdateOpAcquire == null) {
            return new AdapterHelper$UpdateOp(i, i2, i3, obj);
        }
        adapterHelper$UpdateOpAcquire.cmd = i;
        adapterHelper$UpdateOpAcquire.positionStart = i2;
        adapterHelper$UpdateOpAcquire.itemCount = i3;
        adapterHelper$UpdateOpAcquire.payload = obj;
        return adapterHelper$UpdateOpAcquire;
    }

    public boolean onItemRangeChanged(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(4, i, i2, obj));
        this.mExistingUpdateTypes |= 4;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeInserted(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(1, i, i2, null));
        this.mExistingUpdateTypes |= 1;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeMoved(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.mPendingUpdates.add(obtainUpdateOp(8, i, i2, null));
        this.mExistingUpdateTypes |= 8;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeRemoved(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(2, i, i2, null));
        this.mExistingUpdateTypes |= 2;
        return this.mPendingUpdates.size() == 1;
    }

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i = 0; i < size; i++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.mPendingUpdates.get(i);
            int i2 = adapterHelper$UpdateOp.cmd;
            if (i2 == 1) {
                applyAdd(adapterHelper$UpdateOp);
            } else if (i2 == 2) {
                applyRemove(adapterHelper$UpdateOp);
            } else if (i2 == 4) {
                applyUpdate(adapterHelper$UpdateOp);
            } else if (i2 == 8) {
                applyMove(adapterHelper$UpdateOp);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    @Override // androidx.recyclerview.widget.OpReorderer$Callback
    public void recycleUpdateOp(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        if (this.mDisableRecycler) {
            return;
        }
        adapterHelper$UpdateOp.payload = null;
        this.mUpdateOpPool.release(adapterHelper$UpdateOp);
    }

    public void recycleUpdateOpsAndClearList(List<AdapterHelper$UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(AdapterHelper$Callback adapterHelper$Callback, boolean z2) {
        this.mUpdateOpPool = new Pools$SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = adapterHelper$Callback;
        this.mDisableRecycler = z2;
        this.mOpReorderer = new OpReorderer(this);
    }

    public int findPositionOffset(int i, int i2) {
        int size = this.mPostponedList.size();
        while (i2 < size) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.mPostponedList.get(i2);
            int i3 = adapterHelper$UpdateOp.cmd;
            if (i3 == 8) {
                int i4 = adapterHelper$UpdateOp.positionStart;
                if (i4 == i) {
                    i = adapterHelper$UpdateOp.itemCount;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (adapterHelper$UpdateOp.itemCount <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = adapterHelper$UpdateOp.positionStart;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = adapterHelper$UpdateOp.itemCount;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += adapterHelper$UpdateOp.itemCount;
                }
            }
            i2++;
        }
        return i;
    }
}
