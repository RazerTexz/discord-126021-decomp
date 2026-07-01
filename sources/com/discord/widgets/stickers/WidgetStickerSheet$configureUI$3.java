package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ boolean $isPackEnabled;
    public final /* synthetic */ StickerSheetViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetStickerSheet this$0;

    public WidgetStickerSheet$configureUI$3(WidgetStickerSheet widgetStickerSheet, boolean z2, StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState) {
        this.this$0 = widgetStickerSheet;
        this.$isPackEnabled = z2;
        this.$viewState = stickerSheetViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (!this.$isPackEnabled || this.$viewState.getCanUsePremiumStickers()) {
            return;
        }
        this.this$0.dismiss();
        StickerPremiumUpsellDialog$Companion stickerPremiumUpsellDialog$Companion = StickerPremiumUpsellDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        stickerPremiumUpsellDialog$Companion.show(parentFragmentManager, new Traits$Location(null, Traits$Location$Section.STICKER_POPOUT, null, null, null, 29, null));
    }
}
