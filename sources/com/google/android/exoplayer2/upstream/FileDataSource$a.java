package com.google.android.exoplayer2.upstream;

import android.system.ErrnoException;
import android.system.OsConstants;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class FileDataSource$a {
    public static /* synthetic */ boolean a(Throwable th) {
        return b(th);
    }

    @DoNotInline
    private static boolean b(@Nullable Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
