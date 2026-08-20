package com.discord.widgets.chat.list.adapter;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$Model$createRenderContext$1 extends AbstractC12240o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetChatListAdapter.EventHandler $eventHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment$Model$createRenderContext$1(WidgetChatListAdapter.EventHandler eventHandler) {
        super(1);
        this.$eventHandler = eventHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, "url");
        this.$eventHandler.onUrlLongClicked(str);
    }
}
