package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifPickerBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.gifpicker.GifPickerViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPicker extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGifPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifCategoryAdapter categoryAdapter;
    private Function1<? super GifCategoryItem, Unit> onSelectGifCategory;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGifPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GifPickerViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifPickerViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifPickerViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGifPicker.this.handleViewState(viewState);
        }
    }

    public WidgetGifPicker() {
        super(R.layout.widget_gif_picker);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGifPicker2.INSTANCE, null, 2, null);
        WidgetGifPicker3 widgetGifPicker3 = WidgetGifPicker3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GifPickerViewModel.class), new WidgetGifPicker$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGifPicker3));
    }

    private final WidgetGifPickerBinding getBinding() {
        return (WidgetGifPickerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifPickerViewModel getViewModel() {
        return (GifPickerViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(GifPickerViewModel.ViewState viewState) {
        RecyclerView recyclerView = getBinding().f2401b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setVisibility(viewState.getIsLoaded() ? 0 : 8);
        GifLoadingView gifLoadingView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(gifLoadingView, "binding.gifPickerLoadingView");
        gifLoadingView.setVisibility(viewState.getIsLoaded() ^ true ? 0 : 8);
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        gifCategoryAdapter.setItems(viewState.getGifCategoryItems());
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().f2401b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecyclerView recyclerView2 = getBinding().f2401b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.gifPickerCategoryRecycler");
        recyclerView2.setItemAnimator(null);
        this.categoryAdapter = new GifCategoryAdapter(this, this.onSelectGifCategory, null, 4, null);
        RecyclerView recyclerView3 = getBinding().f2401b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.gifPickerCategoryRecycler");
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView3.setAdapter(gifCategoryAdapter);
        getBinding().f2401b.addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), 2));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2401b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker.setWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker.setWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.this.getBinding().f2401b, windowInsetsCompat);
                ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.this.getBinding().d, windowInsetsCompat);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpCategoryRecycler();
        setWindowInsetsListeners();
        GifLoadingView.updateView$default(getBinding().d, 2, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void scrollToTop() {
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        if (gifCategoryAdapter.getPageSize() > 0) {
            getBinding().f2401b.scrollToPosition(0);
        }
    }

    public final void setOnSelectGifCategory(Function1<? super GifCategoryItem, Unit> onGifCategorySelected) {
        Intrinsics3.checkNotNullParameter(onGifCategorySelected, "onGifCategorySelected");
        this.onSelectGifCategory = onGifCategorySelected;
    }
}
