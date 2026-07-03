package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsPermissionsAdvancedBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.SimpleRolesAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelSettingsPermissionsAdvanced.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0)};
    private SimpleMembersAdapter membersAdapter;
    private SimpleRolesAdapter rolesAdapter;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canAddRole;
        private final boolean canManage;
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser me;
        private final List<SimpleMembersAdapter.MemberItem> memberItems;
        private final long myPermissions;
        private final List<SimpleRolesAdapter.RoleItem> roleItems;

        /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Collection<Long> getOverwriteIds(Channel channel, PermissionOverwrite.Type type) {
                List<PermissionOverwrite> listM7655v = channel.m7655v();
                if (listM7655v == null) {
                    return C12147n.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : listM7655v) {
                    if (((PermissionOverwrite) obj).getType() == type) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((PermissionOverwrite) it.next()).m8131e()));
                }
                return arrayList2;
            }

            public final Observable<Model> get(long channelId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreChannels channels = companion.getChannels();
                StoreUser users = companion.getUsers();
                StorePermissions permissions = companion.getPermissions();
                StoreGuilds guilds = companion.getGuilds();
                return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{channels, users, permissions, guilds}, false, null, null, new WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1(channels, channelId, guilds, users, permissions), 14, null);
            }

            public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
                return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map, List<SimpleMembersAdapter.MemberItem> list) {
            C12238m.checkNotNullParameter(meUser, "me");
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(map, "guildRoles");
            C12238m.checkNotNullParameter(list, "memberItems");
            this.me = meUser;
            this.guild = guild;
            this.channel = channel;
            this.myPermissions = j;
            this.guildRoles = map;
            this.memberItems = list;
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
            List<SimpleRolesAdapter.RoleItem> listBuildRoleItems = buildRoleItems();
            this.roleItems = listBuildRoleItems;
            this.canAddRole = map.size() > listBuildRoleItems.size();
        }

        private final List<SimpleRolesAdapter.RoleItem> buildRoleItems() {
            ArrayList arrayList = new ArrayList();
            Iterator it = INSTANCE.getOverwriteIds(this.channel, PermissionOverwrite.Type.ROLE).iterator();
            while (it.hasNext()) {
                GuildRole guildRole = this.guildRoles.get(Long.valueOf(((Number) it.next()).longValue()));
                if (guildRole != null) {
                    arrayList.add(new SimpleRolesAdapter.RoleItem(guildRole));
                }
            }
            return C12163u.sorted(arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, Guild guild, Channel channel, long j, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.me;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                channel = model.channel;
            }
            Channel channel2 = channel;
            if ((i & 8) != 0) {
                j = model.myPermissions;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                map = model.guildRoles;
            }
            Map map2 = map;
            if ((i & 32) != 0) {
                list = model.memberItems;
            }
            return model.copy(meUser, guild2, channel2, j2, map2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public final Map<Long, GuildRole> component5() {
            return this.guildRoles;
        }

        public final List<SimpleMembersAdapter.MemberItem> component6() {
            return this.memberItems;
        }

        public final Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles, List<SimpleMembersAdapter.MemberItem> memberItems) {
            C12238m.checkNotNullParameter(me2, "me");
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(guildRoles, "guildRoles");
            C12238m.checkNotNullParameter(memberItems, "memberItems");
            return new Model(me2, guild, channel, myPermissions, guildRoles, memberItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.me, model.me) && C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.channel, model.channel) && this.myPermissions == model.myPermissions && C12238m.areEqual(this.guildRoles, model.guildRoles) && C12238m.areEqual(this.memberItems, model.memberItems);
        }

        public final boolean getCanAddRole() {
            return this.canAddRole;
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final List<SimpleMembersAdapter.MemberItem> getMemberItems() {
            return this.memberItems;
        }

        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public final List<SimpleRolesAdapter.RoleItem> getRoleItems() {
            return this.roleItems;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iM3a = (C0002b.m3a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            int iHashCode3 = (iM3a + (map != null ? map.hashCode() : 0)) * 31;
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            return iHashCode3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(me=");
            sbM833U.append(this.me);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", myPermissions=");
            sbM833U.append(this.myPermissions);
            sbM833U.append(", guildRoles=");
            sbM833U.append(this.guildRoles);
            sbM833U.append(", memberItems=");
            return C1643a.m824L(sbM833U, this.memberItems, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureMembers$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final class C75461 extends AbstractC12240o implements Function1<User, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C75461(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            C12238m.checkNotNullParameter(user, "user");
            WidgetChannelSettingsEditPermissions.INSTANCE.createForUser(WidgetChannelSettingsPermissionsAdvanced.this.requireContext(), this.$model.getGuild().getId(), this.$model.getChannel().getId(), user.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureRoles$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final class C75471 extends AbstractC12240o implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C75471(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
            invoke2(guildRole);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) {
            WidgetChannelSettingsEditPermissions.Companion companion = WidgetChannelSettingsEditPermissions.INSTANCE;
            Context contextRequireContext = WidgetChannelSettingsPermissionsAdvanced.this.requireContext();
            long id2 = this.$model.getGuild().getId();
            long id3 = this.$model.getChannel().getId();
            C12238m.checkNotNull(guildRole);
            companion.createForRole(contextRequireContext, id2, id3, guildRole.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final class C75501 extends AbstractC12240o implements Function1<Model, Unit> {
        public C75501() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelSettingsPermissionsAdvanced.this.configureUI(model);
        }
    }

    public WidgetChannelSettingsPermissionsAdvanced() {
        super(C5419R.layout.widget_channel_settings_permissions_advanced);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsPermissionsAdvanced$viewBinding$2.INSTANCE, null, 2, null);
    }

    private final void configureMembers(Model model) {
        if (model.getMemberItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().f15951d;
            C12238m.checkNotNullExpressionValue(linearLayout, "viewBinding.membersContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleMembersAdapter simpleMembersAdapter = this.membersAdapter;
        if (simpleMembersAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("membersAdapter");
        }
        simpleMembersAdapter.setData(model.getMemberItems(), new C75461(model));
        LinearLayout linearLayout2 = getViewBinding().f15951d;
        C12238m.checkNotNullExpressionValue(linearLayout2, "viewBinding.membersContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureRoles(Model model) {
        if (model.getRoleItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().f15953f;
            C12238m.checkNotNullExpressionValue(linearLayout, "viewBinding.rolesContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleRolesAdapter simpleRolesAdapter = this.rolesAdapter;
        if (simpleRolesAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("rolesAdapter");
        }
        simpleRolesAdapter.setData(model.getRoleItems(), new C75471(model));
        LinearLayout linearLayout2 = getViewBinding().f15953f;
        C12238m.checkNotNullExpressionValue(linearLayout2, "viewBinding.rolesContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureUI(final Model model) {
        if (model == null || !model.getCanManage()) {
            return;
        }
        getViewBinding().f15950c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getCanAddRole()) {
                    WidgetChannelSettingsPermissionsAddRole.create(WidgetChannelSettingsPermissionsAdvanced.this.getContext(), model.getChannel().getId());
                } else {
                    C0876m.m171i(WidgetChannelSettingsPermissionsAdvanced.this, C5419R.string.overwrite_no_role_to_add, 0, 4);
                }
            }
        });
        getViewBinding().f15949b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSettingsPermissionsAddMember.create(WidgetChannelSettingsPermissionsAdvanced.this.getContext(), model.getGuild().getId(), model.getChannel().getId());
            }
        });
        configureRoles(model);
        configureMembers(model);
    }

    private final WidgetChannelSettingsPermissionsAdvancedBinding getViewBinding() {
        return (WidgetChannelSettingsPermissionsAdvancedBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getViewBinding().f15954g;
        C12238m.checkNotNullExpressionValue(recyclerView, "viewBinding.rolesRecycler");
        this.rolesAdapter = (SimpleRolesAdapter) companion.configure(new SimpleRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getViewBinding().f15954g;
        C12238m.checkNotNullExpressionValue(recyclerView2, "viewBinding.rolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getViewBinding().f15954g.setHasFixedSize(false);
        RecyclerView recyclerView3 = getViewBinding().f15952e;
        C12238m.checkNotNullExpressionValue(recyclerView3, "viewBinding.membersRecycler");
        this.membersAdapter = (SimpleMembersAdapter) companion.configure(new SimpleMembersAdapter(recyclerView3));
        RecyclerView recyclerView4 = getViewBinding().f15952e;
        C12238m.checkNotNullExpressionValue(recyclerView4, "viewBinding.membersRecycler");
        recyclerView4.setNestedScrollingEnabled(false);
        getViewBinding().f15952e.setHasFixedSize(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableM11112r = Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).m11110p(1L, TimeUnit.SECONDS).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Model[channelId]\n       …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetChannelSettingsPermissionsAdvanced.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75501());
    }
}
