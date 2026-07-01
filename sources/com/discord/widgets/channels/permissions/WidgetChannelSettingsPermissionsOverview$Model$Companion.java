package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$Model$Companion {
    private WidgetChannelSettingsPermissionsOverview$Model$Companion() {
    }

    public final Observable<WidgetChannelSettingsPermissionsOverview$Model> get(long channelId) {
        Observable observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1(channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…          }\n            }");
        return observableY;
    }

    public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
        return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
    }

    public /* synthetic */ WidgetChannelSettingsPermissionsOverview$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
