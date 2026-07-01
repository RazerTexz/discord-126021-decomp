package com.discord.widgets.emoji;

import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$joinGuild$1 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ EmojiSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel$joinGuild$1(EmojiSheetViewModel emojiSheetViewModel) {
        super(1);
        this.this$0 = emojiSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        EmojiSheetViewModel.access$updateViewState(this.this$0, EmojiSheetViewModel$ViewState$Dismiss.INSTANCE);
    }
}
