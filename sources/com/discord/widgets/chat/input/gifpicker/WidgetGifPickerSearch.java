package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import defpackage.u;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGifPickerSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifAdapter gifAdapter;

    /* JADX INFO: renamed from: gifPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifPickerViewModel;
    private Function0<Unit> onGifSelected;

    public WidgetGifPickerSearch() {
        super(R$layout.widget_gif_picker_search);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGifPickerSearch$binding$2.INSTANCE, null, 2, null);
        WidgetGifPickerSearch$gifPickerViewModel$2 widgetGifPickerSearch$gifPickerViewModel$2 = new WidgetGifPickerSearch$gifPickerViewModel$2(this);
        g0 g0Var = new g0(this);
        this.gifPickerViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GifSearchViewModel.class), new WidgetGifPickerSearch$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGifPickerSearch$gifPickerViewModel$2));
    }

    public static final /* synthetic */ GifSearchViewModel access$getGifPickerViewModel$p(WidgetGifPickerSearch widgetGifPickerSearch) {
        return widgetGifPickerSearch.getGifPickerViewModel();
    }

    public static final /* synthetic */ Function0 access$getOnGifSelected$p(WidgetGifPickerSearch widgetGifPickerSearch) {
        return widgetGifPickerSearch.onGifSelected;
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifPickerSearch widgetGifPickerSearch, GifSearchViewModel$ViewState gifSearchViewModel$ViewState) {
        widgetGifPickerSearch.handleViewState(gifSearchViewModel$ViewState);
    }

    public static final /* synthetic */ void access$setOnGifSelected$p(WidgetGifPickerSearch widgetGifPickerSearch, Function0 function0) {
        widgetGifPickerSearch.onGifSelected = function0;
    }

    private final WidgetGifPickerSearchBinding getBinding() {
        return (WidgetGifPickerSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifSearchViewModel getGifPickerViewModel() {
        return (GifSearchViewModel) this.gifPickerViewModel.getValue();
    }

    private final void handleViewState(GifSearchViewModel$ViewState viewState) {
        if (viewState instanceof GifSearchViewModel$ViewState$Loaded) {
            GifAdapter gifAdapter = this.gifAdapter;
            if (gifAdapter == null) {
                m.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter.setItems(((GifSearchViewModel$ViewState$Loaded) viewState).getAdapterItems());
            AppViewFlipper appViewFlipper = getBinding().d;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.gifSearchViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (m.areEqual(viewState, GifSearchViewModel$ViewState$LoadingSearchResults.INSTANCE)) {
            GifAdapter gifAdapter2 = this.gifAdapter;
            if (gifAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter2.clearItems();
            AppViewFlipper appViewFlipper2 = getBinding().d;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.gifSearchViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        RecyclerView recyclerView = getBinding().f2402b;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(categoryColumnsCount, 1));
        RecyclerView recyclerView2 = getBinding().f2402b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.gifSearchGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        WidgetGifPickerSearch$setUpGifRecycler$1 widgetGifPickerSearch$setUpGifRecycler$1 = new WidgetGifPickerSearch$setUpGifRecycler$1(this);
        GifAdapter$Companion gifAdapter$Companion = GifAdapter.Companion;
        RecyclerView recyclerView3 = getBinding().f2402b;
        m.checkNotNullExpressionValue(recyclerView3, "binding.gifSearchGifRecycler");
        this.gifAdapter = new GifAdapter(this, widgetGifPickerSearch$setUpGifRecycler$1, gifAdapter$Companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), new WidgetGifPickerSearch$setUpGifRecycler$2(getBinding().e), null, 16, null);
        RecyclerView recyclerView4 = getBinding().f2402b;
        m.checkNotNullExpressionValue(recyclerView4, "binding.gifSearchGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            m.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().f2402b.addItemDecoration(new u(iDpToPixels, categoryColumnsCount));
    }

    private final void setupSearchBar() {
        getBinding().e.a(this, new WidgetGifPickerSearch$setupSearchBar$1(this));
    }

    public final void clearSearchBar() {
        getGifPickerViewModel().setSearchText("");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter$Companion gifAdapter$Companion = GifAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2402b;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        int iCalculateColumnCount = gifAdapter$Companion.calculateColumnCount(recyclerView);
        setUpGifRecycler(iCalculateColumnCount);
        setupSearchBar();
        GifLoadingView.updateView$default(getBinding().c, iCalculateColumnCount, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().e.binding.c.requestFocus();
        Observable<GifSearchViewModel$ViewState> observableR = getGifPickerViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "gifPickerViewModel\n     …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGifPickerSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGifPickerSearch$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        m.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
