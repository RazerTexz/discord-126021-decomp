package com.discord.utilities.notices;

import android.content.Context;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class NoticeBuilders$noticeDataBuilders$1 extends C12236k implements Function2<Context, StoreNotices.Dialog, NoticeBuilders.DialogData> {
    public NoticeBuilders$noticeDataBuilders$1(NoticeBuilders noticeBuilders) {
        super(2, noticeBuilders, NoticeBuilders.class, "requestRatingModalBuilder", "requestRatingModalBuilder(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final NoticeBuilders.DialogData invoke(Context context, StoreNotices.Dialog dialog) {
        C12238m.checkNotNullParameter(context, "p1");
        C12238m.checkNotNullParameter(dialog, "p2");
        return ((NoticeBuilders) this.receiver).requestRatingModalBuilder(context, dialog);
    }
}
