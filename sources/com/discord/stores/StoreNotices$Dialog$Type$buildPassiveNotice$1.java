package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$Dialog$Type$buildPassiveNotice$1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ StoreNotices.Dialog.Type this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices$Dialog$Type$buildPassiveNotice$1(StoreNotices.Dialog.Type type) {
        super(1);
        this.this$0 = type;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        StoreNotices.Dialog dialog = new StoreNotices.Dialog(this.this$0, null, 2, null);
        NoticeBuilders noticeBuilders = NoticeBuilders.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        noticeBuilders.showNotice(fragmentActivity, supportFragmentManager, dialog);
        return true;
    }
}
