package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.application.Application;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsEmptyGuildRoleSubscriptionsViewModel$1 extends o implements Function1<List<? extends Application>, Unit> {
    public final /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel$1(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel) {
        super(1);
        this.this$0 = serverSettingsEmptyGuildRoleSubscriptionsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
        invoke2((List<Application>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Application> list) {
        m.checkNotNullParameter(list, "it");
        ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$handleMonetizationStatus(this.this$0, list);
    }
}
