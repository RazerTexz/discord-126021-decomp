package com.discord.widgets.chat.list.adapter;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2$1(WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2 widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1 widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1 = this.this$0.this$0;
        if (widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1.$roleSubscriptionListingId != null) {
            WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(widgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1.this$0).onRoleSubscriptionPurchaseSystemMessageClicked(this.this$0.this$0.$roleSubscriptionListingId.longValue(), this.this$0.this$0.$this_getSystemMessage.getId());
        }
    }
}
