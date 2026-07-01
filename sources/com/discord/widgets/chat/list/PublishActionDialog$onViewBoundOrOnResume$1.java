package com.discord.widgets.chat.list;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PublishActionDialog$onViewBoundOrOnResume$1 extends k implements Function1<PublishActionDialogViewModel$ViewState, Unit> {
    public PublishActionDialog$onViewBoundOrOnResume$1(PublishActionDialog publishActionDialog) {
        super(1, publishActionDialog, PublishActionDialog.class, "updateView", "updateView(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel$ViewState publishActionDialogViewModel$ViewState) {
        invoke2(publishActionDialogViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PublishActionDialogViewModel$ViewState publishActionDialogViewModel$ViewState) {
        m.checkNotNullParameter(publishActionDialogViewModel$ViewState, "p1");
        PublishActionDialog.access$updateView((PublishActionDialog) this.receiver, publishActionDialogViewModel$ViewState);
    }
}
