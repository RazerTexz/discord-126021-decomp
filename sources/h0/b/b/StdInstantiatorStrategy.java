package h0.b.b;

import h0.b.a.ObjectInstantiator;
import h0.b.a.b.Android10Instantiator;
import h0.b.a.b.Android17Instantiator;
import h0.b.a.b.Android18Instantiator;
import h0.b.a.c.AccessibleInstantiator;
import h0.b.a.c.ObjectInputStreamInstantiator;
import h0.b.a.d.GCJInstantiator;
import h0.b.a.e.PercInstantiator;
import h0.b.a.f.SunReflectionFactoryInstantiator;
import h0.b.a.f.UnsafeFactoryInstantiator;
import java.io.Serializable;

/* JADX INFO: renamed from: h0.b.b.c, reason: use source file name */
/* JADX INFO: compiled from: StdInstantiatorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdInstantiatorStrategy implements InstantiatorStrategy {
    @Override // h0.b.b.InstantiatorStrategy
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> cls) {
        if (PlatformDescription.b("Java HotSpot") || PlatformDescription.b("OpenJDK")) {
            if (PlatformDescription.d != null) {
                return Serializable.class.isAssignableFrom(cls) ? new ObjectInputStreamInstantiator(cls) : new AccessibleInstantiator(cls);
            }
            return new SunReflectionFactoryInstantiator(cls);
        }
        if (!PlatformDescription.b("Dalvik")) {
            if (PlatformDescription.b("BEA")) {
                return new SunReflectionFactoryInstantiator(cls);
            }
            if (PlatformDescription.b("GNU libgcj")) {
                return new GCJInstantiator(cls);
            }
            return PlatformDescription.b("PERC") ? new PercInstantiator(cls) : new UnsafeFactoryInstantiator(cls);
        }
        if (PlatformDescription.c) {
            return new UnsafeFactoryInstantiator(cls);
        }
        int i = PlatformDescription.f3734b;
        if (i <= 10) {
            return new Android10Instantiator(cls);
        }
        return i <= 17 ? new Android17Instantiator(cls) : new Android18Instantiator(cls);
    }
}
