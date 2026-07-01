package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import b.d.b.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RecyclerView$Recycler {
    public static final int DEFAULT_CACHE_SIZE = 2;
    public final ArrayList<RecyclerView$ViewHolder> mAttachedScrap;
    public final ArrayList<RecyclerView$ViewHolder> mCachedViews;
    public ArrayList<RecyclerView$ViewHolder> mChangedScrap;
    public RecyclerView$RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax;
    private final List<RecyclerView$ViewHolder> mUnmodifiableAttachedScrap;
    private RecyclerView$ViewCacheExtension mViewCacheExtension;
    public int mViewCacheMax;
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$Recycler(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
        ArrayList<RecyclerView$ViewHolder> arrayList = new ArrayList<>();
        this.mAttachedScrap = arrayList;
        this.mChangedScrap = null;
        this.mCachedViews = new ArrayList<>();
        this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
        this.mRequestedCacheMax = 2;
        this.mViewCacheMax = 2;
    }

    private void attachAccessibilityDelegateOnBind(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (this.this$0.isAccessibilityEnabled()) {
            View view = recyclerView$ViewHolder.itemView;
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.this$0.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate == null) {
                return;
            }
            AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
            if (itemDelegate instanceof RecyclerViewAccessibilityDelegate$ItemDelegate) {
                ((RecyclerViewAccessibilityDelegate$ItemDelegate) itemDelegate).saveOriginalDelegate(view);
            }
            ViewCompat.setAccessibilityDelegate(view, itemDelegate);
        }
    }

    private void invalidateDisplayListInt(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        if (view instanceof ViewGroup) {
            invalidateDisplayListInt((ViewGroup) view, false);
        }
    }

    private boolean tryBindViewHolderByDeadline(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, long j) {
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = this.this$0;
        int itemViewType = recyclerView$ViewHolder.getItemViewType();
        long nanoTime = this.this$0.getNanoTime();
        if (j != RecyclerView.FOREVER_NS && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j)) {
            return false;
        }
        this.this$0.mAdapter.bindViewHolder(recyclerView$ViewHolder, i);
        this.mRecyclerPool.factorInBindTime(recyclerView$ViewHolder.getItemViewType(), this.this$0.getNanoTime() - nanoTime);
        attachAccessibilityDelegateOnBind(recyclerView$ViewHolder);
        if (!this.this$0.mState.isPreLayout()) {
            return true;
        }
        recyclerView$ViewHolder.mPreLayoutPosition = i2;
        return true;
    }

    public void addViewHolderToRecycledViewPool(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, boolean z2) {
        RecyclerView.clearNestedRecyclerViewIfNotNested(recyclerView$ViewHolder);
        View view = recyclerView$ViewHolder.itemView;
        RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.this$0.mAccessibilityDelegate;
        if (recyclerViewAccessibilityDelegate != null) {
            AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
            ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate$ItemDelegate ? ((RecyclerViewAccessibilityDelegate$ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view) : null);
        }
        if (z2) {
            dispatchViewRecycled(recyclerView$ViewHolder);
        }
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = null;
        getRecycledViewPool().putRecycledView(recyclerView$ViewHolder);
    }

    public void bindViewToPosition(@NonNull View view, int i) {
        RecyclerView$LayoutParams recyclerView$LayoutParams;
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null) {
            throw new IllegalArgumentException(a.n(this.this$0, a.U("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter")));
        }
        int iFindPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i);
        if (iFindPositionOffset < 0 || iFindPositionOffset >= this.this$0.mAdapter.getItemCount()) {
            StringBuilder sbW = a.W("Inconsistency detected. Invalid item position ", i, "(offset:", iFindPositionOffset, ").state:");
            sbW.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.n(this.this$0, sbW));
        }
        tryBindViewHolderByDeadline(childViewHolderInt, iFindPositionOffset, i, RecyclerView.FOREVER_NS);
        ViewGroup$LayoutParams layoutParams = childViewHolderInt.itemView.getLayoutParams();
        if (layoutParams == null) {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateDefaultLayoutParams();
            childViewHolderInt.itemView.setLayoutParams(recyclerView$LayoutParams);
        } else if (this.this$0.checkLayoutParams(layoutParams)) {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) layoutParams;
        } else {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateLayoutParams(layoutParams);
            childViewHolderInt.itemView.setLayoutParams(recyclerView$LayoutParams);
        }
        recyclerView$LayoutParams.mInsetsDirty = true;
        recyclerView$LayoutParams.mViewHolder = childViewHolderInt;
        recyclerView$LayoutParams.mPendingInvalidate = childViewHolderInt.itemView.getParent() == null;
    }

    public void clear() {
        this.mAttachedScrap.clear();
        recycleAndClearCachedViews();
    }

    public void clearOldPositions() {
        int size = this.mCachedViews.size();
        for (int i = 0; i < size; i++) {
            this.mCachedViews.get(i).clearOldPosition();
        }
        int size2 = this.mAttachedScrap.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.mAttachedScrap.get(i2).clearOldPosition();
        }
        ArrayList<RecyclerView$ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                this.mChangedScrap.get(i3).clearOldPosition();
            }
        }
    }

    public void clearScrap() {
        this.mAttachedScrap.clear();
        ArrayList<RecyclerView$ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public int convertPreLayoutPositionToPostLayout(int i) {
        if (i >= 0 && i < this.this$0.mState.getItemCount()) {
            return !this.this$0.mState.isPreLayout() ? i : this.this$0.mAdapterHelper.findPositionOffset(i);
        }
        StringBuilder sbV = a.V("invalid position ", i, ". State item count is ");
        sbV.append(this.this$0.mState.getItemCount());
        throw new IndexOutOfBoundsException(a.n(this.this$0, sbV));
    }

    public void dispatchViewRecycled(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        RecyclerView$RecyclerListener recyclerView$RecyclerListener = this.this$0.mRecyclerListener;
        if (recyclerView$RecyclerListener != null) {
            recyclerView$RecyclerListener.onViewRecycled(recyclerView$ViewHolder);
        }
        int size = this.this$0.mRecyclerListeners.size();
        for (int i = 0; i < size; i++) {
            this.this$0.mRecyclerListeners.get(i).onViewRecycled(recyclerView$ViewHolder);
        }
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.onViewRecycled(recyclerView$ViewHolder);
        }
        RecyclerView recyclerView = this.this$0;
        if (recyclerView.mState != null) {
            recyclerView.mViewInfoStore.removeViewHolder(recyclerView$ViewHolder);
        }
    }

    public RecyclerView$ViewHolder getChangedScrapViewForPosition(int i) {
        int size;
        int iFindPositionOffset;
        ArrayList<RecyclerView$ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList != null && (size = arrayList.size()) != 0) {
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView$ViewHolder recyclerView$ViewHolder = this.mChangedScrap.get(i2);
                if (!recyclerView$ViewHolder.wasReturnedFromScrap() && recyclerView$ViewHolder.getLayoutPosition() == i) {
                    recyclerView$ViewHolder.addFlags(32);
                    return recyclerView$ViewHolder;
                }
            }
            if (this.this$0.mAdapter.hasStableIds() && (iFindPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i)) > 0 && iFindPositionOffset < this.this$0.mAdapter.getItemCount()) {
                long itemId = this.this$0.mAdapter.getItemId(iFindPositionOffset);
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.mChangedScrap.get(i3);
                    if (!recyclerView$ViewHolder2.wasReturnedFromScrap() && recyclerView$ViewHolder2.getItemId() == itemId) {
                        recyclerView$ViewHolder2.addFlags(32);
                        return recyclerView$ViewHolder2;
                    }
                }
            }
        }
        return null;
    }

    public RecyclerView$RecycledViewPool getRecycledViewPool() {
        if (this.mRecyclerPool == null) {
            this.mRecyclerPool = new RecyclerView$RecycledViewPool();
        }
        return this.mRecyclerPool;
    }

    public int getScrapCount() {
        return this.mAttachedScrap.size();
    }

    @NonNull
    public List<RecyclerView$ViewHolder> getScrapList() {
        return this.mUnmodifiableAttachedScrap;
    }

    public RecyclerView$ViewHolder getScrapOrCachedViewForId(long j, int i, boolean z2) {
        for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mAttachedScrap.get(size);
            if (recyclerView$ViewHolder.getItemId() == j && !recyclerView$ViewHolder.wasReturnedFromScrap()) {
                if (i == recyclerView$ViewHolder.getItemViewType()) {
                    recyclerView$ViewHolder.addFlags(32);
                    if (recyclerView$ViewHolder.isRemoved() && !this.this$0.mState.isPreLayout()) {
                        recyclerView$ViewHolder.setFlags(2, 14);
                    }
                    return recyclerView$ViewHolder;
                }
                if (!z2) {
                    this.mAttachedScrap.remove(size);
                    this.this$0.removeDetachedView(recyclerView$ViewHolder.itemView, false);
                    quickRecycleScrapView(recyclerView$ViewHolder.itemView);
                }
            }
        }
        int size2 = this.mCachedViews.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return null;
            }
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.mCachedViews.get(size2);
            if (recyclerView$ViewHolder2.getItemId() == j && !recyclerView$ViewHolder2.isAttachedToTransitionOverlay()) {
                if (i == recyclerView$ViewHolder2.getItemViewType()) {
                    if (!z2) {
                        this.mCachedViews.remove(size2);
                    }
                    return recyclerView$ViewHolder2;
                }
                if (!z2) {
                    recycleCachedViewAt(size2);
                    return null;
                }
            }
        }
    }

    public RecyclerView$ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i, boolean z2) {
        View viewFindHiddenNonRemovedView;
        int size = this.mAttachedScrap.size();
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mAttachedScrap.get(i2);
            if (!recyclerView$ViewHolder.wasReturnedFromScrap() && recyclerView$ViewHolder.getLayoutPosition() == i && !recyclerView$ViewHolder.isInvalid() && (this.this$0.mState.mInPreLayout || !recyclerView$ViewHolder.isRemoved())) {
                recyclerView$ViewHolder.addFlags(32);
                return recyclerView$ViewHolder;
            }
        }
        if (z2 || (viewFindHiddenNonRemovedView = this.this$0.mChildHelper.findHiddenNonRemovedView(i)) == null) {
            int size2 = this.mCachedViews.size();
            for (int i3 = 0; i3 < size2; i3++) {
                RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.mCachedViews.get(i3);
                if (!recyclerView$ViewHolder2.isInvalid() && recyclerView$ViewHolder2.getLayoutPosition() == i && !recyclerView$ViewHolder2.isAttachedToTransitionOverlay()) {
                    if (!z2) {
                        this.mCachedViews.remove(i3);
                    }
                    return recyclerView$ViewHolder2;
                }
            }
            return null;
        }
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(viewFindHiddenNonRemovedView);
        this.this$0.mChildHelper.unhide(viewFindHiddenNonRemovedView);
        int iIndexOfChild = this.this$0.mChildHelper.indexOfChild(viewFindHiddenNonRemovedView);
        if (iIndexOfChild != -1) {
            this.this$0.mChildHelper.detachViewFromParent(iIndexOfChild);
            scrapView(viewFindHiddenNonRemovedView);
            childViewHolderInt.addFlags(8224);
            return childViewHolderInt;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("layout index should not be -1 after unhiding a view:");
        sb.append(childViewHolderInt);
        throw new IllegalStateException(a.n(this.this$0, sb));
    }

    public View getScrapViewAt(int i) {
        return this.mAttachedScrap.get(i).itemView;
    }

    @NonNull
    public View getViewForPosition(int i) {
        return getViewForPosition(i, false);
    }

    public void markItemDecorInsetsDirty() {
        int size = this.mCachedViews.size();
        for (int i = 0; i < size; i++) {
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.mCachedViews.get(i).itemView.getLayoutParams();
            if (recyclerView$LayoutParams != null) {
                recyclerView$LayoutParams.mInsetsDirty = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int size = this.mCachedViews.size();
        for (int i = 0; i < size; i++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(i);
            if (recyclerView$ViewHolder != null) {
                recyclerView$ViewHolder.addFlags(6);
                recyclerView$ViewHolder.addChangePayload(null);
            }
        }
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        if (recyclerView$Adapter == null || !recyclerView$Adapter.hasStableIds()) {
            recycleAndClearCachedViews();
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int size = this.mCachedViews.size();
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(i3);
            if (recyclerView$ViewHolder != null && recyclerView$ViewHolder.mPosition >= i) {
                recyclerView$ViewHolder.offsetPosition(i2, false);
            }
        }
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i < i2) {
            i3 = -1;
            i5 = i;
            i4 = i2;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.mCachedViews.size();
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(i7);
            if (recyclerView$ViewHolder != null && (i6 = recyclerView$ViewHolder.mPosition) >= i5 && i6 <= i4) {
                if (i6 == i) {
                    recyclerView$ViewHolder.offsetPosition(i2 - i, false);
                } else {
                    recyclerView$ViewHolder.offsetPosition(i3, false);
                }
            }
        }
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z2) {
        int i3 = i + i2;
        for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(size);
            if (recyclerView$ViewHolder != null) {
                int i4 = recyclerView$ViewHolder.mPosition;
                if (i4 >= i3) {
                    recyclerView$ViewHolder.offsetPosition(-i2, z2);
                } else if (i4 >= i) {
                    recyclerView$ViewHolder.addFlags(8);
                    recycleCachedViewAt(size);
                }
            }
        }
    }

    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2, boolean z2) {
        clear();
        getRecycledViewPool().onAdapterChanged(recyclerView$Adapter, recyclerView$Adapter2, z2);
    }

    public void quickRecycleScrapView(View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.mScrapContainer = null;
        childViewHolderInt.mInChangeScrap = false;
        childViewHolderInt.clearReturnedFromScrapFlag();
        recycleViewHolderInternal(childViewHolderInt);
    }

    public void recycleAndClearCachedViews() {
        for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
            recycleCachedViewAt(size);
        }
        this.mCachedViews.clear();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        }
    }

    public void recycleCachedViewAt(int i) {
        addViewHolderToRecycledViewPool(this.mCachedViews.get(i), true);
        this.mCachedViews.remove(i);
    }

    public void recycleView(@NonNull View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isTmpDetached()) {
            this.this$0.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        } else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        recycleViewHolderInternal(childViewHolderInt);
        if (this.this$0.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
            return;
        }
        this.this$0.mItemAnimator.endAnimation(childViewHolderInt);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0091 A[PHI: r1
      0x0091: PHI (r1v19 boolean) = (r1v6 boolean), (r1v0 boolean) binds: [B:41:0x008b, B:20:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    public void recycleViewHolderInternal(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean z2 = false;
        boolean z3 = true;
        if (recyclerView$ViewHolder.isScrap() || recyclerView$ViewHolder.itemView.getParent() != null) {
            StringBuilder sbU = a.U("Scrapped or attached views may not be recycled. isScrap:");
            sbU.append(recyclerView$ViewHolder.isScrap());
            sbU.append(" isAttached:");
            sbU.append(recyclerView$ViewHolder.itemView.getParent() != null);
            throw new IllegalArgumentException(a.n(this.this$0, sbU));
        }
        if (recyclerView$ViewHolder.isTmpDetached()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            sb.append(recyclerView$ViewHolder);
            throw new IllegalArgumentException(a.n(this.this$0, sb));
        }
        if (recyclerView$ViewHolder.shouldIgnore()) {
            throw new IllegalArgumentException(a.n(this.this$0, a.U("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }
        boolean zDoesTransientStatePreventRecycling = recyclerView$ViewHolder.doesTransientStatePreventRecycling();
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        if ((recyclerView$Adapter != null && zDoesTransientStatePreventRecycling && recyclerView$Adapter.onFailedToRecycleView(recyclerView$ViewHolder)) || recyclerView$ViewHolder.isRecyclable()) {
            if (this.mViewCacheMax <= 0 || recyclerView$ViewHolder.hasAnyOfTheFlags(526)) {
                z2 = false;
            } else {
                int size = this.mCachedViews.size();
                if (size >= this.mViewCacheMax && size > 0) {
                    recycleCachedViewAt(0);
                    size--;
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(recyclerView$ViewHolder.mPosition)) {
                    do {
                        size--;
                        if (size < 0) {
                            break;
                        }
                    } while (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(size).mPosition));
                    size++;
                }
                this.mCachedViews.add(size, recyclerView$ViewHolder);
                z2 = true;
            }
            if (z2) {
                z3 = false;
            } else {
                addViewHolderToRecycledViewPool(recyclerView$ViewHolder, true);
            }
        } else {
            z3 = false;
        }
        this.this$0.mViewInfoStore.removeViewHolder(recyclerView$ViewHolder);
        if (z2 || z3 || !zDoesTransientStatePreventRecycling) {
            return;
        }
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = null;
    }

    public void scrapView(View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !this.this$0.canReuseUpdatedViewHolder(childViewHolderInt)) {
            if (this.mChangedScrap == null) {
                this.mChangedScrap = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.mChangedScrap.add(childViewHolderInt);
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.this$0.mAdapter.hasStableIds()) {
            throw new IllegalArgumentException(a.n(this.this$0, a.U("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        childViewHolderInt.setScrapContainer(this, false);
        this.mAttachedScrap.add(childViewHolderInt);
    }

    public void setRecycledViewPool(RecyclerView$RecycledViewPool recyclerView$RecycledViewPool) {
        RecyclerView$RecycledViewPool recyclerView$RecycledViewPool2 = this.mRecyclerPool;
        if (recyclerView$RecycledViewPool2 != null) {
            recyclerView$RecycledViewPool2.detach();
        }
        this.mRecyclerPool = recyclerView$RecycledViewPool;
        if (recyclerView$RecycledViewPool == null || this.this$0.getAdapter() == null) {
            return;
        }
        this.mRecyclerPool.attach();
    }

    public void setViewCacheExtension(RecyclerView$ViewCacheExtension recyclerView$ViewCacheExtension) {
        this.mViewCacheExtension = recyclerView$ViewCacheExtension;
    }

    public void setViewCacheSize(int i) {
        this.mRequestedCacheMax = i;
        updateViewCacheSize();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:106:0x01fc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0155 A[PHI: r1 r5
      0x0155: PHI (r1v13 androidx.recyclerview.widget.RecyclerView$ViewHolder) = 
      (r1v12 androidx.recyclerview.widget.RecyclerView$ViewHolder)
      (r1v33 androidx.recyclerview.widget.RecyclerView$ViewHolder)
     binds: [B:28:0x005d, B:59:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x0155: PHI (r5v3 boolean) = (r5v2 boolean), (r5v5 boolean) binds: [B:28:0x005d, B:59:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x0176  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d2  */
    @Nullable
    public RecyclerView$ViewHolder tryGetViewHolderForPositionByDeadline(int i, boolean z2, long j) {
        RecyclerView$ViewHolder childViewHolder;
        boolean z3;
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        boolean z4;
        ViewGroup$LayoutParams layoutParams;
        RecyclerView$LayoutParams recyclerView$LayoutParams;
        int iFindPositionOffset;
        RecyclerView recyclerViewFindNestedRecyclerView;
        RecyclerView$ViewCacheExtension recyclerView$ViewCacheExtension;
        View viewForPositionAndType;
        if (i < 0 || i >= this.this$0.mState.getItemCount()) {
            StringBuilder sbW = a.W("Invalid item position ", i, "(", i, "). Item count:");
            sbW.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.n(this.this$0, sbW));
        }
        if (this.this$0.mState.isPreLayout()) {
            childViewHolder = getChangedScrapViewForPosition(i);
            z3 = childViewHolder != null;
            if (childViewHolder == null && (childViewHolder = getScrapOrHiddenOrCachedHolderForPosition(i, z2)) != null) {
                if (validateViewHolderForOffsetPosition(childViewHolder)) {
                    z3 = true;
                } else {
                    if (!z2) {
                        childViewHolder.addFlags(4);
                        if (childViewHolder.isScrap()) {
                            this.this$0.removeDetachedView(childViewHolder.itemView, false);
                            childViewHolder.unScrap();
                        } else if (childViewHolder.wasReturnedFromScrap()) {
                            childViewHolder.clearReturnedFromScrapFlag();
                        }
                        recycleViewHolderInternal(childViewHolder);
                    }
                    childViewHolder = null;
                }
            }
            if (childViewHolder == null) {
                recyclerView$ViewHolder = childViewHolder;
            } else {
                iFindPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i);
                if (iFindPositionOffset >= 0 || iFindPositionOffset >= this.this$0.mAdapter.getItemCount()) {
                    StringBuilder sbW2 = a.W("Inconsistency detected. Invalid item position ", i, "(offset:", iFindPositionOffset, ").state:");
                    sbW2.append(this.this$0.mState.getItemCount());
                    throw new IndexOutOfBoundsException(a.n(this.this$0, sbW2));
                }
                int itemViewType = this.this$0.mAdapter.getItemViewType(iFindPositionOffset);
                if (this.this$0.mAdapter.hasStableIds() && (childViewHolder = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(iFindPositionOffset), itemViewType, z2)) != null) {
                    childViewHolder.mPosition = iFindPositionOffset;
                    z3 = true;
                }
                if (childViewHolder == null && (recyclerView$ViewCacheExtension = this.mViewCacheExtension) != null && (viewForPositionAndType = recyclerView$ViewCacheExtension.getViewForPositionAndType(this, i, itemViewType)) != null) {
                    childViewHolder = this.this$0.getChildViewHolder(viewForPositionAndType);
                    if (childViewHolder == null) {
                        throw new IllegalArgumentException(a.n(this.this$0, a.U("getViewForPositionAndType returned a view which does not have a ViewHolder")));
                    }
                    if (childViewHolder.shouldIgnore()) {
                        throw new IllegalArgumentException(a.n(this.this$0, a.U("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.")));
                    }
                }
                if (childViewHolder == null) {
                    RecyclerView$ViewHolder recycledView = getRecycledViewPool().getRecycledView(itemViewType);
                    if (recycledView != null) {
                        recycledView.resetInternal();
                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                            invalidateDisplayListInt(recycledView);
                        }
                    }
                    childViewHolder = recycledView;
                }
                if (childViewHolder == null) {
                    long nanoTime = this.this$0.getNanoTime();
                    if (j != RecyclerView.FOREVER_NS && !this.mRecyclerPool.willCreateInTime(itemViewType, nanoTime, j)) {
                        return null;
                    }
                    RecyclerView recyclerView = this.this$0;
                    RecyclerView$ViewHolder recyclerView$ViewHolderCreateViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && (recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(recyclerView$ViewHolderCreateViewHolder.itemView)) != null) {
                        recyclerView$ViewHolderCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewFindNestedRecyclerView);
                    }
                    this.mRecyclerPool.factorInCreateTime(itemViewType, this.this$0.getNanoTime() - nanoTime);
                    recyclerView$ViewHolder = recyclerView$ViewHolderCreateViewHolder;
                } else {
                    recyclerView$ViewHolder = childViewHolder;
                }
            }
            z4 = z3;
            if (z4 && !this.this$0.mState.isPreLayout() && recyclerView$ViewHolder.hasAnyOfTheFlags(8192)) {
                recyclerView$ViewHolder.setFlags(0, 8192);
                if (this.this$0.mState.mRunSimpleAnimations) {
                    int iBuildAdapterChangeFlagsForAnimations = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations(recyclerView$ViewHolder) | 4096;
                    RecyclerView recyclerView2 = this.this$0;
                    this.this$0.recordAnimationInfoIfBouncedHiddenView(recyclerView$ViewHolder, recyclerView2.mItemAnimator.recordPreLayoutInformation(recyclerView2.mState, recyclerView$ViewHolder, iBuildAdapterChangeFlagsForAnimations, recyclerView$ViewHolder.getUnmodifiedPayloads()));
                }
            }
            if (this.this$0.mState.isPreLayout() || !recyclerView$ViewHolder.isBound()) {
                boolean zTryBindViewHolderByDeadline = (recyclerView$ViewHolder.isBound() || recyclerView$ViewHolder.needsUpdate() || recyclerView$ViewHolder.isInvalid()) ? tryBindViewHolderByDeadline(recyclerView$ViewHolder, this.this$0.mAdapterHelper.findPositionOffset(i), i, j) : false;
                layoutParams = recyclerView$ViewHolder.itemView.getLayoutParams();
                if (layoutParams == null) {
                    recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateDefaultLayoutParams();
                    recyclerView$ViewHolder.itemView.setLayoutParams(recyclerView$LayoutParams);
                } else if (this.this$0.checkLayoutParams(layoutParams)) {
                    recyclerView$LayoutParams = (RecyclerView$LayoutParams) layoutParams;
                } else {
                    recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateLayoutParams(layoutParams);
                    recyclerView$ViewHolder.itemView.setLayoutParams(recyclerView$LayoutParams);
                }
                recyclerView$LayoutParams.mViewHolder = recyclerView$ViewHolder;
                recyclerView$LayoutParams.mPendingInvalidate = !z4 && zTryBindViewHolderByDeadline;
                return recyclerView$ViewHolder;
            }
            recyclerView$ViewHolder.mPreLayoutPosition = i;
            layoutParams = recyclerView$ViewHolder.itemView.getLayoutParams();
            if (layoutParams == null) {
                recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateDefaultLayoutParams();
                recyclerView$ViewHolder.itemView.setLayoutParams(recyclerView$LayoutParams);
            } else if (this.this$0.checkLayoutParams(layoutParams)) {
                recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateLayoutParams(layoutParams);
                recyclerView$ViewHolder.itemView.setLayoutParams(recyclerView$LayoutParams);
            } else {
                recyclerView$LayoutParams = (RecyclerView$LayoutParams) layoutParams;
            }
            recyclerView$LayoutParams.mViewHolder = recyclerView$ViewHolder;
            recyclerView$LayoutParams.mPendingInvalidate = !z4 && zTryBindViewHolderByDeadline;
            return recyclerView$ViewHolder;
        }
        childViewHolder = null;
        if (childViewHolder == null) {
            if (validateViewHolderForOffsetPosition(childViewHolder)) {
                if (!z2) {
                    childViewHolder.addFlags(4);
                    if (childViewHolder.isScrap()) {
                        this.this$0.removeDetachedView(childViewHolder.itemView, false);
                        childViewHolder.unScrap();
                    } else if (childViewHolder.wasReturnedFromScrap()) {
                        childViewHolder.clearReturnedFromScrapFlag();
                    }
                    recycleViewHolderInternal(childViewHolder);
                }
                childViewHolder = null;
            } else {
                z3 = true;
            }
        }
        if (childViewHolder == null) {
            iFindPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i);
            if (iFindPositionOffset >= 0) {
            }
            StringBuilder sbW3 = a.W("Inconsistency detected. Invalid item position ", i, "(offset:", iFindPositionOffset, ").state:");
            sbW3.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.n(this.this$0, sbW3));
        }
        recyclerView$ViewHolder = childViewHolder;
        z4 = z3;
        if (z4) {
            recyclerView$ViewHolder.setFlags(0, 8192);
            if (this.this$0.mState.mRunSimpleAnimations) {
                int iBuildAdapterChangeFlagsForAnimations2 = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations(recyclerView$ViewHolder) | 4096;
                RecyclerView recyclerView3 = this.this$0;
                this.this$0.recordAnimationInfoIfBouncedHiddenView(recyclerView$ViewHolder, recyclerView3.mItemAnimator.recordPreLayoutInformation(recyclerView3.mState, recyclerView$ViewHolder, iBuildAdapterChangeFlagsForAnimations2, recyclerView$ViewHolder.getUnmodifiedPayloads()));
            }
        }
        if (this.this$0.mState.isPreLayout()) {
            if (recyclerView$ViewHolder.isBound()) {
            }
        } else {
            if (recyclerView$ViewHolder.isBound()) {
            }
        }
        layoutParams = recyclerView$ViewHolder.itemView.getLayoutParams();
        if (layoutParams == null) {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateDefaultLayoutParams();
            recyclerView$ViewHolder.itemView.setLayoutParams(recyclerView$LayoutParams);
        } else if (this.this$0.checkLayoutParams(layoutParams)) {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateLayoutParams(layoutParams);
            recyclerView$ViewHolder.itemView.setLayoutParams(recyclerView$LayoutParams);
        } else {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) layoutParams;
        }
        recyclerView$LayoutParams.mViewHolder = recyclerView$ViewHolder;
        recyclerView$LayoutParams.mPendingInvalidate = !z4 && zTryBindViewHolderByDeadline;
        return recyclerView$ViewHolder;
    }

    public void unscrapView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (recyclerView$ViewHolder.mInChangeScrap) {
            this.mChangedScrap.remove(recyclerView$ViewHolder);
        } else {
            this.mAttachedScrap.remove(recyclerView$ViewHolder);
        }
        recyclerView$ViewHolder.mScrapContainer = null;
        recyclerView$ViewHolder.mInChangeScrap = false;
        recyclerView$ViewHolder.clearReturnedFromScrapFlag();
    }

    public void updateViewCacheSize() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.this$0.mLayout;
        this.mViewCacheMax = this.mRequestedCacheMax + (recyclerView$LayoutManager != null ? recyclerView$LayoutManager.mPrefetchMaxCountObserved : 0);
        for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
            recycleCachedViewAt(size);
        }
    }

    public boolean validateViewHolderForOffsetPosition(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (recyclerView$ViewHolder.isRemoved()) {
            return this.this$0.mState.isPreLayout();
        }
        int i = recyclerView$ViewHolder.mPosition;
        if (i < 0 || i >= this.this$0.mAdapter.getItemCount()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistency detected. Invalid view holder adapter position");
            sb.append(recyclerView$ViewHolder);
            throw new IndexOutOfBoundsException(a.n(this.this$0, sb));
        }
        if (this.this$0.mState.isPreLayout() || this.this$0.mAdapter.getItemViewType(recyclerView$ViewHolder.mPosition) == recyclerView$ViewHolder.getItemViewType()) {
            return !this.this$0.mAdapter.hasStableIds() || recyclerView$ViewHolder.getItemId() == this.this$0.mAdapter.getItemId(recyclerView$ViewHolder.mPosition);
        }
        return false;
    }

    public void viewRangeUpdate(int i, int i2) {
        int i3;
        int i4 = i2 + i;
        for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(size);
            if (recyclerView$ViewHolder != null && (i3 = recyclerView$ViewHolder.mPosition) >= i && i3 < i4) {
                recyclerView$ViewHolder.addFlags(2);
                recycleCachedViewAt(size);
            }
        }
    }

    public View getViewForPosition(int i, boolean z2) {
        return tryGetViewHolderForPositionByDeadline(i, z2, RecyclerView.FOREVER_NS).itemView;
    }

    private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) childAt, true);
            }
        }
        if (z2) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }
}
