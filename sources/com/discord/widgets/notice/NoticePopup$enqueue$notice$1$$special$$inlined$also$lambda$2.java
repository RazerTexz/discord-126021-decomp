package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ FragmentActivity $activity$inlined;
    public final /* synthetic */ View $view;
    public final /* synthetic */ NoticePopup$enqueue$notice$1 this$0;

    public NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$2(View view, NoticePopup$enqueue$notice$1 noticePopup$enqueue$notice$1, FragmentActivity fragmentActivity) {
        this.$view = view;
        this.this$0 = noticePopup$enqueue$notice$1;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        NoticePopup.access$dismiss(NoticePopup.INSTANCE, this.this$0.$noticeName);
        this.this$0.$onClickTopRightIcon.invoke(this.$view);
    }
}
