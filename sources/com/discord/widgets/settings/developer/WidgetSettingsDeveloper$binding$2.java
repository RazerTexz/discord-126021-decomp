package com.discord.widgets.settings.developer;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsDeveloper$binding$2 extends C12236k implements Function1<View, WidgetSettingsDeveloperBinding> {
    public static final WidgetSettingsDeveloper$binding$2 INSTANCE = new WidgetSettingsDeveloper$binding$2();

    public WidgetSettingsDeveloper$binding$2() {
        super(1, WidgetSettingsDeveloperBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsDeveloperBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.developer_settings_crash_discord_jnibridge;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.developer_settings_crash_discord_jnibridge);
        if (materialButton != null) {
            i = C5419R.id.developer_settings_crash_discord_nonfatal;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.developer_settings_crash_discord_nonfatal);
            if (materialButton2 != null) {
                i = C5419R.id.developer_settings_crash_kotlin;
                MaterialButton materialButton3 = (MaterialButton) view.findViewById(C5419R.id.developer_settings_crash_kotlin);
                if (materialButton3 != null) {
                    i = C5419R.id.developer_settings_experiments;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.developer_settings_experiments);
                    if (recyclerView != null) {
                        i = C5419R.id.developer_settings_notices;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.developer_settings_notices);
                        if (recyclerView2 != null) {
                            i = C5419R.id.developer_settings_simulate_gateway_reconnect;
                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(C5419R.id.developer_settings_simulate_gateway_reconnect);
                            if (materialButton4 != null) {
                                i = C5419R.id.settings_developer_screenshot_bug_reporting;
                                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.settings_developer_screenshot_bug_reporting);
                                if (checkedSetting != null) {
                                    i = C5419R.id.textView;
                                    TextView textView = (TextView) view.findViewById(C5419R.id.textView);
                                    if (textView != null) {
                                        return new WidgetSettingsDeveloperBinding((CoordinatorLayout) view, materialButton, materialButton2, materialButton3, recyclerView, recyclerView2, materialButton4, checkedSetting, textView);
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
