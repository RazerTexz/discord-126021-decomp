package b.i.c.w;

import b.i.a.b.Transformer;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Transformer {
    public static final Transformer a = new p();

    @Override // b.i.a.b.Transformer
    public final Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
