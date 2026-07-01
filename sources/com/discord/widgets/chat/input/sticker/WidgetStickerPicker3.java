package com.discord.widgets.chat.input.sticker;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$initialStickerPackId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker3(WidgetStickerPicker widgetStickerPicker) {
        super(0);
        this.this$0 = widgetStickerPicker;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID"));
        }
        return null;
    }
}
