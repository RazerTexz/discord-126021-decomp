package com.discord.widgets.settings.developer;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsDeveloper2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsDeveloperBinding> {
    public static final WidgetSettingsDeveloper2 INSTANCE = new WidgetSettingsDeveloper2();

    public WidgetSettingsDeveloper2() {
        super(1, WidgetSettingsDeveloperBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsDeveloperBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.developer_settings_crash_discord_jnibridge;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.developer_settings_crash_discord_jnibridge);
        if (materialButton != null) {
            i = R.id.developer_settings_crash_discord_nonfatal;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.developer_settings_crash_discord_nonfatal);
            if (materialButton2 != null) {
                i = R.id.developer_settings_crash_kotlin;
                MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.developer_settings_crash_kotlin);
                if (materialButton3 != null) {
                    i = R.id.developer_settings_experiments;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.developer_settings_experiments);
                    if (recyclerView != null) {
                        i = R.id.developer_settings_notices;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.developer_settings_notices);
                        if (recyclerView2 != null) {
                            i = R.id.developer_settings_simulate_gateway_reconnect;
                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.developer_settings_simulate_gateway_reconnect);
                            if (materialButton4 != null) {
                                i = R.id.settings_developer_screenshot_bug_reporting;
                                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_developer_screenshot_bug_reporting);
                                if (checkedSetting != null) {
                                    i = R.id.textView;
                                    TextView textView = (TextView) view.findViewById(R.id.textView);
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
