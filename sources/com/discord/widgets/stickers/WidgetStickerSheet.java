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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent;
import com.discord.widgets.chat.input.expression.ExpressionPickerEventBus;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewType;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_sheet_analytics_location";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetStickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, long channelId) {
            Channel channelFindChannelById;
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(sticker, "sticker");
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

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetStickerSheet.kt */
    public static final /* synthetic */ class C101361 extends C12236k implements Function1<StickerSheetViewModel.ViewState, Unit> {
        public C101361(WidgetStickerSheet widgetStickerSheet) {
            super(1, widgetStickerSheet, WidgetStickerSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetStickerSheet) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2 */
    /* JADX INFO: compiled from: WidgetStickerSheet.kt */
    public static final class C101382 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C101382 INSTANCE = new C101382();

        /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetStickerSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                C12238m.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, "Sticker Nitro Upsell Popout", 2, null);
            }
        }

        public C101382() {
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
            renderContext.m8423b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    public WidgetStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerSheet$binding$2.INSTANCE, null, 2, null);
        WidgetStickerSheet$viewModel$2 widgetStickerSheet$viewModel$2 = new WidgetStickerSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(StickerSheetViewModel.class), new WidgetStickerSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetStickerSheet$viewModel$2));
    }

    private final void configureUI(final StickerSheetViewModel.ViewState viewState) {
        CharSequence charSequenceM213e;
        final ModelStickerPack modelStickerPackComponent1 = viewState.getStickerPack();
        final Sticker stickerComponent2 = viewState.getSticker();
        PremiumTier premiumTierComponent3 = viewState.getMeUserPremiumTier();
        final boolean zComponent4 = viewState.getIsStickerPackEnabled();
        TextView textView = getBinding().f18210d;
        C12238m.checkNotNullExpressionValue(textView, "binding.stickerSheetStickerName");
        textView.setText(stickerComponent2.getName());
        if (!viewState.getCanUsePremiumStickers()) {
            getBinding().f18209c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerSheet.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                    FragmentActivity fragmentActivityRequireActivity = WidgetStickerSheet.this.requireActivity();
                    C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                    WidgetSettingsPremium.Companion.launch$default(companion, fragmentActivityRequireActivity, null, "Sticker Nitro Upsell Popout", 2, null);
                }
            });
        }
        TextView textView2 = getBinding().f18209c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.stickerSheetStickerInfo");
        if (zComponent4 || viewState.getCanUsePremiumStickers() || modelStickerPackComponent1.isPremiumPack()) {
            charSequenceM213e = C1107b.m213e(this, C5419R.string.sticker_popout_pack_info_premium, new Object[]{modelStickerPackComponent1.getName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        } else {
            charSequenceM213e = !modelStickerPackComponent1.canBePurchased() ? C1107b.m213e(this, C5419R.string.sticker_popout_pack_info_unavailable, new Object[]{modelStickerPackComponent1.getName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(this, C5419R.string.sticker_popout_pack_info, new Object[]{modelStickerPackComponent1.getName(), String.valueOf(StickerUtils.INSTANCE.calculatePremiumStickerPackDiscount())}, C101382.INSTANCE);
        }
        textView2.setText(charSequenceM213e);
        try {
            getBinding().f18214h.m8616d(modelStickerPackComponent1.getStickers().get(0), 0);
            getBinding().f18215i.m8616d(modelStickerPackComponent1.getStickers().get(1), 0);
            getBinding().f18216j.m8616d(modelStickerPackComponent1.getStickers().get(2), 0);
            getBinding().f18217k.m8616d(modelStickerPackComponent1.getStickers().get(3), 0);
        } catch (IndexOutOfBoundsException unused) {
        }
        Bundle arguments = getArguments();
        final String string = arguments != null ? arguments.getString(ANALYTICS_LOCATION) : null;
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().f18208b.setText(stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, modelStickerPackComponent1, premiumTierComponent3, zComponent4));
        getBinding().f18208b.setIsLoading(false);
        getBinding().f18208b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!zComponent4 || viewState.getCanUsePremiumStickers()) {
                    return;
                }
                WidgetStickerSheet.this.dismiss();
                StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
            }
        });
        LoadingButton loadingButton = getBinding().f18208b;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.stickerSheetBuyButton");
        loadingButton.setVisibility(zComponent4 && !viewState.getCanUsePremiumStickers() ? 0 : 8);
        MaterialButton materialButton = getBinding().f18211e;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.stickerSheetViewButton");
        materialButton.setVisibility(zComponent4 ? 0 : 8);
        getBinding().f18211e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (zComponent4 && viewState.getCanUsePremiumStickers()) {
                    ExpressionPickerEventBus.INSTANCE.getINSTANCE().emitEvent(new ExpressionPickerEvent.OpenStickerPicker(stickerComponent2.getPackId(), null, false, 2, null));
                } else {
                    WidgetStickerPackStoreSheet.Companion companion = WidgetStickerPackStoreSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, stickerComponent2, StickerPackStoreSheetViewType.STICKER_POPOUT_VIEW_ALL, string, StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(modelStickerPackComponent1.canBePurchased()));
                }
                WidgetStickerSheet.this.dismiss();
            }
        });
        RelativeLayout relativeLayout = getBinding().f18213g;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.stickerSheetViewLimitedContainer");
        relativeLayout.setVisibility(modelStickerPackComponent1.isLimitedPack() ? 0 : 8);
        Chip chip = getBinding().f18212f;
        C12238m.checkNotNullExpressionValue(chip, "binding.stickerSheetViewLimitedChip");
        Context contextRequireContext2 = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
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
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetStickerSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101361(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_sticker_sheet;
    }
}
