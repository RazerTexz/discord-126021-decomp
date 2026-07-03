package p007b.p195g.p196a.p198b.p204t;

import java.io.IOException;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.InterfaceC2114j;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p200p.C2130j;

/* JADX INFO: renamed from: b.g.a.b.t.d */
/* JADX INFO: compiled from: DefaultPrettyPrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2142d implements InterfaceC2114j, InterfaceC2143e<C2142d>, Serializable {

    /* JADX INFO: renamed from: j */
    public static final C2130j f4599j = new C2130j(" ");
    private static final long serialVersionUID = 1;
    public b _arrayIndenter;
    public String _objectFieldValueSeparatorWithSpaces;
    public b _objectIndenter;
    public final InterfaceC2115k _rootSeparator;
    public C2148j _separators;
    public boolean _spacesInObjectEntries;

    /* JADX INFO: renamed from: k */
    public transient int f4600k;

    /* JADX INFO: renamed from: b.g.a.b.t.d$a */
    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public static class a extends c {

        /* JADX INFO: renamed from: j */
        public static final a f4601j = new a();

        @Override // p007b.p195g.p196a.p198b.p204t.C2142d.b
        /* JADX INFO: renamed from: a */
        public void mo1731a(AbstractC2108d abstractC2108d, int i) throws IOException {
            abstractC2108d.mo1640R(' ');
        }

        @Override // p007b.p195g.p196a.p198b.p204t.C2142d.c, p007b.p195g.p196a.p198b.p204t.C2142d.b
        public boolean isInline() {
            return true;
        }
    }

    /* JADX INFO: renamed from: b.g.a.b.t.d$b */
    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo1731a(AbstractC2108d abstractC2108d, int i) throws IOException;

        boolean isInline();
    }

    /* JADX INFO: renamed from: b.g.a.b.t.d$c */
    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public static class c implements b, Serializable {
        @Override // p007b.p195g.p196a.p198b.p204t.C2142d.b
        public boolean isInline() {
            return !(this instanceof C2141c);
        }
    }

    public C2142d() {
        C2130j c2130j = f4599j;
        this._arrayIndenter = a.f4601j;
        this._objectIndenter = C2141c.f4598k;
        this._spacesInObjectEntries = true;
        this._rootSeparator = c2130j;
        C2148j c2148j = InterfaceC2114j.f4519b;
        this._separators = c2148j;
        StringBuilder sbM833U = C1643a.m833U(" ");
        sbM833U.append(c2148j.m1738c());
        sbM833U.append(" ");
        this._objectFieldValueSeparatorWithSpaces = sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: a */
    public void mo1678a(AbstractC2108d abstractC2108d) throws IOException {
        abstractC2108d.mo1640R('{');
        if (this._objectIndenter.isInline()) {
            return;
        }
        this.f4600k++;
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: b */
    public void mo1679b(AbstractC2108d abstractC2108d) throws IOException {
        InterfaceC2115k interfaceC2115k = this._rootSeparator;
        if (interfaceC2115k != null) {
            abstractC2108d.mo1641S(interfaceC2115k);
        }
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: c */
    public void mo1680c(AbstractC2108d abstractC2108d) throws IOException {
        abstractC2108d.mo1640R(this._separators.m1736a());
        this._arrayIndenter.mo1731a(abstractC2108d, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: d */
    public void mo1681d(AbstractC2108d abstractC2108d) throws IOException {
        this._objectIndenter.mo1731a(abstractC2108d, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.p204t.InterfaceC2143e
    /* JADX INFO: renamed from: e */
    public C2142d mo1732e() {
        if (C2142d.class == C2142d.class) {
            return new C2142d(this);
        }
        throw new IllegalStateException(C1643a.m867o(C2142d.class, C1643a.m833U("Failed `createInstance()`: "), " does not override method; it has to"));
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: f */
    public void mo1682f(AbstractC2108d abstractC2108d, int i) throws IOException {
        if (!this._objectIndenter.isInline()) {
            this.f4600k--;
        }
        if (i > 0) {
            this._objectIndenter.mo1731a(abstractC2108d, this.f4600k);
        } else {
            abstractC2108d.mo1640R(' ');
        }
        abstractC2108d.mo1640R('}');
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: g */
    public void mo1683g(AbstractC2108d abstractC2108d) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.f4600k++;
        }
        abstractC2108d.mo1640R('[');
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: h */
    public void mo1684h(AbstractC2108d abstractC2108d) throws IOException {
        this._arrayIndenter.mo1731a(abstractC2108d, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: i */
    public void mo1685i(AbstractC2108d abstractC2108d) throws IOException {
        abstractC2108d.mo1640R(this._separators.m1737b());
        this._objectIndenter.mo1731a(abstractC2108d, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: j */
    public void mo1686j(AbstractC2108d abstractC2108d, int i) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.f4600k--;
        }
        if (i > 0) {
            this._arrayIndenter.mo1731a(abstractC2108d, this.f4600k);
        } else {
            abstractC2108d.mo1640R(' ');
        }
        abstractC2108d.mo1640R(']');
    }

    @Override // p007b.p195g.p196a.p198b.InterfaceC2114j
    /* JADX INFO: renamed from: k */
    public void mo1687k(AbstractC2108d abstractC2108d) throws IOException {
        if (this._spacesInObjectEntries) {
            abstractC2108d.mo1642T(this._objectFieldValueSeparatorWithSpaces);
        } else {
            abstractC2108d.mo1640R(this._separators.m1738c());
        }
    }

    public C2142d(C2142d c2142d) {
        InterfaceC2115k interfaceC2115k = c2142d._rootSeparator;
        this._arrayIndenter = a.f4601j;
        this._objectIndenter = C2141c.f4598k;
        this._spacesInObjectEntries = true;
        this._arrayIndenter = c2142d._arrayIndenter;
        this._objectIndenter = c2142d._objectIndenter;
        this._spacesInObjectEntries = c2142d._spacesInObjectEntries;
        this.f4600k = c2142d.f4600k;
        this._separators = c2142d._separators;
        this._objectFieldValueSeparatorWithSpaces = c2142d._objectFieldValueSeparatorWithSpaces;
        this._rootSeparator = interfaceC2115k;
    }
}
