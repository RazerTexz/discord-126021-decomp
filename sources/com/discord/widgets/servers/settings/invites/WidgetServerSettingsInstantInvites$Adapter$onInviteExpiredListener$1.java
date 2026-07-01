package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1 extends o implements Function1<ModelInvite, Unit> {
    public static final WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1 INSTANCE = new WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1();

    public WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        m.checkNotNullParameter(modelInvite, "it");
    }
}
