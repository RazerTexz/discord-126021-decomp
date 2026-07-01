package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotificationsOs$binding$2 extends k implements Function1<View, WidgetSettingsNotificationOsBinding> {
    public static final WidgetSettingsNotificationsOs$binding$2 INSTANCE = new WidgetSettingsNotificationsOs$binding$2();

    public WidgetSettingsNotificationsOs$binding$2() {
        super(1, WidgetSettingsNotificationOsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsNotificationOsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsNotificationOsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = R$id.settings_notification_os;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.settings_notification_os);
            if (relativeLayout != null) {
                i = R$id.settings_notification_os_label;
                TextView textView = (TextView) view.findViewById(R$id.settings_notification_os_label);
                if (textView != null) {
                    i = R$id.settings_notification_switch;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.settings_notification_switch);
                    if (checkedSetting2 != null) {
                        return new WidgetSettingsNotificationOsBinding((LinearLayout) view, checkedSetting, relativeLayout, textView, checkedSetting2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
