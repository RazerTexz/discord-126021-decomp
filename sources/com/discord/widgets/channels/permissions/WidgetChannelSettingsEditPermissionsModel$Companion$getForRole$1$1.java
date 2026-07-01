package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$1 extends o implements Function1<PermissionOverwrite, Boolean> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$1(WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1 widgetChannelSettingsEditPermissionsModel$Companion$getForRole$1) {
        super(1);
        this.this$0 = widgetChannelSettingsEditPermissionsModel$Companion$getForRole$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        return permissionOverwrite.getId() == this.this$0.$targetRoleId;
    }
}
