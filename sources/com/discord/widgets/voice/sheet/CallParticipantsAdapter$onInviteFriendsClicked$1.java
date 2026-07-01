package com.discord.widgets.voice.sheet;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$onInviteFriendsClicked$1 extends Lambda implements Function1<View, Unit> {
    public static final CallParticipantsAdapter$onInviteFriendsClicked$1 INSTANCE = new CallParticipantsAdapter$onInviteFriendsClicked$1();

    public CallParticipantsAdapter$onInviteFriendsClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
    }
}
