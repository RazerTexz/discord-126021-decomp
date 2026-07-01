package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTabsHostBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.tabs.TabsHostViewModel;
import com.discord.widgets.user.WidgetUserStatusSheet;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost extends AppFragment {
    private static final long BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS = 200;
    private static final long BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS = 250;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ValueAnimator bottomNavAnimator;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private int previousBottomNavHeight;
    private Boolean previousShowBottomNav;
    private final Map<NavigationTab, OnTabSelectedListener> tabToTabSelectionListenerMap;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private TabsHostViewModel.ViewState viewState;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTabsHost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTabsHostBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$configureSystemStatusBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public final /* synthetic */ int $defaultStatusBarColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$defaultStatusBarColor = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            WidgetTabsHost.this.setPanelWindowInsetsListeners(state.isVisible());
            int color = ColorCompat.getColor(WidgetTabsHost.this, R.color.transparent);
            if (!state.isVisible()) {
                color = this.$defaultStatusBarColor;
            }
            ColorCompat.setStatusBarColor$default((Fragment) WidgetTabsHost.this, color, false, 4, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<TabsHostViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TabsHostViewModel.ViewState viewState) {
            WidgetTabsHost widgetTabsHost = WidgetTabsHost.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetTabsHost.updateViews(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<TabsHostViewModel.Event, Unit> {
        public AnonymousClass2(WidgetTabsHost widgetTabsHost) {
            super(1, widgetTabsHost, WidgetTabsHost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/tabs/TabsHostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TabsHostViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetTabsHost) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<NavigationTab, Unit> {
        public AnonymousClass1(TabsHostViewModel tabsHostViewModel) {
            super(1, tabsHostViewModel, TabsHostViewModel.class, "selectTab", "selectTab(Lcom/discord/widgets/tabs/NavigationTab;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NavigationTab navigationTab) {
            invoke2(navigationTab);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavigationTab navigationTab) {
            Intrinsics3.checkNotNullParameter(navigationTab, "p1");
            ((TabsHostViewModel) this.receiver).selectTab(navigationTab);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetTabsHost) this.receiver).onSearchClick();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSettingsLongPress", "onSettingsLongPress()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetTabsHost) this.receiver).onSettingsLongPress();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTabsHost.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetTabsHost) this.receiver).onSearchClick();
        }
    }

    public WidgetTabsHost() {
        super(R.layout.widget_tabs_host);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTabsHost2.INSTANCE, null, 2, null);
        this.tabToTabSelectionListenerMap = new LinkedHashMap();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        WidgetTabsHost5 widgetTabsHost5 = WidgetTabsHost5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(TabsHostViewModel.class), new WidgetTabsHost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetTabsHost5));
    }

    private final void configureSystemStatusBar() {
        int themedColor = ColorCompat.getThemedColor(this, R.attr.colorBackgroundTertiary);
        ColorCompat.setStatusBarColor$default((Fragment) this, themedColor, false, 4, (Object) null);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), (Class<?>) WidgetTabsHost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(themedColor));
    }

    private final WidgetTabsHostBinding getBinding() {
        return (WidgetTabsHostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final TabsHostViewModel getViewModel() {
        return (TabsHostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(TabsHostViewModel.Event event) {
        if (Intrinsics3.areEqual(event, TabsHostViewModel.Event.TrackFriendsListShown.INSTANCE)) {
            handleFriendsListShown();
        } else if (Intrinsics3.areEqual(event, TabsHostViewModel.Event.DismissSearchDialog.INSTANCE)) {
            WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.dismiss(parentFragmentManager);
        }
    }

    private final void handleFriendsListShown() {
        AnalyticsTracker.INSTANCE.friendsListViewed();
    }

    private final void navigateToTab(NavigationTab navigationTab) {
        FragmentContainerView fragmentContainerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetTabsHostHome");
        fragmentContainerView.setVisibility(navigationTab == NavigationTab.HOME ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetTabsHostFriends");
        fragmentContainerView2.setVisibility(navigationTab == NavigationTab.FRIENDS ? 0 : 8);
        FragmentContainerView fragmentContainerView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetTabsHostMentions");
        fragmentContainerView3.setVisibility(navigationTab == NavigationTab.MENTIONS ? 0 : 8);
        FragmentContainerView fragmentContainerView4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetTabsHostUserSettings");
        fragmentContainerView4.setVisibility(navigationTab == NavigationTab.SETTINGS ? 0 : 8);
        OnTabSelectedListener onTabSelectedListener = this.tabToTabSelectionListenerMap.get(navigationTab);
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected();
        }
    }

    private final void onSearchClick() {
        WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetGlobalSearchDialog.Companion.show$default(companion, parentFragmentManager, null, 2, null);
    }

    private final void onSettingsLongPress() {
        WidgetUserStatusSheet.INSTANCE.show(this);
    }

    private final void setPanelWindowInsetsListeners(final boolean isCallStatusVisible) {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.tabs.WidgetTabsHost.setPanelWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Sequence<View> children;
                Intrinsics3.checkNotNullParameter(view, "v");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), view.getPaddingTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
                if (!(view instanceof ViewGroup)) {
                    view = null;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup != null && (children = androidx.core.view.ViewGroup.getChildren(viewGroup)) != null) {
                    Iterator<View> it = children.iterator();
                    while (it.hasNext()) {
                        ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompatBuild);
                    }
                }
                return windowInsetsCompatBuild;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.tabs.WidgetTabsHost.setPanelWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Sequence<View> children;
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                if (isCallStatusVisible) {
                    view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
                } else {
                    view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                    windowInsetsCompat = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
                    Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "WindowInsetsCompat.Build…      )\n        ).build()");
                }
                if (!(view instanceof ViewGroup)) {
                    view = null;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup != null && (children = androidx.core.view.ViewGroup.getChildren(viewGroup)) != null) {
                    Iterator<View> it = children.iterator();
                    while (it.hasNext()) {
                        ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
                    }
                }
                return windowInsetsCompat;
            }
        });
        FrameLayout frameLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.tabs.WidgetTabsHost.setPanelWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                int systemWindowInsetTop;
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                if (isCallStatusVisible) {
                    systemWindowInsetTop = 0;
                } else {
                    Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                    systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                }
                view.setPadding(view.getPaddingLeft(), systemWindowInsetTop, view.getPaddingRight(), view.getPaddingBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2664b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.tabs.WidgetTabsHost.setPanelWindowInsetsListeners.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        getBinding().c.requestApplyInsets();
    }

    public static /* synthetic */ void setPanelWindowInsetsListeners$default(WidgetTabsHost widgetTabsHost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    private final void updateNavHostMargins(TabsHostViewModel.ViewState viewState) {
        NavigationTab selectedTab = viewState.getSelectedTab();
        FrameLayout frameLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, selectedTab == NavigationTab.HOME ? 0 : viewState.getBottomNavHeight());
        FrameLayout frameLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.widgetTabsHostNavHost");
        frameLayout2.setLayoutParams(marginLayoutParams);
    }

    private final void updateViews(TabsHostViewModel.ViewState viewState) {
        this.viewState = viewState;
        NavigationTab selectedTab = viewState.getSelectedTab();
        boolean showBottomNav = viewState.getShowBottomNav();
        int bottomNavHeight = viewState.getBottomNavHeight();
        navigateToTab(selectedTab);
        getBinding().f2664b.updateView(selectedTab, new AnonymousClass1(getViewModel()), showBottomNav, viewState.getMyUserId(), viewState.getVisibleTabs(), viewState.getNumHomeNotifications(), viewState.getNumFriendsNotifications(), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
        updateNavHostMargins(viewState);
        boolean z2 = !Intrinsics3.areEqual(Boolean.valueOf(showBottomNav), this.previousShowBottomNav);
        boolean z3 = bottomNavHeight != this.previousBottomNavHeight;
        if (z2 || z3) {
            ValueAnimator valueAnimator = this.bottomNavAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            TabsHostBottomNavigationView tabsHostBottomNavigationView = getBinding().f2664b;
            Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
            float translationY = tabsHostBottomNavigationView.getTranslationY();
            if (showBottomNav) {
                TabsHostBottomNavigationView tabsHostBottomNavigationView2 = getBinding().f2664b;
                Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView2, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView2.setVisibility(0);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(translationY, 0.0f);
                valueAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat.setDuration(BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.discord.widgets.tabs.WidgetTabsHost$updateViews$$inlined$apply$lambda$1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        TabsHostBottomNavigationView tabsHostBottomNavigationView3 = this.this$0.getBinding().f2664b;
                        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView3, "binding.widgetTabsHostBottomNavigationView");
                        Intrinsics3.checkNotNullExpressionValue(valueAnimator2, "animator");
                        Object animatedValue = valueAnimator2.getAnimatedValue();
                        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        tabsHostBottomNavigationView3.setTranslationY(((Float) animatedValue).floatValue());
                    }
                });
                valueAnimatorOfFloat.start();
                this.bottomNavAnimator = valueAnimatorOfFloat;
            } else if (bottomNavHeight > 0) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(translationY, bottomNavHeight);
                valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat2.setDuration(BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.discord.widgets.tabs.WidgetTabsHost$updateViews$$inlined$apply$lambda$2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        TabsHostBottomNavigationView tabsHostBottomNavigationView3 = this.this$0.getBinding().f2664b;
                        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView3, "binding.widgetTabsHostBottomNavigationView");
                        Intrinsics3.checkNotNullExpressionValue(valueAnimator2, "animator");
                        Object animatedValue = valueAnimator2.getAnimatedValue();
                        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        tabsHostBottomNavigationView3.setTranslationY(((Float) animatedValue).floatValue());
                    }
                });
                valueAnimatorOfFloat2.start();
                this.bottomNavAnimator = valueAnimatorOfFloat2;
            } else {
                TabsHostBottomNavigationView tabsHostBottomNavigationView3 = getBinding().f2664b;
                Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView3, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView3.setVisibility(4);
            }
        }
        this.previousBottomNavHeight = bottomNavHeight;
        this.previousShowBottomNav = Boolean.valueOf(showBottomNav);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4008) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ValueAnimator valueAnimator = this.bottomNavAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2664b.addHeightChangedListener(BottomNavViewObserver.INSTANCE.getINSTANCE());
        setPanelWindowInsetsListeners$default(this, false, 1, null);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.tabs.WidgetTabsHost.onViewBound.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.valueOf(WidgetTabsHost.this.getViewModel().handleBackPress());
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<TabsHostViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetTabsHost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetTabsHost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        configureSystemStatusBar();
    }

    public final void registerTabSelectionListener(NavigationTab navigationTab, OnTabSelectedListener onTabSelectedListener) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        Intrinsics3.checkNotNullParameter(onTabSelectedListener, "onTabSelectedListener");
        this.tabToTabSelectionListenerMap.put(navigationTab, onTabSelectedListener);
        TabsHostViewModel.ViewState viewState = this.viewState;
        NavigationTab selectedTab = viewState != null ? viewState.getSelectedTab() : null;
        if (selectedTab != null) {
            navigateToTab(selectedTab);
        }
    }
}
