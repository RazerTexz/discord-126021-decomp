package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetChannelNotificationSettingsBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelNotificationSettings4 extends FunctionReferenceImpl implements Function1<View, WidgetChannelNotificationSettingsBinding> {
    public static final WidgetChannelNotificationSettings4 INSTANCE = new WidgetChannelNotificationSettings4();

    public WidgetChannelNotificationSettings4() {
        super(1, WidgetChannelNotificationSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelNotificationSettingsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_notification_settings_system;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channel_notification_settings_system);
        if (linearLayout != null) {
            i = R.id.channel_settings_notifications_frequency_wrap;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.channel_settings_notifications_frequency_wrap);
            if (linearLayout2 != null) {
                i = R.id.forum_channel_notification_settings;
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.forum_channel_notification_settings);
                if (linearLayout3 != null) {
                    i = R.id.frequency_all_posts;
                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.frequency_all_posts);
                    if (checkedSetting != null) {
                        i = R.id.frequency_header;
                        TextView textView = (TextView) view.findViewById(R.id.frequency_header);
                        if (textView != null) {
                            i = R.id.frequency_radio_all;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.frequency_radio_all);
                            if (checkedSetting2 != null) {
                                i = R.id.frequency_radio_mentions;
                                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.frequency_radio_mentions);
                                if (checkedSetting3 != null) {
                                    i = R.id.frequency_radio_nothing;
                                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.frequency_radio_nothing);
                                    if (checkedSetting4 != null) {
                                        i = R.id.frequency_subheader;
                                        TextView textView2 = (TextView) view.findViewById(R.id.frequency_subheader);
                                        if (textView2 != null) {
                                            i = R.id.frequency_top_divider;
                                            View viewFindViewById = view.findViewById(R.id.frequency_top_divider);
                                            if (viewFindViewById != null) {
                                                i = R.id.mute_settings;
                                                NotificationMuteSettingsView notificationMuteSettingsView = (NotificationMuteSettingsView) view.findViewById(R.id.mute_settings);
                                                if (notificationMuteSettingsView != null) {
                                                    i = R.id.scroll_view;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
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
