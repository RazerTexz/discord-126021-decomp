package com.discord.widgets.user.presence;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.StageCallRichPresencePartyData;
import d0.t.m0;
import d0.t.n0;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModelStageRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelStageRichPresence$Companion$observeStageRichPresence$1$1 extends o implements Function1<Long, ModelStageRichPresence> {
    public final /* synthetic */ Map $userPresences;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelStageRichPresence$Companion$observeStageRichPresence$1$1(Map map) {
        super(1);
        this.$userPresences = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ModelStageRichPresence invoke(Long l) {
        return invoke(l.longValue());
    }

    public final ModelStageRichPresence invoke(long j) {
        List<Activity> activities;
        Object next;
        StageCallRichPresencePartyData stageChannelRichPresencePartyData;
        String smallText;
        Presence presence = (Presence) this.$userPresences.get(Long.valueOf(j));
        if (presence != null && (activities = presence.getActivities()) != null) {
            Iterator<T> it = activities.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!ActivityUtilsKt.isStageChannelActivity((Activity) next));
            Activity activity = (Activity) next;
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
                return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, smallText, smallImage, activity.getName(), m0.setOf(Long.valueOf(j)), stageChannelRichPresencePartyData.getUserIsSpeaker() ? m0.setOf(Long.valueOf(j)) : n0.emptySet(), stageChannelRichPresencePartyData.getSpeakerCount(), stageChannelRichPresencePartyData.getAudienceSize());
            }
        }
        return null;
    }
}
