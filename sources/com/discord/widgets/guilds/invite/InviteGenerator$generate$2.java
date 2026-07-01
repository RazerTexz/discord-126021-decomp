package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import rx.functions.Action1;

/* JADX INFO: compiled from: InviteGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteGenerator$generate$2<T> implements Action1<Error> {
    public final /* synthetic */ InviteGenerator this$0;

    public InviteGenerator$generate$2(InviteGenerator inviteGenerator) {
        this.this$0 = inviteGenerator;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        InviteGenerator.access$handleRestCallFailed(this.this$0);
    }
}
