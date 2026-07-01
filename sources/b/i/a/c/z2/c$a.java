package b.i.a.c.z2;

import b.i.a.c.j1;

/* JADX INFO: compiled from: MetadataDecoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a implements c {
    @Override // b.i.a.c.z2.c
    public boolean a(j1 j1Var) {
        String str = j1Var.w;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }

    @Override // b.i.a.c.z2.c
    public b b(j1 j1Var) {
        String str = j1Var.w;
        if (str != null) {
            switch (str) {
                case "application/vnd.dvb.ait":
                    return new b.i.a.c.z2.h.a();
                case "application/x-icy":
                    return new b.i.a.c.z2.j.a();
                case "application/id3":
                    return new b.i.a.c.z2.k.b();
                case "application/x-emsg":
                    return new b.i.a.c.z2.i.a();
                case "application/x-scte35":
                    return new b.i.a.c.z2.l.a();
            }
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
    }
}
