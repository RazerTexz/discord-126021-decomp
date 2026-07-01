package com.discord.utilities.premium;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.WidgetBlockRussianPurchasesDialog;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.premium.BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1, reason: use source file name */
/* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockRussianPurchasesUtils3 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public static final BlockRussianPurchasesUtils3 INSTANCE = new BlockRussianPurchasesUtils3();

    public BlockRussianPurchasesUtils3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
        WidgetBlockRussianPurchasesDialog widgetBlockRussianPurchasesDialog = new WidgetBlockRussianPurchasesDialog();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        widgetBlockRussianPurchasesDialog.show(supportFragmentManager, Reflection2.getOrCreateKotlinClass(WidgetBlockRussianPurchasesDialog.class).toString());
        return true;
    }
}
