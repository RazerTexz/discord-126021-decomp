package com.discord.widgets.servers.role_members;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
import com.discord.views.SearchInputView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoleMembers$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsRoleMembersBinding> {
    public static final WidgetServerSettingsRoleMembers$binding$2 INSTANCE = new WidgetServerSettingsRoleMembers$binding$2();

    public WidgetServerSettingsRoleMembers$binding$2() {
        super(1, WidgetServerSettingsRoleMembersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsRoleMembersBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.role_members_app_view_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.role_members_app_view_flipper);
        if (appViewFlipper != null) {
            i = C5419R.id.server_settings_role_members_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.server_settings_role_members_list);
            if (recyclerView != null) {
                i = C5419R.id.server_settings_role_members_search_input;
                SearchInputView searchInputView = (SearchInputView) view.findViewById(C5419R.id.server_settings_role_members_search_input);
                if (searchInputView != null) {
                    return new WidgetServerSettingsRoleMembersBinding((LinearLayout) view, appViewFlipper, recyclerView, searchInputView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
