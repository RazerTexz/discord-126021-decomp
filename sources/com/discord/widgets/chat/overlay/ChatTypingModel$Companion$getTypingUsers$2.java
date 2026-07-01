package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingUsers$2<T, R> implements b<List<? extends String>, List<? extends CharSequence>> {
    public static final ChatTypingModel$Companion$getTypingUsers$2 INSTANCE = new ChatTypingModel$Companion$getTypingUsers$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends CharSequence> call(List<? extends String> list) {
        return call2((List<String>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<CharSequence> call2(List<String> list) {
        m.checkNotNullExpressionValue(list, "names");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b.a.k.b.l(a.y("!!", (String) it.next(), "!!"), new Object[0], null, 2));
        }
        return u.take(arrayList, 4);
    }
}
