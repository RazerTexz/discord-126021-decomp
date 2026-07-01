package s.a.c2;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: s.a.c2.v, reason: use source file name */
/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Channel8<T> {
    public final Object a;

    /* JADX INFO: renamed from: s.a.c2.v$a */
    /* JADX INFO: compiled from: Channel.kt */
    public static final class a {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics3.areEqual(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Closed(");
            sbU.append(this.a);
            sbU.append(')');
            return sbU.toString();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Channel8) && Intrinsics3.areEqual(this.a, ((Channel8) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.a;
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }
}
