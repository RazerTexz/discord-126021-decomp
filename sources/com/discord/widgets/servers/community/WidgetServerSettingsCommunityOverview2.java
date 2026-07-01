package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.views.LoadingButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityOverview2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCommunityOverviewBinding> {
    public static final WidgetServerSettingsCommunityOverview2 INSTANCE = new WidgetServerSettingsCommunityOverview2();

    public WidgetServerSettingsCommunityOverview2() {
        super(1, WidgetServerSettingsCommunityOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsCommunityOverviewBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.community_rules_channel;
        CommunitySelectorView communitySelectorView = (CommunitySelectorView) view.findViewById(R.id.community_rules_channel);
        if (communitySelectorView != null) {
            i = R.id.community_updates_channel;
            CommunitySelectorView communitySelectorView2 = (CommunitySelectorView) view.findViewById(R.id.community_updates_channel);
            if (communitySelectorView2 != null) {
                i = R.id.server_settings_community_locale;
                CommunitySelectorView communitySelectorView3 = (CommunitySelectorView) view.findViewById(R.id.server_settings_community_locale);
                if (communitySelectorView3 != null) {
                    i = R.id.server_settings_community_overview_scroll;
                    ScrollView scrollView = (ScrollView) view.findViewById(R.id.server_settings_community_overview_scroll);
                    if (scrollView != null) {
                        i = R.id.server_settings_disable_community_button;
                        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.server_settings_disable_community_button);
                        if (loadingButton != null) {
                            i = R.id.server_settings_disable_community_message;
                            CommunitySelectorView communitySelectorView4 = (CommunitySelectorView) view.findViewById(R.id.server_settings_disable_community_message);
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
