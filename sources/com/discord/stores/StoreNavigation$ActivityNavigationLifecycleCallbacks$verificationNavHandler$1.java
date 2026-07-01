package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.user.account.WidgetUserAccountVerify;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1() {
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
        AppScreen2 appScreen2 = AppScreen2.g;
        boolean zG = appActivity.g(AppScreen2.e);
        boolean z2 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_EMAIL || modelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_PHONE;
        if (zG || !z2) {
            return z2;
        }
        WidgetUserAccountVerify.INSTANCE.launch(appActivity, modelGlobalNavigation.getUserRequiredAction());
        return true;
    }
}
