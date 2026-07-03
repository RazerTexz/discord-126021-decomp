package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.views.LoadingButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityOverview$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsCommunityOverviewBinding> {
    public static final WidgetServerSettingsCommunityOverview$binding$2 INSTANCE = new WidgetServerSettingsCommunityOverview$binding$2();

    public WidgetServerSettingsCommunityOverview$binding$2() {
        super(1, WidgetServerSettingsCommunityOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsCommunityOverviewBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.community_rules_channel;
        CommunitySelectorView communitySelectorView = (CommunitySelectorView) view.findViewById(C5419R.id.community_rules_channel);
        if (communitySelectorView != null) {
            i = C5419R.id.community_updates_channel;
            CommunitySelectorView communitySelectorView2 = (CommunitySelectorView) view.findViewById(C5419R.id.community_updates_channel);
            if (communitySelectorView2 != null) {
                i = C5419R.id.server_settings_community_locale;
                CommunitySelectorView communitySelectorView3 = (CommunitySelectorView) view.findViewById(C5419R.id.server_settings_community_locale);
                if (communitySelectorView3 != null) {
                    i = C5419R.id.server_settings_community_overview_scroll;
                    ScrollView scrollView = (ScrollView) view.findViewById(C5419R.id.server_settings_community_overview_scroll);
                    if (scrollView != null) {
                        i = C5419R.id.server_settings_disable_community_button;
                        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.server_settings_disable_community_button);
                        if (loadingButton != null) {
                            i = C5419R.id.server_settings_disable_community_message;
                            CommunitySelectorView communitySelectorView4 = (CommunitySelectorView) view.findViewById(C5419R.id.server_settings_disable_community_message);
                            if (communitySelectorView4 != null) {
                                return new WidgetServerSettingsCommunityOverviewBinding((LinearLayout) view, communitySelectorView, communitySelectorView2, communitySelectorView3, scrollView, loadingButton, communitySelectorView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
