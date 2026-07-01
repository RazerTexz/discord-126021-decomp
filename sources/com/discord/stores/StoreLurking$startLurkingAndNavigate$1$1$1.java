package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingAndNavigate$1$1$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final StoreLurking$startLurkingAndNavigate$1$1$1 INSTANCE = new StoreLurking$startLurkingAndNavigate$1$1$1();

    public StoreLurking$startLurkingAndNavigate$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "it");
        StoreNavigation.setNavigationPanelAction$default(StoreStream.Companion.getNavigation(), StoreNavigation$PanelAction.OPEN, null, 2, null);
        return true;
    }
}
