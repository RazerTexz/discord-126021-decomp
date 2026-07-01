package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming$SystemCallIncoming;
import d0.e0.c;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1() {
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
        if (appActivity.g(n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetVoiceCallIncoming.class), a0.getOrCreateKotlinClass(WidgetVoiceCallIncoming$SystemCallIncoming.class)})) || !storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getIncomingCall()) {
            return storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.getIncomingCall();
        }
        j.e(appActivity, WidgetVoiceCallIncoming.class, null, 4);
        return true;
    }
}
