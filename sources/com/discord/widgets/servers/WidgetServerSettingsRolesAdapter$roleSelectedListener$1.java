package com.discord.widgets.servers;

import com.discord.api.role.GuildRole;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$roleSelectedListener$1 extends o implements Function1<GuildRole, Unit> {
    public static final WidgetServerSettingsRolesAdapter$roleSelectedListener$1 INSTANCE = new WidgetServerSettingsRolesAdapter$roleSelectedListener$1();

    public WidgetServerSettingsRolesAdapter$roleSelectedListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
        invoke2(guildRole);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRole guildRole) {
        m.checkNotNullParameter(guildRole, "it");
    }
}
