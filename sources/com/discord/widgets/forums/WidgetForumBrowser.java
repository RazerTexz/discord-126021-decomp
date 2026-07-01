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
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.ForumBrowserEmptyBinding;
import b.a.i.ForumBrowserLoadingBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetForumBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumBrowserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            if (context != null) {
                AppScreen2.e(context, WidgetForumBrowser.class, null, 4);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureCreatePostButton$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, Long, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2.longValue());
            return Unit.a;
        }

        public final void invoke(long j, long j2) {
            WidgetForumBrowser.this.openCreatePostScreen(j, j2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$handleViewState$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ WidgetForumBrowserViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetForumBrowserViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetForumBrowserViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetForumBrowser.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetForumBrowserViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetForumBrowser.this.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass1(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPost", "openForumPost(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((WidgetForumBrowser) this.receiver).openForumPost(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumBrowser.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass2(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPostOptions", "openForumPostOptions(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((WidgetForumBrowser) this.receiver).openForumPostOptions(channel);
        }
    }

    public WidgetForumBrowser() {
        super(R.layout.widget_forum_browser);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetForumBrowser2.INSTANCE, null, 2, null);
        WidgetForumBrowser9 widgetForumBrowser9 = WidgetForumBrowser9.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetForumBrowserViewModel.class), new WidgetForumBrowser$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetForumBrowser9));
        this.adapterDataReference = new ArrayList();
        this.panelNsfwHidden = true;
    }

    private final void configureCreatePostButton(final WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
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
        WidgetForumGuidelinesBottomSheet.INSTANCE.registerForResult(this, CLOSE_FORUM_GUIDELINES_REQUEST_KEY, new AnonymousClass2());
    }

    private final void configureEmptyState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ForumBrowserEmptyBinding forumBrowserEmptyBinding = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding, "binding.emptyView");
        ConstraintLayout constraintLayout = forumBrowserEmptyBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(0);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        this.adapterDataReference.clear();
        TextView textView = getBinding().c.f170b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyView.forumBrowserEmptySubheading");
        FormatUtils.m(textView, R.string.forum_empty_state_description, new Object[]{viewState.getChannelName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void configureGuidelinesButton(final WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().g;
        String channelTopic = viewState.getChannelTopic();
        floatingActionButton.setVisibility(!(channelTopic == null || channelTopic.length() == 0) && this.panelNsfwHidden ? 0 : 8);
        if (floatingActionButton.getVisibility() == 0) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.forums.WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, viewState.getGuildId(), viewState.getChannelId(), "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY");
                }
            });
        }
    }

    private final void configureListState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ForumBrowserEmptyBinding forumBrowserEmptyBinding = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding, "binding.emptyView");
        ConstraintLayout constraintLayout = forumBrowserEmptyBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(0);
        this.adapterDataReference.clear();
        this.adapterDataReference.addAll(viewState.getListItems());
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(viewState.getListItems());
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        forumBrowserLayoutManager.setOnLayoutCompletedCallback(new WidgetForumBrowser5(this, viewState));
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        forumBrowserScrollListener.setOnScrollCallback(new WidgetForumBrowser6(this, viewState));
        forumBrowserScrollListener.setOnScrollEndCallback(new WidgetForumBrowser7(this, viewState));
        forumBrowserScrollListener.setOnScrollStateChangedCallback(new WidgetForumBrowser8(this, viewState));
    }

    private final void enqueueForumPostFirstMessageFetches(long parentChannelId, long guildId) {
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindFirstVisibleItemPosition = forumBrowserLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            return;
        }
        ForumBrowserLayoutManager forumBrowserLayoutManager2 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindLastVisibleItemPosition = forumBrowserLayoutManager2.findLastVisibleItemPosition();
        if (iFindLastVisibleItemPosition == -1) {
            return;
        }
        int size = this.adapterDataReference.size();
        ForumBrowserLayoutManager forumBrowserLayoutManager3 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int i = (iFindFirstVisibleItemPosition / 10) * 10;
        int iCoerceAtMost = _Ranges.coerceAtMost(_Ranges.coerceAtMost(size, forumBrowserLayoutManager3.getItemCount()) - 1, (((iFindLastVisibleItemPosition / 10) + 1) * 10) - 1);
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
            getBinding().f.scrollToPosition(0);
        }
    }

    private final void handleViewState(WidgetForumBrowserViewModel.ViewState viewState) {
        WidgetForumBrowserViewModel.NsfwPanelState nsfwPanelState = viewState.getNsfwPanelState();
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(nsfwPanelState.getGuildId(), nsfwPanelState.isChannelNsfw(), nsfwPanelState.isNsfwUnconsented(), nsfwPanelState.getNsfwAllowed(), getBinding().e, new AnonymousClass1(viewState), (64 & 64) != 0 ? null : null);
        }
        if (!(viewState instanceof WidgetForumBrowserViewModel.ViewState.Loading)) {
            if (viewState instanceof WidgetForumBrowserViewModel.ViewState.Loaded) {
                ForumBrowserLoadingBinding forumBrowserLoadingBinding = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(forumBrowserLoadingBinding, "binding.loadingView");
                ConstraintLayout constraintLayout = forumBrowserLoadingBinding.a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.loadingView.root");
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
        ForumBrowserLoadingBinding forumBrowserLoadingBinding2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserLoadingBinding2, "binding.loadingView");
        ConstraintLayout constraintLayout2 = forumBrowserLoadingBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.loadingView.root");
        constraintLayout2.setVisibility(0);
        ForumBrowserEmptyBinding forumBrowserEmptyBinding = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding, "binding.emptyView");
        ConstraintLayout constraintLayout3 = forumBrowserEmptyBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.emptyView.root");
        constraintLayout3.setVisibility(8);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        Intrinsics3.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        extendedFloatingActionButton.setVisibility(8);
        FloatingActionButton floatingActionButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        floatingActionButton.setVisibility(8);
        ForumBrowserEmptyBinding forumBrowserEmptyBinding2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding2, "binding.emptyView");
        ConstraintLayout constraintLayout4 = forumBrowserEmptyBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout4, "binding.emptyView.root");
        constraintLayout4.setVisibility(8);
        this.adapterDataReference.clear();
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(Collections2.emptyList());
    }

    private final void onCreatePostClick(long guildId, long parentChannelId, boolean hasForumGuidelines) {
        if (!hasForumGuidelines || ForumGuidelinesManager.INSTANCE.hasSeenGuidelines(parentChannelId)) {
            openCreatePostScreen(guildId, parentChannelId);
            return;
        }
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        ChannelSelector.INSTANCE.getInstance().selectChannel(channel, Long.valueOf(channel.getParentId()), StoreChannelsSelected3.THREAD_BROWSER);
        requireActivity().onBackPressed();
    }

    private final void openForumPostOptions(Channel channel) {
        WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channel.getId());
    }

    private final void setWindowInsetListener(View viewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.forums.WidgetForumBrowser.setWindowInsetListener.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                Intrinsics3.checkNotNullExpressionValue(view, "view");
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
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        setWindowInsetListener(recyclerView);
        FloatingActionButton floatingActionButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        setWindowInsetListener(floatingActionButton);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        Intrinsics3.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        setWindowInsetListener(extendedFloatingActionButton);
    }

    public static final void show(Context context) {
        INSTANCE.show(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetForumBrowser.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetForumBrowser.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.forumBrowserAdapter = (WidgetForumBrowserAdapter) companion.configure(new WidgetForumBrowserAdapter(recyclerView, new AnonymousClass1(this), new AnonymousClass2(this)));
        RecyclerView recyclerView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        this.forumBrowserLayoutManager = new ForumBrowserLayoutManager(recyclerView2);
        this.forumBrowserScrollListener = new ForumBrowserScrollListener();
        RecyclerView recyclerView3 = getBinding().f;
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        recyclerView3.setLayoutManager(forumBrowserLayoutManager);
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        recyclerView3.addOnScrollListener(forumBrowserScrollListener);
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        recyclerView3.addItemDecoration(widgetForumBrowserAdapter.getItemDecoration());
        setWindowInsetsListeners();
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }
}
