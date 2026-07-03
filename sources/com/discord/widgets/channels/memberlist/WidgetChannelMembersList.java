package com.discord.widgets.channels.memberlist;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p507d0.C12083g;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList extends AppFragment {
    private static final String SOURCE = "WidgetChannelMembersList";
    private ChannelMembersListAdapter adapter;
    private int memberCellHeightPx;

    /* JADX INFO: renamed from: recycler$delegate, reason: from kotlin metadata */
    private final Lazy recycler;
    private final RxOnScrollListener scrollListener;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class RxOnScrollListener extends RecyclerView.OnScrollListener {
        private final PublishSubject<Unit> scrollYSubject = PublishSubject.m11133k0();

        public final Observable<Unit> observeScrollChanges() {
            PublishSubject<Unit> publishSubject = this.scrollYSubject;
            C12238m.checkNotNullExpressionValue(publishSubject, "scrollYSubject");
            return publishSubject;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            PublishSubject<Unit> publishSubject = this.scrollYSubject;
            publishSubject.f27650k.onNext(Unit.f27425a);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$configureLoadedUI$1 */
    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class C74881 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ WidgetChannelMembersListViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74881(WidgetChannelMembersListViewModel.ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            Long lValueOf = Long.valueOf(this.$viewState.getChannel().getId());
            FragmentManager parentFragmentManager = WidgetChannelMembersList.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, lValueOf, parentFragmentManager, Long.valueOf(this.$viewState.getChannel().getGuildId()), null, null, null, 112, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$configureLoadedUI$2 */
    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class C74892 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ WidgetChannelMembersListViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74892(WidgetChannelMembersListViewModel.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetChannelMembersList.this, this.$viewState.getChannel(), WidgetChannelMembersList.SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$configureLoadedUI$3 */
    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class C74903 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ WidgetChannelMembersListViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74903(WidgetChannelMembersListViewModel.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChannelMembersList.this.getViewModel().onThreadJoinLeaveClicked(this.$viewState.getChannel().getId(), this.$viewState.isThreadJoined());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class C74911 extends AbstractC12240o implements Function1<WidgetChannelMembersListViewModel.ViewState, Unit> {
        public C74911() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelMembersListViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetChannelMembersList.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class C74922 extends AbstractC12240o implements Function1<WidgetChannelMembersListViewModel.Event, Unit> {
        public C74922() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelMembersListViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            if (C12238m.areEqual(event, WidgetChannelMembersListViewModel.Event.ScrollToTop.INSTANCE)) {
                WidgetChannelMembersList.this.scrollToTop();
            } else if (C12238m.areEqual(event, WidgetChannelMembersListViewModel.Event.UpdateRanges.INSTANCE)) {
                WidgetChannelMembersList.this.updateRanges();
            } else if (event instanceof WidgetChannelMembersListViewModel.Event.Error) {
                WidgetChannelMembersList.this.showError((WidgetChannelMembersListViewModel.Event.Error) event);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetChannelMembersList.kt */
    public static final class C74933 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C74933() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetChannelMembersList.this.updateRanges();
        }
    }

    public WidgetChannelMembersList() {
        super(C5419R.layout.widget_channel_members_list);
        this.recycler = C12083g.lazy(new WidgetChannelMembersList$recycler$2(this));
        this.scrollListener = new RxOnScrollListener();
        WidgetChannelMembersList$viewModel$2 widgetChannelMembersList$viewModel$2 = WidgetChannelMembersList$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChannelMembersListViewModel.class), new WidgetChannelMembersList$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChannelMembersList$viewModel$2));
    }

    private final void configureLoadedUI(WidgetChannelMembersListViewModel.ViewState.Loaded viewState) {
        if (viewState.getChannel() != null) {
            ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
            if (channelMembersListAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter.setOnUserClicked(new C74881(viewState));
            ChannelMembersListAdapter channelMembersListAdapter2 = this.adapter;
            if (channelMembersListAdapter2 == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter2.setOnAddMemberClicked(new C74892(viewState));
            ChannelMembersListAdapter channelMembersListAdapter3 = this.adapter;
            if (channelMembersListAdapter3 == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter3.setOnJoinLeaveThreadClicked(new C74903(viewState));
        }
        ChannelMembersListAdapter channelMembersListAdapter4 = this.adapter;
        if (channelMembersListAdapter4 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter4.setData(viewState.getListItems().getListId(), viewState.getListItems(), true);
    }

    private final void configureUI(WidgetChannelMembersListViewModel.ViewState viewState) {
        if (!C12238m.areEqual(viewState, WidgetChannelMembersListViewModel.ViewState.Empty.INSTANCE) && (viewState instanceof WidgetChannelMembersListViewModel.ViewState.Loaded)) {
            configureLoadedUI((WidgetChannelMembersListViewModel.ViewState.Loaded) viewState);
        }
    }

    private final RecyclerView getRecycler() {
        return (RecyclerView) this.recycler.getValue();
    }

    private final WidgetChannelMembersListViewModel getViewModel() {
        return (WidgetChannelMembersListViewModel) this.viewModel.getValue();
    }

    private final void scrollToTop() {
        getRecycler().scrollToPosition(0);
    }

    private final void setupRecyclerView() {
        this.memberCellHeightPx = getResources().getDimensionPixelSize(C5419R.dimen.channel_list_row_height);
        getRecycler().setHasFixedSize(true);
        getRecycler().removeOnScrollListener(this.scrollListener);
        getRecycler().addOnScrollListener(this.scrollListener);
        ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
        if (channelMembersListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(channelMembersListAdapter);
        getRecycler().addItemDecoration(stickyHeaderItemDecoration);
        stickyHeaderItemDecoration.blockClicks(getRecycler());
        RecyclerView recycler = getRecycler();
        ChannelMembersListAdapter channelMembersListAdapter2 = this.adapter;
        if (channelMembersListAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recycler.setAdapter(channelMembersListAdapter2);
    }

    private final void showError(WidgetChannelMembersListViewModel.Event.Error event) {
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(event.getCode());
        C0876m.m171i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : C5419R.string.network_error_bad_request, 0, 4);
    }

    private final void updateRanges() {
        View view = getView();
        if (view != null) {
            int height = (view.getHeight() / this.memberCellHeightPx) + 1;
            RecyclerView.LayoutManager layoutManager = getRecycler().getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            getViewModel().updateSubscriptionsForChannel(new IntRange(C11226f.coerceAtLeast(linearLayoutManager.findFirstVisibleItemPosition() - height, 0), linearLayoutManager.findLastVisibleItemPosition() + height));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChannelMembersListAdapter channelMembersListAdapter = new ChannelMembersListAdapter();
        this.adapter = channelMembersListAdapter;
        if (channelMembersListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter.setHasStableIds(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
        if (channelMembersListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter.dispose();
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelMembersList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74911());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChannelMembersList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74922());
        Observable<Unit> observableM11110p = this.scrollListener.observeScrollChanges().m11110p(100L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "scrollListener\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), (Class<?>) WidgetChannelMembersList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74933());
    }
}
