package b.g.a.b.t;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.b.PrettyPrinter2;
import b.g.a.b.SerializableString;
import b.g.a.b.p.SerializedString;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.b.t.d, reason: use source file name */
/* JADX INFO: compiled from: DefaultPrettyPrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultPrettyPrinter implements PrettyPrinter2, Instantiatable<DefaultPrettyPrinter>, Serializable {
    public static final SerializedString j = new SerializedString(" ");
    private static final long serialVersionUID = 1;
    public b _arrayIndenter;
    public String _objectFieldValueSeparatorWithSpaces;
    public b _objectIndenter;
    public final SerializableString _rootSeparator;
    public Separators _separators;
    public boolean _spacesInObjectEntries;
    public transient int k;

    /* JADX INFO: renamed from: b.g.a.b.t.d$a */
    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public static class a extends c {
        public static final a j = new a();

        @Override // b.g.a.b.t.DefaultPrettyPrinter.b
        public void a(JsonGenerator jsonGenerator, int i) throws IOException {
            jsonGenerator.R(' ');
        }

        @Override // b.g.a.b.t.DefaultPrettyPrinter.c, b.g.a.b.t.DefaultPrettyPrinter.b
        public boolean isInline() {
            return true;
        }
    }

    /* JADX INFO: renamed from: b.g.a.b.t.d$b */
    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public interface b {
        void a(JsonGenerator jsonGenerator, int i) throws IOException;

        boolean isInline();
    }

    /* JADX INFO: renamed from: b.g.a.b.t.d$c */
    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public static class c implements b, Serializable {
        @Override // b.g.a.b.t.DefaultPrettyPrinter.b
        public boolean isInline() {
            return !(this instanceof DefaultIndenter);
        }
    }

    public DefaultPrettyPrinter() {
        SerializedString serializedString = j;
        this._arrayIndenter = a.j;
        this._objectIndenter = DefaultIndenter.k;
        this._spacesInObjectEntries = true;
        this._rootSeparator = serializedString;
        Separators separators = PrettyPrinter2.f663b;
        this._separators = separators;
        StringBuilder sbU = outline.U(" ");
        sbU.append(separators.c());
        sbU.append(" ");
        this._objectFieldValueSeparatorWithSpaces = sbU.toString();
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void a(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.R('{');
        if (this._objectIndenter.isInline()) {
            return;
        }
        this.k++;
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void b(JsonGenerator jsonGenerator) throws IOException {
        SerializableString serializableString = this._rootSeparator;
        if (serializableString != null) {
            jsonGenerator.S(serializableString);
        }
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void c(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.R(this._separators.a());
        this._arrayIndenter.a(jsonGenerator, this.k);
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void d(JsonGenerator jsonGenerator) throws IOException {
        this._objectIndenter.a(jsonGenerator, this.k);
    }

    @Override // b.g.a.b.t.Instantiatable
    public DefaultPrettyPrinter e() {
        if (DefaultPrettyPrinter.class == DefaultPrettyPrinter.class) {
            return new DefaultPrettyPrinter(this);
        }
        throw new IllegalStateException(outline.o(DefaultPrettyPrinter.class, outline.U("Failed `createInstance()`: "), " does not override method; it has to"));
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void f(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this._objectIndenter.isInline()) {
            this.k--;
        }
        if (i > 0) {
            this._objectIndenter.a(jsonGenerator, this.k);
        } else {
            jsonGenerator.R(' ');
        }
        jsonGenerator.R('}');
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void g(JsonGenerator jsonGenerator) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.k++;
        }
        jsonGenerator.R('[');
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void h(JsonGenerator jsonGenerator) throws IOException {
        this._arrayIndenter.a(jsonGenerator, this.k);
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void i(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.R(this._separators.b());
        this._objectIndenter.a(jsonGenerator, this.k);
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void j(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.k--;
        }
        if (i > 0) {
            this._arrayIndenter.a(jsonGenerator, this.k);
        } else {
            jsonGenerator.R(' ');
        }
        jsonGenerator.R(']');
    }

    @Override // b.g.a.b.PrettyPrinter2
    public void k(JsonGenerator jsonGenerator) throws IOException {
        if (this._spacesInObjectEntries) {
            jsonGenerator.T(this._objectFieldValueSeparatorWithSpaces);
        } else {
            jsonGenerator.R(this._separators.c());
        }
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter) {
        SerializableString serializableString = defaultPrettyPrinter._rootSeparator;
        this._arrayIndenter = a.j;
        this._objectIndenter = DefaultIndenter.k;
        this._spacesInObjectEntries = true;
        this._arrayIndenter = defaultPrettyPrinter._arrayIndenter;
        this._objectIndenter = defaultPrettyPrinter._objectIndenter;
        this._spacesInObjectEntries = defaultPrettyPrinter._spacesInObjectEntries;
        this.k = defaultPrettyPrinter.k;
        this._separators = defaultPrettyPrinter._separators;
        this._objectFieldValueSeparatorWithSpaces = defaultPrettyPrinter._objectFieldValueSeparatorWithSpaces;
        this._rootSeparator = serializableString;
    }
}
