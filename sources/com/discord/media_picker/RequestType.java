package com.discord.media_picker;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: RequestType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum RequestType {
    CAMERA,
    GALLERY,
    DOCUMENTS,
    CROP,
    CHOOSER;

    public static final RequestType$a Companion = new RequestType$a(null);

    public final int getCode$media_picker_release() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return 777;
        }
        if (iOrdinal == 1) {
            return 778;
        }
        if (iOrdinal == 2) {
            return 779;
        }
        if (iOrdinal == 3) {
            return 800;
        }
        if (iOrdinal == 4) {
            return 801;
        }
        throw new NoWhenBranchMatchedException();
    }
}
