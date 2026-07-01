package b.g.a.c;

import b.g.a.b.JsonParser;
import b.g.a.b.StreamReadCapability;
import b.g.a.b.t.JacksonFeatureSet;
import b.g.a.c.a0.DeserializerCache;
import b.g.a.c.a0.DeserializerFactory;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.LinkedNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g, reason: use source file name */
/* JADX INFO: compiled from: DeserializationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializationContext extends DatabindContext implements Serializable {
    private static final long serialVersionUID = 1;
    public final DeserializerCache _cache;
    public final DeserializationConfig _config;
    public LinkedNode<JavaType> _currentType;
    public final DeserializerFactory _factory;
    public final int _featureFlags;
    public final InjectableValues _injectableValues;
    public final JacksonFeatureSet<StreamReadCapability> _readCapabilities;
    public final Class<?> _view;

    public DeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        Objects.requireNonNull(deserializerFactory, "Cannot pass null DeserializerFactory");
        this._factory = deserializerFactory;
        this._cache = deserializerCache == null ? new DeserializerCache() : deserializerCache;
        this._featureFlags = 0;
        this._readCapabilities = null;
        this._config = null;
        this._view = null;
    }

    @Override // b.g.a.c.DatabindContext
    public final TypeFactory d() {
        return this._config._base._typeFactory;
    }

    @Override // b.g.a.c.DatabindContext
    public <T> T f(JavaType javaType, String str) throws JsonMappingException {
        throw new InvalidDefinitionException((JsonParser) null, str, javaType);
    }
}
