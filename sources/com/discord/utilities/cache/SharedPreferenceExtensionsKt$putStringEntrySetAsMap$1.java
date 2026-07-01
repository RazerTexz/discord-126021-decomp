package com.discord.utilities.cache;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: SharedPreferenceExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1<V> extends o implements Function1<V, String> {
    public static final SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1 INSTANCE = new SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1();

    public SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1() {
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object obj) {
        return invoke2(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(V v) {
        return String.valueOf(v);
    }
}
