package com.discord.widgets.channels.threads.browser;

import com.discord.i18n.Hook;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadBrowserThreadView$setThreadData$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ ThreadBrowserThreadView$setThreadData$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView$setThreadData$1$1(ThreadBrowserThreadView$setThreadData$1 threadBrowserThreadView$setThreadData$1) {
        super(1);
        this.this$0 = threadBrowserThreadView$setThreadData$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        ThreadBrowserThreadView$setThreadData$1 threadBrowserThreadView$setThreadData$1 = this.this$0;
        hook.replacementText = threadBrowserThreadView$setThreadData$1.$creatorName;
        hook.styles.addAll(ThreadBrowserThreadView.access$getMemberCharacterStyles(threadBrowserThreadView$setThreadData$1.this$0, threadBrowserThreadView$setThreadData$1.$creatorMember));
    }
}
