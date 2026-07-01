package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.tos.WidgetTos;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        boolean zH = appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetTos.class));
        boolean z2 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.TOS_UPDATE_ACKNOWLEDGMENT;
        boolean z3 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.AGREEMENTS;
        boolean z4 = (z2 || z3) && !zH;
        boolean z5 = (z2 || z3 || !zH) ? false : true;
        if (z4) {
            WidgetTos.INSTANCE.show(appActivity, z2);
        } else if (z5) {
            AppScreen2.c(appActivity, false, null, 6);
        } else if (!z2 && !z3) {
            return false;
        }
        return true;
    }
}
