package p617h0.p620b.p627b;

import java.io.Serializable;
import p617h0.p620b.p621a.InterfaceC12436a;
import p617h0.p620b.p621a.p622b.C12437a;
import p617h0.p620b.p621a.p622b.C12438b;
import p617h0.p620b.p621a.p622b.C12439c;
import p617h0.p620b.p621a.p623c.C12440a;
import p617h0.p620b.p621a.p623c.C12441b;
import p617h0.p620b.p621a.p624d.C12442a;
import p617h0.p620b.p621a.p625e.C12444a;
import p617h0.p620b.p621a.p626f.C12445a;
import p617h0.p620b.p621a.p626f.C12446b;

/* JADX INFO: renamed from: h0.b.b.c */
/* JADX INFO: compiled from: StdInstantiatorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12449c implements InterfaceC12447a {
    @Override // p617h0.p620b.p627b.InterfaceC12447a
    public <T> InterfaceC12436a<T> newInstantiatorOf(Class<T> cls) {
        if (C12448b.m10657b("Java HotSpot") || C12448b.m10657b("OpenJDK")) {
            if (C12448b.f26405d != null) {
                return Serializable.class.isAssignableFrom(cls) ? new C12441b(cls) : new C12440a(cls);
            }
            return new C12445a(cls);
        }
        if (!C12448b.m10657b("Dalvik")) {
            if (C12448b.m10657b("BEA")) {
                return new C12445a(cls);
            }
            if (C12448b.m10657b("GNU libgcj")) {
                return new C12442a(cls);
            }
            return C12448b.m10657b("PERC") ? new C12444a(cls) : new C12446b(cls);
        }
        if (C12448b.f26404c) {
            return new C12446b(cls);
        }
        int i = C12448b.f26403b;
        if (i <= 10) {
            return new C12437a(cls);
        }
        return i <= 17 ? new C12438b(cls) : new C12439c(cls);
    }
}
