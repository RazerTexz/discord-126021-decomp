package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.b.a.c;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetStickerPickerBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsTracker$PremiumUpsellType;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.recycler.SpeedOnScrollListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$Companion;
import com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog;
import com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog$Companion;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$Companion;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$LayoutParams;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import j0.l.e.k;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker extends AppFragment implements c {
    public static final String ARG_MODE = "MODE";
    private static final int STICKER_PICKER_VIEW_FLIPPER_EMPTY_STATE = 1;
    private static final int STICKER_PICKER_VIEW_FLIPPER_EMPTY_STATE_PHASE_1 = 2;
    private static final int STICKER_PICKER_VIEW_FLIPPER_RESULTS = 0;
    public static final String VIEW_TYPE = "VIEW_TYPE";
    private Long autoscrollToPackId;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean canHandleIsShown;
    private StickerCategoryAdapter categoryAdapter;
    private LinearLayoutManager categoryLayoutManager;

    /* JADX INFO: renamed from: initialStickerPackId$delegate, reason: from kotlin metadata */
    private final Lazy initialStickerPackId;
    private OnBackspacePressedListener onBackspacePressedListener;
    private StickerPickerViewModel$ViewState previousViewState;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private boolean restoredSearchQueryFromViewModel;
    private Function0<Unit> scrollExpressionPickerToTop;
    private Function1<? super Boolean, Unit> showSearchBar;
    private WidgetStickerAdapter stickerAdapter;
    private final PublishSubject<Unit> stickerCategoryScrollSubject;
    private StickerPickerListener stickerPickerListener;
    private StickerPickerMode stickerPickerMode;

    /* JADX INFO: renamed from: viewModelForInline$delegate, reason: from kotlin metadata */
    private final Lazy viewModelForInline;

    /* JADX INFO: renamed from: viewModelForSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelForSheet;
    private boolean wasActive;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStickerPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerPickerBinding;", 0)};
    public static final WidgetStickerPicker$Companion Companion = new WidgetStickerPicker$Companion(null);

    public WidgetStickerPicker() {
        super(R$layout.widget_sticker_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerPicker$binding$2.INSTANCE, null, 2, null);
        this.initialStickerPackId = g.lazy(new WidgetStickerPicker$initialStickerPackId$2(this));
        this.viewModelForInline = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StickerPickerInlineViewModel.class), new WidgetStickerPicker$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetStickerPicker$viewModelForInline$2(this)));
        this.viewModelForSheet = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StickerPickerSheetViewModel.class), new WidgetStickerPicker$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetStickerPicker$viewModelForSheet$2(this)));
        this.scrollExpressionPickerToTop = WidgetStickerPicker$scrollExpressionPickerToTop$1.INSTANCE;
        this.stickerCategoryScrollSubject = PublishSubject.k0();
        this.recyclerScrollingWithinThresholdSubject = BehaviorSubject.l0(Boolean.TRUE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPicker widgetStickerPicker, StickerPickerViewModel$ViewState stickerPickerViewModel$ViewState) {
        widgetStickerPicker.configureUI(stickerPickerViewModel$ViewState);
    }

    public static final /* synthetic */ int access$getAdditionalBottomPaddingPx(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.getAdditionalBottomPaddingPx();
    }

    public static final /* synthetic */ WidgetStickerPickerBinding access$getBinding$p(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.getBinding();
    }

    public static final /* synthetic */ Long access$getInitialStickerPackId$p(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.getInitialStickerPackId();
    }

    public static final /* synthetic */ BehaviorSubject access$getRecyclerScrollingWithinThresholdSubject$p(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.recyclerScrollingWithinThresholdSubject;
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getStickerAdapter$p(WidgetStickerPicker widgetStickerPicker) {
        WidgetStickerAdapter widgetStickerAdapter = widgetStickerPicker.stickerAdapter;
        if (widgetStickerAdapter == null) {
            m.throwUninitializedPropertyAccessException("stickerAdapter");
        }
        return widgetStickerAdapter;
    }

    public static final /* synthetic */ PublishSubject access$getStickerCategoryScrollSubject$p(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.stickerCategoryScrollSubject;
    }

    public static final /* synthetic */ StickerPickerMode access$getStickerPickerMode$p(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.stickerPickerMode;
    }

    public static final /* synthetic */ StickerPickerViewModel access$getViewModel$p(WidgetStickerPicker widgetStickerPicker) {
        return widgetStickerPicker.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStickerPicker widgetStickerPicker, StickerPickerViewModel$Event stickerPickerViewModel$Event) {
        widgetStickerPicker.handleEvent(stickerPickerViewModel$Event);
    }

    public static final /* synthetic */ void access$handleNewStickerRecyclerScrollPosition(WidgetStickerPicker widgetStickerPicker, int i, List list) {
        widgetStickerPicker.handleNewStickerRecyclerScrollPosition(i, list);
    }

    public static final /* synthetic */ void access$launchBottomSheet(WidgetStickerPicker widgetStickerPicker) {
        widgetStickerPicker.launchBottomSheet();
    }

    public static final /* synthetic */ void access$onGuildClicked(WidgetStickerPicker widgetStickerPicker, StickerCategoryItem$GuildItem stickerCategoryItem$GuildItem) {
        widgetStickerPicker.onGuildClicked(stickerCategoryItem$GuildItem);
    }

    public static final /* synthetic */ void access$onPackClicked(WidgetStickerPicker widgetStickerPicker, StickerCategoryItem$PackItem stickerCategoryItem$PackItem) {
        widgetStickerPicker.onPackClicked(stickerCategoryItem$PackItem);
    }

    public static final /* synthetic */ void access$onRecentClicked(WidgetStickerPicker widgetStickerPicker) {
        widgetStickerPicker.onRecentClicked();
    }

    public static final /* synthetic */ void access$onSelectedCategoryAdapterPositionUpdated(WidgetStickerPicker widgetStickerPicker, int i) {
        widgetStickerPicker.onSelectedCategoryAdapterPositionUpdated(i);
    }

    public static final /* synthetic */ void access$onStickerHeaderItemsClicked(WidgetStickerPicker widgetStickerPicker, StoreHeaderItem storeHeaderItem) {
        widgetStickerPicker.onStickerHeaderItemsClicked(storeHeaderItem);
    }

    public static final /* synthetic */ void access$onStickerItemSelected(WidgetStickerPicker widgetStickerPicker, StickerItem stickerItem) {
        widgetStickerPicker.onStickerItemSelected(stickerItem);
    }

    public static final /* synthetic */ void access$setStickerAdapter$p(WidgetStickerPicker widgetStickerPicker, WidgetStickerAdapter widgetStickerAdapter) {
        widgetStickerPicker.stickerAdapter = widgetStickerAdapter;
    }

    public static final /* synthetic */ void access$setStickerPickerMode$p(WidgetStickerPicker widgetStickerPicker, StickerPickerMode stickerPickerMode) {
        widgetStickerPicker.stickerPickerMode = stickerPickerMode;
    }

    private final void configureUI(StickerPickerViewModel$ViewState viewState) {
        String searchQuery = viewState != null ? viewState.getSearchQuery() : null;
        if (!this.restoredSearchQueryFromViewModel && searchQuery != null) {
            this.restoredSearchQueryFromViewModel = true;
            getBinding().r.setText(searchQuery);
        }
        if (viewState == null) {
            return;
        }
        if (viewState instanceof StickerPickerViewModel$ViewState$EmptyNonPremium) {
            if (this.wasActive && ((StickerPickerViewModel$ViewState$EmptyNonPremium) viewState).isStickersSelectedTab()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.EmptyStickerPickerUpsell, new Traits$Location(null, Traits$Location$Section.EMPTY_STICKER_PICKER_UPSELL, null, null, null, 29, null), null, null, 12, null);
            }
            AppViewFlipper appViewFlipper = getBinding().l;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputStickerPickerViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            Function1<? super Boolean, Unit> function1 = this.showSearchBar;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            this.scrollExpressionPickerToTop.invoke();
            StickerPickerViewModel$ViewState$EmptyNonPremium stickerPickerViewModel$ViewState$EmptyNonPremium = (StickerPickerViewModel$ViewState$EmptyNonPremium) viewState;
            if (stickerPickerViewModel$ViewState$EmptyNonPremium.getEmptyStateStickers().size() >= 4) {
                StickerView.e(getBinding().d, stickerPickerViewModel$ViewState$EmptyNonPremium.getEmptyStateStickers().get(0), null, 2);
                StickerView.e(getBinding().e, stickerPickerViewModel$ViewState$EmptyNonPremium.getEmptyStateStickers().get(1), null, 2);
                StickerView.e(getBinding().f, stickerPickerViewModel$ViewState$EmptyNonPremium.getEmptyStateStickers().get(2), null, 2);
                StickerView.e(getBinding().g, stickerPickerViewModel$ViewState$EmptyNonPremium.getEmptyStateStickers().get(3), null, 2);
            }
            showCategoryBottomBar(false);
        } else if (viewState instanceof StickerPickerViewModel$ViewState$EmptySearchResults) {
            AppViewFlipper appViewFlipper2 = getBinding().l;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.chatInputStickerPickerViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            Function1<? super Boolean, Unit> function2 = this.showSearchBar;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE);
            }
            this.scrollExpressionPickerToTop.invoke();
            getBinding().f2661b.setImageResource(2131232448);
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.chatInputStickerPickerEmptyTitle");
            textView.setVisibility(8);
            TextView textView2 = getBinding().i;
            m.checkNotNullExpressionValue(textView2, "binding.chatInputStickerPickerEmptySubtitle");
            textView2.setText(getString(2131893283));
            LinkifiedTextView linkifiedTextView = getBinding().c;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatInputStickerPickerEmptyLink");
            linkifiedTextView.setVisibility(8);
            showCategoryBottomBar(true);
            StickerCategoryAdapter stickerCategoryAdapter = this.categoryAdapter;
            if (stickerCategoryAdapter == null) {
                m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            stickerCategoryAdapter.setItems(((StickerPickerViewModel$ViewState$EmptySearchResults) viewState).getCategoryItems());
        } else if (viewState instanceof StickerPickerViewModel$ViewState$Stickers) {
            AppViewFlipper appViewFlipper3 = getBinding().l;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.chatInputStickerPickerViewFlipper");
            appViewFlipper3.setDisplayedChild(0);
            Function1<? super Boolean, Unit> function3 = this.showSearchBar;
            if (function3 != null) {
                function3.invoke(Boolean.TRUE);
            }
            WidgetStickerAdapter widgetStickerAdapter = this.stickerAdapter;
            if (widgetStickerAdapter == null) {
                m.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            StickerPickerViewModel$ViewState$Stickers stickerPickerViewModel$ViewState$Stickers = (StickerPickerViewModel$ViewState$Stickers) viewState;
            widgetStickerAdapter.setData(stickerPickerViewModel$ViewState$Stickers.getStickerItems());
            SearchInputView searchInputView = getBinding().r;
            m.checkNotNullExpressionValue(searchInputView, "binding.stickerSearchInput");
            searchInputView.setVisibility(this.stickerPickerMode != StickerPickerMode.INLINE ? 0 : 8);
            WidgetStickerAdapter widgetStickerAdapter2 = this.stickerAdapter;
            if (widgetStickerAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            widgetStickerAdapter2.setOnScrollPositionListener(new WidgetStickerPicker$configureUI$1(this, viewState));
            WidgetStickerAdapter widgetStickerAdapter3 = this.stickerAdapter;
            if (widgetStickerAdapter3 == null) {
                m.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            widgetStickerAdapter3.setOnScrollListener(null);
            showCategoryBottomBar(true);
            StickerCategoryAdapter stickerCategoryAdapter2 = this.categoryAdapter;
            if (stickerCategoryAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            stickerCategoryAdapter2.setItems(stickerPickerViewModel$ViewState$Stickers.getCategoryItems());
            if (this.stickerPickerMode == StickerPickerMode.BOTTOM_SHEET) {
                RecyclerView recyclerView = getBinding().k;
                m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
                ViewGroup$LayoutParams layoutParams = recyclerView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
                frameLayout$LayoutParams.topMargin = DimenUtils.dpToPixels(72);
                RecyclerView recyclerView2 = getBinding().k;
                m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputStickerPickerRecycler");
                recyclerView2.setLayoutParams(frameLayout$LayoutParams);
            }
        }
        this.previousViewState = viewState;
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build$VERSION.SDK_INT >= 29) {
            return DimenUtils.dpToPixels(8);
        }
        return 0;
    }

    private final WidgetStickerPickerBinding getBinding() {
        return (WidgetStickerPickerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getInitialStickerPackId() {
        return (Long) this.initialStickerPackId.getValue();
    }

    private final StickerPickerMode getMode() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("MODE") : null;
        StickerPickerMode stickerPickerMode = (StickerPickerMode) (serializable instanceof StickerPickerMode ? serializable : null);
        return stickerPickerMode != null ? stickerPickerMode : StickerPickerMode.INLINE;
    }

    private final StickerPickerViewModel getViewModel() {
        return getMode() == StickerPickerMode.INLINE ? getViewModelForInline() : getViewModelForSheet();
    }

    private final StickerPickerInlineViewModel getViewModelForInline() {
        return (StickerPickerInlineViewModel) this.viewModelForInline.getValue();
    }

    private final StickerPickerSheetViewModel getViewModelForSheet() {
        return (StickerPickerSheetViewModel) this.viewModelForSheet.getValue();
    }

    private final void handleEvent(StickerPickerViewModel$Event event) {
        if (event instanceof StickerPickerViewModel$Event$ScrollToStickerItemPosition) {
            WidgetStickerAdapter widgetStickerAdapter = this.stickerAdapter;
            if (widgetStickerAdapter == null) {
                m.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            widgetStickerAdapter.scrollToPosition(((StickerPickerViewModel$Event$ScrollToStickerItemPosition) event).getPosition());
            return;
        }
        if (!(event instanceof StickerPickerViewModel$Event$ShowStickerPremiumUpsell)) {
            if (event instanceof StickerPickerViewModel$Event$SlowMode) {
                b.a.d.m.i(getParentFragment(), 2131887611, 0, 4);
            }
        } else {
            UnsendableStickerPremiumUpsellDialog$Companion unsendableStickerPremiumUpsellDialog$Companion = UnsendableStickerPremiumUpsellDialog.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            unsendableStickerPremiumUpsellDialog$Companion.show(parentFragmentManager);
        }
    }

    private final void handleNewStickerRecyclerScrollPosition(int stickerRecyclerScrollPosition, List<? extends StickerCategoryItem> stickerCategoryItems) {
        Long l;
        for (StickerCategoryItem stickerCategoryItem : stickerCategoryItems) {
            Pair<Integer, Integer> categoryRange = stickerCategoryItem.getCategoryRange();
            int iIntValue = categoryRange.getFirst().intValue();
            int iIntValue2 = categoryRange.getSecond().intValue();
            long categoryId = stickerCategoryItem.getCategoryId();
            if (iIntValue <= stickerRecyclerScrollPosition && iIntValue2 > stickerRecyclerScrollPosition && ((l = this.autoscrollToPackId) == null || (l != null && l.longValue() == categoryId))) {
                this.autoscrollToPackId = null;
                if (!stickerCategoryItem.getIsSelected()) {
                    selectCategoryById(categoryId);
                }
            }
        }
    }

    private final void initializeSearchBar() {
        AppBarLayout appBarLayout = getBinding().m;
        m.checkNotNullExpressionValue(appBarLayout, "binding.stickerAppBar");
        StickerPickerMode stickerPickerMode = this.stickerPickerMode;
        StickerPickerMode stickerPickerMode2 = StickerPickerMode.INLINE;
        appBarLayout.setVisibility(stickerPickerMode != stickerPickerMode2 ? 0 : 8);
        SearchInputView searchInputView = getBinding().r;
        m.checkNotNullExpressionValue(searchInputView, "binding.stickerSearchInput");
        searchInputView.setVisibility(this.stickerPickerMode != stickerPickerMode2 ? 0 : 8);
        getBinding().r.setOnClearClicked(new WidgetStickerPicker$initializeSearchBar$1(this));
        if (this.stickerPickerMode == StickerPickerMode.BOTTOM_SHEET) {
            getBinding().r.binding.c.requestFocus();
            showKeyboard(getBinding().r.getEditText());
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("com.discord.intent.extra.EXTRA_TEXT") : null;
        if (string != null) {
            getBinding().r.setText(string);
            getViewModel().setSearchText(string);
            this.restoredSearchQueryFromViewModel = true;
        }
    }

    private final void launchBottomSheet() {
        WidgetStickerPickerSheet$Companion widgetStickerPickerSheet$Companion = WidgetStickerPickerSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetStickerPickerSheet$Companion.show$default(widgetStickerPickerSheet$Companion, parentFragmentManager, this.stickerPickerListener, null, null, null, 28, null);
    }

    private final void onGuildClicked(StickerCategoryItem$GuildItem guildItem) {
        AnalyticsTracker.INSTANCE.guildCategorySelected(guildItem.getGuild().getId());
        this.autoscrollToPackId = Long.valueOf(guildItem.getGuild().getId());
        selectCategoryById(guildItem.getGuild().getId());
        Pair<Integer, Integer> categoryRange = guildItem.getCategoryRange();
        Observable<T> observableQ = new k(Unit.a).q(200L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableQ, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableQ, this, null, 2, null), WidgetStickerPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerPicker$onGuildClicked$1(this, categoryRange), 62, (Object) null);
    }

    private final void onPackClicked(StickerCategoryItem$PackItem stickerPackItem) {
        AnalyticsTracker.INSTANCE.stickerPackCategorySelected(stickerPackItem.getPack().getId());
        this.autoscrollToPackId = Long.valueOf(stickerPackItem.getPack().getId());
        selectCategoryById(stickerPackItem.getPack().getId());
        Pair<Integer, Integer> categoryRange = stickerPackItem.getCategoryRange();
        Observable<T> observableQ = new k(Unit.a).q(200L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableQ, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableQ, this, null, 2, null), WidgetStickerPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerPicker$onPackClicked$1(this, categoryRange), 62, (Object) null);
    }

    private final void onRecentClicked() {
        selectCategoryById(-1L);
        WidgetStickerAdapter widgetStickerAdapter = this.stickerAdapter;
        if (widgetStickerAdapter == null) {
            m.throwUninitializedPropertyAccessException("stickerAdapter");
        }
        widgetStickerAdapter.scrollToPosition(0);
    }

    private final void onSelectedCategoryAdapterPositionUpdated(int selectedCategoryPosition) {
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.categoryLayoutManager;
        if (linearLayoutManager2 == null) {
            m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
        int i = iFindLastCompletelyVisibleItemPosition - iFindFirstCompletelyVisibleItemPosition;
        if (new IntRange(iFindFirstCompletelyVisibleItemPosition, iFindLastCompletelyVisibleItemPosition).contains(selectedCategoryPosition)) {
            return;
        }
        int iMax = Math.max(selectedCategoryPosition < iFindFirstCompletelyVisibleItemPosition ? selectedCategoryPosition - i : selectedCategoryPosition + i, 0);
        StickerCategoryAdapter stickerCategoryAdapter = this.categoryAdapter;
        if (stickerCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        getBinding().p.scrollToPosition(Math.min(iMax, stickerCategoryAdapter.getPageSize() - 1));
    }

    private final void onStickerHeaderItemsClicked(StoreHeaderItem storeHeaderItem) {
        WidgetStickerPackDetailsDialog$Companion widgetStickerPackDetailsDialog$Companion = WidgetStickerPackDetailsDialog.Companion;
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetStickerPackDetailsDialog$Companion.show$default(widgetStickerPackDetailsDialog$Companion, childFragmentManager, storeHeaderItem.getPack().getId(), null, 4, null);
    }

    private final void onStickerItemSelected(StickerItem stickerItem) {
        StickerPickerListener stickerPickerListener;
        Sticker sticker = stickerItem.getSticker();
        if (!getViewModel().onStickerSelected(sticker) || (stickerPickerListener = this.stickerPickerListener) == null) {
            return;
        }
        stickerPickerListener.onStickerPicked(sticker);
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView, "binding.stickerPickerCategoryRecycler");
        recyclerView.setItemAnimator(null);
        StickerCategoryAdapter stickerCategoryAdapter = new StickerCategoryAdapter(new WidgetStickerPicker$setUpCategoryRecycler$1(this), new WidgetStickerPicker$setUpCategoryRecycler$2(this), new WidgetStickerPicker$setUpCategoryRecycler$3(this), new WidgetStickerPicker$setUpCategoryRecycler$4(this), this, null, 32, null);
        this.categoryAdapter = stickerCategoryAdapter;
        if (stickerCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        stickerCategoryAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView2, "binding.stickerPickerCategoryRecycler");
        StickerCategoryAdapter stickerCategoryAdapter2 = this.categoryAdapter;
        if (stickerCategoryAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView2.setAdapter(stickerCategoryAdapter2);
        RecyclerView recyclerView3 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView3, "binding.stickerPickerCategoryRecycler");
        StickerCategoryAdapter stickerCategoryAdapter3 = this.categoryAdapter;
        if (stickerCategoryAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        this.categoryLayoutManager = new SelfHealingLinearLayoutManager(recyclerView3, stickerCategoryAdapter3, 0, false, 8, null);
        RecyclerView recyclerView4 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView4, "binding.stickerPickerCategoryRecycler");
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        recyclerView4.setLayoutManager(linearLayoutManager);
        getBinding().p.addOnScrollListener(new WidgetStickerPicker$setUpCategoryRecycler$5(this));
    }

    private final void setUpStickerRecycler() {
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputStickerPickerRecycler");
        WidgetStickerAdapter widgetStickerAdapter = new WidgetStickerAdapter(recyclerView2, new WidgetStickerPicker$setUpStickerRecycler$1(this), new WidgetStickerPicker$setUpStickerRecycler$2(this), this.recyclerScrollingWithinThresholdSubject, this, false, 32, null);
        this.stickerAdapter = widgetStickerAdapter;
        if (widgetStickerAdapter == null) {
            m.throwUninitializedPropertyAccessException("stickerAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(widgetStickerAdapter);
        getBinding().k.addItemDecoration(stickyHeaderItemDecoration);
        RecyclerView recyclerView3 = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView3, "binding.chatInputStickerPickerRecycler");
        stickyHeaderItemDecoration.blockClicks(recyclerView3);
        getBinding().k.setHasFixedSize(true);
        getBinding().k.setRecyclerListener(WidgetStickerPicker$setUpStickerRecycler$3.INSTANCE);
        getBinding().k.addOnScrollListener(new SpeedOnScrollListener(0L, new WidgetStickerPicker$setUpStickerRecycler$4(this), 0, null, 13, null));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().q, new WidgetStickerPicker$setWindowInsetsListeners$1(this));
    }

    public static /* synthetic */ void setupForInlineSearchAndScroll$default(WidgetStickerPicker widgetStickerPicker, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        widgetStickerPicker.setupForInlineSearchAndScroll(str, j);
    }

    private final void showCategoryBottomBar(boolean showBottomBar) {
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = new ViewGroup$MarginLayoutParams(-1, -1);
        viewGroup$MarginLayoutParams.bottomMargin = showBottomBar ? DimenUtils.dpToPixels(48) : 0;
        AppViewFlipper appViewFlipper = getBinding().l;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputStickerPickerViewFlipper");
        appViewFlipper.setLayoutParams(new CoordinatorLayout$LayoutParams(viewGroup$MarginLayoutParams));
        ConstraintLayout constraintLayout = getBinding().n;
        m.checkNotNullExpressionValue(constraintLayout, "binding.stickerPickerBottomBar");
        constraintLayout.setVisibility(showBottomBar ? 0 : 8);
        View view = getBinding().o;
        m.checkNotNullExpressionValue(view, "binding.stickerPickerBottomBarDivider");
        view.setVisibility(showBottomBar ? 0 : 8);
    }

    public final void clearSearchInput() {
        getViewModel().setSearchText("");
    }

    public final boolean getCanHandleIsShown() {
        return this.canHandleIsShown;
    }

    @Override // b.b.a.c
    public void isShown(boolean isActive) {
        if (isActive && !this.wasActive) {
            getBinding().m.setExpanded(true);
            scrollToTop();
        }
        try {
            getViewModel().setSelectedCategoryId(-1L);
            clearSearchInput();
        } catch (Exception unused) {
        }
        this.wasActive = isActive;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.gc();
        this.stickerPickerMode = getMode();
        this.canHandleIsShown = true;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        CoordinatorLayout coordinatorLayout = getBinding().q;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.stickerPickerContainer");
        coordinatorLayout.setPadding(coordinatorLayout.getPaddingLeft(), coordinatorLayout.getPaddingTop(), coordinatorLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        StickerPickerMode mode = getMode();
        StickerPickerMode stickerPickerMode = StickerPickerMode.INLINE;
        if (mode == stickerPickerMode) {
            setWindowInsetsListeners();
        }
        initializeSearchBar();
        Toolbar toolbar = getBinding().f2662s;
        m.checkNotNullExpressionValue(toolbar, "binding.stickerToolbar");
        ViewGroup$LayoutParams layoutParams = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout$LayoutParams) layoutParams).setScrollFlags(this.stickerPickerMode == stickerPickerMode ? 5 : 0);
        setUpStickerRecycler();
        setUpCategoryRecycler();
        getBinding().r.a(this, new WidgetStickerPicker$onViewBound$1(this));
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        getViewModel().setSelectedCategoryId(lValueOf != null ? lValueOf.longValue() : -1L);
        RecyclerView recyclerView = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView, "binding.stickerPickerCategoryRecycler");
        recyclerView.setLayoutParams(new ConstraintLayout$LayoutParams(-1, -1));
        getBinding().h.setIsLoading(false);
        getBinding().h.setOnClickListener(new WidgetStickerPicker$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StickerPickerViewModel viewModel = getViewModel();
        WidgetExpressionPickerAdapter$Companion widgetExpressionPickerAdapter$Companion = WidgetExpressionPickerAdapter.Companion;
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        viewModel.setStickerCountToDisplayForStore(widgetExpressionPickerAdapter$Companion.calculateNumOfColumns(recyclerView, getResources().getDimension(2131165320), 4));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStickerPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerPicker$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStickerPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerPicker$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }

    public final void scrollToPack(Long packId) {
        getViewModel().scrollToPackId(packId);
    }

    public final void scrollToTop() {
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new WidgetStickerPicker$scrollToTop$$inlined$doOnLayout$1(this));
        } else {
            access$getBinding$p(this).k.scrollToPosition(0);
        }
    }

    public final void selectCategoryById(long itemId) {
        getViewModel().setSelectedCategoryId(itemId);
    }

    public final void setListener(StickerPickerListener stickerPickerListener) {
        this.stickerPickerListener = stickerPickerListener;
    }

    public final void setOnBackspacePressedListener(OnBackspacePressedListener onBackspacePressedListener) {
        this.onBackspacePressedListener = onBackspacePressedListener;
    }

    public final void setScrollExpressionPickerToTop(Function0<Unit> scrollExpressionPickerToTop) {
        m.checkNotNullParameter(scrollExpressionPickerToTop, "scrollExpressionPickerToTop");
        this.scrollExpressionPickerToTop = scrollExpressionPickerToTop;
    }

    public final void setShowSearchBar(Function1<? super Boolean, Unit> showSearchBar) {
        this.showSearchBar = showSearchBar;
    }

    public final void setupForInlineSearchAndScroll(String searchText, long packId) {
        m.checkNotNullParameter(searchText, "searchText");
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1(this, searchText, packId));
            return;
        }
        access$getViewModel$p(this).setSearchText(searchText);
        access$getViewModel$p(this).setSelectedCategoryId(packId);
        RecyclerView recyclerView2 = access$getBinding$p(this).k;
        m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView2) || recyclerView2.isLayoutRequested()) {
            recyclerView2.addOnLayoutChangeListener(new WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$lambda$1(this, searchText, packId));
        } else {
            scrollToPack(Long.valueOf(packId));
        }
    }
}
