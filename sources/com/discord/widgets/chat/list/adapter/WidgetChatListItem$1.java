package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListItem$1 implements View$OnTouchListener {
    public final /* synthetic */ WidgetChatListAdapter $adapter;
    private final GestureDetector tapGestureDetector;
    public final /* synthetic */ WidgetChatListItem this$0;

    public WidgetChatListItem$1(WidgetChatListItem widgetChatListItem, WidgetChatListAdapter widgetChatListAdapter) {
        this.this$0 = widgetChatListItem;
        this.$adapter = widgetChatListAdapter;
        View view = widgetChatListItem.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        this.tapGestureDetector = new GestureDetector(view.getContext(), new WidgetChatListItem$1$tapGestureDetector$1(this));
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return this.tapGestureDetector.onTouchEvent(event);
    }
}
