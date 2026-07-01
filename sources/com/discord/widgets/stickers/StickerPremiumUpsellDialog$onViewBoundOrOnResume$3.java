package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog$onViewBoundOrOnResume$3 implements View$OnClickListener {
    public final /* synthetic */ StickerPremiumUpsellDialog this$0;

    public StickerPremiumUpsellDialog$onViewBoundOrOnResume$3(StickerPremiumUpsellDialog stickerPremiumUpsellDialog) {
        this.this$0 = stickerPremiumUpsellDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
