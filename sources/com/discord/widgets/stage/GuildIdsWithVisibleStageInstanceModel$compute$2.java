package com.discord.widgets.stage;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel$compute$2 extends o implements Function1<Map$Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Long> {
    public static final GuildIdsWithVisibleStageInstanceModel$compute$2 INSTANCE = new GuildIdsWithVisibleStageInstanceModel$compute$2();

    public GuildIdsWithVisibleStageInstanceModel$compute$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Map$Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> map$Entry) {
        return Long.valueOf(invoke2((Map$Entry<Long, ? extends Map<Long, StageInstance>>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(Map$Entry<Long, ? extends Map<Long, StageInstance>> map$Entry) {
        m.checkNotNullParameter(map$Entry, "entry");
        return map$Entry.getKey().longValue();
    }
}
