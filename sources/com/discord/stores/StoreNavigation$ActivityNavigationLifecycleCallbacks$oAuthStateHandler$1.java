package com.discord.stores;

import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        Uri oAuthUri = modelGlobalNavigation.getOAuthUri();
        if (!Intrinsics3.areEqual(oAuthUri, Uri.EMPTY)) {
            AppScreen2 appScreen2 = AppScreen2.g;
            if (!appActivity.g(AppScreen2.c)) {
                WidgetOauth2Authorize.INSTANCE.launch(appActivity, oAuthUri);
                StoreAuthentication authentication = this.this$0.stream.getAuthentication();
                Uri uri = Uri.EMPTY;
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                authentication.setOAuthUriSubject(uri);
                return true;
            }
        }
        return false;
    }
}
