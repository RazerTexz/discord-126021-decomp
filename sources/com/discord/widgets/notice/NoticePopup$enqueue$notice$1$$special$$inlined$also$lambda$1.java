package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ FragmentActivity $activity$inlined;
    public final /* synthetic */ NoticePopup$enqueue$notice$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$1(NoticePopup$enqueue$notice$1 noticePopup$enqueue$notice$1, FragmentActivity fragmentActivity) {
        super(0);
        this.this$0 = noticePopup$enqueue$notice$1;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NoticePopup.INSTANCE.dismiss(this.this$0.$noticeName);
    }
}
