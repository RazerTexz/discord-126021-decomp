package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelSettingsEditPermissionsModel {
    public static final WidgetChannelSettingsEditPermissionsModel$Companion Companion = new WidgetChannelSettingsEditPermissionsModel$Companion(null);
    private final Channel channel;
    private final long targetId;
    private final int type;
    private final boolean useNewThreadsPermissions;

    private WidgetChannelSettingsEditPermissionsModel(Channel channel, long j, int i, boolean z2) {
        this.channel = channel;
        this.targetId = j;
        this.type = i;
        this.useNewThreadsPermissions = z2;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public long getTargetId() {
        return this.targetId;
    }

    public final int getType() {
        return this.type;
    }

    public boolean getUseNewThreadsPermissions() {
        return this.useNewThreadsPermissions;
    }

    public /* synthetic */ WidgetChannelSettingsEditPermissionsModel(Channel channel, long j, int i, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, j, i, z2);
    }
}
