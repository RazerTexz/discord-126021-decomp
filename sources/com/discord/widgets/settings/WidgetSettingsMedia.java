package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsMediaBinding;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.t.n;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsMediaBinding;", 0)};
    public static final WidgetSettingsMedia$Companion Companion = new WidgetSettingsMedia$Companion(null);
    private static final String PREVIEW_MAX_SIZE_MB = "10";
    private StoreAccessibility accessibilitySettings;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private StoreUserSettings userSettings;

    public WidgetSettingsMedia() {
        super(R$layout.widget_settings_media);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsMedia$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ StoreUserSettings access$getUserSettings$p(WidgetSettingsMedia widgetSettingsMedia) {
        StoreUserSettings storeUserSettings = widgetSettingsMedia.userSettings;
        if (storeUserSettings == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        return storeUserSettings;
    }

    public static final /* synthetic */ void access$setUserSettings$p(WidgetSettingsMedia widgetSettingsMedia, StoreUserSettings storeUserSettings) {
        widgetSettingsMedia.userSettings = storeUserSettings;
    }

    private final WidgetSettingsMediaBinding getBinding() {
        return (WidgetSettingsMediaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131896300);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        this.userSettings = storeStream$Companion.getUserSettings();
        this.accessibilitySettings = storeStream$Companion.getAccessibility();
        CheckedSetting checkedSetting = getBinding().f2630b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.attachmentsToggle");
        StoreUserSettings storeUserSettings = this.userSettings;
        if (storeUserSettings == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting.setChecked(storeUserSettings.getIsAttachmentMediaInline());
        CheckedSetting.i(getBinding().f2630b, b.k(this, 2131892040, new Object[]{PREVIEW_MAX_SIZE_MB}, null, 4), false, 2);
        getBinding().f2630b.setOnCheckedListener(new WidgetSettingsMedia$onViewBound$1(this));
        getBinding().c.setOnCheckedListener(new WidgetSettingsMedia$onViewBound$2(this));
        CheckedSetting checkedSetting2 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.compressionToggle");
        StoreUserSettings storeUserSettings2 = this.userSettings;
        if (storeUserSettings2 == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting2.setChecked(storeUserSettings2.getIsAutoImageCompressionEnabled());
        LinkifiedTextView linkifiedTextView = getBinding().d;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.compressionToggleSubtext");
        b.m(linkifiedTextView, 2131892005, new Object[]{"getNitro"}, new WidgetSettingsMedia$onViewBound$3(this));
        CheckedSetting checkedSetting3 = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsTextImagesEmbedsToggle");
        StoreUserSettings storeUserSettings3 = this.userSettings;
        if (storeUserSettings3 == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting3.setChecked(storeUserSettings3.getIsEmbedMediaInlined());
        getBinding().g.setOnCheckedListener(new WidgetSettingsMedia$onViewBound$4(this));
        CheckedSetting checkedSetting4 = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsTextImagesLinksToggle");
        StoreUserSettings storeUserSettings4 = this.userSettings;
        if (storeUserSettings4 == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting4.setChecked(storeUserSettings4.getIsRenderEmbedsEnabled());
        getBinding().h.setOnCheckedListener(new WidgetSettingsMedia$onViewBound$5(this));
        CheckedSetting checkedSetting5 = getBinding().l;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsTextImagesSyncToggle");
        StoreUserSettings storeUserSettings5 = this.userSettings;
        if (storeUserSettings5 == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting5.setChecked(storeUserSettings5.getIsSyncTextAndImagesEnabled());
        getBinding().l.setOnCheckedListener(new WidgetSettingsMedia$onViewBound$6(this));
        CheckedSetting checkedSetting6 = getBinding().m;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.stickersSuggestions");
        StoreUserSettings storeUserSettings6 = this.userSettings;
        if (storeUserSettings6 == null) {
            m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting6.setChecked(storeUserSettings6.getIsStickerSuggestionsEnabled());
        getBinding().m.setOnCheckedListener(new WidgetSettingsMedia$onViewBound$7(this));
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().f, getBinding().j, getBinding().e, getBinding().i, getBinding().k})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
