package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager$LayoutParams extends RecyclerView$LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    public int mSpanIndex;
    public int mSpanSize;

    public GridLayoutManager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }

    public int getSpanIndex() {
        return this.mSpanIndex;
    }

    public int getSpanSize() {
        return this.mSpanSize;
    }

    public GridLayoutManager$LayoutParams(int i, int i2) {
        super(i, i2);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }

    public GridLayoutManager$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }

    public GridLayoutManager$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }

    public GridLayoutManager$LayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        super(recyclerView$LayoutParams);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }
}
