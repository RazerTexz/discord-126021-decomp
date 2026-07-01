package com.discord.widgets.channels.memberlist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.a.d.g0;
import b.a.d.i0;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.d0.f;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList extends AppFragment {
    public static final WidgetChannelMembersList$Companion Companion = new WidgetChannelMembersList$Companion(null);
    private static final String SOURCE = "WidgetChannelMembersList";
    private ChannelMembersListAdapter adapter;
    private int memberCellHeightPx;

    /* JADX INFO: renamed from: recycler$delegate, reason: from kotlin metadata */
    private final Lazy recycler;
    private final WidgetChannelMembersList$RxOnScrollListener scrollListener;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelMembersList() {
        super(R$layout.widget_channel_members_list);
        this.recycler = g.lazy(new WidgetChannelMembersList$recycler$2(this));
        this.scrollListener = new WidgetChannelMembersList$RxOnScrollListener();
        WidgetChannelMembersList$viewModel$2 widgetChannelMembersList$viewModel$2 = WidgetChannelMembersList$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelMembersListViewModel.class), new WidgetChannelMembersList$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelMembersList$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelMembersList widgetChannelMembersList, WidgetChannelMembersListViewModel$ViewState widgetChannelMembersListViewModel$ViewState) {
        widgetChannelMembersList.configureUI(widgetChannelMembersListViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetChannelMembersListViewModel access$getViewModel$p(WidgetChannelMembersList widgetChannelMembersList) {
        return widgetChannelMembersList.getViewModel();
    }

    public static final /* synthetic */ void access$scrollToTop(WidgetChannelMembersList widgetChannelMembersList) {
        widgetChannelMembersList.scrollToTop();
    }

    public static final /* synthetic */ void access$showError(WidgetChannelMembersList widgetChannelMembersList, WidgetChannelMembersListViewModel$Event$Error widgetChannelMembersListViewModel$Event$Error) {
        widgetChannelMembersList.showError(widgetChannelMembersListViewModel$Event$Error);
    }

    public static final /* synthetic */ void access$updateRanges(WidgetChannelMembersList widgetChannelMembersList) {
        widgetChannelMembersList.updateRanges();
    }

    private final void configureLoadedUI(WidgetChannelMembersListViewModel$ViewState$Loaded viewState) {
        if (viewState.getChannel() != null) {
            ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
            if (channelMembersListAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter.setOnUserClicked(new WidgetChannelMembersList$configureLoadedUI$1(this, viewState));
            ChannelMembersListAdapter channelMembersListAdapter2 = this.adapter;
            if (channelMembersListAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter2.setOnAddMemberClicked(new WidgetChannelMembersList$configureLoadedUI$2(this, viewState));
            ChannelMembersListAdapter channelMembersListAdapter3 = this.adapter;
            if (channelMembersListAdapter3 == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter3.setOnJoinLeaveThreadClicked(new WidgetChannelMembersList$configureLoadedUI$3(this, viewState));
        }
        ChannelMembersListAdapter channelMembersListAdapter4 = this.adapter;
        if (channelMembersListAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter4.setData(viewState.getListItems().getListId(), viewState.getListItems(), true);
    }

    private final void configureUI(WidgetChannelMembersListViewModel$ViewState viewState) {
        if (!m.areEqual(viewState, WidgetChannelMembersListViewModel$ViewState$Empty.INSTANCE) && (viewState instanceof WidgetChannelMembersListViewModel$ViewState$Loaded)) {
            configureLoadedUI((WidgetChannelMembersListViewModel$ViewState$Loaded) viewState);
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
        this.memberCellHeightPx = getResources().getDimensionPixelSize(2131165311);
        getRecycler().setHasFixedSize(true);
        getRecycler().removeOnScrollListener(this.scrollListener);
        getRecycler().addOnScrollListener(this.scrollListener);
        ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
        if (channelMembersListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(channelMembersListAdapter);
        getRecycler().addItemDecoration(stickyHeaderItemDecoration);
        stickyHeaderItemDecoration.blockClicks(getRecycler());
        RecyclerView recycler = getRecycler();
        ChannelMembersListAdapter channelMembersListAdapter2 = this.adapter;
        if (channelMembersListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recycler.setAdapter(channelMembersListAdapter2);
    }

    private final void showError(WidgetChannelMembersListViewModel$Event$Error event) {
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(event.getCode());
        b.a.d.m.i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : 2131893169, 0, 4);
    }

    private final void updateRanges() {
        View view = getView();
        if (view != null) {
            int height = (view.getHeight() / this.memberCellHeightPx) + 1;
            RecyclerView$LayoutManager layoutManager = getRecycler().getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            getViewModel().updateSubscriptionsForChannel(new IntRange(f.coerceAtLeast(linearLayoutManager.findFirstVisibleItemPosition() - height, 0), linearLayoutManager.findLastVisibleItemPosition() + height));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChannelMembersListAdapter channelMembersListAdapter = new ChannelMembersListAdapter();
        this.adapter = channelMembersListAdapter;
        if (channelMembersListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter.setHasStableIds(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
        if (channelMembersListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter.dispose();
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelMembersList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelMembersList$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChannelMembersList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelMembersList$onViewBoundOrOnResume$2(this), 62, (Object) null);
        Observable<Unit> observableP = this.scrollListener.observeScrollChanges().p(100L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "scrollListener\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), WidgetChannelMembersList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelMembersList$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
