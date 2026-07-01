package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.widgets.user.account.WidgetUserAccountVerify;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1() {
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
        j jVar = j.g;
        boolean zG = appActivity.g(j.e);
        boolean z2 = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_EMAIL || storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_PHONE;
        if (zG || !z2) {
            return z2;
        }
        WidgetUserAccountVerify.Companion.launch(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getUserRequiredAction());
        return true;
    }
}
