package p007b.p225i.p226a.p242c.p279z2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.z2.g */
/* JADX INFO: compiled from: SimpleMetadataDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3161g implements InterfaceC3156b {
    @Override // p007b.p225i.p226a.p242c.p279z2.InterfaceC3156b
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Metadata mo3895a(C3158d c3158d) {
        ByteBuffer byteBuffer = c3158d.f19778l;
        Objects.requireNonNull(byteBuffer);
        C1460d.m531j(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (c3158d.m3554m()) {
            return null;
        }
        return mo3899b(c3158d, byteBuffer);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract Metadata mo3899b(C3158d c3158d, ByteBuffer byteBuffer);
}
