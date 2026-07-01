package com.discord.widgets.servers.role_members;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
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

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsRoleMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0)};
    public static final WidgetServerSettingsRoleMembers$Companion Companion = new WidgetServerSettingsRoleMembers$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_ROLE_ID = "INTENT_EXTRA_GUILD_ROLE_ID";
    private static final int ROLE_MEMBERS_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int ROLE_MEMBERS_VIEW_FLIPPER_RESULT = 1;
    private ServerSettingsRoleMembersAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: guildRoleId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsRoleMembers() {
        super(R$layout.widget_server_settings_role_members);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsRoleMembers$binding$2.INSTANCE, null, 2, null);
        this.guildRoleId = g.lazy(new WidgetServerSettingsRoleMembers$guildRoleId$2(this));
        this.guildId = g.lazy(new WidgetServerSettingsRoleMembers$guildId$2(this));
        WidgetServerSettingsRoleMembers$viewModel$2 widgetServerSettingsRoleMembers$viewModel$2 = new WidgetServerSettingsRoleMembers$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ServerSettingsRoleMembersViewModel.class), new WidgetServerSettingsRoleMembers$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetServerSettingsRoleMembers$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers, ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewState) {
        widgetServerSettingsRoleMembers.configureUI(serverSettingsRoleMembersViewModel$ViewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        return widgetServerSettingsRoleMembers.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildRoleId$p(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        return widgetServerSettingsRoleMembers.getGuildRoleId();
    }

    public static final /* synthetic */ ServerSettingsRoleMembersViewModel access$getViewModel$p(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        return widgetServerSettingsRoleMembers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers, ServerSettingsRoleMembersViewModel$Event serverSettingsRoleMembersViewModel$Event) {
        widgetServerSettingsRoleMembers.handleEvents(serverSettingsRoleMembersViewModel$Event);
    }

    private final void configureUI(ServerSettingsRoleMembersViewModel$ViewState viewState) {
        if (viewState instanceof ServerSettingsRoleMembersViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2584b;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.roleMembersAppViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsRoleMembersViewModel$ViewState$Loaded) {
            AppViewFlipper appViewFlipper2 = getBinding().f2584b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.roleMembersAppViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter = this.adapter;
            if (serverSettingsRoleMembersAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            serverSettingsRoleMembersAdapter.setRemoveMemberClickListener(new WidgetServerSettingsRoleMembers$configureUI$1(this, viewState));
            ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter2 = this.adapter;
            if (serverSettingsRoleMembersAdapter2 == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            serverSettingsRoleMembersAdapter2.setItems(((ServerSettingsRoleMembersViewModel$ViewState$Loaded) viewState).getMemberList());
        }
    }

    private final WidgetServerSettingsRoleMembersBinding getBinding() {
        return (WidgetServerSettingsRoleMembersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildRoleId() {
        return ((Number) this.guildRoleId.getValue()).longValue();
    }

    private final ServerSettingsRoleMembersViewModel getViewModel() {
        return (ServerSettingsRoleMembersViewModel) this.viewModel.getValue();
    }

    private final void handleEvents(ServerSettingsRoleMembersViewModel$Event event) {
        if (event instanceof ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure) {
            b.a.d.m.i(this, 2131888366, 0, 4);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.adapter = new ServerSettingsRoleMembersAdapter(this, null, 2, null);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRoleMembersList");
        ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter = this.adapter;
        if (serverSettingsRoleMembersAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(serverSettingsRoleMembersAdapter);
        getBinding().d.a(this, new WidgetServerSettingsRoleMembers$onViewBound$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsRoleMembersViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsRoleMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsRoleMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
