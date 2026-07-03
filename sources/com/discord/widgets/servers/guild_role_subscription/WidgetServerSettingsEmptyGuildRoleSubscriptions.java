package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsEmptyGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: SERVER_SETTINGS_EMPTY_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADED_STATE */
    private static final int f19391x695af06c = 1;

    /* JADX INFO: renamed from: SERVER_SETTINGS_EMPTY_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE */
    private static final int f19392x40bf7979 = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C0870j.m156d(context, WidgetServerSettingsEmptyGuildRoleSubscriptions.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
    public static final class C94531 extends AbstractC12240o implements Function1<ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState, Unit> {
        public C94531() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
            WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions = WidgetServerSettingsEmptyGuildRoleSubscriptions.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsEmptyGuildRoleSubscriptions.configureUI(viewState);
        }
    }

    public WidgetServerSettingsEmptyGuildRoleSubscriptions() {
        super(C5419R.layout.widget_server_settings_empty_guild_role_subscription);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsEmptyGuildRoleSubscriptions$guildId$2(this));
        WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2 widgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2 = new WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class), new C9449x24a2fb51(c0865g0), new C0869i0(widgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2));
    }

    private final void configureUI(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
        if (viewState.isLoading()) {
            AppViewFlipper appViewFlipper = getBinding().f17657c;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsEm…eSubscriptionsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().f17657c;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsEm…eSubscriptionsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        Boolean boolIsMonetizationEnabled = viewState.isMonetizationEnabled();
        if (boolIsMonetizationEnabled != null) {
            if (boolIsMonetizationEnabled.booleanValue()) {
                getBinding().f17656b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetGuildRoleSubscriptionPlanSetup.INSTANCE.launch(this.this$0.requireContext(), this.this$0.getGuildId());
                        this.this$0.requireActivity().finish();
                    }
                });
            } else {
                getBinding().f17656b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetServerSettingsEnableMonetizationUnavailable.Companion.launch(this.this$0.requireContext());
                    }
                });
            }
        }
    }

    private final WidgetServerSettingsEmptyGuildRoleSubscriptionBinding getBinding() {
        return (WidgetServerSettingsEmptyGuildRoleSubscriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsEmptyGuildRoleSubscriptionsViewModel getViewModel() {
        return (ServerSettingsEmptyGuildRoleSubscriptionsViewModel) this.viewModel.getValue();
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
        getBinding().f17656b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionPlanSetup.INSTANCE.launch(WidgetServerSettingsEmptyGuildRoleSubscriptions.this.requireContext(), WidgetServerSettingsEmptyGuildRoleSubscriptions.this.getGuildId());
                WidgetServerSettingsEmptyGuildRoleSubscriptions.this.requireActivity().finish();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsEmptyGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94531());
    }
}
