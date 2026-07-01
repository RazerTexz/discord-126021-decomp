package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.utilities.stateful.StatefulViews;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$configureUi$2 implements View$OnClickListener {
    public final /* synthetic */ String $displayName;
    public final /* synthetic */ Channel $group;
    public final /* synthetic */ WidgetChannelGroupDMSettings this$0;

    public WidgetChannelGroupDMSettings$configureUi$2(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, Channel channel, String str) {
        this.this$0 = widgetChannelGroupDMSettings;
        this.$group = channel;
        this.$displayName = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModelAccess$getViewModel$p = WidgetChannelGroupDMSettings.access$getViewModel$p(this.this$0);
        long id2 = this.$group.getId();
        StatefulViews statefulViewsAccess$getState$p = WidgetChannelGroupDMSettings.access$getState$p(this.this$0);
        TextInputLayout textInputLayout = WidgetChannelGroupDMSettings.access$getBinding$p(this.this$0).f2257b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        channelGroupDMSettingsViewModelAccess$getViewModel$p.editGroup(id2, ((String) statefulViewsAccess$getState$p.get(textInputLayout.getId(), this.$displayName)).toString());
    }
}
