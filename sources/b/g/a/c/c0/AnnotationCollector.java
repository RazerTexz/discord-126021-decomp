package b.g.a.c.c0;

import b.g.a.c.i0.Annotations;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.o, reason: use source file name */
/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AnnotationCollector {
    public static final Annotations a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f692b;

    /* JADX INFO: renamed from: b.g.a.c.c0.o$a */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class a extends AnnotationCollector {
        public static final a c = new a(null);

        public a(Object obj) {
            super(null);
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public AnnotationCollector a(Annotation annotation) {
            return new e(this.f692b, annotation.annotationType(), annotation);
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public AnnotationMap b() {
            return new AnnotationMap();
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public Annotations c() {
            return AnnotationCollector.a;
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public boolean d(Annotation annotation) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$b */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class b extends AnnotationCollector {
        public final HashMap<Class<?>, Annotation> c;

        public b(Object obj, Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            super(obj);
            HashMap<Class<?>, Annotation> map = new HashMap<>();
            this.c = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public AnnotationCollector a(Annotation annotation) {
            this.c.put(annotation.annotationType(), annotation);
            return this;
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public AnnotationMap b() {
            AnnotationMap annotationMap = new AnnotationMap();
            for (Annotation annotation : this.c.values()) {
                if (annotationMap.j == null) {
                    annotationMap.j = new HashMap<>();
                }
                Annotation annotationPut = annotationMap.j.put(annotation.annotationType(), annotation);
                if (annotationPut != null) {
                    annotationPut.equals(annotation);
                }
            }
            return annotationMap;
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public Annotations c() {
            if (this.c.size() != 2) {
                return new AnnotationMap(this.c);
            }
            Iterator<Map.Entry<Class<?>, Annotation>> it = this.c.entrySet().iterator();
            Map.Entry<Class<?>, Annotation> next = it.next();
            Map.Entry<Class<?>, Annotation> next2 = it.next();
            return new f(next.getKey(), next.getValue(), next2.getKey(), next2.getValue());
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public boolean d(Annotation annotation) {
            return this.c.containsKey(annotation.annotationType());
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$c */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class c implements Annotations, Serializable {
        private static final long serialVersionUID = 1;

        @Override // b.g.a.c.i0.Annotations
        public <A extends Annotation> A a(Class<A> cls) {
            return null;
        }

        @Override // b.g.a.c.i0.Annotations
        public int size() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$d */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class d implements Annotations, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type;
        private final Annotation _value;

        public d(Class<?> cls, Annotation annotation) {
            this._type = cls;
            this._value = annotation;
        }

        @Override // b.g.a.c.i0.Annotations
        public <A extends Annotation> A a(Class<A> cls) {
            if (this._type == cls) {
                return (A) this._value;
            }
            return null;
        }

        @Override // b.g.a.c.i0.Annotations
        public int size() {
            return 1;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$e */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class e extends AnnotationCollector {
        public Class<?> c;
        public Annotation d;

        public e(Object obj, Class<?> cls, Annotation annotation) {
            super(obj);
            this.c = cls;
            this.d = annotation;
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public AnnotationCollector a(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<?> cls = this.c;
            if (cls != clsAnnotationType) {
                return new b(this.f692b, cls, this.d, clsAnnotationType, annotation);
            }
            this.d = annotation;
            return this;
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public AnnotationMap b() {
            Class<?> cls = this.c;
            Annotation annotation = this.d;
            HashMap map = new HashMap(4);
            map.put(cls, annotation);
            return new AnnotationMap(map);
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public Annotations c() {
            return new d(this.c, this.d);
        }

        @Override // b.g.a.c.c0.AnnotationCollector
        public boolean d(Annotation annotation) {
            return annotation.annotationType() == this.c;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.o$f */
    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class f implements Annotations, Serializable {
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

        @Override // b.g.a.c.i0.Annotations
        public <A extends Annotation> A a(Class<A> cls) {
            if (this._type1 == cls) {
                return (A) this._value1;
            }
            if (this._type2 == cls) {
                return (A) this._value2;
            }
            return null;
        }

        @Override // b.g.a.c.i0.Annotations
        public int size() {
            return 2;
        }
    }

    public AnnotationCollector(Object obj) {
        this.f692b = obj;
    }

    public abstract AnnotationCollector a(Annotation annotation);

    public abstract AnnotationMap b();

    public abstract Annotations c();

    public abstract boolean d(Annotation annotation);
}
