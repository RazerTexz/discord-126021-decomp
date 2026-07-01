package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    public WidgetEditProfileBannerSheet$onViewCreated$1(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        this.this$0 = widgetEditProfileBannerSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditProfileBannerSheet.access$navigateToUpsellModal(this.this$0);
    }
}
