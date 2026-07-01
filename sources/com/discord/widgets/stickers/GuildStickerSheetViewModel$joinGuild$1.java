package com.discord.widgets.stickers;

import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$joinGuild$1 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ GuildStickerSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel$joinGuild$1(GuildStickerSheetViewModel guildStickerSheetViewModel) {
        super(1);
        this.this$0 = guildStickerSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        GuildStickerSheetViewModel.access$updateViewState(this.this$0, GuildStickerSheetViewModel$ViewState$Dismiss.INSTANCE);
    }
}
