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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiPickerBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.press.RepeatingOnTouchListener;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p009a.p012b.C0811c;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p643a.C12666r;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker extends AppFragment implements OnEmojiSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEmojiPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEmojiPickerBinding;", 0)};
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$configureUI$1 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78221 extends AbstractC12240o implements Function1<Integer, Unit> {
        public final /* synthetic */ EmojiPickerViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C78221(EmojiPickerViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetEmojiPicker.this.handleNewEmojiRecyclerScrollPosition(i, ((EmojiPickerViewModel.ViewState.Results) this.$viewState).getCategoryItems());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$initializeSearchBar$3 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78283 extends AbstractC12240o implements Function1<String, Unit> {
        public C78283() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "input");
            WidgetEmojiPicker.this.handleInputChanged(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$onEmojiSelected$1 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78291 extends AbstractC12240o implements Function1<Emoji, Unit> {
        public C78291() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
            invoke2(emoji);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Emoji emoji) {
            C12238m.checkNotNullParameter(emoji, "validEmoji");
            EmojiPickerListener emojiPickerListener = WidgetEmojiPicker.this.emojiPickerListener;
            if (emojiPickerListener != null) {
                emojiPickerListener.onEmojiPicked(emoji);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78301 extends AbstractC12240o implements Function1<EmojiPickerViewModel.ViewState, Unit> {
        public C78301() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiPickerViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiPickerViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetEmojiPicker.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78312 extends AbstractC12240o implements Function1<EmojiPickerViewModel.Event, Unit> {
        public C78312() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiPickerViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiPickerViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetEmojiPicker.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpCategoryRecycler$1 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final /* synthetic */ class C78321 extends C12236k implements Function1<EmojiCategoryItem, Unit> {
        public C78321(WidgetEmojiPicker widgetEmojiPicker) {
            super(1, widgetEmojiPicker, WidgetEmojiPicker.class, "onCategoryClicked", "onCategoryClicked(Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiCategoryItem emojiCategoryItem) {
            invoke2(emojiCategoryItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiCategoryItem emojiCategoryItem) {
            C12238m.checkNotNullParameter(emojiCategoryItem, "p1");
            ((WidgetEmojiPicker) this.receiver).onCategoryClicked(emojiCategoryItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpCategoryRecycler$2 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final /* synthetic */ class C78332 extends C12236k implements Function1<Integer, Unit> {
        public C78332(WidgetEmojiPicker widgetEmojiPicker) {
            super(1, widgetEmojiPicker, WidgetEmojiPicker.class, "onSelectedCategoryAdapterPositionUpdated", "onSelectedCategoryAdapterPositionUpdated(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            ((WidgetEmojiPicker) this.receiver).onSelectedCategoryAdapterPositionUpdated(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpEmojiRecycler$1 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final /* synthetic */ class C78351 extends C12236k implements Function0<Unit> {
        public C78351(WidgetEmojiPicker widgetEmojiPicker) {
            super(0, widgetEmojiPicker, WidgetEmojiPicker.class, "onPremiumCtaClicked", "onPremiumCtaClicked()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetEmojiPicker) this.receiver).onPremiumCtaClicked();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$setUpEmojiRecycler$2 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78362 extends AbstractC12240o implements Function0<Unit> {
        public C78362() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetEmojiPicker widgetEmojiPicker = WidgetEmojiPicker.this;
            widgetEmojiPicker.hideKeyboard(widgetEmojiPicker.getView());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$subscribeToCategoryRecyclerScrolls$1 */
    /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
    public static final class C78391 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C78391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetEmojiPicker widgetEmojiPicker = WidgetEmojiPicker.this;
            widgetEmojiPicker.configureUnicodeCategoriesShortcutButton(widgetEmojiPicker.previousViewState);
        }
    }

    public WidgetEmojiPicker() {
        super(C5419R.layout.widget_emoji_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEmojiPicker$binding$2.INSTANCE, null, 2, null);
        this.viewModelForInline = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(EmojiPickerViewModel.Inline.class), new C7818x642fc3ef(this), new C0863f0(new WidgetEmojiPicker$viewModelForInline$2(this)));
        this.viewModelForSheet = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(EmojiPickerViewModel.Sheet.class), new C7820x642fc3f1(this), new C0863f0(new WidgetEmojiPicker$viewModelForSheet$2(this)));
        this.emojiCategoryScrollSubject = PublishSubject.m11133k0();
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
                if (stringHeaderItem != null && stringHeaderItem.getStringRes() == C5419R.string.emoji_available_with_premium) {
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
            getBinding().f16563m.setText(searchQuery);
        }
        if (viewState == null) {
            return;
        }
        if (viewState instanceof EmojiPickerViewModel.ViewState.EmptySearch) {
            AppViewFlipper appViewFlipper = getBinding().f16553c;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputEmojiPickerViewFlipper");
            appViewFlipper.setDisplayedChild(1);
            setEmojiPickerBottomBarVisible(false);
            unit = Unit.f27425a;
        } else {
            if (!(viewState instanceof EmojiPickerViewModel.ViewState.Results)) {
                throw new NoWhenBranchMatchedException();
            }
            EmojiPickerViewModel.ViewState.Results results = (EmojiPickerViewModel.ViewState.Results) viewState;
            setEmojiPickerBottomBarVisible(results.getShowBottomBar());
            AppViewFlipper appViewFlipper2 = getBinding().f16553c;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.chatInputEmojiPickerViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
            if (widgetEmojiAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter.setData(results.getResultItems());
            WidgetEmojiAdapter widgetEmojiAdapter2 = this.emojiAdapter;
            if (widgetEmojiAdapter2 == null) {
                C12238m.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter2.setOnScrollPositionListener(new C78221(viewState));
            EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
            if (emojiCategoryAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            emojiCategoryAdapter.setItems(results.getCategoryItems());
            configureUnicodeCategoriesShortcutButton(viewState);
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
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
                getBinding().f16561k.setImageDrawable(ContextCompat.getDrawable(requireContext(), EmojiCategoryViewHolder.INSTANCE.getCategoryIconResId(firstUnicodeEmojiCategoryItem.getEmojiCategory())));
            }
            LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
            if (linearLayoutManager == null) {
                C12238m.throwUninitializedPropertyAccessException("categoryLayoutManager");
            }
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            LinearLayoutManager linearLayoutManager2 = this.categoryLayoutManager;
            if (linearLayoutManager2 == null) {
                C12238m.throwUninitializedPropertyAccessException("categoryLayoutManager");
            }
            int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
            if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindLastCompletelyVisibleItemPosition == -1) {
                return;
            }
            EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
            if (emojiCategoryAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            if (iFindLastCompletelyVisibleItemPosition >= emojiCategoryAdapter.getPageSize()) {
                return;
            }
            EmojiCategoryAdapter emojiCategoryAdapter2 = this.categoryAdapter;
            if (emojiCategoryAdapter2 == null) {
                C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            EmojiCategoryItem itemAtPosition = emojiCategoryAdapter2.getItemAtPosition(iFindFirstCompletelyVisibleItemPosition);
            EmojiCategoryAdapter emojiCategoryAdapter3 = this.categoryAdapter;
            if (emojiCategoryAdapter3 == null) {
                C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            boolean z2 = itemAtPosition.containsOnlyUnicodeEmoji() || emojiCategoryAdapter3.getItemAtPosition(iFindLastCompletelyVisibleItemPosition).containsOnlyUnicodeEmoji();
            ImageView imageView = getBinding().f16561k;
            C12238m.checkNotNullExpressionValue(imageView, "binding.emojiPickerUnicodeEmojiShortcutButton");
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
                C12238m.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter.scrollToPosition(((EmojiPickerViewModel.Event.ScrollToEmojiListPosition) event).getPosition());
            unit = Unit.f27425a;
        } else {
            if (!(event instanceof EmojiPickerViewModel.Event.ShowPremiumUpsellDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            C0811c.Companion bVar = C0811c.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerViewModel.Event.ShowPremiumUpsellDialog showPremiumUpsellDialog = (EmojiPickerViewModel.Event.ShowPremiumUpsellDialog) event;
            C0811c.Companion.m114a(bVar, parentFragmentManager, showPremiumUpsellDialog.getPageNumber(), C1107b.m213e(this, showPremiumUpsellDialog.getHeader(), new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null).toString(), C1107b.m213e(this, showPremiumUpsellDialog.getBody(), new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null).toString(), null, showPremiumUpsellDialog.getSectionName(), null, null, showPremiumUpsellDialog.getShowOtherPages(), showPremiumUpsellDialog.getShowLearnMore(), 208);
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void handleInputChanged(String input) {
        getViewModel().setSearchText(input);
        boolean z2 = input.length() == 0;
        getBinding().f16562l.setImageResource(z2 ? C5419R.drawable.ic_search_16dp : C5419R.drawable.ic_clear_white_24dp);
        ImageView imageView = getBinding().f16562l;
        C12238m.checkNotNullExpressionValue(imageView, "binding.emojiSearchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorTextMuted)) : ColorStateList.valueOf(ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorTextNormal)));
        if (z2) {
            ImageView imageView2 = getBinding().f16562l;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.emojiSearchClear");
            imageView2.setContentDescription(C1107b.m213e(this, C5419R.string.search_emojis, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            ImageView imageView3 = getBinding().f16562l;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.emojiSearchClear");
            imageView3.setImportantForAccessibility(2);
            return;
        }
        ImageView imageView4 = getBinding().f16562l;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.emojiSearchClear");
        imageView4.setContentDescription(C1107b.m213e(this, C5419R.string.reset, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        ImageView imageView5 = getBinding().f16562l;
        C12238m.checkNotNullExpressionValue(imageView5, "binding.emojiSearchClear");
        imageView5.setImportantForAccessibility(1);
    }

    private final void handleNewEmojiRecyclerScrollPosition(int emojiRecyclerScrollPosition, List<? extends EmojiCategoryItem> emojiCategoryItems) {
        for (EmojiCategoryItem emojiCategoryItem : emojiCategoryItems) {
            Pair<Integer, Integer> categoryRange = emojiCategoryItem.getCategoryRange();
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
        ImageView imageView = getBinding().f16556f;
        C12238m.checkNotNullExpressionValue(imageView, "binding.emojiPickerBackspaceIcon");
        imageView.setVisibility(z2 ? 0 : 8);
        getBinding().f16561k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeInputButtons.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEmojiPicker.this.isNextCategoryScrollSmooth = false;
                WidgetEmojiPicker.this.getViewModel().onClickUnicodeEmojiCategories();
            }
        });
        getBinding().f16556f.setOnTouchListener(new RepeatingOnTouchListener(250L, 50L, TimeUnit.MILLISECONDS, new Action0() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeInputButtons.2
            @Override // p658rx.functions.Action0
            public final void call() {
                OnBackspacePressedListener onBackspacePressedListener = WidgetEmojiPicker.this.onBackspacePressedListener;
                if (onBackspacePressedListener != null) {
                    onBackspacePressedListener.onBackspacePressed();
                }
            }
        }, new Action0() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeInputButtons.3
            @Override // p658rx.functions.Action0
            public final void call() {
                WidgetEmojiPicker widgetEmojiPicker = WidgetEmojiPicker.this;
                try {
                    C12112k.a aVar = C12112k.f25169j;
                    C12112k.m11474constructorimpl(Boolean.valueOf(widgetEmojiPicker.getBinding().f16556f.performHapticFeedback(3)));
                } catch (Throwable th) {
                    C12112k.a aVar2 = C12112k.f25169j;
                    C12112k.m11474constructorimpl(C12113l.createFailure(th));
                }
                OnBackspacePressedListener onBackspacePressedListener = WidgetEmojiPicker.this.onBackspacePressedListener;
                if (onBackspacePressedListener != null) {
                    onBackspacePressedListener.onBackspacePressed();
                }
            }
        }));
    }

    private final void initializeSearchBar() {
        AppBarLayout appBarLayout = getBinding().f16554d;
        C12238m.checkNotNullExpressionValue(appBarLayout, "binding.emojiAppBar");
        EmojiPickerMode emojiPickerMode = this.emojiPickerMode;
        EmojiPickerMode emojiPickerMode2 = EmojiPickerMode.INLINE;
        appBarLayout.setVisibility(emojiPickerMode != emojiPickerMode2 ? 0 : 8);
        TextView textView = getBinding().f16555e;
        C12238m.checkNotNullExpressionValue(textView, "binding.emojiInlineSearchButton");
        textView.setVisibility(this.emojiPickerMode == emojiPickerMode2 ? 0 : 8);
        TextInputEditText textInputEditText = getBinding().f16563m;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.emojiSearchInput");
        textInputEditText.setVisibility(this.emojiPickerMode != emojiPickerMode2 ? 0 : 8);
        getBinding().f16555e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeSearchBar.1

            /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$initializeSearchBar$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetEmojiPicker.kt */
            @InterfaceC12188e(m10084c = "com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$initializeSearchBar$1$1", m10085f = "WidgetEmojiPicker.kt", m10086l = {412}, m10087m = "invokeSuspend")
            public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public int label;

                public AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C12238m.checkNotNullParameter(continuation, "completion");
                    return ViewOnClickListenerC78261.this.new AnonymousClass1(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        C12113l.throwOnFailure(obj);
                        this.label = 1;
                        if (C3404f.m4234P(250L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C12113l.throwOnFailure(obj);
                    }
                    Function0 function0 = WidgetEmojiPicker.this.onEmojiSearchOpenedListener;
                    if (function0 != null) {
                    }
                    return Unit.f27425a;
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12238m.checkNotNullExpressionValue(view, "view");
                CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
                if (coroutineScope != null) {
                    C3404f.m4211H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                }
                WidgetEmojiPicker.this.launchBottomSheet();
            }
        });
        getBinding().f16562l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.initializeSearchBar.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (WidgetEmojiPicker.this.emojiPickerMode == EmojiPickerMode.INLINE) {
                    WidgetEmojiPicker.this.launchBottomSheet();
                } else {
                    WidgetEmojiPicker.this.getBinding().f16563m.setText("");
                }
            }
        });
        TextInputEditText textInputEditText2 = getBinding().f16563m;
        C12238m.checkNotNullExpressionValue(textInputEditText2, "binding.emojiSearchInput");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText2, this, new C78283());
        if (this.emojiPickerMode == EmojiPickerMode.BOTTOM_SHEET) {
            getBinding().f16563m.requestFocus();
            TextInputEditText textInputEditText3 = getBinding().f16563m;
            C12238m.checkNotNullExpressionValue(textInputEditText3, "binding.emojiSearchInput");
            showKeyboard(textInputEditText3);
        }
    }

    private final void launchBottomSheet() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, this.emojiPickerListener, getEmojiPickerContextType(), null, 8, null);
    }

    private final void onCategoryClicked(EmojiCategoryItem emojiCategoryItem) {
        if (emojiCategoryItem instanceof EmojiCategoryItem.GuildItem) {
            AnalyticsTracker.INSTANCE.emojiCategorySelected(((EmojiCategoryItem.GuildItem) emojiCategoryItem).getGuild().getId());
        }
        selectCategoryByItemId(emojiCategoryItem.getStableId());
        Pair<Integer, Integer> categoryRange = emojiCategoryItem.getCategoryRange();
        WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
        if (widgetEmojiAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        widgetEmojiAdapter.scrollToPosition(categoryRange.getFirst().intValue());
    }

    private final void onPremiumCtaClicked() {
        WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, requireContext(), null, null, 6, null);
    }

    private final void onSelectedCategoryAdapterPositionUpdated(int selectedCategoryPosition) {
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.categoryLayoutManager;
        if (linearLayoutManager2 == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
        int i = iFindLastCompletelyVisibleItemPosition - iFindFirstCompletelyVisibleItemPosition;
        if (new IntRange(iFindFirstCompletelyVisibleItemPosition, iFindLastCompletelyVisibleItemPosition).contains(selectedCategoryPosition)) {
            return;
        }
        int iMax = Math.max(selectedCategoryPosition < iFindFirstCompletelyVisibleItemPosition ? selectedCategoryPosition - i : selectedCategoryPosition + i, 0);
        EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
        if (emojiCategoryAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        int iMin = Math.min(iMax, emojiCategoryAdapter.getPageSize() - 1);
        if (this.isNextCategoryScrollSmooth) {
            getBinding().f16559i.smoothScrollToPosition(iMin);
        } else {
            getBinding().f16559i.scrollToPosition(iMin);
            this.isNextCategoryScrollSmooth = true;
        }
    }

    private final void selectCategoryByItemId(long itemId) {
        getViewModel().setSelectedCategoryItemId(itemId);
    }

    private final void setEmojiPickerBottomBarVisible(boolean visible) {
        ConstraintLayout constraintLayout = getBinding().f16557g;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.emojiPickerBottomBar");
        constraintLayout.setVisibility(visible ? 0 : 8);
        View view = getBinding().f16558h;
        C12238m.checkNotNullExpressionValue(view, "binding.emojiPickerBottomBarDivider");
        view.setVisibility(visible ? 0 : 8);
        RecyclerView recyclerView = getBinding().f16552b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatInputEmojiPickerRecycler");
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, visible ? getResources().getDimensionPixelSize(C5419R.dimen.expression_picker_category_bar_height) : 0);
        recyclerView.setLayoutParams(marginLayoutParams);
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().f16559i;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.emojiPickerCategoryRecycler");
        recyclerView.setItemAnimator(null);
        EmojiCategoryAdapter emojiCategoryAdapter = new EmojiCategoryAdapter(new C78321(this), new C78332(this), this, null, 8, null);
        this.categoryAdapter = emojiCategoryAdapter;
        if (emojiCategoryAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        emojiCategoryAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().f16559i;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.emojiPickerCategoryRecycler");
        EmojiCategoryAdapter emojiCategoryAdapter2 = this.categoryAdapter;
        if (emojiCategoryAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView2.setAdapter(emojiCategoryAdapter2);
        RecyclerView recyclerView3 = getBinding().f16559i;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.emojiPickerCategoryRecycler");
        EmojiCategoryAdapter emojiCategoryAdapter3 = this.categoryAdapter;
        if (emojiCategoryAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        this.categoryLayoutManager = new SelfHealingLinearLayoutManager(recyclerView3, emojiCategoryAdapter3, 0, false, 8, null);
        RecyclerView recyclerView4 = getBinding().f16559i;
        C12238m.checkNotNullExpressionValue(recyclerView4, "binding.emojiPickerCategoryRecycler");
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            C12238m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        recyclerView4.setLayoutManager(linearLayoutManager);
        getBinding().f16559i.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.setUpCategoryRecycler.3
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                C12238m.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrolled(recyclerView5, dx, dy);
                WidgetEmojiPicker.this.emojiCategoryScrollSubject.f27650k.onNext((T) Unit.f27425a);
            }
        });
    }

    private final void setUpEmojiRecycler() {
        RecyclerView recyclerView = getBinding().f16552b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatInputEmojiPickerRecycler");
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = getBinding().f16552b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputEmojiPickerRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetEmojiAdapter widgetEmojiAdapter = new WidgetEmojiAdapter(recyclerView2, parentFragmentManager, this, new C78351(this), new C78362());
        this.emojiAdapter = widgetEmojiAdapter;
        if (widgetEmojiAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(widgetEmojiAdapter);
        getBinding().f16552b.addItemDecoration(stickyHeaderItemDecoration);
        RecyclerView recyclerView3 = getBinding().f16552b;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.chatInputEmojiPickerRecycler");
        stickyHeaderItemDecoration.blockClicks(recyclerView3);
        getBinding().f16552b.setHasFixedSize(true);
        getBinding().f16552b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.setUpEmojiRecycler.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                C12238m.checkNotNullParameter(recyclerView4, "recyclerView");
                WidgetEmojiPicker.this.checkUpsellHeaderVisibility(recyclerView4);
            }
        });
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16560j, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "view");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), WidgetEmojiPicker.this.getAdditionalBottomPaddingPx() + windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    private final void subscribeToCategoryRecyclerScrolls() {
        PublishSubject<Unit> publishSubject = this.emojiCategoryScrollSubject;
        Observable observableM11074h0 = Observable.m11074h0(new C12666r(publishSubject.f27640j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        C12238m.checkNotNullExpressionValue(observableM11074h0, "emojiCategoryScrollSubje…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11074h0, this, null, 2, null), (Class<?>) WidgetEmojiPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78391());
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
        C12238m.checkNotNullParameter(emoji, "emoji");
        getViewModel().onEmojiSelected(emoji, new C78291());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        CoordinatorLayout coordinatorLayout = getBinding().f16560j;
        C12238m.checkNotNullExpressionValue(coordinatorLayout, "binding.emojiPickerContainer");
        coordinatorLayout.setPadding(coordinatorLayout.getPaddingLeft(), coordinatorLayout.getPaddingTop(), coordinatorLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        EmojiPickerMode mode = getMode();
        EmojiPickerMode emojiPickerMode = EmojiPickerMode.INLINE;
        if (mode == emojiPickerMode) {
            setWindowInsetsListeners();
        }
        initializeInputButtons();
        initializeSearchBar();
        Toolbar toolbar = getBinding().f16564n;
        C12238m.checkNotNullExpressionValue(toolbar, "binding.emojiToolbar");
        ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(this.emojiPickerMode == emojiPickerMode ? 5 : 0);
        setUpEmojiRecycler();
        setUpCategoryRecycler();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEmojiPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78301());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetEmojiPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78312());
        subscribeToCategoryRecyclerScrolls();
    }

    public final void scrollToTop() {
        WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
        if (widgetEmojiAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        if (widgetEmojiAdapter.getPageSize() > 0) {
            getBinding().f16552b.scrollToPosition(0);
        }
    }

    public final void setListener(EmojiPickerListener emojiPickerListener) {
        this.emojiPickerListener = emojiPickerListener;
    }

    public final void setOnBackspacePressedListener(OnBackspacePressedListener onBackspacePressedListener) {
        this.onBackspacePressedListener = onBackspacePressedListener;
    }
}
