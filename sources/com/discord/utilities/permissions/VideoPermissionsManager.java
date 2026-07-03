package com.discord.utilities.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VideoPermissionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoPermissionsManager {
    private final PermissionsManager permissionsManager;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPermissionsManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VideoPermissionsManager(PermissionsManager permissionsManager) {
        C12238m.checkNotNullParameter(permissionsManager, "permissionsManager");
        this.permissionsManager = permissionsManager;
    }

    public final boolean hasVideoPermission(Channel channel, Long channelIdAFK, Long computedPermissions) {
        C12238m.checkNotNullParameter(channel, "channel");
        long id2 = channel.getId();
        if (channelIdAFK != null && id2 == channelIdAFK.longValue()) {
            return false;
        }
        if (ChannelUtils.m7667B(channel)) {
            return true;
        }
        return this.permissionsManager.can(512L, computedPermissions);
    }

    public /* synthetic */ VideoPermissionsManager(PermissionsManager permissionsManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PermissionsManager() : permissionsManager);
    }
}
