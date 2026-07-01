package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter$setItems$1 extends o implements Function1<List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem>, Unit> {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierAdapter$setItems$1(ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter) {
        super(1);
        this.this$0 = serverSettingsGuildRoleSubscriptionTierAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> list) {
        m.checkNotNullParameter(list, "items");
        ServerSettingsGuildRoleSubscriptionTierAdapter.access$setItems$p(this.this$0, list);
    }
}
