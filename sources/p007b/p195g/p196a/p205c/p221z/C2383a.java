package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import p007b.p195g.p196a.p198b.C2105a;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.C2371u;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2173a;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2199t;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2211c;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f;
import p007b.p195g.p196a.p205c.p218h0.C2335n;

/* JADX INFO: renamed from: b.g.a.c.z.a */
/* JADX INFO: compiled from: BaseSettings.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2383a implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final TimeZone f5074j = TimeZone.getTimeZone("UTC");
    private static final long serialVersionUID = 1;
    public final AbstractC2173a.a _accessorNaming;
    public final AbstractC2165b _annotationIntrospector;
    public final AbstractC2199t _classIntrospector;
    public final DateFormat _dateFormat;
    public final C2105a _defaultBase64;
    public final AbstractC2393k _handlerInstantiator;
    public final Locale _locale;
    public final C2371u _propertyNamingStrategy;
    public final TimeZone _timeZone;
    public final C2335n _typeFactory;
    public final InterfaceC2214f<?> _typeResolverBuilder;
    public final AbstractC2211c _typeValidator;

    public C2383a(AbstractC2199t abstractC2199t, AbstractC2165b abstractC2165b, C2371u c2371u, C2335n c2335n, InterfaceC2214f interfaceC2214f, DateFormat dateFormat, Locale locale, TimeZone timeZone, C2105a c2105a, AbstractC2211c abstractC2211c, AbstractC2173a.a aVar) {
        this._classIntrospector = abstractC2199t;
        this._annotationIntrospector = abstractC2165b;
        this._propertyNamingStrategy = c2371u;
        this._typeFactory = c2335n;
        this._typeResolverBuilder = interfaceC2214f;
        this._dateFormat = dateFormat;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = c2105a;
        this._typeValidator = abstractC2211c;
        this._accessorNaming = aVar;
    }
}
