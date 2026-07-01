package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$launchNotice$notice$1 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ Function1 $showAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$launchNotice$notice$1(String str, Function1 function1) {
        super(1);
        this.$noticeName = str;
        this.$showAction = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "it");
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$noticeName, 0L, 2, null);
        return ((Boolean) this.$showAction.invoke(fragmentActivity)).booleanValue();
    }
}
