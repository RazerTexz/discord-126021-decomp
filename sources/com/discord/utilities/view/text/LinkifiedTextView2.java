package com.discord.utilities.view.text;

import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LinkifiedTextView2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Job $this_apply;
    public final /* synthetic */ LinkifiedTextView.ClickableSpanOnTouchListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView2(Job job, LinkifiedTextView.ClickableSpanOnTouchListener clickableSpanOnTouchListener) {
        super(1);
        this.$this_apply = job;
        this.this$0 = clickableSpanOnTouchListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.this$0.job.weakCompareAndSet(this.$this_apply, null);
    }
}
