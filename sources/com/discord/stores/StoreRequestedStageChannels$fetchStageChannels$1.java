package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels$fetchStageChannels$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Set $channelIds;
    public final /* synthetic */ StoreRequestedStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRequestedStageChannels$fetchStageChannels$1(StoreRequestedStageChannels storeRequestedStageChannels, Set set) {
        super(0);
        this.this$0 = storeRequestedStageChannels;
        this.$channelIds = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Set set = this.$channelIds;
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                Set<Long> set2 = u.toSet(arrayList);
                StoreRequestedStageChannels.access$updateStatus(this.this$0, set2, StoreRequestedStageChannels$FetchStatus.LOADING);
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreRequestedStageChannels.access$getRestAPI$p(this.this$0).getStageInstancesForChannels(set2), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreRequestedStageChannels$fetchStageChannels$1$1(this, set2), (Function0) null, (Function0) null, new StoreRequestedStageChannels$fetchStageChannels$1$2(this, set2), 54, (Object) null);
                return;
            } else {
                Object next = it.next();
                StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState = (StoreRequestedStageChannels$StageInstanceState) StoreRequestedStageChannels.access$getRequestedStageChannelsSnapshot$p(this.this$0).get(Long.valueOf(((Number) next).longValue()));
                if (storeRequestedStageChannels$StageInstanceState == null || !storeRequestedStageChannels$StageInstanceState.isLoading()) {
                    arrayList.add(next);
                }
            }
        }
    }
}
