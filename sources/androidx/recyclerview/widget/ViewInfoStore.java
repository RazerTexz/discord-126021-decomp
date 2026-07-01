package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class ViewInfoStore {
    private static final boolean DEBUG = false;

    @VisibleForTesting
    public final SimpleArrayMap<RecyclerView$ViewHolder, ViewInfoStore$InfoRecord> mLayoutHolderMap = new SimpleArrayMap<>();

    @VisibleForTesting
    public final LongSparseArray<RecyclerView$ViewHolder> mOldChangedHolders = new LongSparseArray<>();

    private RecyclerView$ItemAnimator$ItemHolderInfo popFromLayoutStep(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordValueAt;
        RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo;
        int iIndexOfKey = this.mLayoutHolderMap.indexOfKey(recyclerView$ViewHolder);
        if (iIndexOfKey >= 0 && (viewInfoStore$InfoRecordValueAt = this.mLayoutHolderMap.valueAt(iIndexOfKey)) != null) {
            int i2 = viewInfoStore$InfoRecordValueAt.flags;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                viewInfoStore$InfoRecordValueAt.flags = i3;
                if (i == 4) {
                    recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecordValueAt.preInfo;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecordValueAt.postInfo;
                }
                if ((i3 & 12) == 0) {
                    this.mLayoutHolderMap.removeAt(iIndexOfKey);
                    ViewInfoStore$InfoRecord.recycle(viewInfoStore$InfoRecordValueAt);
                }
                return recyclerView$ItemAnimator$ItemHolderInfo;
            }
        }
        return null;
    }

    public void addToAppearedInPreLayoutHolders(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.flags |= 2;
        viewInfoStore$InfoRecordObtain.preInfo = recyclerView$ItemAnimator$ItemHolderInfo;
    }

    public void addToDisappearedInLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.flags |= 1;
    }

    public void addToOldChangeHolders(long j, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mOldChangedHolders.put(j, recyclerView$ViewHolder);
    }

    public void addToPostLayout(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.postInfo = recyclerView$ItemAnimator$ItemHolderInfo;
        viewInfoStore$InfoRecordObtain.flags |= 8;
    }

    public void addToPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.preInfo = recyclerView$ItemAnimator$ItemHolderInfo;
        viewInfoStore$InfoRecordObtain.flags |= 4;
    }

    public void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    public RecyclerView$ViewHolder getFromOldChangeHolders(long j) {
        return this.mOldChangedHolders.get(j);
    }

    public boolean isDisappearing(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        return (viewInfoStore$InfoRecord == null || (viewInfoStore$InfoRecord.flags & 1) == 0) ? false : true;
    }

    public boolean isInPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        return (viewInfoStore$InfoRecord == null || (viewInfoStore$InfoRecord.flags & 4) == 0) ? false : true;
    }

    public void onDetach() {
        ViewInfoStore$InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        removeFromDisappearedInLayout(recyclerView$ViewHolder);
    }

    @Nullable
    public RecyclerView$ItemAnimator$ItemHolderInfo popFromPostLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return popFromLayoutStep(recyclerView$ViewHolder, 8);
    }

    @Nullable
    public RecyclerView$ItemAnimator$ItemHolderInfo popFromPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return popFromLayoutStep(recyclerView$ViewHolder, 4);
    }

    public void process(ViewInfoStore$ProcessCallback viewInfoStore$ProcessCallback) {
        for (int size = this.mLayoutHolderMap.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolderKeyAt = this.mLayoutHolderMap.keyAt(size);
            ViewInfoStore$InfoRecord viewInfoStore$InfoRecordRemoveAt = this.mLayoutHolderMap.removeAt(size);
            int i = viewInfoStore$InfoRecordRemoveAt.flags;
            if ((i & 3) == 3) {
                viewInfoStore$ProcessCallback.unused(recyclerView$ViewHolderKeyAt);
            } else if ((i & 1) != 0) {
                RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecordRemoveAt.preInfo;
                if (recyclerView$ItemAnimator$ItemHolderInfo == null) {
                    viewInfoStore$ProcessCallback.unused(recyclerView$ViewHolderKeyAt);
                } else {
                    viewInfoStore$ProcessCallback.processDisappeared(recyclerView$ViewHolderKeyAt, recyclerView$ItemAnimator$ItemHolderInfo, viewInfoStore$InfoRecordRemoveAt.postInfo);
                }
            } else if ((i & 14) == 14) {
                viewInfoStore$ProcessCallback.processAppeared(recyclerView$ViewHolderKeyAt, viewInfoStore$InfoRecordRemoveAt.preInfo, viewInfoStore$InfoRecordRemoveAt.postInfo);
            } else if ((i & 12) == 12) {
                viewInfoStore$ProcessCallback.processPersistent(recyclerView$ViewHolderKeyAt, viewInfoStore$InfoRecordRemoveAt.preInfo, viewInfoStore$InfoRecordRemoveAt.postInfo);
            } else if ((i & 4) != 0) {
                viewInfoStore$ProcessCallback.processDisappeared(recyclerView$ViewHolderKeyAt, viewInfoStore$InfoRecordRemoveAt.preInfo, null);
            } else if ((i & 8) != 0) {
                viewInfoStore$ProcessCallback.processAppeared(recyclerView$ViewHolderKeyAt, viewInfoStore$InfoRecordRemoveAt.preInfo, viewInfoStore$InfoRecordRemoveAt.postInfo);
            }
            ViewInfoStore$InfoRecord.recycle(viewInfoStore$InfoRecordRemoveAt);
        }
    }

    public void removeFromDisappearedInLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecord == null) {
            return;
        }
        viewInfoStore$InfoRecord.flags &= -2;
    }

    public void removeViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        for (int size = this.mOldChangedHolders.size() - 1; size >= 0; size--) {
            if (recyclerView$ViewHolder == this.mOldChangedHolders.valueAt(size)) {
                this.mOldChangedHolders.removeAt(size);
                break;
            }
        }
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordRemove = this.mLayoutHolderMap.remove(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecordRemove != null) {
            ViewInfoStore$InfoRecord.recycle(viewInfoStore$InfoRecordRemove);
        }
    }
}
