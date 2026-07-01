package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$observeForumPostFirstMessages$1 extends o implements Function0<Map<Long, ? extends Message>> {
    public final /* synthetic */ StoreForumPostMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$observeForumPostFirstMessages$1(StoreForumPostMessages storeForumPostMessages) {
        super(0);
        this.this$0 = storeForumPostMessages;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Message> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Message> invoke2() {
        return StoreForumPostMessages.access$getForumPostFirstMessageSnapshot$p(this.this$0);
    }
}
