package com.discord.widgets.chat.list;

import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatList$onViewBoundOrOnResume$1 extends k implements Function1<WidgetChatListModel, Unit> {
    public WidgetChatList$onViewBoundOrOnResume$1(WidgetChatList widgetChatList) {
        super(1, widgetChatList, WidgetChatList.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/model/WidgetChatListModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListModel widgetChatListModel) {
        invoke2(widgetChatListModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListModel widgetChatListModel) {
        WidgetChatList.access$configureUI((WidgetChatList) this.receiver, widgetChatListModel);
    }
}
