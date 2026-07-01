package b.i.a.c.x2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.x2.c0.AmrExtractor;
import b.i.a.c.x2.d0.FlacExtractor;
import b.i.a.c.x2.e0.FlvExtractor;
import b.i.a.c.x2.f0.JpegExtractor;
import b.i.a.c.x2.g0.MatroskaExtractor;
import b.i.a.c.x2.h0.Mp3Extractor;
import b.i.a.c.x2.i0.FragmentedMp4Extractor;
import b.i.a.c.x2.i0.Mp4Extractor;
import b.i.a.c.x2.j0.OggExtractor;
import b.i.a.c.x2.k0.Ac3Extractor;
import b.i.a.c.x2.k0.Ac4Extractor;
import b.i.a.c.x2.k0.AdtsExtractor;
import b.i.a.c.x2.k0.PsExtractor;
import b.i.a.c.x2.k0.TsExtractor;
import b.i.a.c.x2.l0.WavExtractor;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.i.a.c.x2.f, reason: use source file name */
/* JADX INFO: compiled from: DefaultExtractorsFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory2 {
    public static final int[] a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1175b = new a();

    /* JADX INFO: renamed from: b.i.a.c.x2.f$a */
    /* JADX INFO: compiled from: DefaultExtractorsFactory.java */
    public static final class a {
        public final AtomicBoolean a = new AtomicBoolean(false);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        @GuardedBy("extensionLoaded")
        public Constructor<? extends Extractor> f1176b;
    }

    @Override // b.i.a.c.x2.ExtractorsFactory2
    public synchronized Extractor[] a() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Override // b.i.a.c.x2.ExtractorsFactory2
    public synchronized Extractor[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iO0 = AnimatableValueParser.O0(map);
        if (iO0 != -1) {
            c(iO0, arrayList);
        }
        int iP0 = AnimatableValueParser.P0(uri);
        if (iP0 != -1 && iP0 != iO0) {
            c(iP0, arrayList);
        }
        for (int i : a) {
            if (i != iO0 && i != iP0) {
                c(i, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    public final void c(int i, List<Extractor> list) {
        Extractor extractorNewInstance;
        Constructor<? extends Extractor> constructor;
        switch (i) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                list.add(new AdtsExtractor(0));
                return;
            case 3:
                list.add(new AmrExtractor(0));
                return;
            case 4:
                a aVar = f1175b;
                synchronized (aVar.a) {
                    extractorNewInstance = null;
                    if (aVar.a.get()) {
                        constructor = aVar.f1176b;
                    } else {
                        try {
                            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                                aVar.f1176b = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
                            }
                            break;
                        } catch (ClassNotFoundException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Error instantiating FLAC extension", e);
                        }
                        aVar.a.set(true);
                        constructor = aVar.f1176b;
                    }
                }
                if (constructor != null) {
                    try {
                        extractorNewInstance = constructor.newInstance(0);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
                if (extractorNewInstance != null) {
                    list.add(extractorNewInstance);
                    return;
                } else {
                    list.add(new FlacExtractor(0));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                list.add(new MatroskaExtractor(0));
                return;
            case 7:
                list.add(new Mp3Extractor(0));
                return;
            case 8:
                list.add(new FragmentedMp4Extractor(0));
                list.add(new Mp4Extractor(0));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                list.add(new TsExtractor(1, 0, 112800));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new JpegExtractor());
                return;
        }
    }
}
