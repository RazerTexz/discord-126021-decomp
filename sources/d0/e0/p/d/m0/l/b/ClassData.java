package d0.e0.p.d.m0.l.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.f, reason: use source file name */
/* JADX INFO: compiled from: ClassData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassData {
    public final NameResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.c f3499b;
    public final BinaryVersion c;
    public final SourceElement d;

    public ClassData(NameResolver nameResolver, d0.e0.p.d.m0.f.c cVar, BinaryVersion binaryVersion, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(cVar, "classProto");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(sourceElement, "sourceElement");
        this.a = nameResolver;
        this.f3499b = cVar;
        this.c = binaryVersion;
        this.d = sourceElement;
    }

    public final NameResolver component1() {
        return this.a;
    }

    public final d0.e0.p.d.m0.f.c component2() {
        return this.f3499b;
    }

    public final BinaryVersion component3() {
        return this.c;
    }

    public final SourceElement component4() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics3.areEqual(this.a, classData.a) && Intrinsics3.areEqual(this.f3499b, classData.f3499b) && Intrinsics3.areEqual(this.c, classData.c) && Intrinsics3.areEqual(this.d, classData.d);
    }

    public int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.f3499b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ClassData(nameResolver=");
        sbU.append(this.a);
        sbU.append(", classProto=");
        sbU.append(this.f3499b);
        sbU.append(", metadataVersion=");
        sbU.append(this.c);
        sbU.append(", sourceElement=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }
}
