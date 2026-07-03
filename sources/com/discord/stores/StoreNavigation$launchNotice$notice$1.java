package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$launchNotice$notice$1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
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
        C12238m.checkNotNullParameter(fragmentActivity, "it");
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$noticeName, 0L, 2, null);
        return ((Boolean) this.$showAction.invoke(fragmentActivity)).booleanValue();
    }
}
