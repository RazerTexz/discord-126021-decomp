package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0.f;
import d0.f0.q;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.p.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel extends d0<WidgetStageChannelModeratorPermissionsViewModel$ViewState> {
    public static final WidgetStageChannelModeratorPermissionsViewModel$Companion Companion = new WidgetStageChannelModeratorPermissionsViewModel$Companion(null);

    public WidgetStageChannelModeratorPermissionsViewModel(long j) {
        super(null, 1, null);
        Observable observableR = WidgetStageChannelModeratorPermissionsViewModel$Companion.observeStores$default(Companion, j, null, null, null, null, 30, null).X(a.a()).r();
        m.checkNotNullExpressionValue(observableR, "observeStores(channelId)…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetStageChannelModeratorPermissionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageChannelModeratorPermissionsViewModel$1(this), 62, (Object) null);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel, WidgetStageChannelModeratorPermissionsViewModel$StoreState widgetStageChannelModeratorPermissionsViewModel$StoreState) {
        widgetStageChannelModeratorPermissionsViewModel.handleStoreState(widgetStageChannelModeratorPermissionsViewModel$StoreState);
    }

    private final PermissionOwnerListView$RemoveStatus getMemberRemoveStatus(WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid storeState, boolean isOwner) {
        if (storeState.getCanEditModerators()) {
            return isOwner ? new PermissionOwnerListView$RemoveStatus$CannotRemove(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason.IS_GUILD_OWNER) : PermissionOwnerListView$RemoveStatus$CanRemove.INSTANCE;
        }
        return new PermissionOwnerListView$RemoveStatus$CannotRemove(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason.HAS_NO_PERMISSION);
    }

    private final PermissionOwnerListView$RemoveStatus getRoleRemoveStatus(WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid storeState, GuildRole role) {
        if (!storeState.getCanEditModerators()) {
            return new PermissionOwnerListView$RemoveStatus$CannotRemove(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason.HAS_NO_PERMISSION);
        }
        if (PermissionUtils.INSTANCE.canRole(20971536L, role, null)) {
            return new PermissionOwnerListView$RemoveStatus$CannotRemove(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason.IS_NOT_OVERRIDE);
        }
        return (role.getPermissions() & 8) == 8 ? new PermissionOwnerListView$RemoveStatus$CannotRemove(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason.IS_ADMINISTRATOR) : PermissionOwnerListView$RemoveStatus$CanRemove.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0187  */
    @MainThread
    private final void handleStoreState(WidgetStageChannelModeratorPermissionsViewModel$StoreState storeState) {
        List listEmptyList;
        if (!(storeState instanceof WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid)) {
            updateViewState(WidgetStageChannelModeratorPermissionsViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid = (WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid) storeState;
        List<PermissionOverwrite> channelPermissionOverwrites = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getChannelPermissionOverwrites();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = channelPermissionOverwrites.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).getType() == PermissionOverwrite$Type.ROLE) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((PermissionOverwrite) obj).e()), obj);
        }
        Collection<GuildRole> collectionValues = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getGuildRoles().values();
        ArrayList<GuildRole> arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues) {
            GuildRole guildRole = (GuildRole) obj2;
            if ((guildRole.getPermissions() & 8) == 8 || PermissionUtils.INSTANCE.canRole(20971536L, guildRole, (PermissionOverwrite) linkedHashMap.get(Long.valueOf(guildRole.getId())))) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(arrayList2, 10));
        for (GuildRole guildRole2 : arrayList2) {
            arrayList3.add(new PermissionOwnerListView$Item(new PermissionOwner$Role(guildRole2), getRoleRemoveStatus(widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid, guildRole2)));
        }
        Set set = q.toSet(q.map(q.filter(q.filter(q.filter(u.asSequence(widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getChannelPermissionOverwrites()), WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$1.INSTANCE), WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2.INSTANCE), new WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$3(storeState)), WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4.INSTANCE));
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = set.iterator();
        while (true) {
            PermissionOwnerListView$Item permissionOwnerListView$Item = null;
            if (!it2.hasNext()) {
                break;
            }
            long jLongValue = ((Number) it2.next()).longValue();
            User user = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getUsersWithOverwrites().get(Long.valueOf(jLongValue));
            if (user != null) {
                GuildMember guildMember = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getGuildMembers().get(Long.valueOf(jLongValue));
                permissionOwnerListView$Item = new PermissionOwnerListView$Item(new PermissionOwner$Member(user, guildMember != null ? guildMember.getNick() : null, false), getMemberRemoveStatus(widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid, false));
            }
            if (permissionOwnerListView$Item != null) {
                arrayList4.add(permissionOwnerListView$Item);
            }
        }
        User guildOwnerUser = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getGuildOwnerUser();
        if (guildOwnerUser == null) {
            listEmptyList = n.emptyList();
        } else {
            GuildMember guildMember2 = (GuildMember) b.d.b.a.a.f(guildOwnerUser, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getGuildMembers());
            listEmptyList = d0.t.m.listOf(new PermissionOwnerListView$Item(new PermissionOwner$Member(guildOwnerUser, guildMember2 != null ? guildMember2.getNick() : null, true), getMemberRemoveStatus(widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid, true)));
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
        }
        updateViewState(new WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid(arrayList3, u.plus((Collection) arrayList4, (Iterable) listEmptyList), widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.getCanEditModerators()));
    }
}
