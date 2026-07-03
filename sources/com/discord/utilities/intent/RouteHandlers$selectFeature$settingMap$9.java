package com.discord.utilities.intent;

import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$9 extends AbstractC12240o implements Function1<FragmentActivity, Unit> {
    public static final RouteHandlers$selectFeature$settingMap$9 INSTANCE = new RouteHandlers$selectFeature$settingMap$9();

    public RouteHandlers$selectFeature$settingMap$9() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
        invoke2(fragmentActivity);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "ctx");
        ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, C12134g0.mapOf(C12116o.m10073to("location_page", "Deep Link")), 1, null);
        WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, fragmentActivity, null, false, false, false, 30, null);
    }
}
