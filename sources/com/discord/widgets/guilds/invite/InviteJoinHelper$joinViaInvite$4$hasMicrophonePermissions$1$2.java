package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import p507d0.C12112k;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: InviteJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteJoinHelper$joinViaInvite$4$hasMicrophonePermissions$1$2 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Continuation $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteJoinHelper$joinViaInvite$4$hasMicrophonePermissions$1$2(Continuation continuation) {
        super(0);
        this.$cont = continuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Continuation continuation = this.$cont;
        Boolean bool = Boolean.TRUE;
        C12112k.a aVar = C12112k.f25169j;
        continuation.resumeWith(C12112k.m11474constructorimpl(bool));
    }
}
