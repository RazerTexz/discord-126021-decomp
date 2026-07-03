package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
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
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.C0811c;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsMediaBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsMedia.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetSettingsMedia.kt */
    public static final class C96483 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsMedia.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                C0811c.Companion companion = C0811c.INSTANCE;
                FragmentManager childFragmentManager = WidgetSettingsMedia.this.getChildFragmentManager();
                C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                C0811c.Companion.m114a(companion, childFragmentManager, 3, null, null, null, "Image Compression Settings", null, null, false, false, 988);
            }
        }

        public C96483() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("getNitro", new AnonymousClass1());
        }
    }

    public WidgetSettingsMedia() {
        super(C5419R.layout.widget_settings_media);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsMedia$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ StoreUserSettings access$getUserSettings$p(WidgetSettingsMedia widgetSettingsMedia) {
        StoreUserSettings storeUserSettings = widgetSettingsMedia.userSettings;
        if (storeUserSettings == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.text_and_images);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        this.userSettings = companion.getUserSettings();
        this.accessibilitySettings = companion.getAccessibility();
        CheckedSetting checkedSetting = getBinding().f18006b;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.attachmentsToggle");
        StoreUserSettings storeUserSettings = this.userSettings;
        if (storeUserSettings == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting.setChecked(storeUserSettings.getIsAttachmentMediaInline());
        CheckedSetting.m8524i(getBinding().f18006b, C1107b.m213e(this, C5419R.string.inline_attachment_media_help, new Object[]{PREVIEW_MAX_SIZE_MB}, (4 & 4) != 0 ? C1107b.a.f1490j : null), false, 2);
        getBinding().f18006b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
                C12238m.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsAttachmentMediaInline(appActivity, bool.booleanValue());
            }
        });
        getBinding().f18007c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                C12238m.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsAutoImageCompressionEnabled(bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting2 = getBinding().f18007c;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.compressionToggle");
        StoreUserSettings storeUserSettings2 = this.userSettings;
        if (storeUserSettings2 == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting2.setChecked(storeUserSettings2.getIsAutoImageCompressionEnabled());
        LinkifiedTextView linkifiedTextView = getBinding().f18008d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.compressionToggleSubtext");
        C1107b.m221m(linkifiedTextView, C5419R.string.image_compression_nitro_upsell, new Object[]{"getNitro"}, new C96483());
        CheckedSetting checkedSetting3 = getBinding().f18011g;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsTextImagesEmbedsToggle");
        StoreUserSettings storeUserSettings3 = this.userSettings;
        if (storeUserSettings3 == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting3.setChecked(storeUserSettings3.getIsEmbedMediaInlined());
        getBinding().f18011g.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.4
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
                C12238m.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsEmbedMediaInlined(appActivity, bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting4 = getBinding().f18012h;
        C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsTextImagesLinksToggle");
        StoreUserSettings storeUserSettings4 = this.userSettings;
        if (storeUserSettings4 == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting4.setChecked(storeUserSettings4.getIsRenderEmbedsEnabled());
        getBinding().f18012h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.5
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
                C12238m.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.setIsRenderEmbedsEnabled(appActivity, bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting5 = getBinding().f18016l;
        C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsTextImagesSyncToggle");
        StoreUserSettings storeUserSettings5 = this.userSettings;
        if (storeUserSettings5 == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting5.setChecked(storeUserSettings5.getIsSyncTextAndImagesEnabled());
        getBinding().f18016l.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.6
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
                C12238m.checkNotNullExpressionValue(bool, "checked");
                storeUserSettingsAccess$getUserSettings$p.getIsSyncTextAndImagesEnabled(bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting6 = getBinding().f18017m;
        C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.stickersSuggestions");
        StoreUserSettings storeUserSettings6 = this.userSettings;
        if (storeUserSettings6 == null) {
            C12238m.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting6.setChecked(storeUserSettings6.getIsStickerSuggestionsEnabled());
        getBinding().f18017m.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsMedia.onViewBound.7
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                C12238m.checkNotNullExpressionValue(bool, "checked");
                analyticsTracker.stickerSuggestionsEnabledToggled(bool.booleanValue(), new Traits.Location(null, Traits.Location.Section.SETTINGS_TEXT_AND_IMAGES, null, null, null, 29, null));
                WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this).setIsStickerSuggestionsEnabled(bool.booleanValue());
            }
        });
        for (TextView textView : C12147n.listOf((Object[]) new TextView[]{getBinding().f18010f, getBinding().f18014j, getBinding().f18009e, getBinding().f18013i, getBinding().f18015k})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
