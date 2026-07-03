package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsActivityStatus$binding$2 extends C12236k implements Function1<View, WidgetSettingsActivityStatusBinding> {
    public static final WidgetSettingsActivityStatus$binding$2 INSTANCE = new WidgetSettingsActivityStatus$binding$2();

    public WidgetSettingsActivityStatus$binding$2() {
        super(1, WidgetSettingsActivityStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsActivityStatusBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.show_current_activity);
        if (checkedSetting != null) {
            return new WidgetSettingsActivityStatusBinding((CoordinatorLayout) view, checkedSetting);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.show_current_activity)));
    }
}
