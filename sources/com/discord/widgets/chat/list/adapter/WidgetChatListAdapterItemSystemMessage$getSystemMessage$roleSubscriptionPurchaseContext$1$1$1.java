package com.discord.widgets.chat.list.adapter;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1$1(WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1 widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0.this$0.this$0).getEventHandler();
        WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1 widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1 = this.this$0.this$0;
        eventHandler.onMessageAuthorNameClicked(widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1.$this_getSystemMessage, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1.this$0).getData().getGuildId());
    }
}
