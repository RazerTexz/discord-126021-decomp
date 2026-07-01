package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$ItemAnimator$ItemHolderInfo {
    public int bottom;
    public int changeFlags;
    public int left;
    public int right;
    public int top;

    @NonNull
    public RecyclerView$ItemAnimator$ItemHolderInfo setFrom(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return setFrom(recyclerView$ViewHolder, 0);
    }

    @NonNull
    public RecyclerView$ItemAnimator$ItemHolderInfo setFrom(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        View view = recyclerView$ViewHolder.itemView;
        this.left = view.getLeft();
        this.top = view.getTop();
        this.right = view.getRight();
        this.bottom = view.getBottom();
        return this;
    }
}
