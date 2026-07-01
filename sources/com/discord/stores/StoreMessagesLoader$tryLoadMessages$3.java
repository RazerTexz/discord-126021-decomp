package com.discord.stores;

import android.content.Context;
import com.discord.api.message.Message;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$3 extends o implements Function4<Long, Long, Long, Long, Unit> {
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$3(StoreMessagesLoader storeMessagesLoader) {
        super(4);
        this.this$0 = storeMessagesLoader;
    }

    public static /* synthetic */ void invoke$default(StoreMessagesLoader$tryLoadMessages$3 storeMessagesLoader$tryLoadMessages$3, long j, Long l, Long l2, Long l3, int i, Object obj) {
        storeMessagesLoader$tryLoadMessages$3.invoke(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : l3);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3, Long l4) {
        invoke(l.longValue(), l2, l3, l4);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final synchronized void invoke(long j, Long l, Long l2, Long l3) {
        Observable<List<Message>> channelMessages;
        StoreMessagesLoader.access$channelLoadedStateUpdate(this.this$0, j, StoreMessagesLoader$tryLoadMessages$3$1.INSTANCE);
        if (l == null || l.longValue() != 1) {
            if (l == null || l.longValue() != 0) {
                if (l != null) {
                    channelMessages = RestAPI.Companion.getApi().getChannelMessagesAround(j, StoreMessagesLoader.access$getMessageRequestSize$p(this.this$0), l.longValue());
                }
                StoreMessagesLoader.access$getChannelMessagesLoadingSubject$p(this.this$0).k.onNext((T) Boolean.TRUE);
                Observable observableG = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).G(StoreMessagesLoader$tryLoadMessages$3$2.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "messagesRequest\n        …messages.map(::Message) }");
                Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(observableG);
                Class<?> cls = this.this$0.getClass();
                StoreMessagesLoader$tryLoadMessages$3$3 storeMessagesLoader$tryLoadMessages$3$3 = new StoreMessagesLoader$tryLoadMessages$3$3(this, j, l, l2, l3);
                ObservableExtensionsKt.appSubscribe$default(observableComputationLatest, cls, (Context) null, new StoreMessagesLoader$tryLoadMessages$3$5(this), new StoreMessagesLoader$tryLoadMessages$3$4(this, j), (Function0) null, (Function0) null, storeMessagesLoader$tryLoadMessages$3$3, 50, (Object) null);
            }
        }
        channelMessages = RestAPI.Companion.getApi().getChannelMessages(j, l2, l3, Integer.valueOf(StoreMessagesLoader.access$getMessageRequestSize$p(this.this$0)));
        StoreMessagesLoader.access$getChannelMessagesLoadingSubject$p(this.this$0).k.onNext((T) Boolean.TRUE);
        Observable observableG2 = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).G(StoreMessagesLoader$tryLoadMessages$3$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "messagesRequest\n        …messages.map(::Message) }");
        Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableG2);
        Class<?> cls2 = this.this$0.getClass();
        StoreMessagesLoader$tryLoadMessages$3$3 storeMessagesLoader$tryLoadMessages$3$4 = new StoreMessagesLoader$tryLoadMessages$3$3(this, j, l, l2, l3);
        ObservableExtensionsKt.appSubscribe$default(observableComputationLatest2, cls2, (Context) null, new StoreMessagesLoader$tryLoadMessages$3$5(this), new StoreMessagesLoader$tryLoadMessages$3$4(this, j), (Function0) null, (Function0) null, storeMessagesLoader$tryLoadMessages$3$4, 50, (Object) null);
    }
}
