package com.discord.widgets.stickers;

import com.discord.api.sticker.Sticker;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet$viewModel$2 extends AbstractC12240o implements Function0<GuildStickerSheetViewModel> {
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildStickerSheet$viewModel$2(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        super(0);
        this.this$0 = widgetGuildStickerSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildStickerSheetViewModel invoke() {
        Serializable serializable = this.this$0.getArgumentsOrDefault().getSerializable("com.discord.intent.extra.EXTRA_STICKER");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        return new GuildStickerSheetViewModel((Sticker) serializable, null, null, null, null, null, 62, null);
    }
}
