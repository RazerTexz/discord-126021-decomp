package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettings$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsBinding> {
    public static final WidgetServerSettings$binding$2 INSTANCE = new WidgetServerSettings$binding$2();

    public WidgetServerSettings$binding$2() {
        super(1, WidgetServerSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.server_settings_bans_option;
        TextView textView = (TextView) view.findViewById(C5419R.id.server_settings_bans_option);
        if (textView != null) {
            i = C5419R.id.server_settings_community_overview_option;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.server_settings_community_overview_option);
            if (textView2 != null) {
                i = C5419R.id.server_settings_emojis_option;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.server_settings_emojis_option);
                if (textView3 != null) {
                    i = C5419R.id.server_settings_enable_community_option;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.server_settings_enable_community_option);
                    if (textView4 != null) {
                        i = C5419R.id.server_settings_guild_role_subscription_basic_info;
                        TextView textView5 = (TextView) view.findViewById(C5419R.id.server_settings_guild_role_subscription_basic_info);
                        if (textView5 != null) {
                            i = C5419R.id.server_settings_guild_role_subscription_earnings;
                            TextView textView6 = (TextView) view.findViewById(C5419R.id.server_settings_guild_role_subscription_earnings);
                            if (textView6 != null) {
                                i = C5419R.id.server_settings_guild_role_subscription_get_started;
                                TextView textView7 = (TextView) view.findViewById(C5419R.id.server_settings_guild_role_subscription_get_started);
                                if (textView7 != null) {
                                    i = C5419R.id.server_settings_guild_role_subscription_tiers;
                                    TextView textView8 = (TextView) view.findViewById(C5419R.id.server_settings_guild_role_subscription_tiers);
                                    if (textView8 != null) {
                                        i = C5419R.id.server_settings_instant_invites_option;
                                        TextView textView9 = (TextView) view.findViewById(C5419R.id.server_settings_instant_invites_option);
                                        if (textView9 != null) {
                                            i = C5419R.id.server_settings_members_option;
                                            TextView textView10 = (TextView) view.findViewById(C5419R.id.server_settings_members_option);
                                            if (textView10 != null) {
                                                i = C5419R.id.server_settings_option_audit_log;
                                                TextView textView11 = (TextView) view.findViewById(C5419R.id.server_settings_option_audit_log);
                                                if (textView11 != null) {
                                                    i = C5419R.id.server_settings_option_channels;
                                                    TextView textView12 = (TextView) view.findViewById(C5419R.id.server_settings_option_channels);
                                                    if (textView12 != null) {
                                                        i = C5419R.id.server_settings_option_integrations;
                                                        TextView textView13 = (TextView) view.findViewById(C5419R.id.server_settings_option_integrations);
                                                        if (textView13 != null) {
                                                            i = C5419R.id.server_settings_option_moderation;
                                                            TextView textView14 = (TextView) view.findViewById(C5419R.id.server_settings_option_moderation);
                                                            if (textView14 != null) {
                                                                i = C5419R.id.server_settings_option_overview;
                                                                TextView textView15 = (TextView) view.findViewById(C5419R.id.server_settings_option_overview);
                                                                if (textView15 != null) {
                                                                    i = C5419R.id.server_settings_option_security;
                                                                    TextView textView16 = (TextView) view.findViewById(C5419R.id.server_settings_option_security);
                                                                    if (textView16 != null) {
                                                                        i = C5419R.id.server_settings_option_vanity_url;
                                                                        TextView textView17 = (TextView) view.findViewById(C5419R.id.server_settings_option_vanity_url);
                                                                        if (textView17 != null) {
                                                                            i = C5419R.id.server_settings_roles_option;
                                                                            TextView textView18 = (TextView) view.findViewById(C5419R.id.server_settings_roles_option);
                                                                            if (textView18 != null) {
                                                                                i = C5419R.id.server_settings_section_community;
                                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.server_settings_section_community);
                                                                                if (linearLayout != null) {
                                                                                    i = C5419R.id.server_settings_section_community_divider;
                                                                                    View viewFindViewById = view.findViewById(C5419R.id.server_settings_section_community_divider);
                                                                                    if (viewFindViewById != null) {
                                                                                        i = C5419R.id.server_settings_section_general_settings;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.server_settings_section_general_settings);
                                                                                        if (linearLayout2 != null) {
                                                                                            i = C5419R.id.server_settings_section_server_monetization;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(C5419R.id.server_settings_section_server_monetization);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = C5419R.id.server_settings_section_server_monetization_divider;
                                                                                                View viewFindViewById2 = view.findViewById(C5419R.id.server_settings_section_server_monetization_divider);
                                                                                                if (viewFindViewById2 != null) {
                                                                                                    i = C5419R.id.server_settings_section_user_management;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(C5419R.id.server_settings_section_user_management);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i = C5419R.id.server_settings_section_user_management_divider;
                                                                                                        View viewFindViewById3 = view.findViewById(C5419R.id.server_settings_section_user_management_divider);
                                                                                                        if (viewFindViewById3 != null) {
                                                                                                            i = C5419R.id.server_settings_server_icon;
                                                                                                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.server_settings_server_icon);
                                                                                                            if (simpleDraweeView != null) {
                                                                                                                i = C5419R.id.server_settings_server_icon_text;
                                                                                                                TextView textView19 = (TextView) view.findViewById(C5419R.id.server_settings_server_icon_text);
                                                                                                                if (textView19 != null) {
                                                                                                                    i = C5419R.id.server_settings_server_name;
                                                                                                                    TextView textView20 = (TextView) view.findViewById(C5419R.id.server_settings_server_name);
                                                                                                                    if (textView20 != null) {
                                                                                                                        return new WidgetServerSettingsBinding((CoordinatorLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, linearLayout, viewFindViewById, linearLayout2, linearLayout3, viewFindViewById2, linearLayout4, viewFindViewById3, simpleDraweeView, textView19, textView20);
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
