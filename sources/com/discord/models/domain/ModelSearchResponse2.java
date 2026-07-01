package com.discord.models.domain;

import com.discord.api.message.Message;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.models.domain.ModelSearchResponse$hits$2, reason: use source file name */
/* JADX INFO: compiled from: ModelSearchResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSearchResponse2 extends Lambda implements Function0<List<? extends Message>> {
    public final /* synthetic */ ModelSearchResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelSearchResponse2(ModelSearchResponse modelSearchResponse) {
        super(0);
        this.this$0 = modelSearchResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Message> invoke() {
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
            List<? extends Message> list = _Collections.toList(arrayList);
            if (list != null) {
                return list;
            }
        }
        return Collections2.emptyList();
    }
}
