package com.discord.stores;

import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6284xb63f3475 extends AbstractC12240o implements Function1<StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Unit> {
    public final /* synthetic */ AppActivity $activity;
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6284xb63f3475(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks, AppActivity appActivity) {
        super(1);
        this.this$0 = activityNavigationLifecycleCallbacks;
        this.$activity = appActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        invoke2(modelGlobalNavigation);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        C12238m.checkNotNullParameter(modelGlobalNavigation, "it");
        this.this$0.handleGlobalNavigationData(this.$activity, modelGlobalNavigation);
    }
}
