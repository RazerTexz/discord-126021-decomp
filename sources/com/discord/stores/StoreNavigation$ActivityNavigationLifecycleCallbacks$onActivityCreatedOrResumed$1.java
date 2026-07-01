package com.discord.stores;

import com.discord.app.AppActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1 extends o implements Function1<StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Unit> {
    public final /* synthetic */ AppActivity $activity;
    public final /* synthetic */ StoreNavigation$ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1(StoreNavigation$ActivityNavigationLifecycleCallbacks storeNavigation$ActivityNavigationLifecycleCallbacks, AppActivity appActivity) {
        super(1);
        this.this$0 = storeNavigation$ActivityNavigationLifecycleCallbacks;
        this.$activity = appActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        invoke2(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        m.checkNotNullParameter(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, "it");
        StoreNavigation$ActivityNavigationLifecycleCallbacks.access$handleGlobalNavigationData(this.this$0, this.$activity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation);
    }
}
