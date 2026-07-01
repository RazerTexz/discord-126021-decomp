package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetAgeVerify;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1() {
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
        boolean zH = appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetAgeVerify.class));
        if (modelGlobalNavigation.getShouldShowAgeGate() != null && !zH) {
            WidgetAgeVerify.INSTANCE.start(appActivity, modelGlobalNavigation.getShouldShowAgeGate() == StoreNavigation.AgeGate.NSFW_CHANNEL_AGE_GATE);
        } else if (modelGlobalNavigation.getShouldShowAgeGate() == null) {
            return false;
        }
        return true;
    }
}
