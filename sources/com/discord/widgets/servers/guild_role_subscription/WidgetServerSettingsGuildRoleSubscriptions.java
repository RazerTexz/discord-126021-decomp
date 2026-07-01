package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel$ViewState;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0)};
    public static final WidgetServerSettingsGuildRoleSubscriptions$Companion Companion = new WidgetServerSettingsGuildRoleSubscriptions$Companion(null);
    private static final String INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID = "INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID";
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_OVERVIEW_STATE = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: planDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy planDetailsViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsGuildRoleSubscriptions() {
        super(R$layout.widget_server_settings_guild_role_subscriptions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptions$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsGuildRoleSubscriptions$guildId$2(this));
        WidgetServerSettingsGuildRoleSubscriptions$viewModel$2 widgetServerSettingsGuildRoleSubscriptions$viewModel$2 = new WidgetServerSettingsGuildRoleSubscriptions$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionViewModel.class), new WidgetServerSettingsGuildRoleSubscriptions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetServerSettingsGuildRoleSubscriptions$viewModel$2));
        this.planDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetServerSettingsGuildRoleSubscriptions$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetServerSettingsGuildRoleSubscriptions$planDetailsViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions, ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewState) {
        widgetServerSettingsGuildRoleSubscriptions.configureUI(serverSettingsGuildRoleSubscriptionViewModel$ViewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        return widgetServerSettingsGuildRoleSubscriptions.getGuildId();
    }

    public static final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        return widgetServerSettingsGuildRoleSubscriptions.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions, ServerSettingsGuildRoleSubscriptionViewModel$Event serverSettingsGuildRoleSubscriptionViewModel$Event) {
        widgetServerSettingsGuildRoleSubscriptions.handleEvents(serverSettingsGuildRoleSubscriptionViewModel$Event);
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel$ViewState viewState) {
        if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Empty) {
            WidgetServerSettingsEmptyGuildRoleSubscriptions.Companion.launch(requireContext(), getGuildId());
            requireActivity().finish();
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) {
            configureUI((ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) viewState);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Failed) {
            b.a.d.m.i(this, 2131888366, 0, 4);
            requireActivity().finish();
        }
    }

    private final WidgetServerSettingsGuildRoleSubscriptionsBinding getBinding() {
        return (WidgetServerSettingsGuildRoleSubscriptionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getPlanDetailsViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.planDetailsViewModel.getValue();
    }

    private final ServerSettingsGuildRoleSubscriptionViewModel getViewModel() {
        return (ServerSettingsGuildRoleSubscriptionViewModel) this.viewModel.getValue();
    }

    private final void handleEvents(ServerSettingsGuildRoleSubscriptionViewModel$Event event) {
        if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitSuccess) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            return;
        }
        if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitFailure) {
            b.a.d.m.i(this, 2131888366, 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
        } else if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate) {
            ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate = (ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate) event;
            getPlanDetailsViewModel().setGroupPlanDetails(serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.getGuildRoleSubscriptionGroupListing(), serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.getFullServerGatingOverwrite());
        }
    }

    public static final void launch(Context context, long j) {
        Companion.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(2131891423);
        getBinding().f2571b.setOnClickListener(new WidgetServerSettingsGuildRoleSubscriptions$onViewBound$1(this));
        getChildFragmentManager().beginTransaction().replace(R$id.guild_role_subscription_plan_details, WidgetGuildRoleSubscriptionPlanDetails.Companion.newInstance(true)).replace(R$id.guild_role_subscription_plan_format, WidgetGuildRoleSubscriptionPlanFormat.Companion.newInstance(true)).commit();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<ServerSettingsGuildRoleSubscriptionViewModel$Event> observableR2 = getViewModel().observeEvents().r();
        m.checkNotNullExpressionValue(observableR2, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$2(this), 62, (Object) null);
        Observable<GuildRoleSubscriptionPlanDetailsViewModel$ViewState> observableR3 = getPlanDetailsViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR3, "planDetailsViewModel\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR3, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded loadedViewState) {
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        FloatingActionButton floatingActionButton = getBinding().f2571b;
        floatingActionButton.setVisibility(loadedViewState.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!loadedViewState.isSubmitting());
    }
}
