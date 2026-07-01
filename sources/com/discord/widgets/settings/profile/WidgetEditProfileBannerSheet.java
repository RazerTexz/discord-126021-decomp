package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.d;
import b.a.a.b.d$b;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsTracker$PremiumUpsellType;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialog$k;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEditProfileBannerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0)};
    public static final WidgetEditProfileBannerSheet$Companion Companion = new WidgetEditProfileBannerSheet$Companion(null);

    public WidgetEditProfileBannerSheet() {
        super(false, 1, null);
        this.onChangeProfileBannerImage = WidgetEditProfileBannerSheet$onChangeProfileBannerImage$1.INSTANCE;
        this.onRemoveProfileBannerImage = WidgetEditProfileBannerSheet$onRemoveProfileBannerImage$1.INSTANCE;
        this.onColorSelected = WidgetEditProfileBannerSheet$onColorSelected$1.INSTANCE;
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEditProfileBannerSheet$binding$2.INSTANCE, null, 2, null);
        this.isGuildContext = g.lazy(new WidgetEditProfileBannerSheet$isGuildContext$2(this));
        WidgetEditProfileBannerSheet$viewModel$2 widgetEditProfileBannerSheet$viewModel$2 = new WidgetEditProfileBannerSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(EditProfileBannerSheetViewModel.class), new WidgetEditProfileBannerSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetEditProfileBannerSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUi(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, EditProfileBannerSheetViewModel$ViewState editProfileBannerSheetViewModel$ViewState) {
        widgetEditProfileBannerSheet.configureUi(editProfileBannerSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ int access$getDefaultBannerColor$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.defaultBannerColor;
    }

    public static final /* synthetic */ EditProfileBannerSheetViewModel access$getViewModel$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.getViewModel();
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, int i) {
        widgetEditProfileBannerSheet.launchColorPicker(i);
    }

    public static final /* synthetic */ void access$navigateToUpsellModal(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        widgetEditProfileBannerSheet.navigateToUpsellModal();
    }

    public static final /* synthetic */ void access$setDefaultBannerColor$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, int i) {
        widgetEditProfileBannerSheet.defaultBannerColor = i;
    }

    private final void configureStringsForGuild() {
        MaterialTextView materialTextView = getBinding().e;
        m.checkNotNullExpressionValue(materialTextView, "binding.bannerColorItemTitle");
        materialTextView.setText(b.k(this, 2131887510, new Object[0], null, 4));
        MaterialTextView materialTextView2 = getBinding().c;
        m.checkNotNullExpressionValue(materialTextView2, "binding.bannerChangeImageItemTitle");
        materialTextView2.setText(b.k(this, 2131887509, new Object[0], null, 4));
        MaterialTextView materialTextView3 = getBinding().g;
        m.checkNotNullExpressionValue(materialTextView3, "binding.bannerRemoveImageItem");
        materialTextView3.setText(b.k(this, 2131887511, new Object[0], null, 4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Integer] */
    private final void configureUi(EditProfileBannerSheetViewModel$ViewState viewState) {
        if (viewState instanceof EditProfileBannerSheetViewModel$ViewState) {
            String bannerColorHex = viewState.getBannerColorHex();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            if (isGuildContext()) {
                configureStringsForGuild();
            }
            if (bannerColorHex != null) {
                try {
                    ref$ObjectRef.element = Integer.valueOf(Color.parseColor(bannerColorHex));
                } catch (IllegalArgumentException e) {
                    Logger.e$default(AppLog.g, a.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                }
            }
            if (((Integer) ref$ObjectRef.element) != null) {
                ImageView imageView = getBinding().f;
                m.checkNotNullExpressionValue(imageView, "binding.bannerColorPreview");
                ColorCompatKt.tintWithColor(imageView, ((Integer) ref$ObjectRef.element).intValue());
            }
            ImageView imageView2 = getBinding().f;
            m.checkNotNullExpressionValue(imageView2, "binding.bannerColorPreview");
            imageView2.setVisibility(((Integer) ref$ObjectRef.element) == null ? 4 : 0);
            getBinding().d.setOnClickListener(new WidgetEditProfileBannerSheet$configureUi$1(this, ref$ObjectRef));
            MaterialButton materialButton = getBinding().h;
            m.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellButton");
            materialButton.setVisibility(viewState.getShowPremiumUpsell() ? 0 : 8);
            MaterialButton materialButton2 = getBinding().h;
            m.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellButton");
            if ((materialButton2.getVisibility() == 0) && !getViewModel().getUpsellViewedTracked()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.CustomProfileBannerUpsell, new Traits$Location(Traits$Location$Page.USER_SETTINGS, "User Profile", Traits$Location$Obj.EDIT_PROFILE_BANNER, null, null, 24, null), null, null, 12, null);
                getViewModel().setUpsellViewedTracked(true);
            }
            getBinding().f2369b.setOnClickListener(new WidgetEditProfileBannerSheet$configureUi$2(this, viewState));
        }
        KotlinExtensionsKt.getExhaustive(Unit.a);
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
        ColorPickerDialog$k colorPickerDialog$k = new ColorPickerDialog$k();
        colorPickerDialog$k.h = initialColor;
        colorPickerDialog$k.f3148s = ColorCompat.getThemedColor(getContext(), 2130968911);
        colorPickerDialog$k.i = false;
        colorPickerDialog$k.j = false;
        colorPickerDialog$k.f = 0;
        colorPickerDialog$k.a = 2131896853;
        colorPickerDialog$k.r = ColorCompat.getThemedColor(getContext(), 2130968989);
        FontUtils fontUtils = FontUtils.INSTANCE;
        colorPickerDialog$k.f3149x = fontUtils.getThemedFontResId(getContext(), 2130969390);
        colorPickerDialog$k.l = true;
        colorPickerDialog$k.e = 2131887708;
        colorPickerDialog$k.p = ColorCompat.getThemedColor(getContext(), 2130969062);
        colorPickerDialog$k.d = 2131895390;
        colorPickerDialog$k.w = ColorCompat.getColor(getContext(), 2131100487);
        colorPickerDialog$k.f3150y = fontUtils.getThemedFontResId(getContext(), 2130969396);
        colorPickerDialog$k.t = ColorCompat.getThemedColor(getContext(), 2130969056);
        colorPickerDialog$k.u = 2131231203;
        colorPickerDialog$k.f3151z = fontUtils.getThemedFontResId(getContext(), 2130969395);
        ColorPickerDialog colorPickerDialogA = colorPickerDialog$k.a();
        colorPickerDialogA.k = new WidgetEditProfileBannerSheet$launchColorPicker$1(this);
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogA.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
        this.colorPickerDialog = colorPickerDialogA;
    }

    private final void navigateToUpsellModal() {
        d$b d_b = d.k;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker$PremiumUpsellType analyticsTracker$PremiumUpsellType = AnalyticsTracker$PremiumUpsellType.CustomProfileUpsellModal;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        String string = b.i(resources, 2131894319, new Object[0], null, 4).toString();
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        d_b.a(parentFragmentManager, analyticsTracker$PremiumUpsellType, 2131232439, string, b.i(resources2, 2131894317, new Object[0], null, 4).toString(), Traits$Location$Page.USER_SETTINGS, "User Profile", Traits$Location$Obj.EDIT_PROFILE_BANNER);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_edit_profile_banner_sheet;
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEditProfileBannerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEditProfileBannerSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence charSequenceI;
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().h.setOnClickListener(new WidgetEditProfileBannerSheet$onViewCreated$1(this));
        getBinding().g.setOnClickListener(new WidgetEditProfileBannerSheet$onViewCreated$2(this));
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_HAS_BANNER_IMAGE);
        MaterialTextView materialTextView = getBinding().c;
        m.checkNotNullExpressionValue(materialTextView, "binding.bannerChangeImageItemTitle");
        if (z2) {
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            charSequenceI = b.i(resources, 2131896864, new Object[0], null, 4);
        } else {
            Resources resources2 = getResources();
            m.checkNotNullExpressionValue(resources2, "resources");
            charSequenceI = b.i(resources2, 2131896981, new Object[0], null, 4);
        }
        materialTextView.setText(charSequenceI);
        MaterialTextView materialTextView2 = getBinding().g;
        m.checkNotNullExpressionValue(materialTextView2, "binding.bannerRemoveImageItem");
        materialTextView2.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnChangeProfileBannerImage(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onChangeProfileBannerImage = function0;
    }

    public final void setOnColorSelected(Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onColorSelected = function1;
    }

    public final void setOnRemoveProfileBannerImage(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onRemoveProfileBannerImage = function0;
    }
}
