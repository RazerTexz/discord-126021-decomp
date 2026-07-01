package b.a.t.a;

import b.d.b.a.outline;
import com.discord.simpleast.core.node.StyleNode;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.t.a.f, reason: use source file name */
/* JADX INFO: compiled from: CodeStyleProviders.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeStyleProviders<R> {
    public final StyleNode.a<R> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StyleNode.a<R> f291b;
    public final StyleNode.a<R> c;
    public final StyleNode.a<R> d;
    public final StyleNode.a<R> e;
    public final StyleNode.a<R> f;
    public final StyleNode.a<R> g;
    public final StyleNode.a<R> h;

    public CodeStyleProviders(StyleNode.a<R> aVar, StyleNode.a<R> aVar2, StyleNode.a<R> aVar3, StyleNode.a<R> aVar4, StyleNode.a<R> aVar5, StyleNode.a<R> aVar6, StyleNode.a<R> aVar7, StyleNode.a<R> aVar8) {
        Intrinsics3.checkNotNullParameter(aVar, "defaultStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar2, "commentStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar3, "literalStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar4, "keywordStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar5, "identifierStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar6, "typesStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar7, "genericsStyleProvider");
        Intrinsics3.checkNotNullParameter(aVar8, "paramsStyleProvider");
        this.a = aVar;
        this.f291b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeStyleProviders)) {
            return false;
        }
        CodeStyleProviders codeStyleProviders = (CodeStyleProviders) obj;
        return Intrinsics3.areEqual(this.a, codeStyleProviders.a) && Intrinsics3.areEqual(this.f291b, codeStyleProviders.f291b) && Intrinsics3.areEqual(this.c, codeStyleProviders.c) && Intrinsics3.areEqual(this.d, codeStyleProviders.d) && Intrinsics3.areEqual(this.e, codeStyleProviders.e) && Intrinsics3.areEqual(this.f, codeStyleProviders.f) && Intrinsics3.areEqual(this.g, codeStyleProviders.g) && Intrinsics3.areEqual(this.h, codeStyleProviders.h);
    }

    public int hashCode() {
        StyleNode.a<R> aVar = this.a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        StyleNode.a<R> aVar2 = this.f291b;
        int iHashCode2 = (iHashCode + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar3 = this.c;
        int iHashCode3 = (iHashCode2 + (aVar3 != null ? aVar3.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar4 = this.d;
        int iHashCode4 = (iHashCode3 + (aVar4 != null ? aVar4.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar5 = this.e;
        int iHashCode5 = (iHashCode4 + (aVar5 != null ? aVar5.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar6 = this.f;
        int iHashCode6 = (iHashCode5 + (aVar6 != null ? aVar6.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar7 = this.g;
        int iHashCode7 = (iHashCode6 + (aVar7 != null ? aVar7.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar8 = this.h;
        return iHashCode7 + (aVar8 != null ? aVar8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CodeStyleProviders(defaultStyleProvider=");
        sbU.append(this.a);
        sbU.append(", commentStyleProvider=");
        sbU.append(this.f291b);
        sbU.append(", literalStyleProvider=");
        sbU.append(this.c);
        sbU.append(", keywordStyleProvider=");
        sbU.append(this.d);
        sbU.append(", identifierStyleProvider=");
        sbU.append(this.e);
        sbU.append(", typesStyleProvider=");
        sbU.append(this.f);
        sbU.append(", genericsStyleProvider=");
        sbU.append(this.g);
        sbU.append(", paramsStyleProvider=");
        sbU.append(this.h);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CodeStyleProviders() {
        CodeStyleProviders2 codeStyleProviders2 = CodeStyleProviders2.a;
        this(codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2);
    }
}
