package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsBansBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsBans$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsBansBinding> {
    public static final WidgetServerSettingsBans$binding$2 INSTANCE = new WidgetServerSettingsBans$binding$2();

    public WidgetServerSettingsBans$binding$2() {
        super(1, WidgetServerSettingsBansBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsBansBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsBansBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.no_bans_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.no_bans_body);
        if (textView != null) {
            i = C5419R.id.no_results_text;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.no_results_text);
            if (textView2 != null) {
                i = C5419R.id.server_settings_bans_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.server_settings_bans_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.server_settings_bans_search;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.server_settings_bans_search);
                    if (textInputLayout != null) {
                        i = C5419R.id.server_settings_bans_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_bans_view_flipper);
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
