package com.discord.widgets.chat.list.adapter;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$Model$createRenderContext$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetChatListAdapter$EventHandler $eventHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$Model$createRenderContext$1(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler) {
        super(1);
        this.$eventHandler = widgetChatListAdapter$EventHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "url");
        this.$eventHandler.onUrlLongClicked(str);
    }
}
