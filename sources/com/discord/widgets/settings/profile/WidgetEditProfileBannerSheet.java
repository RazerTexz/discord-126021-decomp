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
import b.a.a.b.SingleValuePropPremiumUpsellDialog;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEditProfileBannerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Long guildId, String defaultBannerColorHex, String initialColorPreviewHex, boolean hasBannerImage, FragmentManager fragmentManager, Function0<Unit> onChangeProfileBannerImage, Function0<Unit> onRemoveProfileBannerImage, Function1<? super Integer, Unit> onColorSelected) {
            Intrinsics3.checkNotNullParameter(defaultBannerColorHex, "defaultBannerColorHex");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(onChangeProfileBannerImage, "onChangeProfileBannerImage");
            Intrinsics3.checkNotNullParameter(onRemoveProfileBannerImage, "onRemoveProfileBannerImage");
            Intrinsics3.checkNotNullParameter(onColorSelected, "onColorSelected");
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$isGuildContext$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<EditProfileBannerSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditProfileBannerSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetEditProfileBannerSheet.this.configureUi(viewState);
        }
    }

    public WidgetEditProfileBannerSheet() {
        super(false, 1, null);
        this.onChangeProfileBannerImage = WidgetEditProfileBannerSheet6.INSTANCE;
        this.onRemoveProfileBannerImage = WidgetEditProfileBannerSheet8.INSTANCE;
        this.onColorSelected = WidgetEditProfileBannerSheet7.INSTANCE;
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEditProfileBannerSheet5.INSTANCE, null, 2, null);
        this.isGuildContext = LazyJVM.lazy(new AnonymousClass2());
        WidgetEditProfileBannerSheet9 widgetEditProfileBannerSheet9 = new WidgetEditProfileBannerSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EditProfileBannerSheetViewModel.class), new WidgetEditProfileBannerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEditProfileBannerSheet9));
    }

    private final void configureStringsForGuild() {
        MaterialTextView materialTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.bannerColorItemTitle");
        materialTextView.setText(FormatUtils.e(this, R.string.change_identity_profile_color, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        MaterialTextView materialTextView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.bannerChangeImageItemTitle");
        materialTextView2.setText(FormatUtils.e(this, R.string.change_identity_profile_banner, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        MaterialTextView materialTextView3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.bannerRemoveImageItem");
        materialTextView3.setText(FormatUtils.e(this, R.string.change_identity_reset_banner, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
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
                    Logger.e$default(AppLog.g, outline.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                }
            }
            if (((Integer) ref$ObjectRef.element) != null) {
                ImageView imageView = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.bannerColorPreview");
                ColorCompat2.tintWithColor(imageView, ((Integer) ref$ObjectRef.element).intValue());
            }
            ImageView imageView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.bannerColorPreview");
            imageView2.setVisibility(((Integer) ref$ObjectRef.element) == null ? 4 : 0);
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.configureUi.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = WidgetEditProfileBannerSheet.this;
                    Integer num = (Integer) ref$ObjectRef.element;
                    widgetEditProfileBannerSheet.launchColorPicker(num != null ? num.intValue() : widgetEditProfileBannerSheet.defaultBannerColor);
                }
            });
            MaterialButton materialButton = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellButton");
            materialButton.setVisibility(viewState.getShowPremiumUpsell() ? 0 : 8);
            MaterialButton materialButton2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellButton");
            if ((materialButton2.getVisibility() == 0) && !getViewModel().getUpsellViewedTracked()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.CustomProfileBannerUpsell, new Traits.Location(Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER, null, null, 24, null), null, null, 12, null);
                getViewModel().setUpsellViewedTracked(true);
            }
            getBinding().f2369b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.configureUi.2
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
        KotlinExtensions.getExhaustive(Unit.a);
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
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = initialColor;
        kVar.f3148s = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary);
        kVar.i = false;
        kVar.j = false;
        kVar.f = 0;
        kVar.a = R.string.user_settings_banner_color_title;
        kVar.r = ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(getContext(), R.attr.font_display_bold);
        kVar.l = true;
        kVar.e = R.string.color_picker_use_default;
        kVar.p = ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.w = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_semibold);
        kVar.t = ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        colorPickerDialogA.k = new ColorPickerDialogListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.launchColorPicker.1
            @Override // b.k.a.a.ColorPickerDialogListener
            public void onColorReset(int dialogId) {
                WidgetEditProfileBannerSheet.this.getViewModel().updateColorPreview(null);
                WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(null);
            }

            @Override // b.k.a.a.ColorPickerDialogListener
            public void onColorSelected(int dialogId, int selectedColor) {
                EditProfileBannerSheetViewModel viewModel = WidgetEditProfileBannerSheet.this.getViewModel();
                ColorCompat colorCompat = ColorCompat.INSTANCE;
                viewModel.updateColorPreview(colorCompat.getColorHexFromColorInt(selectedColor));
                WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(Integer.valueOf(colorCompat.removeAlphaComponent(selectedColor)));
            }

            @Override // b.k.a.a.ColorPickerDialogListener
            public void onDialogDismissed(int dialogId) {
            }
        };
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogA.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
        this.colorPickerDialog = colorPickerDialogA;
    }

    private final void navigateToUpsellModal() {
        SingleValuePropPremiumUpsellDialog.Companion companion = SingleValuePropPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.CustomProfileUpsellModal;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        String string = FormatUtils.c(resources, R.string.premium_profile_customization_upsell_header, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null).toString();
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        companion.a(parentFragmentManager, premiumUpsellType, R.drawable.img_profile_banner_value_prop, string, FormatUtils.c(resources2, R.string.premium_profile_customization_upsell_body, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null).toString(), Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_edit_profile_banner_sheet;
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEditProfileBannerSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence charSequenceC;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditProfileBannerSheet.this.navigateToUpsellModal();
            }
        });
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditProfileBannerSheet.this.getOnRemoveProfileBannerImage().invoke();
                WidgetEditProfileBannerSheet.this.dismiss();
            }
        });
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_HAS_BANNER_IMAGE);
        MaterialTextView materialTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.bannerChangeImageItemTitle");
        if (z2) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            charSequenceC = FormatUtils.c(resources, R.string.user_settings_change_profile_banner, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        } else {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            charSequenceC = FormatUtils.c(resources2, R.string.user_settings_upload_banner, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        }
        materialTextView.setText(charSequenceC);
        MaterialTextView materialTextView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.bannerRemoveImageItem");
        materialTextView2.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnChangeProfileBannerImage(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onChangeProfileBannerImage = function0;
    }

    public final void setOnColorSelected(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onColorSelected = function1;
    }

    public final void setOnRemoveProfileBannerImage(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onRemoveProfileBannerImage = function0;
    }
}
