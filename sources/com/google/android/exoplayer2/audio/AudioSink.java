package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2998x1;
import p007b.p225i.p226a.p242c.p263t2.C2931o;
import p007b.p225i.p226a.p242c.p263t2.C2937u;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioSink {

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final C2811j1 format;
        public final boolean isRecoverable;

        public InitializationException(int i, int i2, int i3, int i4, C2811j1 c2811j1, boolean z2, @Nullable Exception exc) {
            String str = z2 ? " (recoverable)" : "";
            StringBuilder sb = new StringBuilder(str.length() + 80);
            sb.append("AudioTrack init failed ");
            sb.append(i);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(")");
            sb.append(str);
            super(sb.toString(), exc);
            this.audioTrackState = i;
            this.isRecoverable = z2;
            this.format = c2811j1;
        }
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedDiscontinuityException(long j, long j2) {
            StringBuilder sbM830R = C1643a.m830R(103, "Unexpected audio track timestamp discontinuity: expected ", j2, ", got ");
            sbM830R.append(j);
            super(sbM830R.toString());
            this.actualPresentationTimeUs = j;
            this.expectedPresentationTimeUs = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final C2811j1 format;
        public final boolean isRecoverable;

        public WriteException(int i, C2811j1 c2811j1, boolean z2) {
            super(C1643a.m851g(36, "AudioTrack write failed: ", i));
            this.isRecoverable = z2;
            this.errorCode = i;
            this.format = c2811j1;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.audio.AudioSink$a */
    public interface InterfaceC10686a {
    }

    /* JADX INFO: renamed from: a */
    boolean mo8757a(C2811j1 c2811j1);

    /* JADX INFO: renamed from: b */
    boolean mo8758b();

    /* JADX INFO: renamed from: c */
    C2998x1 mo8759c();

    /* JADX INFO: renamed from: d */
    void mo8760d();

    /* JADX INFO: renamed from: e */
    void mo8761e();

    void flush();

    /* JADX INFO: renamed from: i */
    void mo8762i(C2998x1 c2998x1);

    /* JADX INFO: renamed from: j */
    void mo8763j() throws WriteException;

    /* JADX INFO: renamed from: k */
    boolean mo8764k();

    /* JADX INFO: renamed from: l */
    void mo8765l(int i);

    /* JADX INFO: renamed from: m */
    long mo8766m(boolean z2);

    /* JADX INFO: renamed from: n */
    void mo8767n();

    /* JADX INFO: renamed from: o */
    void mo8768o(C2931o c2931o);

    /* JADX INFO: renamed from: p */
    void mo8769p();

    /* JADX INFO: renamed from: q */
    void mo8770q(float f);

    /* JADX INFO: renamed from: r */
    void mo8771r();

    void reset();

    /* JADX INFO: renamed from: s */
    boolean mo8772s(ByteBuffer byteBuffer, long j, int i) throws WriteException, InitializationException;

    /* JADX INFO: renamed from: t */
    void mo8773t(InterfaceC10686a interfaceC10686a);

    /* JADX INFO: renamed from: u */
    int mo8774u(C2811j1 c2811j1);

    /* JADX INFO: renamed from: v */
    void mo8775v(C2811j1 c2811j1, int i, @Nullable int[] iArr) throws ConfigurationException;

    /* JADX INFO: renamed from: w */
    void mo8776w(boolean z2);

    /* JADX INFO: renamed from: x */
    void mo8777x(C2937u c2937u);

    public static final class ConfigurationException extends Exception {
        public final C2811j1 format;

        public ConfigurationException(Throwable th, C2811j1 c2811j1) {
            super(th);
            this.format = c2811j1;
        }

        public ConfigurationException(String str, C2811j1 c2811j1) {
            super(str);
            this.format = c2811j1;
        }
    }
}
