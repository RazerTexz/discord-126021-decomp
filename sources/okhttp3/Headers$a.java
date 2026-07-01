package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Headers$a {
    public final List<String> a = new ArrayList(20);

    public final Headers$a a(String str, String str2) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        Headers$b headers$b = Headers.j;
        headers$b.a(str);
        headers$b.b(str2, str);
        b(str, str2);
        return this;
    }

    public final Headers$a b(String str, String str2) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        this.a.add(str);
        this.a.add(w.trim(str2).toString());
        return this;
    }

    public final Headers c() {
        Object[] array = this.a.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final Headers$a d(String str) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i = 0;
        while (i < this.a.size()) {
            if (t.equals(str, this.a.get(i), true)) {
                this.a.remove(i);
                this.a.remove(i);
                i -= 2;
            }
            i += 2;
        }
        return this;
    }
}
