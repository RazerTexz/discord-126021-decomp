package com.discord.widgets.servers.settings.members;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsMembers2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsMembersBinding> {
    public static final WidgetServerSettingsMembers2 INSTANCE = new WidgetServerSettingsMembers2();

    public WidgetServerSettingsMembers2() {
        super(1, WidgetServerSettingsMembersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsMembersBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.no_results_text;
        TextView textView = (TextView) view.findViewById(R.id.no_results_text);
        if (textView != null) {
            i = R.id.server_settings_members_header_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.server_settings_members_header_container);
            if (linearLayout != null) {
                i = R.id.server_settings_members_name_search;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_members_name_search);
                if (textInputLayout != null) {
                    i = R.id.server_settings_members_recycler;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_members_recycler);
                    if (recyclerView != null) {
                        i = R.id.server_settings_members_roles_spinner;
                        Spinner spinner = (Spinner) view.findViewById(R.id.server_settings_members_roles_spinner);
                        if (spinner != null) {
                            i = R.id.server_settings_members_view_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_members_view_flipper);
                            if (appViewFlipper != null) {
                                return new WidgetServerSettingsMembersBinding((CoordinatorLayout) view, textView, linearLayout, textInputLayout, recyclerView, spinner, appViewFlipper);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
