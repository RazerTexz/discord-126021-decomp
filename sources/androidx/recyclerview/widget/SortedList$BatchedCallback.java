package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SortedList$BatchedCallback<T2> extends SortedList$Callback<T2> {
    private final BatchingListUpdateCallback mBatchingListUpdateCallback;
    public final SortedList$Callback<T2> mWrappedCallback;

    public SortedList$BatchedCallback(SortedList$Callback<T2> sortedList$Callback) {
        this.mWrappedCallback = sortedList$Callback;
        this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(sortedList$Callback);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public boolean areContentsTheSame(T2 t2, T2 t3) {
        return this.mWrappedCallback.areContentsTheSame(t2, t3);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public boolean areItemsTheSame(T2 t2, T2 t3) {
        return this.mWrappedCallback.areItemsTheSame(t2, t3);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, java.util.Comparator
    public int compare(T2 t2, T2 t3) {
        return this.mWrappedCallback.compare(t2, t3);
    }

    public void dispatchLastEvent() {
        this.mBatchingListUpdateCallback.dispatchLastEvent();
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    @Nullable
    public Object getChangePayload(T2 t2, T2 t3) {
        return this.mWrappedCallback.getChangePayload(t2, t3);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public void onChanged(int i, int i2) {
        this.mBatchingListUpdateCallback.onChanged(i, i2, null);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.mBatchingListUpdateCallback.onInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.mBatchingListUpdateCallback.onMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.mBatchingListUpdateCallback.onRemoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.mBatchingListUpdateCallback.onChanged(i, i2, obj);
    }
}
