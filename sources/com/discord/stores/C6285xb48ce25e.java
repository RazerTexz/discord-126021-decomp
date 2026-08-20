package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.widgets.tos.WidgetTos;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6285xb48ce25e extends AbstractC12240o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6285xb48ce25e INSTANCE = new C6285xb48ce25e();

    public C6285xb48ce25e() {
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
        boolean zM8348h = appActivity.m8348h(C12216a0.getOrCreateKotlinClass(WidgetTos.class));
        boolean z2 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.TOS_UPDATE_ACKNOWLEDGMENT;
        boolean z3 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.AGREEMENTS;
        boolean z4 = (z2 || z3) && !zM8348h;
        boolean z5 = (z2 || z3 || !zM8348h) ? false : true;
        if (z4) {
            WidgetTos.INSTANCE.show(appActivity, z2);
        } else if (z5) {
            C0870j.m155c(appActivity, false, null, 6);
        } else if (!z2 && !z3) {
            return false;
        }
        return true;
    }
}
