package androidx.viewpager2.widget;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewPager2$DataSetChangeObserver extends RecyclerView$AdapterDataObserver {
    private ViewPager2$DataSetChangeObserver() {
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

    public /* synthetic */ ViewPager2$DataSetChangeObserver(ViewPager2$1 viewPager2$1) {
        this();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        onChanged();
    }
}
