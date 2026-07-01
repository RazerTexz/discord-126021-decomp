package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.t.n;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior extends AppFragment {
    private static final String API_LINK = "https://discord.com/developers/docs/intro";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsBehavior.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0)};
    public static final WidgetSettingsBehavior$Companion Companion = new WidgetSettingsBehavior$Companion(null);

    public WidgetSettingsBehavior() {
        super(R$layout.widget_settings_behavior);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsBehavior$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsBehaviorBinding getBinding() {
        return (WidgetSettingsBehaviorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131889200);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
        CheckedSetting checkedSetting = getBinding().f;
        checkedSetting.setChecked(userSettings.getIsShiftEnterToSendEnabled());
        checkedSetting.setOnCheckedListener(new WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$1(userSettings));
        CheckedSetting checkedSetting2 = getBinding().d;
        checkedSetting2.setChecked(userSettings.getIsDeveloperMode());
        Context context = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context, "context");
        b.h(context, 2131888435, new Object[]{API_LINK}, null, 4);
        Context context2 = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.h(b.h(context2, 2131888435, new Object[]{API_LINK}, null, 4), false);
        checkedSetting2.setSubtextOnClickListener(new WidgetSettingsBehavior$onViewBound$2$1(checkedSetting2));
        checkedSetting2.setOnCheckedListener(new WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$2(this, userSettings));
        CheckedSetting checkedSetting3 = getBinding().f2605b;
        checkedSetting3.setChecked(userSettings.getIsChromeCustomTabsEnabled());
        checkedSetting3.setOnCheckedListener(new WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$3(userSettings));
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().e, getBinding().c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
