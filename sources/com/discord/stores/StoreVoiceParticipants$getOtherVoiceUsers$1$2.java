package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getOtherVoiceUsers$1$2<T, R> implements b<Set<? extends Long>, List<? extends Long>> {
    public final /* synthetic */ Long $meId;
    public final /* synthetic */ StoreVoiceParticipants$getOtherVoiceUsers$1 this$0;

    public StoreVoiceParticipants$getOtherVoiceUsers$1$2(StoreVoiceParticipants$getOtherVoiceUsers$1 storeVoiceParticipants$getOtherVoiceUsers$1, Long l) {
        this.this$0 = storeVoiceParticipants$getOtherVoiceUsers$1;
        this.$meId = l;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Long> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(Set<Long> set) {
        m.checkNotNullExpressionValue(set, "memberIds");
        ArrayList arrayList = new ArrayList();
        for (T t : set) {
            long jLongValue = ((Number) t).longValue();
            Long l = this.$meId;
            if ((l == null || jLongValue != l.longValue()) && this.this$0.$voiceStates.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
