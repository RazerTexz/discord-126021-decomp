package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsActivityStatus$binding$2 extends k implements Function1<View, WidgetSettingsActivityStatusBinding> {
    public static final WidgetSettingsActivityStatus$binding$2 INSTANCE = new WidgetSettingsActivityStatus$binding$2();

    public WidgetSettingsActivityStatus$binding$2() {
        super(1, WidgetSettingsActivityStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsActivityStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsActivityStatusBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.show_current_activity);
        if (checkedSetting != null) {
            return new WidgetSettingsActivityStatusBinding((CoordinatorLayout) view, checkedSetting);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.show_current_activity)));
    }
}
