package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FragmentActivity $activity$inlined;
    public final /* synthetic */ NoticePopup2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopup3(NoticePopup2 noticePopup2, FragmentActivity fragmentActivity) {
        super(0);
        this.this$0 = noticePopup2;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NoticePopup.INSTANCE.dismiss(this.this$0.$noticeName);
    }
}
