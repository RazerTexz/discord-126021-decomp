package com.discord.utilities.rest;

import com.lytefast.flexinput.model.Attachment;
import d0.f0.k;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.e;
import d0.w.i.a.j;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.rest.SendUtils$uniqueifyNames$1", f = "SendUtils.kt", l = {204, 206}, m = "invokeSuspend")
public final class SendUtils$uniqueifyNames$1 extends j implements Function2<k<? super Attachment<? extends Object>>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List $attachmentParts;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils$uniqueifyNames$1(List list, Continuation continuation) {
        super(2, continuation);
        this.$attachmentParts = list;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        SendUtils$uniqueifyNames$1 sendUtils$uniqueifyNames$1 = new SendUtils$uniqueifyNames$1(this.$attachmentParts, continuation);
        sendUtils$uniqueifyNames$1.L$0 = obj;
        return sendUtils$uniqueifyNames$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k<? super Attachment<? extends Object>> kVar, Continuation<? super Unit> continuation) {
        return ((SendUtils$uniqueifyNames$1) create(kVar, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        k kVar;
        Map map;
        Iterator it;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            k kVar2 = (k) this.L$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            kVar = kVar2;
            map = linkedHashMap;
            it = this.$attachmentParts.iterator();
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$2;
            map = (Map) this.L$1;
            kVar = (k) this.L$0;
            l.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Attachment attachment = (Attachment) it.next();
            Object objBoxInt = map.get(attachment.getDisplayName());
            if (objBoxInt == null) {
                objBoxInt = b.boxInt(0);
            }
            int iIntValue = ((Number) objBoxInt).intValue();
            map.put(attachment.getDisplayName(), b.boxInt(iIntValue + 1));
            if (iIntValue == 0) {
                this.L$0 = kVar;
                this.L$1 = map;
                this.L$2 = it;
                this.label = 1;
                if (kVar.yield(attachment, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Attachment attachmentRenamedWithDuplicateCount = SendUtils.INSTANCE.renamedWithDuplicateCount(attachment, iIntValue);
                this.L$0 = kVar;
                this.L$1 = map;
                this.L$2 = it;
                this.label = 2;
                if (kVar.yield(attachmentRenamedWithDuplicateCount, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.a;
    }
}
