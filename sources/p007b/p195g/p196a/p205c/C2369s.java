package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.EnumC2080h0;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;

/* JADX INFO: renamed from: b.g.a.c.s */
/* JADX INFO: compiled from: PropertyMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2369s implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final C2369s f5025j = new C2369s(Boolean.TRUE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: k */
    public static final C2369s f5026k = new C2369s(Boolean.FALSE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: l */
    public static final C2369s f5027l = new C2369s(null, null, null, null, null, null, null);
    private static final long serialVersionUID = -1;
    public EnumC2080h0 _contentNulls;
    public final String _defaultValue;
    public final String _description;
    public final Integer _index;
    public final Boolean _required;
    public EnumC2080h0 _valueNulls;

    /* JADX INFO: renamed from: m */
    public final transient a f5028m;

    /* JADX INFO: renamed from: b.g.a.c.s$a */
    /* JADX INFO: compiled from: PropertyMetadata.java */
    public static final class a {
        public a(AbstractC2188i abstractC2188i, boolean z2) {
        }
    }

    public C2369s(Boolean bool, String str, Integer num, String str2, a aVar, EnumC2080h0 enumC2080h0, EnumC2080h0 enumC2080h1) {
        this._required = bool;
        this._description = str;
        this._index = num;
        this._defaultValue = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f5028m = aVar;
        this._valueNulls = enumC2080h0;
        this._contentNulls = enumC2080h1;
    }

    /* JADX INFO: renamed from: a */
    public C2369s m2226a(a aVar) {
        return new C2369s(this._required, this._description, this._index, this._defaultValue, aVar, this._valueNulls, this._contentNulls);
    }

    public Object readResolve() {
        if (this._description != null || this._index != null || this._defaultValue != null || this.f5028m != null || this._valueNulls != null || this._contentNulls != null) {
            return this;
        }
        Boolean bool = this._required;
        if (bool == null) {
            return f5027l;
        }
        return bool.booleanValue() ? f5025j : f5026k;
    }
}
