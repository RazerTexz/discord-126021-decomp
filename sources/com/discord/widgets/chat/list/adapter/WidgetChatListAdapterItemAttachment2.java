package com.discord.widgets.chat.list.adapter;

import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$Model$createRenderContext$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment2 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ WidgetChatListAdapter.EventHandler $eventHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment2(WidgetChatListAdapter.EventHandler eventHandler) {
        super(1);
        this.$eventHandler = eventHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "url");
        this.$eventHandler.onUrlLongClicked(str);
    }
}
