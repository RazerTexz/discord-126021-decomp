package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerPackStoreSheetBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$Companion;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStickerPackStoreSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", 0)};
    public static final WidgetStickerPackStoreSheet$Companion Companion = new WidgetStickerPackStoreSheet$Companion(null);

    public WidgetStickerPackStoreSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerPackStoreSheet$binding$2.INSTANCE, null, 2, null);
        WidgetStickerPackStoreSheet$viewModel$2 widgetStickerPackStoreSheet$viewModel$2 = new WidgetStickerPackStoreSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StickerPackStoreSheetViewModel.class), new WidgetStickerPackStoreSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStickerPackStoreSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerPackStoreSheetViewModel$ViewState stickerPackStoreSheetViewModel$ViewState) {
        widgetStickerPackStoreSheet.configureUI(stickerPackStoreSheetViewModel$ViewState);
    }

    public static final /* synthetic */ void access$onStickerHeaderItemsClicked(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StoreHeaderItem storeHeaderItem) {
        widgetStickerPackStoreSheet.onStickerHeaderItemsClicked(storeHeaderItem);
    }

    public static final /* synthetic */ void access$onStickerItemSelected(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerItem stickerItem) {
        widgetStickerPackStoreSheet.onStickerItemSelected(stickerItem);
    }

    private final void configureUI(StickerPackStoreSheetViewModel$ViewState viewState) {
        if (viewState != null) {
            setBottomSheetState(3);
            WidgetStickerAdapter widgetStickerAdapter = this.adapter;
            if (widgetStickerAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            widgetStickerAdapter.setData(viewState.getStickerItems());
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            CharSequence stickerPackPremiumPriceLabel = stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, viewState.getStickerPack(), viewState.getMeUserPremiumTier(), viewState.isPackEnabled());
            boolean zIsStickerPackFreeForPremiumTier = stickerUtils.isStickerPackFreeForPremiumTier(viewState.getStickerPack(), PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY);
            getBinding().e.setText(stickerPackPremiumPriceLabel);
            LoadingButton loadingButton = getBinding().e;
            m.checkNotNullExpressionValue(loadingButton, "binding.stickerStoreBuyButtonPremium");
            loadingButton.setVisibility(viewState.isPackEnabled() && !viewState.canUserAccessToPremiumStickers() ? 0 : 8);
            getBinding().e.setOnClickListener(new WidgetStickerPackStoreSheet$configureUI$1(this, viewState));
            LoadingButton loadingButton2 = getBinding().e;
            m.checkNotNullExpressionValue(loadingButton2, "binding.stickerStoreBuyButtonPremium");
            loadingButton2.setEnabled(true);
            getBinding().e.setIsLoading(false);
            getBinding().e.setIconVisibility(!zIsStickerPackFreeForPremiumTier);
            String bannerCDNAssetUrl = stickerUtils.getBannerCDNAssetUrl(viewState.getStickerPack(), 1024);
            if (!(bannerCDNAssetUrl.length() > 0)) {
                SimpleDraweeView simpleDraweeView = getBinding().d;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerPackViewAllBanner");
                simpleDraweeView.setVisibility(8);
            } else {
                SimpleDraweeView simpleDraweeView2 = getBinding().d;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerPackViewAllBanner");
                MGImages.setImage$default(simpleDraweeView2, bannerCDNAssetUrl, 0, 0, false, null, null, 124, null);
                SimpleDraweeView simpleDraweeView3 = getBinding().d;
                m.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerPackViewAllBanner");
                simpleDraweeView3.setVisibility(0);
            }
        }
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build$VERSION.SDK_INT >= 29) {
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
        WidgetStickerPackDetailsDialog$Companion widgetStickerPackDetailsDialog$Companion = WidgetStickerPackDetailsDialog.Companion;
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        widgetStickerPackDetailsDialog$Companion.show(childFragmentManager, storeHeaderItem.getPack().getId(), Integer.valueOf(DimenUtils.dpToPixels(80)));
    }

    private final void onStickerItemSelected(StickerItem stickerItem) {
        StickerFullSizeDialog$Companion stickerFullSizeDialog$Companion = StickerFullSizeDialog.Companion;
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        stickerFullSizeDialog$Companion.show(childFragmentManager, stickerItem.getSticker());
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, StickerPurchaseLocation stickerPurchaseLocation) {
        Companion.show(fragmentManager, sticker, stickerPackStoreSheetViewType, str, stickerPurchaseLocation);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_sticker_pack_store_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStickerPackStoreSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerPackStoreSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RelativeLayout relativeLayout = getBinding().f2660b;
        m.checkNotNullExpressionValue(relativeLayout, "binding.stickerPackStoreSheetContainer");
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.stickerPackStoreSheetRecycler");
        this.adapter = new WidgetStickerAdapter(recyclerView, new WidgetStickerPackStoreSheet$onViewCreated$1(this), new WidgetStickerPackStoreSheet$onViewCreated$2(this), null, this, true, 8, null);
        getViewModel().fetchStickersData();
    }
}
