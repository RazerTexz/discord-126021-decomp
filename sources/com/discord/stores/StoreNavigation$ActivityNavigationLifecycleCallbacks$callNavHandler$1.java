package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import d0.e0.KClass;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        if (appActivity.g(Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetVoiceCallIncoming.class), Reflection2.getOrCreateKotlinClass(WidgetVoiceCallIncoming.SystemCallIncoming.class)})) || !modelGlobalNavigation.getIncomingCall()) {
            return modelGlobalNavigation.getIncomingCall();
        }
        AppScreen2.e(appActivity, WidgetVoiceCallIncoming.class, null, 4);
        return true;
    }
}
