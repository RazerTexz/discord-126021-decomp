package com.discord.widgets.home;

import android.widget.ImageView;
import com.discord.widgets.chat.list.WidgetChatList;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$animatePeek$1 implements Runnable {
    public final /* synthetic */ WidgetChatList $fragmentChatList;
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$animatePeek$1(WidgetHome widgetHome, WidgetChatList widgetChatList) {
        this.this$0 = widgetHome;
        this.$fragmentChatList = widgetChatList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = WidgetHome.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(imageView, "binding.peekTransitionBitmap");
        imageView.setVisibility(8);
        this.$fragmentChatList.enableItemAnimations();
    }
}
