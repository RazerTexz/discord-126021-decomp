package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.l */
/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4998l extends AbstractC5002p {

    /* JADX INFO: renamed from: h */
    public final AbstractC5002p f13380h = new C4991e();

    /* JADX INFO: renamed from: o */
    public static Result m7000o(Result result) throws FormatException {
        String str = result.f21668a;
        if (str.charAt(0) != '0') {
            throw FormatException.m9260a();
        }
        Result result2 = new Result(str.substring(1), null, result.f21670c, EnumC4946a.UPC_A);
        Map<EnumC4955j, Object> map = result.f21672e;
        if (map != null) {
            result2.m9261a(map);
        }
        return result2;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k, p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, FormatException {
        return m7000o(this.f13380h.mo6919a(c4948c, map));
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p, p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m7000o(this.f13380h.mo6983b(i, c4962a, map));
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: j */
    public int mo6989j(C4962a c4962a, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f13380h.mo6989j(c4962a, iArr, sb);
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: k */
    public Result mo7001k(int i, C4962a c4962a, int[] iArr, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m7000o(this.f13380h.mo7001k(i, c4962a, iArr, map));
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: n */
    public EnumC4946a mo6990n() {
        return EnumC4946a.UPC_A;
    }
}
