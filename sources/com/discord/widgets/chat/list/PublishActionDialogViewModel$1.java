package com.discord.widgets.chat.list;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialogViewModel$1 extends o implements Function1<PublishActionDialogViewModel$StoreState, Unit> {
    public final /* synthetic */ PublishActionDialogViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialogViewModel$1(PublishActionDialogViewModel publishActionDialogViewModel) {
        super(1);
        this.this$0 = publishActionDialogViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel$StoreState publishActionDialogViewModel$StoreState) {
        invoke2(publishActionDialogViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PublishActionDialogViewModel$StoreState publishActionDialogViewModel$StoreState) {
        m.checkNotNullParameter(publishActionDialogViewModel$StoreState, "storeState");
        PublishActionDialogViewModel.access$handleStoreState(this.this$0, publishActionDialogViewModel$StoreState);
    }
}
