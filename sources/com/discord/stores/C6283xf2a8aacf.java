package com.discord.stores;

import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6283xf2a8aacf extends AbstractC12240o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6283xf2a8aacf(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        C12238m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(modelGlobalNavigation, "model");
        Uri oAuthUri = modelGlobalNavigation.getOAuthUri();
        if (!C12238m.areEqual(oAuthUri, Uri.EMPTY)) {
            C0870j c0870j = C0870j.f524g;
            if (!appActivity.m8347g(C0870j.f520c)) {
                WidgetOauth2Authorize.INSTANCE.launch(appActivity, oAuthUri);
                StoreAuthentication authentication = this.this$0.stream.getAuthentication();
                Uri uri = Uri.EMPTY;
                C12238m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                authentication.setOAuthUriSubject(uri);
                return true;
            }
        }
        return false;
    }
}
