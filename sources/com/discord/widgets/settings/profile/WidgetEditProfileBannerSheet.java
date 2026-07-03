package com.discord.widgets.settings.profile;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.C0812d;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p440k.p441a.p442a.InterfaceC5079f;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet extends AppBottomSheet {
    private static final String ARG_DEFAULT_BANNER_COLOR_HEX = "ARG_DEFAULT_BANNER_COLOR_HEX";
    private static final String ARG_HAS_BANNER_IMAGE = "ARG_HAS_BANNER_IMAGE";
    private static final String ARG_INITIAL_COLOR_PREVIEW_HEX = "ARG_INITIAL_COLOR_PREVIEW_HEX";
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ColorPickerDialog colorPickerDialog;
    private int defaultBannerColor;

    /* JADX INFO: renamed from: isGuildContext$delegate, reason: from kotlin metadata */
    private final Lazy isGuildContext;
    private Function0<Unit> onChangeProfileBannerImage;
    private Function1<? super Integer, Unit> onColorSelected;
    private Function0<Unit> onRemoveProfileBannerImage;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEditProfileBannerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Long guildId, String defaultBannerColorHex, String initialColorPreviewHex, boolean hasBannerImage, FragmentManager fragmentManager, Function0<Unit> onChangeProfileBannerImage, Function0<Unit> onRemoveProfileBannerImage, Function1<? super Integer, Unit> onColorSelected) {
            C12238m.checkNotNullParameter(defaultBannerColorHex, "defaultBannerColorHex");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(onChangeProfileBannerImage, "onChangeProfileBannerImage");
            C12238m.checkNotNullParameter(onRemoveProfileBannerImage, "onRemoveProfileBannerImage");
            C12238m.checkNotNullParameter(onColorSelected, "onColorSelected");
            WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = new WidgetEditProfileBannerSheet();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetEditProfileBannerSheet.ARG_DEFAULT_BANNER_COLOR_HEX, defaultBannerColorHex);
            bundle.putString(WidgetEditProfileBannerSheet.ARG_INITIAL_COLOR_PREVIEW_HEX, initialColorPreviewHex);
            bundle.putBoolean(WidgetEditProfileBannerSheet.ARG_HAS_BANNER_IMAGE, hasBannerImage);
            if (guildId != null) {
                bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            widgetEditProfileBannerSheet.setArguments(bundle);
            widgetEditProfileBannerSheet.setOnChangeProfileBannerImage(onChangeProfileBannerImage);
            widgetEditProfileBannerSheet.setOnRemoveProfileBannerImage(onRemoveProfileBannerImage);
            widgetEditProfileBannerSheet.setOnColorSelected(onColorSelected);
            widgetEditProfileBannerSheet.show(fragmentManager, WidgetEditProfileBannerSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$isGuildContext$2 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class C99632 extends AbstractC12240o implements Function0<Boolean> {
        public C99632() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetEditProfileBannerSheet.this.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID") > 0;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class C99651 extends AbstractC12240o implements Function1<EditProfileBannerSheetViewModel.ViewState, Unit> {
        public C99651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditProfileBannerSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetEditProfileBannerSheet.this.configureUi(viewState);
        }
    }

    public WidgetEditProfileBannerSheet() {
        super(false, 1, null);
        this.onChangeProfileBannerImage = WidgetEditProfileBannerSheet$onChangeProfileBannerImage$1.INSTANCE;
        this.onRemoveProfileBannerImage = WidgetEditProfileBannerSheet$onRemoveProfileBannerImage$1.INSTANCE;
        this.onColorSelected = WidgetEditProfileBannerSheet$onColorSelected$1.INSTANCE;
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEditProfileBannerSheet$binding$2.INSTANCE, null, 2, null);
        this.isGuildContext = C12083g.lazy(new C99632());
        WidgetEditProfileBannerSheet$viewModel$2 widgetEditProfileBannerSheet$viewModel$2 = new WidgetEditProfileBannerSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(EditProfileBannerSheetViewModel.class), new WidgetEditProfileBannerSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetEditProfileBannerSheet$viewModel$2));
    }

    private final void configureStringsForGuild() {
        MaterialTextView materialTextView = getBinding().f16494e;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.bannerColorItemTitle");
        materialTextView.setText(C1107b.m213e(this, C5419R.string.change_identity_profile_color, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        MaterialTextView materialTextView2 = getBinding().f16492c;
        C12238m.checkNotNullExpressionValue(materialTextView2, "binding.bannerChangeImageItemTitle");
        materialTextView2.setText(C1107b.m213e(this, C5419R.string.change_identity_profile_banner, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        MaterialTextView materialTextView3 = getBinding().f16496g;
        C12238m.checkNotNullExpressionValue(materialTextView3, "binding.bannerRemoveImageItem");
        materialTextView3.setText(C1107b.m213e(this, C5419R.string.change_identity_reset_banner, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Integer] */
    private final void configureUi(final EditProfileBannerSheetViewModel.ViewState viewState) {
        if (viewState instanceof EditProfileBannerSheetViewModel.ViewState) {
            String bannerColorHex = viewState.getBannerColorHex();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            if (isGuildContext()) {
                configureStringsForGuild();
            }
            if (bannerColorHex != null) {
                try {
                    ref$ObjectRef.element = Integer.valueOf(Color.parseColor(bannerColorHex));
                } catch (IllegalArgumentException e) {
                    Logger.e$default(AppLog.f14950g, C1643a.m883w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                }
            }
            if (((Integer) ref$ObjectRef.element) != null) {
                ImageView imageView = getBinding().f16495f;
                C12238m.checkNotNullExpressionValue(imageView, "binding.bannerColorPreview");
                ColorCompatKt.tintWithColor(imageView, ((Integer) ref$ObjectRef.element).intValue());
            }
            ImageView imageView2 = getBinding().f16495f;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.bannerColorPreview");
            imageView2.setVisibility(((Integer) ref$ObjectRef.element) == null ? 4 : 0);
            getBinding().f16493d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.configureUi.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = WidgetEditProfileBannerSheet.this;
                    Integer num = (Integer) ref$ObjectRef.element;
                    widgetEditProfileBannerSheet.launchColorPicker(num != null ? num.intValue() : widgetEditProfileBannerSheet.defaultBannerColor);
                }
            });
            MaterialButton materialButton = getBinding().f16497h;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellButton");
            materialButton.setVisibility(viewState.getShowPremiumUpsell() ? 0 : 8);
            MaterialButton materialButton2 = getBinding().f16497h;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellButton");
            if ((materialButton2.getVisibility() == 0) && !getViewModel().getUpsellViewedTracked()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.CustomProfileBannerUpsell, new Traits.Location(Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER, null, null, 24, null), null, null, 12, null);
                getViewModel().setUpsellViewedTracked(true);
            }
            getBinding().f16491b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.configureUi.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (viewState.getShowPremiumUpsell()) {
                        WidgetEditProfileBannerSheet.this.navigateToUpsellModal();
                    } else {
                        WidgetEditProfileBannerSheet.this.getOnChangeProfileBannerImage().invoke();
                        WidgetEditProfileBannerSheet.this.dismiss();
                    }
                }
            });
        }
        KotlinExtensionsKt.getExhaustive(Unit.f27425a);
    }

    private final WidgetEditProfileBannerSheetBinding getBinding() {
        return (WidgetEditProfileBannerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final EditProfileBannerSheetViewModel getViewModel() {
        return (EditProfileBannerSheetViewModel) this.viewModel.getValue();
    }

    private final boolean isGuildContext() {
        return ((Boolean) this.isGuildContext.getValue()).booleanValue();
    }

    private final void launchColorPicker(@ColorInt int initialColor) {
        ColorPickerDialog.C11163k c11163k = new ColorPickerDialog.C11163k();
        c11163k.f21754h = initialColor;
        c11163k.f21765s = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundPrimary);
        c11163k.f21755i = false;
        c11163k.f21756j = false;
        c11163k.f21752f = 0;
        c11163k.f21747a = C5419R.string.user_settings_banner_color_title;
        c11163k.f21764r = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        c11163k.f21770x = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_display_bold);
        c11163k.f21758l = true;
        c11163k.f21751e = C5419R.string.color_picker_use_default;
        c11163k.f21762p = ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand);
        c11163k.f21750d = C5419R.string.select;
        c11163k.f21769w = ColorCompat.getColor(getContext(), C5419R.color.white);
        c11163k.f21771y = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_semibold);
        c11163k.f21766t = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextMuted);
        c11163k.f21767u = C5419R.drawable.drawable_cpv_edit_text_background;
        c11163k.f21772z = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogM9275a = c11163k.m9275a();
        colorPickerDialogM9275a.f21719k = new InterfaceC5079f() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.launchColorPicker.1
            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onColorReset(int dialogId) {
                WidgetEditProfileBannerSheet.this.getViewModel().updateColorPreview(null);
                WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(null);
            }

            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onColorSelected(int dialogId, int selectedColor) {
                EditProfileBannerSheetViewModel viewModel = WidgetEditProfileBannerSheet.this.getViewModel();
                ColorCompat colorCompat = ColorCompat.INSTANCE;
                viewModel.updateColorPreview(colorCompat.getColorHexFromColorInt(selectedColor));
                WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(Integer.valueOf(colorCompat.removeAlphaComponent(selectedColor)));
            }

            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onDialogDismissed(int dialogId) {
            }
        };
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogM9275a.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
        this.colorPickerDialog = colorPickerDialogM9275a;
    }

    private final void navigateToUpsellModal() {
        C0812d.Companion companion = C0812d.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.CustomProfileUpsellModal;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        String string = C1107b.m211c(resources, C5419R.string.premium_profile_customization_upsell_header, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null).toString();
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        companion.m117a(parentFragmentManager, premiumUpsellType, C5419R.drawable.img_profile_banner_value_prop, string, C1107b.m211c(resources2, C5419R.string.premium_profile_customization_upsell_body, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null).toString(), Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_edit_profile_banner_sheet;
    }

    public final Function0<Unit> getOnChangeProfileBannerImage() {
        return this.onChangeProfileBannerImage;
    }

    public final Function1<Integer, Unit> getOnColorSelected() {
        return this.onColorSelected;
    }

    public final Function0<Unit> getOnRemoveProfileBannerImage() {
        return this.onRemoveProfileBannerImage;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
        ColorPickerDialog colorPickerDialog = this.colorPickerDialog;
        if (colorPickerDialog != null) {
            colorPickerDialog.dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEditProfileBannerSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99651());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence charSequenceM211c;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f16497h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditProfileBannerSheet.this.navigateToUpsellModal();
            }
        });
        getBinding().f16496g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditProfileBannerSheet.this.getOnRemoveProfileBannerImage().invoke();
                WidgetEditProfileBannerSheet.this.dismiss();
            }
        });
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_HAS_BANNER_IMAGE);
        MaterialTextView materialTextView = getBinding().f16492c;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.bannerChangeImageItemTitle");
        if (z2) {
            Resources resources = getResources();
            C12238m.checkNotNullExpressionValue(resources, "resources");
            charSequenceM211c = C1107b.m211c(resources, C5419R.string.user_settings_change_profile_banner, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        } else {
            Resources resources2 = getResources();
            C12238m.checkNotNullExpressionValue(resources2, "resources");
            charSequenceM211c = C1107b.m211c(resources2, C5419R.string.user_settings_upload_banner, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }
        materialTextView.setText(charSequenceM211c);
        MaterialTextView materialTextView2 = getBinding().f16496g;
        C12238m.checkNotNullExpressionValue(materialTextView2, "binding.bannerRemoveImageItem");
        materialTextView2.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnChangeProfileBannerImage(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onChangeProfileBannerImage = function0;
    }

    public final void setOnColorSelected(Function1<? super Integer, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onColorSelected = function1;
    }

    public final void setOnRemoveProfileBannerImage(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onRemoveProfileBannerImage = function0;
    }
}
