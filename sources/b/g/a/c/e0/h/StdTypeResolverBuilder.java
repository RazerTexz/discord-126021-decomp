package b.g.a.c.e0.h;

import b.d.b.a.outline;
import b.g.a.a.JsonTypeInfo;
import b.g.a.c.JavaType;
import b.g.a.c.MapperFeature;
import b.g.a.c.SerializationConfig;
import b.g.a.c.e0.DefaultBaseTypeLimitingValidator;
import b.g.a.c.e0.NamedType;
import b.g.a.c.e0.PolymorphicTypeValidator;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.e0.TypeSerializer;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.c.e0.h.j, reason: use source file name */
/* JADX INFO: compiled from: StdTypeResolverBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    public TypeIdResolver _customIdResolver;
    public JsonTypeInfo.b _idType;
    public JsonTypeInfo.a _includeAs;
    public String _typeProperty;

    @Override // b.g.a.c.e0.TypeResolverBuilder
    public TypeResolverBuilder a(boolean z2) {
        return this;
    }

    @Override // b.g.a.c.e0.TypeResolverBuilder
    public /* bridge */ /* synthetic */ TypeResolverBuilder b(JsonTypeInfo.b bVar, TypeIdResolver typeIdResolver) {
        g(bVar, typeIdResolver);
        return this;
    }

    @Override // b.g.a.c.e0.TypeResolverBuilder
    public TypeResolverBuilder c(String str) {
        if (str == null || str.isEmpty()) {
            str = this._idType.f();
        }
        this._typeProperty = str;
        return this;
    }

    @Override // b.g.a.c.e0.TypeResolverBuilder
    public TypeResolverBuilder d(Class cls) {
        return this;
    }

    @Override // b.g.a.c.e0.TypeResolverBuilder
    public TypeSerializer e(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == JsonTypeInfo.b.NONE || javaType._class.isPrimitive()) {
            return null;
        }
        PolymorphicTypeValidator defaultBaseTypeLimitingValidator = serializationConfig._base._typeValidator;
        if (defaultBaseTypeLimitingValidator == LaissezFaireSubTypeValidator.j && serializationConfig.q(MapperFeature.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            defaultBaseTypeLimitingValidator = new DefaultBaseTypeLimitingValidator();
        }
        TypeIdResolver classNameIdResolver = this._customIdResolver;
        if (classNameIdResolver == null) {
            JsonTypeInfo.b bVar = this._idType;
            if (bVar == null) {
                throw new IllegalStateException("Cannot build, 'init()' not yet called");
            }
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 0) {
                classNameIdResolver = null;
            } else if (iOrdinal == 1) {
                classNameIdResolver = new ClassNameIdResolver(javaType, serializationConfig._base._typeFactory, defaultBaseTypeLimitingValidator);
            } else if (iOrdinal == 2) {
                classNameIdResolver = new MinimalClassNameIdResolver(javaType, serializationConfig._base._typeFactory, defaultBaseTypeLimitingValidator);
            } else if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    StringBuilder sbU = outline.U("Do not know how to construct standard type id resolver for idType: ");
                    sbU.append(this._idType);
                    throw new IllegalStateException(sbU.toString());
                }
                classNameIdResolver = new ClassNameIdResolver(javaType, serializationConfig._base._typeFactory, defaultBaseTypeLimitingValidator);
            } else {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                serializationConfig.q(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (collection != null) {
                    for (NamedType namedType : collection) {
                        Class<?> cls = namedType._class;
                        concurrentHashMap.put(cls.getName(), namedType.a() ? namedType._name : TypeNameIdResolver.d(cls));
                    }
                }
                classNameIdResolver = new TypeNameIdResolver(serializationConfig, javaType, concurrentHashMap, null);
            }
        }
        if (this._idType == JsonTypeInfo.b.DEDUCTION) {
            return new AsExistingPropertyTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        int iOrdinal2 = this._includeAs.ordinal();
        if (iOrdinal2 == 0) {
            return new AsPropertyTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        if (iOrdinal2 == 1) {
            return new AsWrapperTypeSerializer(classNameIdResolver, null);
        }
        if (iOrdinal2 == 2) {
            return new AsArrayTypeSerializer(classNameIdResolver, null);
        }
        if (iOrdinal2 == 3) {
            return new AsExternalTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        if (iOrdinal2 == 4) {
            return new AsExistingPropertyTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        StringBuilder sbU2 = outline.U("Do not know how to construct standard type serializer for inclusion type: ");
        sbU2.append(this._includeAs);
        throw new IllegalStateException(sbU2.toString());
    }

    @Override // b.g.a.c.e0.TypeResolverBuilder
    public TypeResolverBuilder f(JsonTypeInfo.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this._includeAs = aVar;
        return this;
    }

    public StdTypeResolverBuilder g(JsonTypeInfo.b bVar, TypeIdResolver typeIdResolver) {
        if (bVar == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this._idType = bVar;
        this._customIdResolver = typeIdResolver;
        this._typeProperty = bVar.f();
        return this;
    }
}
