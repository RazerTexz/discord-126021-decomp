package androidx.recyclerview.widget;

import android.database.Observable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$AdapterDataObservable extends Observable<RecyclerView$AdapterDataObserver> {
    public boolean hasObservers() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public void notifyChanged() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    public void notifyItemMoved(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
        }
    }

    public void notifyItemRangeChanged(int i, int i2) {
        notifyItemRangeChanged(i, i2, null);
    }

    public void notifyItemRangeInserted(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
        }
    }

    public void notifyItemRangeRemoved(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
        }
    }

    public void notifyStateRestorationPolicyChanged() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$AdapterDataObserver) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
        }
    }

    public void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
        }
    }
}
