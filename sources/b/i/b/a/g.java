package b.i.b.a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

/* JADX INFO: compiled from: MoreObjects.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g$a f1643b;
    public g$a c;

    public g(String str, f fVar) {
        g$a g_a = new g$a(null);
        this.f1643b = g_a;
        this.c = g_a;
        this.a = str;
    }

    @CanIgnoreReturnValue
    public g a(String str, int i) {
        String strValueOf = String.valueOf(i);
        g$a g_a = new g$a(null);
        this.c.c = g_a;
        this.c = g_a;
        g_a.f1644b = strValueOf;
        g_a.a = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        g$a g_a = this.f1643b.c;
        String str = "";
        while (g_a != null) {
            Object obj = g_a.f1644b;
            sb.append(str);
            String str2 = g_a.a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            g_a = g_a.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
