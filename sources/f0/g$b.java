package f0;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g$b)) {
            return false;
        }
        g$b g_b = (g$b) obj;
        Objects.requireNonNull(g_b);
        if (!d0.z.d.m.areEqual((Object) null, (Object) null)) {
            return false;
        }
        Objects.requireNonNull(g_b);
        if (!d0.z.d.m.areEqual((Object) null, (Object) null)) {
            return false;
        }
        Objects.requireNonNull(g_b);
        return !(d0.z.d.m.areEqual((Object) null, (Object) null) ^ true);
    }

    public int hashCode() {
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) null);
        sb.append(MentionUtilsKt.SLASH_CHAR);
        throw null;
    }
}
