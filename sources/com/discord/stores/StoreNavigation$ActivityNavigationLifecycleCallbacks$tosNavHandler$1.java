package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.widgets.tos.WidgetTos;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1() {
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
        boolean zH = appActivity.h(a0.getOrCreateKotlinClass(WidgetTos.class));
        boolean z2 = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getUserRequiredAction() == RequiredAction.TOS_UPDATE_ACKNOWLEDGMENT;
        boolean z3 = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getUserRequiredAction() == RequiredAction.AGREEMENTS;
        boolean z4 = (z2 || z3) && !zH;
        boolean z5 = (z2 || z3 || !zH) ? false : true;
        if (z4) {
            WidgetTos.Companion.show(appActivity, z2);
        } else if (z5) {
            j.c(appActivity, false, null, 6);
        } else if (!z2 && !z3) {
            return false;
        }
        return true;
    }
}
