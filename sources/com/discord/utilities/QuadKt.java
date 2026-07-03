package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Quad.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QuadKt {
    public static final <T> List<T> toList(Quad<? extends T, ? extends T, ? extends T, ? extends T> quad) {
        C12238m.checkNotNullParameter(quad, "$this$toList");
        return C12147n.listOf(quad.getFirst(), quad.getSecond(), quad.getThird(), quad.getFourth());
    }
}
