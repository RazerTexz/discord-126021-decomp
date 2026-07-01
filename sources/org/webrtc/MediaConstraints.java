package org.webrtc;

import b.d.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MediaConstraints {
    public final List<MediaConstraints$KeyValuePair> mandatory = new ArrayList();
    public final List<MediaConstraints$KeyValuePair> optional = new ArrayList();

    private static String stringifyKeyValuePairList(List<MediaConstraints$KeyValuePair> list) {
        StringBuilder sb = new StringBuilder("[");
        for (MediaConstraints$KeyValuePair mediaConstraints$KeyValuePair : list) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(mediaConstraints$KeyValuePair.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @CalledByNative
    public List<MediaConstraints$KeyValuePair> getMandatory() {
        return this.mandatory;
    }

    @CalledByNative
    public List<MediaConstraints$KeyValuePair> getOptional() {
        return this.optional;
    }

    public String toString() {
        StringBuilder sbU = a.U("mandatory: ");
        sbU.append(stringifyKeyValuePairList(this.mandatory));
        sbU.append(", optional: ");
        sbU.append(stringifyKeyValuePairList(this.optional));
        return sbU.toString();
    }
}
