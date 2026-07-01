package com.discord.widgets.forums;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter$itemDecoration$1 extends RecyclerView$ItemDecoration {
    public final /* synthetic */ WidgetForumBrowserAdapter this$0;

    public WidgetForumBrowserAdapter$itemDecoration$1(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        this.this$0 = widgetForumBrowserAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        boolean z2 = childAdapterPosition == 0;
        int type = ((ForumBrowserItem) WidgetForumBrowserAdapter.access$getInternalData$p(this.this$0).get(childAdapterPosition)).getType();
        if (type == 0) {
            outRect.top = DimenUtils.dpToPixels(24);
            outRect.bottom = DimenUtils.dpToPixels(8);
            outRect.left = DimenUtils.dpToPixels(16);
        }
        if (type == 1) {
            outRect.bottom = DimenUtils.dpToPixels(12);
            outRect.top = z2 ? DimenUtils.dpToPixels(12) : 0;
        }
    }
}
