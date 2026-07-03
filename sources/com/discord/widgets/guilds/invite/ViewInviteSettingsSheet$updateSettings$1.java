package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$updateSettings$1 extends AbstractC12240o implements Function1<ModelInvite.Settings, Unit> {
    public static final ViewInviteSettingsSheet$updateSettings$1 INSTANCE = new ViewInviteSettingsSheet$updateSettings$1();

    public ViewInviteSettingsSheet$updateSettings$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite.Settings settings) {
        invoke2(settings);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite.Settings settings) {
        C12238m.checkNotNullParameter(settings, "it");
    }
}
