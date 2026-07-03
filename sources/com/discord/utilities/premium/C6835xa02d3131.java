package com.discord.utilities.premium;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.C0841r;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.utilities.premium.BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1 */
/* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6835xa02d3131 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public static final C6835xa02d3131 INSTANCE = new C6835xa02d3131();

    public C6835xa02d3131() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "appActivity");
        C0841r c0841r = new C0841r();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        c0841r.show(supportFragmentManager, C12216a0.getOrCreateKotlinClass(C0841r.class).toString());
        return true;
    }
}
