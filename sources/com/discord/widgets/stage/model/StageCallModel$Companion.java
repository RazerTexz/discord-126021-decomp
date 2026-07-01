package com.discord.widgets.stage.model;

import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$AudienceItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$MediaType;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$SpeakerItem;
import d0.d0.f;
import d0.f0.q;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel$Companion {
    private StageCallModel$Companion() {
    }

    private final StageCallModel create(Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Guild guild, Map<Long, StoreVoiceParticipants$VoiceUser> participants, Set<Long> blockedUsers, StageInstance stageInstance, boolean isLurking, StoreStageChannels stagesStore) {
        int i;
        int i2;
        VoiceState voiceState;
        int i3;
        boolean z2;
        String string;
        Collection<StoreVoiceParticipants$VoiceUser> collectionValues = participants.values();
        ArrayList<StoreVoiceParticipants$VoiceUser> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((StoreVoiceParticipants$VoiceUser) obj).isConnected()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(Long.valueOf(((StoreVoiceParticipants$VoiceUser) obj2).getUser().getId()), obj2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
            Object key = map$Entry.getKey();
            StageRoles stageRolesM17getUserRolesuOBN1zc = stagesStore.m17getUserRolesuOBN1zc(((Number) map$Entry.getKey()).longValue(), channel.getId());
            linkedHashMap2.put(key, StageRoles.m25boximpl(stageRolesM17getUserRolesuOBN1zc != null ? stageRolesM17getUserRolesuOBN1zc.m35unboximpl() : StageRoles.Companion.m37getAUDIENCE1LxfuJo()));
        }
        Collection collectionValues2 = linkedHashMap2.values();
        if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
            i = 0;
        } else {
            Iterator it = collectionValues2.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                if (StageRoles.m33isSpeakerimpl(((StageRoles) it.next()).m35unboximpl()) && (i4 = i4 + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
            i = i4;
        }
        if (arrayList.isEmpty()) {
            i2 = 0;
        } else {
            int i5 = 0;
            for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser : arrayList) {
                StageRoles stageRolesM17getUserRolesuOBN1zc2 = stagesStore.m17getUserRolesuOBN1zc(storeVoiceParticipants$VoiceUser.getUser().getId(), channel.getId());
                if ((StageRoles.m33isSpeakerimpl(stageRolesM17getUserRolesuOBN1zc2 != null ? stageRolesM17getUserRolesuOBN1zc2.m35unboximpl() : StageRoles.Companion.m37getAUDIENCE1LxfuJo()) && ((voiceState = storeVoiceParticipants$VoiceUser.getVoiceState()) == null || !voiceState.getSelfVideo())) && (i5 = i5 + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
            i2 = i5;
        }
        int iCoerceAtMost = f.coerceAtMost(i2, 3);
        int i6 = 0;
        int i7 = 0;
        for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2 : arrayList) {
            VoiceState voiceState2 = storeVoiceParticipants$VoiceUser2.getVoiceState();
            if (voiceState2 != null) {
                m.checkNotNullParameter(voiceState2, "$this$hasUnackedRequestToSpeak");
                if (d.y0(voiceState2) == StageRequestToSpeakState.REQUESTED_TO_SPEAK) {
                    i6++;
                }
            }
            int i8 = i6;
            boolean zContains = blockedUsers.contains(Long.valueOf(storeVoiceParticipants$VoiceUser2.getUser().getId()));
            if (zContains) {
                i7++;
            }
            int i9 = i7;
            StageRoles stageRoles = (StageRoles) linkedHashMap2.get(Long.valueOf(storeVoiceParticipants$VoiceUser2.getUser().getId()));
            if (stageRoles == null || !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
                arrayList4.add(new StageCallItem$AudienceItem(storeVoiceParticipants$VoiceUser2, channel, RoleUtils.getHighestHoistedRole(guildRoles, guildMembers.get(Long.valueOf(storeVoiceParticipants$VoiceUser2.getUser().getId()))), zContains));
            } else {
                if (storeVoiceParticipants$VoiceUser2.getStreamContext() != null) {
                    StageCallItem$MediaType stageCallItem$MediaType = StageCallItem$MediaType.STREAM;
                    StringBuilder sbU = a.U("STREAM-");
                    sbU.append(storeVoiceParticipants$VoiceUser2.getUser().getId());
                    arrayList2.add(new StageMediaParticipant(sbU.toString(), storeVoiceParticipants$VoiceUser2, channel, false, zContains, stageCallItem$MediaType));
                }
                VoiceState voiceState3 = storeVoiceParticipants$VoiceUser2.getVoiceState();
                if (voiceState3 != null && voiceState3.getSelfVideo()) {
                    StageRoles stageRoles2 = (StageRoles) linkedHashMap2.get(Long.valueOf(storeVoiceParticipants$VoiceUser2.getUser().getId()));
                    boolean z3 = stageRoles2 != null && StageRoles.m32isModeratorimpl(stageRoles2.m35unboximpl());
                    StageCallItem$MediaType stageCallItem$MediaType2 = StageCallItem$MediaType.USER;
                    StringBuilder sbU2 = a.U("USER-");
                    sbU2.append(storeVoiceParticipants$VoiceUser2.getUser().getId());
                    arrayList2.add(new StageMediaParticipant(sbU2.toString(), storeVoiceParticipants$VoiceUser2, channel, z3, zContains, stageCallItem$MediaType2));
                } else {
                    StageRoles stageRoles3 = (StageRoles) linkedHashMap2.get(Long.valueOf(storeVoiceParticipants$VoiceUser2.getUser().getId()));
                    if (stageRoles3 == null || !StageRoles.m32isModeratorimpl(stageRoles3.m35unboximpl())) {
                        i3 = 3;
                        z2 = false;
                    } else {
                        i3 = 3;
                        z2 = true;
                    }
                    if (i > i3) {
                        string = String.valueOf(arrayList3.size() % i3);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(arrayList3.size() % i3);
                        sb.append('-');
                        sb.append(i);
                        string = sb.toString();
                    }
                    arrayList3.add(new StageCallItem$SpeakerItem(storeVoiceParticipants$VoiceUser2, channel, z2, string, iCoerceAtMost, zContains));
                }
            }
            i6 = i8;
            i7 = i9;
        }
        StageRoles stageRolesM15getMyRolesvisDeB4 = stagesStore.m15getMyRolesvisDeB4(channel.getId());
        return new StageCallModel(stageRolesM15getMyRolesvisDeB4 != null ? stageRolesM15getMyRolesvisDeB4.m35unboximpl() : StageRoles.Companion.m37getAUDIENCE1LxfuJo(), arrayList3, arrayList2, u.sorted(arrayList4), q.toList(q.map(q.filter(u.asSequence(arrayList3), StageCallModel$Companion$create$2.INSTANCE), StageCallModel$Companion$create$3.INSTANCE)), i6, stageInstance, i7, guild, isLurking, i, null);
    }

    public static /* synthetic */ StageCallModel create$default(StageCallModel$Companion stageCallModel$Companion, Channel channel, Map map, Map map2, Guild guild, Map map3, Set set, StageInstance stageInstance, boolean z2, StoreStageChannels storeStageChannels, int i, Object obj) {
        return stageCallModel$Companion.create(channel, map, map2, guild, map3, set, stageInstance, z2, (i & 256) != 0 ? StoreStream.Companion.getStageChannels() : storeStageChannels);
    }

    public final Observable<StageCallModel> observeStageCallModel(long channelId) {
        Observable observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new StageCallModel$Companion$observeStageCallModel$1(channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
        return observableY;
    }

    public /* synthetic */ StageCallModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
