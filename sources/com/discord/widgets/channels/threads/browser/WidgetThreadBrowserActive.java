package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActive extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetThreadBrowserActive.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private WidgetThreadBrowserAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: browserViewModel$delegate, reason: from kotlin metadata */
    private final Lazy browserViewModel;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetThreadBrowserActive create(long guildId, long channelId) {
            WidgetThreadBrowserActive widgetThreadBrowserActive = new WidgetThreadBrowserActive();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetThreadBrowserActive.setArguments(bundleM832T);
            return widgetThreadBrowserActive;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onResume$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
    public static final class C76441 extends AbstractC12240o implements Function1<WidgetThreadBrowserActiveViewModel.ViewState, Unit> {
        public C76441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserActiveViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserActiveViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowserActive.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
    public static final /* synthetic */ class C76451 extends C12236k implements Function1<Channel, Unit> {
        public C76451(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel) {
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
    public static final class C76462 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C76462() {
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
            FragmentManager parentFragmentManager = WidgetThreadBrowserActive.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, channel.getId());
        }
    }

    public WidgetThreadBrowserActive() {
        super(C5419R.layout.widget_thread_browser_active);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowserActive$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetThreadBrowserActive$guildId$2(this));
        this.channelId = C12083g.lazy(new WidgetThreadBrowserActive$channelId$2(this));
        WidgetThreadBrowserActive$viewModel$2 widgetThreadBrowserActive$viewModel$2 = new WidgetThreadBrowserActive$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadBrowserActiveViewModel.class), new WidgetThreadBrowserActive$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetThreadBrowserActive$viewModel$2));
        this.browserViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new C7642xb317a1df(this), new C0863f0(new WidgetThreadBrowserActive$browserViewModel$2(this)));
    }

    private final WidgetThreadBrowserActiveBinding getBinding() {
        return (WidgetThreadBrowserActiveBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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

    private final WidgetThreadBrowserActiveViewModel getViewModel() {
        return (WidgetThreadBrowserActiveViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetThreadBrowserActiveViewModel.ViewState viewState) {
        WidgetThreadBrowserAdapter widgetThreadBrowserAdapter = this.adapter;
        if (widgetThreadBrowserAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetThreadBrowserAdapter.setData(viewState.getListItems());
        TextView textView = getBinding().f18265b.f1205d;
        C12238m.checkNotNullExpressionValue(textView, "binding.emptyView.threadBrowserEmptyHeading");
        textView.setText(requireContext().getString(C5419R.string.thread_browser_empty_state_active_header));
        ConstraintLayout constraintLayout = getBinding().f18265b.f1203b;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.threadBrowserEmpty");
        constraintLayout.setVisibility(viewState.getListItems().isEmpty() ? 0 : 8);
        MaterialButton materialButton = getBinding().f18265b.f1204c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.emptyView.threadBrowserEmptyCreateButton");
        materialButton.setVisibility(viewState.getCanCreateThread() ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetThreadBrowserActive.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76441());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f18266c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (WidgetThreadBrowserAdapter) companion.configure(new WidgetThreadBrowserAdapter(recyclerView, new C76451(getBrowserViewModel()), new C76462()));
        getBinding().f18265b.f1204c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowserActive.this.getGuildId(), WidgetThreadBrowserActive.this.getChannelId(), null, "Thread Browser Empty State", 4, null);
                WidgetThreadBrowserActive.this.requireAppActivity().finish();
            }
        });
    }
}
