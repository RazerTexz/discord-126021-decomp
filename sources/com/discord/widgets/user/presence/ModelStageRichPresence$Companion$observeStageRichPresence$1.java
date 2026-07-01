package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import d0.f0.q;
import d0.t.u;
import j0.k.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ModelStageRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelStageRichPresence$Companion$observeStageRichPresence$1<T, R> implements b<Map<Long, ? extends Presence>, List<? extends ModelStageRichPresence>> {
    public static final ModelStageRichPresence$Companion$observeStageRichPresence$1 INSTANCE = new ModelStageRichPresence$Companion$observeStageRichPresence$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ModelStageRichPresence> call(Map<Long, ? extends Presence> map) {
        return call2((Map<Long, Presence>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelStageRichPresence> call2(Map<Long, Presence> map) {
        return q.toList(q.mapNotNull(u.asSequence(map.keySet()), new ModelStageRichPresence$Companion$observeStageRichPresence$1$1(map)));
    }
}
