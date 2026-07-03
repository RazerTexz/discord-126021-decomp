package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import com.discord.widgets.chat.input.gifpicker.GifAdapter;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p000.C13173u;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGifPickerSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifAdapter gifAdapter;

    /* JADX INFO: renamed from: gifPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifPickerViewModel;
    private Function0<Unit> onGifSelected;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final class C78861 extends AbstractC12240o implements Function1<GifSearchViewModel.ViewState, Unit> {
        public C78861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifSearchViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifSearchViewModel.ViewState viewState) {
            WidgetGifPickerSearch widgetGifPickerSearch = WidgetGifPickerSearch.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetGifPickerSearch.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$1 */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final class C78871 extends AbstractC12240o implements Function1<GifAdapterItem.GifItem, Unit> {
        public C78871() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem.GifItem gifItem) {
            invoke2(gifItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifAdapterItem.GifItem gifItem) {
            C12238m.checkNotNullParameter(gifItem, "gifItem");
            WidgetGifPickerSearch.this.getGifPickerViewModel().selectGif(gifItem);
            Function0 function0 = WidgetGifPickerSearch.this.onGifSelected;
            if (function0 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$2 */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final /* synthetic */ class C78882 extends C12236k implements Function1<String, Unit> {
        public C78882(SearchInputView searchInputView) {
            super(1, searchInputView, SearchInputView.class, "setText", "setText(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((SearchInputView) this.receiver).setText(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setupSearchBar$1 */
    /* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
    public static final class C78891 extends AbstractC12240o implements Function1<String, Unit> {
        public C78891() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "searchQuery");
            WidgetGifPickerSearch.this.getGifPickerViewModel().setSearchText(str);
        }
    }

    public WidgetGifPickerSearch() {
        super(C5419R.layout.widget_gif_picker_search);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGifPickerSearch$binding$2.INSTANCE, null, 2, null);
        WidgetGifPickerSearch$gifPickerViewModel$2 widgetGifPickerSearch$gifPickerViewModel$2 = new WidgetGifPickerSearch$gifPickerViewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.gifPickerViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GifSearchViewModel.class), new WidgetGifPickerSearch$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGifPickerSearch$gifPickerViewModel$2));
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
                C12238m.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter.setItems(((GifSearchViewModel.ViewState.Loaded) viewState).getAdapterItems());
            AppViewFlipper appViewFlipper = getBinding().f16705d;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.gifSearchViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (C12238m.areEqual(viewState, GifSearchViewModel.ViewState.LoadingSearchResults.INSTANCE)) {
            GifAdapter gifAdapter2 = this.gifAdapter;
            if (gifAdapter2 == null) {
                C12238m.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter2.clearItems();
            AppViewFlipper appViewFlipper2 = getBinding().f16705d;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.gifSearchViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        RecyclerView recyclerView = getBinding().f16703b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(categoryColumnsCount, 1));
        RecyclerView recyclerView2 = getBinding().f16703b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.gifSearchGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        C78871 c78871 = new C78871();
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().f16703b;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.gifSearchGifRecycler");
        this.gifAdapter = new GifAdapter(this, c78871, companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), new C78882(getBinding().f16706e), null, 16, null);
        RecyclerView recyclerView4 = getBinding().f16703b;
        C12238m.checkNotNullExpressionValue(recyclerView4, "binding.gifSearchGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().f16703b.addItemDecoration(new C13173u(iDpToPixels, categoryColumnsCount));
    }

    private final void setupSearchBar() {
        getBinding().f16706e.m8553a(this, new C78891());
    }

    public final void clearSearchBar() {
        getGifPickerViewModel().setSearchText("");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16703b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        int iCalculateColumnCount = companion.calculateColumnCount(recyclerView);
        setUpGifRecycler(iCalculateColumnCount);
        setupSearchBar();
        GifLoadingView.updateView$default(getBinding().f16704c, iCalculateColumnCount, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f16706e.binding.f971c.requestFocus();
        Observable<GifSearchViewModel.ViewState> observableM11112r = getGifPickerViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "gifPickerViewModel\n     …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetGifPickerSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78861());
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        C12238m.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
