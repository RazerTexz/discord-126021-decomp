package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$configureUi$2 implements View$OnClickListener {
    public final /* synthetic */ EditProfileBannerSheetViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    public WidgetEditProfileBannerSheet$configureUi$2(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, EditProfileBannerSheetViewModel$ViewState editProfileBannerSheetViewModel$ViewState) {
        this.this$0 = widgetEditProfileBannerSheet;
        this.$viewState = editProfileBannerSheetViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.getShowPremiumUpsell()) {
            WidgetEditProfileBannerSheet.access$navigateToUpsellModal(this.this$0);
        } else {
            this.this$0.getOnChangeProfileBannerImage().invoke();
            this.this$0.dismiss();
        }
    }
}
