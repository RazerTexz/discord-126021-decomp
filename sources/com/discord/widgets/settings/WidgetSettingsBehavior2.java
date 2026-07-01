package com.discord.widgets.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBehavior2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsBehaviorBinding> {
    public static final WidgetSettingsBehavior2 INSTANCE = new WidgetSettingsBehavior2();

    public WidgetSettingsBehavior2() {
        super(1, WidgetSettingsBehaviorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsBehaviorBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_behavior_browser_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_behavior_browser_switch);
        if (checkedSetting != null) {
            i = R.id.settings_behavior_chat_header;
            TextView textView = (TextView) view.findViewById(R.id.settings_behavior_chat_header);
            if (textView != null) {
                i = R.id.settings_behavior_dev_mode_switch;
                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_behavior_dev_mode_switch);
                if (checkedSetting2 != null) {
                    i = R.id.settings_behavior_keyboard_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.settings_behavior_keyboard_header);
                    if (textView2 != null) {
                        i = R.id.settings_behavior_shift_send_toggle;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.settings_behavior_shift_send_toggle);
                        if (checkedSetting3 != null) {
                            return new WidgetSettingsBehaviorBinding((CoordinatorLayout) view, checkedSetting, textView, checkedSetting2, textView2, checkedSetting3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
