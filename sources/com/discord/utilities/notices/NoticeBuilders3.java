package com.discord.utilities.notices;

import android.content.Context;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.utilities.notices.NoticeBuilders$noticeDataBuilders$2, reason: use source file name */
/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class NoticeBuilders3 extends FunctionReferenceImpl implements Function2<Context, StoreNotices.Dialog, NoticeBuilders.DialogData> {
    public NoticeBuilders3(NoticeBuilders noticeBuilders) {
        super(2, noticeBuilders, NoticeBuilders.class, "deleteConnectionModalBuilder", "deleteConnectionModalBuilder(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final NoticeBuilders.DialogData invoke(Context context, StoreNotices.Dialog dialog) {
        Intrinsics3.checkNotNullParameter(context, "p1");
        Intrinsics3.checkNotNullParameter(dialog, "p2");
        return ((NoticeBuilders) this.receiver).deleteConnectionModalBuilder(context, dialog);
    }
}
