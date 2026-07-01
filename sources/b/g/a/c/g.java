package b.g.a.c;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: DeserializationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends e implements Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.a0.e _cache;
    public final f _config;
    public b.g.a.c.i0.i<j> _currentType;
    public final b.g.a.c.a0.f _factory;
    public final int _featureFlags;
    public final i _injectableValues;
    public final b.g.a.b.t.h<b.g.a.b.l> _readCapabilities;
    public final Class<?> _view;

    public g(b.g.a.c.a0.f fVar, b.g.a.c.a0.e eVar) {
        Objects.requireNonNull(fVar, "Cannot pass null DeserializerFactory");
        this._factory = fVar;
        this._cache = eVar == null ? new b.g.a.c.a0.e() : eVar;
        this._featureFlags = 0;
        this._readCapabilities = null;
        this._config = null;
        this._view = null;
    }

    @Override // b.g.a.c.e
    public final b.g.a.c.h0.n d() {
        return this._config._base._typeFactory;
    }

    @Override // b.g.a.c.e
    public <T> T f(j jVar, String str) throws JsonMappingException {
        throw new InvalidDefinitionException((b.g.a.b.f) null, str, jVar);
    }
}
