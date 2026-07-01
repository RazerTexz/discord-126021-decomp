package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites3 extends Lambda implements Function1<ModelInvite, Unit> {
    public static final WidgetServerSettingsInstantInvites3 INSTANCE = new WidgetServerSettingsInstantInvites3();

    public WidgetServerSettingsInstantInvites3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        Intrinsics3.checkNotNullParameter(modelInvite, "it");
    }
}
