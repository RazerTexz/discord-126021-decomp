package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Long $roleSubscriptionListingId;
    public final /* synthetic */ Message $this_getSystemMessage;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Message message, int i, Context context, Long l) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage;
        this.$this_getSystemMessage = message;
        this.$authorRoleColor = i;
        this.$context = context;
        this.$roleSubscriptionListingId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1(this));
        renderContext.a("roleSubscriptionOnClick", new WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2(this));
    }
}
