package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccount$Model $model;
    public final /* synthetic */ WidgetSettingsAccount this$0;

    public WidgetSettingsAccount$configureUI$10(WidgetSettingsAccount widgetSettingsAccount, WidgetSettingsAccount$Model widgetSettingsAccount$Model) {
        this.this$0 = widgetSettingsAccount;
        this.$model = widgetSettingsAccount$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$model.getOwnsAnyGuilds()) {
            WidgetSettingsAccount.access$showOwnsGuildModal(this.this$0);
            return;
        }
        WidgetDisableDeleteAccountDialog$Companion widgetDisableDeleteAccountDialog$Companion = WidgetDisableDeleteAccountDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetDisableDeleteAccountDialog$Companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog$Mode.DISABLE);
    }
}
