package com.discord.widgets.servers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.z1;
import com.discord.R$id;
import com.discord.databinding.WidgetServerNotificationsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerNotifications$binding$2 extends k implements Function1<View, WidgetServerNotificationsBinding> {
    public static final WidgetServerNotifications$binding$2 INSTANCE = new WidgetServerNotifications$binding$2();

    public WidgetServerNotifications$binding$2() {
        super(1, WidgetServerNotificationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerNotificationsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerNotificationsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.add_override;
        View viewFindViewById = view.findViewById(R$id.add_override);
        if (viewFindViewById != null) {
            int i2 = R$id.category_overview_name;
            TextView textView = (TextView) viewFindViewById.findViewById(R$id.category_overview_name);
            if (textView != null) {
                i2 = 2131363590;
                Guideline guideline = (Guideline) viewFindViewById.findViewById(2131363590);
                if (guideline != null) {
                    i2 = R$id.navigation_indicator;
                    ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.navigation_indicator);
                    if (imageView != null) {
                        z1 z1Var = new z1((ConstraintLayout) viewFindViewById, textView, guideline, imageView);
                        i = R$id.guild_notifications_override_list;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.guild_notifications_override_list);
                        if (recyclerView != null) {
                            i = R$id.server_notifications_everyone_switch;
                            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.server_notifications_everyone_switch);
                            if (checkedSetting != null) {
                                i = R$id.server_notifications_frequency_0_radio;
                                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.server_notifications_frequency_0_radio);
                                if (checkedSetting2 != null) {
                                    i = R$id.server_notifications_frequency_1_radio;
                                    CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.server_notifications_frequency_1_radio);
                                    if (checkedSetting3 != null) {
                                        i = R$id.server_notifications_frequency_2_radio;
                                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R$id.server_notifications_frequency_2_radio);
                                        if (checkedSetting4 != null) {
                                            i = R$id.server_notifications_frequency_divider;
                                            View viewFindViewById2 = view.findViewById(R$id.server_notifications_frequency_divider);
                                            if (viewFindViewById2 != null) {
                                                i = R$id.server_notifications_frequency_wrap;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.server_notifications_frequency_wrap);
                                                if (linearLayout != null) {
                                                    i = R$id.server_notifications_highlights;
                                                    NotificationHighlightsSettingsView notificationHighlightsSettingsView = (NotificationHighlightsSettingsView) view.findViewById(R$id.server_notifications_highlights);
                                                    if (notificationHighlightsSettingsView != null) {
                                                        i = R$id.server_notifications_highlights_divider;
                                                        View viewFindViewById3 = view.findViewById(R$id.server_notifications_highlights_divider);
                                                        if (viewFindViewById3 != null) {
                                                            i = R$id.server_notifications_mute_settings_view;
                                                            NotificationMuteSettingsView notificationMuteSettingsView = (NotificationMuteSettingsView) view.findViewById(R$id.server_notifications_mute_settings_view);
                                                            if (notificationMuteSettingsView != null) {
                                                                i = R$id.server_notifications_override_divider;
                                                                View viewFindViewById4 = view.findViewById(R$id.server_notifications_override_divider);
                                                                if (viewFindViewById4 != null) {
                                                                    i = R$id.server_notifications_override_title;
                                                                    TextView textView2 = (TextView) view.findViewById(R$id.server_notifications_override_title);
                                                                    if (textView2 != null) {
                                                                        i = R$id.server_notifications_push_switch;
                                                                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R$id.server_notifications_push_switch);
                                                                        if (checkedSetting5 != null) {
                                                                            i = R$id.server_notifications_roles_divider;
                                                                            View viewFindViewById5 = view.findViewById(R$id.server_notifications_roles_divider);
                                                                            if (viewFindViewById5 != null) {
                                                                                i = R$id.server_notifications_roles_switch;
                                                                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R$id.server_notifications_roles_switch);
                                                                                if (checkedSetting6 != null) {
                                                                                    return new WidgetServerNotificationsBinding((CoordinatorLayout) view, z1Var, recyclerView, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, viewFindViewById2, linearLayout, notificationHighlightsSettingsView, viewFindViewById3, notificationMuteSettingsView, viewFindViewById4, textView2, checkedSetting5, viewFindViewById5, checkedSetting6);
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
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
