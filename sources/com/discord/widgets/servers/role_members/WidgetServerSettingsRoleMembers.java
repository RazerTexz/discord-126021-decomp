package com.discord.widgets.servers.role_members;

import android.content.Context;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0825e;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsRoleMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetServerSettingsRoleMembers newInstance(long guildRoleId, long guildId) {
            WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = new WidgetServerSettingsRoleMembers();
            widgetServerSettingsRoleMembers.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetServerSettingsRoleMembers.INTENT_EXTRA_GUILD_ROLE_ID, Long.valueOf(guildRoleId)), C12116o.m10073to("INTENT_EXTRA_GUILD_ID", Long.valueOf(guildId))));
            return widgetServerSettingsRoleMembers;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$configureUI$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95771 extends AbstractC12240o implements Function2<GuildMember, User, Unit> {
        public final /* synthetic */ ServerSettingsRoleMembersViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C95771(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            super(2);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember, User user) {
            invoke2(guildMember, user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final GuildMember guildMember, User user) {
            C12238m.checkNotNullParameter(guildMember, "guildMember");
            C12238m.checkNotNullParameter(user, "user");
            C0825e.Companion companion = C0825e.INSTANCE;
            FragmentManager childFragmentManager = WidgetServerSettingsRoleMembers.this.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetServerSettingsRoleMembers.this.getString(C5419R.string.role_remove_member_confirm_title);
            Context contextRequireContext = WidgetServerSettingsRoleMembers.this.requireContext();
            Object[] objArr = new Object[2];
            Object nick = guildMember.getNick();
            if (nick == null) {
                nick = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
            }
            objArr[0] = nick;
            objArr[1] = ((ServerSettingsRoleMembersViewModel.ViewState.Loaded) this.$viewState).getRole().getName();
            companion.m128a(childFragmentManager, new SimpleConfirmationDialogArgs(string, C1107b.m216h(contextRequireContext, C5419R.string.role_remove_member_confirm_body, objArr, null, 4).toString(), WidgetServerSettingsRoleMembers.this.getString(C5419R.string.remove), WidgetServerSettingsRoleMembers.this.getString(C5419R.string.cancel)), new View.OnClickListener() { // from class: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers.configureUI.1.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsRoleMembers.this.getViewModel().removeRoleFromMember(guildMember);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95781 extends AbstractC12240o implements Function1<String, Unit> {
        public C95781() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "searchQuery");
            WidgetServerSettingsRoleMembers.this.getViewModel().updateSearchQuery(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95791 extends AbstractC12240o implements Function1<ServerSettingsRoleMembersViewModel.ViewState, Unit> {
        public C95791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = WidgetServerSettingsRoleMembers.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsRoleMembers.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95802 extends AbstractC12240o implements Function1<ServerSettingsRoleMembersViewModel.Event, Unit> {
        public C95802() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsRoleMembersViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetServerSettingsRoleMembers.this.handleEvents(event);
        }
    }

    public WidgetServerSettingsRoleMembers() {
        super(C5419R.layout.widget_server_settings_role_members);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsRoleMembers$binding$2.INSTANCE, null, 2, null);
        this.guildRoleId = C12083g.lazy(new WidgetServerSettingsRoleMembers$guildRoleId$2(this));
        this.guildId = C12083g.lazy(new WidgetServerSettingsRoleMembers$guildId$2(this));
        WidgetServerSettingsRoleMembers$viewModel$2 widgetServerSettingsRoleMembers$viewModel$2 = new WidgetServerSettingsRoleMembers$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ServerSettingsRoleMembersViewModel.class), new C9576x93a19a7a(c0865g0), new C0869i0(widgetServerSettingsRoleMembers$viewModel$2));
    }

    private final void configureUI(ServerSettingsRoleMembersViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsRoleMembersViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17745b;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.roleMembersAppViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsRoleMembersViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper2 = getBinding().f17745b;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.roleMembersAppViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter = this.adapter;
            if (serverSettingsRoleMembersAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            serverSettingsRoleMembersAdapter.setRemoveMemberClickListener(new C95771(viewState));
            ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter2 = this.adapter;
            if (serverSettingsRoleMembersAdapter2 == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            serverSettingsRoleMembersAdapter2.setItems(((ServerSettingsRoleMembersViewModel.ViewState.Loaded) viewState).getMemberList());
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

    private final void handleEvents(ServerSettingsRoleMembersViewModel.Event event) {
        if (event instanceof ServerSettingsRoleMembersViewModel.Event.RemoveMemberFailure) {
            C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.adapter = new ServerSettingsRoleMembersAdapter(this, null, 2, 0 == true ? 1 : 0);
        RecyclerView recyclerView = getBinding().f17746c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRoleMembersList");
        ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter = this.adapter;
        if (serverSettingsRoleMembersAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(serverSettingsRoleMembersAdapter);
        getBinding().f17747d.m8553a(this, new C95781());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsRoleMembersViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsRoleMembers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95791());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsRoleMembers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95802());
    }
}
