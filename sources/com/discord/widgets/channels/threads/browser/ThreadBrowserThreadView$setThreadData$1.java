package com.discord.widgets.channels.threads.browser;

import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadBrowserThreadView$setThreadData$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ GuildMember $creatorMember;
    public final /* synthetic */ String $creatorName;
    public final /* synthetic */ ThreadBrowserThreadView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView$setThreadData$1(ThreadBrowserThreadView threadBrowserThreadView, String str, GuildMember guildMember) {
        super(1);
        this.this$0 = threadBrowserThreadView;
        this.$creatorName = str;
        this.$creatorMember = guildMember;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("authorHook", new ThreadBrowserThreadView$setThreadData$1$1(this));
    }
}
