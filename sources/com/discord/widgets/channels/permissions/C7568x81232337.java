package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.permissions.PermissionUtils;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2 */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7568x81232337 extends AbstractC12240o implements Function1<PermissionOverwrite, Boolean> {
    public static final C7568x81232337 INSTANCE = new C7568x81232337();

    public C7568x81232337() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        C12238m.checkNotNullParameter(permissionOverwrite, "it");
        return PermissionUtils.can(20971536L, Long.valueOf(permissionOverwrite.getAllow()));
    }
}
