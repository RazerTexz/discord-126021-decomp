package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1$1 implements View$OnClickListener {
    public final /* synthetic */ NoticePopup$enqueue$notice$1 this$0;

    public NoticePopup$enqueue$notice$1$1(NoticePopup$enqueue$notice$1 noticePopup$enqueue$notice$1) {
        this.this$0 = noticePopup$enqueue$notice$1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.this$0.$onClick;
        m.checkNotNullExpressionValue(view, "view");
        function1.invoke(view);
        NoticePopup.access$dismiss(NoticePopup.INSTANCE, this.this$0.$noticeName);
    }
}
