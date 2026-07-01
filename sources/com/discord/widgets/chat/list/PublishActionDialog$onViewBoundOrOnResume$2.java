package com.discord.widgets.chat.list;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PublishActionDialog$onViewBoundOrOnResume$2 extends k implements Function1<PublishActionDialogViewModel$Event, Unit> {
    public PublishActionDialog$onViewBoundOrOnResume$2(PublishActionDialog publishActionDialog) {
        super(1, publishActionDialog, PublishActionDialog.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel$Event publishActionDialogViewModel$Event) {
        invoke2(publishActionDialogViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PublishActionDialogViewModel$Event publishActionDialogViewModel$Event) {
        m.checkNotNullParameter(publishActionDialogViewModel$Event, "p1");
        PublishActionDialog.access$handleEvent((PublishActionDialog) this.receiver, publishActionDialogViewModel$Event);
    }
}
