package b.i.c.m.d.k;

import android.os.Build;
import b.i.c.m.d.k.x;
import b.i.c.m.d.p.ByteString2;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.p.SessionProtobufHelper;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class y implements x.g {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1705b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;

    public y(x xVar, int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3) {
        this.a = i;
        this.f1705b = i2;
        this.c = j;
        this.d = j2;
        this.e = z2;
        this.f = i3;
    }

    @Override // b.i.c.m.d.k.x.g
    public void a(CodedOutputStream2 codedOutputStream2) throws Exception {
        int i = this.a;
        String str = Build.MODEL;
        int i2 = this.f1705b;
        long j = this.c;
        long j2 = this.d;
        boolean z2 = this.e;
        int i3 = this.f;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        ByteString2 byteString2J = SessionProtobufHelper.j(str);
        ByteString2 byteString2J2 = SessionProtobufHelper.j(str3);
        ByteString2 byteString2J3 = SessionProtobufHelper.j(str2);
        codedOutputStream2.r(9, 2);
        int iC = CodedOutputStream2.c(3, i) + 0;
        int iB = byteString2J == null ? 0 : CodedOutputStream2.b(4, byteString2J);
        int iF = CodedOutputStream2.f(5, i2);
        int iH = CodedOutputStream2.h(6, j);
        int iH2 = CodedOutputStream2.h(7, j2);
        codedOutputStream2.o(CodedOutputStream2.f(12, i3) + CodedOutputStream2.a(10, z2) + iH2 + iH + iF + iC + iB + (byteString2J3 == null ? 0 : CodedOutputStream2.b(13, byteString2J3)) + (byteString2J2 == null ? 0 : CodedOutputStream2.b(14, byteString2J2)));
        codedOutputStream2.m(3, i);
        codedOutputStream2.l(4, byteString2J);
        codedOutputStream2.s(5, i2);
        codedOutputStream2.t(6, j);
        codedOutputStream2.t(7, j2);
        codedOutputStream2.k(10, z2);
        codedOutputStream2.s(12, i3);
        if (byteString2J3 != null) {
            codedOutputStream2.l(13, byteString2J3);
        }
        if (byteString2J2 != null) {
            codedOutputStream2.l(14, byteString2J2);
        }
    }
}
