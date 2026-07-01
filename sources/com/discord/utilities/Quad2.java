package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: com.discord.utilities.QuadKt, reason: use source file name */
/* JADX INFO: compiled from: Quad.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Quad2 {
    public static final <T> List<T> toList(Quad<? extends T, ? extends T, ? extends T, ? extends T> quad) {
        Intrinsics3.checkNotNullParameter(quad, "$this$toList");
        return Collections2.listOf(quad.getFirst(), quad.getSecond(), quad.getThird(), quad.getFourth());
    }
}
