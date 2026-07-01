package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Map;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getOtherVoiceUsers$1$3$1<T> implements Action1<Map<Long, ? extends User>> {
    public final /* synthetic */ StoreVoiceParticipants$getOtherVoiceUsers$1$3 this$0;

    public StoreVoiceParticipants$getOtherVoiceUsers$1$3$1(StoreVoiceParticipants$getOtherVoiceUsers$1$3 storeVoiceParticipants$getOtherVoiceUsers$1$3) {
        this.this$0 = storeVoiceParticipants$getOtherVoiceUsers$1$3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Map<Long, ? extends User> map) {
        call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Map<Long, ? extends User> map) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StageInstance stageInstanceForChannel = storeStream$Companion.getStageInstances().getStageInstanceForChannel(this.this$0.this$0.$channel.getId());
        if ((stageInstanceForChannel != null ? stageInstanceForChannel.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC) {
            StoreGuildMemberRequester guildMemberRequester = storeStream$Companion.getGuildMemberRequester();
            Iterator it = this.this$0.this$0.$voiceStates.keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                m.checkNotNullExpressionValue(map, "otherUsers");
                if (!map.containsKey(Long.valueOf(jLongValue))) {
                    guildMemberRequester.queueRequest(this.this$0.this$0.$channel.getGuildId(), jLongValue);
                }
            }
            guildMemberRequester.performQueuedRequests();
        }
    }
}
