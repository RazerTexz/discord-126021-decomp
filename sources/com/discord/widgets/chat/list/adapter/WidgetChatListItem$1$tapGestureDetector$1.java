package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;

/* JADX INFO: compiled from: WidgetChatListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListItem$1$tapGestureDetector$1 extends GestureDetector$SimpleOnGestureListener {
    public final /* synthetic */ WidgetChatListItem$1 this$0;

    public WidgetChatListItem$1$tapGestureDetector$1(WidgetChatListItem$1 widgetChatListItem$1) {
        this.this$0 = widgetChatListItem$1;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        this.this$0.$adapter.getEventHandler().onListClicked();
        return super.onSingleTapUp(e);
    }
}
