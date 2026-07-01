package com.discord.widgets.stickers;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet$bindSubscriptions$1 extends o implements Function1<GuildStickerSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildStickerSheet$bindSubscriptions$1(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        super(1);
        this.this$0 = widgetGuildStickerSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildStickerSheetViewModel$ViewState guildStickerSheetViewModel$ViewState) {
        invoke2(guildStickerSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildStickerSheetViewModel$ViewState guildStickerSheetViewModel$ViewState) {
        if (m.areEqual(guildStickerSheetViewModel$ViewState, GuildStickerSheetViewModel$ViewState$Loading.INSTANCE)) {
            WidgetGuildStickerSheet.access$showLoading(this.this$0);
        } else if (m.areEqual(guildStickerSheetViewModel$ViewState, GuildStickerSheetViewModel$ViewState$Dismiss.INSTANCE)) {
            this.this$0.dismiss();
        } else if (guildStickerSheetViewModel$ViewState instanceof GuildStickerSheetViewModel$ViewState$Loaded) {
            WidgetGuildStickerSheet.access$configureUI(this.this$0, (GuildStickerSheetViewModel$ViewState$Loaded) guildStickerSheetViewModel$ViewState);
        }
    }
}
