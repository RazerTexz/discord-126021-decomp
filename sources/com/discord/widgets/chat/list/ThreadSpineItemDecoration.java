package com.discord.widgets.chat.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.m;

/* JADX INFO: compiled from: ThreadSpineItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadSpineItemDecoration extends RecyclerView$ItemDecoration {
    private final WidgetChatListAdapter adapter;
    private final Context context;
    private final Drawable drawable;
    private final int startPositionPx;

    public ThreadSpineItemDecoration(Context context, WidgetChatListAdapter widgetChatListAdapter) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.context = context;
        this.adapter = widgetChatListAdapter;
        this.drawable = ContextCompat.getDrawable(context, 2131232542);
        this.startPositionPx = context.getResources().getDimensionPixelSize(2131165321);
    }

    private final void drawSpinePiece(Canvas canvas, RecyclerView parent, View child) {
        Rect rect = new Rect();
        parent.getDecoratedBoundsWithMargins(child, rect);
        Drawable drawable = this.drawable;
        if (drawable != null) {
            int i = this.startPositionPx;
            drawable.setBounds(i, rect.top, drawable.getIntrinsicWidth() + i, rect.bottom);
            this.drawable.draw(canvas);
        }
    }

    private final void handleRecyclerViewChildren(Canvas canvas, RecyclerView parent) {
        canvas.save();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (childAdapterPosition >= 0 && childAdapterPosition < this.adapter.getPageSize() && this.adapter.getItem(childAdapterPosition).getShouldShowThreadSpine()) {
                m.checkNotNullExpressionValue(childAt, "child");
                drawSpinePiece(canvas, parent, childAt);
            }
        }
        canvas.restore();
    }

    public final WidgetChatListAdapter getAdapter() {
        return this.adapter;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(canvas, "canvas");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        if (parent.getLayoutManager() == null) {
            return;
        }
        handleRecyclerViewChildren(canvas, parent);
    }
}
