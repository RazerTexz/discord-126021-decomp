package com.discord.stores;

import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1 extends Lambda implements Function1<StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Unit> {
    public final /* synthetic */ AppActivity $activity;
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks, AppActivity appActivity) {
        super(1);
        this.this$0 = activityNavigationLifecycleCallbacks;
        this.$activity = appActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        invoke2(modelGlobalNavigation);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "it");
        this.this$0.handleGlobalNavigationData(this.$activity, modelGlobalNavigation);
    }
}
