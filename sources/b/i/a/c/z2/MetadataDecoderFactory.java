package b.i.a.c.z2;

import b.i.a.c.Format2;
import b.i.a.c.z2.h.AppInfoTableDecoder;
import b.i.a.c.z2.i.EventMessageDecoder;
import b.i.a.c.z2.j.IcyDecoder;
import b.i.a.c.z2.k.Id3Decoder;
import b.i.a.c.z2.l.SpliceInfoDecoder;

/* JADX INFO: renamed from: b.i.a.c.z2.c, reason: use source file name */
/* JADX INFO: compiled from: MetadataDecoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory a = new a();

    /* JADX INFO: renamed from: b.i.a.c.z2.c$a */
    /* JADX INFO: compiled from: MetadataDecoderFactory.java */
    public class a implements MetadataDecoderFactory {
        @Override // b.i.a.c.z2.MetadataDecoderFactory
        public boolean a(Format2 format2) {
            String str = format2.w;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // b.i.a.c.z2.MetadataDecoderFactory
        public MetadataDecoder b(Format2 format2) {
            String str = format2.w;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new AppInfoTableDecoder();
                    case "application/x-icy":
                        return new IcyDecoder();
                    case "application/id3":
                        return new Id3Decoder();
                    case "application/x-emsg":
                        return new EventMessageDecoder();
                    case "application/x-scte35":
                        return new SpliceInfoDecoder();
                }
            }
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    boolean a(Format2 format2);

    MetadataDecoder b(Format2 format2);
}
