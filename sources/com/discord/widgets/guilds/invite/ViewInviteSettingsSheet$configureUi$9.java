package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$configureUi$9 implements View$OnClickListener {
    public final /* synthetic */ ViewInviteSettingsSheet this$0;

    public ViewInviteSettingsSheet$configureUi$9(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.this$0 = viewInviteSettingsSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ModelInvite$Settings modelInvite$SettingsMergeTemporary;
        ViewInviteSettingsSheet.access$getBinding$p(this.this$0).f.toggle();
        ViewInviteSettingsSheet viewInviteSettingsSheet = this.this$0;
        ModelInvite$Settings modelInvite$SettingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
        if (modelInvite$SettingsAccess$getPendingInviteSettings$p != null) {
            CheckedSetting checkedSetting = ViewInviteSettingsSheet.access$getBinding$p(this.this$0).f;
            m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            modelInvite$SettingsMergeTemporary = modelInvite$SettingsAccess$getPendingInviteSettings$p.mergeTemporary(checkedSetting.isChecked());
        } else {
            modelInvite$SettingsMergeTemporary = null;
        }
        ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, modelInvite$SettingsMergeTemporary);
    }
}
