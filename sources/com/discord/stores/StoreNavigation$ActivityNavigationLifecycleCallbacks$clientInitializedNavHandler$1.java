package com.discord.stores;

import com.discord.app.AppActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$clientInitializedNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$clientInitializedNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$clientInitializedNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$clientInitializedNavHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        m.checkNotNullParameter(appActivity, "<anonymous parameter 0>");
        m.checkNotNullParameter(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, "model");
        return !storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getInitialized();
    }
}
