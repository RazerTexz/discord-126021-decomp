package com.discord.stores;

import com.discord.utilities.message.MessageUtils;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$getPendingAck$1 extends o implements Function2<StoreMessageAck$Ack, Long, Boolean> {
    public final /* synthetic */ boolean $clearLock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$getPendingAck$1(boolean z2) {
        super(2);
        this.$clearLock = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(StoreMessageAck$Ack storeMessageAck$Ack, Long l) {
        return Boolean.valueOf(invoke(storeMessageAck$Ack, l.longValue()));
    }

    public final boolean invoke(StoreMessageAck$Ack storeMessageAck$Ack, long j) {
        boolean zIsNewer = MessageUtils.isNewer(storeMessageAck$Ack != null ? Long.valueOf(storeMessageAck$Ack.getMessageId()) : null, Long.valueOf(j));
        boolean z2 = storeMessageAck$Ack == null || !storeMessageAck$Ack.isLockedAck();
        if (zIsNewer) {
            return this.$clearLock || z2;
        }
        return false;
    }
}
