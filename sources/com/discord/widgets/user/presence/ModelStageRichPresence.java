package com.discord.widgets.user.presence;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.ActivityUtils2;
import d0.f0._Sequences2;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

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
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Observable observableG = storeUserPresence.observeAllPresences().G(new Func1<Map<Long, ? extends Presence>, List<? extends ModelStageRichPresence>>() { // from class: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1

                /* JADX INFO: renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ModelStageRichPresence.kt */
                public static final class AnonymousClass1 extends Lambda implements Function1<Long, ModelStageRichPresence> {
                    public final /* synthetic */ Map $userPresences;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(Map map) {
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
                        ActivityUtils2 stageChannelRichPresencePartyData;
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
                            } while (!ActivityUtils.isStageChannelActivity((Activity) next));
                            Activity activity = next;
                            if (activity != null && (stageChannelRichPresencePartyData = ActivityUtils.getStageChannelRichPresencePartyData(activity)) != null) {
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
                                return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, smallText, smallImage, activity.getName(), SetsJVM.setOf(Long.valueOf(j)), stageChannelRichPresencePartyData.getUserIsSpeaker() ? SetsJVM.setOf(Long.valueOf(j)) : Sets5.emptySet(), stageChannelRichPresencePartyData.getSpeakerCount(), stageChannelRichPresencePartyData.getAudienceSize());
                            }
                        }
                        return null;
                    }
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ List<? extends ModelStageRichPresence> call(Map<Long, ? extends Presence> map) {
                    return call2((Map<Long, Presence>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<ModelStageRichPresence> call2(Map<Long, Presence> map) {
                    return _Sequences2.toList(_Sequences2.mapNotNull(_Collections.asSequence(map.keySet()), new AnonymousClass1(map)));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeUserPresence\n      …   }.toList()\n          }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelStageRichPresence(long j, long j2, boolean z2, long j3, boolean z3, boolean z4, String str, String str2, String str3, Set<Long> set, Set<Long> set2, long j4, long j5) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        Intrinsics3.checkNotNullParameter(set, "knownUserIds");
        Intrinsics3.checkNotNullParameter(set2, "speakerIds");
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
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        Intrinsics3.checkNotNullParameter(knownUserIds, "knownUserIds");
        Intrinsics3.checkNotNullParameter(speakerIds, "speakerIds");
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
        return this.channelId == modelStageRichPresence.channelId && this.stageInstanceId == modelStageRichPresence.stageInstanceId && this.userIsSpeaker == modelStageRichPresence.userIsSpeaker && this.guildId == modelStageRichPresence.guildId && this.guildIsPartnered == modelStageRichPresence.guildIsPartnered && this.guildIsVerified == modelStageRichPresence.guildIsVerified && Intrinsics3.areEqual(this.guildName, modelStageRichPresence.guildName) && Intrinsics3.areEqual(this.guildIcon, modelStageRichPresence.guildIcon) && Intrinsics3.areEqual(this.topic, modelStageRichPresence.topic) && Intrinsics3.areEqual(this.knownUserIds, modelStageRichPresence.knownUserIds) && Intrinsics3.areEqual(this.speakerIds, modelStageRichPresence.speakerIds) && this.speakerCount == modelStageRichPresence.speakerCount && this.audienceSize == modelStageRichPresence.audienceSize;
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
        int iA = (b.a(this.stageInstanceId) + (b.a(this.channelId) * 31)) * 31;
        boolean z2 = this.userIsSpeaker;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iA2 = (b.a(this.guildId) + ((iA + r0) * 31)) * 31;
        boolean z3 = this.guildIsPartnered;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i = (iA2 + r1) * 31;
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
        return b.a(this.audienceSize) + ((b.a(this.speakerCount) + ((iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStageRichPresence(channelId=");
        sbU.append(this.channelId);
        sbU.append(", stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", userIsSpeaker=");
        sbU.append(this.userIsSpeaker);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildIsPartnered=");
        sbU.append(this.guildIsPartnered);
        sbU.append(", guildIsVerified=");
        sbU.append(this.guildIsVerified);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildIcon=");
        sbU.append(this.guildIcon);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", knownUserIds=");
        sbU.append(this.knownUserIds);
        sbU.append(", speakerIds=");
        sbU.append(this.speakerIds);
        sbU.append(", speakerCount=");
        sbU.append(this.speakerCount);
        sbU.append(", audienceSize=");
        return outline.C(sbU, this.audienceSize, ")");
    }
}
