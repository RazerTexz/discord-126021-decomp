package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerView$AdapterDataObserver {
    public void onChanged() {
    }

    public void onItemRangeChanged(int i, int i2) {
    }

    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        onItemRangeChanged(i, i2);
    }

    public void onItemRangeInserted(int i, int i2) {
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
    }

    public void onItemRangeRemoved(int i, int i2) {
    }

    public void onStateRestorationPolicyChanged() {
    }
}
