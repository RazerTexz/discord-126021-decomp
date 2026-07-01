package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.widgets.client.WidgetClientOutdated;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, "model");
        boolean zH = appActivity.h(a0.getOrCreateKotlinClass(WidgetClientOutdated.class));
        if (storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getClientOutdated()) {
            if (zH) {
                return true;
            }
            WidgetClientOutdated.Companion.launch(appActivity);
            return true;
        }
        if (storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getClientOutdated() || !zH) {
            return storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getClientOutdated();
        }
        j.c(appActivity, false, null, 6);
        return true;
    }
}
