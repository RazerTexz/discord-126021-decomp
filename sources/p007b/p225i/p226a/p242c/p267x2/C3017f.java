package p007b.p225i.p226a.p242c.p267x2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p267x2.p268c0.C3005b;
import p007b.p225i.p226a.p242c.p267x2.p269d0.C3010d;
import p007b.p225i.p226a.p242c.p267x2.p270e0.C3014c;
import p007b.p225i.p226a.p242c.p267x2.p271f0.C3018a;
import p007b.p225i.p226a.p242c.p267x2.p272g0.C3028e;
import p007b.p225i.p226a.p242c.p267x2.p273h0.C3037f;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3048g;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3050i;
import p007b.p225i.p226a.p242c.p267x2.p275j0.C3062d;
import p007b.p225i.p226a.p242c.p267x2.p276k0.C3073b0;
import p007b.p225i.p226a.p242c.p267x2.p276k0.C3080f;
import p007b.p225i.p226a.p242c.p267x2.p276k0.C3084h;
import p007b.p225i.p226a.p242c.p267x2.p276k0.C3085h0;
import p007b.p225i.p226a.p242c.p267x2.p276k0.C3088j;
import p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b;

/* JADX INFO: renamed from: b.i.a.c.x2.f */
/* JADX INFO: compiled from: DefaultExtractorsFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3017f implements InterfaceC3106l {

    /* JADX INFO: renamed from: a */
    public static final int[] f8151a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* JADX INFO: renamed from: b */
    public static final a f8152b = new a();

    /* JADX INFO: renamed from: b.i.a.c.x2.f$a */
    /* JADX INFO: compiled from: DefaultExtractorsFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final AtomicBoolean f8153a = new AtomicBoolean(false);

        /* JADX INFO: renamed from: b */
        @Nullable
        @GuardedBy("extensionLoaded")
        public Constructor<? extends InterfaceC3031h> f8154b;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
    /* JADX INFO: renamed from: a */
    public synchronized InterfaceC3031h[] mo3630a() {
        return mo3631b(Uri.EMPTY, new HashMap());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
    /* JADX INFO: renamed from: b */
    public synchronized InterfaceC3031h[] mo3631b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iM460O0 = C1460d.m460O0(map);
        if (iM460O0 != -1) {
            m3664c(iM460O0, arrayList);
        }
        int iM463P0 = C1460d.m463P0(uri);
        if (iM463P0 != -1 && iM463P0 != iM460O0) {
            m3664c(iM463P0, arrayList);
        }
        for (int i : f8151a) {
            if (i != iM460O0 && i != iM463P0) {
                m3664c(i, arrayList);
            }
        }
        return (InterfaceC3031h[]) arrayList.toArray(new InterfaceC3031h[arrayList.size()]);
    }

    /* JADX INFO: renamed from: c */
    public final void m3664c(int i, List<InterfaceC3031h> list) {
        InterfaceC3031h interfaceC3031hNewInstance;
        Constructor<? extends InterfaceC3031h> constructor;
        switch (i) {
            case 0:
                list.add(new C3080f());
                return;
            case 1:
                list.add(new C3084h());
                return;
            case 2:
                list.add(new C3088j(0));
                return;
            case 3:
                list.add(new C3005b(0));
                return;
            case 4:
                a aVar = f8152b;
                synchronized (aVar.f8153a) {
                    interfaceC3031hNewInstance = null;
                    if (aVar.f8153a.get()) {
                        constructor = aVar.f8154b;
                    } else {
                        try {
                            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                                aVar.f8154b = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(InterfaceC3031h.class).getConstructor(Integer.TYPE);
                            }
                            break;
                        } catch (ClassNotFoundException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Error instantiating FLAC extension", e);
                        }
                        aVar.f8153a.set(true);
                        constructor = aVar.f8154b;
                    }
                }
                if (constructor != null) {
                    try {
                        interfaceC3031hNewInstance = constructor.newInstance(0);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
                if (interfaceC3031hNewInstance != null) {
                    list.add(interfaceC3031hNewInstance);
                    return;
                } else {
                    list.add(new C3010d(0));
                    return;
                }
            case 5:
                list.add(new C3014c());
                return;
            case 6:
                list.add(new C3028e(0));
                return;
            case 7:
                list.add(new C3037f(0));
                return;
            case 8:
                list.add(new C3048g(0));
                list.add(new C3050i(0));
                return;
            case 9:
                list.add(new C3062d());
                return;
            case 10:
                list.add(new C3073b0());
                return;
            case 11:
                list.add(new C3085h0(1, 0, 112800));
                return;
            case 12:
                list.add(new C3108b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new C3018a());
                return;
        }
    }
}
