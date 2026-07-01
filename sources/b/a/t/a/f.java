package b.a.t.a;

import com.discord.simpleast.core.node.StyleNode$a;

/* JADX INFO: compiled from: CodeStyleProviders.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f<R> {
    public final StyleNode$a<R> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StyleNode$a<R> f291b;
    public final StyleNode$a<R> c;
    public final StyleNode$a<R> d;
    public final StyleNode$a<R> e;
    public final StyleNode$a<R> f;
    public final StyleNode$a<R> g;
    public final StyleNode$a<R> h;

    public f(StyleNode$a<R> styleNode$a, StyleNode$a<R> styleNode$a2, StyleNode$a<R> styleNode$a3, StyleNode$a<R> styleNode$a4, StyleNode$a<R> styleNode$a5, StyleNode$a<R> styleNode$a6, StyleNode$a<R> styleNode$a7, StyleNode$a<R> styleNode$a8) {
        d0.z.d.m.checkNotNullParameter(styleNode$a, "defaultStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a2, "commentStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a3, "literalStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a4, "keywordStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a5, "identifierStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a6, "typesStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a7, "genericsStyleProvider");
        d0.z.d.m.checkNotNullParameter(styleNode$a8, "paramsStyleProvider");
        this.a = styleNode$a;
        this.f291b = styleNode$a2;
        this.c = styleNode$a3;
        this.d = styleNode$a4;
        this.e = styleNode$a5;
        this.f = styleNode$a6;
        this.g = styleNode$a7;
        this.h = styleNode$a8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return d0.z.d.m.areEqual(this.a, fVar.a) && d0.z.d.m.areEqual(this.f291b, fVar.f291b) && d0.z.d.m.areEqual(this.c, fVar.c) && d0.z.d.m.areEqual(this.d, fVar.d) && d0.z.d.m.areEqual(this.e, fVar.e) && d0.z.d.m.areEqual(this.f, fVar.f) && d0.z.d.m.areEqual(this.g, fVar.g) && d0.z.d.m.areEqual(this.h, fVar.h);
    }

    public int hashCode() {
        StyleNode$a<R> styleNode$a = this.a;
        int iHashCode = (styleNode$a != null ? styleNode$a.hashCode() : 0) * 31;
        StyleNode$a<R> styleNode$a2 = this.f291b;
        int iHashCode2 = (iHashCode + (styleNode$a2 != null ? styleNode$a2.hashCode() : 0)) * 31;
        StyleNode$a<R> styleNode$a3 = this.c;
        int iHashCode3 = (iHashCode2 + (styleNode$a3 != null ? styleNode$a3.hashCode() : 0)) * 31;
        StyleNode$a<R> styleNode$a4 = this.d;
        int iHashCode4 = (iHashCode3 + (styleNode$a4 != null ? styleNode$a4.hashCode() : 0)) * 31;
        StyleNode$a<R> styleNode$a5 = this.e;
        int iHashCode5 = (iHashCode4 + (styleNode$a5 != null ? styleNode$a5.hashCode() : 0)) * 31;
        StyleNode$a<R> styleNode$a6 = this.f;
        int iHashCode6 = (iHashCode5 + (styleNode$a6 != null ? styleNode$a6.hashCode() : 0)) * 31;
        StyleNode$a<R> styleNode$a7 = this.g;
        int iHashCode7 = (iHashCode6 + (styleNode$a7 != null ? styleNode$a7.hashCode() : 0)) * 31;
        StyleNode$a<R> styleNode$a8 = this.h;
        return iHashCode7 + (styleNode$a8 != null ? styleNode$a8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CodeStyleProviders(defaultStyleProvider=");
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
    public f() {
        g gVar = g.a;
        this(gVar, gVar, gVar, gVar, gVar, gVar, gVar, gVar);
    }
}
