package com.discord.widgets.friends;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetFriendsListBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rest.RestAPIAbortMessages$ResponseResolver;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet$Companion;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList extends AppFragment implements OnTabSelectedListener {
    private static final String ANALYTICS_SOURCE = "Friends";
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_LOADING = 2;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetFriendsListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetFriendsListLoadingAdapter loadingAdapter;
    private PrivateCallLauncher privateCallLauncher;
    private boolean showContactSyncIcon;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFriendsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsListBinding;", 0)};
    public static final WidgetFriendsList$Companion Companion = new WidgetFriendsList$Companion(null);

    public WidgetFriendsList() {
        super(R$layout.widget_friends_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsList$binding$2.INSTANCE, null, 2, null);
        WidgetFriendsList$viewModel$2 widgetFriendsList$viewModel$2 = WidgetFriendsList$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(FriendsListViewModel.class), new WidgetFriendsList$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFriendsList$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetFriendsList widgetFriendsList, FriendsListViewModel$ViewState friendsListViewModel$ViewState) {
        widgetFriendsList.configureUI(friendsListViewModel$ViewState);
    }

    public static final /* synthetic */ boolean access$getShowContactSyncIcon$p(WidgetFriendsList widgetFriendsList) {
        return widgetFriendsList.showContactSyncIcon;
    }

    public static final /* synthetic */ FriendsListViewModel access$getViewModel$p(WidgetFriendsList widgetFriendsList) {
        return widgetFriendsList.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFriendsList widgetFriendsList, FriendsListViewModel$Event friendsListViewModel$Event) {
        widgetFriendsList.handleEvent(friendsListViewModel$Event);
    }

    public static final /* synthetic */ void access$setShowContactSyncIcon$p(WidgetFriendsList widgetFriendsList, boolean z2) {
        widgetFriendsList.showContactSyncIcon = z2;
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(2131889471);
        setActionBarTitleLayoutMinimumTappableArea();
        setActionBarOptionsMenu(R$menu.menu_friends, new WidgetFriendsList$configureToolbar$1(this), new WidgetFriendsList$configureToolbar$2(this));
    }

    private final void configureUI(FriendsListViewModel$ViewState viewState) {
        if (m.areEqual(viewState, FriendsListViewModel$ViewState$Uninitialized.INSTANCE)) {
            showLoadingView();
        } else if (viewState instanceof FriendsListViewModel$ViewState$Empty) {
            showEmptyView((FriendsListViewModel$ViewState$Empty) viewState);
        } else {
            if (!(viewState instanceof FriendsListViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            updateView((FriendsListViewModel$ViewState$Loaded) viewState);
        }
    }

    private final void displayFlipperChild(int index) {
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.friendsListFlipper");
        appViewFlipper.setVisibility(0);
        AppViewFlipper appViewFlipper2 = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper2, "binding.friendsListFlipper");
        appViewFlipper2.setDisplayedChild(index);
    }

    private final WidgetFriendsListBinding getBinding() {
        return (WidgetFriendsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FriendsListViewModel getViewModel() {
        return (FriendsListViewModel) this.viewModel.getValue();
    }

    private final void handleCaptchaError(FriendsListViewModel$Event$CaptchaError event) {
        WidgetCaptchaBottomSheet$Companion.enqueue$default(WidgetCaptchaBottomSheet.Companion, "Add Friend Captcha", new WidgetFriendsList$handleCaptchaError$1(this, event), null, CaptchaErrorBody.Companion.createFromError(event.getError()), 4, null);
    }

    private final void handleEvent(FriendsListViewModel$Event event) {
        if (event instanceof FriendsListViewModel$Event$ShowToast) {
            handleShowToast((FriendsListViewModel$Event$ShowToast) event);
            return;
        }
        if (event instanceof FriendsListViewModel$Event$ShowFriendRequestErrorToast) {
            handleShowFriendRequestErrorToast((FriendsListViewModel$Event$ShowFriendRequestErrorToast) event);
        } else if (event instanceof FriendsListViewModel$Event$LaunchVoiceCall) {
            handleLaunchVoiceCall((FriendsListViewModel$Event$LaunchVoiceCall) event);
        } else {
            if (!(event instanceof FriendsListViewModel$Event$CaptchaError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleCaptchaError((FriendsListViewModel$Event$CaptchaError) event);
        }
    }

    private final void handleLaunchVoiceCall(FriendsListViewModel$Event$LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleShowFriendRequestErrorToast(FriendsListViewModel$Event$ShowFriendRequestErrorToast event) {
        b.a.d.m.j(this, RestAPIAbortMessages$ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(FriendsListViewModel$Event$ShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
    }

    private final void showEmptyView(FriendsListViewModel$ViewState$Empty viewState) {
        displayFlipperChild(1);
        this.showContactSyncIcon = viewState.getShowContactSyncIcon();
        configureToolbar();
    }

    private final void showLoadingView() {
        displayFlipperChild(2);
    }

    private final void updateView(FriendsListViewModel$ViewState$Loaded viewState) {
        displayFlipperChild(0);
        WidgetFriendsListAdapter widgetFriendsListAdapter = this.adapter;
        if (widgetFriendsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setData(viewState.getItems());
        this.showContactSyncIcon = viewState.getShowContactSyncIcon();
        configureToolbar();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        AnalyticsTracker.INSTANCE.friendsListViewed();
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.FRIENDS, this);
        }
        getBinding().f2396b.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.friendsListRecycler");
        WidgetFriendsListAdapter widgetFriendsListAdapter = (WidgetFriendsListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetFriendsListAdapter(recyclerView));
        this.adapter = widgetFriendsListAdapter;
        if (widgetFriendsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setOnClickUserProfile(new WidgetFriendsList$onViewBound$1(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter2 = this.adapter;
        if (widgetFriendsListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter2.setOnClickPendingHeaderExpand(new WidgetFriendsList$onViewBound$2(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter3 = this.adapter;
        if (widgetFriendsListAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter3.setOnClickCall(new WidgetFriendsList$onViewBound$3(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter4 = this.adapter;
        if (widgetFriendsListAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter4.setOnClickChat(new WidgetFriendsList$onViewBound$4(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter5 = this.adapter;
        if (widgetFriendsListAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter5.setOnClickAcceptFriend(new WidgetFriendsList$onViewBound$5(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter6 = this.adapter;
        if (widgetFriendsListAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter6.setOnClickDeclineFriend(new WidgetFriendsList$onViewBound$6(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter7 = this.adapter;
        if (widgetFriendsListAdapter7 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter7.setOnClickContactSyncUpsell(new WidgetFriendsList$onViewBound$7(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter8 = this.adapter;
        if (widgetFriendsListAdapter8 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter8.setOnClickContactSyncUpsellLongClick(new WidgetFriendsList$onViewBound$8(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter9 = this.adapter;
        if (widgetFriendsListAdapter9 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter9.setOnClickSuggestedHeaderExpandCollapse(new WidgetFriendsList$onViewBound$9(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter10 = this.adapter;
        if (widgetFriendsListAdapter10 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter10.setOnClickApproveSuggestion(new WidgetFriendsList$onViewBound$10(this));
        WidgetFriendsListAdapter widgetFriendsListAdapter11 = this.adapter;
        if (widgetFriendsListAdapter11 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter11.setOnClickRemoveSuggestion(new WidgetFriendsList$onViewBound$11(getViewModel()));
        this.loadingAdapter = new WidgetFriendsListLoadingAdapter();
        RecyclerView recyclerView2 = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView2, "binding.friendsListLoading");
        WidgetFriendsListLoadingAdapter widgetFriendsListLoadingAdapter = this.loadingAdapter;
        if (widgetFriendsListLoadingAdapter == null) {
            m.throwUninitializedPropertyAccessException("loadingAdapter");
        }
        recyclerView2.setAdapter(widgetFriendsListLoadingAdapter);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFriendsList$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFriendsList$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
