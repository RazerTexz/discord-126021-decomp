package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4 */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7570x81232339 extends AbstractC12240o implements Function1<PermissionOverwrite, Long> {
    public static final C7570x81232339 INSTANCE = new C7570x81232339();

    public C7570x81232339() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(PermissionOverwrite permissionOverwrite) {
        return Long.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(PermissionOverwrite permissionOverwrite) {
        C12238m.checkNotNullParameter(permissionOverwrite, "it");
        return permissionOverwrite.m8131e();
    }
}
