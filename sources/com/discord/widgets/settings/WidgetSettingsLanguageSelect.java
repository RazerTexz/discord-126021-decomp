package com.discord.widgets.settings;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsLanguageSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0)};
    public static final WidgetSettingsLanguageSelect$Companion Companion = new WidgetSettingsLanguageSelect$Companion(null);
    private static final String REQUEST_KEY_USER_LOCALE = "REQUEST_KEY_USER_LOCALE";
    private static final String RESULT_KEY_USE_LOCALE = "INTENT_EXTRA_LOCALE";
    private WidgetSettingsLanguageSelect$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsLanguageSelect() {
        super(R$layout.widget_settings_language_select);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsLanguageSelect$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$onLocaleSelected(WidgetSettingsLanguageSelect widgetSettingsLanguageSelect, String str) {
        widgetSettingsLanguageSelect.onLocaleSelected(str);
    }

    private final WidgetSettingsLanguageSelectBinding getBinding() {
        return (WidgetSettingsLanguageSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onLocaleSelected(String locale) {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_KEY_USE_LOCALE, locale);
        FragmentKt.setFragmentResult(this, REQUEST_KEY_USER_LOCALE, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f2628b;
        m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.settingsLanguageSelectList");
        WidgetSettingsLanguageSelect$Adapter widgetSettingsLanguageSelect$Adapter = (WidgetSettingsLanguageSelect$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsLanguageSelect$Adapter(maxHeightRecyclerView, this));
        this.adapter = widgetSettingsLanguageSelect$Adapter;
        if (widgetSettingsLanguageSelect$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsLanguageSelect$Adapter.setData(WidgetSettingsLanguageSelect$Model.INSTANCE.getLocales());
    }
}
