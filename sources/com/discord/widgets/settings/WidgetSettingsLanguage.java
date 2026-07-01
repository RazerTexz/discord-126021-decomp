package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsLanguage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0)};
    public static final WidgetSettingsLanguage$Companion Companion = new WidgetSettingsLanguage$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsLanguage() {
        super(R$layout.widget_settings_language);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsLanguage$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsLanguage widgetSettingsLanguage, String str) {
        widgetSettingsLanguage.configureUI(str);
    }

    private final void configureUI(String locale) {
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.settingsLanguageCurrentText");
        WidgetSettingsLanguage$Companion widgetSettingsLanguage$Companion = Companion;
        textView.setText(getString(widgetSettingsLanguage$Companion.getLocaleResId(locale)));
        getBinding().c.setImageResource(widgetSettingsLanguage$Companion.getLocaleFlagResId(locale));
    }

    private final WidgetSettingsLanguageBinding getBinding() {
        return (WidgetSettingsLanguageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131892508);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        WidgetSettingsLanguageSelect.Companion.registerForResult(this, new WidgetSettingsLanguage$onViewBound$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeStream$Companion.getUserSettingsSystem().observeSettings(false), this, null, 2, null), WidgetSettingsLanguage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsLanguage$onViewBoundOrOnResume$1(this), 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsLanguageSyncCheck");
        checkedSetting.setChecked(storeStream$Companion.getUserSettingsSystem().getIsLocaleSyncEnabled());
        getBinding().f.setOnCheckedListener(WidgetSettingsLanguage$onViewBoundOrOnResume$2.INSTANCE);
        getBinding().f2627b.setOnClickListener(new WidgetSettingsLanguage$onViewBoundOrOnResume$3(this));
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().e, getBinding().g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
