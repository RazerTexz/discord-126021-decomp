package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListDiffer$1$1 extends DiffUtil$Callback {
    public final /* synthetic */ AsyncListDiffer$1 this$1;

    public AsyncListDiffer$1$1(AsyncListDiffer$1 asyncListDiffer$1) {
        this.this$1 = asyncListDiffer$1;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int i, int i2) {
        Object obj = this.this$1.val$oldList.get(i);
        Object obj2 = this.this$1.val$newList.get(i2);
        if (obj != null && obj2 != null) {
            return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int i, int i2) {
        Object obj = this.this$1.val$oldList.get(i);
        Object obj2 = this.this$1.val$newList.get(i2);
        if (obj == null || obj2 == null) {
            return obj == null && obj2 == null;
        }
        return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    @Nullable
    public Object getChangePayload(int i, int i2) {
        Object obj = this.this$1.val$oldList.get(i);
        Object obj2 = this.this$1.val$newList.get(i2);
        if (obj == null || obj2 == null) {
            throw new AssertionError();
        }
        return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.this$1.val$newList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.this$1.val$oldList.size();
    }
}
