package com.discord.widgets.forums;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p025i.C1016o;
import p007b.p008a.p025i.C1023p;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetForumBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumBrowserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            if (context != null) {
                C0870j.m157e(context, WidgetForumBrowser.class, null, 4);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureCreatePostButton$2 */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class C83392 extends AbstractC12240o implements Function2<Long, Long, Unit> {
        public C83392() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, long j2) {
            WidgetForumBrowser.this.openCreatePostScreen(j, j2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$handleViewState$1 */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class C83411 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ WidgetForumBrowserViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83411(WidgetForumBrowserViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetForumBrowser.this.panelNsfwHidden = !z2;
            WidgetForumBrowserViewModel.ViewState viewState = this.$viewState;
            if (viewState instanceof WidgetForumBrowserViewModel.ViewState.Loaded) {
                WidgetForumBrowser.this.configureCreatePostButton((WidgetForumBrowserViewModel.ViewState.Loaded) viewState);
                WidgetForumBrowser.this.configureGuidelinesButton((WidgetForumBrowserViewModel.ViewState.Loaded) this.$viewState);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$1 */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class C83421 extends AbstractC12240o implements Function1<WidgetForumBrowserViewModel.Event, Unit> {
        public C83421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetForumBrowser.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$2 */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class C83432 extends AbstractC12240o implements Function1<WidgetForumBrowserViewModel.ViewState, Unit> {
        public C83432() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetForumBrowser.this.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final /* synthetic */ class C83441 extends C12236k implements Function1<Channel, Unit> {
        public C83441(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPost", "openForumPost(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((WidgetForumBrowser) this.receiver).openForumPost(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final /* synthetic */ class C83452 extends C12236k implements Function1<Channel, Unit> {
        public C83452(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPostOptions", "openForumPostOptions(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((WidgetForumBrowser) this.receiver).openForumPostOptions(channel);
        }
    }

    public WidgetForumBrowser() {
        super(C5419R.layout.widget_forum_browser);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetForumBrowser$binding$2.INSTANCE, null, 2, null);
        WidgetForumBrowser$viewModel$2 widgetForumBrowser$viewModel$2 = WidgetForumBrowser$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetForumBrowserViewModel.class), new WidgetForumBrowser$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetForumBrowser$viewModel$2));
        this.adapterDataReference = new ArrayList();
        this.panelNsfwHidden = true;
    }

    private final void configureCreatePostButton(final WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f16634b;
        extendedFloatingActionButton.setVisibility(viewState.getCanCreateForumChannelPosts() && this.panelNsfwHidden ? 0 : 8);
        if (extendedFloatingActionButton.getVisibility() == 0) {
            String channelTopic = viewState.getChannelTopic();
            final boolean z2 = !(channelTopic == null || channelTopic.length() == 0);
            extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.forums.WidgetForumBrowser$configureCreatePostButton$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.onCreatePostClick(viewState.getGuildId(), viewState.getChannelId(), z2);
                }
            });
        }
        WidgetForumGuidelinesBottomSheet.INSTANCE.registerForResult(this, CLOSE_FORUM_GUIDELINES_REQUEST_KEY, new C83392());
    }

    private final void configureEmptyState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        C1016o c1016o = getBinding().f16635c;
        C12238m.checkNotNullExpressionValue(c1016o, "binding.emptyView");
        ConstraintLayout constraintLayout = c1016o.f1092a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(0);
        RecyclerView recyclerView = getBinding().f16638f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        this.adapterDataReference.clear();
        TextView textView = getBinding().f16635c.f1093b;
        C12238m.checkNotNullExpressionValue(textView, "binding.emptyView.forumBrowserEmptySubheading");
        C1107b.m221m(textView, C5419R.string.forum_empty_state_description, new Object[]{viewState.getChannelName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void configureGuidelinesButton(final WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().f16639g;
        String channelTopic = viewState.getChannelTopic();
        floatingActionButton.setVisibility(!(channelTopic == null || channelTopic.length() == 0) && this.panelNsfwHidden ? 0 : 8);
        if (floatingActionButton.getVisibility() == 0) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.forums.WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, viewState.getGuildId(), viewState.getChannelId(), "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY");
                }
            });
        }
    }

    private final void configureListState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        C1016o c1016o = getBinding().f16635c;
        C12238m.checkNotNullExpressionValue(c1016o, "binding.emptyView");
        ConstraintLayout constraintLayout = c1016o.f1092a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f16638f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(0);
        this.adapterDataReference.clear();
        this.adapterDataReference.addAll(viewState.getListItems());
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(viewState.getListItems());
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        forumBrowserLayoutManager.setOnLayoutCompletedCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$1(this, viewState));
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        forumBrowserScrollListener.setOnScrollCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$2(this, viewState));
        forumBrowserScrollListener.setOnScrollEndCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$3(this, viewState));
        forumBrowserScrollListener.setOnScrollStateChangedCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$4(this, viewState));
    }

    private final void enqueueForumPostFirstMessageFetches(long parentChannelId, long guildId) {
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindFirstVisibleItemPosition = forumBrowserLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            return;
        }
        ForumBrowserLayoutManager forumBrowserLayoutManager2 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager2 == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindLastVisibleItemPosition = forumBrowserLayoutManager2.findLastVisibleItemPosition();
        if (iFindLastVisibleItemPosition == -1) {
            return;
        }
        int size = this.adapterDataReference.size();
        ForumBrowserLayoutManager forumBrowserLayoutManager3 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager3 == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int i = (iFindFirstVisibleItemPosition / 10) * 10;
        int iCoerceAtMost = C11226f.coerceAtMost(C11226f.coerceAtMost(size, forumBrowserLayoutManager3.getItemCount()) - 1, (((iFindLastVisibleItemPosition / 10) + 1) * 10) - 1);
        if (i > iCoerceAtMost) {
            return;
        }
        while (true) {
            ForumBrowserItem forumBrowserItem = this.adapterDataReference.get(i);
            if (forumBrowserItem instanceof ForumBrowserItem.PostItem) {
                ForumBrowserItem.PostItem postItem = (ForumBrowserItem.PostItem) forumBrowserItem;
                if (postItem.getPost().getIsActivePost()) {
                    getViewModel().enqueueForumPostFirstMessageFetch(parentChannelId, guildId, postItem.getPost().getChannel().getId());
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

    private final void handleEvent(WidgetForumBrowserViewModel.Event event) {
        if (event instanceof WidgetForumBrowserViewModel.Event.ScrollToTop) {
            getBinding().f16638f.scrollToPosition(0);
        }
    }

    private final void handleViewState(WidgetForumBrowserViewModel.ViewState viewState) {
        WidgetForumBrowserViewModel.NsfwPanelState nsfwPanelState = viewState.getNsfwPanelState();
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(nsfwPanelState.getGuildId(), nsfwPanelState.isChannelNsfw(), nsfwPanelState.isNsfwUnconsented(), nsfwPanelState.getNsfwAllowed(), getBinding().f16637e, new C83411(viewState), (64 & 64) != 0 ? null : null);
        }
        if (!(viewState instanceof WidgetForumBrowserViewModel.ViewState.Loading)) {
            if (viewState instanceof WidgetForumBrowserViewModel.ViewState.Loaded) {
                C1023p c1023p = getBinding().f16636d;
                C12238m.checkNotNullExpressionValue(c1023p, "binding.loadingView");
                ConstraintLayout constraintLayout = c1023p.f1121a;
                C12238m.checkNotNullExpressionValue(constraintLayout, "binding.loadingView.root");
                constraintLayout.setVisibility(8);
                WidgetForumBrowserViewModel.ViewState.Loaded loaded = (WidgetForumBrowserViewModel.ViewState.Loaded) viewState;
                configureCreatePostButton(loaded);
                configureGuidelinesButton(loaded);
                if (loaded.getListItems().isEmpty()) {
                    configureEmptyState(loaded);
                    return;
                } else {
                    configureListState(loaded);
                    return;
                }
            }
            return;
        }
        C1023p c1023p2 = getBinding().f16636d;
        C12238m.checkNotNullExpressionValue(c1023p2, "binding.loadingView");
        ConstraintLayout constraintLayout2 = c1023p2.f1121a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.loadingView.root");
        constraintLayout2.setVisibility(0);
        C1016o c1016o = getBinding().f16635c;
        C12238m.checkNotNullExpressionValue(c1016o, "binding.emptyView");
        ConstraintLayout constraintLayout3 = c1016o.f1092a;
        C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.emptyView.root");
        constraintLayout3.setVisibility(8);
        RecyclerView recyclerView = getBinding().f16638f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f16634b;
        C12238m.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        extendedFloatingActionButton.setVisibility(8);
        FloatingActionButton floatingActionButton = getBinding().f16639g;
        C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        floatingActionButton.setVisibility(8);
        C1016o c1016o2 = getBinding().f16635c;
        C12238m.checkNotNullExpressionValue(c1016o2, "binding.emptyView");
        ConstraintLayout constraintLayout4 = c1016o2.f1092a;
        C12238m.checkNotNullExpressionValue(constraintLayout4, "binding.emptyView.root");
        constraintLayout4.setVisibility(8);
        this.adapterDataReference.clear();
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(C12147n.emptyList());
    }

    private final void onCreatePostClick(long guildId, long parentChannelId, boolean hasForumGuidelines) {
        if (!hasForumGuidelines || ForumGuidelinesManager.INSTANCE.hasSeenGuidelines(parentChannelId)) {
            openCreatePostScreen(guildId, parentChannelId);
            return;
        }
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId, parentChannelId, CLOSE_FORUM_GUIDELINES_REQUEST_KEY);
    }

    private final void onLayoutCompleted(long parentChannelId, long guildId) {
        List<ForumBrowserItem> list = this.adapterDataReference;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ForumBrowserItem.PostItem) {
                arrayList.add(obj);
            }
        }
        boolean z2 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((ForumBrowserItem.PostItem) it.next()).getPost().getIsActivePost()) {
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
        ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), guildId, channelId, null, "Thread Browser Toolbar", 4, null);
    }

    private final void openForumPost(Channel channel) {
        ChannelSelector.INSTANCE.getInstance().selectChannel(channel, Long.valueOf(channel.getParentId()), SelectedChannelAnalyticsLocation.THREAD_BROWSER);
        requireActivity().onBackPressed();
    }

    private final void openForumPostOptions(Channel channel) {
        WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channel.getId());
    }

    private final void setWindowInsetListener(View viewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.forums.WidgetForumBrowser.setWindowInsetListener.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                C12238m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                C12238m.checkNotNullExpressionValue(view, "view");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = insets.bottom;
                view.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
    }

    private final void setWindowInsetsListeners() {
        WidgetForumBrowserBinding binding = getBinding();
        C12238m.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.f16633a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        RecyclerView recyclerView = getBinding().f16638f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        setWindowInsetListener(recyclerView);
        FloatingActionButton floatingActionButton = getBinding().f16639g;
        C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        setWindowInsetListener(floatingActionButton);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f16634b;
        C12238m.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        setWindowInsetListener(extendedFloatingActionButton);
    }

    public static final void show(Context context) {
        INSTANCE.show(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetForumBrowser.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83421());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetForumBrowser.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83432());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16638f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.forumBrowserAdapter = (WidgetForumBrowserAdapter) companion.configure(new WidgetForumBrowserAdapter(recyclerView, new C83441(this), new C83452(this)));
        RecyclerView recyclerView2 = getBinding().f16638f;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        this.forumBrowserLayoutManager = new ForumBrowserLayoutManager(recyclerView2);
        this.forumBrowserScrollListener = new ForumBrowserScrollListener();
        RecyclerView recyclerView3 = getBinding().f16638f;
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        recyclerView3.setLayoutManager(forumBrowserLayoutManager);
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        recyclerView3.addOnScrollListener(forumBrowserScrollListener);
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        recyclerView3.addItemDecoration(widgetForumBrowserAdapter.getItemDecoration());
        setWindowInsetsListeners();
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }
}
