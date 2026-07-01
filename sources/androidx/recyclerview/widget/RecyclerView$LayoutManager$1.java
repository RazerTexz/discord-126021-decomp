package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$LayoutManager$1 implements ViewBoundsCheck$Callback {
    public final /* synthetic */ RecyclerView$LayoutManager this$0;

    public RecyclerView$LayoutManager$1(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        this.this$0 = recyclerView$LayoutManager;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public View getChildAt(int i) {
        return this.this$0.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildEnd(View view) {
        return this.this$0.getDecoratedRight(view) + ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildStart(View view) {
        return this.this$0.getDecoratedLeft(view) - ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentEnd() {
        return this.this$0.getWidth() - this.this$0.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentStart() {
        return this.this$0.getPaddingLeft();
    }
}
