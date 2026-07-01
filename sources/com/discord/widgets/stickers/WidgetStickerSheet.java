package com.discord.widgets.stickers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent;
import com.discord.widgets.chat.input.expression.ExpressionPickerEventBus;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet2;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import com.discord.widgets.stickers.StickerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_sheet_analytics_location";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetStickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, long channelId) {
            Channel channelFindChannelById;
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            if (sticker.getType() == StickerType.STANDARD && (channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelId)) != null) {
                String str = channelFindChannelById.getGuildId() == 0 ? "DM Channel" : Traits.Location.Page.GUILD_CHANNEL;
                WidgetStickerSheet widgetStickerSheet = new WidgetStickerSheet();
                Bundle bundle = new Bundle();
                bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
                bundle.putString(WidgetStickerSheet.ANALYTICS_LOCATION, str);
                widgetStickerSheet.setArguments(bundle);
                widgetStickerSheet.show(fragmentManager, WidgetStickerSheet.class.getName());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerSheet$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StickerSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStickerSheet widgetStickerSheet) {
            super(1, widgetStickerSheet, WidgetStickerSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetStickerSheet) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetStickerSheet.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, "Sticker Nitro Upsell Popout", 2, null);
            }
        }

        public AnonymousClass2() {
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
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    public WidgetStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerSheet2.INSTANCE, null, 2, null);
        WidgetStickerSheet3 widgetStickerSheet3 = new WidgetStickerSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StickerSheetViewModel.class), new WidgetStickerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStickerSheet3));
    }

    private final void configureUI(final StickerSheetViewModel.ViewState viewState) {
        CharSequence charSequenceE;
        final ModelStickerPack modelStickerPackComponent1 = viewState.getStickerPack();
        final Sticker stickerComponent2 = viewState.getSticker();
        PremiumTier premiumTierComponent3 = viewState.getMeUserPremiumTier();
        final boolean zComponent4 = viewState.getIsStickerPackEnabled();
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerSheetStickerName");
        textView.setText(stickerComponent2.getName());
        if (!viewState.getCanUsePremiumStickers()) {
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerSheet.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                    FragmentActivity fragmentActivityRequireActivity = WidgetStickerSheet.this.requireActivity();
                    Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                    WidgetSettingsPremium.Companion.launch$default(companion, fragmentActivityRequireActivity, null, "Sticker Nitro Upsell Popout", 2, null);
                }
            });
        }
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerSheetStickerInfo");
        if (zComponent4 || viewState.getCanUsePremiumStickers() || modelStickerPackComponent1.isPremiumPack()) {
            charSequenceE = FormatUtils.e(this, R.string.sticker_popout_pack_info_premium, new Object[]{modelStickerPackComponent1.getName()}, (4 & 4) != 0 ? FormatUtils.a.j : null);
        } else {
            charSequenceE = !modelStickerPackComponent1.canBePurchased() ? FormatUtils.e(this, R.string.sticker_popout_pack_info_unavailable, new Object[]{modelStickerPackComponent1.getName()}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(this, R.string.sticker_popout_pack_info, new Object[]{modelStickerPackComponent1.getName(), String.valueOf(StickerUtils.INSTANCE.calculatePremiumStickerPackDiscount())}, AnonymousClass2.INSTANCE);
        }
        textView2.setText(charSequenceE);
        try {
            getBinding().h.d(modelStickerPackComponent1.getStickers().get(0), 0);
            getBinding().i.d(modelStickerPackComponent1.getStickers().get(1), 0);
            getBinding().j.d(modelStickerPackComponent1.getStickers().get(2), 0);
            getBinding().k.d(modelStickerPackComponent1.getStickers().get(3), 0);
        } catch (IndexOutOfBoundsException unused) {
        }
        Bundle arguments = getArguments();
        final String string = arguments != null ? arguments.getString(ANALYTICS_LOCATION) : null;
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().f2663b.setText(stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, modelStickerPackComponent1, premiumTierComponent3, zComponent4));
        getBinding().f2663b.setIsLoading(false);
        getBinding().f2663b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!zComponent4 || viewState.getCanUsePremiumStickers()) {
                    return;
                }
                WidgetStickerSheet.this.dismiss();
                StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
            }
        });
        LoadingButton loadingButton = getBinding().f2663b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.stickerSheetBuyButton");
        loadingButton.setVisibility(zComponent4 && !viewState.getCanUsePremiumStickers() ? 0 : 8);
        MaterialButton materialButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.stickerSheetViewButton");
        materialButton.setVisibility(zComponent4 ? 0 : 8);
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (zComponent4 && viewState.getCanUsePremiumStickers()) {
                    ExpressionPickerEventBus.INSTANCE.getINSTANCE().emitEvent(new ExpressionPickerEvent.OpenStickerPicker(stickerComponent2.getPackId(), null, false, 2, null));
                } else {
                    WidgetStickerPackStoreSheet.Companion companion = WidgetStickerPackStoreSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, stickerComponent2, WidgetStickerPackStoreSheet2.STICKER_POPOUT_VIEW_ALL, string, StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(modelStickerPackComponent1.canBePurchased()));
                }
                WidgetStickerSheet.this.dismiss();
            }
        });
        RelativeLayout relativeLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.stickerSheetViewLimitedContainer");
        relativeLayout.setVisibility(modelStickerPackComponent1.isLimitedPack() ? 0 : 8);
        Chip chip = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.stickerSheetViewLimitedChip");
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        chip.setText(stickerUtils.getLimitedTimeLeftString(contextRequireContext2, modelStickerPackComponent1.getStoreListing()));
    }

    private final WidgetStickerSheetBinding getBinding() {
        return (WidgetStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerSheetViewModel getViewModel() {
        return (StickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, long j) {
        INSTANCE.show(fragmentManager, sticker, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) WidgetStickerSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_sheet;
    }
}
