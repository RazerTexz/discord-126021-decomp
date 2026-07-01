package com.google.android.exoplayer2.audio;

import b.d.b.a.outline;
import b.i.a.c.f3.Util2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioProcessor {
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnhandledAudioFormatException(a aVar) {
            String strValueOf = String.valueOf(aVar);
            super(outline.j(strValueOf.length() + 18, "Unhandled format: ", strValueOf));
        }
    }

    public static final class a {
        public static final a a = new a(-1, -1, -1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2914b;
        public final int c;
        public final int d;
        public final int e;

        public a(int i, int i2, int i3) {
            this.f2914b = i;
            this.c = i2;
            this.d = i3;
            this.e = Util2.z(i3) ? Util2.s(i3, i2) : -1;
        }

        public String toString() {
            int i = this.f2914b;
            int i2 = this.c;
            int i3 = this.d;
            StringBuilder sb = new StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i);
            sb.append(", channelCount=");
            sb.append(i2);
            sb.append(", encoding=");
            sb.append(i3);
            sb.append(']');
            return sb.toString();
        }
    }

    boolean a();

    boolean b();

    void c(ByteBuffer byteBuffer);

    a d(a aVar) throws UnhandledAudioFormatException;

    void e();

    void flush();

    ByteBuffer getOutput();

    void reset();
}
