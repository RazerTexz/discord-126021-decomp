package com.discord.widgets.servers;

import com.discord.api.role.GuildRole;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$roleSelectedListener$1 extends AbstractC12240o implements Function1<GuildRole, Unit> {
    public static final WidgetServerSettingsRolesAdapter$roleSelectedListener$1 INSTANCE = new WidgetServerSettingsRolesAdapter$roleSelectedListener$1();

    public WidgetServerSettingsRolesAdapter$roleSelectedListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
        invoke2(guildRole);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRole guildRole) {
        C12238m.checkNotNullParameter(guildRole, "it");
    }
}
