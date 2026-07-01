package b.i.a.c.z2.i;

import b.i.a.c.f3.x;
import b.i.a.c.z2.d;
import b.i.a.c.z2.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: EventMessageDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends g {
    @Override // b.i.a.c.z2.g
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        x xVar = new x(byteBuffer.array(), byteBuffer.limit());
        String strN = xVar.n();
        Objects.requireNonNull(strN);
        String strN2 = xVar.n();
        Objects.requireNonNull(strN2);
        return new Metadata(new EventMessage(strN, strN2, xVar.m(), xVar.m(), Arrays.copyOfRange(xVar.a, xVar.f984b, xVar.c)));
    }
}
