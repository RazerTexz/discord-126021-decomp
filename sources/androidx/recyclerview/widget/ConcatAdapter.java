package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ConcatAdapter extends RecyclerView$Adapter<RecyclerView$ViewHolder> {
    public static final String TAG = "ConcatAdapter";
    private final ConcatAdapterController mController;

    @SafeVarargs
    public ConcatAdapter(@NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder>... recyclerView$AdapterArr) {
        this(ConcatAdapter$Config.DEFAULT, recyclerView$AdapterArr);
    }

    public boolean addAdapter(@NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter) {
        return this.mController.addAdapter(recyclerView$Adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int findRelativeAdapterPositionIn(@NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        return this.mController.getLocalAdapterPosition(recyclerView$Adapter, recyclerView$ViewHolder, i);
    }

    @NonNull
    public List<? extends RecyclerView$Adapter<? extends RecyclerView$ViewHolder>> getAdapters() {
        return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.mController.getTotalCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int i) {
        return this.mController.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int i) {
        return this.mController.getItemViewType(i);
    }

    public void internalSetStateRestorationPolicy(@NonNull RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy) {
        super.setStateRestorationPolicy(recyclerView$Adapter$StateRestorationPolicy);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mController.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        this.mController.onBindViewHolder(recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    @NonNull
    public RecyclerView$ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return this.mController.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mController.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mController.onFailedToRecycleView(recyclerView$ViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mController.onViewAttachedToWindow(recyclerView$ViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mController.onViewDetachedFromWindow(recyclerView$ViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onViewRecycled(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mController.onViewRecycled(recyclerView$ViewHolder);
    }

    public boolean removeAdapter(@NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter) {
        return this.mController.removeAdapter(recyclerView$Adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void setHasStableIds(boolean z2) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void setStateRestorationPolicy(@NonNull RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull ConcatAdapter$Config concatAdapter$Config, @NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder>... recyclerView$AdapterArr) {
        this(concatAdapter$Config, (List<? extends RecyclerView$Adapter<? extends RecyclerView$ViewHolder>>) Arrays.asList(recyclerView$AdapterArr));
    }

    public boolean addAdapter(int i, @NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter) {
        return this.mController.addAdapter(i, recyclerView$Adapter);
    }

    public ConcatAdapter(@NonNull List<? extends RecyclerView$Adapter<? extends RecyclerView$ViewHolder>> list) {
        this(ConcatAdapter$Config.DEFAULT, list);
    }

    public ConcatAdapter(@NonNull ConcatAdapter$Config concatAdapter$Config, @NonNull List<? extends RecyclerView$Adapter<? extends RecyclerView$ViewHolder>> list) {
        this.mController = new ConcatAdapterController(this, concatAdapter$Config);
        Iterator<? extends RecyclerView$Adapter<? extends RecyclerView$ViewHolder>> it = list.iterator();
        while (it.hasNext()) {
            addAdapter(it.next());
        }
        super.setHasStableIds(this.mController.hasStableIds());
    }
}
