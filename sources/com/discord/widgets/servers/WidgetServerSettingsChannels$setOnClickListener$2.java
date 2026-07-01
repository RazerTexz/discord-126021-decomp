package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$setOnClickListener$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels$Model $model;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels$setOnClickListener$2(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) {
        super(1);
        this.this$0 = widgetServerSettingsChannels;
        this.$model = widgetServerSettingsChannels$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        if (PermissionUtils.can(16L, this.$model.getChannelPermissions().get(Long.valueOf(j)))) {
            Channel channel = this.$model.getChannels().get(Long.valueOf(j));
            if (channel == null || !ChannelUtils.w(channel)) {
                WidgetTextChannelSettings.Companion.launch(j, this.this$0.requireContext());
            } else {
                WidgetVoiceChannelSettings.Companion.launch(j, this.this$0.requireContext());
            }
        }
    }
}
