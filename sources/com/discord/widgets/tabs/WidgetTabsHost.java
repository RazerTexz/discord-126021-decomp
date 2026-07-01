package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTabsHostBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.user.WidgetUserStatusSheet;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog$Companion;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

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
    private TabsHostViewModel$ViewState viewState;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTabsHost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTabsHostBinding;", 0)};
    public static final WidgetTabsHost$Companion Companion = new WidgetTabsHost$Companion(null);

    public WidgetTabsHost() {
        super(R$layout.widget_tabs_host);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTabsHost$binding$2.INSTANCE, null, 2, null);
        this.tabToTabSelectionListenerMap = new LinkedHashMap();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.Provider.get();
        WidgetTabsHost$viewModel$2 widgetTabsHost$viewModel$2 = WidgetTabsHost$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(TabsHostViewModel.class), new WidgetTabsHost$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetTabsHost$viewModel$2));
    }

    public static final /* synthetic */ WidgetTabsHostBinding access$getBinding$p(WidgetTabsHost widgetTabsHost) {
        return widgetTabsHost.getBinding();
    }

    public static final /* synthetic */ TabsHostViewModel access$getViewModel$p(WidgetTabsHost widgetTabsHost) {
        return widgetTabsHost.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetTabsHost widgetTabsHost, TabsHostViewModel$Event tabsHostViewModel$Event) {
        widgetTabsHost.handleEvent(tabsHostViewModel$Event);
    }

    public static final /* synthetic */ void access$onSearchClick(WidgetTabsHost widgetTabsHost) {
        widgetTabsHost.onSearchClick();
    }

    public static final /* synthetic */ void access$onSettingsLongPress(WidgetTabsHost widgetTabsHost) {
        widgetTabsHost.onSettingsLongPress();
    }

    public static final /* synthetic */ void access$setPanelWindowInsetsListeners(WidgetTabsHost widgetTabsHost, boolean z2) {
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    public static final /* synthetic */ void access$updateViews(WidgetTabsHost widgetTabsHost, TabsHostViewModel$ViewState tabsHostViewModel$ViewState) {
        widgetTabsHost.updateViews(tabsHostViewModel$ViewState);
    }

    private final void configureSystemStatusBar() {
        int themedColor = ColorCompat.getThemedColor(this, 2130968914);
        ColorCompat.setStatusBarColor$default((Fragment) this, themedColor, false, 4, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetTabsHost$configureSystemStatusBar$1(this, themedColor), 62, (Object) null);
    }

    private final WidgetTabsHostBinding getBinding() {
        return (WidgetTabsHostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final TabsHostViewModel getViewModel() {
        return (TabsHostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(TabsHostViewModel$Event event) {
        if (m.areEqual(event, TabsHostViewModel$Event$TrackFriendsListShown.INSTANCE)) {
            handleFriendsListShown();
        } else if (m.areEqual(event, TabsHostViewModel$Event$DismissSearchDialog.INSTANCE)) {
            WidgetGlobalSearchDialog$Companion widgetGlobalSearchDialog$Companion = WidgetGlobalSearchDialog.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetGlobalSearchDialog$Companion.dismiss(parentFragmentManager);
        }
    }

    private final void handleFriendsListShown() {
        AnalyticsTracker.INSTANCE.friendsListViewed();
    }

    private final void navigateToTab(NavigationTab navigationTab) {
        FragmentContainerView fragmentContainerView = getBinding().e;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetTabsHostHome");
        fragmentContainerView.setVisibility(navigationTab == NavigationTab.HOME ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().d;
        m.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetTabsHostFriends");
        fragmentContainerView2.setVisibility(navigationTab == NavigationTab.FRIENDS ? 0 : 8);
        FragmentContainerView fragmentContainerView3 = getBinding().f;
        m.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetTabsHostMentions");
        fragmentContainerView3.setVisibility(navigationTab == NavigationTab.MENTIONS ? 0 : 8);
        FragmentContainerView fragmentContainerView4 = getBinding().i;
        m.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetTabsHostUserSettings");
        fragmentContainerView4.setVisibility(navigationTab == NavigationTab.SETTINGS ? 0 : 8);
        OnTabSelectedListener onTabSelectedListener = this.tabToTabSelectionListenerMap.get(navigationTab);
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected();
        }
    }

    private final void onSearchClick() {
        WidgetGlobalSearchDialog$Companion widgetGlobalSearchDialog$Companion = WidgetGlobalSearchDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetGlobalSearchDialog$Companion.show$default(widgetGlobalSearchDialog$Companion, parentFragmentManager, null, 2, null);
    }

    private final void onSettingsLongPress() {
        WidgetUserStatusSheet.Companion.show(this);
    }

    private final void setPanelWindowInsetsListeners(boolean isCallStatusVisible) {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, WidgetTabsHost$setPanelWindowInsetsListeners$1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new WidgetTabsHost$setPanelWindowInsetsListeners$2(isCallStatusVisible));
        FrameLayout frameLayout = getBinding().g;
        m.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new WidgetTabsHost$setPanelWindowInsetsListeners$3(isCallStatusVisible));
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2664b, WidgetTabsHost$setPanelWindowInsetsListeners$4.INSTANCE);
        getBinding().c.requestApplyInsets();
    }

    public static /* synthetic */ void setPanelWindowInsetsListeners$default(WidgetTabsHost widgetTabsHost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    private final void updateNavHostMargins(TabsHostViewModel$ViewState viewState) {
        NavigationTab selectedTab = viewState.getSelectedTab();
        FrameLayout frameLayout = getBinding().g;
        m.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewGroup$LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, viewGroup$MarginLayoutParams.rightMargin, selectedTab == NavigationTab.HOME ? 0 : viewState.getBottomNavHeight());
        FrameLayout frameLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(frameLayout2, "binding.widgetTabsHostNavHost");
        frameLayout2.setLayoutParams(viewGroup$MarginLayoutParams);
    }

    private final void updateViews(TabsHostViewModel$ViewState viewState) {
        this.viewState = viewState;
        NavigationTab selectedTab = viewState.getSelectedTab();
        boolean showBottomNav = viewState.getShowBottomNav();
        int bottomNavHeight = viewState.getBottomNavHeight();
        navigateToTab(selectedTab);
        getBinding().f2664b.updateView(selectedTab, new WidgetTabsHost$updateViews$1(getViewModel()), showBottomNav, viewState.getMyUserId(), viewState.getVisibleTabs(), viewState.getNumHomeNotifications(), viewState.getNumFriendsNotifications(), new WidgetTabsHost$updateViews$2(this), new WidgetTabsHost$updateViews$3(this), new WidgetTabsHost$updateViews$4(this));
        updateNavHostMargins(viewState);
        boolean z2 = !m.areEqual(Boolean.valueOf(showBottomNav), this.previousShowBottomNav);
        boolean z3 = bottomNavHeight != this.previousBottomNavHeight;
        if (z2 || z3) {
            ValueAnimator valueAnimator = this.bottomNavAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            TabsHostBottomNavigationView tabsHostBottomNavigationView = getBinding().f2664b;
            m.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
            float translationY = tabsHostBottomNavigationView.getTranslationY();
            if (showBottomNav) {
                TabsHostBottomNavigationView tabsHostBottomNavigationView2 = getBinding().f2664b;
                m.checkNotNullExpressionValue(tabsHostBottomNavigationView2, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView2.setVisibility(0);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(translationY, 0.0f);
                valueAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat.setDuration(BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat.addUpdateListener(new WidgetTabsHost$updateViews$$inlined$apply$lambda$1(this));
                valueAnimatorOfFloat.start();
                this.bottomNavAnimator = valueAnimatorOfFloat;
            } else if (bottomNavHeight > 0) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(translationY, bottomNavHeight);
                valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat2.setDuration(BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat2.addUpdateListener(new WidgetTabsHost$updateViews$$inlined$apply$lambda$2(this));
                valueAnimatorOfFloat2.start();
                this.bottomNavAnimator = valueAnimatorOfFloat2;
            } else {
                TabsHostBottomNavigationView tabsHostBottomNavigationView3 = getBinding().f2664b;
                m.checkNotNullExpressionValue(tabsHostBottomNavigationView3, "binding.widgetTabsHostBottomNavigationView");
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
            GoogleSmartLockManager.Companion.handleResult(resultCode, data);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2664b.addHeightChangedListener(BottomNavViewObserver.Companion.getINSTANCE());
        setPanelWindowInsetsListeners$default(this, false, 1, null);
        AppFragment.setOnBackPressed$default(this, new WidgetTabsHost$onViewBound$1(this), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<TabsHostViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetTabsHost$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetTabsHost$onViewBoundOrOnResume$2(this), 62, (Object) null);
        configureSystemStatusBar();
    }

    public final void registerTabSelectionListener(NavigationTab navigationTab, OnTabSelectedListener onTabSelectedListener) {
        m.checkNotNullParameter(navigationTab, "navigationTab");
        m.checkNotNullParameter(onTabSelectedListener, "onTabSelectedListener");
        this.tabToTabSelectionListenerMap.put(navigationTab, onTabSelectedListener);
        TabsHostViewModel$ViewState tabsHostViewModel$ViewState = this.viewState;
        NavigationTab selectedTab = tabsHostViewModel$ViewState != null ? tabsHostViewModel$ViewState.getSelectedTab() : null;
        if (selectedTab != null) {
            navigateToTab(selectedTab);
        }
    }
}
