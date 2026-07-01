package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotificationsOs2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsNotificationOsBinding> {
    public static final WidgetSettingsNotificationsOs2 INSTANCE = new WidgetSettingsNotificationsOs2();

    public WidgetSettingsNotificationsOs2() {
        super(1, WidgetSettingsNotificationOsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsNotificationOsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = R.id.settings_notification_os;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.settings_notification_os);
            if (relativeLayout != null) {
                i = R.id.settings_notification_os_label;
                TextView textView = (TextView) view.findViewById(R.id.settings_notification_os_label);
                if (textView != null) {
                    i = R.id.settings_notification_switch;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_notification_switch);
                    if (checkedSetting2 != null) {
                        return new WidgetSettingsNotificationOsBinding((LinearLayout) view, checkedSetting, relativeLayout, textView, checkedSetting2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
