package com.discord.widgets.home;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import b.a.d.j;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$maybeShowHubEmailUpsell$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final WidgetHome$maybeShowHubEmailUpsell$1 INSTANCE = new WidgetHome$maybeShowHubEmailUpsell$1();

    public WidgetHome$maybeShowHubEmailUpsell$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        j.d(fragmentActivity, WidgetHubEmailFlow.class, new HubEmailArgs(null, 0, null, 7, null));
        return true;
    }
}
