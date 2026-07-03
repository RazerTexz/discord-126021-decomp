package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotificationsOs$binding$2 extends C12236k implements Function1<View, WidgetSettingsNotificationOsBinding> {
    public static final WidgetSettingsNotificationsOs$binding$2 INSTANCE = new WidgetSettingsNotificationsOs$binding$2();

    public WidgetSettingsNotificationsOs$binding$2() {
        super(1, WidgetSettingsNotificationOsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsNotificationOsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = C5419R.id.settings_notification_os;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.settings_notification_os);
            if (relativeLayout != null) {
                i = C5419R.id.settings_notification_os_label;
                TextView textView = (TextView) view.findViewById(C5419R.id.settings_notification_os_label);
                if (textView != null) {
                    i = C5419R.id.settings_notification_switch;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.settings_notification_switch);
                    if (checkedSetting2 != null) {
                        return new WidgetSettingsNotificationOsBinding((LinearLayout) view, checkedSetting, relativeLayout, textView, checkedSetting2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
