package com.discord.widgets.chat.list.actions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$onResume$1 extends o implements Function1<WidgetChatListActions$Model, Unit> {
    public final /* synthetic */ WidgetChatListActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActions$onResume$1(WidgetChatListActions widgetChatListActions) {
        super(1);
        this.this$0 = widgetChatListActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListActions$Model widgetChatListActions$Model) {
        invoke2(widgetChatListActions$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListActions$Model widgetChatListActions$Model) {
        WidgetChatListActions.access$configureUI(this.this$0, widgetChatListActions$Model);
    }
}
