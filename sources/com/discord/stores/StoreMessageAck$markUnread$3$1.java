package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.message.Message;
import com.discord.utilities.SnowflakeUtils;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$markUnread$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $channelMessages;
    public final /* synthetic */ StoreMessageAck$markUnread$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$markUnread$3$1(StoreMessageAck$markUnread$3 storeMessageAck$markUnread$3, List list) {
        super(0);
        this.this$0 = storeMessageAck$markUnread$3;
        this.$channelMessages = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Object obj;
        List list = this.$channelMessages;
        ArrayList arrayListA0 = a.a0(list, "channelMessages");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Message) next).getId() < this.this$0.$messageId) {
                arrayListA0.add(next);
            }
        }
        Iterator it2 = arrayListA0.iterator();
        if (it2.hasNext()) {
            Object next2 = it2.next();
            if (it2.hasNext()) {
                long id2 = ((Message) next2).getId();
                do {
                    Object next3 = it2.next();
                    long id3 = ((Message) next3).getId();
                    if (id2 < id3) {
                        next2 = next3;
                        id2 = id3;
                    }
                } while (it2.hasNext());
            }
            obj = next2;
        } else {
            obj = null;
        }
        Message message = (Message) obj;
        List list2 = this.$channelMessages;
        ArrayList arrayListA1 = a.a0(list2, "channelMessages");
        for (Object obj2 : list2) {
            if (((Message) obj2).getId() >= this.this$0.$messageId) {
                arrayListA1.add(obj2);
            }
        }
        StoreMessageAck$Ack storeMessageAck$Ack = new StoreMessageAck$Ack(message != null ? message.getId() : (((this.this$0.$messageId >>> 22) - 1) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, true);
        StoreMessageAck$markUnread$3 storeMessageAck$markUnread$3 = this.this$0;
        StoreMessageAck.access$updateAcks(storeMessageAck$markUnread$3.this$0, storeMessageAck$markUnread$3.$channelId, storeMessageAck$Ack);
        int iProcessMarkUnread$app_productionGoogleRelease = StoreStream.Companion.getMentions().processMarkUnread$app_productionGoogleRelease(this.this$0.$channelId, arrayListA1);
        StoreMessageAck storeMessageAck = this.this$0.this$0;
        k kVar = new k(new StoreMessageAck$PendingAck(this.this$0.$channelId, storeMessageAck$Ack));
        m.checkNotNullExpressionValue(kVar, "Observable.just(PendingAck(channelId, ack))");
        StoreMessageAck.access$postPendingAck(storeMessageAck, kVar, iProcessMarkUnread$app_productionGoogleRelease);
    }
}
