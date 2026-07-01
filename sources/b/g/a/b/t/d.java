package b.g.a.b.t;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: compiled from: DefaultPrettyPrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements b.g.a.b.j, e<d>, Serializable {
    public static final b.g.a.b.p.j j = new b.g.a.b.p.j(" ");
    private static final long serialVersionUID = 1;
    public d$b _arrayIndenter;
    public String _objectFieldValueSeparatorWithSpaces;
    public d$b _objectIndenter;
    public final b.g.a.b.k _rootSeparator;
    public j _separators;
    public boolean _spacesInObjectEntries;
    public transient int k;

    public d() {
        b.g.a.b.p.j jVar = j;
        this._arrayIndenter = d$a.j;
        this._objectIndenter = c.k;
        this._spacesInObjectEntries = true;
        this._rootSeparator = jVar;
        j jVar2 = b.g.a.b.j.f663b;
        this._separators = jVar2;
        StringBuilder sbU = b.d.b.a.a.U(" ");
        sbU.append(jVar2.c());
        sbU.append(" ");
        this._objectFieldValueSeparatorWithSpaces = sbU.toString();
    }

    @Override // b.g.a.b.j
    public void a(b.g.a.b.d dVar) throws IOException {
        dVar.R('{');
        if (this._objectIndenter.isInline()) {
            return;
        }
        this.k++;
    }

    @Override // b.g.a.b.j
    public void b(b.g.a.b.d dVar) throws IOException {
        b.g.a.b.k kVar = this._rootSeparator;
        if (kVar != null) {
            dVar.S(kVar);
        }
    }

    @Override // b.g.a.b.j
    public void c(b.g.a.b.d dVar) throws IOException {
        dVar.R(this._separators.a());
        this._arrayIndenter.a(dVar, this.k);
    }

    @Override // b.g.a.b.j
    public void d(b.g.a.b.d dVar) throws IOException {
        this._objectIndenter.a(dVar, this.k);
    }

    @Override // b.g.a.b.t.e
    public d e() {
        if (d.class == d.class) {
            return new d(this);
        }
        throw new IllegalStateException(b.d.b.a.a.o(d.class, b.d.b.a.a.U("Failed `createInstance()`: "), " does not override method; it has to"));
    }

    @Override // b.g.a.b.j
    public void f(b.g.a.b.d dVar, int i) throws IOException {
        if (!this._objectIndenter.isInline()) {
            this.k--;
        }
        if (i > 0) {
            this._objectIndenter.a(dVar, this.k);
        } else {
            dVar.R(' ');
        }
        dVar.R('}');
    }

    @Override // b.g.a.b.j
    public void g(b.g.a.b.d dVar) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.k++;
        }
        dVar.R('[');
    }

    @Override // b.g.a.b.j
    public void h(b.g.a.b.d dVar) throws IOException {
        this._arrayIndenter.a(dVar, this.k);
    }

    @Override // b.g.a.b.j
    public void i(b.g.a.b.d dVar) throws IOException {
        dVar.R(this._separators.b());
        this._objectIndenter.a(dVar, this.k);
    }

    @Override // b.g.a.b.j
    public void j(b.g.a.b.d dVar, int i) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.k--;
        }
        if (i > 0) {
            this._arrayIndenter.a(dVar, this.k);
        } else {
            dVar.R(' ');
        }
        dVar.R(']');
    }

    @Override // b.g.a.b.j
    public void k(b.g.a.b.d dVar) throws IOException {
        if (this._spacesInObjectEntries) {
            dVar.T(this._objectFieldValueSeparatorWithSpaces);
        } else {
            dVar.R(this._separators.c());
        }
    }

    public d(d dVar) {
        b.g.a.b.k kVar = dVar._rootSeparator;
        this._arrayIndenter = d$a.j;
        this._objectIndenter = c.k;
        this._spacesInObjectEntries = true;
        this._arrayIndenter = dVar._arrayIndenter;
        this._objectIndenter = dVar._objectIndenter;
        this._spacesInObjectEntries = dVar._spacesInObjectEntries;
        this.k = dVar.k;
        this._separators = dVar._separators;
        this._objectFieldValueSeparatorWithSpaces = dVar._objectFieldValueSeparatorWithSpaces;
        this._rootSeparator = kVar;
    }
}
