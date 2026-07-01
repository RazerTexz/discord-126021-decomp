package b.i.a.c.z2.i;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.z2.MetadataInputBuffer;
import b.i.a.c.z2.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.z2.i.a, reason: use source file name */
/* JADX INFO: compiled from: EventMessageDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EventMessageDecoder extends SimpleMetadataDecoder {
    @Override // b.i.a.c.z2.SimpleMetadataDecoder
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(byteBuffer.array(), byteBuffer.limit());
        String strN = parsableByteArray.n();
        Objects.requireNonNull(strN);
        String strN2 = parsableByteArray.n();
        Objects.requireNonNull(strN2);
        return new Metadata(new EventMessage(strN, strN2, parsableByteArray.m(), parsableByteArray.m(), Arrays.copyOfRange(parsableByteArray.a, parsableByteArray.f984b, parsableByteArray.c)));
    }
}
