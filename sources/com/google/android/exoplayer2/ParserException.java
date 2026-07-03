package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ParserException extends IOException {
    public final boolean contentIsMalformed;
    public final int dataType;

    public ParserException(@Nullable String str, @Nullable Throwable th, boolean z2, int i) {
        super(str, th);
        this.contentIsMalformed = z2;
        this.dataType = i;
    }

    /* JADX INFO: renamed from: a */
    public static ParserException m8755a(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 1);
    }

    /* JADX INFO: renamed from: b */
    public static ParserException m8756b(@Nullable String str) {
        return new ParserException(str, null, false, 1);
    }
}
