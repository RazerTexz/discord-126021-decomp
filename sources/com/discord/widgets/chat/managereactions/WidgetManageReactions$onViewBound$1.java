package com.discord.widgets.chat.managereactions;

import d0.z.d.q;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetManageReactions$onViewBound$1 extends q {
    public WidgetManageReactions$onViewBound$1(WidgetManageReactions widgetManageReactions) {
        super(widgetManageReactions, WidgetManageReactions.class, "modelProvider", "getModelProvider()Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", 0);
    }

    @Override // d0.z.d.q, kotlin.reflect.KProperty0
    public Object get() {
        return WidgetManageReactions.access$getModelProvider$p((WidgetManageReactions) this.receiver);
    }

    @Override // d0.z.d.q
    public void set(Object obj) {
        WidgetManageReactions.access$setModelProvider$p((WidgetManageReactions) this.receiver, (ManageReactionsModelProvider) obj);
    }
}
