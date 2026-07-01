package com.facebook.common.file;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils$CreateDirectoryException extends IOException {
    public FileUtils$CreateDirectoryException(String str) {
        super(str);
    }

    public FileUtils$CreateDirectoryException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
