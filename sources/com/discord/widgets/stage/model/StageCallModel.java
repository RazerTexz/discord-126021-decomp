package com.discord.widgets.stage.model;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func7;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageCallModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<StageCallItem.AudienceItem> audience;
    private final Guild guild;
    private final boolean isLurking;
    private final List<StageMediaParticipant> mediaParticipants;
    private final int myStageRoles;
    private final int numBlockedUsers;
    private final int numSpeakers;
    private final int requestingToSpeakCount;
    private final List<StageCallItem.SpeakerItem> speakerItems;
    private final List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers;
    private final StageInstance stageInstance;

    /* JADX INFO: compiled from: StageCallModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final StageCallModel create(Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> participants, Set<Long> blockedUsers, StageInstance stageInstance, boolean isLurking, StoreStageChannels stagesStore) {
            int i;
            int i2;
            VoiceState voiceState;
            int i3;
            boolean z2;
            String string;
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = participants.values();
            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (((StoreVoiceParticipants.VoiceUser) obj).isConnected()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(Long.valueOf(((StoreVoiceParticipants.VoiceUser) obj2).getUser().getId()), obj2);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Object key = entry.getKey();
                StageRoles stageRolesM11394getUserRolesuOBN1zc = stagesStore.m11394getUserRolesuOBN1zc(((Number) entry.getKey()).longValue(), channel.getId());
                linkedHashMap2.put(key, StageRoles.m11402boximpl(stageRolesM11394getUserRolesuOBN1zc != null ? stageRolesM11394getUserRolesuOBN1zc.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo()));
            }
            Collection collectionValues2 = linkedHashMap2.values();
            if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = collectionValues2.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    if (StageRoles.m11410isSpeakerimpl(((StageRoles) it.next()).m11412unboximpl()) && (i4 = i4 + 1) < 0) {
                        C12147n.throwCountOverflow();
                    }
                }
                i = i4;
            }
            if (arrayList.isEmpty()) {
                i2 = 0;
            } else {
                int i5 = 0;
                for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                    StageRoles stageRolesM11394getUserRolesuOBN1zc2 = stagesStore.m11394getUserRolesuOBN1zc(voiceUser.getUser().getId(), channel.getId());
                    if ((StageRoles.m11410isSpeakerimpl(stageRolesM11394getUserRolesuOBN1zc2 != null ? stageRolesM11394getUserRolesuOBN1zc2.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo()) && ((voiceState = voiceUser.getVoiceState()) == null || !voiceState.getSelfVideo())) && (i5 = i5 + 1) < 0) {
                        C12147n.throwCountOverflow();
                    }
                }
                i2 = i5;
            }
            int iCoerceAtMost = C11226f.coerceAtMost(i2, 3);
            int i6 = 0;
            int i7 = 0;
            for (StoreVoiceParticipants.VoiceUser voiceUser2 : arrayList) {
                VoiceState voiceState2 = voiceUser2.getVoiceState();
                if (voiceState2 != null) {
                    C12238m.checkNotNullParameter(voiceState2, "$this$hasUnackedRequestToSpeak");
                    if (C1460d.m592y0(voiceState2) == StageRequestToSpeakState.REQUESTED_TO_SPEAK) {
                        i6++;
                    }
                }
                int i8 = i6;
                boolean zContains = blockedUsers.contains(Long.valueOf(voiceUser2.getUser().getId()));
                if (zContains) {
                    i7++;
                }
                int i9 = i7;
                StageRoles stageRoles = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                if (stageRoles == null || !StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) {
                    arrayList4.add(new StageCallItem.AudienceItem(voiceUser2, channel, RoleUtils.getHighestHoistedRole(guildRoles, guildMembers.get(Long.valueOf(voiceUser2.getUser().getId()))), zContains));
                } else {
                    if (voiceUser2.getStreamContext() != null) {
                        StageCallItem.MediaType mediaType = StageCallItem.MediaType.STREAM;
                        StringBuilder sbM833U = C1643a.m833U("STREAM-");
                        sbM833U.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageMediaParticipant(sbM833U.toString(), voiceUser2, channel, false, zContains, mediaType));
                    }
                    VoiceState voiceState3 = voiceUser2.getVoiceState();
                    if (voiceState3 != null && voiceState3.getSelfVideo()) {
                        StageRoles stageRoles2 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        boolean z3 = stageRoles2 != null && StageRoles.m11409isModeratorimpl(stageRoles2.m11412unboximpl());
                        StageCallItem.MediaType mediaType2 = StageCallItem.MediaType.USER;
                        StringBuilder sbM833U2 = C1643a.m833U("USER-");
                        sbM833U2.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageMediaParticipant(sbM833U2.toString(), voiceUser2, channel, z3, zContains, mediaType2));
                    } else {
                        StageRoles stageRoles3 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        if (stageRoles3 == null || !StageRoles.m11409isModeratorimpl(stageRoles3.m11412unboximpl())) {
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
                        arrayList3.add(new StageCallItem.SpeakerItem(voiceUser2, channel, z2, string, iCoerceAtMost, zContains));
                    }
                }
                i6 = i8;
                i7 = i9;
            }
            StageRoles stageRolesM11392getMyRolesvisDeB4 = stagesStore.m11392getMyRolesvisDeB4(channel.getId());
            return new StageCallModel(stageRolesM11392getMyRolesvisDeB4 != null ? stageRolesM11392getMyRolesvisDeB4.m11412unboximpl() : StageRoles.INSTANCE.m11414getAUDIENCE1LxfuJo(), arrayList3, arrayList2, C12163u.sorted(arrayList4), C12078q.toList(C12078q.map(C12078q.filter(C12163u.asSequence(arrayList3), StageCallModel$Companion$create$2.INSTANCE), StageCallModel$Companion$create$3.INSTANCE)), i6, stageInstance, i7, guild, isLurking, i, null);
        }

        public final Observable<StageCallModel> observeStageCallModel(final long channelId) {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends StageCallModel>>() { // from class: com.discord.widgets.stage.model.StageCallModel$Companion$observeStageCallModel$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends StageCallModel> call(final Channel channel) {
                    if (channel == null) {
                        return new C12721k(null);
                    }
                    if (!ChannelUtils.m7669D(channel)) {
                        return new C12721k(null);
                    }
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    return Observable.m11069e(ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getGuilds().observeRoles(channel.getGuildId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserRelationships().observeForType(2), companion.getStageInstances().observeStageInstanceForChannel(channelId), companion.getLurking().isLurkingObs(channel.getGuildId()), new Func7<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Guild, Map<Long, ? extends Integer>, StageInstance, Boolean, StageCallModel>() { // from class: com.discord.widgets.stage.model.StageCallModel$Companion$observeStageCallModel$1.1
                        @Override // p658rx.functions.Func7
                        public /* bridge */ /* synthetic */ StageCallModel call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends GuildRole> map3, Guild guild, Map<Long, ? extends Integer> map4, StageInstance stageInstance, Boolean bool) {
                            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, (Map<Long, GuildMember>) map2, (Map<Long, GuildRole>) map3, guild, (Map<Long, Integer>) map4, stageInstance, bool);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final StageCallModel call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, Map<Long, GuildMember> map2, Map<Long, GuildRole> map3, Guild guild, Map<Long, Integer> map4, StageInstance stageInstance, Boolean bool) {
                            StageCallModel.Companion companion2 = StageCallModel.INSTANCE;
                            Channel channel2 = channel;
                            C12238m.checkNotNullExpressionValue(map2, "guildMembers");
                            C12238m.checkNotNullExpressionValue(map3, "guildRoles");
                            C12238m.checkNotNullExpressionValue(map, "participants");
                            Set<Long> setKeySet = map4.keySet();
                            C12238m.checkNotNullExpressionValue(bool, "isLurking");
                            return companion2.create(channel2, map2, map3, guild, map, setKeySet, stageInstance, bool.booleanValue(), (256 & 256) != 0 ? StoreStream.INSTANCE.getStageChannels() : null);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private StageCallModel(int i, List<StageCallItem.SpeakerItem> list, List<StageMediaParticipant> list2, List<StageCallItem.AudienceItem> list3, List<StoreVoiceParticipants.VoiceUser> list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4) {
        this.myStageRoles = i;
        this.speakerItems = list;
        this.mediaParticipants = list2;
        this.audience = list3;
        this.speakingVoiceUsers = list4;
        this.requestingToSpeakCount = i2;
        this.stageInstance = stageInstance;
        this.numBlockedUsers = i3;
        this.guild = guild;
        this.isLurking = z2;
        this.numSpeakers = i4;
    }

    /* JADX INFO: renamed from: component1-1LxfuJo, reason: not valid java name and from getter */
    public final int getMyStageRoles() {
        return this.myStageRoles;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final List<StageCallItem.SpeakerItem> component2() {
        return this.speakerItems;
    }

    public final List<StageMediaParticipant> component3() {
        return this.mediaParticipants;
    }

    public final List<StageCallItem.AudienceItem> component4() {
        return this.audience;
    }

    public final List<StoreVoiceParticipants.VoiceUser> component5() {
        return this.speakingVoiceUsers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: copy-YvLQhEs, reason: not valid java name */
    public final StageCallModel m11418copyYvLQhEs(int myStageRoles, List<StageCallItem.SpeakerItem> speakerItems, List<StageMediaParticipant> mediaParticipants, List<StageCallItem.AudienceItem> audience, List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers, int requestingToSpeakCount, StageInstance stageInstance, int numBlockedUsers, Guild guild, boolean isLurking, int numSpeakers) {
        C12238m.checkNotNullParameter(speakerItems, "speakerItems");
        C12238m.checkNotNullParameter(mediaParticipants, "mediaParticipants");
        C12238m.checkNotNullParameter(audience, "audience");
        C12238m.checkNotNullParameter(speakingVoiceUsers, "speakingVoiceUsers");
        return new StageCallModel(myStageRoles, speakerItems, mediaParticipants, audience, speakingVoiceUsers, requestingToSpeakCount, stageInstance, numBlockedUsers, guild, isLurking, numSpeakers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallModel)) {
            return false;
        }
        StageCallModel stageCallModel = (StageCallModel) other;
        return this.myStageRoles == stageCallModel.myStageRoles && C12238m.areEqual(this.speakerItems, stageCallModel.speakerItems) && C12238m.areEqual(this.mediaParticipants, stageCallModel.mediaParticipants) && C12238m.areEqual(this.audience, stageCallModel.audience) && C12238m.areEqual(this.speakingVoiceUsers, stageCallModel.speakingVoiceUsers) && this.requestingToSpeakCount == stageCallModel.requestingToSpeakCount && C12238m.areEqual(this.stageInstance, stageCallModel.stageInstance) && this.numBlockedUsers == stageCallModel.numBlockedUsers && C12238m.areEqual(this.guild, stageCallModel.guild) && this.isLurking == stageCallModel.isLurking && this.numSpeakers == stageCallModel.numSpeakers;
    }

    public final List<StageCallItem.AudienceItem> getAudience() {
        return this.audience;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<StageMediaParticipant> getMediaParticipants() {
        return this.mediaParticipants;
    }

    /* JADX INFO: renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
    public final int m11419getMyStageRoles1LxfuJo() {
        return this.myStageRoles;
    }

    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    public final List<StageCallItem.SpeakerItem> getSpeakerItems() {
        return this.speakerItems;
    }

    public final List<StoreVoiceParticipants.VoiceUser> getSpeakingVoiceUsers() {
        return this.speakingVoiceUsers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27 */
    public int hashCode() {
        int i = this.myStageRoles * 31;
        List<StageCallItem.SpeakerItem> list = this.speakerItems;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<StageMediaParticipant> list2 = this.mediaParticipants;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<StageCallItem.AudienceItem> list3 = this.audience;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<StoreVoiceParticipants.VoiceUser> list4 = this.speakingVoiceUsers;
        int iHashCode4 = (((iHashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31) + this.requestingToSpeakCount) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode5 = (((iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31) + this.numBlockedUsers) * 31;
        Guild guild = this.guild;
        int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isLurking;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((iHashCode6 + r1) * 31) + this.numSpeakers;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StageCallModel(myStageRoles=");
        sbM833U.append(StageRoles.m11411toStringimpl(this.myStageRoles));
        sbM833U.append(", speakerItems=");
        sbM833U.append(this.speakerItems);
        sbM833U.append(", mediaParticipants=");
        sbM833U.append(this.mediaParticipants);
        sbM833U.append(", audience=");
        sbM833U.append(this.audience);
        sbM833U.append(", speakingVoiceUsers=");
        sbM833U.append(this.speakingVoiceUsers);
        sbM833U.append(", requestingToSpeakCount=");
        sbM833U.append(this.requestingToSpeakCount);
        sbM833U.append(", stageInstance=");
        sbM833U.append(this.stageInstance);
        sbM833U.append(", numBlockedUsers=");
        sbM833U.append(this.numBlockedUsers);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", isLurking=");
        sbM833U.append(this.isLurking);
        sbM833U.append(", numSpeakers=");
        return C1643a.m814B(sbM833U, this.numSpeakers, ")");
    }

    public /* synthetic */ StageCallModel(int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, list3, list4, i2, stageInstance, i3, guild, z2, i4);
    }
}
