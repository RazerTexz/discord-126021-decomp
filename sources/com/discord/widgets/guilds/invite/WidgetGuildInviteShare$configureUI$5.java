package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ Experiment $inviteExperiment;
    public final /* synthetic */ WidgetInviteModel $widgetInviteModel;
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    public WidgetGuildInviteShare$configureUI$5(WidgetGuildInviteShare widgetGuildInviteShare, WidgetInviteModel widgetInviteModel, Experiment experiment) {
        this.this$0 = widgetGuildInviteShare;
        this.$widgetInviteModel = widgetInviteModel;
        this.$inviteExperiment = experiment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i;
        WidgetGuildInviteShare.access$getBinding$p(this.this$0).e.toggle();
        ModelInvite$Settings settings = this.$widgetInviteModel.getSettings();
        if (settings != null) {
            WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModelAccess$getViewModel$p = WidgetGuildInviteShare.access$getViewModel$p(this.this$0);
            CheckedSetting checkedSetting = WidgetGuildInviteShare.access$getBinding$p(this.this$0).e;
            m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
            if (checkedSetting.isChecked()) {
                i = 0;
            } else {
                Experiment experiment = this.$inviteExperiment;
                i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite$Settings.SEVEN_DAYS;
            }
            ModelInvite$Settings modelInvite$SettingsMergeMaxAge = settings.mergeMaxAge(i);
            m.checkNotNullExpressionValue(modelInvite$SettingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
            widgetGuildInviteShareViewModelAccess$getViewModel$p.updateInviteSettings(modelInvite$SettingsMergeMaxAge);
        }
        Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
        if (targetChannel != null) {
            WidgetGuildInviteShare.access$getViewModel$p(this.this$0).generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
        }
    }
}
