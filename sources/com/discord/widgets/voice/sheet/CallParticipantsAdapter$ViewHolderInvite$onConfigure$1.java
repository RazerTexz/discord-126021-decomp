package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderInvite$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ CallParticipantsAdapter$ViewHolderInvite this$0;

    public CallParticipantsAdapter$ViewHolderInvite$onConfigure$1(CallParticipantsAdapter$ViewHolderInvite callParticipantsAdapter$ViewHolderInvite) {
        this.this$0 = callParticipantsAdapter$ViewHolderInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<View, Unit> onInviteFriendsClicked = CallParticipantsAdapter$ViewHolderInvite.access$getAdapter$p(this.this$0).getOnInviteFriendsClicked();
        m.checkNotNullExpressionValue(view, "it");
        onInviteFriendsClicked.invoke(view);
    }
}
