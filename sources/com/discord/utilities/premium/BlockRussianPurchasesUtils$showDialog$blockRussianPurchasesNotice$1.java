package com.discord.utilities.premium;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.r;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1 INSTANCE = new BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1();

    public BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "appActivity");
        r rVar = new r();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        rVar.show(supportFragmentManager, a0.getOrCreateKotlinClass(r.class).toString());
        return true;
    }
}
