package b.i.c.m.d.k;

import android.os.Build;
import b.i.c.m.d.k.x;
import b.i.c.m.d.p.ByteString2;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.p.SessionProtobufHelper;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class w implements x.g {
    public final /* synthetic */ boolean a;

    public w(x xVar, String str, String str2, boolean z2) {
        this.a = z2;
    }

    @Override // b.i.c.m.d.k.x.g
    public void a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = Build.VERSION.RELEASE;
        String str2 = Build.VERSION.CODENAME;
        boolean z2 = this.a;
        ByteString2 byteString2 = SessionProtobufHelper.a;
        ByteString2 byteString2A = ByteString2.a(str);
        ByteString2 byteString2A2 = ByteString2.a(str2);
        codedOutputStream2.r(8, 2);
        codedOutputStream2.o(CodedOutputStream2.a(4, z2) + CodedOutputStream2.b(3, byteString2A2) + CodedOutputStream2.b(2, byteString2A) + CodedOutputStream2.c(1, 3) + 0);
        codedOutputStream2.m(1, 3);
        codedOutputStream2.l(2, byteString2A);
        codedOutputStream2.l(3, byteString2A2);
        codedOutputStream2.k(4, z2);
    }
}
