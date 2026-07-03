package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.client.WidgetClientOutdated;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6276xe14e3735 extends AbstractC12240o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6276xe14e3735 INSTANCE = new C6276xe14e3735();

    public C6276xe14e3735() {
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
        boolean zM8348h = appActivity.m8348h(C12216a0.getOrCreateKotlinClass(WidgetClientOutdated.class));
        if (modelGlobalNavigation.getClientOutdated()) {
            if (zM8348h) {
                return true;
            }
            WidgetClientOutdated.INSTANCE.launch(appActivity);
            return true;
        }
        if (modelGlobalNavigation.getClientOutdated() || !zM8348h) {
            return modelGlobalNavigation.getClientOutdated();
        }
        C0870j.m155c(appActivity, false, null, 6);
        return true;
    }
}
