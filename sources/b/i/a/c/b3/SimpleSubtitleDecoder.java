package b.i.a.c.b3;

/* JADX INFO: renamed from: b.i.a.c.b3.e, reason: use source file name */
/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleSubtitleDecoder extends SubtitleOutputBuffer {
    public final /* synthetic */ SimpleSubtitleDecoder2 n;

    public SimpleSubtitleDecoder(SimpleSubtitleDecoder2 simpleSubtitleDecoder2) {
        this.n = simpleSubtitleDecoder2;
    }

    @Override // b.i.a.c.v2.DecoderOutputBuffer
    public void p() {
        SimpleSubtitleDecoder2 simpleSubtitleDecoder2 = this.n;
        synchronized (simpleSubtitleDecoder2.f1145b) {
            q();
            O[] oArr = simpleSubtitleDecoder2.f;
            int i = simpleSubtitleDecoder2.h;
            simpleSubtitleDecoder2.h = i + 1;
            oArr[i] = this;
            simpleSubtitleDecoder2.g();
        }
    }
}
