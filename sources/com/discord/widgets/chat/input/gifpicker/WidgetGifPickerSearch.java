package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.chat.input.gifpicker.GifAdapter;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.GifStaggeredGridItemDecoration;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGifPickerSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifAdapter gifAdapter;

    /* JADX INFO: renamed from: gifPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifPickerViewModel;
    private Function0<Unit> onGifSelected;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GifSearchViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifSearchViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifSearchViewModel.ViewState viewState) {
            WidgetGifPickerSearch widgetGifPickerSearch = WidgetGifPickerSearch.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetGifPickerSearch.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GifAdapterItem.GifItem, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem.GifItem gifItem) {
            invoke2(gifItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifAdapterItem.GifItem gifItem) {
            Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
            WidgetGifPickerSearch.this.getGifPickerViewModel().selectGif(gifItem);
            Function0 function0 = WidgetGifPickerSearch.this.onGifSelected;
            if (function0 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(SearchInputView searchInputView) {
            super(1, searchInputView, SearchInputView.class, "setText", "setText(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((SearchInputView) this.receiver).setText(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setupSearchBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetGifPickerSearch.this.getGifPickerViewModel().setSearchText(str);
        }
    }

    public WidgetGifPickerSearch() {
        super(R.layout.widget_gif_picker_search);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGifPickerSearch2.INSTANCE, null, 2, null);
        WidgetGifPickerSearch3 widgetGifPickerSearch3 = new WidgetGifPickerSearch3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.gifPickerViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GifSearchViewModel.class), new WidgetGifPickerSearch$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGifPickerSearch3));
    }

    private final WidgetGifPickerSearchBinding getBinding() {
        return (WidgetGifPickerSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifSearchViewModel getGifPickerViewModel() {
        return (GifSearchViewModel) this.gifPickerViewModel.getValue();
    }

    private final void handleViewState(GifSearchViewModel.ViewState viewState) {
        if (viewState instanceof GifSearchViewModel.ViewState.Loaded) {
            GifAdapter gifAdapter = this.gifAdapter;
            if (gifAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter.setItems(((GifSearchViewModel.ViewState.Loaded) viewState).getAdapterItems());
            AppViewFlipper appViewFlipper = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.gifSearchViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (Intrinsics3.areEqual(viewState, GifSearchViewModel.ViewState.LoadingSearchResults.INSTANCE)) {
            GifAdapter gifAdapter2 = this.gifAdapter;
            if (gifAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter2.clearItems();
            AppViewFlipper appViewFlipper2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.gifSearchViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        RecyclerView recyclerView = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(categoryColumnsCount, 1));
        RecyclerView recyclerView2 = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.gifSearchGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.gifSearchGifRecycler");
        this.gifAdapter = new GifAdapter(this, anonymousClass1, companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), new AnonymousClass2(getBinding().e), null, 16, null);
        RecyclerView recyclerView4 = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.gifSearchGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().f2402b.addItemDecoration(new GifStaggeredGridItemDecoration(iDpToPixels, categoryColumnsCount));
    }

    private final void setupSearchBar() {
        getBinding().e.a(this, new AnonymousClass1());
    }

    public final void clearSearchBar() {
        getGifPickerViewModel().setSearchText("");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        int iCalculateColumnCount = companion.calculateColumnCount(recyclerView);
        setUpGifRecycler(iCalculateColumnCount);
        setupSearchBar();
        GifLoadingView.updateView$default(getBinding().c, iCalculateColumnCount, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().e.binding.c.requestFocus();
        Observable<GifSearchViewModel.ViewState> observableR = getGifPickerViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "gifPickerViewModel\n     …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetGifPickerSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        Intrinsics3.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
