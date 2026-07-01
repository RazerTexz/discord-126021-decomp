package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.w;
import d0.t.m;
import d0.t.o;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel extends d0<WidgetChannelSettingsAddMemberFragmentViewModel$ViewState> {
    public static final WidgetChannelSettingsAddMemberFragmentViewModel$Companion Companion = new WidgetChannelSettingsAddMemberFragmentViewModel$Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGatewayConnection gatewaySocket;
    private final StoreGuilds guildsStore;
    private String query;
    private final HashMap<Long, PermissionOverwrite$Type> selected;
    private final boolean showRolesWithGuildPermission;
    private WidgetChannelSettingsAddMemberFragmentViewModel$StoreState storeState;
    private final StoreUser userStore;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreUser users = (i & 16) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        this(j, z2, channels, guilds, users, (i & 32) != 0 ? StoreStream.Companion.getGatewaySocket() : storeGatewayConnection, (i & 64) != 0 ? WidgetChannelSettingsAddMemberFragmentViewModel$Companion.access$observeStoreState(Companion, j, channels, guilds, users) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModel, WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState) {
        widgetChannelSettingsAddMemberFragmentViewModel.handleStoreState(widgetChannelSettingsAddMemberFragmentViewModel$StoreState);
    }

    private final WidgetChannelSettingsAddMemberFragmentViewModel$ViewState generateViewState(WidgetChannelSettingsAddMemberFragmentViewModel$StoreState storeState) {
        return new WidgetChannelSettingsAddMemberFragmentViewModel$ViewState(storeState.getGuild(), storeState.getChannel(), this.query, makeAdapterItems(storeState), this.selected);
    }

    @MainThread
    private final void handleStoreState(WidgetChannelSettingsAddMemberFragmentViewModel$StoreState storeState) {
        this.storeState = storeState;
        updateViewState(generateViewState(storeState));
    }

    private final boolean isPermissionOverrideAlreadyPresent(PermissionOverwrite overwrite, long permission) {
        return overwrite != null && (overwrite.getAllow() & permission) == permission;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0090  */
    private final List<AddMemberAdapter$Item> makeAdapterItems(WidgetChannelSettingsAddMemberFragmentViewModel$StoreState storeState) {
        AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd;
        boolean z2;
        Guild guild = storeState.getGuild();
        Map<Long, PermissionOverwrite> channelPermissionOverwritesMap = storeState.getChannelPermissionOverwritesMap();
        String str = this.query;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String string = w.trim(str).toString();
        Collection<GuildRole> collectionValues = storeState.getRoles().values();
        ArrayList<GuildRole> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            GuildRole guildRole = (GuildRole) obj;
            if ((guildRole.getPermissions() & 8) == 0) {
                long id2 = guildRole.getId();
                if ((guild == null || id2 != guild.getId()) && ((this.showRolesWithGuildPermission || !PermissionUtils.INSTANCE.canRole(20971536L, guildRole, channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())))) && !isPermissionOverrideAlreadyPresent(channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())), 20971536L) && w.contains((CharSequence) guildRole.getName(), (CharSequence) string, true))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole2 : arrayList) {
            boolean zCanRole = PermissionUtils.INSTANCE.canRole(20971536L, guildRole2, channelPermissionOverwritesMap.get(Long.valueOf(guildRole2.getId())));
            PermissionOwner$Role permissionOwner$Role = new PermissionOwner$Role(guildRole2);
            boolean z3 = zCanRole || this.selected.containsKey(Long.valueOf(guildRole2.getId()));
            if (zCanRole) {
                addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd = new AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd(AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason.HAS_GUILD_PERMISSIONS);
            } else {
                if (zCanRole) {
                    throw new NoWhenBranchMatchedException();
                }
                addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd = AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CanAdd.INSTANCE;
            }
            arrayList2.add(new AddMemberAdapter$Item$PermissionOwnerItem(permissionOwner$Role, z3, addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd));
        }
        Set<Map$Entry<Long, GuildMember>> setEntrySet = storeState.getMembers().entrySet();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            User user = storeState.getUsers().get(map$Entry.getKey());
            Pair pair = user == null ? null : new Pair((GuildMember) map$Entry.getValue(), user);
            if (pair != null) {
                arrayList3.add(pair);
            }
        }
        ArrayList<Pair> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Pair pair2 = (Pair) obj2;
            GuildMember guildMember = (GuildMember) pair2.component1();
            User user2 = (User) pair2.component2();
            if (((guild != null ? guild.isOwner(user2.getId()) : false) || isPermissionOverrideAlreadyPresent((PermissionOverwrite) a.f(user2, channelPermissionOverwritesMap), 20971536L) || (!w.contains((CharSequence) user2.getUsername(), (CharSequence) string, true) && (guildMember.getNick() == null || !w.contains((CharSequence) guildMember.getNick(), (CharSequence) string, true)))) ? false : true) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList(o.collectionSizeOrDefault(arrayList4, 10));
        for (Pair pair3 : arrayList4) {
            GuildMember guildMember2 = (GuildMember) pair3.component1();
            User user3 = (User) pair3.component2();
            arrayList5.add(new AddMemberAdapter$Item$PermissionOwnerItem(new PermissionOwner$Member(user3, guildMember2.getNick(), guild != null && guild.isOwner(user3.getId())), this.selected.containsKey(Long.valueOf(user3.getId())), AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CanAdd.INSTANCE));
        }
        return u.plus((Collection) u.plus((Collection) u.plus((Collection) m.listOf(new AddMemberAdapter$Item$CategoryItem(AddMemberAdapter$Item$CategoryItem$Companion$CategoryType.ROLE)), (Iterable) arrayList2), (Iterable) m.listOf(new AddMemberAdapter$Item$CategoryItem(AddMemberAdapter$Item$CategoryItem$Companion$CategoryType.MEMBER))), (Iterable) arrayList5);
    }

    private final void requestMembers(String query) {
        Guild guild;
        WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState = this.storeState;
        if (widgetChannelSettingsAddMemberFragmentViewModel$StoreState == null || (guild = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.getGuild()) == null) {
            return;
        }
        long id2 = guild.getId();
        StoreGatewayConnection storeGatewayConnection = this.gatewaySocket;
        Objects.requireNonNull(query, "null cannot be cast to non-null type kotlin.CharSequence");
        storeGatewayConnection.requestGuildMembers(id2, w.trim(query).toString(), null, 20);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        d0.z.d.m.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void toggleItem(long id2, PermissionOverwrite$Type type) {
        d0.z.d.m.checkNotNullParameter(type, "type");
        if (this.selected.containsKey(Long.valueOf(id2))) {
            this.selected.remove(Long.valueOf(id2));
        } else {
            this.selected.put(Long.valueOf(id2), type);
        }
        WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState = this.storeState;
        if (widgetChannelSettingsAddMemberFragmentViewModel$StoreState != null) {
            updateViewState(generateViewState(widgetChannelSettingsAddMemberFragmentViewModel$StoreState));
        }
    }

    public final void updateQuery(String query) {
        d0.z.d.m.checkNotNullParameter(query, "query");
        this.query = query;
        WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState = this.storeState;
        if (widgetChannelSettingsAddMemberFragmentViewModel$StoreState != null) {
            updateViewState(generateViewState(widgetChannelSettingsAddMemberFragmentViewModel$StoreState));
        }
        requestMembers(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable<WidgetChannelSettingsAddMemberFragmentViewModel$StoreState> observable) {
        super(null, 1, null);
        d0.z.d.m.checkNotNullParameter(storeChannels, "channelsStore");
        d0.z.d.m.checkNotNullParameter(storeGuilds, "guildsStore");
        d0.z.d.m.checkNotNullParameter(storeUser, "userStore");
        d0.z.d.m.checkNotNullParameter(storeGatewayConnection, "gatewaySocket");
        d0.z.d.m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.showRolesWithGuildPermission = z2;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.userStore = storeUser;
        this.gatewaySocket = storeGatewayConnection;
        this.query = "";
        this.selected = new HashMap<>();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetChannelSettingsAddMemberFragmentViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsAddMemberFragmentViewModel$1(this), 62, (Object) null);
    }
}
