package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$4 extends o implements Function4<Long, List<? extends Message>, Boolean, Boolean, Unit> {
    public final /* synthetic */ StoreMessagesLoader$tryLoadMessages$3 $loadMessages$3;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$4(StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader$tryLoadMessages$3 storeMessagesLoader$tryLoadMessages$3) {
        super(4);
        this.this$0 = storeMessagesLoader;
        this.$loadMessages$3 = storeMessagesLoader$tryLoadMessages$3;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Message> list, Boolean bool, Boolean bool2) {
        invoke(l.longValue(), (List<Message>) list, bool.booleanValue(), bool2.booleanValue());
        return Unit.a;
    }

    public final synchronized void invoke(long j, List<Message> list, boolean z2, boolean z3) {
        m.checkNotNullParameter(list, "messages");
        if (list.isEmpty()) {
            StoreMessagesLoader.access$channelLoadedStateUpdate(this.this$0, j, StoreMessagesLoader$tryLoadMessages$4$1.INSTANCE);
            return;
        }
        if (z2) {
            StoreMessagesLoader$tryLoadMessages$3.invoke$default(this.$loadMessages$3, j, null, Long.valueOf(list.get(0).getId()), null, 10, null);
        } else if (z3) {
            StoreMessagesLoader$tryLoadMessages$3.invoke$default(this.$loadMessages$3, j, null, null, Long.valueOf(list.get(list.size() - 1).getId()), 6, null);
        }
    }
}
