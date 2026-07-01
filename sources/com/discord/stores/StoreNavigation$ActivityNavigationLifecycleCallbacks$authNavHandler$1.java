package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.models.authentication.AuthState;
import com.discord.widgets.auth.WidgetAuthForceChangePassword;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1() {
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
        boolean zG = appActivity.g(j.a);
        boolean zG2 = appActivity.g(j.f58b);
        boolean zH = appActivity.h(a0.getOrCreateKotlinClass(WidgetAuthForceChangePassword.class));
        boolean zIsInitializedForAuthedUser = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.isInitializedForAuthedUser();
        StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1 storeNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1 = StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1.INSTANCE;
        if (!zIsInitializedForAuthedUser || (!(zG || zH) || storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getAuthState() == null)) {
            if (storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getAuthState() == null) {
                if (!zG && !zG2) {
                    storeNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1.invoke(appActivity, false);
                }
            } else if (!zG && !zH) {
                return false;
            }
        } else if (storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getAuthState().getRequiredActions().isEmpty()) {
            storeNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1.invoke(appActivity, true);
        } else {
            if (zH || !AuthState.Companion.isUpdatePasswordRequired(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getAuthState())) {
                return false;
            }
            WidgetAuthForceChangePassword.Companion.launch(appActivity);
        }
        return true;
    }
}
