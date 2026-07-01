package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$buildUsableEmojiSet$4<T> extends o implements Function2<Map<T, Integer>, T, Unit> {
    public static final StoreEmoji$buildUsableEmojiSet$4 INSTANCE = new StoreEmoji$buildUsableEmojiSet$4();

    public StoreEmoji$buildUsableEmojiSet$4() {
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((Map<Object, Integer>) obj, obj2);
        return Unit.a;
    }

    public final <T> void invoke(Map<T, Integer> map, T t) {
        m.checkNotNullParameter(map, "$this$increment");
        Integer num = map.get(t);
        map.put(t, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }
}
