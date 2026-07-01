package com.discord.widgets.servers.role_members;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
import com.discord.views.SearchInputView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoleMembers4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsRoleMembersBinding> {
    public static final WidgetServerSettingsRoleMembers4 INSTANCE = new WidgetServerSettingsRoleMembers4();

    public WidgetServerSettingsRoleMembers4() {
        super(1, WidgetServerSettingsRoleMembersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsRoleMembersBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.role_members_app_view_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.role_members_app_view_flipper);
        if (appViewFlipper != null) {
            i = R.id.server_settings_role_members_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_role_members_list);
            if (recyclerView != null) {
                i = R.id.server_settings_role_members_search_input;
                SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.server_settings_role_members_search_input);
                if (searchInputView != null) {
                    return new WidgetServerSettingsRoleMembersBinding((LinearLayout) view, appViewFlipper, recyclerView, searchInputView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
