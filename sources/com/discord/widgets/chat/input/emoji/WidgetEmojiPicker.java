package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.a.b.c;
import b.a.a.b.c$b;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiPickerBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.press.RepeatingOnTouchListener;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$LayoutParams;
import com.google.android.material.textfield.TextInputEditText;
import d0.z.d.a0;
import d0.z.d.m;
import j0.l.a.r;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker extends AppFragment implements OnEmojiSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEmojiPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEmojiPickerBinding;", 0)};
    public static final WidgetEmojiPicker$Companion Companion = new WidgetEmojiPicker$Companion(null);
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
    private EmojiPickerViewModel$ViewState previousViewState;
    private boolean restoredSearchQueryFromViewModel;

    /* JADX INFO: renamed from: viewModelForInline$delegate, reason: from kotlin metadata */
    private final Lazy viewModelForInline;

    /* JADX INFO: renamed from: viewModelForSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelForSheet;

    public WidgetEmojiPicker() {
        super(R$layout.widget_emoji_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEmojiPicker$binding$2.INSTANCE, null, 2, null);
        this.viewModelForInline = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(EmojiPickerViewModel$Inline.class), new WidgetEmojiPicker$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetEmojiPicker$viewModelForInline$2(this)));
        this.viewModelForSheet = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(EmojiPickerViewModel$Sheet.class), new WidgetEmojiPicker$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetEmojiPicker$viewModelForSheet$2(this)));
        this.emojiCategoryScrollSubject = PublishSubject.k0();
        this.isNextCategoryScrollSmooth = true;
    }

    public static final /* synthetic */ void access$checkUpsellHeaderVisibility(WidgetEmojiPicker widgetEmojiPicker, RecyclerView recyclerView) {
        widgetEmojiPicker.checkUpsellHeaderVisibility(recyclerView);
    }

    public static final /* synthetic */ void access$configureUI(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerViewModel$ViewState emojiPickerViewModel$ViewState) {
        widgetEmojiPicker.configureUI(emojiPickerViewModel$ViewState);
    }

    public static final /* synthetic */ void access$configureUnicodeCategoriesShortcutButton(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerViewModel$ViewState emojiPickerViewModel$ViewState) {
        widgetEmojiPicker.configureUnicodeCategoriesShortcutButton(emojiPickerViewModel$ViewState);
    }

    public static final /* synthetic */ int access$getAdditionalBottomPaddingPx(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.getAdditionalBottomPaddingPx();
    }

    public static final /* synthetic */ WidgetEmojiPickerBinding access$getBinding$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.getBinding();
    }

    public static final /* synthetic */ PublishSubject access$getEmojiCategoryScrollSubject$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.emojiCategoryScrollSubject;
    }

    public static final /* synthetic */ EmojiPickerContextType access$getEmojiPickerContextType$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.getEmojiPickerContextType();
    }

    public static final /* synthetic */ EmojiPickerListener access$getEmojiPickerListener$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.emojiPickerListener;
    }

    public static final /* synthetic */ EmojiPickerMode access$getEmojiPickerMode$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.emojiPickerMode;
    }

    public static final /* synthetic */ OnBackspacePressedListener access$getOnBackspacePressedListener$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.onBackspacePressedListener;
    }

    public static final /* synthetic */ Function0 access$getOnEmojiSearchOpenedListener$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.onEmojiSearchOpenedListener;
    }

    public static final /* synthetic */ EmojiPickerViewModel$ViewState access$getPreviousViewState$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.previousViewState;
    }

    public static final /* synthetic */ EmojiPickerViewModel access$getViewModel$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerViewModel$Event emojiPickerViewModel$Event) {
        widgetEmojiPicker.handleEvent(emojiPickerViewModel$Event);
    }

    public static final /* synthetic */ void access$handleInputChanged(WidgetEmojiPicker widgetEmojiPicker, String str) {
        widgetEmojiPicker.handleInputChanged(str);
    }

    public static final /* synthetic */ void access$handleNewEmojiRecyclerScrollPosition(WidgetEmojiPicker widgetEmojiPicker, int i, List list) {
        widgetEmojiPicker.handleNewEmojiRecyclerScrollPosition(i, list);
    }

    public static final /* synthetic */ boolean access$isNextCategoryScrollSmooth$p(WidgetEmojiPicker widgetEmojiPicker) {
        return widgetEmojiPicker.isNextCategoryScrollSmooth;
    }

    public static final /* synthetic */ void access$launchBottomSheet(WidgetEmojiPicker widgetEmojiPicker) {
        widgetEmojiPicker.launchBottomSheet();
    }

    public static final /* synthetic */ void access$onCategoryClicked(WidgetEmojiPicker widgetEmojiPicker, EmojiCategoryItem emojiCategoryItem) {
        widgetEmojiPicker.onCategoryClicked(emojiCategoryItem);
    }

    public static final /* synthetic */ void access$onPremiumCtaClicked(WidgetEmojiPicker widgetEmojiPicker) {
        widgetEmojiPicker.onPremiumCtaClicked();
    }

    public static final /* synthetic */ void access$onSelectedCategoryAdapterPositionUpdated(WidgetEmojiPicker widgetEmojiPicker, int i) {
        widgetEmojiPicker.onSelectedCategoryAdapterPositionUpdated(i);
    }

    public static final /* synthetic */ void access$setEmojiPickerListener$p(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerListener emojiPickerListener) {
        widgetEmojiPicker.emojiPickerListener = emojiPickerListener;
    }

    public static final /* synthetic */ void access$setEmojiPickerMode$p(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerMode emojiPickerMode) {
        widgetEmojiPicker.emojiPickerMode = emojiPickerMode;
    }

    public static final /* synthetic */ void access$setNextCategoryScrollSmooth$p(WidgetEmojiPicker widgetEmojiPicker, boolean z2) {
        widgetEmojiPicker.isNextCategoryScrollSmooth = z2;
    }

    public static final /* synthetic */ void access$setOnBackspacePressedListener$p(WidgetEmojiPicker widgetEmojiPicker, OnBackspacePressedListener onBackspacePressedListener) {
        widgetEmojiPicker.onBackspacePressedListener = onBackspacePressedListener;
    }

    public static final /* synthetic */ void access$setOnEmojiSearchOpenedListener$p(WidgetEmojiPicker widgetEmojiPicker, Function0 function0) {
        widgetEmojiPicker.onEmojiSearchOpenedListener = function0;
    }

    public static final /* synthetic */ void access$setPreviousViewState$p(WidgetEmojiPicker widgetEmojiPicker, EmojiPickerViewModel$ViewState emojiPickerViewModel$ViewState) {
        widgetEmojiPicker.previousViewState = emojiPickerViewModel$ViewState;
    }

    private final void checkUpsellHeaderVisibility(RecyclerView recyclerView) {
        RecyclerView$LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int iFindFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
        int iFindLastCompletelyVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
        if (iFindLastCompletelyVisibleItemPosition < iFindFirstCompletelyVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView$ViewHolder recyclerView$ViewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iFindLastCompletelyVisibleItemPosition);
            if (!(recyclerView$ViewHolderFindViewHolderForAdapterPosition instanceof WidgetEmojiAdapter$HeaderViewHolder)) {
                recyclerView$ViewHolderFindViewHolderForAdapterPosition = null;
            }
            WidgetEmojiAdapter$HeaderViewHolder widgetEmojiAdapter$HeaderViewHolder = (WidgetEmojiAdapter$HeaderViewHolder) recyclerView$ViewHolderFindViewHolderForAdapterPosition;
            if (widgetEmojiAdapter$HeaderViewHolder != null) {
                WidgetEmojiAdapter$HeaderItem boundItem = widgetEmojiAdapter$HeaderViewHolder.getBoundItem();
                WidgetEmojiAdapter$HeaderItem$StringHeaderItem widgetEmojiAdapter$HeaderItem$StringHeaderItem = (WidgetEmojiAdapter$HeaderItem$StringHeaderItem) (boundItem instanceof WidgetEmojiAdapter$HeaderItem$StringHeaderItem ? boundItem : null);
                if (widgetEmojiAdapter$HeaderItem$StringHeaderItem != null && widgetEmojiAdapter$HeaderItem$StringHeaderItem.getStringRes() == 2131888751) {
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

    private final void configureUI(EmojiPickerViewModel$ViewState viewState) {
        Unit unit;
        String searchQuery = viewState != null ? viewState.getSearchQuery() : null;
        if (!this.restoredSearchQueryFromViewModel && searchQuery != null) {
            this.restoredSearchQueryFromViewModel = true;
            getBinding().m.setText(searchQuery);
        }
        if (viewState == null) {
            return;
        }
        if (viewState instanceof EmojiPickerViewModel$ViewState$EmptySearch) {
            AppViewFlipper appViewFlipper = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.chatInputEmojiPickerViewFlipper");
            appViewFlipper.setDisplayedChild(1);
            setEmojiPickerBottomBarVisible(false);
            unit = Unit.a;
        } else {
            if (!(viewState instanceof EmojiPickerViewModel$ViewState$Results)) {
                throw new NoWhenBranchMatchedException();
            }
            EmojiPickerViewModel$ViewState$Results emojiPickerViewModel$ViewState$Results = (EmojiPickerViewModel$ViewState$Results) viewState;
            setEmojiPickerBottomBarVisible(emojiPickerViewModel$ViewState$Results.getShowBottomBar());
            AppViewFlipper appViewFlipper2 = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.chatInputEmojiPickerViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
            if (widgetEmojiAdapter == null) {
                m.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter.setData(emojiPickerViewModel$ViewState$Results.getResultItems());
            WidgetEmojiAdapter widgetEmojiAdapter2 = this.emojiAdapter;
            if (widgetEmojiAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter2.setOnScrollPositionListener(new WidgetEmojiPicker$configureUI$1(this, viewState));
            EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
            if (emojiCategoryAdapter == null) {
                m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            emojiCategoryAdapter.setItems(emojiPickerViewModel$ViewState$Results.getCategoryItems());
            configureUnicodeCategoriesShortcutButton(viewState);
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
        this.previousViewState = viewState;
    }

    private final void configureUnicodeCategoriesShortcutButton(EmojiPickerViewModel$ViewState viewState) {
        if (!(viewState instanceof EmojiPickerViewModel$ViewState$Results)) {
            viewState = null;
        }
        EmojiPickerViewModel$ViewState$Results emojiPickerViewModel$ViewState$Results = (EmojiPickerViewModel$ViewState$Results) viewState;
        if (emojiPickerViewModel$ViewState$Results != null) {
            EmojiCategoryItem$StandardItem firstUnicodeEmojiCategoryItem = emojiPickerViewModel$ViewState$Results.getFirstUnicodeEmojiCategoryItem();
            if (firstUnicodeEmojiCategoryItem != null) {
                getBinding().k.setImageDrawable(ContextCompat.getDrawable(requireContext(), EmojiCategoryViewHolder.Companion.getCategoryIconResId(firstUnicodeEmojiCategoryItem.getEmojiCategory())));
            }
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
            if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindLastCompletelyVisibleItemPosition == -1) {
                return;
            }
            EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
            if (emojiCategoryAdapter == null) {
                m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            if (iFindLastCompletelyVisibleItemPosition >= emojiCategoryAdapter.getPageSize()) {
                return;
            }
            EmojiCategoryAdapter emojiCategoryAdapter2 = this.categoryAdapter;
            if (emojiCategoryAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            EmojiCategoryItem itemAtPosition = emojiCategoryAdapter2.getItemAtPosition(iFindFirstCompletelyVisibleItemPosition);
            EmojiCategoryAdapter emojiCategoryAdapter3 = this.categoryAdapter;
            if (emojiCategoryAdapter3 == null) {
                m.throwUninitializedPropertyAccessException("categoryAdapter");
            }
            boolean z2 = itemAtPosition.containsOnlyUnicodeEmoji() || emojiCategoryAdapter3.getItemAtPosition(iFindLastCompletelyVisibleItemPosition).containsOnlyUnicodeEmoji();
            ImageView imageView = getBinding().k;
            m.checkNotNullExpressionValue(imageView, "binding.emojiPickerUnicodeEmojiShortcutButton");
            imageView.setVisibility((z2 || firstUnicodeEmojiCategoryItem == null) ? false : true ? 0 : 8);
        }
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build$VERSION.SDK_INT >= 29) {
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

    private final EmojiPickerViewModel$Inline getViewModelForInline() {
        return (EmojiPickerViewModel$Inline) this.viewModelForInline.getValue();
    }

    private final EmojiPickerViewModel$Sheet getViewModelForSheet() {
        return (EmojiPickerViewModel$Sheet) this.viewModelForSheet.getValue();
    }

    private final void handleEvent(EmojiPickerViewModel$Event event) {
        Unit unit;
        if (event instanceof EmojiPickerViewModel$Event$ScrollToEmojiListPosition) {
            WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
            if (widgetEmojiAdapter == null) {
                m.throwUninitializedPropertyAccessException("emojiAdapter");
            }
            widgetEmojiAdapter.scrollToPosition(((EmojiPickerViewModel$Event$ScrollToEmojiListPosition) event).getPosition());
            unit = Unit.a;
        } else {
            if (!(event instanceof EmojiPickerViewModel$Event$ShowPremiumUpsellDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            c$b c_b = c.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerViewModel$Event$ShowPremiumUpsellDialog emojiPickerViewModel$Event$ShowPremiumUpsellDialog = (EmojiPickerViewModel$Event$ShowPremiumUpsellDialog) event;
            c$b.a(c_b, parentFragmentManager, emojiPickerViewModel$Event$ShowPremiumUpsellDialog.getPageNumber(), b.k(this, emojiPickerViewModel$Event$ShowPremiumUpsellDialog.getHeader(), new Object[0], null, 4).toString(), b.k(this, emojiPickerViewModel$Event$ShowPremiumUpsellDialog.getBody(), new Object[0], null, 4).toString(), null, emojiPickerViewModel$Event$ShowPremiumUpsellDialog.getSectionName(), null, null, emojiPickerViewModel$Event$ShowPremiumUpsellDialog.getShowOtherPages(), emojiPickerViewModel$Event$ShowPremiumUpsellDialog.getShowLearnMore(), 208);
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void handleInputChanged(String input) {
        getViewModel().setSearchText(input);
        boolean z2 = input.length() == 0;
        getBinding().l.setImageResource(z2 ? 2131232097 : 2131231673);
        ImageView imageView = getBinding().l;
        m.checkNotNullExpressionValue(imageView, "binding.emojiSearchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(requireContext(), 2130969056)) : ColorStateList.valueOf(ColorCompat.getThemedColor(requireContext(), 2130969057)));
        if (z2) {
            ImageView imageView2 = getBinding().l;
            m.checkNotNullExpressionValue(imageView2, "binding.emojiSearchClear");
            imageView2.setContentDescription(b.k(this, 2131895318, new Object[0], null, 4));
            ImageView imageView3 = getBinding().l;
            m.checkNotNullExpressionValue(imageView3, "binding.emojiSearchClear");
            imageView3.setImportantForAccessibility(2);
            return;
        }
        ImageView imageView4 = getBinding().l;
        m.checkNotNullExpressionValue(imageView4, "binding.emojiSearchClear");
        imageView4.setContentDescription(b.k(this, 2131894833, new Object[0], null, 4));
        ImageView imageView5 = getBinding().l;
        m.checkNotNullExpressionValue(imageView5, "binding.emojiSearchClear");
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
        ImageView imageView = getBinding().f;
        m.checkNotNullExpressionValue(imageView, "binding.emojiPickerBackspaceIcon");
        imageView.setVisibility(z2 ? 0 : 8);
        getBinding().k.setOnClickListener(new WidgetEmojiPicker$initializeInputButtons$1(this));
        getBinding().f.setOnTouchListener(new RepeatingOnTouchListener(250L, 50L, TimeUnit.MILLISECONDS, new WidgetEmojiPicker$initializeInputButtons$2(this), new WidgetEmojiPicker$initializeInputButtons$3(this)));
    }

    private final void initializeSearchBar() {
        AppBarLayout appBarLayout = getBinding().d;
        m.checkNotNullExpressionValue(appBarLayout, "binding.emojiAppBar");
        EmojiPickerMode emojiPickerMode = this.emojiPickerMode;
        EmojiPickerMode emojiPickerMode2 = EmojiPickerMode.INLINE;
        appBarLayout.setVisibility(emojiPickerMode != emojiPickerMode2 ? 0 : 8);
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.emojiInlineSearchButton");
        textView.setVisibility(this.emojiPickerMode == emojiPickerMode2 ? 0 : 8);
        TextInputEditText textInputEditText = getBinding().m;
        m.checkNotNullExpressionValue(textInputEditText, "binding.emojiSearchInput");
        textInputEditText.setVisibility(this.emojiPickerMode != emojiPickerMode2 ? 0 : 8);
        getBinding().e.setOnClickListener(new WidgetEmojiPicker$initializeSearchBar$1(this));
        getBinding().l.setOnClickListener(new WidgetEmojiPicker$initializeSearchBar$2(this));
        TextInputEditText textInputEditText2 = getBinding().m;
        m.checkNotNullExpressionValue(textInputEditText2, "binding.emojiSearchInput");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText2, this, new WidgetEmojiPicker$initializeSearchBar$3(this));
        if (this.emojiPickerMode == EmojiPickerMode.BOTTOM_SHEET) {
            getBinding().m.requestFocus();
            TextInputEditText textInputEditText3 = getBinding().m;
            m.checkNotNullExpressionValue(textInputEditText3, "binding.emojiSearchInput");
            showKeyboard(textInputEditText3);
        }
    }

    private final void launchBottomSheet() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, this.emojiPickerListener, getEmojiPickerContextType(), null, 8, null);
    }

    private final void onCategoryClicked(EmojiCategoryItem emojiCategoryItem) {
        if (emojiCategoryItem instanceof EmojiCategoryItem$GuildItem) {
            AnalyticsTracker.INSTANCE.emojiCategorySelected(((EmojiCategoryItem$GuildItem) emojiCategoryItem).getGuild().getId());
        }
        selectCategoryByItemId(emojiCategoryItem.getStableId());
        Pair<Integer, Integer> categoryRange = emojiCategoryItem.getCategoryRange();
        WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
        if (widgetEmojiAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        widgetEmojiAdapter.scrollToPosition(categoryRange.getFirst().intValue());
    }

    private final void onPremiumCtaClicked() {
        WidgetSettingsPremium$Companion.launch$default(WidgetSettingsPremium.Companion, requireContext(), null, null, 6, null);
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
        EmojiCategoryAdapter emojiCategoryAdapter = this.categoryAdapter;
        if (emojiCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
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
        m.checkNotNullExpressionValue(constraintLayout, "binding.emojiPickerBottomBar");
        constraintLayout.setVisibility(visible ? 0 : 8);
        View view = getBinding().h;
        m.checkNotNullExpressionValue(view, "binding.emojiPickerBottomBarDivider");
        view.setVisibility(visible ? 0 : 8);
        RecyclerView recyclerView = getBinding().f2376b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputEmojiPickerRecycler");
        ViewGroup$LayoutParams layoutParams = recyclerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, viewGroup$MarginLayoutParams.rightMargin, visible ? getResources().getDimensionPixelSize(2131165437) : 0);
        recyclerView.setLayoutParams(viewGroup$MarginLayoutParams);
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView, "binding.emojiPickerCategoryRecycler");
        recyclerView.setItemAnimator(null);
        EmojiCategoryAdapter emojiCategoryAdapter = new EmojiCategoryAdapter(new WidgetEmojiPicker$setUpCategoryRecycler$1(this), new WidgetEmojiPicker$setUpCategoryRecycler$2(this), this, null, 8, null);
        this.categoryAdapter = emojiCategoryAdapter;
        if (emojiCategoryAdapter == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        emojiCategoryAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView2, "binding.emojiPickerCategoryRecycler");
        EmojiCategoryAdapter emojiCategoryAdapter2 = this.categoryAdapter;
        if (emojiCategoryAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView2.setAdapter(emojiCategoryAdapter2);
        RecyclerView recyclerView3 = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView3, "binding.emojiPickerCategoryRecycler");
        EmojiCategoryAdapter emojiCategoryAdapter3 = this.categoryAdapter;
        if (emojiCategoryAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        this.categoryLayoutManager = new SelfHealingLinearLayoutManager(recyclerView3, emojiCategoryAdapter3, 0, false, 8, null);
        RecyclerView recyclerView4 = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView4, "binding.emojiPickerCategoryRecycler");
        LinearLayoutManager linearLayoutManager = this.categoryLayoutManager;
        if (linearLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("categoryLayoutManager");
        }
        recyclerView4.setLayoutManager(linearLayoutManager);
        getBinding().i.addOnScrollListener(new WidgetEmojiPicker$setUpCategoryRecycler$3(this));
    }

    private final void setUpEmojiRecycler() {
        RecyclerView recyclerView = getBinding().f2376b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputEmojiPickerRecycler");
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = getBinding().f2376b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputEmojiPickerRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetEmojiAdapter widgetEmojiAdapter = new WidgetEmojiAdapter(recyclerView2, parentFragmentManager, this, new WidgetEmojiPicker$setUpEmojiRecycler$1(this), new WidgetEmojiPicker$setUpEmojiRecycler$2(this));
        this.emojiAdapter = widgetEmojiAdapter;
        if (widgetEmojiAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojiAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(widgetEmojiAdapter);
        getBinding().f2376b.addItemDecoration(stickyHeaderItemDecoration);
        RecyclerView recyclerView3 = getBinding().f2376b;
        m.checkNotNullExpressionValue(recyclerView3, "binding.chatInputEmojiPickerRecycler");
        stickyHeaderItemDecoration.blockClicks(recyclerView3);
        getBinding().f2376b.setHasFixedSize(true);
        getBinding().f2376b.addOnScrollListener(new WidgetEmojiPicker$setUpEmojiRecycler$3(this));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().j, new WidgetEmojiPicker$setWindowInsetsListeners$1(this));
    }

    private final void subscribeToCategoryRecyclerScrolls() {
        PublishSubject<Unit> publishSubject = this.emojiCategoryScrollSubject;
        Observable observableH0 = Observable.h0(new r(publishSubject.j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        m.checkNotNullExpressionValue(observableH0, "emojiCategoryScrollSubje…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableH0, this, null, 2, null), WidgetEmojiPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEmojiPicker$subscribeToCategoryRecyclerScrolls$1(this), 62, (Object) null);
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
        m.checkNotNullParameter(emoji, "emoji");
        getViewModel().onEmojiSelected(emoji, new WidgetEmojiPicker$onEmojiSelected$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        CoordinatorLayout coordinatorLayout = getBinding().j;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.emojiPickerContainer");
        coordinatorLayout.setPadding(coordinatorLayout.getPaddingLeft(), coordinatorLayout.getPaddingTop(), coordinatorLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        EmojiPickerMode mode = getMode();
        EmojiPickerMode emojiPickerMode = EmojiPickerMode.INLINE;
        if (mode == emojiPickerMode) {
            setWindowInsetsListeners();
        }
        initializeInputButtons();
        initializeSearchBar();
        Toolbar toolbar = getBinding().n;
        m.checkNotNullExpressionValue(toolbar, "binding.emojiToolbar");
        ViewGroup$LayoutParams layoutParams = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout$LayoutParams) layoutParams).setScrollFlags(this.emojiPickerMode == emojiPickerMode ? 5 : 0);
        setUpEmojiRecycler();
        setUpCategoryRecycler();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEmojiPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEmojiPicker$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetEmojiPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEmojiPicker$onViewBoundOrOnResume$2(this), 62, (Object) null);
        subscribeToCategoryRecyclerScrolls();
    }

    public final void scrollToTop() {
        WidgetEmojiAdapter widgetEmojiAdapter = this.emojiAdapter;
        if (widgetEmojiAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojiAdapter");
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
