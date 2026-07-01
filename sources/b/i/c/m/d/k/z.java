package b.i.c.m.d.k;

import b.i.c.m.d.k.x;
import b.i.c.m.d.p.ByteString2;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.p.SessionProtobufHelper;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class z implements x.g {
    public final /* synthetic */ UserMetadata a;

    public z(x xVar, UserMetadata userMetadata) {
        this.a = userMetadata;
    }

    @Override // b.i.c.m.d.k.x.g
    public void a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = this.a.a;
        ByteString2 byteString2 = SessionProtobufHelper.a;
        if (str == null) {
            str = "";
        }
        ByteString2 byteString2A = ByteString2.a(str);
        SessionProtobufHelper.j(null);
        SessionProtobufHelper.j(null);
        int iB = CodedOutputStream2.b(1, byteString2A) + 0;
        codedOutputStream2.r(6, 2);
        codedOutputStream2.o(iB);
        codedOutputStream2.l(1, byteString2A);
    }
}
