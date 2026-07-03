package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.StyleNode;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.a.f */
/* JADX INFO: compiled from: CodeStyleProviders.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1280f<R> {

    /* JADX INFO: renamed from: a */
    public final StyleNode.InterfaceC5656a<R> f1906a;

    /* JADX INFO: renamed from: b */
    public final StyleNode.InterfaceC5656a<R> f1907b;

    /* JADX INFO: renamed from: c */
    public final StyleNode.InterfaceC5656a<R> f1908c;

    /* JADX INFO: renamed from: d */
    public final StyleNode.InterfaceC5656a<R> f1909d;

    /* JADX INFO: renamed from: e */
    public final StyleNode.InterfaceC5656a<R> f1910e;

    /* JADX INFO: renamed from: f */
    public final StyleNode.InterfaceC5656a<R> f1911f;

    /* JADX INFO: renamed from: g */
    public final StyleNode.InterfaceC5656a<R> f1912g;

    /* JADX INFO: renamed from: h */
    public final StyleNode.InterfaceC5656a<R> f1913h;

    public C1280f(StyleNode.InterfaceC5656a<R> interfaceC5656a, StyleNode.InterfaceC5656a<R> interfaceC5656a2, StyleNode.InterfaceC5656a<R> interfaceC5656a3, StyleNode.InterfaceC5656a<R> interfaceC5656a4, StyleNode.InterfaceC5656a<R> interfaceC5656a5, StyleNode.InterfaceC5656a<R> interfaceC5656a6, StyleNode.InterfaceC5656a<R> interfaceC5656a7, StyleNode.InterfaceC5656a<R> interfaceC5656a8) {
        C12238m.checkNotNullParameter(interfaceC5656a, "defaultStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a2, "commentStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a3, "literalStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a4, "keywordStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a5, "identifierStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a6, "typesStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a7, "genericsStyleProvider");
        C12238m.checkNotNullParameter(interfaceC5656a8, "paramsStyleProvider");
        this.f1906a = interfaceC5656a;
        this.f1907b = interfaceC5656a2;
        this.f1908c = interfaceC5656a3;
        this.f1909d = interfaceC5656a4;
        this.f1910e = interfaceC5656a5;
        this.f1911f = interfaceC5656a6;
        this.f1912g = interfaceC5656a7;
        this.f1913h = interfaceC5656a8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1280f)) {
            return false;
        }
        C1280f c1280f = (C1280f) obj;
        return C12238m.areEqual(this.f1906a, c1280f.f1906a) && C12238m.areEqual(this.f1907b, c1280f.f1907b) && C12238m.areEqual(this.f1908c, c1280f.f1908c) && C12238m.areEqual(this.f1909d, c1280f.f1909d) && C12238m.areEqual(this.f1910e, c1280f.f1910e) && C12238m.areEqual(this.f1911f, c1280f.f1911f) && C12238m.areEqual(this.f1912g, c1280f.f1912g) && C12238m.areEqual(this.f1913h, c1280f.f1913h);
    }

    public int hashCode() {
        StyleNode.InterfaceC5656a<R> interfaceC5656a = this.f1906a;
        int iHashCode = (interfaceC5656a != null ? interfaceC5656a.hashCode() : 0) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a2 = this.f1907b;
        int iHashCode2 = (iHashCode + (interfaceC5656a2 != null ? interfaceC5656a2.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a3 = this.f1908c;
        int iHashCode3 = (iHashCode2 + (interfaceC5656a3 != null ? interfaceC5656a3.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a4 = this.f1909d;
        int iHashCode4 = (iHashCode3 + (interfaceC5656a4 != null ? interfaceC5656a4.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a5 = this.f1910e;
        int iHashCode5 = (iHashCode4 + (interfaceC5656a5 != null ? interfaceC5656a5.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a6 = this.f1911f;
        int iHashCode6 = (iHashCode5 + (interfaceC5656a6 != null ? interfaceC5656a6.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a7 = this.f1912g;
        int iHashCode7 = (iHashCode6 + (interfaceC5656a7 != null ? interfaceC5656a7.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a8 = this.f1913h;
        return iHashCode7 + (interfaceC5656a8 != null ? interfaceC5656a8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CodeStyleProviders(defaultStyleProvider=");
        sbM833U.append(this.f1906a);
        sbM833U.append(", commentStyleProvider=");
        sbM833U.append(this.f1907b);
        sbM833U.append(", literalStyleProvider=");
        sbM833U.append(this.f1908c);
        sbM833U.append(", keywordStyleProvider=");
        sbM833U.append(this.f1909d);
        sbM833U.append(", identifierStyleProvider=");
        sbM833U.append(this.f1910e);
        sbM833U.append(", typesStyleProvider=");
        sbM833U.append(this.f1911f);
        sbM833U.append(", genericsStyleProvider=");
        sbM833U.append(this.f1912g);
        sbM833U.append(", paramsStyleProvider=");
        sbM833U.append(this.f1913h);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1280f() {
        C1281g c1281g = C1281g.f1914a;
        this(c1281g, c1281g, c1281g, c1281g, c1281g, c1281g, c1281g, c1281g);
    }
}
