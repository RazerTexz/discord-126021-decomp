package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsMediaBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsMediaBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PREVIEW_MAX_SIZE_MB = "10";
    private StoreAccessibility accessibilitySettings;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private StoreUserSettings userSettings;

    /* JADX INFO: compiled from: WidgetSettingsMedia.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsMedia.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsMedia.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsMedia.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                MultiValuePropPremiumUpsellDialog.Companion companion = MultiValuePropPremiumUpsellDialog.INSTANCE;
                FragmentManager childFragmentManager = WidgetSettingsMedia.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                MultiValuePropPremiumUpsellDialog.Companion.a(companion, childFragmentManager, 3, null, null, null, "Image Compression Settings", null, null, false, false, 988);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("getNitro", new AnonymousClass1());
        }
    }

    public WidgetSettingsMedia() {
        super(R.layout.widget_settings_media);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsMedia2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ StoreUserSettings access$getUserSettings$p(WidgetSettingsMedia widgetSettingsMedia) {
        StoreUserSettings storeUserSettings = widgetSettingsMedia.userSettings;
        if (storeUserSettings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        return storeUserSettings;
    }

    private final WidgetSettingsMediaBinding getBinding() {
        return (WidgetSettingsMediaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.text_and_images);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        this.userSettings = companion.getUserSettings();
        this.accessibilitySettings = companion.getAccessibility();
        CheckedSetting checkedSetting = getBinding().f2630b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.attachmentsToggle");
        StoreUserSettings storeUserSettings = this.userSettings;
        if (storeUserSettings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting.setChecked(storeUserSettings.getIsAttachmentMediaInline());
        CheckedSetting.i(getBinding().f2630b, FormatUtils.e(this, R.string.inline_attachment_media_help, new Object[]{PREVIEW_MAX_SIZE_MB}, (4 & 4) != 0 ? FormatUtils.a.j : null), false, 2);
        getBinding().f2630b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsAttachmentMediaInline(appActivity, bool.booleanValue());
            }
        });
        getBinding().c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsAutoImageCompressionEnabled(bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.compressionToggle");
        StoreUserSettings storeUserSettings2 = this.userSettings;
        if (storeUserSettings2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting2.setChecked(storeUserSettings2.getIsAutoImageCompressionEnabled());
        LinkifiedTextView linkifiedTextView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.compressionToggleSubtext");
        FormatUtils.m(linkifiedTextView, R.string.image_compression_nitro_upsell, new Object[]{"getNitro"}, new AnonymousClass3());
        CheckedSetting checkedSetting3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsTextImagesEmbedsToggle");
        StoreUserSettings storeUserSettings3 = this.userSettings;
        if (storeUserSettings3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting3.setChecked(storeUserSettings3.getIsEmbedMediaInlined());
        getBinding().g.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.4
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsEmbedMediaInlined(appActivity, bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting4 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsTextImagesLinksToggle");
        StoreUserSettings storeUserSettings4 = this.userSettings;
        if (storeUserSettings4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting4.setChecked(storeUserSettings4.getIsRenderEmbedsEnabled());
        getBinding().h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.5
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsRenderEmbedsEnabled(appActivity, bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting5 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsTextImagesSyncToggle");
        StoreUserSettings storeUserSettings5 = this.userSettings;
        if (storeUserSettings5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting5.setChecked(storeUserSettings5.getIsSyncTextAndImagesEnabled());
        getBinding().l.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.6
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.getIsSyncTextAndImagesEnabled(bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting6 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.stickersSuggestions");
        StoreUserSettings storeUserSettings6 = this.userSettings;
        if (storeUserSettings6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting6.setChecked(storeUserSettings6.getIsStickerSuggestionsEnabled());
        getBinding().m.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.7
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                analyticsTracker.stickerSuggestionsEnabledToggled(bool.booleanValue(), new Traits.Location(null, Traits.Location.Section.SETTINGS_TEXT_AND_IMAGES, null, null, null, 29, null));
                WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this).setIsStickerSuggestionsEnabled(bool.booleanValue());
            }
        });
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f, getBinding().j, getBinding().e, getBinding().i, getBinding().k})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
