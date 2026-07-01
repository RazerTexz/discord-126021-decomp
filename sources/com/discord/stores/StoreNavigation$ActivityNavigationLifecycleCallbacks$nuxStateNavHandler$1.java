package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncMode;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.contact_sync.WidgetContactSync$Companion;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.HubEmailEntryPoint;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailFlow$Companion;
import com.discord.widgets.nux.WidgetGuildTemplates;
import d0.t.g0;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation$ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1(StoreNavigation$ActivityNavigationLifecycleCallbacks storeNavigation$ActivityNavigationLifecycleCallbacks) {
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
        Experiment userExperiment = StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getExperiments().getUserExperiment("2021-04_contact_sync_android_main", storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNuxState().getPostRegister());
        boolean z2 = userExperiment != null && userExperiment.getBucket() == 1;
        if (!storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNuxState().getPostRegister()) {
            return false;
        }
        if (!z2 || storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNuxState().getContactSyncCompleted()) {
            StoreNotices notices = StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNotices();
            WidgetHubEmailFlow$Companion widgetHubEmailFlow$Companion = WidgetHubEmailFlow.Companion;
            String name = widgetHubEmailFlow$Companion.getNAME();
            m.checkNotNullExpressionValue(name, "WidgetHubEmailFlow.NAME");
            if (!notices.hasBeenSeen(name) && !appActivity.h(a0.getOrCreateKotlinClass(WidgetHubEmailFlow.class)) && GrowthTeamFeatures.INSTANCE.isHubOnboardingEnabled()) {
                j.d(appActivity, WidgetHubEmailFlow.class, new HubEmailArgs(null, 0, HubEmailEntryPoint.Onboarding, 3, null));
                StoreNotices notices2 = StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNotices();
                String name2 = widgetHubEmailFlow$Companion.getNAME();
                m.checkNotNullExpressionValue(name2, "WidgetHubEmailFlow.NAME");
                StoreNotices.markSeen$default(notices2, name2, 0L, 2, null);
            } else if (!appActivity.h(a0.getOrCreateKotlinClass(WidgetGuildTemplates.class)) && !appActivity.h(a0.getOrCreateKotlinClass(WidgetHome.class)) && !appActivity.h(a0.getOrCreateKotlinClass(WidgetHubEmailFlow.class))) {
                WidgetGuildTemplates.Companion.launch(appActivity, CreateGuildTrigger.NUF, true);
                StoreNavigation$ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNux().updateNux(StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1$1.INSTANCE);
            }
        } else if (!appActivity.h(a0.getOrCreateKotlinClass(WidgetContactSync.class))) {
            ContactSyncFlowAnalytics.Companion.trackStart(true, g0.mapOf(d0.o.to("location_page", "Onboarding")));
            WidgetContactSync$Companion.launch$default(WidgetContactSync.Companion, appActivity, ContactSyncMode.ONBOARDING, false, false, false, 28, null);
        }
        return true;
    }
}
