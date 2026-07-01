package com.discord.utilities.file;

import d0.z.d.m;

/* JADX INFO: compiled from: DownloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtils$DownloadState$Failure extends DownloadUtils$DownloadState {
    private final Exception exception;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadUtils$DownloadState$Failure(Exception exc) {
        super(null);
        m.checkNotNullParameter(exc, "exception");
        this.exception = exc;
    }

    public final Exception getException() {
        return this.exception;
    }
}
