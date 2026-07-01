package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class NestedAdapterWrapper {
    public final RecyclerView$Adapter<RecyclerView$ViewHolder> adapter;
    private RecyclerView$AdapterDataObserver mAdapterObserver = new NestedAdapterWrapper$1(this);
    public int mCachedItemCount;
    public final NestedAdapterWrapper$Callback mCallback;

    @NonNull
    private final StableIdStorage$StableIdLookup mStableIdLookup;

    @NonNull
    private final ViewTypeStorage$ViewTypeLookup mViewTypeLookup;

    public NestedAdapterWrapper(RecyclerView$Adapter<RecyclerView$ViewHolder> recyclerView$Adapter, NestedAdapterWrapper$Callback nestedAdapterWrapper$Callback, ViewTypeStorage viewTypeStorage, StableIdStorage$StableIdLookup stableIdStorage$StableIdLookup) {
        this.adapter = recyclerView$Adapter;
        this.mCallback = nestedAdapterWrapper$Callback;
        this.mViewTypeLookup = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdStorage$StableIdLookup;
        this.mCachedItemCount = recyclerView$Adapter.getItemCount();
        recyclerView$Adapter.registerAdapterDataObserver(this.mAdapterObserver);
    }

    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int i) {
        return this.mStableIdLookup.localToGlobal(this.adapter.getItemId(i));
    }

    public int getItemViewType(int i) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(i));
    }

    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        this.adapter.bindViewHolder(recyclerView$ViewHolder, i);
    }

    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.adapter.onCreateViewHolder(viewGroup, this.mViewTypeLookup.globalToLocal(i));
    }
}
