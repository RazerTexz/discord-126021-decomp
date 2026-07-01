package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptions.INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID, guildId);
            AppScreen2.d(context, WidgetServerSettingsGuildRoleSubscriptions.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = WidgetServerSettingsGuildRoleSubscriptions.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsGuildRoleSubscriptions.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
            WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = WidgetServerSettingsGuildRoleSubscriptions.this;
            Intrinsics3.checkNotNullExpressionValue(event, "it");
            widgetServerSettingsGuildRoleSubscriptions.handleEvents(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptions.this.getViewModel().onGuildRoleSubscriptionGroupUpdated(viewState.getDescription(), viewState.getCoverImage(), viewState.isFullServerGate());
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptions() {
        super(R.layout.widget_server_settings_guild_role_subscriptions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptions2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsGuildRoleSubscriptions3(this));
        WidgetServerSettingsGuildRoleSubscriptions5 widgetServerSettingsGuildRoleSubscriptions5 = new WidgetServerSettingsGuildRoleSubscriptions5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionViewModel.class), new WidgetServerSettingsGuildRoleSubscriptions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsGuildRoleSubscriptions5));
        this.planDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetServerSettingsGuildRoleSubscriptions$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsGuildRoleSubscriptions4.INSTANCE));
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Empty) {
            WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
            requireActivity().finish();
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded) {
            configureUI((ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Failed) {
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
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
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.guild_settings_role_subscriptions_title);
        getBinding().f2571b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsGuildRoleSubscriptions.this.getViewModel().submitChanges();
            }
        });
        getChildFragmentManager().beginTransaction().replace(R.id.guild_role_subscription_plan_details, WidgetGuildRoleSubscriptionPlanDetails.INSTANCE.newInstance(true)).replace(R.id.guild_role_subscription_plan_format, WidgetGuildRoleSubscriptionPlanFormat.INSTANCE.newInstance(true)).commit();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        Observable<ServerSettingsGuildRoleSubscriptionViewModel.Event> observableR2 = getViewModel().observeEvents().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        Observable<GuildRoleSubscriptionPlanDetailsViewModel.ViewState> observableR3 = getPlanDetailsViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "planDetailsViewModel\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR3, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded loadedViewState) {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        FloatingActionButton floatingActionButton = getBinding().f2571b;
        floatingActionButton.setVisibility(loadedViewState.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!loadedViewState.isSubmitting());
    }
}
