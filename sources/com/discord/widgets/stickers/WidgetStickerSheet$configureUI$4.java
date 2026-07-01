package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.api.sticker.Sticker;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent$OpenStickerPicker;
import com.discord.widgets.chat.input.expression.ExpressionPickerEventBus;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewType;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ boolean $isPackEnabled;
    public final /* synthetic */ String $location;
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ ModelStickerPack $stickerPack;
    public final /* synthetic */ StickerSheetViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetStickerSheet this$0;

    public WidgetStickerSheet$configureUI$4(WidgetStickerSheet widgetStickerSheet, boolean z2, StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState, Sticker sticker, String str, ModelStickerPack modelStickerPack) {
        this.this$0 = widgetStickerSheet;
        this.$isPackEnabled = z2;
        this.$viewState = stickerSheetViewModel$ViewState;
        this.$sticker = sticker;
        this.$location = str;
        this.$stickerPack = modelStickerPack;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$isPackEnabled && this.$viewState.getCanUsePremiumStickers()) {
            ExpressionPickerEventBus.Companion.getINSTANCE().emitEvent(new ExpressionPickerEvent$OpenStickerPicker(this.$sticker.getPackId(), null, false, 2, null));
        } else {
            WidgetStickerPackStoreSheet$Companion widgetStickerPackStoreSheet$Companion = WidgetStickerPackStoreSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetStickerPackStoreSheet$Companion.show(parentFragmentManager, this.$sticker, StickerPackStoreSheetViewType.STICKER_POPOUT_VIEW_ALL, this.$location, StickerPurchaseLocation.Companion.getPopoutPurchaseLocation(this.$stickerPack.canBePurchased()));
        }
        this.this$0.dismiss();
    }
}
