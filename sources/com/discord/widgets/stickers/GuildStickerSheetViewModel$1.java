package com.discord.widgets.stickers;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$1 extends o implements Function1<GuildStickerSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildStickerSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel$1(GuildStickerSheetViewModel guildStickerSheetViewModel) {
        super(1);
        this.this$0 = guildStickerSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildStickerSheetViewModel$StoreState guildStickerSheetViewModel$StoreState) {
        invoke2(guildStickerSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildStickerSheetViewModel$StoreState guildStickerSheetViewModel$StoreState) {
        m.checkNotNullParameter(guildStickerSheetViewModel$StoreState, "storeState");
        GuildStickerSheetViewModel.access$handleStoreState(this.this$0, guildStickerSheetViewModel$StoreState);
    }
}
