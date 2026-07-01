package b.i.a.b.j.q;

import android.content.Context;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.a.b.j.v.Clock3;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.q.c, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CreationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CreationContext extends CreationContext {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Clock3 f773b;
    public final Clock3 c;
    public final String d;

    public AutoValue_CreationContext(Context context, Clock3 clock3, Clock3 clock4, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(clock3, "Null wallClock");
        this.f773b = clock3;
        Objects.requireNonNull(clock4, "Null monotonicClock");
        this.c = clock4;
        Objects.requireNonNull(str, "Null backendName");
        this.d = str;
    }

    @Override // b.i.a.b.j.q.CreationContext
    public Context a() {
        return this.a;
    }

    @Override // b.i.a.b.j.q.CreationContext
    @NonNull
    public String b() {
        return this.d;
    }

    @Override // b.i.a.b.j.q.CreationContext
    public Clock3 c() {
        return this.c;
    }

    @Override // b.i.a.b.j.q.CreationContext
    public Clock3 d() {
        return this.f773b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        return this.a.equals(creationContext.a()) && this.f773b.equals(creationContext.d()) && this.c.equals(creationContext.c()) && this.d.equals(creationContext.b());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f773b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("CreationContext{applicationContext=");
        sbU.append(this.a);
        sbU.append(", wallClock=");
        sbU.append(this.f773b);
        sbU.append(", monotonicClock=");
        sbU.append(this.c);
        sbU.append(", backendName=");
        return outline.J(sbU, this.d, "}");
    }
}
