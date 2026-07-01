package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreNotices$Dialog$Type$buildPassiveNotice$1, reason: use source file name */
/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ StoreNotices.Dialog.Type this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices2(StoreNotices.Dialog.Type type) {
        super(1);
        this.this$0 = type;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        StoreNotices.Dialog dialog = new StoreNotices.Dialog(this.this$0, null, 2, null);
        NoticeBuilders noticeBuilders = NoticeBuilders.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        noticeBuilders.showNotice(fragmentActivity, supportFragmentManager, dialog);
        return true;
    }
}
