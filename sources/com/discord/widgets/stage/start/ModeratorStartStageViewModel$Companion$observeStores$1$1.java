package com.discord.widgets.stage.start;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.o;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageViewModel$Companion$observeStores$1$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, List<? extends GuildScheduledEvent>, Long, ModeratorStartStageViewModel$StoreState> {
    public final /* synthetic */ ModeratorStartStageViewModel$Companion$observeStores$1 this$0;

    public ModeratorStartStageViewModel$Companion$observeStores$1$1(ModeratorStartStageViewModel$Companion$observeStores$1 moderatorStartStageViewModel$Companion$observeStores$1) {
        this.this$0 = moderatorStartStageViewModel$Companion$observeStores$1;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ ModeratorStartStageViewModel$StoreState call(Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map, List<? extends GuildScheduledEvent> list, Long l) {
        return call2((Map<Long, StoreVoiceParticipants$VoiceUser>) map, (List<GuildScheduledEvent>) list, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModeratorStartStageViewModel$StoreState call2(Map<Long, StoreVoiceParticipants$VoiceUser> map, List<GuildScheduledEvent> list, Long l) {
        ArrayList arrayListA0 = a.a0(list, "guildScheduledEvents");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long channelId = ((GuildScheduledEvent) next).getChannelId();
            if (channelId != null && channelId.longValue() == this.this$0.$channelId) {
                arrayListA0.add(next);
            }
        }
        List listSortedWith = u.sortedWith(arrayListA0, new ModeratorStartStageViewModel$Companion$observeStores$1$1$$special$$inlined$sortedBy$1());
        Collection<StoreVoiceParticipants$VoiceUser> collectionValues = map.values();
        ArrayList<StoreVoiceParticipants$VoiceUser> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((StoreVoiceParticipants$VoiceUser) obj).isMe()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser : arrayList) {
            arrayList2.add(new UserGuildMember(storeVoiceParticipants$VoiceUser.getUser(), storeVoiceParticipants$VoiceUser.getGuildMember()));
        }
        return new ModeratorStartStageViewModel$StoreState(listSortedWith, arrayList2, PermissionUtils.can(Permission.START_STAGE_EVENT, l));
    }
}
