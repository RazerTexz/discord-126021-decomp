package b.g.a.c.z;

import b.g.a.b.Base64Variant;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.PropertyNamingStrategy;
import b.g.a.c.c0.AccessorNamingStrategy;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.e0.PolymorphicTypeValidator;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.h0.TypeFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: renamed from: b.g.a.c.z.a, reason: use source file name */
/* JADX INFO: compiled from: BaseSettings.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BaseSettings implements Serializable {
    public static final TimeZone j = TimeZone.getTimeZone("UTC");
    private static final long serialVersionUID = 1;
    public final AccessorNamingStrategy.a _accessorNaming;
    public final AnnotationIntrospector _annotationIntrospector;
    public final ClassIntrospector _classIntrospector;
    public final DateFormat _dateFormat;
    public final Base64Variant _defaultBase64;
    public final HandlerInstantiator _handlerInstantiator;
    public final Locale _locale;
    public final PropertyNamingStrategy _propertyNamingStrategy;
    public final TimeZone _timeZone;
    public final TypeFactory _typeFactory;
    public final TypeResolverBuilder<?> _typeResolverBuilder;
    public final PolymorphicTypeValidator _typeValidator;

    public BaseSettings(ClassIntrospector classIntrospector, AnnotationIntrospector annotationIntrospector, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, TypeResolverBuilder typeResolverBuilder, DateFormat dateFormat, Locale locale, TimeZone timeZone, Base64Variant base64Variant, PolymorphicTypeValidator polymorphicTypeValidator, AccessorNamingStrategy.a aVar) {
        this._classIntrospector = classIntrospector;
        this._annotationIntrospector = annotationIntrospector;
        this._propertyNamingStrategy = propertyNamingStrategy;
        this._typeFactory = typeFactory;
        this._typeResolverBuilder = typeResolverBuilder;
        this._dateFormat = dateFormat;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = base64Variant;
        this._typeValidator = polymorphicTypeValidator;
        this._accessorNaming = aVar;
    }
}
