package com.discord.stores;

import android.content.Intent;
import b.a.d.j;
import com.discord.app.AppActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1 extends o implements Function2<AppActivity, Boolean, Unit> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppActivity appActivity, Boolean bool) {
        invoke(appActivity, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(AppActivity appActivity, boolean z2) {
        m.checkNotNullParameter(appActivity, "context");
        Intent intentAddFlags = new Intent().addFlags(268468224);
        m.checkNotNullExpressionValue(intentAddFlags, "Intent()\n            .ad…FLAG_ACTIVITY_CLEAR_TASK)");
        j.b(appActivity, z2, intentAddFlags);
    }
}
