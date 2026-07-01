package com.discord.models.domain;

import com.discord.api.message.Message;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ModelSearchResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSearchResponse$hits$2 extends o implements Function0<List<? extends Message>> {
    public final /* synthetic */ ModelSearchResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelSearchResponse$hits$2(ModelSearchResponse modelSearchResponse) {
        super(0);
        this.this$0 = modelSearchResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Message> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Message> invoke2() {
        Object next;
        Boolean hit;
        List<List<Message>> messages = this.this$0.getMessages();
        if (messages != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    hit = ((Message) next).getHit();
                } while (!(hit != null ? hit.booleanValue() : false));
                Message message = (Message) next;
                if (message != null) {
                    arrayList.add(message);
                }
            }
            List<? extends Message> list = u.toList(arrayList);
            if (list != null) {
                return list;
            }
        }
        return n.emptyList();
    }
}
