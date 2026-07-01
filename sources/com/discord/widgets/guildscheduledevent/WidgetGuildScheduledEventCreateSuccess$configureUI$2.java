package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ Experiment $inviteExperiment;
    public final /* synthetic */ WidgetInviteModel $widgetInviteModel;
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    public WidgetGuildScheduledEventCreateSuccess$configureUI$2(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess, WidgetInviteModel widgetInviteModel, Experiment experiment) {
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
        this.$widgetInviteModel = widgetInviteModel;
        this.$inviteExperiment = experiment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i;
        WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(this.this$0).d.toggle();
        ModelInvite$Settings settings = this.$widgetInviteModel.getSettings();
        if (settings != null) {
            WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p = WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(this.this$0);
            CheckedSetting checkedSetting = WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
            if (checkedSetting.isChecked()) {
                i = 0;
            } else {
                Experiment experiment = this.$inviteExperiment;
                i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite$Settings.SEVEN_DAYS;
            }
            ModelInvite$Settings modelInvite$SettingsMergeMaxAge = settings.mergeMaxAge(i);
            m.checkNotNullExpressionValue(modelInvite$SettingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
            widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p.updateInviteSettings(modelInvite$SettingsMergeMaxAge);
        }
        Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
        if (targetChannel != null) {
            WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(this.this$0).generateInviteLink(Long.valueOf(Long.valueOf(targetChannel.getId()).longValue()));
        }
    }
}
