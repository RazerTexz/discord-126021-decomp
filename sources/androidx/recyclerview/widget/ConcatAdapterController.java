package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import b.d.b.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConcatAdapterController implements NestedAdapterWrapper$Callback {
    private final ConcatAdapter mConcatAdapter;

    @NonNull
    private final ConcatAdapter$Config$StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List<WeakReference<RecyclerView>> mAttachedRecyclerViews = new ArrayList();
    private final IdentityHashMap<RecyclerView$ViewHolder, NestedAdapterWrapper> mBinderLookup = new IdentityHashMap<>();
    private List<NestedAdapterWrapper> mWrappers = new ArrayList();
    private ConcatAdapterController$WrapperAndLocalPosition mReusableHolder = new ConcatAdapterController$WrapperAndLocalPosition();

    public ConcatAdapterController(ConcatAdapter concatAdapter, ConcatAdapter$Config concatAdapter$Config) {
        this.mConcatAdapter = concatAdapter;
        if (concatAdapter$Config.isolateViewTypes) {
            this.mViewTypeStorage = new ViewTypeStorage$IsolatedViewTypeStorage();
        } else {
            this.mViewTypeStorage = new ViewTypeStorage$SharedIdRangeViewTypeStorage();
        }
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode = concatAdapter$Config.stableIdMode;
        this.mStableIdMode = concatAdapter$Config$StableIdMode;
        if (concatAdapter$Config$StableIdMode == ConcatAdapter$Config$StableIdMode.NO_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage$NoStableIdStorage();
        } else if (concatAdapter$Config$StableIdMode == ConcatAdapter$Config$StableIdMode.ISOLATED_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage$IsolatedStableIdStorage();
        } else {
            if (concatAdapter$Config$StableIdMode != ConcatAdapter$Config$StableIdMode.SHARED_STABLE_IDS) {
                throw new IllegalArgumentException("unknown stable id mode");
            }
            this.mStableIdStorage = new StableIdStorage$SharedPoolStableIdStorage();
        }
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicyComputeStateRestorationPolicy = computeStateRestorationPolicy();
        if (recyclerView$Adapter$StateRestorationPolicyComputeStateRestorationPolicy != this.mConcatAdapter.getStateRestorationPolicy()) {
            this.mConcatAdapter.internalSetStateRestorationPolicy(recyclerView$Adapter$StateRestorationPolicyComputeStateRestorationPolicy);
        }
    }

    private RecyclerView$Adapter$StateRestorationPolicy computeStateRestorationPolicy() {
        for (NestedAdapterWrapper nestedAdapterWrapper : this.mWrappers) {
            RecyclerView$Adapter$StateRestorationPolicy stateRestorationPolicy = nestedAdapterWrapper.adapter.getStateRestorationPolicy();
            RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == recyclerView$Adapter$StateRestorationPolicy) {
                return recyclerView$Adapter$StateRestorationPolicy;
            }
            if (stateRestorationPolicy == RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY && nestedAdapterWrapper.getCachedItemCount() == 0) {
                return recyclerView$Adapter$StateRestorationPolicy;
            }
        }
        return RecyclerView$Adapter$StateRestorationPolicy.ALLOW;
    }

    private int countItemsBefore(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper next;
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int cachedItemCount = 0;
        while (it.hasNext() && (next = it.next()) != nestedAdapterWrapper) {
            cachedItemCount += next.getCachedItemCount();
        }
        return cachedItemCount;
    }

    @NonNull
    private ConcatAdapterController$WrapperAndLocalPosition findWrapperAndLocalPosition(int i) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPosition = this.mReusableHolder;
        if (concatAdapterController$WrapperAndLocalPosition.mInUse) {
            concatAdapterController$WrapperAndLocalPosition = new ConcatAdapterController$WrapperAndLocalPosition();
        } else {
            concatAdapterController$WrapperAndLocalPosition.mInUse = true;
        }
        int cachedItemCount = i;
        for (NestedAdapterWrapper nestedAdapterWrapper : this.mWrappers) {
            if (nestedAdapterWrapper.getCachedItemCount() > cachedItemCount) {
                concatAdapterController$WrapperAndLocalPosition.mWrapper = nestedAdapterWrapper;
                concatAdapterController$WrapperAndLocalPosition.mLocalPosition = cachedItemCount;
                break;
            }
            cachedItemCount -= nestedAdapterWrapper.getCachedItemCount();
        }
        if (concatAdapterController$WrapperAndLocalPosition.mWrapper != null) {
            return concatAdapterController$WrapperAndLocalPosition;
        }
        throw new IllegalArgumentException(a.q("Cannot find wrapper for ", i));
    }

    @Nullable
    private NestedAdapterWrapper findWrapperFor(RecyclerView$Adapter<RecyclerView$ViewHolder> recyclerView$Adapter) {
        int iIndexOfWrapper = indexOfWrapper(recyclerView$Adapter);
        if (iIndexOfWrapper == -1) {
            return null;
        }
        return this.mWrappers.get(iIndexOfWrapper);
    }

    @NonNull
    private NestedAdapterWrapper getWrapper(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(recyclerView$ViewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        throw new IllegalStateException("Cannot find wrapper for " + recyclerView$ViewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    private int indexOfWrapper(RecyclerView$Adapter<RecyclerView$ViewHolder> recyclerView$Adapter) {
        int size = this.mWrappers.size();
        for (int i = 0; i < size; i++) {
            if (this.mWrappers.get(i).adapter == recyclerView$Adapter) {
                return i;
            }
        }
        return -1;
    }

    private boolean isAttachedTo(RecyclerView recyclerView) {
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            if (it.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    private void releaseWrapperAndLocalPosition(ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPosition) {
        concatAdapterController$WrapperAndLocalPosition.mInUse = false;
        concatAdapterController$WrapperAndLocalPosition.mWrapper = null;
        concatAdapterController$WrapperAndLocalPosition.mLocalPosition = -1;
        this.mReusableHolder = concatAdapterController$WrapperAndLocalPosition;
    }

    public boolean addAdapter(RecyclerView$Adapter<RecyclerView$ViewHolder> recyclerView$Adapter) {
        return addAdapter(this.mWrappers.size(), recyclerView$Adapter);
    }

    public boolean canRestoreState() {
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            if (!it.next().adapter.canRestoreState()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public RecyclerView$Adapter<? extends RecyclerView$ViewHolder> getBoundAdapter(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(recyclerView$ViewHolder);
        if (nestedAdapterWrapper == null) {
            return null;
        }
        return nestedAdapterWrapper.adapter;
    }

    public List<RecyclerView$Adapter<? extends RecyclerView$ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().adapter);
        }
        return arrayList;
    }

    public long getItemId(int i) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i);
        long itemId = concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.getItemId(concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition);
        return itemId;
    }

    public int getItemViewType(int i) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i);
        int itemViewType = concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.getItemViewType(concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition);
        return itemViewType;
    }

    public int getLocalAdapterPosition(RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter, RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(recyclerView$ViewHolder);
        if (nestedAdapterWrapper == null) {
            return -1;
        }
        int iCountItemsBefore = i - countItemsBefore(nestedAdapterWrapper);
        int pageSize = nestedAdapterWrapper.adapter.getPageSize();
        if (iCountItemsBefore >= 0 && iCountItemsBefore < pageSize) {
            return nestedAdapterWrapper.adapter.findRelativeAdapterPositionIn(recyclerView$Adapter, recyclerView$ViewHolder, iCountItemsBefore);
        }
        StringBuilder sbW = a.W("Detected inconsistent adapter updates. The local position of the view holder maps to ", iCountItemsBefore, " which is out of bounds for the adapter with size ", pageSize, ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        sbW.append(recyclerView$ViewHolder);
        sbW.append("adapter:");
        sbW.append(recyclerView$Adapter);
        throw new IllegalStateException(sbW.toString());
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int cachedItemCount = 0;
        while (it.hasNext()) {
            cachedItemCount += it.next().getCachedItemCount();
        }
        return cachedItemCount;
    }

    public boolean hasStableIds() {
        return this.mStableIdMode != ConcatAdapter$Config$StableIdMode.NO_STABLE_IDS;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (isAttachedTo(recyclerView)) {
            return;
        }
        this.mAttachedRecyclerViews.add(new WeakReference<>(recyclerView));
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        ConcatAdapterController$WrapperAndLocalPosition concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i);
        this.mBinderLookup.put(recyclerView$ViewHolder, concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper);
        concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.onBindViewHolder(recyclerView$ViewHolder, concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(concatAdapterController$WrapperAndLocalPositionFindWrapperAndLocalPosition);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        this.mConcatAdapter.notifyDataSetChanged();
        calculateAndUpdateStateRestorationPolicy();
    }

    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.mViewTypeStorage.getWrapperForGlobalType(i).onCreateViewHolder(viewGroup, i);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        for (int size = this.mAttachedRecyclerViews.size() - 1; size >= 0; size--) {
            WeakReference<RecyclerView> weakReference = this.mAttachedRecyclerViews.get(size);
            if (weakReference.get() != null) {
                if (weakReference.get() == recyclerView) {
                    this.mAttachedRecyclerViews.remove(size);
                    break;
                }
            } else {
                this.mAttachedRecyclerViews.remove(size);
            }
        }
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(recyclerView$ViewHolder);
        if (nestedAdapterWrapper != null) {
            boolean zOnFailedToRecycleView = nestedAdapterWrapper.adapter.onFailedToRecycleView(recyclerView$ViewHolder);
            this.mBinderLookup.remove(recyclerView$ViewHolder);
            return zOnFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + recyclerView$ViewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.mConcatAdapter.notifyItemRangeChanged(i + countItemsBefore(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.mConcatAdapter.notifyItemRangeInserted(i + countItemsBefore(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        int iCountItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemMoved(i + iCountItemsBefore, i2 + iCountItemsBefore);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.mConcatAdapter.notifyItemRangeRemoved(i + countItemsBefore(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper) {
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        getWrapper(recyclerView$ViewHolder).adapter.onViewAttachedToWindow(recyclerView$ViewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        getWrapper(recyclerView$ViewHolder).adapter.onViewDetachedFromWindow(recyclerView$ViewHolder);
    }

    public void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(recyclerView$ViewHolder);
        if (nestedAdapterWrapper != null) {
            nestedAdapterWrapper.adapter.onViewRecycled(recyclerView$ViewHolder);
            this.mBinderLookup.remove(recyclerView$ViewHolder);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + recyclerView$ViewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean removeAdapter(RecyclerView$Adapter<RecyclerView$ViewHolder> recyclerView$Adapter) {
        int iIndexOfWrapper = indexOfWrapper(recyclerView$Adapter);
        if (iIndexOfWrapper == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrappers.get(iIndexOfWrapper);
        int iCountItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mWrappers.remove(iIndexOfWrapper);
        this.mConcatAdapter.notifyItemRangeRemoved(iCountItemsBefore, nestedAdapterWrapper.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                recyclerView$Adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        nestedAdapterWrapper.dispose();
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    public boolean addAdapter(int i, RecyclerView$Adapter<RecyclerView$ViewHolder> recyclerView$Adapter) {
        if (i < 0 || i > this.mWrappers.size()) {
            StringBuilder sbU = a.U("Index must be between 0 and ");
            sbU.append(this.mWrappers.size());
            sbU.append(". Given:");
            sbU.append(i);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (hasStableIds()) {
            Preconditions.checkArgument(recyclerView$Adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (recyclerView$Adapter.hasStableIds()) {
            Log.w(ConcatAdapter.TAG, "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (findWrapperFor(recyclerView$Adapter) != null) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper(recyclerView$Adapter, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
        this.mWrappers.add(i, nestedAdapterWrapper);
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                recyclerView$Adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (nestedAdapterWrapper.getCachedItemCount() > 0) {
            this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(nestedAdapterWrapper), nestedAdapterWrapper.getCachedItemCount());
        }
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper$Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2, @Nullable Object obj) {
        this.mConcatAdapter.notifyItemRangeChanged(i + countItemsBefore(nestedAdapterWrapper), i2, obj);
    }
}
