package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ MeUser $user;

    public WidgetSettingsAccount$configureUI$4(MeUser meUser) {
        this.$user = meUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        boolean zIsVerified = this.$user.isVerified();
        Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2022-01_email_change_confirmation", zIsVerified);
        boolean z2 = userExperiment != null && userExperiment.getBucket() == 1 && zIsVerified;
        WidgetSettingsAccountEmailEdit$Companion widgetSettingsAccountEmailEdit$Companion = WidgetSettingsAccountEmailEdit.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetSettingsAccountEmailEdit$Companion.launch(context, z2);
    }
}
