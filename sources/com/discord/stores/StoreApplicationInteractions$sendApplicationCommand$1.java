package com.discord.stores;

import com.discord.models.commands.ApplicationCommandLocalSendData;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$sendApplicationCommand$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ ApplicationCommandLocalSendData $localSendData;
    public final /* synthetic */ Function1 $onFail;
    public final /* synthetic */ Function0 $onSuccess;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$sendApplicationCommand$1(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1) {
        super(0);
        this.this$0 = storeApplicationInteractions;
        this.$localSendData = applicationCommandLocalSendData;
        this.$attachments = list;
        this.$onSuccess = function0;
        this.$onFail = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationInteractions.access$handleSendApplicationCommandRequest(this.this$0, this.$localSendData, this.$attachments, this.$onSuccess, this.$onFail);
    }
}
