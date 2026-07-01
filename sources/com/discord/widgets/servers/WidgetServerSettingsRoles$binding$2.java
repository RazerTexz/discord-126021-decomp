package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsRolesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoles$binding$2 extends k implements Function1<View, WidgetServerSettingsRolesBinding> {
    public static final WidgetServerSettingsRoles$binding$2 INSTANCE = new WidgetServerSettingsRoles$binding$2();

    public WidgetServerSettingsRoles$binding$2() {
        super(1, WidgetServerSettingsRolesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsRolesBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsRolesBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.roles_list_add_role_fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.roles_list_add_role_fab);
            if (floatingActionButton != null) {
                i = R$id.server_settings_roles_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.server_settings_roles_recycler);
                if (recyclerView != null) {
                    return new WidgetServerSettingsRolesBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
