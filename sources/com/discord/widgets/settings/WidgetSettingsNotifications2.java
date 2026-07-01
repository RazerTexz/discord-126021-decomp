package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotifications$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotifications2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsNotificationsBinding> {
    public static final WidgetSettingsNotifications2 INSTANCE = new WidgetSettingsNotifications2();

    public WidgetSettingsNotifications2() {
        super(1, WidgetSettingsNotificationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsNotificationsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = R.id.settings_notifications_blink;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_notifications_blink);
            if (checkedSetting2 != null) {
                i = R.id.settings_notifications_enabled;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.settings_notifications_enabled);
                if (checkedSetting3 != null) {
                    i = R.id.settings_notifications_mute_all;
                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.settings_notifications_mute_all);
                    if (checkedSetting4 != null) {
                        i = R.id.settings_notifications_vibrations;
                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.settings_notifications_vibrations);
                        if (checkedSetting5 != null) {
                            i = R.id.settings_notifications_wrap;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_notifications_wrap);
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
