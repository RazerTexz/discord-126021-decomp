package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$LayoutManager$2 implements ViewBoundsCheck$Callback {
    public final /* synthetic */ RecyclerView$LayoutManager this$0;

    public RecyclerView$LayoutManager$2(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        this.this$0 = recyclerView$LayoutManager;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public View getChildAt(int i) {
        return this.this$0.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildEnd(View view) {
        return this.this$0.getDecoratedBottom(view) + ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildStart(View view) {
        return this.this$0.getDecoratedTop(view) - ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentEnd() {
        return this.this$0.getHeight() - this.this$0.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentStart() {
        return this.this$0.getPaddingTop();
    }
}
