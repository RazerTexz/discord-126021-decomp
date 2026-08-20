package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.widgets.user.account.WidgetUserAccountVerify;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6286xacd9c7fd extends AbstractC12240o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6286xacd9c7fd INSTANCE = new C6286xacd9c7fd();

    public C6286xacd9c7fd() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        C12238m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(modelGlobalNavigation, "model");
        C0870j c0870j = C0870j.f524g;
        boolean zM8347g = appActivity.m8347g(C0870j.f522e);
        boolean z2 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_EMAIL || modelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_PHONE;
        if (zM8347g || !z2) {
            return z2;
        }
        WidgetUserAccountVerify.INSTANCE.launch(appActivity, modelGlobalNavigation.getUserRequiredAction());
        return true;
    }
}
