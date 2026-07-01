package com.discord.utilities.file;

import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: DownloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtils$DownloadState$Completed extends DownloadUtils$DownloadState {
    private final File file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadUtils$DownloadState$Completed(File file) {
        super(null);
        m.checkNotNullParameter(file, "file");
        this.file = file;
    }

    public final File getFile() {
        return this.file;
    }
}
