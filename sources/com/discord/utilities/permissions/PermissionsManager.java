package com.discord.utilities.permissions;


/* JADX INFO: compiled from: PermissionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionsManager {
    public final boolean can(long permission, Long computedPermissions) {
        return PermissionUtils.can(permission, computedPermissions);
    }
}
