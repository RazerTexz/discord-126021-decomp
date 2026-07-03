package p007b.p225i.p226a.p242c.p279z2;

import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p279z2.p280h.C3162a;
import p007b.p225i.p226a.p242c.p279z2.p281i.C3163a;
import p007b.p225i.p226a.p242c.p279z2.p282j.C3165a;
import p007b.p225i.p226a.p242c.p279z2.p283k.C3167b;
import p007b.p225i.p226a.p242c.p279z2.p284l.C3168a;

/* JADX INFO: renamed from: b.i.a.c.z2.c */
/* JADX INFO: compiled from: MetadataDecoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3157c {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC3157c f9136a = new a();

    /* JADX INFO: renamed from: b.i.a.c.z2.c$a */
    /* JADX INFO: compiled from: MetadataDecoderFactory.java */
    public class a implements InterfaceC3157c {
        @Override // p007b.p225i.p226a.p242c.p279z2.InterfaceC3157c
        /* JADX INFO: renamed from: a */
        public boolean mo3896a(C2811j1 c2811j1) {
            String str = c2811j1.f7155w;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // p007b.p225i.p226a.p242c.p279z2.InterfaceC3157c
        /* JADX INFO: renamed from: b */
        public InterfaceC3156b mo3897b(C2811j1 c2811j1) {
            String str = c2811j1.f7155w;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new C3162a();
                    case "application/x-icy":
                        return new C3165a();
                    case "application/id3":
                        return new C3167b();
                    case "application/x-emsg":
                        return new C3163a();
                    case "application/x-scte35":
                        return new C3168a();
                }
            }
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    /* JADX INFO: renamed from: a */
    boolean mo3896a(C2811j1 c2811j1);

    /* JADX INFO: renamed from: b */
    InterfaceC3156b mo3897b(C2811j1 c2811j1);
}
