package com.discord.widgets.chat.input;

import android.view.View;
import b.b.a.f.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1 implements a {
    public final /* synthetic */ WidgetChatInputAttachments$configureFlexInputFragment$1 this$0;

    public WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1(WidgetChatInputAttachments$configureFlexInputFragment$1 widgetChatInputAttachments$configureFlexInputFragment$1) {
        this.this$0 = widgetChatInputAttachments$configureFlexInputFragment$1;
    }

    @Override // b.b.a.f.a
    public void requestDisplay(View view) {
        m.checkNotNullParameter(view, "view");
        this.this$0.$fragment.showKeyboard(view);
    }

    @Override // b.b.a.f.a
    public void requestHide() {
        WidgetChatInputAttachments$configureFlexInputFragment$1 widgetChatInputAttachments$configureFlexInputFragment$1 = this.this$0;
        widgetChatInputAttachments$configureFlexInputFragment$1.$fragment.hideKeyboard(WidgetChatInputAttachments.access$getFlexInputFragment$p(widgetChatInputAttachments$configureFlexInputFragment$1.this$0).l());
    }
}
