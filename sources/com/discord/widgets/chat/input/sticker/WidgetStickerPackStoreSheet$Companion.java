package com.discord.widgets.chat.input.sticker;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet$Companion {
    private WidgetStickerPackStoreSheet$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetStickerPackStoreSheet$Companion widgetStickerPackStoreSheet$Companion, FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, StickerPurchaseLocation stickerPurchaseLocation, int i, Object obj) {
        widgetStickerPackStoreSheet$Companion.show(fragmentManager, sticker, stickerPackStoreSheetViewType, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : stickerPurchaseLocation);
    }

    public final void show(FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType viewType, String location, StickerPurchaseLocation purchaseLocation) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(viewType, "viewType");
        if (sticker.getType() != StickerType.STANDARD) {
            return;
        }
        WidgetStickerPackStoreSheet widgetStickerPackStoreSheet = new WidgetStickerPackStoreSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
        bundle.putSerializable("widget_sticker_pack_store_sheet_view_type", viewType);
        bundle.putString("widget_sticker_pack_Store_sheet_analytics_location", location);
        bundle.putSerializable("widget_sticker_pack_Store_sheet_analytics_location_section", purchaseLocation);
        widgetStickerPackStoreSheet.setArguments(bundle);
        widgetStickerPackStoreSheet.show(fragmentManager, WidgetStickerPackStoreSheet.class.getName());
    }

    public /* synthetic */ WidgetStickerPackStoreSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
