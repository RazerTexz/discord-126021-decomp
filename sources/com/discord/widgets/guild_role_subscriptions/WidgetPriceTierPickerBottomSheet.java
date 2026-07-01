package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.y.f;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPriceTierPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0)};
    public static final WidgetPriceTierPickerBottomSheet$Companion Companion = new WidgetPriceTierPickerBottomSheet$Companion(null);

    public WidgetPriceTierPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPriceTierPickerBottomSheet$binding$2.INSTANCE, null, 2, null);
        WidgetPriceTierPickerBottomSheet$viewModel$2 widgetPriceTierPickerBottomSheet$viewModel$2 = WidgetPriceTierPickerBottomSheet$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(PriceTierPickerBottomSheetViewModel.class), new WidgetPriceTierPickerBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetPriceTierPickerBottomSheet$viewModel$2));
        this.itemClickListener = new WidgetPriceTierPickerBottomSheet$itemClickListener$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet, PriceTierPickerBottomSheetViewModel$ViewState priceTierPickerBottomSheetViewModel$ViewState) {
        widgetPriceTierPickerBottomSheet.configureUI(priceTierPickerBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        return widgetPriceTierPickerBottomSheet.getArgumentsOrDefault();
    }

    private final void configureUI(PriceTierPickerBottomSheetViewModel$ViewState viewState) {
        if (viewState instanceof PriceTierPickerBottomSheetViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2513b;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.priceTierPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            if (!(viewState instanceof PriceTierPickerBottomSheetViewModel$ViewState$Loaded)) {
                if (viewState instanceof PriceTierPickerBottomSheetViewModel$ViewState$Failed) {
                    b.a.d.m.g(requireContext(), 2131888366, 0, null, 12);
                    dismiss();
                    return;
                }
                return;
            }
            AppViewFlipper appViewFlipper2 = getBinding().f2513b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.priceTierPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            PriceTierPickerAdapter priceTierPickerAdapter = this.adapter;
            if (priceTierPickerAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            priceTierPickerAdapter.setItems(((PriceTierPickerBottomSheetViewModel$ViewState$Loaded) viewState).getPriceTiers());
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
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        Observable<PriceTierPickerBottomSheetViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetPriceTierPickerBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPriceTierPickerBottomSheet$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_price_tier_picker_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new PriceTierPickerAdapter(this.itemClickListener);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.priceTierPickerRecycler");
        PriceTierPickerAdapter priceTierPickerAdapter = this.adapter;
        if (priceTierPickerAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(priceTierPickerAdapter);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165456);
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().c.addItemDecoration(new f(contextRequireContext, 1, 0, dimensionPixelSize, dimensionPixelSize, 4));
    }
}
