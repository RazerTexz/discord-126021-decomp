package com.google.android.exoplayer2.drm;

import b.d.b.a.a;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDrmSessionManager$MissingSchemeDataException extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultDrmSessionManager$MissingSchemeDataException(UUID uuid, DefaultDrmSessionManager$a defaultDrmSessionManager$a) {
        String strValueOf = String.valueOf(uuid);
        super(a.j(strValueOf.length() + 29, "Media does not support uuid: ", strValueOf));
    }
}
