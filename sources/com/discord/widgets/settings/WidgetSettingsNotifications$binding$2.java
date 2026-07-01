package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotifications$binding$2 extends k implements Function1<View, WidgetSettingsNotificationsBinding> {
    public static final WidgetSettingsNotifications$binding$2 INSTANCE = new WidgetSettingsNotifications$binding$2();

    public WidgetSettingsNotifications$binding$2() {
        super(1, WidgetSettingsNotificationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsNotificationsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsNotificationsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = R$id.settings_notifications_blink;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.settings_notifications_blink);
            if (checkedSetting2 != null) {
                i = R$id.settings_notifications_enabled;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.settings_notifications_enabled);
                if (checkedSetting3 != null) {
                    i = R$id.settings_notifications_mute_all;
                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R$id.settings_notifications_mute_all);
                    if (checkedSetting4 != null) {
                        i = R$id.settings_notifications_vibrations;
                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R$id.settings_notifications_vibrations);
                        if (checkedSetting5 != null) {
                            i = R$id.settings_notifications_wrap;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.settings_notifications_wrap);
                            if (linearLayout != null) {
                                return new WidgetSettingsNotificationsBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
