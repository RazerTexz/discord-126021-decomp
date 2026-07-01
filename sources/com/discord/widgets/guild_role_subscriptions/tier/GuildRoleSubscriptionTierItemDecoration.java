package com.discord.widgets.guild_role_subscriptions.tier;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierItemDecoration extends RecyclerView$ItemDecoration {
    private final int horizontalSpacing;
    private final int verticalSpacing;

    public GuildRoleSubscriptionTierItemDecoration(int i, int i2) {
        this.verticalSpacing = i;
        this.horizontalSpacing = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView$Adapter adapter = parent.getAdapter();
        Integer numValueOf = adapter != null ? Integer.valueOf(adapter.getItemViewType(childAdapterPosition)) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            int i = this.verticalSpacing;
            outRect.top = i;
            int i2 = this.horizontalSpacing;
            outRect.left = i2 / 2;
            outRect.right = i2;
            outRect.bottom = i;
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 4) {
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            outRect.bottom = this.verticalSpacing;
            return;
        }
        int i3 = this.horizontalSpacing;
        outRect.left = i3;
        outRect.right = i3;
        int i4 = this.verticalSpacing;
        outRect.top = i4;
        outRect.bottom = i4;
    }
}
