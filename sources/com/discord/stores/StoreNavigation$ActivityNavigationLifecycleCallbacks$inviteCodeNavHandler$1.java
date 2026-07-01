package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncMode;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.contact_sync.WidgetContactSync$Companion;
import com.discord.widgets.guilds.invite.WidgetGuildInvite;
import d0.t.g0;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation$ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1(StoreNavigation$ActivityNavigationLifecycleCallbacks storeNavigation$ActivityNavigationLifecycleCallbacks) {
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
        StoreInviteSettings$InviteCode inviteCode = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getInviteCode();
        if (inviteCode == null) {
            return false;
        }
        boolean postRegisterWithInvite = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNuxState().getPostRegisterWithInvite();
        Experiment userExperiment = StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getExperiments().getUserExperiment("2021-04_contact_sync_android_main", true);
        boolean z2 = postRegisterWithInvite && (userExperiment != null && userExperiment.getBucket() == 1) && storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getUserHasPhone();
        if (postRegisterWithInvite && z2 && !storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNuxState().getContactSyncCompleted()) {
            if (!appActivity.h(a0.getOrCreateKotlinClass(WidgetContactSync.class))) {
                ContactSyncFlowAnalytics.Companion.trackStart(true, g0.mapOf(d0.o.to("location_page", "Onboarding")));
                WidgetContactSync$Companion.launch$default(WidgetContactSync.Companion, appActivity, ContactSyncMode.ONBOARDING, false, false, false, 28, null);
            }
        } else {
            if (appActivity.h(a0.getOrCreateKotlinClass(WidgetGuildInvite.class))) {
                return false;
            }
            WidgetGuildInvite.Companion.launch(appActivity, inviteCode);
            StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNux().updateNux(StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1$1.INSTANCE);
        }
        return true;
    }
}
