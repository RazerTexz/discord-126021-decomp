package b.i.a.c.z2;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.z2.g, reason: use source file name */
/* JADX INFO: compiled from: SimpleMetadataDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    @Override // b.i.a.c.z2.MetadataDecoder
    @Nullable
    public final Metadata a(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.l;
        Objects.requireNonNull(byteBuffer);
        AnimatableValueParser.j(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (metadataInputBuffer.m()) {
            return null;
        }
        return b(metadataInputBuffer, byteBuffer);
    }

    @Nullable
    public abstract Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
