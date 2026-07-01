package com.discord.widgets.stickers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.api.sticker.StickerPartial;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUnknownStickerSheet$Companion {
    private WidgetUnknownStickerSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, StickerPartial sticker) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(sticker, "sticker");
        WidgetUnknownStickerSheet widgetUnknownStickerSheet = new WidgetUnknownStickerSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
        widgetUnknownStickerSheet.setArguments(bundle);
        widgetUnknownStickerSheet.show(fragmentManager, WidgetUnknownStickerSheet.class.getName());
    }

    public /* synthetic */ WidgetUnknownStickerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
