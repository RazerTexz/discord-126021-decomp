package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionTierListBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsGuildRoleSubscriptionTierList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_TIERS_VIEW_FLIPPER_LOADED_STATE */
    private static final int f19393x64833d6d = 1;

    /* JADX INFO: renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_TIERS_VIEW_FLIPPER_LOADING_STATE */
    private static final int f19394xaaa0cc98 = 0;
    private ServerSettingsGuildRoleSubscriptionTierAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C0870j.m156d(context, WidgetServerSettingsGuildRoleSubscriptionTierList.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
    public static final class C94561 extends AbstractC12240o implements Function1<ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState, Unit> {
        public C94561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList = WidgetServerSettingsGuildRoleSubscriptionTierList.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsGuildRoleSubscriptionTierList.configureUI(viewState);
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptionTierList() {
        super(C5419R.layout.widget_server_settings_guild_role_subscription_tier_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionTierList$binding$2.INSTANCE, null, 2, null);
        WidgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2 widgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2 = new WidgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionTierListViewModel.class), new C9454x6bb8463d(c0865g0), new C0869i0(widgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2));
        this.guildId = C12083g.lazy(new WidgetServerSettingsGuildRoleSubscriptionTierList$guildId$2(this));
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17670c;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionTierListViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded) {
            configureUI((ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Failed) {
            C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
            requireActivity().finish();
        }
    }

    private final WidgetServerSettingsGuildRoleSubscriptionTierListBinding getBinding() {
        return (WidgetServerSettingsGuildRoleSubscriptionTierListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsGuildRoleSubscriptionTierListViewModel getViewModel() {
        return (ServerSettingsGuildRoleSubscriptionTierListViewModel) this.viewModel.getValue();
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.adapter = new ServerSettingsGuildRoleSubscriptionTierAdapter(this, null, 2, 0 == true ? 1 : 0);
        RecyclerView recyclerView = getBinding().f17669b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsGu…dRoleSubscriptionTierList");
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(serverSettingsGuildRoleSubscriptionTierAdapter);
        RecyclerView recyclerView2 = getBinding().f17669b;
        Context contextRequireContext = requireContext();
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter2 = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(contextRequireContext, 1, serverSettingsGuildRoleSubscriptionTierAdapter2, DimenUtils.dpToPixels(8), 0, 16, null));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.guild_role_subscription_settings_section_tiers);
        setActionBarSubtitle(C5419R.string.guild_settings_role_subscriptions_title);
        Observable<ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptionTierList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94561());
    }

    private final void configureUI(final ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded loadedViewState) {
        AppViewFlipper appViewFlipper = getBinding().f17670c;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionTierListViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        serverSettingsGuildRoleSubscriptionTierAdapter.setItemClickListener(new ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList.configureUI.1
            @Override // com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener
            public void onAddTierItemClick() {
                WidgetCreateGuildRoleSubscriptionTier.INSTANCE.launch(WidgetServerSettingsGuildRoleSubscriptionTierList.this.requireContext(), WidgetServerSettingsGuildRoleSubscriptionTierList.this.getGuildId(), loadedViewState.getGroupListingId());
            }

            @Override // com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener
            public void onTierItemClick(long tierListingId) {
                WidgetServerSettingsGuildRoleSubscriptionEditTier.INSTANCE.launch(WidgetServerSettingsGuildRoleSubscriptionTierList.this.requireContext(), WidgetServerSettingsGuildRoleSubscriptionTierList.this.getGuildId(), loadedViewState.getGroupListingId(), tierListingId);
            }
        });
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter2 = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        serverSettingsGuildRoleSubscriptionTierAdapter2.setItems(loadedViewState.getAdapterItems());
    }
}
