package com.discord.widgets.stickers;

import com.discord.api.sticker.Sticker;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet$viewModel$2 extends o implements Function0<GuildStickerSheetViewModel> {
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildStickerSheet$viewModel$2(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        super(0);
        this.this$0 = widgetGuildStickerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildStickerSheetViewModel invoke() {
        Serializable serializable = WidgetGuildStickerSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable("com.discord.intent.extra.EXTRA_STICKER");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        return new GuildStickerSheetViewModel((Sticker) serializable, null, null, null, null, null, 62, null);
    }
}
