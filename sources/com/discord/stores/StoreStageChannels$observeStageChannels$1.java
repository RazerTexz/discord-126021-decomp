package com.discord.stores;

import com.discord.widgets.stage.model.StageChannel;
import d0.f0.q;
import d0.t.h0;
import d0.t.u;
import d0.z.d.o;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$observeStageChannels$1 extends o implements Function0<Map<Long, ? extends StageChannel>> {
    public final /* synthetic */ StoreStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannels$observeStageChannels$1(StoreStageChannels storeStageChannels) {
        super(0);
        this.this$0 = storeStageChannels;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StageChannel> invoke2() {
        Object obj;
        Iterator it = q.map(u.asSequence(StoreStageChannels.access$getGuildsStore$p(this.this$0).getGuilds().keySet()), new StoreStageChannels$observeStageChannels$1$1(this)).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = h0.plus((Map) next, (Map) it.next());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map<Long, ? extends StageChannel> map = (Map) obj;
        return map != null ? map : h0.emptyMap();
    }
}
