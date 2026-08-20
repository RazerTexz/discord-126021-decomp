package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifCategoryBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p000.C13173u;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Func0;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGifCategory.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifCategoryBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGifCategory.kt */
    public static final class C78761 extends AbstractC12240o implements Function1<GifCategoryViewModel.ViewState, Unit> {
        public C78761() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifCategoryViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifCategoryViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetGifCategory.this.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$setUpGifRecycler$1 */
    /* JADX INFO: compiled from: WidgetGifCategory.kt */
    public static final /* synthetic */ class C78791 extends C12236k implements Function1<GifAdapterItem.GifItem, Unit> {
        public C78791(WidgetGifCategory widgetGifCategory) {
            super(1, widgetGifCategory, WidgetGifCategory.class, "selectGif", "selectGif(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem.GifItem gifItem) {
            invoke2(gifItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifAdapterItem.GifItem gifItem) {
            C12238m.checkNotNullParameter(gifItem, "p1");
            ((WidgetGifCategory) this.receiver).selectGif(gifItem);
        }
    }

    public WidgetGifCategory() {
        super(C5419R.layout.widget_gif_category);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGifCategory$binding$2.INSTANCE, null, 2, null);
        this.expressionTrayViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ExpressionTrayViewModel.class), new C7874x11220d5d(this), new C0863f0(WidgetGifCategory$expressionTrayViewModel$2.INSTANCE));
        WidgetGifCategory$gifCategoryViewModel$2 widgetGifCategory$gifCategoryViewModel$2 = new WidgetGifCategory$gifCategoryViewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.gifCategoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GifCategoryViewModel.class), new WidgetGifCategory$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGifCategory$gifCategoryViewModel$2));
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

    private final void handleViewState(GifCategoryViewModel.ViewState viewState) {
        RecyclerView recyclerView = getBinding().f16695c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        recyclerView.setVisibility(0);
        GifLoadingView gifLoadingView = getBinding().f16696d;
        C12238m.checkNotNullExpressionValue(gifLoadingView, "binding.gifCategoryLoadingView");
        gifLoadingView.setVisibility(8);
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("gifAdapter");
        }
        gifAdapter.setItems(viewState.getGifItems());
    }

    private final void selectGif(GifAdapterItem.GifItem gifItem) {
        getGifCategoryViewModel().selectGif(gifItem);
        Function0<Unit> function0 = this.onGifSelected;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void setUpBackBehavior() {
        setOnBackPressed(new Func0<Boolean>() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory.setUpBackBehavior.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetGifCategory.this.handleBack();
                return Boolean.TRUE;
            }
        }, 0);
        getBinding().f16697e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory.setUpBackBehavior.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGifCategory.this.handleBack();
            }
        });
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(categoryColumnsCount, 1);
        RecyclerView recyclerView = getBinding().f16695c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecyclerView recyclerView2 = getBinding().f16695c;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.gifCategoryGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().f16695c;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.gifCategoryGifRecycler");
        this.gifAdapter = new GifAdapter(this, new C78791(this), companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), null, null, 24, null);
        RecyclerView recyclerView4 = getBinding().f16695c;
        C12238m.checkNotNullExpressionValue(recyclerView4, "binding.gifCategoryGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().f16695c.addItemDecoration(new C13173u(iDpToPixels, categoryColumnsCount));
    }

    private final void setUpTitle() {
        String string;
        GifCategoryItem gifCategory = getGifCategory();
        TextView textView = getBinding().f16697e;
        C12238m.checkNotNullExpressionValue(textView, "binding.gifCategoryTitle");
        if (gifCategory instanceof GifCategoryItem.Standard) {
            string = ((GifCategoryItem.Standard) gifCategory).getGifCategory().getCategoryName();
        } else {
            if (!(gifCategory instanceof GifCategoryItem.Trending)) {
                throw new NoWhenBranchMatchedException();
            }
            string = getResources().getString(C5419R.string.gif_picker_result_type_trending_gifs);
        }
        textView.setText(string);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16695c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullExpressionValue(view, "view");
                C12238m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16694b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory.setWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                ViewCompat.dispatchApplyWindowInsets(WidgetGifCategory.this.getBinding().f16695c, windowInsetsCompat);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16695c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        int iCalculateColumnCount = companion.calculateColumnCount(recyclerView);
        setUpTitle();
        setUpBackBehavior();
        setUpGifRecycler(iCalculateColumnCount);
        GifLoadingView.updateView$default(getBinding().f16696d, iCalculateColumnCount, 0, 2, null);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getGifCategoryViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGifCategory.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78761());
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        C12238m.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
