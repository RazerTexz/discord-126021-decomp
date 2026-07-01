package androidx.viewpager2.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStateAdapter$DataSetChangeObserver extends RecyclerView$AdapterDataObserver {
    private FragmentStateAdapter$DataSetChangeObserver() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public abstract void onChanged();

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public final void onItemRangeInserted(int i, int i2) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public final void onItemRangeMoved(int i, int i2, int i3) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public final void onItemRangeRemoved(int i, int i2) {
        onChanged();
    }

    public /* synthetic */ FragmentStateAdapter$DataSetChangeObserver(FragmentStateAdapter$1 fragmentStateAdapter$1) {
        this();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        onChanged();
    }
}
