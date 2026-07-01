package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.streams.StreamContext;
import d0.t.n;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rx.functions.FuncN;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getStreamContextsForUsers$1<R> implements FuncN<Map<Long, ? extends StreamContext>> {
    public final /* synthetic */ List $userIds;

    public StoreVoiceParticipants$getStreamContextsForUsers$1(List list) {
        this.$userIds = list;
    }

    @Override // rx.functions.FuncN
    public /* bridge */ /* synthetic */ Map<Long, ? extends StreamContext> call(Object[] objArr) {
        return call2(objArr);
    }

    @Override // rx.functions.FuncN
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StreamContext> call2(Object[] objArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : this.$userIds) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            linkedHashMap.put(Long.valueOf(((Number) obj).longValue()), (StreamContext) objArr[i]);
            i = i2;
        }
        return linkedHashMap;
    }
}
