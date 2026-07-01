package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneManage$Companion$Source;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$12 implements View$OnClickListener {
    public final /* synthetic */ MeUser $user;
    public final /* synthetic */ WidgetSettingsAccount this$0;

    public WidgetSettingsAccount$configureUI$12(WidgetSettingsAccount widgetSettingsAccount, MeUser meUser) {
        this.this$0 = widgetSettingsAccount;
        this.$user = meUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UserUtils userUtils = UserUtils.INSTANCE;
        if (userUtils.isMfaSMSEnabled(this.$user)) {
            WidgetEnableSMSBackupDialog$Companion widgetEnableSMSBackupDialog$Companion = WidgetEnableSMSBackupDialog.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetEnableSMSBackupDialog$Companion.show(parentFragmentManager, false);
            return;
        }
        if (userUtils.isMfaSMSEnabled(this.$user) || !userUtils.getHasPhone(this.$user)) {
            WidgetUserPhoneManage.Companion.launch(a.x(view, "it", "it.context"), WidgetUserAccountVerifyBase$Mode.NO_HISTORY_FROM_USER_SETTINGS, WidgetUserPhoneManage$Companion$Source.MFA_PHONE_UPDATE);
            return;
        }
        WidgetEnableSMSBackupDialog$Companion widgetEnableSMSBackupDialog$Companion2 = WidgetEnableSMSBackupDialog.Companion;
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        widgetEnableSMSBackupDialog$Companion2.show(parentFragmentManager2, true);
    }
}
