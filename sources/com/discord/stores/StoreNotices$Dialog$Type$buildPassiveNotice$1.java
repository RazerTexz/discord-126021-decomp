package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$Dialog$Type$buildPassiveNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ StoreNotices$Dialog$Type this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices$Dialog$Type$buildPassiveNotice$1(StoreNotices$Dialog$Type storeNotices$Dialog$Type) {
        super(1);
        this.this$0 = storeNotices$Dialog$Type;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        StoreNotices$Dialog storeNotices$Dialog = new StoreNotices$Dialog(this.this$0, null, 2, null);
        NoticeBuilders noticeBuilders = NoticeBuilders.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        noticeBuilders.showNotice(fragmentActivity, supportFragmentManager, storeNotices$Dialog);
        return true;
    }
}
