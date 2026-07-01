package b.i.b.a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.a.g, reason: use source file name */
/* JADX INFO: compiled from: MoreObjects.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MoreObjects2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1643b;
    public a c;

    /* JADX INFO: renamed from: b.i.b.a.g$a */
    /* JADX INFO: compiled from: MoreObjects.java */
    public static final class a {

        @NullableDecl
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NullableDecl
        public Object f1644b;

        @NullableDecl
        public a c;

        public a(MoreObjects moreObjects) {
        }
    }

    public MoreObjects2(String str, MoreObjects moreObjects) {
        a aVar = new a(null);
        this.f1643b = aVar;
        this.c = aVar;
        this.a = str;
    }

    @CanIgnoreReturnValue
    public MoreObjects2 a(String str, int i) {
        String strValueOf = String.valueOf(i);
        a aVar = new a(null);
        this.c.c = aVar;
        this.c = aVar;
        aVar.f1644b = strValueOf;
        aVar.a = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        a aVar = this.f1643b.c;
        String str = "";
        while (aVar != null) {
            Object obj = aVar.f1644b;
            sb.append(str);
            String str2 = aVar.a;
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
            aVar = aVar.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
