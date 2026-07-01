package com.discord.widgets.stickers;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerSheetBinding;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_sheet_analytics_location";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerSheetBinding;", 0)};
    public static final WidgetStickerSheet$Companion Companion = new WidgetStickerSheet$Companion(null);

    public WidgetStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerSheet$binding$2.INSTANCE, null, 2, null);
        WidgetStickerSheet$viewModel$2 widgetStickerSheet$viewModel$2 = new WidgetStickerSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StickerSheetViewModel.class), new WidgetStickerSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStickerSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerSheet widgetStickerSheet, StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState) {
        widgetStickerSheet.configureUI(stickerSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStickerSheet widgetStickerSheet) {
        return widgetStickerSheet.getArgumentsOrDefault();
    }

    private final void configureUI(StickerSheetViewModel$ViewState viewState) {
        CharSequence charSequenceK;
        ModelStickerPack modelStickerPackComponent1 = viewState.getStickerPack();
        Sticker stickerComponent2 = viewState.getSticker();
        PremiumTier premiumTierComponent3 = viewState.getMeUserPremiumTier();
        boolean zComponent4 = viewState.getIsStickerPackEnabled();
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.stickerSheetStickerName");
        textView.setText(stickerComponent2.getName());
        if (!viewState.getCanUsePremiumStickers()) {
            getBinding().c.setOnClickListener(new WidgetStickerSheet$configureUI$1(this));
        }
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.stickerSheetStickerInfo");
        if (zComponent4 || viewState.getCanUsePremiumStickers() || modelStickerPackComponent1.isPremiumPack()) {
            charSequenceK = b.k(this, 2131895966, new Object[]{modelStickerPackComponent1.getName()}, null, 4);
        } else {
            charSequenceK = !modelStickerPackComponent1.canBePurchased() ? b.k(this, 2131895967, new Object[]{modelStickerPackComponent1.getName()}, null, 4) : b.e(this, 2131895964, new Object[]{modelStickerPackComponent1.getName(), String.valueOf(StickerUtils.INSTANCE.calculatePremiumStickerPackDiscount())}, WidgetStickerSheet$configureUI$2.INSTANCE);
        }
        textView2.setText(charSequenceK);
        try {
            getBinding().h.d(modelStickerPackComponent1.getStickers().get(0), 0);
            getBinding().i.d(modelStickerPackComponent1.getStickers().get(1), 0);
            getBinding().j.d(modelStickerPackComponent1.getStickers().get(2), 0);
            getBinding().k.d(modelStickerPackComponent1.getStickers().get(3), 0);
        } catch (IndexOutOfBoundsException unused) {
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ANALYTICS_LOCATION) : null;
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().f2663b.setText(stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, modelStickerPackComponent1, premiumTierComponent3, zComponent4));
        getBinding().f2663b.setIsLoading(false);
        getBinding().f2663b.setOnClickListener(new WidgetStickerSheet$configureUI$3(this, zComponent4, viewState));
        LoadingButton loadingButton = getBinding().f2663b;
        m.checkNotNullExpressionValue(loadingButton, "binding.stickerSheetBuyButton");
        loadingButton.setVisibility(zComponent4 && !viewState.getCanUsePremiumStickers() ? 0 : 8);
        MaterialButton materialButton = getBinding().e;
        m.checkNotNullExpressionValue(materialButton, "binding.stickerSheetViewButton");
        materialButton.setVisibility(zComponent4 ? 0 : 8);
        getBinding().e.setOnClickListener(new WidgetStickerSheet$configureUI$4(this, zComponent4, viewState, stickerComponent2, string, modelStickerPackComponent1));
        RelativeLayout relativeLayout = getBinding().g;
        m.checkNotNullExpressionValue(relativeLayout, "binding.stickerSheetViewLimitedContainer");
        relativeLayout.setVisibility(modelStickerPackComponent1.isLimitedPack() ? 0 : 8);
        Chip chip = getBinding().f;
        m.checkNotNullExpressionValue(chip, "binding.stickerSheetViewLimitedChip");
        Context contextRequireContext2 = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        chip.setText(stickerUtils.getLimitedTimeLeftString(contextRequireContext2, modelStickerPackComponent1.getStoreListing()));
    }

    private final WidgetStickerSheetBinding getBinding() {
        return (WidgetStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerSheetViewModel getViewModel() {
        return (StickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, long j) {
        Companion.show(fragmentManager, sticker, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetStickerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerSheet$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_sticker_sheet;
    }
}
