package com.discord.stores;

import com.discord.api.application.Application;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication$fetchIfNonexisting$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $results;
    public final /* synthetic */ StoreApplication$fetchIfNonexisting$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplication$fetchIfNonexisting$1$1$1(StoreApplication$fetchIfNonexisting$1$1 storeApplication$fetchIfNonexisting$1$1, List list) {
        super(0);
        this.this$0 = storeApplication$fetchIfNonexisting$1$1;
        this.$results = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Object next;
        StoreApplication.access$getApplicationsLoading$p(this.this$0.this$0.this$0).remove(Long.valueOf(this.this$0.this$0.$appId));
        Iterator it = this.$results.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((Application) next).getId() == this.this$0.this$0.$appId));
        Application application = (Application) next;
        if (application != null) {
            StoreApplication.access$getApplications$p(this.this$0.this$0.this$0).put(Long.valueOf(this.this$0.this$0.$appId), application);
            this.this$0.this$0.this$0.markChanged();
        }
    }
}
