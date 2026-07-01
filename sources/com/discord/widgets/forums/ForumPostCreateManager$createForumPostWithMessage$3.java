package com.discord.widgets.forums;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$createForumPostWithMessage$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $forumChannelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumPostCreateManager$createForumPostWithMessage$3(Context context, long j) {
        super(1);
        this.$context = context;
        this.$forumChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$forumChannelId);
    }
}
