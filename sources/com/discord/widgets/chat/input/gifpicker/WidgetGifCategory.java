package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifCategoryBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import d0.z.d.a0;
import d0.z.d.m;
import defpackage.u;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifCategory extends AppFragment {
    public static final String ARG_GIF_CATEGORY_ITEM = "GIF_CATEGORY_ITEM";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: expressionTrayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy expressionTrayViewModel;
    private GifAdapter gifAdapter;

    /* JADX INFO: renamed from: gifCategoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifCategoryViewModel;
    private Function0<Unit> onGifSelected;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGifCategory.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifCategoryBinding;", 0)};
    public static final WidgetGifCategory$Companion Companion = new WidgetGifCategory$Companion(null);

    public WidgetGifCategory() {
        super(R$layout.widget_gif_category);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGifCategory$binding$2.INSTANCE, null, 2, null);
        this.expressionTrayViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ExpressionTrayViewModel.class), new WidgetGifCategory$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetGifCategory$expressionTrayViewModel$2.INSTANCE));
        WidgetGifCategory$gifCategoryViewModel$2 widgetGifCategory$gifCategoryViewModel$2 = new WidgetGifCategory$gifCategoryViewModel$2(this);
        g0 g0Var = new g0(this);
        this.gifCategoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GifCategoryViewModel.class), new WidgetGifCategory$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGifCategory$gifCategoryViewModel$2));
    }

    public static final /* synthetic */ WidgetGifCategoryBinding access$getBinding$p(WidgetGifCategory widgetGifCategory) {
        return widgetGifCategory.getBinding();
    }

    public static final /* synthetic */ GifCategoryItem access$getGifCategory(WidgetGifCategory widgetGifCategory) {
        return widgetGifCategory.getGifCategory();
    }

    public static final /* synthetic */ void access$handleBack(WidgetGifCategory widgetGifCategory) {
        widgetGifCategory.handleBack();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifCategory widgetGifCategory, GifCategoryViewModel$ViewState gifCategoryViewModel$ViewState) {
        widgetGifCategory.handleViewState(gifCategoryViewModel$ViewState);
    }

    public static final /* synthetic */ void access$selectGif(WidgetGifCategory widgetGifCategory, GifAdapterItem$GifItem gifAdapterItem$GifItem) {
        widgetGifCategory.selectGif(gifAdapterItem$GifItem);
    }

    private final WidgetGifCategoryBinding getBinding() {
        return (WidgetGifCategoryBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ExpressionTrayViewModel getExpressionTrayViewModel() {
        return (ExpressionTrayViewModel) this.expressionTrayViewModel.getValue();
    }

    private final GifCategoryItem getGifCategory() {
        Serializable serializable = requireArguments().getSerializable(ARG_GIF_CATEGORY_ITEM);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.chat.input.gifpicker.GifCategoryItem");
        return (GifCategoryItem) serializable;
    }

    private final GifCategoryViewModel getGifCategoryViewModel() {
        return (GifCategoryViewModel) this.gifCategoryViewModel.getValue();
    }

    private final void handleBack() {
        getExpressionTrayViewModel().clickBack();
    }

    private final void handleViewState(GifCategoryViewModel$ViewState viewState) {
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        recyclerView.setVisibility(0);
        GifLoadingView gifLoadingView = getBinding().d;
        m.checkNotNullExpressionValue(gifLoadingView, "binding.gifCategoryLoadingView");
        gifLoadingView.setVisibility(8);
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            m.throwUninitializedPropertyAccessException("gifAdapter");
        }
        gifAdapter.setItems(viewState.getGifItems());
    }

    private final void selectGif(GifAdapterItem$GifItem gifItem) {
        getGifCategoryViewModel().selectGif(gifItem);
        Function0<Unit> function0 = this.onGifSelected;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void setUpBackBehavior() {
        setOnBackPressed(new WidgetGifCategory$setUpBackBehavior$1(this), 0);
        getBinding().e.setOnClickListener(new WidgetGifCategory$setUpBackBehavior$2(this));
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(categoryColumnsCount, 1);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecyclerView recyclerView2 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.gifCategoryGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        GifAdapter$Companion gifAdapter$Companion = GifAdapter.Companion;
        RecyclerView recyclerView3 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView3, "binding.gifCategoryGifRecycler");
        this.gifAdapter = new GifAdapter(this, new WidgetGifCategory$setUpGifRecycler$1(this), gifAdapter$Companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), null, null, 24, null);
        RecyclerView recyclerView4 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView4, "binding.gifCategoryGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            m.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().c.addItemDecoration(new u(iDpToPixels, categoryColumnsCount));
    }

    private final void setUpTitle() {
        String string;
        GifCategoryItem gifCategory = getGifCategory();
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.gifCategoryTitle");
        if (gifCategory instanceof GifCategoryItem$Standard) {
            string = ((GifCategoryItem$Standard) gifCategory).getGifCategory().getCategoryName();
        } else {
            if (!(gifCategory instanceof GifCategoryItem$Trending)) {
                throw new NoWhenBranchMatchedException();
            }
            string = getResources().getString(2131889628);
        }
        textView.setText(string);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, WidgetGifCategory$setWindowInsetsListeners$1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2400b, new WidgetGifCategory$setWindowInsetsListeners$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter$Companion gifAdapter$Companion = GifAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        int iCalculateColumnCount = gifAdapter$Companion.calculateColumnCount(recyclerView);
        setUpTitle();
        setUpBackBehavior();
        setUpGifRecycler(iCalculateColumnCount);
        GifLoadingView.updateView$default(getBinding().d, iCalculateColumnCount, 0, 2, null);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getGifCategoryViewModel().observeViewState(), this, null, 2, null), WidgetGifCategory.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGifCategory$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        m.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
