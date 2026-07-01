package org.webrtc;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class MediaConstraints$KeyValuePair {
    private final String key;
    private final String value;

    public MediaConstraints$KeyValuePair(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaConstraints$KeyValuePair mediaConstraints$KeyValuePair = (MediaConstraints$KeyValuePair) obj;
        return this.key.equals(mediaConstraints$KeyValuePair.key) && this.value.equals(mediaConstraints$KeyValuePair.value);
    }

    @CalledByNative("KeyValuePair")
    public String getKey() {
        return this.key;
    }

    @CalledByNative("KeyValuePair")
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + this.key.hashCode();
    }

    public String toString() {
        return this.key + ": " + this.value;
    }
}
