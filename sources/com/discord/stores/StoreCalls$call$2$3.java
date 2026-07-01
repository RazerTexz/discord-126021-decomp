package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.widgets.voice.call.WidgetCallFailed;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$2$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreCalls$call$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCalls$call$2$3(StoreCalls$call$2 storeCalls$call$2, long j) {
        super(1);
        this.this$0 = storeCalls$call$2;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        Function0 function0 = this.this$0.$onError;
        if (function0 != null) {
        }
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        if (response.getCode() == 50013) {
            error.setShowErrorToasts(false);
            WidgetCallFailed.Companion.show(this.this$0.$fragmentManager, this.$userId);
        }
    }
}
