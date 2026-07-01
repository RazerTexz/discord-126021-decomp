package androidx.preference;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceFragmentCompat$DividerDecoration extends RecyclerView$ItemDecoration {
    private boolean mAllowDividerAfterLastItem = true;
    private Drawable mDivider;
    private int mDividerHeight;
    public final /* synthetic */ PreferenceFragmentCompat this$0;

    public PreferenceFragmentCompat$DividerDecoration(PreferenceFragmentCompat preferenceFragmentCompat) {
        this.this$0 = preferenceFragmentCompat;
    }

    private boolean shouldDrawDividerBelow(View view, RecyclerView recyclerView) {
        RecyclerView$ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        boolean z2 = false;
        if (!((childViewHolder instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder).isDividerAllowedBelow())) {
            return false;
        }
        boolean z3 = this.mAllowDividerAfterLastItem;
        int iIndexOfChild = recyclerView.indexOfChild(view);
        if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
            return z3;
        }
        RecyclerView$ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
        if ((childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).isDividerAllowedAbove()) {
            z2 = true;
        }
        return z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        if (shouldDrawDividerBelow(view, recyclerView)) {
            rect.bottom = this.mDividerHeight;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        if (this.mDivider == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (shouldDrawDividerBelow(childAt, recyclerView)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.mDivider.setBounds(0, height, width, this.mDividerHeight + height);
                this.mDivider.draw(canvas);
            }
        }
    }

    public void setAllowDividerAfterLastItem(boolean z2) {
        this.mAllowDividerAfterLastItem = z2;
    }

    public void setDivider(Drawable drawable) {
        if (drawable != null) {
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerHeight = 0;
        }
        this.mDivider = drawable;
        this.this$0.mList.invalidateItemDecorations();
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
        this.this$0.mList.invalidateItemDecorations();
    }
}
