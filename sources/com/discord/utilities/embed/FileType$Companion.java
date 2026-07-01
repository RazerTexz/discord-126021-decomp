package com.discord.utilities.embed;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileType$Companion {
    private FileType$Companion() {
    }

    public final FileType getFromExtension(String extension) {
        m.checkNotNullParameter(extension, "extension");
        FileType[] fileTypeArrValues = FileType.values();
        for (int i = 0; i < 10; i++) {
            FileType fileType = fileTypeArrValues[i];
            if (FileType.access$matches(fileType, extension)) {
                return fileType;
            }
        }
        return null;
    }

    public /* synthetic */ FileType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
