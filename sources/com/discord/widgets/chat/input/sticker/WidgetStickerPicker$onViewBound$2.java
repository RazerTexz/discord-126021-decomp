package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$onViewBound$2(WidgetStickerPicker widgetStickerPicker) {
        this.this$0 = widgetStickerPicker;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StickerPremiumUpsellDialog$Companion stickerPremiumUpsellDialog$Companion = StickerPremiumUpsellDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        stickerPremiumUpsellDialog$Companion.show(parentFragmentManager, new Traits$Location(null, Traits$Location$Section.EXPRESSION_PICKER, null, null, null, 29, null));
    }
}
