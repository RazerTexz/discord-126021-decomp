package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
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

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID = "INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID";

    /* JADX INFO: renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE */
    private static final int f19395x4404778b = 0;

    /* JADX INFO: renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_OVERVIEW_STATE */
    private static final int f19396xcae62dce = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: planDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy planDetailsViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptions.INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID, guildId);
            C0870j.m156d(context, WidgetServerSettingsGuildRoleSubscriptions.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class C94611 extends AbstractC12240o implements Function1<ServerSettingsGuildRoleSubscriptionViewModel.ViewState, Unit> {
        public C94611() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = WidgetServerSettingsGuildRoleSubscriptions.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsGuildRoleSubscriptions.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class C94622 extends AbstractC12240o implements Function1<ServerSettingsGuildRoleSubscriptionViewModel.Event, Unit> {
        public C94622() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
            WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = WidgetServerSettingsGuildRoleSubscriptions.this;
            C12238m.checkNotNullExpressionValue(event, "it");
            widgetServerSettingsGuildRoleSubscriptions.handleEvents(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class C94633 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public C94633() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptions.this.getViewModel().onGuildRoleSubscriptionGroupUpdated(viewState.getDescription(), viewState.getCoverImage(), viewState.isFullServerGate());
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptions() {
        super(C5419R.layout.widget_server_settings_guild_role_subscriptions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptions$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsGuildRoleSubscriptions$guildId$2(this));
        WidgetServerSettingsGuildRoleSubscriptions$viewModel$2 widgetServerSettingsGuildRoleSubscriptions$viewModel$2 = new WidgetServerSettingsGuildRoleSubscriptions$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionViewModel.class), new C9459x63d36138(c0865g0), new C0869i0(widgetServerSettingsGuildRoleSubscriptions$viewModel$2));
        this.planDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new C9457x273fb616(this), new C0863f0(C9464x86a1a2a6.INSTANCE));
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17673c;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Empty) {
            WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
            requireActivity().finish();
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded) {
            configureUI((ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Failed) {
            C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
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

    private final void handleEvents(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
        if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel.Event.SubmitSuccess) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            return;
        }
        if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel.Event.SubmitFailure) {
            C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
        } else if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel.Event.StoreStateUpdate) {
            ServerSettingsGuildRoleSubscriptionViewModel.Event.StoreStateUpdate storeStateUpdate = (ServerSettingsGuildRoleSubscriptionViewModel.Event.StoreStateUpdate) event;
            getPlanDetailsViewModel().setGroupPlanDetails(storeStateUpdate.getGuildRoleSubscriptionGroupListing(), storeStateUpdate.getFullServerGatingOverwrite());
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.guild_settings_role_subscriptions_title);
        getBinding().f17672b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsGuildRoleSubscriptions.this.getViewModel().submitChanges();
            }
        });
        getChildFragmentManager().beginTransaction().replace(C5419R.id.guild_role_subscription_plan_details, WidgetGuildRoleSubscriptionPlanDetails.INSTANCE.newInstance(true)).replace(C5419R.id.guild_role_subscription_plan_format, WidgetGuildRoleSubscriptionPlanFormat.INSTANCE.newInstance(true)).commit();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94611());
        Observable<ServerSettingsGuildRoleSubscriptionViewModel.Event> observableM11112r2 = getViewModel().observeEvents().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r2, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r2, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94622());
        Observable<GuildRoleSubscriptionPlanDetailsViewModel.ViewState> observableM11112r3 = getPlanDetailsViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r3, "planDetailsViewModel\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r3, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94633());
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded loadedViewState) {
        AppViewFlipper appViewFlipper = getBinding().f17673c;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        FloatingActionButton floatingActionButton = getBinding().f17672b;
        floatingActionButton.setVisibility(loadedViewState.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!loadedViewState.isSubmitting());
    }
}
