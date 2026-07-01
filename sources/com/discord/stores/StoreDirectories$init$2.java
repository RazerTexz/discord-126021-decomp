package com.discord.stores;

import com.discord.utilities.persister.Persister;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$init$2 extends o implements Function1<Set<? extends Long>, Unit> {
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$init$2(StoreDirectories storeDirectories) {
        super(1);
        this.this$0 = storeDirectories;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
        invoke2((Set<Long>) set);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Long> set) {
        Set set2 = (Set) StoreDirectories.access$getHubNamePromptPersister$p(this.this$0).get();
        Persister persisterAccess$getHubNamePromptPersister$p = StoreDirectories.access$getHubNamePromptPersister$p(this.this$0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : set2) {
            if (set.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList.add(obj);
            }
        }
        Persister.set$default(persisterAccess$getHubNamePromptPersister$p, u.toSet(arrayList), false, 2, null);
    }
}
