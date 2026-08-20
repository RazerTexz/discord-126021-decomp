package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p062y.C1329f;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final int PRICE_TIER_PICKER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int PRICE_TIER_PICKER_VIEW_FLIPPER_RESULT = 1;
    private static final String RESULT_EXTRA_PRICE_TIER = "RESULT_EXTRA_PRICE_TIER";
    private PriceTierPickerAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Function1<Integer, Unit> itemClickListener;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetPriceTierPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Fragment fragment, String requestKey) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = new WidgetPriceTierPickerBottomSheet();
            widgetPriceTierPickerBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetPriceTierPickerBottomSheet.ARG_REQUEST_KEY, requestKey)));
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetPriceTierPickerBottomSheet.show(parentFragmentManager, WidgetPriceTierPickerBottomSheet.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function1<? super Integer, Unit> onPriceTierSelected) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onPriceTierSelected, "onPriceTierSelected");
            FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetPriceTierPickerBottomSheet$Companion$registerForResult$1(requestKey, onPriceTierSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
    public static final class C84421 extends AbstractC12240o implements Function1<PriceTierPickerBottomSheetViewModel.ViewState, Unit> {
        public C84421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
            WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = WidgetPriceTierPickerBottomSheet.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetPriceTierPickerBottomSheet.configureUI(viewState);
        }
    }

    public WidgetPriceTierPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPriceTierPickerBottomSheet$binding$2.INSTANCE, null, 2, null);
        WidgetPriceTierPickerBottomSheet$viewModel$2 widgetPriceTierPickerBottomSheet$viewModel$2 = WidgetPriceTierPickerBottomSheet$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(PriceTierPickerBottomSheetViewModel.class), new C8441x829b24a0(c0865g0), new C0869i0(widgetPriceTierPickerBottomSheet$viewModel$2));
        this.itemClickListener = new WidgetPriceTierPickerBottomSheet$itemClickListener$1(this);
    }

    private final void configureUI(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17385b;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.priceTierPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            if (!(viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Loaded)) {
                if (viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Failed) {
                    C0876m.m169g(requireContext(), C5419R.string.default_failure_to_perform_action_message, 0, null, 12);
                    dismiss();
                    return;
                }
                return;
            }
            AppViewFlipper appViewFlipper2 = getBinding().f17385b;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.priceTierPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            PriceTierPickerAdapter priceTierPickerAdapter = this.adapter;
            if (priceTierPickerAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            priceTierPickerAdapter.setItems(((PriceTierPickerBottomSheetViewModel.ViewState.Loaded) viewState).getPriceTiers());
        }
    }

    private final WidgetPriceTierPickerBottomSheetBinding getBinding() {
        return (WidgetPriceTierPickerBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PriceTierPickerBottomSheetViewModel getViewModel() {
        return (PriceTierPickerBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        Observable<PriceTierPickerBottomSheetViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetPriceTierPickerBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84421());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_price_tier_picker_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new PriceTierPickerAdapter(this.itemClickListener);
        RecyclerView recyclerView = getBinding().f17386c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.priceTierPickerRecycler");
        PriceTierPickerAdapter priceTierPickerAdapter = this.adapter;
        if (priceTierPickerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(priceTierPickerAdapter);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_setup_default_padding);
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().f17386c.addItemDecoration(new C1329f(contextRequireContext, 1, 0, dimensionPixelSize, dimensionPixelSize, 4));
    }
}
