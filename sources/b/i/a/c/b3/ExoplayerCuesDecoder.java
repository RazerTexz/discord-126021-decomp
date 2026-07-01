package b.i.a.c.b3;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.BundleableUtil;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.decoder.DecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.b3.d, reason: use source file name */
/* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExoplayerCuesDecoder implements SubtitleDecoder {
    public final CueDecoder a = new CueDecoder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubtitleInputBuffer f843b = new SubtitleInputBuffer();
    public final Deque<SubtitleOutputBuffer> c = new ArrayDeque();
    public int d;
    public boolean e;

    /* JADX INFO: renamed from: b.i.a.c.b3.d$a */
    /* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
    public class a extends SubtitleOutputBuffer {
        public a() {
        }

        @Override // b.i.a.c.v2.DecoderOutputBuffer
        public void p() {
            ExoplayerCuesDecoder exoplayerCuesDecoder = ExoplayerCuesDecoder.this;
            AnimatableValueParser.D(exoplayerCuesDecoder.c.size() < 2);
            AnimatableValueParser.j(!exoplayerCuesDecoder.c.contains(this));
            q();
            exoplayerCuesDecoder.c.addFirst(this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.d$b */
    /* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
    public static final class b implements Subtitle {
        public final long j;
        public final ImmutableList2<Cue> k;

        public b(long j, ImmutableList2<Cue> immutableList2) {
            this.j = j;
            this.k = immutableList2;
        }

        @Override // b.i.a.c.b3.Subtitle
        public int f(long j) {
            return this.j > j ? 0 : -1;
        }

        @Override // b.i.a.c.b3.Subtitle
        public long g(int i) {
            AnimatableValueParser.j(i == 0);
            return this.j;
        }

        @Override // b.i.a.c.b3.Subtitle
        public List<Cue> h(long j) {
            if (j >= this.j) {
                return this.k;
            }
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            return RegularImmutableList.l;
        }

        @Override // b.i.a.c.b3.Subtitle
        public int i() {
            return 1;
        }
    }

    public ExoplayerCuesDecoder() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new a());
        }
        this.d = 0;
    }

    @Override // b.i.a.c.b3.SubtitleDecoder
    public void a(long j) {
    }

    @Override // b.i.a.c.v2.Decoder
    @Nullable
    public SubtitleOutputBuffer b() throws DecoderException {
        AnimatableValueParser.D(!this.e);
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer subtitleOutputBufferRemoveFirst = this.c.removeFirst();
        if (this.f843b.n()) {
            subtitleOutputBufferRemoveFirst.j(4);
        } else {
            SubtitleInputBuffer subtitleInputBuffer = this.f843b;
            long j = subtitleInputBuffer.n;
            CueDecoder cueDecoder = this.a;
            ByteBuffer byteBuffer = subtitleInputBuffer.l;
            Objects.requireNonNull(byteBuffer);
            byte[] bArrArray = byteBuffer.array();
            Objects.requireNonNull(cueDecoder);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArrArray, 0, bArrArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
            parcelObtain.recycle();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
            Objects.requireNonNull(parcelableArrayList);
            subtitleOutputBufferRemoveFirst.r(this.f843b.n, new b(j, BundleableUtil.a(Cue.k, parcelableArrayList)), 0L);
        }
        this.f843b.p();
        this.d = 0;
        return subtitleOutputBufferRemoveFirst;
    }

    @Override // b.i.a.c.v2.Decoder
    @Nullable
    public SubtitleInputBuffer c() throws DecoderException {
        AnimatableValueParser.D(!this.e);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.f843b;
    }

    @Override // b.i.a.c.v2.Decoder
    public void d(SubtitleInputBuffer subtitleInputBuffer) throws DecoderException {
        SubtitleInputBuffer subtitleInputBuffer2 = subtitleInputBuffer;
        AnimatableValueParser.D(!this.e);
        AnimatableValueParser.D(this.d == 1);
        AnimatableValueParser.j(this.f843b == subtitleInputBuffer2);
        this.d = 2;
    }

    @Override // b.i.a.c.v2.Decoder
    public void flush() {
        AnimatableValueParser.D(!this.e);
        this.f843b.p();
        this.d = 0;
    }

    @Override // b.i.a.c.v2.Decoder
    public void release() {
        this.e = true;
    }
}
