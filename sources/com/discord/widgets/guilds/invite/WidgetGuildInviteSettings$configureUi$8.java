package com.discord.widgets.guilds.invite;

import android.widget.RadioGroup;
import android.widget.RadioGroup$OnCheckedChangeListener;
import com.discord.models.domain.ModelInvite$Settings;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$configureUi$8 implements RadioGroup$OnCheckedChangeListener {
    public final /* synthetic */ ModelInvite$Settings $inviteSettings;
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    public WidgetGuildInviteSettings$configureUi$8(WidgetGuildInviteSettings widgetGuildInviteSettings, ModelInvite$Settings modelInvite$Settings) {
        this.this$0 = widgetGuildInviteSettings;
        this.$inviteSettings = modelInvite$Settings;
    }

    @Override // android.widget.RadioGroup$OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        GuildInviteSettingsViewModel guildInviteSettingsViewModelAccess$getViewModel$p = WidgetGuildInviteSettings.access$getViewModel$p(this.this$0);
        ModelInvite$Settings modelInvite$SettingsMergeMaxUses = this.$inviteSettings.mergeMaxUses(i);
        m.checkNotNullExpressionValue(modelInvite$SettingsMergeMaxUses, "inviteSettings.mergeMaxUses(checkedId)");
        guildInviteSettingsViewModelAccess$getViewModel$p.updatePendingInviteSettings(modelInvite$SettingsMergeMaxUses);
    }
}
