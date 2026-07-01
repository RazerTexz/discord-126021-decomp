package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.SeekMap;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.g, reason: use source file name */
/* JADX INFO: compiled from: OggSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public interface OggSeeker {
    @Nullable
    SeekMap a();

    long b(ExtractorInput extractorInput) throws IOException;

    void c(long j);
}
