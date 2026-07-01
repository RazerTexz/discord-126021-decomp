package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageActionDialogs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageActionDialogs$showDeleteMessageConfirmation$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ Function0 $onSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageActionDialogs$showDeleteMessageConfirmation$1(Message message, Function0 function0) {
        super(1);
        this.$message = message;
        this.$onSuccess = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        StoreStream.Companion.getMessages().deleteMessage(this.$message);
        this.$onSuccess.invoke();
    }
}
