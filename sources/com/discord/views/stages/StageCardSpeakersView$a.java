package com.discord.views.stages;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCardSpeakersView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCardSpeakersView$a extends RecyclerView$ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        m.checkNotNullParameter(rect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(recyclerView, "parent");
        m.checkNotNullParameter(recyclerView$State, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$State);
        boolean z2 = recyclerView.getChildAdapterPosition(view) >= recyclerView$State.getItemCount() + (-2);
        rect.left = DimenUtils.dpToPixels(4);
        rect.right = DimenUtils.dpToPixels(4);
        rect.bottom = z2 ? 0 : DimenUtils.dpToPixels(8);
    }
}
