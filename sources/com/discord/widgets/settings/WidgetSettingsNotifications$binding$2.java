package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotifications$binding$2 extends C12236k implements Function1<View, WidgetSettingsNotificationsBinding> {
    public static final WidgetSettingsNotifications$binding$2 INSTANCE = new WidgetSettingsNotifications$binding$2();

    public WidgetSettingsNotifications$binding$2() {
        super(1, WidgetSettingsNotificationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsNotificationsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = C5419R.id.settings_notifications_blink;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.settings_notifications_blink);
            if (checkedSetting2 != null) {
                i = C5419R.id.settings_notifications_enabled;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.settings_notifications_enabled);
                if (checkedSetting3 != null) {
                    i = C5419R.id.settings_notifications_mute_all;
                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(C5419R.id.settings_notifications_mute_all);
                    if (checkedSetting4 != null) {
                        i = C5419R.id.settings_notifications_vibrations;
                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(C5419R.id.settings_notifications_vibrations);
                        if (checkedSetting5 != null) {
                            i = C5419R.id.settings_notifications_wrap;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.settings_notifications_wrap);
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
