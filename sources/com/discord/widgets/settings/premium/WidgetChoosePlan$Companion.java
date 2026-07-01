package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.app.AppFragment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Subscription;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan$Companion {
    private WidgetChoosePlan$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(WidgetChoosePlan$Companion widgetChoosePlan$Companion, Context context, ActivityResultLauncher activityResultLauncher, WidgetChoosePlan$ViewType widgetChoosePlan$ViewType, String str, Traits$Location traits$Location, Traits$Subscription traits$Subscription, int i, Object obj) {
        widgetChoosePlan$Companion.launch(context, (i & 2) != 0 ? null : activityResultLauncher, widgetChoosePlan$ViewType, (i & 8) != 0 ? null : str, traits$Location, (i & 32) != 0 ? null : traits$Subscription);
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, WidgetChoosePlan$ViewType viewType, String oldSkuName, Traits$Location locationTrait, Traits$Subscription subscriptionTrait) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(viewType, "viewType");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        if (BlockRussianPurchasesUtils.Companion.getINSTANCE().showDialog()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME, oldSkuName);
        intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_LOCATION_TRAIT, locationTrait);
        intent.putExtra(WidgetChoosePlan.RESULT_VIEW_TYPE, viewType);
        AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionTrait, null, null, 12, null);
        if (launcher != null) {
            j.g.f(context, launcher, WidgetChoosePlan.class, intent);
        } else {
            j.d(context, WidgetChoosePlan.class, intent);
        }
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetChoosePlan$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetChoosePlan$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
