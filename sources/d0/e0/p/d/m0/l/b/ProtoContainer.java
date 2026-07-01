package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y, reason: use source file name */
/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ProtoContainer {
    public final NameResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeTable f3510b;
    public final SourceElement c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y$a */
    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class a extends ProtoContainer {
        public final d0.e0.p.d.m0.f.c d;
        public final a e;
        public final ClassId f;
        public final c.EnumC0397c g;
        public final boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0.e0.p.d.m0.f.c cVar, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, a aVar) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics3.checkNotNullParameter(cVar, "classProto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
            this.d = cVar;
            this.e = aVar;
            this.f = NameResolverUtil.getClassId(nameResolver, cVar.getFqName());
            c.EnumC0397c enumC0397c = Flags2.e.get(cVar.getFlags());
            this.g = enumC0397c == null ? c.EnumC0397c.CLASS : enumC0397c;
            Boolean bool = Flags2.f.get(cVar.getFlags());
            Intrinsics3.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
            this.h = bool.booleanValue();
        }

        @Override // d0.e0.p.d.m0.l.b.ProtoContainer
        public FqName debugFqName() {
            FqName fqNameAsSingleFqName = this.f.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "classId.asSingleFqName()");
            return fqNameAsSingleFqName;
        }

        public final ClassId getClassId() {
            return this.f;
        }

        public final d0.e0.p.d.m0.f.c getClassProto() {
            return this.d;
        }

        public final c.EnumC0397c getKind() {
            return this.g;
        }

        public final a getOuterClass() {
            return this.e;
        }

        public final boolean isInner() {
            return this.h;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y$b */
    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class b extends ProtoContainer {
        public final FqName d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FqName fqName, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
            this.d = fqName;
        }

        @Override // d0.e0.p.d.m0.l.b.ProtoContainer
        public FqName debugFqName() {
            return this.d;
        }
    }

    public ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = nameResolver;
        this.f3510b = typeTable;
        this.c = sourceElement;
    }

    public abstract FqName debugFqName();

    public final NameResolver getNameResolver() {
        return this.a;
    }

    public final SourceElement getSource() {
        return this.c;
    }

    public final TypeTable getTypeTable() {
        return this.f3510b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + debugFqName();
    }
}
