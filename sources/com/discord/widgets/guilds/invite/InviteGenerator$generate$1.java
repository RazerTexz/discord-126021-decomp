package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InviteGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InviteGenerator$generate$1 extends k implements Function1<ModelInvite, Unit> {
    public InviteGenerator$generate$1(InviteGenerator inviteGenerator) {
        super(1, inviteGenerator, InviteGenerator.class, "handleGeneratedInvite", "handleGeneratedInvite(Lcom/discord/models/domain/ModelInvite;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        m.checkNotNullParameter(modelInvite, "p1");
        InviteGenerator.access$handleGeneratedInvite((InviteGenerator) this.receiver, modelInvite);
    }
}
