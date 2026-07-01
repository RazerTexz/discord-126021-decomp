package b.i.a.c.x2.f0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.x2.ExtractorInput;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.c, reason: use source file name */
/* JADX INFO: compiled from: StartOffsetExtractorInput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StartOffsetExtractorInput implements ExtractorInput {
    public final ExtractorInput a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1180b;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j) {
        this.a = extractorInput;
        AnimatableValueParser.j(extractorInput.getPosition() >= j);
        this.f1180b = j;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public long b() {
        return this.a.b() - this.f1180b;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public boolean c(byte[] bArr, int i, int i2, boolean z2) {
        return this.a.c(bArr, i, i2, z2);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public boolean e(byte[] bArr, int i, int i2, boolean z2) {
        return this.a.e(bArr, i, i2, z2);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public long f() {
        return this.a.f() - this.f1180b;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void g(int i) throws IOException {
        this.a.g(i);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public long getPosition() {
        return this.a.getPosition() - this.f1180b;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public int h(int i) {
        return this.a.h(i);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public int i(byte[] bArr, int i, int i2) {
        return this.a.i(bArr, i, i2);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void k() {
        this.a.k();
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void l(int i) throws IOException {
        this.a.l(i);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public boolean m(int i, boolean z2) {
        return this.a.m(i, z2);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void o(byte[] bArr, int i, int i2) throws IOException {
        this.a.o(bArr, i, i2);
    }

    @Override // b.i.a.c.x2.ExtractorInput, b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return this.a.read(bArr, i, i2);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.a.readFully(bArr, i, i2);
    }
}
