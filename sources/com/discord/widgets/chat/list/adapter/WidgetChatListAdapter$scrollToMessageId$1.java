package com.discord.widgets.chat.list.adapter;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$scrollToMessageId$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Action0 $onCompleted;
    public final /* synthetic */ WidgetChatListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapter$scrollToMessageId$1(WidgetChatListAdapter widgetChatListAdapter, Action0 action0) {
        super(0);
        this.this$0 = widgetChatListAdapter;
        this.$onCompleted = action0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetChatListAdapter.access$setScrollToWithHighlight$p(this.this$0, null);
        WidgetChatListAdapter.access$publishInteractionState(this.this$0);
        this.$onCompleted.call();
    }
}
