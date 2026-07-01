package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import com.discord.app.AppComponent;
import com.discord.models.message.Message;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageActionDialogs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageActionDialogs$showPinMessageConfirmation$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ AppComponent $appComponent;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isPinned;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ Function0 $onSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageActionDialogs$showPinMessageConfirmation$1(Message message, boolean z2, AppComponent appComponent, Context context, Function0 function0) {
        super(1);
        this.$message = message;
        this.$isPinned = z2;
        this.$appComponent = appComponent;
        this.$context = context;
        this.$onSuccess = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        long channelId = this.$message.getChannelId();
        long id2 = this.$message.getId();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.$isPinned ? RestAPI.Companion.getApi().deleteChannelPin(channelId, id2) : RestAPI.Companion.getApi().addChannelPin(channelId, id2), false, 1, null), this.$appComponent, null, 2, null), MessageActionDialogs.INSTANCE.getClass(), view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MessageActionDialogs$showPinMessageConfirmation$1$1(this), 60, (Object) null);
    }
}
