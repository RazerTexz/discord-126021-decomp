package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserMentions;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p009a.C0841r;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6281x4890bed1 extends AbstractC12240o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6281x4890bed1 INSTANCE = new C6281x4890bed1();

    public C6281x4890bed1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        C12238m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(modelGlobalNavigation, "model");
        if (modelGlobalNavigation.getNotice() == null) {
            return false;
        }
        List<InterfaceC11230c<? extends AppComponent>> validScreens = modelGlobalNavigation.getNotice().getValidScreens();
        boolean z2 = true;
        boolean z3 = validScreens != null && validScreens.contains(C12216a0.getOrCreateKotlinClass(WidgetHome.class)) && appActivity.m8348h(C12216a0.getOrCreateKotlinClass(WidgetTabsHost.class)) && modelGlobalNavigation.getNavigationTab() == NavigationTab.HOME;
        boolean z4 = validScreens != null && validScreens.contains(C12216a0.getOrCreateKotlinClass(WidgetUserMentions.class)) && appActivity.m8348h(C12216a0.getOrCreateKotlinClass(WidgetTabsHost.class)) && modelGlobalNavigation.getNavigationTab() == NavigationTab.MENTIONS;
        String name = modelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(C0841r.INSTANCE);
        boolean zAreEqual = C12238m.areEqual(name, "Block Russian Purchases Dialog");
        if (validScreens != null && !appActivity.m8347g(validScreens) && !z3 && !z4 && !zAreEqual) {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        AppLog appLog = AppLog.f14950g;
        String name2 = modelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(appLog);
        C12238m.checkNotNullParameter(name2, "noticeName");
        appLog.recordBreadcrumb("Notice [" + name2 + ']', NotificationCompat.CATEGORY_NAVIGATION);
        if (modelGlobalNavigation.getNotice().getAutoMarkSeen()) {
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), modelGlobalNavigation.getNotice().getName(), 0L, 2, null);
        }
        return modelGlobalNavigation.getNotice().show(appActivity);
    }
}
