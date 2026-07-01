package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.auth.AuthUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAKey$showLaunchTexts$1 implements View$OnClickListener {
    public final /* synthetic */ PackageManager $pm;

    public WidgetEnableMFAKey$showLaunchTexts$1(PackageManager packageManager) {
        this.$pm = packageManager;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intent launchIntentForPackage = this.$pm.getLaunchIntentForPackage(AuthUtils.AUTHY_PACKAGE);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }
}
