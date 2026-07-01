package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.d.b.a.a;
import b.i.a.c.a3.y;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class ExoPlaybackException extends PlaybackException {
    public final boolean isRecoverable;

    @Nullable
    public final y mediaPeriodId;

    @Nullable
    public final j1 rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @Nullable
    public final String rendererName;
    public final int type;

    public ExoPlaybackException(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    public static ExoPlaybackException b(RuntimeException runtimeException, int i) {
        return new ExoPlaybackException(2, runtimeException, i);
    }

    @CheckResult
    public ExoPlaybackException a(@Nullable y yVar) {
        String message = getMessage();
        int i = e0.a;
        return new ExoPlaybackException(message, getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, yVar, this.timestampMs, this.isRecoverable);
    }

    public ExoPlaybackException(String str, @Nullable Throwable th, int i, int i2, @Nullable String str2, int i3, @Nullable j1 j1Var, int i4, @Nullable y yVar, long j, boolean z2) {
        super(str, th, i, j);
        d.j(!z2 || i2 == 1);
        d.j(th != null || i2 == 3);
        this.type = i2;
        this.rendererName = str2;
        this.rendererIndex = i3;
        this.rendererFormat = j1Var;
        this.rendererFormatSupport = i4;
        this.mediaPeriodId = yVar;
        this.isRecoverable = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExoPlaybackException(int i, @Nullable Throwable th, @Nullable String str, int i2, @Nullable String str2, int i3, @Nullable j1 j1Var, int i4, boolean z2) {
        String strK;
        String str3;
        if (i == 0) {
            strK = "Source error";
        } else if (i != 1) {
            strK = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            String strValueOf = String.valueOf(j1Var);
            int i5 = e0.a;
            if (i4 == 0) {
                str3 = "NO";
            } else if (i4 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str3 = "YES";
            }
            StringBuilder sb = new StringBuilder(str3.length() + strValueOf.length() + a.b(str2, 53));
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i3);
            sb.append(", format=");
            strK = a.K(sb, strValueOf, ", format_supported=", str3);
        }
        if (!TextUtils.isEmpty(null)) {
            String strValueOf2 = String.valueOf(strK);
            strK = a.k("null".length() + strValueOf2.length() + 2, strValueOf2, ": ", null);
        }
        this(strK, th, i2, i, str2, i3, j1Var, i4, null, SystemClock.elapsedRealtime(), z2);
    }
}
