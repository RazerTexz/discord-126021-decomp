package com.discord.widgets.servers.settings.members;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsMembers$binding$2 extends k implements Function1<View, WidgetServerSettingsMembersBinding> {
    public static final WidgetServerSettingsMembers$binding$2 INSTANCE = new WidgetServerSettingsMembers$binding$2();

    public WidgetServerSettingsMembers$binding$2() {
        super(1, WidgetServerSettingsMembersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsMembersBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsMembersBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.no_results_text;
        TextView textView = (TextView) view.findViewById(R$id.no_results_text);
        if (textView != null) {
            i = R$id.server_settings_members_header_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.server_settings_members_header_container);
            if (linearLayout != null) {
                i = R$id.server_settings_members_name_search;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.server_settings_members_name_search);
                if (textInputLayout != null) {
                    i = R$id.server_settings_members_recycler;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.server_settings_members_recycler);
                    if (recyclerView != null) {
                        i = R$id.server_settings_members_roles_spinner;
                        Spinner spinner = (Spinner) view.findViewById(R$id.server_settings_members_roles_spinner);
                        if (spinner != null) {
                            i = R$id.server_settings_members_view_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.server_settings_members_view_flipper);
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
