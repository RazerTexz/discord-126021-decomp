package androidx.recyclerview.widget;

import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerView$Adapter<VH extends RecyclerView$ViewHolder> {
    private final RecyclerView$AdapterDataObservable mObservable = new RecyclerView$AdapterDataObservable();
    private boolean mHasStableIds = false;
    private RecyclerView$Adapter$StateRestorationPolicy mStateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.ALLOW;

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindViewHolder(@NonNull VH vh, int i) {
        boolean z2 = vh.mBindingAdapter == null;
        if (z2) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
        }
        vh.mBindingAdapter = this;
        onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
        if (z2) {
            vh.clearPayload();
            ViewGroup$LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof RecyclerView$LayoutParams) {
                ((RecyclerView$LayoutParams) layoutParams).mInsetsDirty = true;
            }
            TraceCompat.endSection();
        }
    }

    public boolean canRestoreState() {
        int iOrdinal = this.mStateRestorationPolicy.ordinal();
        if (iOrdinal != 1) {
            return iOrdinal != 2;
        }
        return getItemCount() > 0;
    }

    @NonNull
    public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
        try {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
            VH vh = (VH) onCreateViewHolder(viewGroup, i);
            if (vh.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            vh.mItemViewType = i;
            TraceCompat.endSection();
            return vh;
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    public int findRelativeAdapterPositionIn(@NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        if (recyclerView$Adapter == this) {
            return i;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i) {
        return -1L;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    @NonNull
    public final RecyclerView$Adapter$StateRestorationPolicy getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.hasObservers();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public final void notifyItemChanged(int i) {
        this.mObservable.notifyItemRangeChanged(i, 1);
    }

    public final void notifyItemInserted(int i) {
        this.mObservable.notifyItemRangeInserted(i, 1);
    }

    public final void notifyItemMoved(int i, int i2) {
        this.mObservable.notifyItemMoved(i, i2);
    }

    public final void notifyItemRangeChanged(int i, int i2) {
        this.mObservable.notifyItemRangeChanged(i, i2);
    }

    public final void notifyItemRangeInserted(int i, int i2) {
        this.mObservable.notifyItemRangeInserted(i, i2);
    }

    public final void notifyItemRangeRemoved(int i, int i2) {
        this.mObservable.notifyItemRangeRemoved(i, i2);
    }

    public final void notifyItemRemoved(int i) {
        this.mObservable.notifyItemRangeRemoved(i, 1);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(@NonNull VH vh, int i);

    public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
        onBindViewHolder(vh, i);
    }

    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(@NonNull VH vh) {
        return false;
    }

    public void onViewAttachedToWindow(@NonNull VH vh) {
    }

    public void onViewDetachedFromWindow(@NonNull VH vh) {
    }

    public void onViewRecycled(@NonNull VH vh) {
    }

    public void registerAdapterDataObserver(@NonNull RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver) {
        this.mObservable.registerObserver(recyclerView$AdapterDataObserver);
    }

    public void setHasStableIds(boolean z2) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z2;
    }

    public void setStateRestorationPolicy(@NonNull RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy) {
        this.mStateRestorationPolicy = recyclerView$Adapter$StateRestorationPolicy;
        this.mObservable.notifyStateRestorationPolicyChanged();
    }

    public void unregisterAdapterDataObserver(@NonNull RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver) {
        this.mObservable.unregisterObserver(recyclerView$AdapterDataObserver);
    }

    public final void notifyItemChanged(int i, @Nullable Object obj) {
        this.mObservable.notifyItemRangeChanged(i, 1, obj);
    }

    public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.mObservable.notifyItemRangeChanged(i, i2, obj);
    }
}
