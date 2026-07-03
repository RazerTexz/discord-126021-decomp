package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.views.StatusView;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettings$binding$2 extends C12236k implements Function1<View, WidgetSettingsBinding> {
    public static final WidgetSettings$binding$2 INSTANCE = new WidgetSettings$binding$2();

    public WidgetSettings$binding$2() {
        super(1, WidgetSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.accessibility;
        TextView textView = (TextView) view.findViewById(C5419R.id.accessibility);
        if (textView != null) {
            i = C5419R.id.account;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.account);
            if (textView2 != null) {
                i = C5419R.id.acknowledgements;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.acknowledgements);
                if (textView3 != null) {
                    i = C5419R.id.activity_status;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.activity_status);
                    if (textView4 != null) {
                        i = C5419R.id.app_info_header;
                        TextView textView5 = (TextView) view.findViewById(C5419R.id.app_info_header);
                        if (textView5 != null) {
                            i = C5419R.id.app_settings_header;
                            TextView textView6 = (TextView) view.findViewById(C5419R.id.app_settings_header);
                            if (textView6 != null) {
                                i = C5419R.id.appearance;
                                TextView textView7 = (TextView) view.findViewById(C5419R.id.appearance);
                                if (textView7 != null) {
                                    i = C5419R.id.authorized_apps;
                                    TextView textView8 = (TextView) view.findViewById(C5419R.id.authorized_apps);
                                    if (textView8 != null) {
                                        i = C5419R.id.behavior;
                                        TextView textView9 = (TextView) view.findViewById(C5419R.id.behavior);
                                        if (textView9 != null) {
                                            i = C5419R.id.changelog;
                                            TextView textView10 = (TextView) view.findViewById(C5419R.id.changelog);
                                            if (textView10 != null) {
                                                i = C5419R.id.connections;
                                                TextView textView11 = (TextView) view.findViewById(C5419R.id.connections);
                                                if (textView11 != null) {
                                                    i = C5419R.id.developer_options;
                                                    TextView textView12 = (TextView) view.findViewById(C5419R.id.developer_options);
                                                    if (textView12 != null) {
                                                        i = C5419R.id.developer_options_divider;
                                                        View viewFindViewById = view.findViewById(C5419R.id.developer_options_divider);
                                                        if (viewFindViewById != null) {
                                                            i = C5419R.id.developer_options_header;
                                                            TextView textView13 = (TextView) view.findViewById(C5419R.id.developer_options_header);
                                                            if (textView13 != null) {
                                                                i = C5419R.id.language;
                                                                TextView textView14 = (TextView) view.findViewById(C5419R.id.language);
                                                                if (textView14 != null) {
                                                                    i = C5419R.id.nitro_boosting;
                                                                    TextView textView15 = (TextView) view.findViewById(C5419R.id.nitro_boosting);
                                                                    if (textView15 != null) {
                                                                        i = C5419R.id.nitro_gifting;
                                                                        TextView textView16 = (TextView) view.findViewById(C5419R.id.nitro_gifting);
                                                                        if (textView16 != null) {
                                                                            i = C5419R.id.nitroGiftingBadge;
                                                                            TextView textView17 = (TextView) view.findViewById(C5419R.id.nitroGiftingBadge);
                                                                            if (textView17 != null) {
                                                                                i = C5419R.id.nitroGiftingContainer;
                                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.nitroGiftingContainer);
                                                                                if (linearLayout != null) {
                                                                                    i = C5419R.id.nitro_header;
                                                                                    TextView textView18 = (TextView) view.findViewById(C5419R.id.nitro_header);
                                                                                    if (textView18 != null) {
                                                                                        i = C5419R.id.nitro_settings_container;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.nitro_settings_container);
                                                                                        if (linearLayout2 != null) {
                                                                                            i = C5419R.id.notification_upsell;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(C5419R.id.notification_upsell);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = C5419R.id.notification_upsell_dismiss;
                                                                                                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.notification_upsell_dismiss);
                                                                                                if (appCompatImageView != null) {
                                                                                                    i = C5419R.id.notification_upsell_enable;
                                                                                                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.notification_upsell_enable);
                                                                                                    if (materialButton != null) {
                                                                                                        i = C5419R.id.notifications;
                                                                                                        TextView textView19 = (TextView) view.findViewById(C5419R.id.notifications);
                                                                                                        if (textView19 != null) {
                                                                                                            i = C5419R.id.privacy;
                                                                                                            TextView textView20 = (TextView) view.findViewById(C5419R.id.privacy);
                                                                                                            if (textView20 != null) {
                                                                                                                i = C5419R.id.profile;
                                                                                                                TextView textView21 = (TextView) view.findViewById(C5419R.id.profile);
                                                                                                                if (textView21 != null) {
                                                                                                                    i = C5419R.id.qr_scanner;
                                                                                                                    TextView textView22 = (TextView) view.findViewById(C5419R.id.qr_scanner);
                                                                                                                    if (textView22 != null) {
                                                                                                                        i = C5419R.id.role_subscriptions;
                                                                                                                        TextView textView23 = (TextView) view.findViewById(C5419R.id.role_subscriptions);
                                                                                                                        if (textView23 != null) {
                                                                                                                            i = C5419R.id.set_status_container;
                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(C5419R.id.set_status_container);
                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                i = C5419R.id.settings_billing;
                                                                                                                                TextView textView24 = (TextView) view.findViewById(C5419R.id.settings_billing);
                                                                                                                                if (textView24 != null) {
                                                                                                                                    i = C5419R.id.settings_nitro;
                                                                                                                                    TextView textView25 = (TextView) view.findViewById(C5419R.id.settings_nitro);
                                                                                                                                    if (textView25 != null) {
                                                                                                                                        i = C5419R.id.settings_presence_text;
                                                                                                                                        TextView textView26 = (TextView) view.findViewById(C5419R.id.settings_presence_text);
                                                                                                                                        if (textView26 != null) {
                                                                                                                                            i = C5419R.id.settings_status_view;
                                                                                                                                            StatusView statusView = (StatusView) view.findViewById(C5419R.id.settings_status_view);
                                                                                                                                            if (statusView != null) {
                                                                                                                                                i = C5419R.id.support;
                                                                                                                                                TextView textView27 = (TextView) view.findViewById(C5419R.id.support);
                                                                                                                                                if (textView27 != null) {
                                                                                                                                                    i = C5419R.id.text_images_settings;
                                                                                                                                                    TextView textView28 = (TextView) view.findViewById(C5419R.id.text_images_settings);
                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                        i = C5419R.id.upload_debug_logs;
                                                                                                                                                        TextView textView29 = (TextView) view.findViewById(C5419R.id.upload_debug_logs);
                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                            i = C5419R.id.user_settings_header;
                                                                                                                                                            TextView textView30 = (TextView) view.findViewById(C5419R.id.user_settings_header);
                                                                                                                                                            if (textView30 != null) {
                                                                                                                                                                i = C5419R.id.user_settings_profile_header_view;
                                                                                                                                                                UserProfileHeaderView userProfileHeaderView = (UserProfileHeaderView) view.findViewById(C5419R.id.user_settings_profile_header_view);
                                                                                                                                                                if (userProfileHeaderView != null) {
                                                                                                                                                                    i = C5419R.id.voice;
                                                                                                                                                                    TextView textView31 = (TextView) view.findViewById(C5419R.id.voice);
                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                        return new WidgetSettingsBinding((CoordinatorLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, viewFindViewById, textView13, textView14, textView15, textView16, textView17, linearLayout, textView18, linearLayout2, linearLayout3, appCompatImageView, materialButton, textView19, textView20, textView21, textView22, textView23, linearLayout4, textView24, textView25, textView26, statusView, textView27, textView28, textView29, textView30, userProfileHeaderView, textView31);
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
