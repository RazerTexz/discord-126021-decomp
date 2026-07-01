package b.g.a.c.g0.u;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: renamed from: b.g.a.c.g0.u.q, reason: use source file name */
/* JADX INFO: compiled from: InetSocketAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public /* bridge */ /* synthetic */ void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        p((InetSocketAddress) obj, jsonGenerator);
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        WritableTypeId writableTypeIdD = typeSerializer.d(inetSocketAddress, JsonToken2.VALUE_STRING);
        writableTypeIdD.f675b = InetSocketAddress.class;
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, writableTypeIdD);
        p(inetSocketAddress, jsonGenerator);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public void p(InetSocketAddress inetSocketAddress, JsonGenerator jsonGenerator) throws IOException {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    StringBuilder sbU = outline.U("[");
                    sbU.append(hostName.substring(1));
                    sbU.append("]");
                    strSubstring = sbU.toString();
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        StringBuilder sbX = outline.X(hostName, ":");
        sbX.append(inetSocketAddress.getPort());
        jsonGenerator.j0(sbX.toString());
    }
}
