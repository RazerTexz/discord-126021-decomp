package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioProcessor {

    /* JADX INFO: renamed from: a */
    public static final ByteBuffer f19694a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnhandledAudioFormatException(C10685a c10685a) {
            String strValueOf = String.valueOf(c10685a);
            super(C1643a.m857j(strValueOf.length() + 18, "Unhandled format: ", strValueOf));
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.audio.AudioProcessor$a */
    public static final class C10685a {

        /* JADX INFO: renamed from: a */
        public static final C10685a f19695a = new C10685a(-1, -1, -1);

        /* JADX INFO: renamed from: b */
        public final int f19696b;

        /* JADX INFO: renamed from: c */
        public final int f19697c;

        /* JADX INFO: renamed from: d */
        public final int f19698d;

        /* JADX INFO: renamed from: e */
        public final int f19699e;

        public C10685a(int i, int i2, int i3) {
            this.f19696b = i;
            this.f19697c = i2;
            this.f19698d = i3;
            this.f19699e = C2738e0.m3018z(i3) ? C2738e0.m3011s(i3, i2) : -1;
        }

        public String toString() {
            int i = this.f19696b;
            int i2 = this.f19697c;
            int i3 = this.f19698d;
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

    /* JADX INFO: renamed from: a */
    boolean mo3472a();

    /* JADX INFO: renamed from: b */
    boolean mo3485b();

    /* JADX INFO: renamed from: c */
    void mo3470c(ByteBuffer byteBuffer);

    /* JADX INFO: renamed from: d */
    C10685a mo3486d(C10685a c10685a) throws UnhandledAudioFormatException;

    /* JADX INFO: renamed from: e */
    void mo3487e();

    void flush();

    ByteBuffer getOutput();

    void reset();
}
