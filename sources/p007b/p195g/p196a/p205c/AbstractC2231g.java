package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p198b.EnumC2116l;
import p007b.p195g.p196a.p198b.p204t.C2146h;
import p007b.p195g.p196a.p205c.p206a0.AbstractC2158f;
import p007b.p195g.p196a.p205c.p206a0.C2157e;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2347i;

/* JADX INFO: renamed from: b.g.a.c.g */
/* JADX INFO: compiled from: DeserializationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2231g extends AbstractC2208e implements Serializable {
    private static final long serialVersionUID = 1;
    public final C2157e _cache;
    public final C2229f _config;
    public C2347i<AbstractC2360j> _currentType;
    public final AbstractC2158f _factory;
    public final int _featureFlags;
    public final AbstractC2338i _injectableValues;
    public final C2146h<EnumC2116l> _readCapabilities;
    public final Class<?> _view;

    public AbstractC2231g(AbstractC2158f abstractC2158f, C2157e c2157e) {
        Objects.requireNonNull(abstractC2158f, "Cannot pass null DeserializerFactory");
        this._factory = abstractC2158f;
        this._cache = c2157e == null ? new C2157e() : c2157e;
        this._featureFlags = 0;
        this._readCapabilities = null;
        this._config = null;
        this._view = null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2208e
    /* JADX INFO: renamed from: d */
    public final C2335n mo1940d() {
        return this._config._base._typeFactory;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2208e
    /* JADX INFO: renamed from: f */
    public <T> T mo1942f(AbstractC2360j abstractC2360j, String str) throws JsonMappingException {
        throw new InvalidDefinitionException((AbstractC2110f) null, str, abstractC2360j);
    }
}
