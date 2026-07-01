package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import b.a.a.r;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserMentions;
import d0.e0.c;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, "model");
        if (storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice() == null) {
            return false;
        }
        List<c<? extends AppComponent>> validScreens = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice().getValidScreens();
        boolean z2 = true;
        boolean z3 = validScreens != null && validScreens.contains(a0.getOrCreateKotlinClass(WidgetHome.class)) && appActivity.h(a0.getOrCreateKotlinClass(WidgetTabsHost.class)) && storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNavigationTab() == NavigationTab.HOME;
        boolean z4 = validScreens != null && validScreens.contains(a0.getOrCreateKotlinClass(WidgetUserMentions.class)) && appActivity.h(a0.getOrCreateKotlinClass(WidgetTabsHost.class)) && storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNavigationTab() == NavigationTab.MENTIONS;
        String name = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(r.k);
        boolean zAreEqual = m.areEqual(name, "Block Russian Purchases Dialog");
        if (validScreens != null && !appActivity.g(validScreens) && !z3 && !z4 && !zAreEqual) {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        AppLog appLog = AppLog.g;
        String name2 = storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(appLog);
        m.checkNotNullParameter(name2, "noticeName");
        appLog.recordBreadcrumb("Notice [" + name2 + ']', NotificationCompat.CATEGORY_NAVIGATION);
        if (storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice().getAutoMarkSeen()) {
            StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice().getName(), 0L, 2, null);
        }
        return storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getNotice().show(appActivity);
    }
}
