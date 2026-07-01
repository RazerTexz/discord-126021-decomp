package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$configureUI$2 extends o implements Function1<ModelInvite, Unit> {
    public static final WidgetServerSettingsInstantInvites$configureUI$2 INSTANCE = new WidgetServerSettingsInstantInvites$configureUI$2();

    public WidgetServerSettingsInstantInvites$configureUI$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        m.checkNotNullParameter(modelInvite, "invite");
        StoreStream.Companion.getInstantInvites().onInviteRemoved(modelInvite);
    }
}
