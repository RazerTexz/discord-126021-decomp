package p007b.p109f.p161j.p177l;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.C1703j;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p115d.p122g.InterfaceC1700g;

/* JADX INFO: renamed from: b.f.j.l.x */
/* JADX INFO: compiled from: PoolFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1952x {

    /* JADX INFO: renamed from: a */
    public final C1951w f3968a;

    /* JADX INFO: renamed from: b */
    public AbstractC1947s f3969b;

    /* JADX INFO: renamed from: c */
    public InterfaceC1932d f3970c;

    /* JADX INFO: renamed from: d */
    public AbstractC1947s f3971d;

    /* JADX INFO: renamed from: e */
    public AbstractC1947s f3972e;

    /* JADX INFO: renamed from: f */
    public InterfaceC1700g f3973f;

    /* JADX INFO: renamed from: g */
    public C1703j f3974g;

    /* JADX INFO: renamed from: h */
    public InterfaceC1694a f3975h;

    public C1952x(C1951w c1951w) {
        this.f3968a = c1951w;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: a */
    public InterfaceC1932d m1406a() {
        if (this.f3970c == null) {
            String str = this.f3968a.f3966i;
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1868884870:
                    if (str.equals("legacy_default_params")) {
                        b2 = 3;
                    }
                    break;
                case -1106578487:
                    if (str.equals("legacy")) {
                        b2 = 4;
                    }
                    break;
                case -404562712:
                    if (str.equals("experimental")) {
                        b2 = 2;
                    }
                    break;
                case -402149703:
                    if (str.equals("dummy_with_tracking")) {
                        b2 = 1;
                    }
                    break;
                case 95945896:
                    if (str.equals("dummy")) {
                        b2 = 0;
                    }
                    break;
            }
            if (b2 == 0) {
                this.f3970c = new C1940l();
            } else if (b2 == 1) {
                this.f3970c = new C1941m();
            } else if (b2 == 2) {
                Objects.requireNonNull(this.f3968a);
                int i = this.f3968a.f3967j;
                C1950v c1950vM1398h = C1950v.m1398h();
                Objects.requireNonNull(this.f3968a);
                this.f3970c = new C1944p(0, i, c1950vM1398h, null);
            } else if (b2 != 3) {
                C1951w c1951w = this.f3968a;
                this.f3970c = new C1936h(c1951w.f3961d, c1951w.f3958a, c1951w.f3959b, false);
            } else {
                this.f3970c = new C1936h(this.f3968a.f3961d, C1938j.m1390a(), this.f3968a.f3959b, false);
            }
        }
        return this.f3970c;
    }

    /* JADX INFO: renamed from: b */
    public int m1407b() {
        return this.f3968a.f3960c.f3979d;
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC1700g m1408c(int i) {
        AbstractC1947s abstractC1947s;
        if (this.f3973f == null) {
            if (i == 0) {
                if (this.f3972e == null) {
                    try {
                        Constructor<?> constructor = Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(InterfaceC1696c.class, C1953y.class, InterfaceC1954z.class);
                        C1951w c1951w = this.f3968a;
                        this.f3972e = (AbstractC1947s) constructor.newInstance(c1951w.f3961d, c1951w.f3962e, c1951w.f3963f);
                    } catch (ClassNotFoundException e) {
                        C1691a.m978f("PoolFactory", "", e);
                        this.f3972e = null;
                    } catch (IllegalAccessException e2) {
                        C1691a.m978f("PoolFactory", "", e2);
                        this.f3972e = null;
                    } catch (InstantiationException e3) {
                        C1691a.m978f("PoolFactory", "", e3);
                        this.f3972e = null;
                    } catch (NoSuchMethodException e4) {
                        C1691a.m978f("PoolFactory", "", e4);
                        this.f3972e = null;
                    } catch (InvocationTargetException e5) {
                        C1691a.m978f("PoolFactory", "", e5);
                        this.f3972e = null;
                    }
                }
                abstractC1947s = this.f3972e;
            } else if (i == 1) {
                if (this.f3971d == null) {
                    try {
                        Constructor<?> constructor2 = Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(InterfaceC1696c.class, C1953y.class, InterfaceC1954z.class);
                        C1951w c1951w2 = this.f3968a;
                        this.f3971d = (AbstractC1947s) constructor2.newInstance(c1951w2.f3961d, c1951w2.f3962e, c1951w2.f3963f);
                    } catch (ClassNotFoundException unused) {
                        this.f3971d = null;
                    } catch (IllegalAccessException unused2) {
                        this.f3971d = null;
                    } catch (InstantiationException unused3) {
                        this.f3971d = null;
                    } catch (NoSuchMethodException unused4) {
                        this.f3971d = null;
                    } catch (InvocationTargetException unused5) {
                        this.f3971d = null;
                    }
                }
                abstractC1947s = this.f3971d;
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid MemoryChunkType");
                }
                if (this.f3969b == null) {
                    try {
                        Constructor<?> constructor3 = Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(InterfaceC1696c.class, C1953y.class, InterfaceC1954z.class);
                        C1951w c1951w3 = this.f3968a;
                        this.f3969b = (AbstractC1947s) constructor3.newInstance(c1951w3.f3961d, c1951w3.f3962e, c1951w3.f3963f);
                    } catch (ClassNotFoundException unused6) {
                        this.f3969b = null;
                    } catch (IllegalAccessException unused7) {
                        this.f3969b = null;
                    } catch (InstantiationException unused8) {
                        this.f3969b = null;
                    } catch (NoSuchMethodException unused9) {
                        this.f3969b = null;
                    } catch (InvocationTargetException unused10) {
                        this.f3969b = null;
                    }
                }
                abstractC1947s = this.f3969b;
            }
            C1460d.m591y(abstractC1947s, "failed to get pool for chunk type: " + i);
            this.f3973f = new C1949u(abstractC1947s, m1409d());
        }
        return this.f3973f;
    }

    /* JADX INFO: renamed from: d */
    public C1703j m1409d() {
        if (this.f3974g == null) {
            this.f3974g = new C1703j(m1410e());
        }
        return this.f3974g;
    }

    /* JADX INFO: renamed from: e */
    public InterfaceC1694a m1410e() {
        if (this.f3975h == null) {
            C1951w c1951w = this.f3968a;
            this.f3975h = new C1943o(c1951w.f3961d, c1951w.f3964g, c1951w.f3965h);
        }
        return this.f3975h;
    }
}
