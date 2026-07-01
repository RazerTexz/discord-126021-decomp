package com.discord.widgets.voice.fullscreen.stage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager$LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: StageCallAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallAdapter$itemDecoration$1 extends RecyclerView$ItemDecoration {
    public final /* synthetic */ StageCallAdapter this$0;

    public StageCallAdapter$itemDecoration$1(StageCallAdapter stageCallAdapter) {
        this.this$0 = stageCallAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition != -1 && ((StageCallItem) StageCallAdapter.access$getInternalData$p(this.this$0).get(childAdapterPosition)).getType() == 1) {
            ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            int spanIndex = ((GridLayoutManager$LayoutParams) layoutParams).getSpanIndex();
            if (StageCallAdapter.access$getNumSpeakers$p(this.this$0) == 2 && spanIndex == 0) {
                outRect.right = DimenUtils.dpToPixels(4);
                return;
            }
            if (spanIndex == 6) {
                outRect.left = DimenUtils.dpToPixels(4);
                return;
            }
            if (StageCallAdapter.access$getNumSpeakers$p(this.this$0) > 2 && spanIndex == 0) {
                outRect.right = DimenUtils.dpToPixels(5.33f);
            } else if (spanIndex == 8) {
                outRect.left = DimenUtils.dpToPixels(5.33f);
            } else if (spanIndex == 4) {
                outRect.set(DimenUtils.dpToPixels(2.67f), 0, DimenUtils.dpToPixels(2.67f), 0);
            }
        }
    }
}
