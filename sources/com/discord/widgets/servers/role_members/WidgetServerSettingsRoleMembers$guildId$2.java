package com.discord.widgets.servers.role_members;

import android.os.Bundle;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$guildId$2 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers$guildId$2(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(0);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L);
        }
        return -1L;
    }
}
