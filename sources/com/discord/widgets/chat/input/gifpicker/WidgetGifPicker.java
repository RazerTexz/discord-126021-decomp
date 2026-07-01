package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifPickerBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
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

/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPicker extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGifPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifCategoryAdapter categoryAdapter;
    private Function1<? super GifCategoryItem, Unit> onSelectGifCategory;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGifPicker() {
        super(R$layout.widget_gif_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGifPicker$binding$2.INSTANCE, null, 2, null);
        WidgetGifPicker$viewModel$2 widgetGifPicker$viewModel$2 = WidgetGifPicker$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GifPickerViewModel.class), new WidgetGifPicker$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGifPicker$viewModel$2));
    }

    public static final /* synthetic */ WidgetGifPickerBinding access$getBinding$p(WidgetGifPicker widgetGifPicker) {
        return widgetGifPicker.getBinding();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifPicker widgetGifPicker, GifPickerViewModel$ViewState gifPickerViewModel$ViewState) {
        widgetGifPicker.handleViewState(gifPickerViewModel$ViewState);
    }

    private final WidgetGifPickerBinding getBinding() {
        return (WidgetGifPickerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifPickerViewModel getViewModel() {
        return (GifPickerViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(GifPickerViewModel$ViewState viewState) {
        RecyclerView recyclerView = getBinding().f2401b;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setVisibility(viewState.getIsLoaded() ? 0 : 8);
        GifLoadingView gifLoadingView = getBinding().d;
        m.checkNotNullExpressionValue(gifLoadingView, "binding.gifPickerLoadingView");
        gifLoadingView.setVisibility(viewState.getIsLoaded() ^ true ? 0 : 8);
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        gifCategoryAdapter.setItems(viewState.getGifCategoryItems());
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().f2401b;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecyclerView recyclerView2 = getBinding().f2401b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.gifPickerCategoryRecycler");
        recyclerView2.setItemAnimator(null);
        this.categoryAdapter = new GifCategoryAdapter(this, this.onSelectGifCategory, null, 4, null);
        RecyclerView recyclerView3 = getBinding().f2401b;
        m.checkNotNullExpressionValue(recyclerView3, "binding.gifPickerCategoryRecycler");
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView3.setAdapter(gifCategoryAdapter);
        getBinding().f2401b.addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), 2));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2401b, WidgetGifPicker$setWindowInsetsListeners$1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, WidgetGifPicker$setWindowInsetsListeners$2.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new WidgetGifPicker$setWindowInsetsListeners$3(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpCategoryRecycler();
        setWindowInsetsListeners();
        GifLoadingView.updateView$default(getBinding().d, 2, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGifPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGifPicker$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    public final void scrollToTop() {
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        if (gifCategoryAdapter.getItemCount() > 0) {
            getBinding().f2401b.scrollToPosition(0);
        }
    }

    public final void setOnSelectGifCategory(Function1<? super GifCategoryItem, Unit> onGifCategorySelected) {
        m.checkNotNullParameter(onGifCategorySelected, "onGifCategorySelected");
        this.onSelectGifCategory = onGifCategorySelected;
    }
}
