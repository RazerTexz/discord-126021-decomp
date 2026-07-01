package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class SessionDescription {
    public final String description;
    public final SessionDescription$Type type;

    @CalledByNative
    public SessionDescription(SessionDescription$Type sessionDescription$Type, String str) {
        this.type = sessionDescription$Type;
        this.description = str;
    }

    @CalledByNative
    public String getDescription() {
        return this.description;
    }

    @CalledByNative
    public String getTypeInCanonicalForm() {
        return this.type.canonicalForm();
    }
}
