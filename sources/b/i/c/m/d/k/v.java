package b.i.c.m.d.k;

import b.i.c.m.d.k.x;
import b.i.c.m.d.p.ByteString2;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.p.SessionProtobufHelper;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class v implements x.g {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1697b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ x f;

    public v(x xVar, String str, String str2, String str3, String str4, int i) {
        this.f = xVar;
        this.a = str;
        this.f1697b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
    }

    @Override // b.i.c.m.d.k.x.g
    public void a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = this.a;
        String str2 = this.f1697b;
        String str3 = this.c;
        String str4 = this.d;
        int i = this.e;
        String str5 = this.f.f1702y;
        ByteString2 byteString2 = SessionProtobufHelper.a;
        ByteString2 byteString2A = ByteString2.a(str);
        ByteString2 byteString2A2 = ByteString2.a(str2);
        ByteString2 byteString2A3 = ByteString2.a(str3);
        ByteString2 byteString2A4 = ByteString2.a(str4);
        ByteString2 byteString2A5 = str5 != null ? ByteString2.a(str5) : null;
        codedOutputStream2.r(7, 2);
        int iB = CodedOutputStream2.b(6, byteString2A4) + CodedOutputStream2.b(3, byteString2A3) + CodedOutputStream2.b(2, byteString2A2) + CodedOutputStream2.b(1, byteString2A) + 0;
        if (byteString2A5 != null) {
            iB = CodedOutputStream2.b(9, byteString2A5) + CodedOutputStream2.b(8, SessionProtobufHelper.f1740b) + iB;
        }
        codedOutputStream2.o(CodedOutputStream2.c(10, i) + iB);
        codedOutputStream2.l(1, byteString2A);
        codedOutputStream2.l(2, byteString2A2);
        codedOutputStream2.l(3, byteString2A3);
        codedOutputStream2.l(6, byteString2A4);
        if (byteString2A5 != null) {
            codedOutputStream2.l(8, SessionProtobufHelper.f1740b);
            codedOutputStream2.l(9, byteString2A5);
        }
        codedOutputStream2.m(10, i);
    }
}
