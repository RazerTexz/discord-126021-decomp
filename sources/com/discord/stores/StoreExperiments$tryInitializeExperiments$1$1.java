package com.discord.stores;

import com.discord.models.experiments.dto.UnauthenticatedUserExperimentsDto;
import com.discord.models.experiments.dto.UserExperimentDto;
import d0.d0.f;
import d0.t.g0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments$tryInitializeExperiments$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ UnauthenticatedUserExperimentsDto $it;
    public final /* synthetic */ StoreExperiments$tryInitializeExperiments$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExperiments$tryInitializeExperiments$1$1(StoreExperiments$tryInitializeExperiments$1 storeExperiments$tryInitializeExperiments$1, UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto) {
        super(0);
        this.this$0 = storeExperiments$tryInitializeExperiments$1;
        this.$it = unauthenticatedUserExperimentsDto;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreExperiments.access$getStoreAuthentication$p(this.this$0.this$0).setFingerprint(this.$it.getFingerprint(), false);
        StoreExperiments storeExperiments = this.this$0.this$0;
        List<UserExperimentDto> assignments = this.$it.getAssignments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(assignments, 10)), 16));
        for (Object obj : assignments) {
            linkedHashMap.put(Long.valueOf(((UserExperimentDto) obj).getNameHash()), obj);
        }
        StoreExperiments.access$handleLoadedUserExperiments(storeExperiments, linkedHashMap, true);
        StoreExperiments.access$setInitialized(this.this$0.this$0);
    }
}
