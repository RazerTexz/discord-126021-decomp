package b.i.a.b.j.q;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_CreationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends h {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.v.a f773b;
    public final b.i.a.b.j.v.a c;
    public final String d;

    public c(Context context, b.i.a.b.j.v.a aVar, b.i.a.b.j.v.a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.f773b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.d = str;
    }

    @Override // b.i.a.b.j.q.h
    public Context a() {
        return this.a;
    }

    @Override // b.i.a.b.j.q.h
    @NonNull
    public String b() {
        return this.d;
    }

    @Override // b.i.a.b.j.q.h
    public b.i.a.b.j.v.a c() {
        return this.c;
    }

    @Override // b.i.a.b.j.q.h
    public b.i.a.b.j.v.a d() {
        return this.f773b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a()) && this.f773b.equals(hVar.d()) && this.c.equals(hVar.c()) && this.d.equals(hVar.b());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f773b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CreationContext{applicationContext=");
        sbU.append(this.a);
        sbU.append(", wallClock=");
        sbU.append(this.f773b);
        sbU.append(", monotonicClock=");
        sbU.append(this.c);
        sbU.append(", backendName=");
        return b.d.b.a.a.J(sbU, this.d, "}");
    }
}
