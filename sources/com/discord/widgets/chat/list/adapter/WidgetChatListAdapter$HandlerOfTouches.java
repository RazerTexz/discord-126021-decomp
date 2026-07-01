package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$HandlerOfTouches implements View$OnTouchListener {
    private final GestureDetector tapGestureDetector;
    public final /* synthetic */ WidgetChatListAdapter this$0;

    public WidgetChatListAdapter$HandlerOfTouches(WidgetChatListAdapter widgetChatListAdapter) {
        this.this$0 = widgetChatListAdapter;
        this.tapGestureDetector = new GestureDetector(widgetChatListAdapter.getContext(), new WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1(this));
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        boolean z2 = event != null && event.getAction() == 2;
        if (!WidgetChatListAdapter.access$isTouchedSinceLastJump$p(this.this$0) && z2) {
            WidgetChatListAdapter.access$setTouchedSinceLastJump$p(this.this$0, true);
            WidgetChatListAdapter.access$publishInteractionState(this.this$0);
        }
        return this.tapGestureDetector.onTouchEvent(event);
    }
}
