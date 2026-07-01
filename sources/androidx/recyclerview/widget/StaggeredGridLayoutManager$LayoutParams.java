package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager$LayoutParams extends RecyclerView$LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    public boolean mFullSpan;
    public StaggeredGridLayoutManager$Span mSpan;

    public StaggeredGridLayoutManager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int getSpanIndex() {
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpan;
        if (staggeredGridLayoutManager$Span == null) {
            return -1;
        }
        return staggeredGridLayoutManager$Span.mIndex;
    }

    public boolean isFullSpan() {
        return this.mFullSpan;
    }

    public void setFullSpan(boolean z2) {
        this.mFullSpan = z2;
    }

    public StaggeredGridLayoutManager$LayoutParams(int i, int i2) {
        super(i, i2);
    }

    public StaggeredGridLayoutManager$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
    }

    public StaggeredGridLayoutManager$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
    }

    public StaggeredGridLayoutManager$LayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        super(recyclerView$LayoutParams);
    }
}
