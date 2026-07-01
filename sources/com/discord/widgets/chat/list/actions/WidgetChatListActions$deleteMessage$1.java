package com.discord.widgets.chat.list.actions;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListActions$deleteMessage$1 extends k implements Function0<Unit> {
    public WidgetChatListActions$deleteMessage$1(WidgetChatListActions widgetChatListActions) {
        super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WidgetChatListActions) this.receiver).dismiss();
    }
}
