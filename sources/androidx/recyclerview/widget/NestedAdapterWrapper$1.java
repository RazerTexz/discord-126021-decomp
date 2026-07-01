package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class NestedAdapterWrapper$1 extends RecyclerView$AdapterDataObserver {
    public final /* synthetic */ NestedAdapterWrapper this$0;

    public NestedAdapterWrapper$1(NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = nestedAdapterWrapper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount = nestedAdapterWrapper.adapter.getItemCount();
        NestedAdapterWrapper nestedAdapterWrapper2 = this.this$0;
        nestedAdapterWrapper2.mCallback.onChanged(nestedAdapterWrapper2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i, i2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount += i2;
        nestedAdapterWrapper.mCallback.onItemRangeInserted(nestedAdapterWrapper, i, i2);
        NestedAdapterWrapper nestedAdapterWrapper2 = this.this$0;
        if (nestedAdapterWrapper2.mCachedItemCount <= 0 || nestedAdapterWrapper2.adapter.getStateRestorationPolicy() != RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
            return;
        }
        NestedAdapterWrapper nestedAdapterWrapper3 = this.this$0;
        nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        Preconditions.checkArgument(i3 == 1, "moving more than 1 item is not supported in RecyclerView");
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onItemRangeMoved(nestedAdapterWrapper, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount -= i2;
        nestedAdapterWrapper.mCallback.onItemRangeRemoved(nestedAdapterWrapper, i, i2);
        NestedAdapterWrapper nestedAdapterWrapper2 = this.this$0;
        if (nestedAdapterWrapper2.mCachedItemCount >= 1 || nestedAdapterWrapper2.adapter.getStateRestorationPolicy() != RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
            return;
        }
        NestedAdapterWrapper nestedAdapterWrapper3 = this.this$0;
        nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onStateRestorationPolicyChanged() {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i, i2, obj);
    }
}
