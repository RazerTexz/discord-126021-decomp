package com.discord.widgets.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    public WidgetOauth2AuthorizeSamsung$configureUI$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        m.checkNotNullParameter(context, "context");
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
        m.checkNotNullExpressionValue(accountsByType, "accountManager.getAccoun…yType(SA_ACCOUNT_SERVICE)");
        if (!(!(accountsByType.length == 0))) {
            WidgetOauth2AuthorizeSamsung$Companion.access$logI(WidgetOauth2AuthorizeSamsung.Companion, "Not Logged into Samsung Account");
        }
        try {
            ActivityResultLauncher activityResultLauncherAccess$getSamsungDisclaimerLauncher$p = WidgetOauth2AuthorizeSamsung.access$getSamsungDisclaimerLauncher$p(this.this$0);
            Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_NEW_THIRD_PARTY_INTEGRATION_WITH_SAMSUNG_ACCOUNT");
            intent.putExtra("client_id", "97t47j218f");
            intent.putExtra("progress_theme", ModelUserSettings.THEME_DARK);
            activityResultLauncherAccess$getSamsungDisclaimerLauncher$p.launch(intent);
        } catch (ActivityNotFoundException unused) {
            AppActivity appActivity = this.this$0.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }
}
