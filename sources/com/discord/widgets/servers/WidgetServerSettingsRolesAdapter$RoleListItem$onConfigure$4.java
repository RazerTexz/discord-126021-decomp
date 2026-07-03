package com.discord.widgets.servers;

import android.view.View;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$4 extends AbstractC12240o implements Function1<View, Unit> {
    public static final WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$4 INSTANCE = new WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$4();

    public WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "view");
        C0876m.m169g(view.getContext(), C5419R.string.two_fa_guild_mfa_warning_ios, 0, null, 12);
    }
}
