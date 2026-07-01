package b.i.a.c.b3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.v2.DecoderOutputBuffer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.b3.k, reason: use source file name */
/* JADX INFO: compiled from: SubtitleOutputBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    @Nullable
    public Subtitle l;
    public long m;

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        Subtitle subtitle = this.l;
        Objects.requireNonNull(subtitle);
        return subtitle.f(j - this.m);
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        Subtitle subtitle = this.l;
        Objects.requireNonNull(subtitle);
        return subtitle.g(i) + this.m;
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        Subtitle subtitle = this.l;
        Objects.requireNonNull(subtitle);
        return subtitle.h(j - this.m);
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        Subtitle subtitle = this.l;
        Objects.requireNonNull(subtitle);
        return subtitle.i();
    }

    public void q() {
        this.j = 0;
        this.l = null;
    }

    public void r(long j, Subtitle subtitle, long j2) {
        this.k = j;
        this.l = subtitle;
        if (j2 != RecyclerView.FOREVER_NS) {
            j = j2;
        }
        this.m = j;
    }
}
