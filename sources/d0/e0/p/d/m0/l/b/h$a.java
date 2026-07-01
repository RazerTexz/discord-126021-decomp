package d0.e0.p.d.m0.l.b;

/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a {
    public final d0.e0.p.d.m0.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f3501b;

    public h$a(d0.e0.p.d.m0.g.a aVar, f fVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        this.a = aVar;
        this.f3501b = fVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof h$a) && d0.z.d.m.areEqual(this.a, ((h$a) obj).a);
    }

    public final f getClassData() {
        return this.f3501b;
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
