package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$dispatchSubscribe$2<T> extends o implements Function1<List<? extends T>, Unit> {
    public final /* synthetic */ Function1 $onNext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$dispatchSubscribe$2(Function1 function1) {
        super(1);
        this.$onNext = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((List) obj);
        return Unit.a;
    }

    public final void invoke(List<? extends T> list) {
        m.checkNotNullParameter(list, "batch");
        Iterator<? extends T> it = list.iterator();
        while (it.hasNext()) {
            this.$onNext.invoke(it.next());
        }
    }
}
