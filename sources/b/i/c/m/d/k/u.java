package b.i.c.m.d.k;

import b.i.c.m.d.k.x;
import b.i.c.m.d.p.ByteString2;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.p.SessionProtobufHelper;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class u implements x.g {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1695b;
    public final /* synthetic */ long c;

    public u(x xVar, String str, String str2, long j) {
        this.a = str;
        this.f1695b = str2;
        this.c = j;
    }

    @Override // b.i.c.m.d.k.x.g
    public void a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = this.a;
        String str2 = this.f1695b;
        long j = this.c;
        ByteString2 byteString2 = SessionProtobufHelper.a;
        codedOutputStream2.l(1, ByteString2.a(str2));
        codedOutputStream2.l(2, ByteString2.a(str));
        codedOutputStream2.t(3, j);
    }
}
