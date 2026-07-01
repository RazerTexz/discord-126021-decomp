package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics$Companion;
import com.discord.widgets.contact_sync.ContactSyncUpsellSheet;
import com.discord.widgets.contact_sync.ContactSyncUpsellSheet$Companion;
import d0.t.g0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreContactSync$createContactSyncNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final StoreContactSync$createContactSyncNotice$1 INSTANCE = new StoreContactSync$createContactSyncNotice$1();

    public StoreContactSync$createContactSyncNotice$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "appActivity");
        AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits$Location("Release Upsell", null, null, null, null, 30, null));
        ContactSyncFlowAnalytics$Companion.trackStart$default(ContactSyncFlowAnalytics.Companion, false, g0.mapOf(d0.o.to("location_page", "Release Upsell")), 1, null);
        ContactSyncUpsellSheet$Companion contactSyncUpsellSheet$Companion = ContactSyncUpsellSheet.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        contactSyncUpsellSheet$Companion.show(supportFragmentManager);
        return true;
    }
}
