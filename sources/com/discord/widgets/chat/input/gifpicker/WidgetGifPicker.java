package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifPickerBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPicker extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGifPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifCategoryAdapter categoryAdapter;
    private Function1<? super GifCategoryItem, Unit> onSelectGifCategory;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGifPicker.kt */
    public static final class C78821 extends AbstractC12240o implements Function1<GifPickerViewModel.ViewState, Unit> {
        public C78821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifPickerViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifPickerViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetGifPicker.this.handleViewState(viewState);
        }
    }

    public WidgetGifPicker() {
        super(C5419R.layout.widget_gif_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGifPicker$binding$2.INSTANCE, null, 2, null);
        WidgetGifPicker$viewModel$2 widgetGifPicker$viewModel$2 = WidgetGifPicker$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GifPickerViewModel.class), new WidgetGifPicker$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGifPicker$viewModel$2));
    }

    private final WidgetGifPickerBinding getBinding() {
        return (WidgetGifPickerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifPickerViewModel getViewModel() {
        return (GifPickerViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(GifPickerViewModel.ViewState viewState) {
        RecyclerView recyclerView = getBinding().f16699b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setVisibility(viewState.getIsLoaded() ? 0 : 8);
        GifLoadingView gifLoadingView = getBinding().f16701d;
        C12238m.checkNotNullExpressionValue(gifLoadingView, "binding.gifPickerLoadingView");
        gifLoadingView.setVisibility(viewState.getIsLoaded() ^ true ? 0 : 8);
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        gifCategoryAdapter.setItems(viewState.getGifCategoryItems());
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().f16699b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecyclerView recyclerView2 = getBinding().f16699b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.gifPickerCategoryRecycler");
        recyclerView2.setItemAnimator(null);
        this.categoryAdapter = new GifCategoryAdapter(this, this.onSelectGifCategory, null, 4, null);
        RecyclerView recyclerView3 = getBinding().f16699b;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.gifPickerCategoryRecycler");
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView3.setAdapter(gifCategoryAdapter);
        getBinding().f16699b.addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), 2));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16699b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullExpressionValue(view, "view");
                C12238m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16701d, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker.setWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullExpressionValue(view, "view");
                C12238m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16700c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker.setWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.this.getBinding().f16699b, windowInsetsCompat);
                ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.this.getBinding().f16701d, windowInsetsCompat);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpCategoryRecycler();
        setWindowInsetsListeners();
        GifLoadingView.updateView$default(getBinding().f16701d, 2, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78821());
    }

    public final void scrollToTop() {
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        if (gifCategoryAdapter.getPageSize() > 0) {
            getBinding().f16699b.scrollToPosition(0);
        }
    }

    public final void setOnSelectGifCategory(Function1<? super GifCategoryItem, Unit> onGifCategorySelected) {
        C12238m.checkNotNullParameter(onGifCategorySelected, "onGifCategorySelected");
        this.onSelectGifCategory = onGifCategorySelected;
    }
}
