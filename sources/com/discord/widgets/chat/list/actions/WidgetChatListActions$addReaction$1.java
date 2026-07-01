package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$addReaction$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ Emoji $emoji;
    public final /* synthetic */ WidgetChatListActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActions$addReaction$1(WidgetChatListActions widgetChatListActions, Emoji emoji) {
        super(1);
        this.this$0 = widgetChatListActions;
        this.$emoji = emoji;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        StoreStream.Companion.getEmojis().onEmojiUsed(this.$emoji);
        this.this$0.dismiss();
    }
}
