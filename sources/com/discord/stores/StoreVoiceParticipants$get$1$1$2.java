package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$get$1$1$2<T, R> implements b<Pair<? extends MeUser, ? extends Collection<? extends User>>, Observable<? extends Map<Long, ? extends StoreVoiceParticipants$VoiceUser>>> {
    public final /* synthetic */ Map $voiceStates;
    public final /* synthetic */ StoreVoiceParticipants$get$1$1 this$0;

    public StoreVoiceParticipants$get$1$1$2(StoreVoiceParticipants$get$1$1 storeVoiceParticipants$get$1$1, Map map) {
        this.this$0 = storeVoiceParticipants$get$1$1;
        this.$voiceStates = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends StoreVoiceParticipants$VoiceUser>> call(Pair<? extends MeUser, ? extends Collection<? extends User>> pair) {
        return call2((Pair<MeUser, ? extends Collection<? extends User>>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, StoreVoiceParticipants$VoiceUser>> call2(Pair<MeUser, ? extends Collection<? extends User>> pair) {
        MeUser meUserComponent1 = pair.component1();
        Collection<? extends User> collectionComponent2 = pair.component2();
        m.checkNotNullExpressionValue(collectionComponent2, "otherUsers");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collectionComponent2, 10));
        Iterator<T> it = collectionComponent2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((User) it.next()).getId()));
        }
        return Observable.e(ObservableExtensionsKt.leadingEdgeThrottle(this.this$0.this$0.this$0.getStream().getVoiceSpeaking().observeSpeakingUsers(), 250L, TimeUnit.MILLISECONDS), this.this$0.this$0.this$0.getStream().getCalls().get(this.this$0.this$0.$channelId).G(StoreVoiceParticipants$get$1$1$2$1.INSTANCE), this.this$0.this$0.this$0.getStream().getVideoStreams().observeUserStreams(), ObservableExtensionsKt.leadingEdgeThrottle(this.this$0.this$0.this$0.getStream().getGuilds().observeComputed(this.this$0.$guildId), 1L, TimeUnit.SECONDS), this.this$0.this$0.this$0.getStream().getApplicationStreaming().observeStreamSpectators(), this.this$0.this$0.this$0.getStream().getMediaSettings().getVoiceConfig(), StoreVoiceParticipants.access$getStreamContextsForUsers(this.this$0.this$0.this$0, u.plus((Collection<? extends Long>) arrayList, Long.valueOf(meUserComponent1.getId()))), new StoreVoiceParticipants$get$1$1$2$2(this, meUserComponent1, collectionComponent2));
    }
}
