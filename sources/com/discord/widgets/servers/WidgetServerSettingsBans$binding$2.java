package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsBansBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsBans$binding$2 extends k implements Function1<View, WidgetServerSettingsBansBinding> {
    public static final WidgetServerSettingsBans$binding$2 INSTANCE = new WidgetServerSettingsBans$binding$2();

    public WidgetServerSettingsBans$binding$2() {
        super(1, WidgetServerSettingsBansBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsBansBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsBansBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsBansBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.no_bans_body;
        TextView textView = (TextView) view.findViewById(R$id.no_bans_body);
        if (textView != null) {
            i = R$id.no_results_text;
            TextView textView2 = (TextView) view.findViewById(R$id.no_results_text);
            if (textView2 != null) {
                i = R$id.server_settings_bans_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.server_settings_bans_recycler);
                if (recyclerView != null) {
                    i = R$id.server_settings_bans_search;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.server_settings_bans_search);
                    if (textInputLayout != null) {
                        i = R$id.server_settings_bans_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.server_settings_bans_view_flipper);
                        if (appViewFlipper != null) {
                            return new WidgetServerSettingsBansBinding((CoordinatorLayout) view, textView, textView2, recyclerView, textInputLayout, appViewFlipper);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
