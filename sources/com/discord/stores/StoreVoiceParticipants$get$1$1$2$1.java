package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall;
import d0.t.n;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$get$1$1$2$1<T, R> implements b<ModelCall, List<? extends Long>> {
    public static final StoreVoiceParticipants$get$1$1$2$1 INSTANCE = new StoreVoiceParticipants$get$1$1$2$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Long> call(ModelCall modelCall) {
        return call2(modelCall);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(ModelCall modelCall) {
        List<Long> ringing;
        return (modelCall == null || (ringing = modelCall.getRinging()) == null) ? n.emptyList() : ringing;
    }
}
