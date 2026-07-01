package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func7;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$get$1$1$2$2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Set<? extends Long>, List<? extends Long>, Map<Long, ? extends StoreVideoStreams$UserStreams>, Map<Long, ? extends GuildMember>, Map<String, ? extends List<? extends Long>>, StoreMediaSettings$VoiceConfiguration, Map<Long, ? extends StreamContext>, Map<Long, ? extends StoreVoiceParticipants$VoiceUser>> {
    public final /* synthetic */ MeUser $meUser;
    public final /* synthetic */ Collection $otherUsers;
    public final /* synthetic */ StoreVoiceParticipants$get$1$1$2 this$0;

    public StoreVoiceParticipants$get$1$1$2$2(StoreVoiceParticipants$get$1$1$2 storeVoiceParticipants$get$1$1$2, MeUser meUser, Collection collection) {
        this.this$0 = storeVoiceParticipants$get$1$1$2;
        this.$meUser = meUser;
        this.$otherUsers = collection;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreVoiceParticipants$VoiceUser> call(Set<? extends Long> set, List<? extends Long> list, Map<Long, ? extends StoreVideoStreams$UserStreams> map, Map<Long, ? extends GuildMember> map2, Map<String, ? extends List<? extends Long>> map3, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map<Long, ? extends StreamContext> map4) {
        return call2((Set<Long>) set, (List<Long>) list, (Map<Long, StoreVideoStreams$UserStreams>) map, (Map<Long, GuildMember>) map2, (Map<String, ? extends List<Long>>) map3, storeMediaSettings$VoiceConfiguration, (Map<Long, StreamContext>) map4);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, StoreVoiceParticipants$VoiceUser> call2(Set<Long> set, List<Long> list, Map<Long, StoreVideoStreams$UserStreams> map, Map<Long, GuildMember> map2, Map<String, ? extends List<Long>> map3, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map<Long, StreamContext> map4) {
        StoreVoiceParticipants storeVoiceParticipants = this.this$0.this$0.this$0.this$0;
        MeUser meUser = this.$meUser;
        m.checkNotNullExpressionValue(meUser, "meUser");
        Collection collection = this.$otherUsers;
        m.checkNotNullExpressionValue(collection, "otherUsers");
        Map map5 = this.this$0.$voiceStates;
        m.checkNotNullExpressionValue(map5, "voiceStates");
        m.checkNotNullExpressionValue(set, "speakingUsers");
        m.checkNotNullExpressionValue(list, "ringingUsers");
        m.checkNotNullExpressionValue(map, "videoStreams");
        m.checkNotNullExpressionValue(map2, "guildMembers");
        m.checkNotNullExpressionValue(map3, "streamSpectators");
        m.checkNotNullExpressionValue(storeMediaSettings$VoiceConfiguration, "voiceConfig");
        m.checkNotNullExpressionValue(map4, "streamContexts");
        return StoreVoiceParticipants.access$create(storeVoiceParticipants, meUser, collection, map5, set, list, map, map2, map3, storeMediaSettings$VoiceConfiguration, map4);
    }
}
