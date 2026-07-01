package b.i.a.c.x2;

import android.net.Uri;
import b.i.a.c.x2.k0.h0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DefaultExtractorsFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements l {
    public static final int[] a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f$a f1175b = new f$a();

    @Override // b.i.a.c.x2.l
    public synchronized h[] a() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Override // b.i.a.c.x2.l
    public synchronized h[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iO0 = b.c.a.a0.d.O0(map);
        if (iO0 != -1) {
            c(iO0, arrayList);
        }
        int iP0 = b.c.a.a0.d.P0(uri);
        if (iP0 != -1 && iP0 != iO0) {
            c(iP0, arrayList);
        }
        for (int i : a) {
            if (i != iO0 && i != iP0) {
                c(i, arrayList);
            }
        }
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public final void c(int i, List<h> list) {
        h hVarNewInstance;
        Constructor<? extends h> constructor;
        switch (i) {
            case 0:
                list.add(new b.i.a.c.x2.k0.f());
                return;
            case 1:
                list.add(new b.i.a.c.x2.k0.h());
                return;
            case 2:
                list.add(new b.i.a.c.x2.k0.j(0));
                return;
            case 3:
                list.add(new b.i.a.c.x2.c0.b(0));
                return;
            case 4:
                f$a f_a = f1175b;
                synchronized (f_a.a) {
                    hVarNewInstance = null;
                    if (f_a.a.get()) {
                        constructor = f_a.f1176b;
                    } else {
                        try {
                            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                                f_a.f1176b = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(h.class).getConstructor(Integer.TYPE);
                            }
                            break;
                        } catch (ClassNotFoundException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Error instantiating FLAC extension", e);
                        }
                        f_a.a.set(true);
                        constructor = f_a.f1176b;
                    }
                }
                if (constructor != null) {
                    try {
                        hVarNewInstance = constructor.newInstance(0);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
                if (hVarNewInstance != null) {
                    list.add(hVarNewInstance);
                    return;
                } else {
                    list.add(new b.i.a.c.x2.d0.d(0));
                    return;
                }
            case 5:
                list.add(new b.i.a.c.x2.e0.c());
                return;
            case 6:
                list.add(new b.i.a.c.x2.g0.e(0));
                return;
            case 7:
                list.add(new b.i.a.c.x2.h0.f(0));
                return;
            case 8:
                list.add(new b.i.a.c.x2.i0.g(0));
                list.add(new b.i.a.c.x2.i0.i(0));
                return;
            case 9:
                list.add(new b.i.a.c.x2.j0.d());
                return;
            case 10:
                list.add(new b.i.a.c.x2.k0.b0());
                return;
            case 11:
                list.add(new h0(1, 0, 112800));
                return;
            case 12:
                list.add(new b.i.a.c.x2.l0.b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new b.i.a.c.x2.f0.a());
                return;
        }
    }
}
