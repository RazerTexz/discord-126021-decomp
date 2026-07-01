package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelNotificationSettingsBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelNotificationSettings$binding$2 extends k implements Function1<View, WidgetChannelNotificationSettingsBinding> {
    public static final WidgetChannelNotificationSettings$binding$2 INSTANCE = new WidgetChannelNotificationSettings$binding$2();

    public WidgetChannelNotificationSettings$binding$2() {
        super(1, WidgetChannelNotificationSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelNotificationSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelNotificationSettingsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.channel_notification_settings_system;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.channel_notification_settings_system);
        if (linearLayout != null) {
            i = R$id.channel_settings_notifications_frequency_wrap;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.channel_settings_notifications_frequency_wrap);
            if (linearLayout2 != null) {
                i = R$id.forum_channel_notification_settings;
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R$id.forum_channel_notification_settings);
                if (linearLayout3 != null) {
                    i = R$id.frequency_all_posts;
                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.frequency_all_posts);
                    if (checkedSetting != null) {
                        i = R$id.frequency_header;
                        TextView textView = (TextView) view.findViewById(R$id.frequency_header);
                        if (textView != null) {
                            i = R$id.frequency_radio_all;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.frequency_radio_all);
                            if (checkedSetting2 != null) {
                                i = R$id.frequency_radio_mentions;
                                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.frequency_radio_mentions);
                                if (checkedSetting3 != null) {
                                    i = R$id.frequency_radio_nothing;
                                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R$id.frequency_radio_nothing);
                                    if (checkedSetting4 != null) {
                                        i = R$id.frequency_subheader;
                                        TextView textView2 = (TextView) view.findViewById(R$id.frequency_subheader);
                                        if (textView2 != null) {
                                            i = R$id.frequency_top_divider;
                                            View viewFindViewById = view.findViewById(R$id.frequency_top_divider);
                                            if (viewFindViewById != null) {
                                                i = R$id.mute_settings;
                                                NotificationMuteSettingsView notificationMuteSettingsView = (NotificationMuteSettingsView) view.findViewById(R$id.mute_settings);
                                                if (notificationMuteSettingsView != null) {
                                                    i = R$id.scroll_view;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.scroll_view);
                                                    if (nestedScrollView != null) {
                                                        return new WidgetChannelNotificationSettingsBinding((CoordinatorLayout) view, linearLayout, linearLayout2, linearLayout3, checkedSetting, textView, checkedSetting2, checkedSetting3, checkedSetting4, textView2, viewFindViewById, notificationMuteSettingsView, nestedScrollView);
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
