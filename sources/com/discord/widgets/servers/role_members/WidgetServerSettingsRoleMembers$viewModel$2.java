package com.discord.widgets.servers.role_members;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$viewModel$2 extends AbstractC12240o implements Function0<ServerSettingsRoleMembersViewModel> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers$viewModel$2(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(0);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsRoleMembersViewModel invoke() {
        return new ServerSettingsRoleMembersViewModel(this.this$0.getGuildId(), this.this$0.getGuildRoleId(), null, null, null, null, null, null, null, 508, null);
    }
}
