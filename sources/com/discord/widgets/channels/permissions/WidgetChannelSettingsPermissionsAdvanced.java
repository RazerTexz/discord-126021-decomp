package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.SimpleRolesAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsPermissionsAdvanced.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0)};
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
                List<PermissionOverwrite> listV = channel.v();
                if (listV == null) {
                    return Collections2.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : listV) {
                    if (((PermissionOverwrite) obj).getType() == type) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((PermissionOverwrite) it.next()).e()));
                }
                return arrayList2;
            }

            public final Observable<Model> get(long channelId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreChannels channels = companion.getChannels();
                StoreUser users = companion.getUsers();
                StorePermissions permissions = companion.getPermissions();
                StoreGuilds guilds = companion.getGuilds();
                return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, users, permissions, guilds}, false, null, null, new WidgetChannelSettingsPermissionsAdvanced2(channels, channelId, guilds, users, permissions), 14, null);
            }

            public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
                return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map, List<SimpleMembersAdapter.MemberItem> list) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "guildRoles");
            Intrinsics3.checkNotNullParameter(list, "memberItems");
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
            return _Collections.sorted(arrayList);
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
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
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
            return Intrinsics3.areEqual(this.me, model.me) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.myPermissions == model.myPermissions && Intrinsics3.areEqual(this.guildRoles, model.guildRoles) && Intrinsics3.areEqual(this.memberItems, model.memberItems);
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
            int iA = (b.a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            int iHashCode3 = (iA + (map != null ? map.hashCode() : 0)) * 31;
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            return iHashCode3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(me=");
            sbU.append(this.me);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", myPermissions=");
            sbU.append(this.myPermissions);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", memberItems=");
            return outline.L(sbU, this.memberItems, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureMembers$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<User, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetChannelSettingsEditPermissions.INSTANCE.createForUser(WidgetChannelSettingsPermissionsAdvanced.this.requireContext(), this.$model.getGuild().getId(), this.$model.getChannel().getId(), user.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureRoles$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
            invoke2(guildRole);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) {
            WidgetChannelSettingsEditPermissions.Companion companion = WidgetChannelSettingsEditPermissions.INSTANCE;
            Context contextRequireContext = WidgetChannelSettingsPermissionsAdvanced.this.requireContext();
            long id2 = this.$model.getGuild().getId();
            long id3 = this.$model.getChannel().getId();
            Intrinsics3.checkNotNull(guildRole);
            companion.createForRole(contextRequireContext, id2, id3, guildRole.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelSettingsPermissionsAdvanced.this.configureUI(model);
        }
    }

    public WidgetChannelSettingsPermissionsAdvanced() {
        super(R.layout.widget_channel_settings_permissions_advanced);
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsPermissionsAdvanced5.INSTANCE, null, 2, null);
    }

    private final void configureMembers(Model model) {
        if (model.getMemberItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().d;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "viewBinding.membersContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleMembersAdapter simpleMembersAdapter = this.membersAdapter;
        if (simpleMembersAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("membersAdapter");
        }
        simpleMembersAdapter.setData(model.getMemberItems(), new AnonymousClass1(model));
        LinearLayout linearLayout2 = getViewBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "viewBinding.membersContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureRoles(Model model) {
        if (model.getRoleItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().f;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "viewBinding.rolesContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleRolesAdapter simpleRolesAdapter = this.rolesAdapter;
        if (simpleRolesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rolesAdapter");
        }
        simpleRolesAdapter.setData(model.getRoleItems(), new AnonymousClass1(model));
        LinearLayout linearLayout2 = getViewBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "viewBinding.rolesContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureUI(final Model model) {
        if (model == null || !model.getCanManage()) {
            return;
        }
        getViewBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getCanAddRole()) {
                    WidgetChannelSettingsPermissionsAddRole.create(WidgetChannelSettingsPermissionsAdvanced.this.getContext(), model.getChannel().getId());
                } else {
                    AppToast.i(WidgetChannelSettingsPermissionsAdvanced.this, R.string.overwrite_no_role_to_add, 0, 4);
                }
            }
        });
        getViewBinding().f2278b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced.configureUI.2
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getViewBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "viewBinding.rolesRecycler");
        this.rolesAdapter = (SimpleRolesAdapter) companion.configure(new SimpleRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getViewBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "viewBinding.rolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getViewBinding().g.setHasFixedSize(false);
        RecyclerView recyclerView3 = getViewBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "viewBinding.membersRecycler");
        this.membersAdapter = (SimpleMembersAdapter) companion.configure(new SimpleMembersAdapter(recyclerView3));
        RecyclerView recyclerView4 = getViewBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "viewBinding.membersRecycler");
        recyclerView4.setNestedScrollingEnabled(false);
        getViewBinding().e.setHasFixedSize(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).p(1L, TimeUnit.SECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Model[channelId]\n       …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetChannelSettingsPermissionsAdvanced.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
