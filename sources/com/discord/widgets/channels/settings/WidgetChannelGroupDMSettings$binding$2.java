package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelGroupDmSettingsBinding;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelGroupDMSettings$binding$2 extends C12236k implements Function1<View, WidgetChannelGroupDmSettingsBinding> {
    public static final WidgetChannelGroupDMSettings$binding$2 INSTANCE = new WidgetChannelGroupDMSettings$binding$2();

    public WidgetChannelGroupDMSettings$binding$2() {
        super(1, WidgetChannelGroupDmSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelGroupDmSettingsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_settings_edit_name;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.channel_settings_edit_name);
        if (textInputLayout != null) {
            i = C5419R.id.channel_settings_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.channel_settings_save);
            if (floatingActionButton != null) {
                i = C5419R.id.group_dm_notifications_mute_settings_view;
                NotificationMuteSettingsView notificationMuteSettingsView = (NotificationMuteSettingsView) view.findViewById(C5419R.id.group_dm_notifications_mute_settings_view);
                if (notificationMuteSettingsView != null) {
                    i = C5419R.id.group_dm_settings_scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.group_dm_settings_scroll_view);
                    if (nestedScrollView != null) {
                        i = C5419R.id.settings_group_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.settings_group_icon);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.settings_group_icon_label;
                            TextView textView = (TextView) view.findViewById(C5419R.id.settings_group_icon_label);
                            if (textView != null) {
                                i = C5419R.id.settings_group_icon_remove;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.settings_group_icon_remove);
                                if (textView2 != null) {
                                    return new WidgetChannelGroupDmSettingsBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton, notificationMuteSettingsView, nestedScrollView, simpleDraweeView, textView, textView2);
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
