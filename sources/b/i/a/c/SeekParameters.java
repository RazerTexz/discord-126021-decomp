package b.i.a.c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.c.j2, reason: use source file name */
/* JADX INFO: compiled from: SeekParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SeekParameters {
    public static final SeekParameters a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SeekParameters f1026b;
    public final long c;
    public final long d;

    static {
        SeekParameters seekParameters = new SeekParameters(0L, 0L);
        a = seekParameters;
        AnimatableValueParser.j(RecyclerView.FOREVER_NS >= 0);
        AnimatableValueParser.j(RecyclerView.FOREVER_NS >= 0);
        AnimatableValueParser.j(RecyclerView.FOREVER_NS >= 0);
        AnimatableValueParser.j(0 >= 0);
        AnimatableValueParser.j(0 >= 0);
        AnimatableValueParser.j(RecyclerView.FOREVER_NS >= 0);
        f1026b = seekParameters;
    }

    public SeekParameters(long j, long j2) {
        AnimatableValueParser.j(j >= 0);
        AnimatableValueParser.j(j2 >= 0);
        this.c = j;
        this.d = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        return this.c == seekParameters.c && this.d == seekParameters.d;
    }

    public int hashCode() {
        return (((int) this.c) * 31) + ((int) this.d);
    }
}
