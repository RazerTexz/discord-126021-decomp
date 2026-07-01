package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActionsEmojisAdapter$onClickEmoji$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter5 extends Lambda implements Function1<Emoji, Unit> {
    public static final WidgetChatListActionsEmojisAdapter5 INSTANCE = new WidgetChatListActionsEmojisAdapter5();

    public WidgetChatListActionsEmojisAdapter5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
        invoke2(emoji);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "it");
    }
}
