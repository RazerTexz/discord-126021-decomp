package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsOverviewAfkTimeoutBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsOverview$AfkBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsOverviewAfkTimeoutBinding> {
    public static final WidgetServerSettingsOverview$AfkBottomSheet$binding$2 INSTANCE = new WidgetServerSettingsOverview$AfkBottomSheet$binding$2();

    public WidgetServerSettingsOverview$AfkBottomSheet$binding$2() {
        super(1, WidgetServerSettingsOverviewAfkTimeoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsOverviewAfkTimeoutBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = C5419R.id.server_settings_overview_afk_timeout_01;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.server_settings_overview_afk_timeout_01);
            if (textView2 != null) {
                i = C5419R.id.server_settings_overview_afk_timeout_05;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.server_settings_overview_afk_timeout_05);
                if (textView3 != null) {
                    i = C5419R.id.server_settings_overview_afk_timeout_15;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.server_settings_overview_afk_timeout_15);
                    if (textView4 != null) {
                        i = C5419R.id.server_settings_overview_afk_timeout_30;
                        TextView textView5 = (TextView) view.findViewById(C5419R.id.server_settings_overview_afk_timeout_30);
                        if (textView5 != null) {
                            i = C5419R.id.server_settings_overview_afk_timeout_60;
                            TextView textView6 = (TextView) view.findViewById(C5419R.id.server_settings_overview_afk_timeout_60);
                            if (textView6 != null) {
                                return new WidgetServerSettingsOverviewAfkTimeoutBinding((NestedScrollView) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
