package com.discord.widgets.notice;

import b.p.a.j;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1$2 implements j {
    public final /* synthetic */ NoticePopup$enqueue$notice$1 this$0;

    public NoticePopup$enqueue$notice$1$2(NoticePopup$enqueue$notice$1 noticePopup$enqueue$notice$1) {
        this.this$0 = noticePopup$enqueue$notice$1;
    }

    @Override // b.p.a.j
    public final void onHide() {
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), this.this$0.$noticeName, 0L, 2, null);
    }
}
