package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsRolesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoles3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsRolesBinding> {
    public static final WidgetServerSettingsRoles3 INSTANCE = new WidgetServerSettingsRoles3();

    public WidgetServerSettingsRoles3() {
        super(1, WidgetServerSettingsRolesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsRolesBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.roles_list_add_role_fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.roles_list_add_role_fab);
            if (floatingActionButton != null) {
                i = R.id.server_settings_roles_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_roles_recycler);
                if (recyclerView != null) {
                    return new WidgetServerSettingsRolesBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
