package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$configureUi$9 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite$Settings $inviteSettings;
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    public WidgetGuildInviteSettings$configureUi$9(WidgetGuildInviteSettings widgetGuildInviteSettings, ModelInvite$Settings modelInvite$Settings) {
        this.this$0 = widgetGuildInviteSettings;
        this.$inviteSettings = modelInvite$Settings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteSettings.access$getBinding$p(this.this$0).f.toggle();
        GuildInviteSettingsViewModel guildInviteSettingsViewModelAccess$getViewModel$p = WidgetGuildInviteSettings.access$getViewModel$p(this.this$0);
        ModelInvite$Settings modelInvite$Settings = this.$inviteSettings;
        CheckedSetting checkedSetting = WidgetGuildInviteSettings.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
        ModelInvite$Settings modelInvite$SettingsMergeTemporary = modelInvite$Settings.mergeTemporary(checkedSetting.isChecked());
        m.checkNotNullExpressionValue(modelInvite$SettingsMergeTemporary, "inviteSettings.mergeTemp…raryMembership.isChecked)");
        guildInviteSettingsViewModelAccess$getViewModel$p.updatePendingInviteSettings(modelInvite$SettingsMergeTemporary);
    }
}
