package com.discord.widgets.friends;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics$Companion;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.contact_sync.WidgetContactSync$Companion;
import d0.t.g0;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$onViewBound$7 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetFriendsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsList$onViewBound$7(WidgetFriendsList widgetFriendsList) {
        super(0);
        this.this$0 = widgetFriendsList;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ContactSyncFlowAnalytics$Companion.trackStart$default(ContactSyncFlowAnalytics.Companion, false, g0.mapOf(d0.o.to("location_page", "Friends List Upsell")), 1, null);
        AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits$Location("Friends List Upsell", null, null, null, null, 30, null));
        WidgetContactSync$Companion.launch$default(WidgetContactSync.Companion, this.this$0.requireContext(), null, false, false, false, 30, null);
    }
}
