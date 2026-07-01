package com.discord.widgets.chat.list.adapter;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate$onConfigure$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemGuildTemplate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate$onConfigure$2(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        super(1);
        this.this$0 = widgetChatListAdapterItemGuildTemplate;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetChatListAdapterItemGuildTemplate.access$configureInvalidUI(this.this$0);
    }
}
