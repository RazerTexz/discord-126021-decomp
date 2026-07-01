package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView$ViewHolder> extends RecyclerView$Adapter<VH> {
    public final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer$ListListener<T> mListener;

    public ListAdapter(@NonNull DiffUtil$ItemCallback<T> diffUtil$ItemCallback) {
        ListAdapter$1 listAdapter$1 = new ListAdapter$1(this);
        this.mListener = listAdapter$1;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig$Builder(diffUtil$ItemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listAdapter$1);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    public ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        ListAdapter$1 listAdapter$1 = new ListAdapter$1(this);
        this.mListener = listAdapter$1;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listAdapter$1);
    }
}
