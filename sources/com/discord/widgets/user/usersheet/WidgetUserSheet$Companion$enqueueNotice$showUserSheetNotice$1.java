package com.discord.widgets.user.usersheet;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$Companion$enqueueNotice$showUserSheetNotice$1 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $friendToken;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ StoreNotices $storeNotices;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$Companion$enqueueNotice$showUserSheetNotice$1(long j, String str, StoreNotices storeNotices, String str2) {
        super(1);
        this.$userId = j;
        this.$friendToken = str;
        this.$storeNotices = storeNotices;
        this.$noticeName = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
        long j = this.$userId;
        String str = this.$friendToken;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        WidgetUserSheet.Companion.show$default(companion, j, null, supportFragmentManager, null, null, null, str, 58, null);
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
