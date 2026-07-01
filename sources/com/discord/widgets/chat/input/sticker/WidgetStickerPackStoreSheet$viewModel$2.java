package com.discord.widgets.chat.input.sticker;

import android.os.Bundle;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet$viewModel$2 extends o implements Function0<StickerPackStoreSheetViewModel> {
    public final /* synthetic */ WidgetStickerPackStoreSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPackStoreSheet$viewModel$2(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
        super(0);
        this.this$0 = widgetStickerPackStoreSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerPackStoreSheetViewModel invoke() {
        Bundle arguments = this.this$0.getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("com.discord.intent.extra.EXTRA_STICKER") : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        Sticker sticker = (Sticker) serializable;
        Bundle arguments2 = this.this$0.getArguments();
        Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("widget_sticker_pack_store_sheet_view_type") : null;
        Objects.requireNonNull(serializable2, "null cannot be cast to non-null type com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewType");
        StickerPackStoreSheetViewType stickerPackStoreSheetViewType = (StickerPackStoreSheetViewType) serializable2;
        Bundle arguments3 = this.this$0.getArguments();
        String string = arguments3 != null ? arguments3.getString("widget_sticker_pack_Store_sheet_analytics_location") : null;
        Bundle arguments4 = this.this$0.getArguments();
        Serializable serializable3 = arguments4 != null ? arguments4.getSerializable("widget_sticker_pack_Store_sheet_analytics_location_section") : null;
        Objects.requireNonNull(serializable3, "null cannot be cast to non-null type com.discord.widgets.stickers.StickerPurchaseLocation");
        StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics = new StickerPackStoreSheetAnalytics(sticker, stickerPackStoreSheetViewType, string, ((StickerPurchaseLocation) serializable3).getAnalyticsValue());
        Long packId = sticker.getPackId();
        m.checkNotNull(packId);
        return new StickerPackStoreSheetViewModel(packId.longValue(), null, stickerPackStoreSheetAnalytics, null, 10, null);
    }
}
