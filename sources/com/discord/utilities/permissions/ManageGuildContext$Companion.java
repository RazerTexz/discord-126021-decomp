package com.discord.utilities.permissions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageGuildContext$Companion {
    private ManageGuildContext$Companion() {
    }

    public final ManageGuildContext from(List<Channel> categories, boolean isOwner, Long guildPermissions, Map<Long, Long> channelPermissions, int guildMfaLevel, boolean isMeMfaEnabled) {
        boolean z2;
        m.checkNotNullParameter(categories, "categories");
        m.checkNotNullParameter(channelPermissions, "channelPermissions");
        if (!(categories instanceof Collection) || !categories.isEmpty()) {
            Iterator<T> it = categories.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (PermissionUtils.can(16L, (Long) a.d((Channel) it.next(), channelPermissions))) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        return new ManageGuildContext(isOwner || PermissionUtils.can(32L, guildPermissions), isOwner || PermissionUtils.can(16L, guildPermissions) || z2, isOwner || PermissionUtils.can(Permission.MANAGE_ROLES, guildPermissions), isOwner || PermissionUtils.can(4L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_NICKNAMES, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EMOJIS_AND_STICKERS, guildPermissions), isOwner || PermissionUtils.can(128L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions), isOwner && PermissionUtils.isElevated(isMeMfaEnabled, guildMfaLevel));
    }

    public /* synthetic */ ManageGuildContext$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
