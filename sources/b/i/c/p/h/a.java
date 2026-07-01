package b.i.c.p.h;

import com.google.firebase.encoders.EncodingException;

/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements b.i.c.p.c {
    public static final a a = new a();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) {
        e$a e_a = e.a;
        StringBuilder sbU = b.d.b.a.a.U("Couldn't find encoder for type ");
        sbU.append(obj.getClass().getCanonicalName());
        throw new EncodingException(sbU.toString());
    }
}
