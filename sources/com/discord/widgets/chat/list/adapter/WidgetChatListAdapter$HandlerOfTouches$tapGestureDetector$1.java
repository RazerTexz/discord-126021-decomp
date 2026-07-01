package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1 extends GestureDetector$SimpleOnGestureListener {
    public final /* synthetic */ WidgetChatListAdapter$HandlerOfTouches this$0;

    public WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1(WidgetChatListAdapter$HandlerOfTouches widgetChatListAdapter$HandlerOfTouches) {
        this.this$0 = widgetChatListAdapter$HandlerOfTouches;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        this.this$0.this$0.getEventHandler().onListClicked();
        return super.onSingleTapUp(e);
    }
}
