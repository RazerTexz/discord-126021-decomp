package p007b.p225i.p226a.p242c.p279z2.p281i;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p279z2.AbstractC3161g;
import p007b.p225i.p226a.p242c.p279z2.C3158d;

/* JADX INFO: renamed from: b.i.a.c.z2.i.a */
/* JADX INFO: compiled from: EventMessageDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3163a extends AbstractC3161g {
    @Override // p007b.p225i.p226a.p242c.p279z2.AbstractC3161g
    /* JADX INFO: renamed from: b */
    public Metadata mo3899b(C3158d c3158d, ByteBuffer byteBuffer) {
        C2757x c2757x = new C2757x(byteBuffer.array(), byteBuffer.limit());
        String strM3094n = c2757x.m3094n();
        Objects.requireNonNull(strM3094n);
        String strM3094n2 = c2757x.m3094n();
        Objects.requireNonNull(strM3094n2);
        return new Metadata(new EventMessage(strM3094n, strM3094n2, c2757x.m3093m(), c2757x.m3093m(), Arrays.copyOfRange(c2757x.f6793a, c2757x.f6794b, c2757x.f6795c)));
    }
}
