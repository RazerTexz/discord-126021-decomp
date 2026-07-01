package com.discord.widgets.chat.input;

import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendCommand$commandResendCompressedHandler$1$1 extends o implements Function1<List<? extends Attachment<?>>, Unit> {
    public final /* synthetic */ ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendCommand$commandResendCompressedHandler$1$1(ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 chatInputViewModel$sendCommand$commandResendCompressedHandler$1) {
        super(1);
        this.this$0 = chatInputViewModel$sendCommand$commandResendCompressedHandler$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Attachment<?>> list) {
        Object next;
        m.checkNotNullParameter(list, "compressedAttachments");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Unit unit = Unit.a;
            Object arrayList = linkedHashMap.get(unit);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(unit, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map$Entry map$Entry : this.this$0.$attachments.entrySet()) {
            Object key = map$Entry.getKey();
            Iterator<T> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                next = it.next();
            } while (!(((Attachment) next).getId() == ((Attachment) map$Entry.getValue()).getId()));
            linkedHashMap2.put(key, next);
        }
        ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 chatInputViewModel$sendCommand$commandResendCompressedHandler$1 = this.this$0;
        ChatInputViewModel.sendCommand$default(chatInputViewModel$sendCommand$commandResendCompressedHandler$1.this$0, chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$context, chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$messageManager, chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$applicationCommandData, linkedHashMap2, chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$autocomplete, true, null, 64, null);
    }
}
