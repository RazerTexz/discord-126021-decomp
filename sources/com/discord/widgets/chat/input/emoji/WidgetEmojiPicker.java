package com.discord.widgets.chat.input.emoji;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiPickerBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.press.RepeatingOnTouchListener;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import d0.Result2;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.l.a.OnSubscribeLift;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker extends AppFragment implements OnEmojiSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEmojiPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEmojiPickerBinding;", 0)};
    private static final int EMOJI_PICKER_VIEW_FLIPPER_EMPTY_STATE = 1;
    private static final int EMOJI_PICKER_VIEW_FLIPPER_RESULTS = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private EmojiCategoryAdapter categoryAdapter;
    private LinearLayoutManager categoryLayoutManager;
    private WidgetEmojiAdapter emojiAdapter;
    private final PublishSubject<Unit> emojiCategoryScrollSubject;
    private EmojiPickerListener emojiPickerListener;
    private EmojiPickerMode emojiPickerMode;
    private boolean isNextCategoryScrollSmooth;
    private OnBackspacePressedListener onBackspacePressedListener;
    private Function0<Unit> onEmojiSearchOpenedListener;
    private EmojiPickerViewModel.ViewState previousViewState;
    private boolean restoredSearchQueryFromViewModel;

    /* JADX INFO: renamed from: viewModelForInline$delegate, reason: from kotlin metadata */
    private final Lazy viewModelForInline;

    /* JADX INFO: renamed from: viewModelForSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelForSheet;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ EmojiPickerViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EmojiPickerViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetEmojiPicker.this.handleNewEmojiRecyclerScrollPosition(i, ((EmojiPickerViewModel.ViewState.Results) this.$viewState).getCategoryItems());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$initializeSearchBar$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "input");
            WidgetEmojiPicker.this.handleInputChanged(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$onEmojiSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Emoji, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
            invoke2(emoji);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Emoji emoji) {
            Intrinsics3.checkNotNullParameter(emoji, "validEmoji");
            EmojiPickerListener emojiPickerListener = WidgetEmojiPicker.this.emojiPickerListener;
            if (emojiPickerListener != null) {
                emojiPickerListener.onEmojiPicked(emoji);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<EmojiPickerViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiPickerViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiPickerViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetEmojiPicker.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<EmojiPickerViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiPickerViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiPickerViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetEmojiPicker.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpCategoryRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<EmojiCategoryItem, Unit> {
        public AnonymousClass1(WidgetEmojiPicker widgetEmojiPicker) {
            super(1, widgetEmojiPicker, WidgetEmojiPicker.class, "onCategoryClicked", "onCategoryClicked(Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiCategoryItem emojiCategoryItem) {
            invoke2(emojiCategoryItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiCategoryItem emojiCategoryItem) {
            Intrinsics3.checkNotNullParameter(emojiCategoryItem, "p1");
            ((WidgetEmojiPicker) this.receiver).onCategoryClicked(emojiCategoryItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpCategoryRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass2(WidgetEmojiPicker widgetEmojiPicker) {
            super(1, widgetEmojiPicker, WidgetEmojiPicker.class, "onSelectedCategoryAdapterPositionUpdated", "onSelectedCategoryAdapterPositionUpdated(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            ((WidgetEmojiPicker) this.receiver).onSelectedCategoryAdapterPositionUpdated(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpEmojiRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(WidgetEmojiPicker widgetEmojiPicker) {
            super(0, widgetEmojiPicker, WidgetEmojiPicker.class, "onPremiumCtaClicked", "onPremiumCtaClicked()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetEmojiPicker) this.receiver).onPremiumCtaClicked();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpEmojiRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetEmojiPicker widgetEmojiPicker = WidgetEmojiPicker.this;
            widgetEmojiPicker.hideKeyboard(widgetEmojiPicker.getView());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$subscribeToCategoryRecyclerScrolls$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetEmojiPicker widgetEmojiPicker = WidgetEmojiPicker.this;
            widgetEmojiPicker.configureUnicodeCategoriesShortcutButton(widgetEmojiPicker.previousViewState);
        }
    }

    public WidgetEmojiPicker() {
        super(R.layout.widget_emoji_picker);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEmojiPicker2.INSTANCE, null, 2, null);
        this.viewModelForInline = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EmojiPickerViewModel.Inline.class), new WidgetEmojiPicker$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetEmojiPicker3(this)));
        this.viewModelForSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EmojiPickerViewModel.Sheet.class), new WidgetEmojiPicker$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetEmojiPicker4(this)));
        this.emojiCategoryScrollSubject = PublishSubject.k0();
        this.isNextCategoryScrollSmooth = true;
    }

    private final void checkUpsellHeaderVisibility(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int iFindFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
        int iFindLastCompletelyVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
        if (iFindLastCompletelyVisibleItemPosition < iFindFirstCompletelyVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iFindLastCompletelyVisibleItemPosition);
            if (!(viewHolderFindViewHolderForAdapterPosition instanceof WidgetEmojiAdapter.HeaderViewHolder)) {
                viewHolderFindViewHolderForAdapterPosition = null;
            }
            WidgetEmojiAdapter.HeaderViewHolder headerViewHolder = (WidgetEmojiAdapter.HeaderViewHolder) viewHolderFindViewHolderForAdapterPosition;
            if (headerViewHolder != null) {
                WidgetEmojiAdapter.HeaderItem boundItem = headerViewHolder.getBoundItem();
                WidgetEmojiAdapter.HeaderItem.StringHeaderItem stringHeaderItem = (WidgetEmojiAdapter.HeaderItem.StringHeaderItem) (boundItem instanceof WidgetEmojiAdapter.HeaderItem.StringHeaderItem ? boundItem : null);
                if (stringHeaderItem != null && stringHeaderItem.getStringRes() == R.string.emoji_available_with_premium) {
                    getViewModel().onUpsellHeaderVisible();
                }
            }
            if (iFindLastCompletelyVisibleItemPosition == iFindFirstCompletelyVisibleItemPosition) {
                return;
            } else {
                iFindLastCompletelyVisibleItemPosition--;
            }
        }
    }

    private final void configureUI(EmojiPickerViewModel.ViewState viewState) {
        Unit unit;
        String searchQuery = viewState != null ? viewState.getSearchQuery() : null;
        if (!this.restoredSearchQueryFromViewModel && searchQuery != null) {
            this.restoredSearchQueryFromViewModel = true;
            getBinding().m.setText(searchQuery);
        }
        if (viewState == null) {
            return;
        }
        if (viewState instanceof EmojiPickerViewModel.ViewState.EmptySearch) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputEmojiPickerViewFlipper");
            appViewFlipper.setDisplayedChild(1);
            setEmojiPickerBottomBarVisible(false);
            unit = Unit.a;
        } else {
            if (!(viewState instanceof EmojiPickerViewModel.ViewState.Results)) {
                throw new NoWhenBranchMatchedException();
            }
            EmojiPickerViewModel.ViewState.Results results = (EmojiPickerViewModel.ViewState.Results) viewState;
            setEmojiPickerBottomBarVisible(results.getShowBottomBar());
            AppViewFlipper appViewFlipper2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.chatInputEmojiPickerViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
            if (widgetEmojiAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter.setData(results.getResultItems());
            WidgetEmojiAdapter widgetEmojiAdapter2 = this.emojiAdapter;
            if (widgetEmojiAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter2.setOnScrollPositionListener(new AnonymousClass1(viewState));
            EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
            if (emojiCategoryAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            emojiCategoryAdapter.setItems(results.getCategoryItems());
            configureUnicodeCategoriesShortcutButton(viewState);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
        this.previousViewState = viewState;
    }

    private final void configureUnicodeCategoriesShortcutButton(EmojiPickerViewModel.ViewState viewState) {
        if (!(viewState instanceof EmojiPickerViewModel.ViewState.Results)) {
            viewState = null;
        }
        EmojiPickerViewModel.ViewState.Results results = (EmojiPickerViewModel.ViewState.Results) viewState;
        if (results != null) {
            EmojiCategoryItem.StandardItem firstUnicodeEmojiCategoryItem = results.getFirstUnicodeEmojiCategoryItem();
            if (firstUnicodeEmojiCategoryItem != null) {
                getBinding().k.setImageDrawable(ContextCompat.getDrawable(requireContext(), EmojiCategoryViewHolder.INSTANCE.getCategoryIconResId(firstUnicodeEmojiCategoryItem.getEmojiCategory())));
            }
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
            if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindLastCompletelyVisibleItemPosition == -1) {
                return;
            }
            EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
            if (emojiCategoryAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            if (iFindLastCompletelyVisibleItemPosition >= emojiCategoryAdapter.getPageSize()) {
                return;
            }
            EmojiCategoryAdapter emojiCategoryAdapter2 = this.categoryAdapter;
            if (emojiCategoryAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            EmojiCategoryItem itemAtPosition = emojiCategoryAdapter2.getItemAtPosition(iFindFirstCompletelyVisibleItemPosition);
            EmojiCategoryAdapter emojiCategoryAdapter3 = this.categoryAdapter;
            if (emojiCategoryAdapter3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            boolean z2 = itemAtPosition.containsOnlyUnicodeEmoji() || emojiCategoryAdapter3.getItemAtPosition(iFindLastCompletelyVisibleItemPosition).containsOnlyUnicodeEmoji();
            ImageView imageView = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.emojiPickerUnicodeEmojiShortcutButton");
            imageView.setVisibility((z2 || firstUnicodeEmojiCategoryItem == null) ? false : true ? 0 : 8);
        }
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build.VERSION.SDK_INT >= 29) {
            return DimenUtils.dpToPixels(8);
        }
        return 0;
    }

    private final WidgetEmojiPickerBinding getBinding() {
        return (WidgetEmojiPickerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final EmojiPickerContextType getEmojiPickerContextType() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE) : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiPickerContextType");
        return (EmojiPickerContextType) serializable;
    }

    private final EmojiPickerMode getMode() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("MODE") : null;
        EmojiPickerMode emojiPickerMode = (EmojiPickerMode) (serializable instanceof EmojiPickerMode ? serializable : null);
        return emojiPickerMode != null ? emojiPickerMode : EmojiPickerMode.INLINE;
    }

    private final EmojiPickerViewModel getViewModel() {
        return getMode() == EmojiPickerMode.INLINE ? getViewModelForInline() : getViewModelForSheet();
    }

    private final EmojiPickerViewModel.Inline getViewModelForInline() {
        return (EmojiPickerViewModel.Inline) this.viewModelForInline.getValue();
    }

    private final EmojiPickerViewModel.Sheet getViewModelForSheet() {
        return (EmojiPickerViewModel.Sheet) this.viewModelForSheet.getValue();
    }

    private final void handleEvent(EmojiPickerViewModel.Event event) {
        Unit unit;
        if (event instanceof EmojiPickerViewModel.Event.ScrollToEmojiListPosition) {
            WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
            if (widgetEmojiAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter.scrollToPosition(((EmojiPickerViewModel.Event.ScrollToEmojiListPosition) event).getPosition());
            unit = Unit.a;
        } else {
            if (!(event instanceof EmojiPickerViewModel.Event.ShowPremiumUpsellDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            MultiValuePropPremiumUpsellDialog.Companion bVar = MultiValuePropPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerViewModel.Event.ShowPremiumUpsellDialog showPremiumUpsellDialog = (EmojiPickerViewModel.Event.ShowPremiumUpsellDialog) event;
            MultiValuePropPremiumUpsellDialog.Companion.a(bVar, parentFragmentManager, showPremiumUpsellDialog.getPageNumber(), FormatUtils.e(this, showPremiumUpsellDialog.getHeader(), new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null).toString(), FormatUtils.e(this, showPremiumUpsellDialog.getBody(), new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null).toString(), null, showPremiumUpsellDialog.getSectionName(), null, null, showPremiumUpsellDialog.getShowOtherPages(), showPremiumUpsellDialog.getShowLearnMore(), 208);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void handleInputChanged(String input) {
        getViewModel().setSearchText(input);
        boolean z2 = input.length() == 0;
        getBinding().l.setImageResource(z2 ? R.drawable.ic_search_16dp : R.drawable.ic_clear_white_24dp);
        ImageView imageView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.emojiSearchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(requireContext(), R.attr.colorTextMuted)) : ColorStateList.valueOf(ColorCompat.getThemedColor(requireContext(), R.attr.colorTextNormal)));
        if (z2) {
            ImageView imageView2 = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.emojiSearchClear");
            imageView2.setContentDescription(FormatUtils.e(this, R.string.search_emojis, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            ImageView imageView3 = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.emojiSearchClear");
            imageView3.setImportantForAccessibility(2);
            return;
        }
        ImageView imageView4 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.emojiSearchClear");
        imageView4.setContentDescription(FormatUtils.e(this, R.string.reset, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        ImageView imageView5 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.emojiSearchClear");
        imageView5.setImportantForAccessibility(1);
    }

    private final void handleNewEmojiRecyclerScrollPosition(int emojiRecyclerScrollPosition, List<? extends EmojiCategoryItem> emojiCategoryItems) {
        for (EmojiCategoryItem emojiCategoryItem : emojiCategoryItems) {
            Tuples2<Integer, Integer> categoryRange = emojiCategoryItem.getCategoryRange();
            int iIntValue = categoryRange.getFirst().intValue();
            int iIntValue2 = categoryRange.getSecond().intValue();
            if (iIntValue <= emojiRecyclerScrollPosition && iIntValue2 > emojiRecyclerScrollPosition && !emojiCategoryItem.getIsSelected()) {
                selectCategoryByItemId(emojiCategoryItem.getStableId());
                return;
            }
        }
    }

    private final void initializeInputButtons() {
        boolean z2 = this.emojiPickerMode == EmojiPickerMode.INLINE;
        ImageView imageView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.emojiPickerBackspaceIcon");
        imageView.setVisibility(z2 ? 0 : 8);
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeInputButtons.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEmojiPicker.this.isNextCategoryScrollSmooth = false;
                WidgetEmojiPicker.this.getViewModel().onClickUnicodeEmojiCategories();
            }
        });
        getBinding().f.setOnTouchListener(new RepeatingOnTouchListener(250L, 50L, TimeUnit.MILLISECONDS, new Action0() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeInputButtons.2
            @Override // rx.functions.Action0
            public final void call() {
                OnBackspacePressedListener onBackspacePressedListener = WidgetEmojiPicker.this.onBackspacePressedListener;
                if (onBackspacePressedListener != null) {
                    onBackspacePressedListener.onBackspacePressed();
                }
            }
        }, new Action0() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeInputButtons.3
            @Override // rx.functions.Action0
            public final void call() {
                WidgetEmojiPicker widgetEmojiPicker = WidgetEmojiPicker.this;
                try {
                    Result2.a aVar = Result2.j;
                    Result2.m97constructorimpl(Boolean.valueOf(widgetEmojiPicker.getBinding().f.performHapticFeedback(3)));
                } catch (Throwable th) {
                    Result2.a aVar2 = Result2.j;
                    Result2.m97constructorimpl(Result3.createFailure(th));
                }
                OnBackspacePressedListener onBackspacePressedListener = WidgetEmojiPicker.this.onBackspacePressedListener;
                if (onBackspacePressedListener != null) {
                    onBackspacePressedListener.onBackspacePressed();
                }
            }
        }));
    }

    private final void initializeSearchBar() {
        AppBarLayout appBarLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.emojiAppBar");
        EmojiPickerMode emojiPickerMode = this.emojiPickerMode;
        EmojiPickerMode emojiPickerMode2 = EmojiPickerMode.INLINE;
        appBarLayout.setVisibility(emojiPickerMode != emojiPickerMode2 ? 0 : 8);
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.emojiInlineSearchButton");
        textView.setVisibility(this.emojiPickerMode == emojiPickerMode2 ? 0 : 8);
        TextInputEditText textInputEditText = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.emojiSearchInput");
        textInputEditText.setVisibility(this.emojiPickerMode != emojiPickerMode2 ? 0 : 8);
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeSearchBar.1

            /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$initializeSearchBar$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
            @DebugMetadata(c = "com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$initializeSearchBar$1$1", f = "WidgetEmojiPicker.kt", l = {412}, m = "invokeSuspend")
            public static final class C02581 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public int label;

                public C02581(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // d0.w.i.a.ContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Intrinsics3.checkNotNullParameter(continuation, "completion");
                    return AnonymousClass1.this.new C02581(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C02581) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
                }

                @Override // d0.w.i.a.ContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        Result3.throwOnFailure(obj);
                        this.label = 1;
                        if (f.P(250L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Result3.throwOnFailure(obj);
                    }
                    Function0 function0 = WidgetEmojiPicker.this.onEmojiSearchOpenedListener;
                    if (function0 != null) {
                    }
                    return Unit.a;
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(view);
                if (coroutineScope != null) {
                    f.H0(coroutineScope, null, null, new C02581(null), 3, null);
                }
                WidgetEmojiPicker.this.launchBottomSheet();
            }
        });
        getBinding().l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeSearchBar.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (WidgetEmojiPicker.this.emojiPickerMode == EmojiPickerMode.INLINE) {
                    WidgetEmojiPicker.this.launchBottomSheet();
                } else {
                    WidgetEmojiPicker.this.getBinding().m.setText("");
                }
            }
        });
        TextInputEditText textInputEditText2 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.emojiSearchInput");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText2, this, new AnonymousClass3());
        if (this.emojiPickerMode == EmojiPickerMode.BOTTOM_SHEET) {
            getBinding().m.requestFocus();
            TextInputEditText textInputEditText3 = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText3, "binding.emojiSearchInput");
            showKeyboard(textInputEditText3);
        }
    }

    private final void launchBottomSheet() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, this.emojiPickerListener, getEmojiPickerContextType(), null, 8, null);
    }

    private final void onCategoryClicked(EmojiCategoryItem emojiCategoryItem) {
        if (emojiCategoryItem instanceof EmojiCategoryItem.GuildItem) {
            AnalyticsTracker.INSTANCE.emojiCategorySelected(((EmojiCategoryItem.GuildItem) emojiCategoryItem).getGuild().getId());
        }
        selectCategoryByItemId(emojiCategoryItem.getStableId());
        Tuples2<Integer, Integer> categoryRange = emojiCategoryItem.getCategoryRange();
        WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
        if (widgetEmojiAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        widgetEmojiAdapter.scrollToPosition(categoryRange.getFirst().intValue());
    }

    private final void onPremiumCtaClicked() {
        WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, requireContext(), null, null, 6, null);
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
        EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
        if (emojiCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        int iMin = Math.min(iMax, emojiCategoryAdapter.getPageSize() - 1);
        if (this.isNextCategoryScrollSmooth) {
            getBinding().i.smoothScrollToPosition(iMin);
        } else {
            getBinding().i.scrollToPosition(iMin);
            this.isNextCategoryScrollSmooth = true;
        }
    }

    private final void selectCategoryByItemId(long itemId) {
        getViewModel().setSelectedCategoryItemId(itemId);
    }

    private final void setEmojiPickerBottomBarVisible(boolean visible) {
        ConstraintLayout constraintLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.emojiPickerBottomBar");
        constraintLayout.setVisibility(visible ? 0 : 8);
        View view = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.emojiPickerBottomBarDivider");
        view.setVisibility(visible ? 0 : 8);
        RecyclerView recyclerView = getBinding().f2376b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputEmojiPickerRecycler");
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, visible ? getResources().getDimensionPixelSize(R.dimen.expression_picker_category_bar_height) : 0);
        recyclerView.setLayoutParams(marginLayoutParams);
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.emojiPickerCategoryRecycler");
        recyclerView.setItemAnimator(null);
        EmojiCategoryAdapter emojiCategoryAdapter = new EmojiCategoryAdapter(new AnonymousClass1(this), new AnonymousClass2(this), this, null, 8, null);
        this.categoryAdapter = emojiCategoryAdapter;
        if (emojiCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        emojiCategoryAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.emojiPickerCategoryRecycler");
        EmojiCategoryAdapter emojiCategoryAdapter2 = this.categoryAdapter;
        if (emojiCategoryAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView2.setAdapter(emojiCategoryAdapter2);
        RecyclerView recyclerView3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.emojiPickerCategoryRecycler");
        EmojiCategoryAdapter emojiCategoryAdapter3 = this.categoryAdapter;
        if (emojiCategoryAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        this.categoryLayoutManager = new SelfHealingLinearLayoutManager(recyclerView3, emojiCategoryAdapter3, 0, false, 8, null);
        RecyclerView recyclerView4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.emojiPickerCategoryRecycler");
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        recyclerView4.setLayoutManager(linearLayoutManager);
        getBinding().i.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.setUpCategoryRecycler.3
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                Intrinsics3.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrolled(recyclerView5, dx, dy);
                WidgetEmojiPicker.this.emojiCategoryScrollSubject.k.onNext((T) Unit.a);
            }
        });
    }

    private final void setUpEmojiRecycler() {
        RecyclerView recyclerView = getBinding().f2376b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputEmojiPickerRecycler");
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = getBinding().f2376b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatInputEmojiPickerRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetEmojiAdapter widgetEmojiAdapter = new WidgetEmojiAdapter(recyclerView2, parentFragmentManager, this, new AnonymousClass1(this), new AnonymousClass2());
        this.emojiAdapter = widgetEmojiAdapter;
        if (widgetEmojiAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(widgetEmojiAdapter);
        getBinding().f2376b.addItemDecoration(stickyHeaderItemDecoration);
        RecyclerView recyclerView3 = getBinding().f2376b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.chatInputEmojiPickerRecycler");
        stickyHeaderItemDecoration.blockClicks(recyclerView3);
        getBinding().f2376b.setHasFixedSize(true);
        getBinding().f2376b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.setUpEmojiRecycler.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                Intrinsics3.checkNotNullParameter(recyclerView4, "recyclerView");
                WidgetEmojiPicker.this.checkUpsellHeaderVisibility(recyclerView4);
            }
        });
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().j, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), WidgetEmojiPicker.this.getAdditionalBottomPaddingPx() + windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    private final void subscribeToCategoryRecyclerScrolls() {
        PublishSubject<Unit> publishSubject = this.emojiCategoryScrollSubject;
        Observable observableH0 = Observable.h0(new OnSubscribeLift(publishSubject.j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "emojiCategoryScrollSubje…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableH0, this, null, 2, null), (Class<?>) WidgetEmojiPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void clearSearchInput() {
        getViewModel().setSearchText("");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.emojiPickerMode = getMode();
    }

    @Override // com.discord.widgets.chat.input.emoji.OnEmojiSelectedListener
    public void onEmojiSelected(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        getViewModel().onEmojiSelected(emoji, new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        CoordinatorLayout coordinatorLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.emojiPickerContainer");
        coordinatorLayout.setPadding(coordinatorLayout.getPaddingLeft(), coordinatorLayout.getPaddingTop(), coordinatorLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        EmojiPickerMode mode = getMode();
        EmojiPickerMode emojiPickerMode = EmojiPickerMode.INLINE;
        if (mode == emojiPickerMode) {
            setWindowInsetsListeners();
        }
        initializeInputButtons();
        initializeSearchBar();
        Toolbar toolbar = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.emojiToolbar");
        ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(this.emojiPickerMode == emojiPickerMode ? 5 : 0);
        setUpEmojiRecycler();
        setUpCategoryRecycler();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEmojiPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetEmojiPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        subscribeToCategoryRecyclerScrolls();
    }

    public final void scrollToTop() {
        WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
        if (widgetEmojiAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        if (widgetEmojiAdapter.getPageSize() > 0) {
            getBinding().f2376b.scrollToPosition(0);
        }
    }

    public final void setListener(EmojiPickerListener emojiPickerListener) {
        this.emojiPickerListener = emojiPickerListener;
    }

    public final void setOnBackspacePressedListener(OnBackspacePressedListener onBackspacePressedListener) {
        this.onBackspacePressedListener = onBackspacePressedListener;
    }
}
