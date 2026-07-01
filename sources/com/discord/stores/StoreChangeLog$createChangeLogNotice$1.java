package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChangeLog$createChangeLogNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ StoreChangeLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChangeLog$createChangeLogNotice$1(StoreChangeLog storeChangeLog) {
        super(1);
        this.this$0 = storeChangeLog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "appActivity");
        StoreChangeLog.openChangeLog$default(this.this$0, fragmentActivity, false, 2, null);
        return true;
    }
}
