package b.i.a.c.e3.b0;

import androidx.annotation.Nullable;
import b.i.b.a.Charsets;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.n, reason: use source file name */
/* JADX INFO: compiled from: DefaultContentMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultContentMetadata implements ContentMetadata2 {
    public static final DefaultContentMetadata a = new DefaultContentMetadata(Collections.emptyMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f936b;
    public final Map<String, byte[]> c;

    public DefaultContentMetadata() {
        this(Collections.emptyMap());
    }

    public static boolean b(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public DefaultContentMetadata a(ContentMetadataMutations contentMetadataMutations) {
        byte[] bytes;
        HashMap map = new HashMap(this.c);
        Objects.requireNonNull(contentMetadataMutations);
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(contentMetadataMutations.f935b));
        for (int i = 0; i < listUnmodifiableList.size(); i++) {
            map.remove(listUnmodifiableList.get(i));
        }
        HashMap map2 = new HashMap(contentMetadataMutations.a);
        for (Map.Entry entry : map2.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        for (Map.Entry entry2 : Collections.unmodifiableMap(map2).entrySet()) {
            String str = (String) entry2.getKey();
            Object value2 = entry2.getValue();
            if (value2 instanceof Long) {
                bytes = ByteBuffer.allocate(8).putLong(((Long) value2).longValue()).array();
            } else if (value2 instanceof String) {
                bytes = ((String) value2).getBytes(Charsets.c);
            } else {
                if (!(value2 instanceof byte[])) {
                    throw new IllegalArgumentException();
                }
                bytes = (byte[]) value2;
            }
            map.put(str, bytes);
        }
        return b(this.c, map) ? this : new DefaultContentMetadata(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return b(this.c, ((DefaultContentMetadata) obj).c);
    }

    public int hashCode() {
        if (this.f936b == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.c.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f936b = iHashCode;
        }
        return this.f936b;
    }

    public DefaultContentMetadata(Map<String, byte[]> map) {
        this.c = Collections.unmodifiableMap(map);
    }
}
