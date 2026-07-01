package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterItemUploadProgress$onConfigure$1 extends k implements Function1<WidgetChatListAdapterItemUploadProgress$Model, Unit> {
    public WidgetChatListAdapterItemUploadProgress$onConfigure$1(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
        super(1, widgetChatListAdapterItemUploadProgress, WidgetChatListAdapterItemUploadProgress.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemUploadProgress$Model widgetChatListAdapterItemUploadProgress$Model) {
        invoke2(widgetChatListAdapterItemUploadProgress$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemUploadProgress$Model widgetChatListAdapterItemUploadProgress$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemUploadProgress$Model, "p1");
        WidgetChatListAdapterItemUploadProgress.access$configureUI((WidgetChatListAdapterItemUploadProgress) this.receiver, widgetChatListAdapterItemUploadProgress$Model);
    }
}
