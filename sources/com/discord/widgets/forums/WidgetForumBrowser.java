package com.discord.widgets.forums;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.o;
import b.a.i.p;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Companion;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.d0.f;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser extends AppFragment {
    private static final String CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY = "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY";
    private static final String CLOSE_FORUM_GUIDELINES_REQUEST_KEY = "CLOSE_FORUM_GUIDELINES_REQUEST_KEY";
    private final List<ForumBrowserItem> adapterDataReference;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetForumBrowserAdapter forumBrowserAdapter;
    private ForumBrowserLayoutManager forumBrowserLayoutManager;
    private ForumBrowserScrollListener forumBrowserScrollListener;
    private WidgetHomePanelNsfw panelNsfw;
    private boolean panelNsfwHidden;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetForumBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumBrowserBinding;", 0)};
    public static final WidgetForumBrowser$Companion Companion = new WidgetForumBrowser$Companion(null);

    public WidgetForumBrowser() {
        super(R$layout.widget_forum_browser);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetForumBrowser$binding$2.INSTANCE, null, 2, null);
        WidgetForumBrowser$viewModel$2 widgetForumBrowser$viewModel$2 = WidgetForumBrowser$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetForumBrowserViewModel.class), new WidgetForumBrowser$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetForumBrowser$viewModel$2));
        this.adapterDataReference = new ArrayList();
        this.panelNsfwHidden = true;
    }

    public static final /* synthetic */ void access$configureCreatePostButton(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded) {
        widgetForumBrowser.configureCreatePostButton(widgetForumBrowserViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$configureGuidelinesButton(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded) {
        widgetForumBrowser.configureGuidelinesButton(widgetForumBrowserViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$enqueueForumPostFirstMessageFetches(WidgetForumBrowser widgetForumBrowser, long j, long j2) {
        widgetForumBrowser.enqueueForumPostFirstMessageFetches(j, j2);
    }

    public static final /* synthetic */ boolean access$getPanelNsfwHidden$p(WidgetForumBrowser widgetForumBrowser) {
        return widgetForumBrowser.panelNsfwHidden;
    }

    public static final /* synthetic */ WidgetForumBrowserViewModel access$getViewModel$p(WidgetForumBrowser widgetForumBrowser) {
        return widgetForumBrowser.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$Event widgetForumBrowserViewModel$Event) {
        widgetForumBrowser.handleEvent(widgetForumBrowserViewModel$Event);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState widgetForumBrowserViewModel$ViewState) {
        widgetForumBrowser.handleViewState(widgetForumBrowserViewModel$ViewState);
    }

    public static final /* synthetic */ void access$onCreatePostClick(WidgetForumBrowser widgetForumBrowser, long j, long j2, boolean z2) {
        widgetForumBrowser.onCreatePostClick(j, j2, z2);
    }

    public static final /* synthetic */ void access$onLayoutCompleted(WidgetForumBrowser widgetForumBrowser, long j, long j2) {
        widgetForumBrowser.onLayoutCompleted(j, j2);
    }

    public static final /* synthetic */ void access$openCreatePostScreen(WidgetForumBrowser widgetForumBrowser, long j, long j2) {
        widgetForumBrowser.openCreatePostScreen(j, j2);
    }

    public static final /* synthetic */ void access$openForumPost(WidgetForumBrowser widgetForumBrowser, Channel channel) {
        widgetForumBrowser.openForumPost(channel);
    }

    public static final /* synthetic */ void access$openForumPostOptions(WidgetForumBrowser widgetForumBrowser, Channel channel) {
        widgetForumBrowser.openForumPostOptions(channel);
    }

    public static final /* synthetic */ void access$setPanelNsfwHidden$p(WidgetForumBrowser widgetForumBrowser, boolean z2) {
        widgetForumBrowser.panelNsfwHidden = z2;
    }

    private final void configureCreatePostButton(WidgetForumBrowserViewModel$ViewState$Loaded viewState) {
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        extendedFloatingActionButton.setVisibility(viewState.getCanCreateForumChannelPosts() && this.panelNsfwHidden ? 0 : 8);
        if (extendedFloatingActionButton.getVisibility() == 0) {
            String channelTopic = viewState.getChannelTopic();
            extendedFloatingActionButton.setOnClickListener(new WidgetForumBrowser$configureCreatePostButton$$inlined$apply$lambda$1(!(channelTopic == null || channelTopic.length() == 0), this, viewState));
        }
        WidgetForumGuidelinesBottomSheet.Companion.registerForResult(this, CLOSE_FORUM_GUIDELINES_REQUEST_KEY, new WidgetForumBrowser$configureCreatePostButton$2(this));
    }

    private final void configureEmptyState(WidgetForumBrowserViewModel$ViewState$Loaded viewState) {
        o oVar = getBinding().c;
        m.checkNotNullExpressionValue(oVar, "binding.emptyView");
        ConstraintLayout constraintLayout = oVar.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(0);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        this.adapterDataReference.clear();
        TextView textView = getBinding().c.f170b;
        m.checkNotNullExpressionValue(textView, "binding.emptyView.forumBrowserEmptySubheading");
        b.n(textView, 2131889362, new Object[]{viewState.getChannelName()}, null, 4);
    }

    private final void configureGuidelinesButton(WidgetForumBrowserViewModel$ViewState$Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().g;
        String channelTopic = viewState.getChannelTopic();
        floatingActionButton.setVisibility(!(channelTopic == null || channelTopic.length() == 0) && this.panelNsfwHidden ? 0 : 8);
        if (floatingActionButton.getVisibility() == 0) {
            floatingActionButton.setOnClickListener(new WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1(this, viewState));
        }
    }

    private final void configureListState(WidgetForumBrowserViewModel$ViewState$Loaded viewState) {
        o oVar = getBinding().c;
        m.checkNotNullExpressionValue(oVar, "binding.emptyView");
        ConstraintLayout constraintLayout = oVar.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(0);
        this.adapterDataReference.clear();
        this.adapterDataReference.addAll(viewState.getListItems());
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(viewState.getListItems());
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        forumBrowserLayoutManager.setOnLayoutCompletedCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$1(this, viewState));
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        forumBrowserScrollListener.setOnScrollCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$2(this, viewState));
        forumBrowserScrollListener.setOnScrollEndCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$3(this, viewState));
        forumBrowserScrollListener.setOnScrollStateChangedCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$4(this, viewState));
    }

    private final void enqueueForumPostFirstMessageFetches(long parentChannelId, long guildId) {
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindFirstVisibleItemPosition = forumBrowserLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            return;
        }
        ForumBrowserLayoutManager forumBrowserLayoutManager2 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager2 == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindLastVisibleItemPosition = forumBrowserLayoutManager2.findLastVisibleItemPosition();
        if (iFindLastVisibleItemPosition == -1) {
            return;
        }
        int size = this.adapterDataReference.size();
        ForumBrowserLayoutManager forumBrowserLayoutManager3 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager3 == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int i = (iFindFirstVisibleItemPosition / 10) * 10;
        int iCoerceAtMost = f.coerceAtMost(f.coerceAtMost(size, forumBrowserLayoutManager3.getItemCount()) - 1, (((iFindLastVisibleItemPosition / 10) + 1) * 10) - 1);
        if (i > iCoerceAtMost) {
            return;
        }
        while (true) {
            ForumBrowserItem forumBrowserItem = this.adapterDataReference.get(i);
            if (forumBrowserItem instanceof ForumBrowserItem$PostItem) {
                ForumBrowserItem$PostItem forumBrowserItem$PostItem = (ForumBrowserItem$PostItem) forumBrowserItem;
                if (forumBrowserItem$PostItem.getPost().getIsActivePost()) {
                    getViewModel().enqueueForumPostFirstMessageFetch(parentChannelId, guildId, forumBrowserItem$PostItem.getPost().getChannel().getId());
                }
            }
            if (i == iCoerceAtMost) {
                return;
            } else {
                i++;
            }
        }
    }

    private final WidgetForumBrowserBinding getBinding() {
        return (WidgetForumBrowserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetForumBrowserViewModel getViewModel() {
        return (WidgetForumBrowserViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetForumBrowserViewModel$Event event) {
        if (event instanceof WidgetForumBrowserViewModel$Event$ScrollToTop) {
            getBinding().f.scrollToPosition(0);
        }
    }

    private final void handleViewState(WidgetForumBrowserViewModel$ViewState viewState) {
        WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState = viewState.getNsfwPanelState();
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            WidgetHomePanelNsfw.configureUI$default(widgetHomePanelNsfw, nsfwPanelState.getGuildId(), nsfwPanelState.isChannelNsfw(), nsfwPanelState.isNsfwUnconsented(), nsfwPanelState.getNsfwAllowed(), getBinding().e, new WidgetForumBrowser$handleViewState$1(this, viewState), null, 64, null);
        }
        if (!(viewState instanceof WidgetForumBrowserViewModel$ViewState$Loading)) {
            if (viewState instanceof WidgetForumBrowserViewModel$ViewState$Loaded) {
                p pVar = getBinding().d;
                m.checkNotNullExpressionValue(pVar, "binding.loadingView");
                ConstraintLayout constraintLayout = pVar.a;
                m.checkNotNullExpressionValue(constraintLayout, "binding.loadingView.root");
                constraintLayout.setVisibility(8);
                WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded = (WidgetForumBrowserViewModel$ViewState$Loaded) viewState;
                configureCreatePostButton(widgetForumBrowserViewModel$ViewState$Loaded);
                configureGuidelinesButton(widgetForumBrowserViewModel$ViewState$Loaded);
                if (widgetForumBrowserViewModel$ViewState$Loaded.getListItems().isEmpty()) {
                    configureEmptyState(widgetForumBrowserViewModel$ViewState$Loaded);
                    return;
                } else {
                    configureListState(widgetForumBrowserViewModel$ViewState$Loaded);
                    return;
                }
            }
            return;
        }
        p pVar2 = getBinding().d;
        m.checkNotNullExpressionValue(pVar2, "binding.loadingView");
        ConstraintLayout constraintLayout2 = pVar2.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.loadingView.root");
        constraintLayout2.setVisibility(0);
        o oVar = getBinding().c;
        m.checkNotNullExpressionValue(oVar, "binding.emptyView");
        ConstraintLayout constraintLayout3 = oVar.a;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.emptyView.root");
        constraintLayout3.setVisibility(8);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        m.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        extendedFloatingActionButton.setVisibility(8);
        FloatingActionButton floatingActionButton = getBinding().g;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        floatingActionButton.setVisibility(8);
        o oVar2 = getBinding().c;
        m.checkNotNullExpressionValue(oVar2, "binding.emptyView");
        ConstraintLayout constraintLayout4 = oVar2.a;
        m.checkNotNullExpressionValue(constraintLayout4, "binding.emptyView.root");
        constraintLayout4.setVisibility(8);
        this.adapterDataReference.clear();
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(n.emptyList());
    }

    private final void onCreatePostClick(long guildId, long parentChannelId, boolean hasForumGuidelines) {
        if (!hasForumGuidelines || ForumGuidelinesManager.INSTANCE.hasSeenGuidelines(parentChannelId)) {
            openCreatePostScreen(guildId, parentChannelId);
            return;
        }
        WidgetForumGuidelinesBottomSheet$Companion widgetForumGuidelinesBottomSheet$Companion = WidgetForumGuidelinesBottomSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetForumGuidelinesBottomSheet$Companion.show(parentFragmentManager, guildId, parentChannelId, CLOSE_FORUM_GUIDELINES_REQUEST_KEY);
    }

    private final void onLayoutCompleted(long parentChannelId, long guildId) {
        List<ForumBrowserItem> list = this.adapterDataReference;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ForumBrowserItem$PostItem) {
                arrayList.add(obj);
            }
        }
        boolean z2 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((ForumBrowserItem$PostItem) it.next()).getPost().getIsActivePost()) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            enqueueForumPostFirstMessageFetches(parentChannelId, guildId);
            getViewModel().maybeFetchForumPostFirstMessages(parentChannelId, guildId, true);
            getViewModel().requestForumUnreads(parentChannelId, guildId);
        }
    }

    private final void openCreatePostScreen(long guildId, long channelId) {
        ChannelSelector.openCreateThread$default(ChannelSelector.Companion.getInstance(), guildId, channelId, null, "Thread Browser Toolbar", 4, null);
    }

    private final void openForumPost(Channel channel) {
        ChannelSelector.Companion.getInstance().selectChannel(channel, Long.valueOf(channel.getParentId()), SelectedChannelAnalyticsLocation.THREAD_BROWSER);
        requireActivity().onBackPressed();
    }

    private final void openForumPostOptions(Channel channel) {
        WidgetChannelsListItemThreadActions$Companion widgetChannelsListItemThreadActions$Companion = WidgetChannelsListItemThreadActions.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChannelsListItemThreadActions$Companion.show(parentFragmentManager, channel.getId());
    }

    private final void setWindowInsetListener(View viewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding, WidgetForumBrowser$setWindowInsetListener$1.INSTANCE);
    }

    private final void setWindowInsetsListeners() {
        WidgetForumBrowserBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        setWindowInsetListener(recyclerView);
        FloatingActionButton floatingActionButton = getBinding().g;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        setWindowInsetListener(floatingActionButton);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        m.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        setWindowInsetListener(extendedFloatingActionButton);
    }

    public static final void show(Context context) {
        Companion.show(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetForumBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetForumBrowser$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetForumBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetForumBrowser$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.forumBrowserAdapter = (WidgetForumBrowserAdapter) mGRecyclerAdapter$Companion.configure(new WidgetForumBrowserAdapter(recyclerView, new WidgetForumBrowser$onViewBound$1(this), new WidgetForumBrowser$onViewBound$2(this)));
        RecyclerView recyclerView2 = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        this.forumBrowserLayoutManager = new ForumBrowserLayoutManager(recyclerView2);
        this.forumBrowserScrollListener = new ForumBrowserScrollListener();
        RecyclerView recyclerView3 = getBinding().f;
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        recyclerView3.setLayoutManager(forumBrowserLayoutManager);
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        recyclerView3.addOnScrollListener(forumBrowserScrollListener);
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        recyclerView3.addItemDecoration(widgetForumBrowserAdapter.getItemDecoration());
        setWindowInsetsListeners();
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }
}
