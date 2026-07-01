package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEmptyGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", 0)};
    public static final WidgetServerSettingsEmptyGuildRoleSubscriptions$Companion Companion = new WidgetServerSettingsEmptyGuildRoleSubscriptions$Companion(null);
    private static final int SERVER_SETTINGS_EMPTY_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADED_STATE = 1;
    private static final int SERVER_SETTINGS_EMPTY_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsEmptyGuildRoleSubscriptions() {
        super(R$layout.widget_server_settings_empty_guild_role_subscription);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsEmptyGuildRoleSubscriptions$guildId$2(this));
        WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2 widgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2 = new WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class), new WidgetServerSettingsEmptyGuildRoleSubscriptions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions, ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState) {
        widgetServerSettingsEmptyGuildRoleSubscriptions.configureUI(serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        return widgetServerSettingsEmptyGuildRoleSubscriptions.getGuildId();
    }

    private final void configureUI(ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState viewState) {
        if (viewState.isLoading()) {
            AppViewFlipper appViewFlipper = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsEm…eSubscriptionsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsEm…eSubscriptionsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        Boolean boolIsMonetizationEnabled = viewState.isMonetizationEnabled();
        if (boolIsMonetizationEnabled != null) {
            if (boolIsMonetizationEnabled.booleanValue()) {
                getBinding().f2567b.setOnClickListener(new WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$1(this));
            } else {
                getBinding().f2567b.setOnClickListener(new WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$2(this));
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
        Companion.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(2131891423);
        getBinding().f2567b.setOnClickListener(new WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBound$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsEmptyGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
