package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter$onClickEmoji$1 extends o implements Function1<Emoji, Unit> {
    public static final WidgetChatListActionsEmojisAdapter$onClickEmoji$1 INSTANCE = new WidgetChatListActionsEmojisAdapter$onClickEmoji$1();

    public WidgetChatListActionsEmojisAdapter$onClickEmoji$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
        invoke2(emoji);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Emoji emoji) {
        m.checkNotNullParameter(emoji, "it");
    }
}
