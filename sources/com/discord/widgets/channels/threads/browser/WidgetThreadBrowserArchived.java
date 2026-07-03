package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetThreadBrowserArchived.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private WidgetThreadBrowserAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: browserViewModel$delegate, reason: from kotlin metadata */
    private final Lazy browserViewModel;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetThreadBrowserArchivedViewModel.ViewState currentViewState;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetThreadBrowserArchived create(long guildId, long channelId) {
            WidgetThreadBrowserArchived widgetThreadBrowserArchived = new WidgetThreadBrowserArchived();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetThreadBrowserArchived.setArguments(bundleM832T);
            return widgetThreadBrowserArchived;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onResume$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
    public static final class C76541 extends AbstractC12240o implements Function1<WidgetThreadBrowserArchivedViewModel.ViewState, Unit> {
        public C76541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowserArchived.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
    public static final /* synthetic */ class C76551 extends C12236k implements Function1<Channel, Unit> {
        public C76551(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel) {
            super(1, widgetThreadBrowserViewModel, WidgetThreadBrowserViewModel.class, "openThread", "openThread(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((WidgetThreadBrowserViewModel) this.receiver).openThread(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
    public static final class C76562 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C76562() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetThreadBrowserArchived.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, channel.getId());
        }
    }

    public WidgetThreadBrowserArchived() {
        super(C5419R.layout.widget_thread_browser_archived);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowserArchived$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetThreadBrowserArchived$guildId$2(this));
        this.channelId = C12083g.lazy(new WidgetThreadBrowserArchived$channelId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new C7650xcd74f63b(this), new C0863f0(new WidgetThreadBrowserArchived$viewModel$2(this)));
        this.browserViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new C7652xcd74f63d(this), new C0863f0(new WidgetThreadBrowserArchived$browserViewModel$2(this)));
    }

    private final WidgetThreadBrowserArchivedBinding getBinding() {
        return (WidgetThreadBrowserArchivedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadBrowserViewModel getBrowserViewModel() {
        return (WidgetThreadBrowserViewModel) this.browserViewModel.getValue();
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserArchivedViewModel getViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
        ConstraintLayout constraintLayout = getBinding().f18270d;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.threadBrowserErrorOverlay");
        constraintLayout.setVisibility(viewState.isError() ? 0 : 8);
        this.currentViewState = viewState;
        WidgetThreadBrowserAdapter widgetThreadBrowserAdapter = this.adapter;
        if (widgetThreadBrowserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetThreadBrowserAdapter.setData(viewState.getListItems());
        TextView textView = getBinding().f18268b.f1205d;
        C12238m.checkNotNullExpressionValue(textView, "binding.emptyView.threadBrowserEmptyHeading");
        textView.setText(requireContext().getString(C5419R.string.thread_browser_empty_state_archived_header));
        ConstraintLayout constraintLayout2 = getBinding().f18268b.f1203b;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.emptyView.threadBrowserEmpty");
        constraintLayout2.setVisibility(viewState.getListItems().isEmpty() ? 0 : 8);
        MaterialButton materialButton = getBinding().f18268b.f1204c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.emptyView.threadBrowserEmptyCreateButton");
        materialButton.setVisibility(viewState.getCanCreateThread() ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetThreadBrowserArchived.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76541());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f18269c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (WidgetThreadBrowserAdapter) companion.configure(new WidgetThreadBrowserAdapter(recyclerView, new C76551(getBrowserViewModel()), new C76562()));
        getBinding().f18269c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived.onViewBound.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                C12238m.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager == null || linearLayoutManager.findLastVisibleItemPosition() < linearLayoutManager.getItemCount() - 8) {
                    return;
                }
                WidgetThreadBrowserArchivedViewModel.maybeLoadMore$default(WidgetThreadBrowserArchived.this.getViewModel(), false, 1, null);
            }
        });
        getBinding().f18268b.f1204c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowserArchived.this.getGuildId(), WidgetThreadBrowserArchived.this.getChannelId(), null, "Thread Browser Empty State", 4, null);
                WidgetThreadBrowserArchived.this.requireAppActivity().finish();
            }
        });
        getBinding().f18271e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetThreadBrowserArchived.this.getViewModel().maybeLoadMore(true);
            }
        });
    }
}
