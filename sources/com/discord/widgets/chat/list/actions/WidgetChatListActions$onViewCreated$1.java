package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$onViewCreated$1 extends o implements Function1<Emoji, Unit> {
    public final /* synthetic */ WidgetChatListActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActions$onViewCreated$1(WidgetChatListActions widgetChatListActions) {
        super(1);
        this.this$0 = widgetChatListActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
        invoke2(emoji);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        WidgetChatListActions.access$addReaction(this.this$0, emoji);
    }
}
