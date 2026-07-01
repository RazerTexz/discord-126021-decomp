package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: Quad.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QuadKt {
    public static final <T> List<T> toList(Quad<? extends T, ? extends T, ? extends T, ? extends T> quad) {
        m.checkNotNullParameter(quad, "$this$toList");
        return n.listOf(quad.getFirst(), quad.getSecond(), quad.getThird(), quad.getFourth());
    }
}
