package com.discord.widgets.chat.managereactions;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetManageReactions$onViewBound$2 extends k implements Function1<String, Unit> {
    public WidgetManageReactions$onViewBound$2(ManageReactionsModelProvider manageReactionsModelProvider) {
        super(1, manageReactionsModelProvider, ManageReactionsModelProvider.class, "onEmojiTargeted", "onEmojiTargeted(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "p1");
        ((ManageReactionsModelProvider) this.receiver).onEmojiTargeted(str);
    }
}
