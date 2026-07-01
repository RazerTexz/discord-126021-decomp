package com.discord.widgets.chat.input.sticker;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.b.a.FlexInputExpressionTrayStateChangeListener;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetStickerPickerBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.recycler.SpeedOnScrollListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import com.discord.widgets.chat.input.sticker.StickerPickerViewModel;
import com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog;
import com.google.android.material.appbar.AppBarLayout;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.l.e.ScalarSynchronousObservable;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker extends AppFragment implements FlexInputExpressionTrayStateChangeListener {
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
    private StickerPickerViewModel.ViewState previousViewState;
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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStickerPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerPickerBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ StickerPickerViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StickerPickerViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetStickerPicker.this.handleNewStickerRecyclerScrollPosition(i, ((StickerPickerViewModel.ViewState.Stickers) this.$viewState).getCategoryItems());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$initializeSearchBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (WidgetStickerPicker.this.stickerPickerMode == StickerPickerMode.INLINE) {
                WidgetStickerPicker.this.launchBottomSheet();
            } else {
                WidgetStickerPicker.this.getBinding().r.setText("");
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$onGuildClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ Tuples2 $categoryRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Tuples2 tuples2) {
            super(1);
            this.$categoryRange = tuples2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetStickerPicker.access$getStickerAdapter$p(WidgetStickerPicker.this).scrollToPosition(((Number) this.$categoryRange.getFirst()).intValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$onPackClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ Tuples2 $categoryRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Tuples2 tuples2) {
            super(1);
            this.$categoryRange = tuples2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetStickerPicker.access$getStickerAdapter$p(WidgetStickerPicker.this).scrollToPosition(((Number) this.$categoryRange.getFirst()).intValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
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
            WidgetStickerPicker.this.getViewModel().setSearchText(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StickerPickerViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerPickerViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerPickerViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetStickerPicker.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StickerPickerViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerPickerViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerPickerViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetStickerPicker.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpCategoryRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StickerCategoryItem.GuildItem, Unit> {
        public AnonymousClass1(WidgetStickerPicker widgetStickerPicker) {
            super(1, widgetStickerPicker, WidgetStickerPicker.class, "onGuildClicked", "onGuildClicked(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerCategoryItem.GuildItem guildItem) {
            invoke2(guildItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerCategoryItem.GuildItem guildItem) {
            Intrinsics3.checkNotNullParameter(guildItem, "p1");
            ((WidgetStickerPicker) this.receiver).onGuildClicked(guildItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpCategoryRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StickerCategoryItem.PackItem, Unit> {
        public AnonymousClass2(WidgetStickerPicker widgetStickerPicker) {
            super(1, widgetStickerPicker, WidgetStickerPicker.class, "onPackClicked", "onPackClicked(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerCategoryItem.PackItem packItem) {
            invoke2(packItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerCategoryItem.PackItem packItem) {
            Intrinsics3.checkNotNullParameter(packItem, "p1");
            ((WidgetStickerPicker) this.receiver).onPackClicked(packItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpCategoryRecycler$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(WidgetStickerPicker widgetStickerPicker) {
            super(0, widgetStickerPicker, WidgetStickerPicker.class, "onRecentClicked", "onRecentClicked()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetStickerPicker) this.receiver).onRecentClicked();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpCategoryRecycler$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass4(WidgetStickerPicker widgetStickerPicker) {
            super(1, widgetStickerPicker, WidgetStickerPicker.class, "onSelectedCategoryAdapterPositionUpdated", "onSelectedCategoryAdapterPositionUpdated(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            ((WidgetStickerPicker) this.receiver).onSelectedCategoryAdapterPositionUpdated(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpStickerRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StickerAdapterItems3, Unit> {
        public AnonymousClass1(WidgetStickerPicker widgetStickerPicker) {
            super(1, widgetStickerPicker, WidgetStickerPicker.class, "onStickerItemSelected", "onStickerItemSelected(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAdapterItems3 stickerAdapterItems3) {
            invoke2(stickerAdapterItems3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAdapterItems3 stickerAdapterItems3) {
            Intrinsics3.checkNotNullParameter(stickerAdapterItems3, "p1");
            ((WidgetStickerPicker) this.receiver).onStickerItemSelected(stickerAdapterItems3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpStickerRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StickerAdapterItems4, Unit> {
        public AnonymousClass2(WidgetStickerPicker widgetStickerPicker) {
            super(1, widgetStickerPicker, WidgetStickerPicker.class, "onStickerHeaderItemsClicked", "onStickerHeaderItemsClicked(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAdapterItems4 stickerAdapterItems4) {
            invoke2(stickerAdapterItems4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAdapterItems4 stickerAdapterItems4) {
            Intrinsics3.checkNotNullParameter(stickerAdapterItems4, "p1");
            ((WidgetStickerPicker) this.receiver).onStickerHeaderItemsClicked(stickerAdapterItems4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setUpStickerRecycler$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPicker.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetStickerPicker.this.recyclerScrollingWithinThresholdSubject.onNext(Boolean.valueOf(z2));
        }
    }

    public WidgetStickerPicker() {
        super(R.layout.widget_sticker_picker);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerPicker2.INSTANCE, null, 2, null);
        this.initialStickerPackId = LazyJVM.lazy(new WidgetStickerPicker3(this));
        this.viewModelForInline = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StickerPickerInlineViewModel.class), new WidgetStickerPicker$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetStickerPicker5(this)));
        this.viewModelForSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StickerPickerSheetViewModel.class), new WidgetStickerPicker$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetStickerPicker6(this)));
        this.scrollExpressionPickerToTop = WidgetStickerPicker4.INSTANCE;
        this.stickerCategoryScrollSubject = PublishSubject.k0();
        this.recyclerScrollingWithinThresholdSubject = BehaviorSubject.l0(Boolean.TRUE);
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getStickerAdapter$p(WidgetStickerPicker widgetStickerPicker) {
        WidgetStickerAdapter widgetStickerAdapter = widgetStickerPicker.stickerAdapter;
        if (widgetStickerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
        }
        return widgetStickerAdapter;
    }

    private final void configureUI(StickerPickerViewModel.ViewState viewState) {
        String searchQuery = viewState != null ? viewState.getSearchQuery() : null;
        if (!this.restoredSearchQueryFromViewModel && searchQuery != null) {
            this.restoredSearchQueryFromViewModel = true;
            getBinding().r.setText(searchQuery);
        }
        if (viewState == null) {
            return;
        }
        if (viewState instanceof StickerPickerViewModel.ViewState.EmptyNonPremium) {
            if (this.wasActive && ((StickerPickerViewModel.ViewState.EmptyNonPremium) viewState).isStickersSelectedTab()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.EmptyStickerPickerUpsell, new Traits.Location(null, Traits.Location.Section.EMPTY_STICKER_PICKER_UPSELL, null, null, null, 29, null), null, null, 12, null);
            }
            AppViewFlipper appViewFlipper = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputStickerPickerViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            Function1<? super Boolean, Unit> function1 = this.showSearchBar;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            this.scrollExpressionPickerToTop.invoke();
            StickerPickerViewModel.ViewState.EmptyNonPremium emptyNonPremium = (StickerPickerViewModel.ViewState.EmptyNonPremium) viewState;
            if (emptyNonPremium.getEmptyStateStickers().size() >= 4) {
                StickerView.e(getBinding().d, emptyNonPremium.getEmptyStateStickers().get(0), null, 2);
                StickerView.e(getBinding().e, emptyNonPremium.getEmptyStateStickers().get(1), null, 2);
                StickerView.e(getBinding().f, emptyNonPremium.getEmptyStateStickers().get(2), null, 2);
                StickerView.e(getBinding().g, emptyNonPremium.getEmptyStateStickers().get(3), null, 2);
            }
            showCategoryBottomBar(false);
        } else if (viewState instanceof StickerPickerViewModel.ViewState.EmptySearchResults) {
            AppViewFlipper appViewFlipper2 = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.chatInputStickerPickerViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            Function1<? super Boolean, Unit> function2 = this.showSearchBar;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE);
            }
            this.scrollExpressionPickerToTop.invoke();
            getBinding().f2661b.setImageResource(R.drawable.img_stickers_search_empty_90dp);
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputStickerPickerEmptyTitle");
            textView.setVisibility(8);
            TextView textView2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputStickerPickerEmptySubtitle");
            textView2.setText(getString(R.string.no_sticker_search_results));
            LinkifiedTextView linkifiedTextView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.chatInputStickerPickerEmptyLink");
            linkifiedTextView.setVisibility(8);
            showCategoryBottomBar(true);
            StickerCategoryAdapter stickerCategoryAdapter = this.categoryAdapter;
            if (stickerCategoryAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            stickerCategoryAdapter.setItems(((StickerPickerViewModel.ViewState.EmptySearchResults) viewState).getCategoryItems());
        } else if (viewState instanceof StickerPickerViewModel.ViewState.Stickers) {
            AppViewFlipper appViewFlipper3 = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.chatInputStickerPickerViewFlipper");
            appViewFlipper3.setDisplayedChild(0);
            Function1<? super Boolean, Unit> function3 = this.showSearchBar;
            if (function3 != null) {
                function3.invoke(Boolean.TRUE);
            }
            WidgetStickerAdapter widgetStickerAdapter = this.stickerAdapter;
            if (widgetStickerAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            StickerPickerViewModel.ViewState.Stickers stickers = (StickerPickerViewModel.ViewState.Stickers) viewState;
            widgetStickerAdapter.setData(stickers.getStickerItems());
            SearchInputView searchInputView = getBinding().r;
            Intrinsics3.checkNotNullExpressionValue(searchInputView, "binding.stickerSearchInput");
            searchInputView.setVisibility(this.stickerPickerMode != StickerPickerMode.INLINE ? 0 : 8);
            WidgetStickerAdapter widgetStickerAdapter2 = this.stickerAdapter;
            if (widgetStickerAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            widgetStickerAdapter2.setOnScrollPositionListener(new AnonymousClass1(viewState));
            WidgetStickerAdapter widgetStickerAdapter3 = this.stickerAdapter;
            if (widgetStickerAdapter3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            widgetStickerAdapter3.setOnScrollListener(null);
            showCategoryBottomBar(true);
            StickerCategoryAdapter stickerCategoryAdapter2 = this.categoryAdapter;
            if (stickerCategoryAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            stickerCategoryAdapter2.setItems(stickers.getCategoryItems());
            if (this.stickerPickerMode == StickerPickerMode.BOTTOM_SHEET) {
                RecyclerView recyclerView = getBinding().k;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = DimenUtils.dpToPixels(72);
                RecyclerView recyclerView2 = getBinding().k;
                Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatInputStickerPickerRecycler");
                recyclerView2.setLayoutParams(layoutParams2);
            }
        }
        this.previousViewState = viewState;
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build.VERSION.SDK_INT >= 29) {
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

    private final void handleEvent(StickerPickerViewModel.Event event) {
        if (event instanceof StickerPickerViewModel.Event.ScrollToStickerItemPosition) {
            WidgetStickerAdapter widgetStickerAdapter = this.stickerAdapter;
            if (widgetStickerAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
            }
            widgetStickerAdapter.scrollToPosition(((StickerPickerViewModel.Event.ScrollToStickerItemPosition) event).getPosition());
            return;
        }
        if (!(event instanceof StickerPickerViewModel.Event.ShowStickerPremiumUpsell)) {
            if (event instanceof StickerPickerViewModel.Event.SlowMode) {
                AppToast.i(getParentFragment(), R.string.channel_slowmode_desc_short, 0, 4);
            }
        } else {
            UnsendableStickerPremiumUpsellDialog.Companion companion = UnsendableStickerPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager);
        }
    }

    private final void handleNewStickerRecyclerScrollPosition(int stickerRecyclerScrollPosition, List<? extends StickerCategoryItem> stickerCategoryItems) {
        Long l;
        for (StickerCategoryItem stickerCategoryItem : stickerCategoryItems) {
            Tuples2<Integer, Integer> categoryRange = stickerCategoryItem.getCategoryRange();
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
        Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.stickerAppBar");
        StickerPickerMode stickerPickerMode = this.stickerPickerMode;
        StickerPickerMode stickerPickerMode2 = StickerPickerMode.INLINE;
        appBarLayout.setVisibility(stickerPickerMode != stickerPickerMode2 ? 0 : 8);
        SearchInputView searchInputView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(searchInputView, "binding.stickerSearchInput");
        searchInputView.setVisibility(this.stickerPickerMode != stickerPickerMode2 ? 0 : 8);
        getBinding().r.setOnClearClicked(new AnonymousClass1());
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
        WidgetStickerPickerSheet.Companion companion = WidgetStickerPickerSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, this.stickerPickerListener, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
    }

    private final void onGuildClicked(StickerCategoryItem.GuildItem guildItem) {
        AnalyticsTracker.INSTANCE.guildCategorySelected(guildItem.getGuild().getId());
        this.autoscrollToPackId = Long.valueOf(guildItem.getGuild().getId());
        selectCategoryById(guildItem.getGuild().getId());
        Tuples2<Integer, Integer> categoryRange = guildItem.getCategoryRange();
        Observable<T> observableQ = new ScalarSynchronousObservable(Unit.a).q(200L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableQ, this, null, 2, null), (Class<?>) WidgetStickerPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(categoryRange));
    }

    private final void onPackClicked(StickerCategoryItem.PackItem stickerPackItem) {
        AnalyticsTracker.INSTANCE.stickerPackCategorySelected(stickerPackItem.getPack().getId());
        this.autoscrollToPackId = Long.valueOf(stickerPackItem.getPack().getId());
        selectCategoryById(stickerPackItem.getPack().getId());
        Tuples2<Integer, Integer> categoryRange = stickerPackItem.getCategoryRange();
        Observable<T> observableQ = new ScalarSynchronousObservable(Unit.a).q(200L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableQ, this, null, 2, null), (Class<?>) WidgetStickerPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(categoryRange));
    }

    private final void onRecentClicked() {
        selectCategoryById(-1L);
        WidgetStickerAdapter widgetStickerAdapter = this.stickerAdapter;
        if (widgetStickerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
        }
        widgetStickerAdapter.scrollToPosition(0);
    }

    private final void onSelectedCategoryAdapterPositionUpdated(int selectedCategoryPosition) {
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.categoryLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
        int i = iFindLastCompletelyVisibleItemPosition - iFindFirstCompletelyVisibleItemPosition;
        if (new Ranges2(iFindFirstCompletelyVisibleItemPosition, iFindLastCompletelyVisibleItemPosition).contains(selectedCategoryPosition)) {
            return;
        }
        int iMax = Math.max(selectedCategoryPosition < iFindFirstCompletelyVisibleItemPosition ? selectedCategoryPosition - i : selectedCategoryPosition + i, 0);
        StickerCategoryAdapter stickerCategoryAdapter = this.categoryAdapter;
        if (stickerCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        getBinding().p.scrollToPosition(Math.min(iMax, stickerCategoryAdapter.getPageSize() - 1));
    }

    private final void onStickerHeaderItemsClicked(StickerAdapterItems4 storeHeaderItem) {
        WidgetStickerPackDetailsDialog.Companion companion = WidgetStickerPackDetailsDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetStickerPackDetailsDialog.Companion.show$default(companion, childFragmentManager, storeHeaderItem.getPack().getId(), null, 4, null);
    }

    private final void onStickerItemSelected(StickerAdapterItems3 stickerItem) {
        StickerPickerListener stickerPickerListener;
        Sticker sticker = stickerItem.getSticker();
        if (!getViewModel().onStickerSelected(sticker) || (stickerPickerListener = this.stickerPickerListener) == null) {
            return;
        }
        stickerPickerListener.onStickerPicked(sticker);
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.stickerPickerCategoryRecycler");
        recyclerView.setItemAnimator(null);
        StickerCategoryAdapter stickerCategoryAdapter = new StickerCategoryAdapter(new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this), this, null, 32, null);
        this.categoryAdapter = stickerCategoryAdapter;
        if (stickerCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        stickerCategoryAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.stickerPickerCategoryRecycler");
        StickerCategoryAdapter stickerCategoryAdapter2 = this.categoryAdapter;
        if (stickerCategoryAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView2.setAdapter(stickerCategoryAdapter2);
        RecyclerView recyclerView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.stickerPickerCategoryRecycler");
        StickerCategoryAdapter stickerCategoryAdapter3 = this.categoryAdapter;
        if (stickerCategoryAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        this.categoryLayoutManager = new SelfHealingLinearLayoutManager(recyclerView3, stickerCategoryAdapter3, 0, false, 8, null);
        RecyclerView recyclerView4 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.stickerPickerCategoryRecycler");
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        recyclerView4.setLayoutManager(linearLayoutManager);
        getBinding().p.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker.setUpCategoryRecycler.5
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                Intrinsics3.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrolled(recyclerView5, dx, dy);
                WidgetStickerPicker.this.stickerCategoryScrollSubject.k.onNext((T) Unit.a);
            }
        });
    }

    private final void setUpStickerRecycler() {
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatInputStickerPickerRecycler");
        WidgetStickerAdapter widgetStickerAdapter = new WidgetStickerAdapter(recyclerView2, new AnonymousClass1(this), new AnonymousClass2(this), this.recyclerScrollingWithinThresholdSubject, this, false, 32, null);
        this.stickerAdapter = widgetStickerAdapter;
        if (widgetStickerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(widgetStickerAdapter);
        getBinding().k.addItemDecoration(stickyHeaderItemDecoration);
        RecyclerView recyclerView3 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.chatInputStickerPickerRecycler");
        stickyHeaderItemDecoration.blockClicks(recyclerView3);
        getBinding().k.setHasFixedSize(true);
        getBinding().k.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker.setUpStickerRecycler.3
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
                if (viewHolder instanceof StickerAdapterViewHolders2) {
                    ((StickerAdapterViewHolders2) viewHolder).cancelLoading();
                }
            }
        });
        getBinding().k.addOnScrollListener(new SpeedOnScrollListener(0L, new AnonymousClass4(), 0, null, 13, null));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().q, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), WidgetStickerPicker.this.getAdditionalBottomPaddingPx() + windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    public static /* synthetic */ void setupForInlineSearchAndScroll$default(WidgetStickerPicker widgetStickerPicker, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        widgetStickerPicker.setupForInlineSearchAndScroll(str, j);
    }

    private final void showCategoryBottomBar(boolean showBottomBar) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        marginLayoutParams.bottomMargin = showBottomBar ? DimenUtils.dpToPixels(48) : 0;
        AppViewFlipper appViewFlipper = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputStickerPickerViewFlipper");
        appViewFlipper.setLayoutParams(new CoordinatorLayout.LayoutParams(marginLayoutParams));
        ConstraintLayout constraintLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stickerPickerBottomBar");
        constraintLayout.setVisibility(showBottomBar ? 0 : 8);
        View view = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.stickerPickerBottomBarDivider");
        view.setVisibility(showBottomBar ? 0 : 8);
    }

    public final void clearSearchInput() {
        getViewModel().setSearchText("");
    }

    public final boolean getCanHandleIsShown() {
        return this.canHandleIsShown;
    }

    @Override // b.b.a.FlexInputExpressionTrayStateChangeListener
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        CoordinatorLayout coordinatorLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.stickerPickerContainer");
        coordinatorLayout.setPadding(coordinatorLayout.getPaddingLeft(), coordinatorLayout.getPaddingTop(), coordinatorLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        StickerPickerMode mode = getMode();
        StickerPickerMode stickerPickerMode = StickerPickerMode.INLINE;
        if (mode == stickerPickerMode) {
            setWindowInsetsListeners();
        }
        initializeSearchBar();
        Toolbar toolbar = getBinding().f2662s;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.stickerToolbar");
        ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(this.stickerPickerMode == stickerPickerMode ? 5 : 0);
        setUpStickerRecycler();
        setUpCategoryRecycler();
        getBinding().r.a(this, new AnonymousClass1());
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        getViewModel().setSelectedCategoryId(lValueOf != null ? lValueOf.longValue() : -1L);
        RecyclerView recyclerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.stickerPickerCategoryRecycler");
        recyclerView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        getBinding().h.setIsLoading(false);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStickerPicker.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.EXPRESSION_PICKER, null, null, null, 29, null));
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StickerPickerViewModel viewModel = getViewModel();
        WidgetExpressionPickerAdapter.Companion companion = WidgetExpressionPickerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        viewModel.setStickerCountToDisplayForStore(companion.calculateNumOfColumns(recyclerView, getResources().getDimension(R.dimen.chat_input_sticker_size), 4));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetStickerPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetStickerPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final void scrollToPack(Long packId) {
        getViewModel().scrollToPackId(packId);
    }

    public final void scrollToTop() {
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$scrollToTop$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics3.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    this.this$0.getBinding().k.scrollToPosition(0);
                }
            });
        } else {
            getBinding().k.scrollToPosition(0);
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
        Intrinsics3.checkNotNullParameter(scrollExpressionPickerToTop, "scrollExpressionPickerToTop");
        this.scrollExpressionPickerToTop = scrollExpressionPickerToTop;
    }

    public final void setShowSearchBar(Function1<? super Boolean, Unit> showSearchBar) {
        this.showSearchBar = showSearchBar;
    }

    public final void setupForInlineSearchAndScroll(final String searchText, final long packId) {
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1(this, searchText, packId));
            return;
        }
        getViewModel().setSearchText(searchText);
        getViewModel().setSelectedCategoryId(packId);
        RecyclerView recyclerView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView2) || recyclerView2.isLayoutRequested()) {
            recyclerView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$lambda$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics3.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    this.this$0.scrollToPack(Long.valueOf(packId));
                }
            });
        } else {
            scrollToPack(Long.valueOf(packId));
        }
    }
}
