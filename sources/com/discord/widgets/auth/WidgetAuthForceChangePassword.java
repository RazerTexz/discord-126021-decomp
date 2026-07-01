package com.discord.widgets.auth;

import android.view.View;
import android.widget.ImageView;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthForceChangePassword extends WidgetSettingsAccountChangePassword {
    public static final WidgetAuthForceChangePassword$Companion Companion = new WidgetAuthForceChangePassword$Companion(null);

    @Override // com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword
    public void onChangePasswordSuccess() {
        AnalyticsTracker.INSTANCE.trackForceUpdatePasswordSucceeded();
    }

    @Override // com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ImageView imageView = getBinding().f2596b;
        m.checkNotNullExpressionValue(imageView, "binding.authChangePasswordIcon");
        imageView.setVisibility(0);
        setOnBackPressed(WidgetAuthForceChangePassword$onViewBound$1.INSTANCE, 0);
    }
}
