package b.i.a.c.z2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: SimpleMetadataDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements b {
    @Override // b.i.a.c.z2.b
    @Nullable
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.l;
        Objects.requireNonNull(byteBuffer);
        b.c.a.a0.d.j(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (dVar.m()) {
            return null;
        }
        return b(dVar, byteBuffer);
    }

    @Nullable
    public abstract Metadata b(d dVar, ByteBuffer byteBuffer);
}
