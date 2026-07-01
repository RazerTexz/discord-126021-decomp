package b.i.a.c.x2;

import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.h, reason: use source file name */
/* JADX INFO: compiled from: Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Extractor {
    boolean b(ExtractorInput extractorInput) throws IOException;

    int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException;

    void f(ExtractorOutput extractorOutput);

    void g(long j, long j2);

    void release();
}
