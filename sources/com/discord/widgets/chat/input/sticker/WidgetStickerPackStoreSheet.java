package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerPackStoreSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.sticker.StickerFullSizeDialog;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_pack_Store_sheet_analytics_location";
    private static final String ANALYTICS_LOCATION_SECTION = "widget_sticker_pack_Store_sheet_analytics_location_section";
    private static final String VIEW_TYPE = "widget_sticker_pack_store_sheet_view_type";
    private WidgetStickerAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetStickerPackStoreSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType viewType, String location, StickerPurchaseLocation purchaseLocation) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(sticker, "sticker");
            C12238m.checkNotNullParameter(viewType, "viewType");
            if (sticker.getType() != StickerType.STANDARD) {
                return;
            }
            WidgetStickerPackStoreSheet widgetStickerPackStoreSheet = new WidgetStickerPackStoreSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            bundle.putSerializable(WidgetStickerPackStoreSheet.VIEW_TYPE, viewType);
            bundle.putString(WidgetStickerPackStoreSheet.ANALYTICS_LOCATION, location);
            bundle.putSerializable(WidgetStickerPackStoreSheet.ANALYTICS_LOCATION_SECTION, purchaseLocation);
            widgetStickerPackStoreSheet.setArguments(bundle);
            widgetStickerPackStoreSheet.show(fragmentManager, WidgetStickerPackStoreSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
    public static final /* synthetic */ class C79031 extends C12236k implements Function1<StickerPackStoreSheetViewModel.ViewState, Unit> {
        public C79031(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerPackStoreSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerPackStoreSheetViewModel.ViewState viewState) {
            ((WidgetStickerPackStoreSheet) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
    public static final /* synthetic */ class C79041 extends C12236k implements Function1<StickerItem, Unit> {
        public C79041(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerItemSelected", "onStickerItemSelected(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerItem stickerItem) {
            invoke2(stickerItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerItem stickerItem) {
            C12238m.checkNotNullParameter(stickerItem, "p1");
            ((WidgetStickerPackStoreSheet) this.receiver).onStickerItemSelected(stickerItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
    public static final /* synthetic */ class C79052 extends C12236k implements Function1<StoreHeaderItem, Unit> {
        public C79052(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerHeaderItemsClicked", "onStickerHeaderItemsClicked(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreHeaderItem storeHeaderItem) {
            invoke2(storeHeaderItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreHeaderItem storeHeaderItem) {
            C12238m.checkNotNullParameter(storeHeaderItem, "p1");
            ((WidgetStickerPackStoreSheet) this.receiver).onStickerHeaderItemsClicked(storeHeaderItem);
        }
    }

    public WidgetStickerPackStoreSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerPackStoreSheet$binding$2.INSTANCE, null, 2, null);
        WidgetStickerPackStoreSheet$viewModel$2 widgetStickerPackStoreSheet$viewModel$2 = new WidgetStickerPackStoreSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(StickerPackStoreSheetViewModel.class), new WidgetStickerPackStoreSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetStickerPackStoreSheet$viewModel$2));
    }

    private final void configureUI(final StickerPackStoreSheetViewModel.ViewState viewState) {
        if (viewState != null) {
            setBottomSheetState(3);
            WidgetStickerAdapter widgetStickerAdapter = this.adapter;
            if (widgetStickerAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            widgetStickerAdapter.setData(viewState.getStickerItems());
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            CharSequence stickerPackPremiumPriceLabel = stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, viewState.getStickerPack(), viewState.getMeUserPremiumTier(), viewState.isPackEnabled());
            boolean zIsStickerPackFreeForPremiumTier = stickerUtils.isStickerPackFreeForPremiumTier(viewState.getStickerPack(), PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY);
            getBinding().f18187e.setText(stickerPackPremiumPriceLabel);
            LoadingButton loadingButton = getBinding().f18187e;
            C12238m.checkNotNullExpressionValue(loadingButton, "binding.stickerStoreBuyButtonPremium");
            loadingButton.setVisibility(viewState.isPackEnabled() && !viewState.canUserAccessToPremiumStickers() ? 0 : 8);
            getBinding().f18187e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (!viewState.isPackEnabled() || viewState.canUserAccessToPremiumStickers()) {
                        return;
                    }
                    WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                    Context contextRequireContext2 = WidgetStickerPackStoreSheet.this.requireContext();
                    C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext2, 1, null, 4, null);
                }
            });
            LoadingButton loadingButton2 = getBinding().f18187e;
            C12238m.checkNotNullExpressionValue(loadingButton2, "binding.stickerStoreBuyButtonPremium");
            loadingButton2.setEnabled(true);
            getBinding().f18187e.setIsLoading(false);
            getBinding().f18187e.setIconVisibility(!zIsStickerPackFreeForPremiumTier);
            String bannerCDNAssetUrl = stickerUtils.getBannerCDNAssetUrl(viewState.getStickerPack(), 1024);
            if (!(bannerCDNAssetUrl.length() > 0)) {
                SimpleDraweeView simpleDraweeView = getBinding().f18186d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerPackViewAllBanner");
                simpleDraweeView.setVisibility(8);
            } else {
                SimpleDraweeView simpleDraweeView2 = getBinding().f18186d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerPackViewAllBanner");
                MGImages.setImage$default(simpleDraweeView2, bannerCDNAssetUrl, 0, 0, false, null, null, 124, null);
                SimpleDraweeView simpleDraweeView3 = getBinding().f18186d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerPackViewAllBanner");
                simpleDraweeView3.setVisibility(0);
            }
        }
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build.VERSION.SDK_INT >= 29) {
            return DimenUtils.dpToPixels(8);
        }
        return 0;
    }

    private final WidgetStickerPackStoreSheetBinding getBinding() {
        return (WidgetStickerPackStoreSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerPackStoreSheetViewModel getViewModel() {
        return (StickerPackStoreSheetViewModel) this.viewModel.getValue();
    }

    private final void onStickerHeaderItemsClicked(StoreHeaderItem storeHeaderItem) {
        WidgetStickerPackDetailsDialog.Companion companion = WidgetStickerPackDetailsDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.show(childFragmentManager, storeHeaderItem.getPack().getId(), Integer.valueOf(DimenUtils.dpToPixels(80)));
    }

    private final void onStickerItemSelected(StickerItem stickerItem) {
        StickerFullSizeDialog.Companion companion = StickerFullSizeDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.show(childFragmentManager, stickerItem.getSticker());
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, StickerPurchaseLocation stickerPurchaseLocation) {
        INSTANCE.show(fragmentManager, sticker, stickerPackStoreSheetViewType, str, stickerPurchaseLocation);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_sticker_pack_store_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetStickerPackStoreSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79031(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RelativeLayout relativeLayout = getBinding().f18184b;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.stickerPackStoreSheetContainer");
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        RecyclerView recyclerView = getBinding().f18185c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.stickerPackStoreSheetRecycler");
        this.adapter = new WidgetStickerAdapter(recyclerView, new C79041(this), new C79052(this), null, this, true, 8, null);
        getViewModel().fetchStickersData();
    }
}
