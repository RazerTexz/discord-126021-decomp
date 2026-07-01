package com.discord.utilities.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GridColumnSpaceItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GridColumnSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int columnCount;
    private final int columnSpacePx;

    public GridColumnSpaceItemDecoration(int i, int i2) {
        this.columnSpacePx = i;
        this.columnCount = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i = this.columnCount;
        outRect.set(outRect.left, outRect.top, childAdapterPosition % i == i - 1 ? 0 : this.columnSpacePx, outRect.bottom);
    }
}
