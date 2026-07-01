package com.discord.utilities.view.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import b.d.b.a.a;
import d0.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PaddedItemDecorator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaddedItemDecorator extends RecyclerView$ItemDecoration {
    private final int orientation;
    private final boolean spaceBetweenItemsOnly;
    private final int spaceHorz;
    private final int spaceVert;

    public /* synthetic */ PaddedItemDecorator(int i, int i2, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? false : z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        boolean z2 = childAdapterPosition == 0;
        boolean z3 = childAdapterPosition == state.getItemCount() - 1;
        int i = this.orientation;
        if (i == 0) {
            int i2 = this.spaceVert;
            outRect.top = i2;
            outRect.bottom = i2;
            outRect.left = (!z2 || this.spaceBetweenItemsOnly) ? 0 : this.spaceHorz;
            outRect.right = (z3 && this.spaceBetweenItemsOnly) ? 0 : this.spaceHorz;
            return;
        }
        if (i != 1) {
            throw new j(a.w("An operation is not implemented: ", a.B(a.U("Other("), this.orientation, ") orientation padding for items not supported yet.")));
        }
        outRect.top = (!z2 || this.spaceBetweenItemsOnly) ? 0 : this.spaceVert;
        outRect.bottom = (z3 && this.spaceBetweenItemsOnly) ? 0 : this.spaceVert;
        int i3 = this.spaceHorz;
        outRect.left = i3;
        outRect.right = i3;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final boolean getSpaceBetweenItemsOnly() {
        return this.spaceBetweenItemsOnly;
    }

    public final int getSpaceHorz() {
        return this.spaceHorz;
    }

    public final int getSpaceVert() {
        return this.spaceVert;
    }

    public PaddedItemDecorator(int i, int i2, int i3, boolean z2) {
        this.orientation = i;
        this.spaceHorz = i2;
        this.spaceVert = i3;
        this.spaceBetweenItemsOnly = z2;
    }
}
