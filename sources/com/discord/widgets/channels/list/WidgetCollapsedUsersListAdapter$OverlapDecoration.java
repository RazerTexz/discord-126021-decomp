package com.discord.widgets.channels.list;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$State;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetCollapsedUsersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCollapsedUsersListAdapter$OverlapDecoration extends RecyclerView$ItemDecoration {
    private final int offset;

    public WidgetCollapsedUsersListAdapter$OverlapDecoration(int i) {
        this.offset = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        outRect.set(((RecyclerView$LayoutParams) layoutParams).getViewAdapterPosition() != 0 ? this.offset : 0, 0, 0, 0);
    }
}
