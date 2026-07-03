package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1 */
/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9581x3952eed8 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
    public static final C9581x3952eed8 INSTANCE = new C9581x3952eed8();

    public C9581x3952eed8() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        C12238m.checkNotNullParameter(modelInvite, "it");
    }
}
