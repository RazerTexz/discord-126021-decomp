package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2 extends o implements Function1<PermissionOverwrite, Boolean> {
    public static final WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2 INSTANCE = new WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2();

    public WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        m.checkNotNullParameter(permissionOverwrite, "it");
        return PermissionUtils.can(20971536L, Long.valueOf(permissionOverwrite.getAllow()));
    }
}
