package com.discord.widgets.servers.role_members;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers7 extends Lambda implements Function0<ServerSettingsRoleMembersViewModel> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers7(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(0);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsRoleMembersViewModel invoke() {
        return new ServerSettingsRoleMembersViewModel(this.this$0.getGuildId(), this.this$0.getGuildRoleId(), null, null, null, null, null, null, null, 508, null);
    }
}
