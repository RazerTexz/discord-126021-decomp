package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;

/* JADX INFO: renamed from: b.g.a.c.c0.o */
/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2194o {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC2339a f4725a = new c();

    /* JADX INFO: renamed from: b */
    public final Object f4726b;

    /* JADX INFO: renamed from: b.g.a.c.c0.o$a */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class a extends AbstractC2194o {

        /* JADX INFO: renamed from: c */
        public static final a f4727c = new a(null);

        public a(Object obj) {
            super(null);
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: a */
        public AbstractC2194o mo1911a(Annotation annotation) {
            return new e(this.f4726b, annotation.annotationType(), annotation);
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: b */
        public C2195p mo1912b() {
            return new C2195p();
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: c */
        public InterfaceC2339a mo1913c() {
            return AbstractC2194o.f4725a;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: d */
        public boolean mo1914d(Annotation annotation) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$b */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class b extends AbstractC2194o {

        /* JADX INFO: renamed from: c */
        public final HashMap<Class<?>, Annotation> f4728c;

        public b(Object obj, Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            super(obj);
            HashMap<Class<?>, Annotation> map = new HashMap<>();
            this.f4728c = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: a */
        public AbstractC2194o mo1911a(Annotation annotation) {
            this.f4728c.put(annotation.annotationType(), annotation);
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: b */
        public C2195p mo1912b() {
            C2195p c2195p = new C2195p();
            for (Annotation annotation : this.f4728c.values()) {
                if (c2195p.f4731j == null) {
                    c2195p.f4731j = new HashMap<>();
                }
                Annotation annotationPut = c2195p.f4731j.put(annotation.annotationType(), annotation);
                if (annotationPut != null) {
                    annotationPut.equals(annotation);
                }
            }
            return c2195p;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: c */
        public InterfaceC2339a mo1913c() {
            if (this.f4728c.size() != 2) {
                return new C2195p(this.f4728c);
            }
            Iterator<Map.Entry<Class<?>, Annotation>> it = this.f4728c.entrySet().iterator();
            Map.Entry<Class<?>, Annotation> next = it.next();
            Map.Entry<Class<?>, Annotation> next2 = it.next();
            return new f(next.getKey(), next.getValue(), next2.getKey(), next2.getValue());
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: d */
        public boolean mo1914d(Annotation annotation) {
            return this.f4728c.containsKey(annotation.annotationType());
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$c */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class c implements InterfaceC2339a, Serializable {
        private static final long serialVersionUID = 1;

        @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
        /* JADX INFO: renamed from: a */
        public <A extends Annotation> A mo1915a(Class<A> cls) {
            return null;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
        public int size() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$d */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class d implements InterfaceC2339a, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type;
        private final Annotation _value;

        public d(Class<?> cls, Annotation annotation) {
            this._type = cls;
            this._value = annotation;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
        /* JADX INFO: renamed from: a */
        public <A extends Annotation> A mo1915a(Class<A> cls) {
            if (this._type == cls) {
                return (A) this._value;
            }
            return null;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
        public int size() {
            return 1;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$e */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class e extends AbstractC2194o {

        /* JADX INFO: renamed from: c */
        public Class<?> f4729c;

        /* JADX INFO: renamed from: d */
        public Annotation f4730d;

        public e(Object obj, Class<?> cls, Annotation annotation) {
            super(obj);
            this.f4729c = cls;
            this.f4730d = annotation;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: a */
        public AbstractC2194o mo1911a(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<?> cls = this.f4729c;
            if (cls != clsAnnotationType) {
                return new b(this.f4726b, cls, this.f4730d, clsAnnotationType, annotation);
            }
            this.f4730d = annotation;
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: b */
        public C2195p mo1912b() {
            Class<?> cls = this.f4729c;
            Annotation annotation = this.f4730d;
            HashMap map = new HashMap(4);
            map.put(cls, annotation);
            return new C2195p(map);
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: c */
        public InterfaceC2339a mo1913c() {
            return new d(this.f4729c, this.f4730d);
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2194o
        /* JADX INFO: renamed from: d */
        public boolean mo1914d(Annotation annotation) {
            return annotation.annotationType() == this.f4729c;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$f */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class f implements InterfaceC2339a, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type1;
        private final Class<?> _type2;
        private final Annotation _value1;
        private final Annotation _value2;

        public f(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            this._type1 = cls;
            this._value1 = annotation;
            this._type2 = cls2;
            this._value2 = annotation2;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
        /* JADX INFO: renamed from: a */
        public <A extends Annotation> A mo1915a(Class<A> cls) {
            if (this._type1 == cls) {
                return (A) this._value1;
            }
            if (this._type2 == cls) {
                return (A) this._value2;
            }
            return null;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
        public int size() {
            return 2;
        }
    }

    public AbstractC2194o(Object obj) {
        this.f4726b = obj;
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC2194o mo1911a(Annotation annotation);

    /* JADX INFO: renamed from: b */
    public abstract C2195p mo1912b();

    /* JADX INFO: renamed from: c */
    public abstract InterfaceC2339a mo1913c();

    /* JADX INFO: renamed from: d */
    public abstract boolean mo1914d(Annotation annotation);
}
