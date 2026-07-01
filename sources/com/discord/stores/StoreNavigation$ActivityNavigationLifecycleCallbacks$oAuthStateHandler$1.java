package com.discord.stores;

import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation$ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1(StoreNavigation$ActivityNavigationLifecycleCallbacks storeNavigation$ActivityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = storeNavigation$ActivityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, "model");
        Uri oAuthUri = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getOAuthUri();
        if (!m.areEqual(oAuthUri, Uri.EMPTY)) {
            j jVar = j.g;
            if (!appActivity.g(j.c)) {
                WidgetOauth2Authorize.Companion.launch(appActivity, oAuthUri);
                StoreAuthentication authentication = StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getAuthentication();
                Uri uri = Uri.EMPTY;
                m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                authentication.setOAuthUriSubject(uri);
                return true;
            }
        }
        return false;
    }
}
