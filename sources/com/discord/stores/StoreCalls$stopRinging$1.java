package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$stopRinging$1 extends o implements Function1<ModelCall, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ List $recipients;
    public final /* synthetic */ StoreCalls this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCalls$stopRinging$1(StoreCalls storeCalls, long j, List list) {
        super(1);
        this.this$0 = storeCalls;
        this.$channelId = j;
        this.$recipients = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
        invoke2(modelCall);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelCall modelCall) {
        if (modelCall == null) {
            StoreCalls.access$getStream$p(this.this$0).getCallsIncoming().removeIncomingCall(this.$channelId);
        } else {
            ObservableExtensionsKt.appSubscribe$default(RestAPI.Companion.getApi().stopRinging(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, StoreCalls$stopRinging$1$1.INSTANCE, 62, (Object) null);
        }
    }
}
