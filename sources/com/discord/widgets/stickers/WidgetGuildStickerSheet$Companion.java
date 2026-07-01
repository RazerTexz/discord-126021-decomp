package com.discord.widgets.stickers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet$Companion {
    private WidgetGuildStickerSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, Sticker sticker) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(sticker, "sticker");
        if (sticker.getType() != StickerType.GUILD) {
            return;
        }
        WidgetGuildStickerSheet widgetGuildStickerSheet = new WidgetGuildStickerSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
        widgetGuildStickerSheet.setArguments(bundle);
        widgetGuildStickerSheet.show(fragmentManager, WidgetGuildStickerSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildStickerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
