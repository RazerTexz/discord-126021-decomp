package com.discord.widgets.user.presence;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.StageCallRichPresencePartyData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: compiled from: ModelStageRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStageRichPresence {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long audienceSize;
    private final long channelId;
    private final String guildIcon;
    private final long guildId;
    private final boolean guildIsPartnered;
    private final boolean guildIsVerified;
    private final String guildName;
    private final Set<Long> knownUserIds;
    private final long speakerCount;
    private final Set<Long> speakerIds;
    private final long stageInstanceId;
    private final String topic;
    private final boolean userIsSpeaker;

    /* JADX INFO: compiled from: ModelStageRichPresence.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable observeStageRichPresence$default(Companion companion, StoreUserPresence storeUserPresence, int i, Object obj) {
            if ((i & 1) != 0) {
                storeUserPresence = StoreStream.INSTANCE.getPresences();
            }
            return companion.observeStageRichPresence(storeUserPresence);
        }

        public final Observable<List<ModelStageRichPresence>> observeStageRichPresence(StoreUserPresence storeUserPresence) {
            C12238m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Observable observableM11083G = storeUserPresence.observeAllPresences().m11083G(new InterfaceC12589b<Map<Long, ? extends Presence>, List<? extends ModelStageRichPresence>>() { // from class: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1

                /* JADX INFO: renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1$1 */
                /* JADX INFO: compiled from: ModelStageRichPresence.kt */
                public static final class C102731 extends AbstractC12240o implements Function1<Long, ModelStageRichPresence> {
                    public final /* synthetic */ Map $userPresences;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C102731(Map map) {
                        super(1);
                        this.$userPresences = map;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ ModelStageRichPresence invoke(Long l) {
                        return invoke(l.longValue());
                    }

                    public final ModelStageRichPresence invoke(long j) {
                        List<Activity> activities;
                        T next;
                        StageCallRichPresencePartyData stageChannelRichPresencePartyData;
                        String smallText;
                        Presence presence = (Presence) this.$userPresences.get(Long.valueOf(j));
                        if (presence != null && (activities = presence.getActivities()) != null) {
                            Iterator<T> it = activities.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next = (T) null;
                                    break;
                                }
                                next = it.next();
                            } while (!ActivityUtilsKt.isStageChannelActivity((Activity) next));
                            Activity activity = next;
                            if (activity != null && (stageChannelRichPresencePartyData = ActivityUtilsKt.getStageChannelRichPresencePartyData(activity)) != null) {
                                long channelId = stageChannelRichPresencePartyData.getChannelId();
                                long stageInstanceId = stageChannelRichPresencePartyData.getStageInstanceId();
                                boolean userIsSpeaker = stageChannelRichPresencePartyData.getUserIsSpeaker();
                                long guildId = stageChannelRichPresencePartyData.getGuildId();
                                boolean guildIsPartnered = stageChannelRichPresencePartyData.getGuildIsPartnered();
                                boolean guildIsVerified = stageChannelRichPresencePartyData.getGuildIsVerified();
                                ActivityAssets assets = activity.getAssets();
                                String smallImage = assets != null ? assets.getSmallImage() : null;
                                ActivityAssets assets2 = activity.getAssets();
                                if (assets2 == null || (smallText = assets2.getSmallText()) == null) {
                                    smallText = "";
                                }
                                return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, smallText, smallImage, activity.getName(), C12146m0.setOf(Long.valueOf(j)), stageChannelRichPresencePartyData.getUserIsSpeaker() ? C12146m0.setOf(Long.valueOf(j)) : C12148n0.emptySet(), stageChannelRichPresencePartyData.getSpeakerCount(), stageChannelRichPresencePartyData.getAudienceSize());
                            }
                        }
                        return null;
                    }
                }

                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ List<? extends ModelStageRichPresence> call(Map<Long, ? extends Presence> map) {
                    return call2((Map<Long, Presence>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<ModelStageRichPresence> call2(Map<Long, Presence> map) {
                    return C12078q.toList(C12078q.mapNotNull(C12163u.asSequence(map.keySet()), new C102731(map)));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "storeUserPresence\n      …   }.toList()\n          }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelStageRichPresence(long j, long j2, boolean z2, long j3, boolean z3, boolean z4, String str, String str2, String str3, Set<Long> set, Set<Long> set2, long j4, long j5) {
        C12238m.checkNotNullParameter(str, "guildName");
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        C12238m.checkNotNullParameter(set, "knownUserIds");
        C12238m.checkNotNullParameter(set2, "speakerIds");
        this.channelId = j;
        this.stageInstanceId = j2;
        this.userIsSpeaker = z2;
        this.guildId = j3;
        this.guildIsPartnered = z3;
        this.guildIsVerified = z4;
        this.guildName = str;
        this.guildIcon = str2;
        this.topic = str3;
        this.knownUserIds = set;
        this.speakerIds = set2;
        this.speakerCount = j4;
        this.audienceSize = j5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final Set<Long> component10() {
        return this.knownUserIds;
    }

    public final Set<Long> component11() {
        return this.speakerIds;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getAudienceSize() {
        return this.audienceSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getGuildIcon() {
        return this.guildIcon;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public final ModelStageRichPresence copy(long channelId, long stageInstanceId, boolean userIsSpeaker, long guildId, boolean guildIsPartnered, boolean guildIsVerified, String guildName, String guildIcon, String topic, Set<Long> knownUserIds, Set<Long> speakerIds, long speakerCount, long audienceSize) {
        C12238m.checkNotNullParameter(guildName, "guildName");
        C12238m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        C12238m.checkNotNullParameter(knownUserIds, "knownUserIds");
        C12238m.checkNotNullParameter(speakerIds, "speakerIds");
        return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, guildName, guildIcon, topic, knownUserIds, speakerIds, speakerCount, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStageRichPresence)) {
            return false;
        }
        ModelStageRichPresence modelStageRichPresence = (ModelStageRichPresence) other;
        return this.channelId == modelStageRichPresence.channelId && this.stageInstanceId == modelStageRichPresence.stageInstanceId && this.userIsSpeaker == modelStageRichPresence.userIsSpeaker && this.guildId == modelStageRichPresence.guildId && this.guildIsPartnered == modelStageRichPresence.guildIsPartnered && this.guildIsVerified == modelStageRichPresence.guildIsVerified && C12238m.areEqual(this.guildName, modelStageRichPresence.guildName) && C12238m.areEqual(this.guildIcon, modelStageRichPresence.guildIcon) && C12238m.areEqual(this.topic, modelStageRichPresence.topic) && C12238m.areEqual(this.knownUserIds, modelStageRichPresence.knownUserIds) && C12238m.areEqual(this.speakerIds, modelStageRichPresence.speakerIds) && this.speakerCount == modelStageRichPresence.speakerCount && this.audienceSize == modelStageRichPresence.audienceSize;
    }

    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getGuildIcon() {
        return this.guildIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final Set<Long> getKnownUserIds() {
        return this.knownUserIds;
    }

    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    public final Set<Long> getSpeakerIds() {
        return this.speakerIds;
    }

    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        int iM3a = (C0002b.m3a(this.stageInstanceId) + (C0002b.m3a(this.channelId) * 31)) * 31;
        boolean z2 = this.userIsSpeaker;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iM3a2 = (C0002b.m3a(this.guildId) + ((iM3a + r0) * 31)) * 31;
        boolean z3 = this.guildIsPartnered;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i = (iM3a2 + r1) * 31;
        boolean z4 = this.guildIsVerified;
        int i2 = (i + (z4 ? 1 : z4)) * 31;
        String str = this.guildName;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.guildIcon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.topic;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Set<Long> set = this.knownUserIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.speakerIds;
        return C0002b.m3a(this.audienceSize) + ((C0002b.m3a(this.speakerCount) + ((iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelStageRichPresence(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", stageInstanceId=");
        sbM833U.append(this.stageInstanceId);
        sbM833U.append(", userIsSpeaker=");
        sbM833U.append(this.userIsSpeaker);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildIsPartnered=");
        sbM833U.append(this.guildIsPartnered);
        sbM833U.append(", guildIsVerified=");
        sbM833U.append(this.guildIsVerified);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", guildIcon=");
        sbM833U.append(this.guildIcon);
        sbM833U.append(", topic=");
        sbM833U.append(this.topic);
        sbM833U.append(", knownUserIds=");
        sbM833U.append(this.knownUserIds);
        sbM833U.append(", speakerIds=");
        sbM833U.append(this.speakerIds);
        sbM833U.append(", speakerCount=");
        sbM833U.append(this.speakerCount);
        sbM833U.append(", audienceSize=");
        return C1643a.m815C(sbM833U, this.audienceSize, ")");
    }
}
