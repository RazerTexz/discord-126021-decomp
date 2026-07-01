package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UnsendableStickerPremiumUpsellDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ UnsendableStickerPremiumUpsellDialog this$0;

    public UnsendableStickerPremiumUpsellDialog$onViewBound$1(UnsendableStickerPremiumUpsellDialog unsendableStickerPremiumUpsellDialog) {
        this.this$0 = unsendableStickerPremiumUpsellDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
