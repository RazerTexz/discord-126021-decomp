package b.f.j.s;

import b.f.j.e.n;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: MultiImageTranscoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f644b;
    public final Integer c;
    public final boolean d;

    public e(int i, boolean z2, c cVar, Integer num, boolean z3) {
        this.a = i;
        this.f644b = cVar;
        this.c = num;
        this.d = z3;
    }

    public final b a(b.f.i.c cVar, boolean z2) {
        int i = this.a;
        boolean z3 = this.d;
        try {
            Class<?> cls = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");
            Class<?> cls2 = Boolean.TYPE;
            return ((c) cls.getConstructor(Integer.TYPE, cls2, cls2).newInstance(Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(z3))).createImageTranscoder(cVar, z2);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        }
    }

    @Override // b.f.j.s.c
    public b createImageTranscoder(b.f.i.c cVar, boolean z2) {
        c cVar2 = this.f644b;
        b bVarA = null;
        b bVarCreateImageTranscoder = cVar2 == null ? null : cVar2.createImageTranscoder(cVar, z2);
        if (bVarCreateImageTranscoder == null) {
            Integer num = this.c;
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    bVarA = a(cVar, z2);
                } else {
                    if (iIntValue != 1) {
                        throw new IllegalArgumentException("Invalid ImageTranscoderType");
                    }
                    bVarA = new f(z2, this.a);
                }
            }
            bVarCreateImageTranscoder = bVarA;
        }
        if (bVarCreateImageTranscoder == null && n.a) {
            bVarCreateImageTranscoder = a(cVar, z2);
        }
        return bVarCreateImageTranscoder == null ? new f(z2, this.a) : bVarCreateImageTranscoder;
    }
}
