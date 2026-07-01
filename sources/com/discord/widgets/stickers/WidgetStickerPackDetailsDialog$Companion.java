package com.discord.widgets.stickers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog$Companion {
    private WidgetStickerPackDetailsDialog$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetStickerPackDetailsDialog$Companion widgetStickerPackDetailsDialog$Companion, FragmentManager fragmentManager, long j, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        widgetStickerPackDetailsDialog$Companion.show(fragmentManager, j, num);
    }

    public final void show(FragmentManager fragmentManager, long stickerPackId, Integer y2) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", stickerPackId);
        if (y2 != null) {
            y2.intValue();
            bundle.putInt("EXTRA_Y_POSITION", y2.intValue());
        }
        WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog = new WidgetStickerPackDetailsDialog();
        widgetStickerPackDetailsDialog.setArguments(bundle);
        widgetStickerPackDetailsDialog.show(fragmentManager, WidgetStickerPackDetailsDialog.class.getSimpleName());
    }

    public /* synthetic */ WidgetStickerPackDetailsDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
