package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelSettingsEditPermissionsModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final long targetId;
    private final int type;
    private final boolean useNewThreadsPermissions;

    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<WidgetChannelSettingsEditPermissionsModel> getForRole(long guildId, long channelId, final long targetRoleId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableE = Observable.e(companion.getChannels().observeChannel(channelId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForChannel(channelId), companion.getGuilds().observeRoles(guildId), companion.getGuilds().observeComputed(guildId), NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(guildId), new Func7<Channel, MeUser, Guild, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Boolean, WidgetChannelSettingsEditPermissionsModel>() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1

                /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
                public static final class AnonymousClass1 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
                    public AnonymousClass1() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
                        return Boolean.valueOf(invoke2(permissionOverwrite));
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
                        return permissionOverwrite.getId() == targetRoleId;
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
                public static final class AnonymousClass2 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
                    public AnonymousClass2() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
                        return Boolean.valueOf(invoke2(permissionOverwrite));
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
                        return permissionOverwrite.getId() == targetRoleId;
                    }
                }

                @Override // rx.functions.Func7
                public /* bridge */ /* synthetic */ WidgetChannelSettingsEditPermissionsModel call(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Boolean bool) {
                    return call2(channel, meUser, guild, l, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, bool);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChannelSettingsEditPermissionsModel call2(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Boolean bool) {
                    GuildMember guildMember;
                    List<Long> roles;
                    GuildRole guildRole = map.get(Long.valueOf(targetRoleId));
                    if (channel != null && guild != null && guildRole != null && l != null) {
                        WidgetChannelSettingsEditPermissionsModel.Companion companion2 = WidgetChannelSettingsEditPermissionsModel.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                        if (companion2.isAbleToManagePerms(guild, meUser, l.longValue())) {
                            ArrayList arrayList = new ArrayList(channel.v() != null ? channel.v() : Collections2.emptyList());
                            long j = targetRoleId;
                            PermissionOverwrite.Type type = PermissionOverwrite.Type.ROLE;
                            PermissionOverwrite permissionOverwrite = new PermissionOverwrite(j, type, 0L, Permission.ALL);
                            MutableCollections.removeAll((List) arrayList, (Function1) new AnonymousClass1());
                            arrayList.add(permissionOverwrite);
                            PermissionOverwrite permissionOverwrite2 = new PermissionOverwrite(targetRoleId, type, 0L, 0L);
                            MutableCollections.removeAll((List) arrayList, (Function1) new AnonymousClass2());
                            arrayList.add(permissionOverwrite2);
                            boolean z2 = false;
                            boolean z3 = targetRoleId == guild.getId();
                            long jLongValue = l.longValue();
                            long j2 = targetRoleId;
                            long jComputeNonThreadPermissions = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                            long jComputeNonThreadPermissions2 = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                            if (z3 || ((guildMember = map2.get(Long.valueOf(meUser.getId()))) != null && (roles = guildMember.getRoles()) != null && roles.contains(Long.valueOf(targetRoleId)))) {
                                z2 = true;
                            }
                            Intrinsics3.checkNotNullExpressionValue(bool, "useNewThreadsPermissions");
                            return new WidgetChannelSettingsEditPermissionsModel.ModelForRole(channel, jLongValue, guildRole, j2, jComputeNonThreadPermissions, jComputeNonThreadPermissions2, z2, z3, bool.booleanValue());
                        }
                    }
                    return null;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n            .…          }\n            }");
            Observable<WidgetChannelSettingsEditPermissionsModel> observableR = ObservableExtensionsKt.computationLatest(observableE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
            return observableR;
        }

        private final Observable<WidgetChannelSettingsEditPermissionsModel> getForUser(long guildId, long channelId, long targetUserId, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            Observable<WidgetChannelSettingsEditPermissionsModel> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{storeChannels, storeUser, storeGuilds, storePermissions}, false, null, null, new WidgetChannelSettingsEditPermissionsModel3(storeChannels, channelId, storeUser, targetUserId, storeGuilds, guildId, storePermissions), 14, null)).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
            return observableR;
        }

        public static /* synthetic */ Observable getForUser$default(Companion companion, long j, long j2, long j3, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, int i, Object obj) {
            return companion.getForUser(j, j2, j3, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
        }

        private final boolean isAbleToManagePerms(Guild guild, MeUser meUser, long myPermissionsForChannel) {
            return ((guild.getOwnerId() > meUser.getId() ? 1 : (guild.getOwnerId() == meUser.getId() ? 0 : -1)) == 0) || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(myPermissionsForChannel), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(myPermissionsForChannel), meUser.getMfaEnabled(), guild.getMfaLevel());
        }

        public final Observable<WidgetChannelSettingsEditPermissionsModel> get(long guildId, long channelId, long targetId, int type) {
            if (type == 0) {
                return getForUser$default(this, guildId, channelId, targetId, null, null, null, null, 120, null);
            }
            if (type == 1) {
                return getForRole(guildId, channelId, targetId);
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n              .just(null)");
            return scalarSynchronousObservable;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    public static final /* data */ class ModelForRole extends WidgetChannelSettingsEditPermissionsModel {
        private final Channel channel;
        private final GuildRole guildRole;
        private final boolean isEveryoneRole;
        private final boolean meHasRole;
        private final long myPermissionsForChannel;
        private final long myPermissionsWithRoleDenied;
        private final long myPermissionsWithRoleNeutral;
        private final long targetId;
        private final boolean useNewThreadsPermissions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelForRole(Channel channel, long j, GuildRole guildRole, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4) {
            super(channel, j2, 1, z4, null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRole, "guildRole");
            this.channel = channel;
            this.myPermissionsForChannel = j;
            this.guildRole = guildRole;
            this.targetId = j2;
            this.myPermissionsWithRoleNeutral = j3;
            this.myPermissionsWithRoleDenied = j4;
            this.meHasRole = z2;
            this.isEveryoneRole = z3;
            this.useNewThreadsPermissions = z4;
        }

        public final boolean canDenyRolePermission(long permission) {
            return (this.myPermissionsWithRoleDenied & permission) == (permission & this.myPermissionsForChannel);
        }

        public final boolean canNeutralizeRolePermission(long permission) {
            return (this.myPermissionsWithRoleNeutral & permission) == (permission & this.myPermissionsForChannel);
        }

        public final Channel component1() {
            return getChannel();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRole getGuildRole() {
            return this.guildRole;
        }

        public final long component4() {
            return getTargetId();
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getMyPermissionsWithRoleNeutral() {
            return this.myPermissionsWithRoleNeutral;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getMyPermissionsWithRoleDenied() {
            return this.myPermissionsWithRoleDenied;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getMeHasRole() {
            return this.meHasRole;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsEveryoneRole() {
            return this.isEveryoneRole;
        }

        public final boolean component9() {
            return getUseNewThreadsPermissions();
        }

        public final ModelForRole copy(Channel channel, long myPermissionsForChannel, GuildRole guildRole, long targetId, long myPermissionsWithRoleNeutral, long myPermissionsWithRoleDenied, boolean meHasRole, boolean isEveryoneRole, boolean useNewThreadsPermissions) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRole, "guildRole");
            return new ModelForRole(channel, myPermissionsForChannel, guildRole, targetId, myPermissionsWithRoleNeutral, myPermissionsWithRoleDenied, meHasRole, isEveryoneRole, useNewThreadsPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelForRole)) {
                return false;
            }
            ModelForRole modelForRole = (ModelForRole) other;
            return Intrinsics3.areEqual(getChannel(), modelForRole.getChannel()) && this.myPermissionsForChannel == modelForRole.myPermissionsForChannel && Intrinsics3.areEqual(this.guildRole, modelForRole.guildRole) && getTargetId() == modelForRole.getTargetId() && this.myPermissionsWithRoleNeutral == modelForRole.myPermissionsWithRoleNeutral && this.myPermissionsWithRoleDenied == modelForRole.myPermissionsWithRoleDenied && this.meHasRole == modelForRole.meHasRole && this.isEveryoneRole == modelForRole.isEveryoneRole && getUseNewThreadsPermissions() == modelForRole.getUseNewThreadsPermissions();
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public Channel getChannel() {
            return this.channel;
        }

        public final GuildRole getGuildRole() {
            return this.guildRole;
        }

        public final boolean getMeHasRole() {
            return this.meHasRole;
        }

        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        public final long getMyPermissionsWithRoleDenied() {
            return this.myPermissionsWithRoleDenied;
        }

        public final long getMyPermissionsWithRoleNeutral() {
            return this.myPermissionsWithRoleNeutral;
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public long getTargetId() {
            return this.targetId;
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public boolean getUseNewThreadsPermissions() {
            return this.useNewThreadsPermissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            Channel channel = getChannel();
            int iA = (b.a(this.myPermissionsForChannel) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
            GuildRole guildRole = this.guildRole;
            int iA2 = (b.a(this.myPermissionsWithRoleDenied) + ((b.a(this.myPermissionsWithRoleNeutral) + ((b.a(getTargetId()) + ((iA + (guildRole != null ? guildRole.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
            boolean z2 = this.meHasRole;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iA2 + r1) * 31;
            boolean z3 = this.isEveryoneRole;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean useNewThreadsPermissions = getUseNewThreadsPermissions();
            return i2 + (useNewThreadsPermissions ? 1 : useNewThreadsPermissions);
        }

        public final boolean isEveryoneRole() {
            return this.isEveryoneRole;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelForRole(channel=");
            sbU.append(getChannel());
            sbU.append(", myPermissionsForChannel=");
            sbU.append(this.myPermissionsForChannel);
            sbU.append(", guildRole=");
            sbU.append(this.guildRole);
            sbU.append(", targetId=");
            sbU.append(getTargetId());
            sbU.append(", myPermissionsWithRoleNeutral=");
            sbU.append(this.myPermissionsWithRoleNeutral);
            sbU.append(", myPermissionsWithRoleDenied=");
            sbU.append(this.myPermissionsWithRoleDenied);
            sbU.append(", meHasRole=");
            sbU.append(this.meHasRole);
            sbU.append(", isEveryoneRole=");
            sbU.append(this.isEveryoneRole);
            sbU.append(", useNewThreadsPermissions=");
            sbU.append(getUseNewThreadsPermissions());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    public static final /* data */ class ModelForUser extends WidgetChannelSettingsEditPermissionsModel {
        private final Channel channel;
        private final GuildMember guildMember;
        private final boolean isMe;
        private final long myPermissionsForChannel;
        private final boolean useNewThreadsPermissions;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelForUser(Channel channel, long j, boolean z2, User user, GuildMember guildMember, boolean z3) {
            super(channel, user.getId(), 0, z3, null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(user, "user");
            this.channel = channel;
            this.myPermissionsForChannel = j;
            this.isMe = z2;
            this.user = user;
            this.guildMember = guildMember;
            this.useNewThreadsPermissions = z3;
        }

        public static /* synthetic */ ModelForUser copy$default(ModelForUser modelForUser, Channel channel, long j, boolean z2, User user, GuildMember guildMember, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = modelForUser.getChannel();
            }
            if ((i & 2) != 0) {
                j = modelForUser.myPermissionsForChannel;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                z2 = modelForUser.isMe;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                user = modelForUser.user;
            }
            User user2 = user;
            if ((i & 16) != 0) {
                guildMember = modelForUser.guildMember;
            }
            GuildMember guildMember2 = guildMember;
            if ((i & 32) != 0) {
                z3 = modelForUser.getUseNewThreadsPermissions();
            }
            return modelForUser.copy(channel, j2, z4, user2, guildMember2, z3);
        }

        public final Channel component1() {
            return getChannel();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final boolean component6() {
            return getUseNewThreadsPermissions();
        }

        public final ModelForUser copy(Channel channel, long myPermissionsForChannel, boolean isMe, User user, GuildMember guildMember, boolean useNewThreadsPermissions) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(user, "user");
            return new ModelForUser(channel, myPermissionsForChannel, isMe, user, guildMember, useNewThreadsPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelForUser)) {
                return false;
            }
            ModelForUser modelForUser = (ModelForUser) other;
            return Intrinsics3.areEqual(getChannel(), modelForUser.getChannel()) && this.myPermissionsForChannel == modelForUser.myPermissionsForChannel && this.isMe == modelForUser.isMe && Intrinsics3.areEqual(this.user, modelForUser.user) && Intrinsics3.areEqual(this.guildMember, modelForUser.guildMember) && getUseNewThreadsPermissions() == modelForUser.getUseNewThreadsPermissions();
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public Channel getChannel() {
            return this.channel;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public boolean getUseNewThreadsPermissions() {
            return this.useNewThreadsPermissions;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            Channel channel = getChannel();
            int iA = (b.a(this.myPermissionsForChannel) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
            boolean z2 = this.isMe;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iA + r0) * 31;
            User user = this.user;
            int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
            GuildMember guildMember = this.guildMember;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            boolean useNewThreadsPermissions = getUseNewThreadsPermissions();
            return iHashCode2 + (useNewThreadsPermissions ? 1 : useNewThreadsPermissions);
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelForUser(channel=");
            sbU.append(getChannel());
            sbU.append(", myPermissionsForChannel=");
            sbU.append(this.myPermissionsForChannel);
            sbU.append(", isMe=");
            sbU.append(this.isMe);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(", useNewThreadsPermissions=");
            sbU.append(getUseNewThreadsPermissions());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private WidgetChannelSettingsEditPermissionsModel(Channel channel, long j, int i, boolean z2) {
        this.channel = channel;
        this.targetId = j;
        this.type = i;
        this.useNewThreadsPermissions = z2;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public long getTargetId() {
        return this.targetId;
    }

    public final int getType() {
        return this.type;
    }

    public boolean getUseNewThreadsPermissions() {
        return this.useNewThreadsPermissions;
    }

    public /* synthetic */ WidgetChannelSettingsEditPermissionsModel(Channel channel, long j, int i, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, j, i, z2);
    }
}
