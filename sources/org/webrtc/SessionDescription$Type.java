package org.webrtc;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public enum SessionDescription$Type {
    OFFER,
    PRANSWER,
    ANSWER,
    ROLLBACK;

    public String canonicalForm() {
        return name().toLowerCase(Locale.US);
    }
}
