package com.discord.widgets.servers;

import android.view.View;
import b.a.d.AppToast;
import com.discord.R;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter5 extends Lambda implements Function1<View, Unit> {
    public static final WidgetServerSettingsRolesAdapter5 INSTANCE = new WidgetServerSettingsRolesAdapter5();

    public WidgetServerSettingsRolesAdapter5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AppToast.g(view.getContext(), R.string.help_missing_manage_roles_permission, 0, null, 12);
    }
}
