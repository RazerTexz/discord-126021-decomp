package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.t2.AudioAttributes;
import b.i.a.c.t2.AuxEffectInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioSink {

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final Format2 format;
        public final boolean isRecoverable;

        public InitializationException(int i, int i2, int i3, int i4, Format2 format2, boolean z2, @Nullable Exception exc) {
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
            this.format = format2;
        }
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedDiscontinuityException(long j, long j2) {
            StringBuilder sbR = outline.R(103, "Unexpected audio track timestamp discontinuity: expected ", j2, ", got ");
            sbR.append(j);
            super(sbR.toString());
            this.actualPresentationTimeUs = j;
            this.expectedPresentationTimeUs = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final Format2 format;
        public final boolean isRecoverable;

        public WriteException(int i, Format2 format2, boolean z2) {
            super(outline.g(36, "AudioTrack write failed: ", i));
            this.isRecoverable = z2;
            this.errorCode = i;
            this.format = format2;
        }
    }

    public interface a {
    }

    boolean a(Format2 format2);

    boolean b();

    PlaybackParameters c();

    void d();

    void e();

    void flush();

    void i(PlaybackParameters playbackParameters);

    void j() throws WriteException;

    boolean k();

    void l(int i);

    long m(boolean z2);

    void n();

    void o(AudioAttributes audioAttributes);

    void p();

    void q(float f);

    void r();

    void reset();

    boolean s(ByteBuffer byteBuffer, long j, int i) throws WriteException, InitializationException;

    void t(a aVar);

    int u(Format2 format2);

    void v(Format2 format2, int i, @Nullable int[] iArr) throws ConfigurationException;

    void w(boolean z2);

    void x(AuxEffectInfo auxEffectInfo);

    public static final class ConfigurationException extends Exception {
        public final Format2 format;

        public ConfigurationException(Throwable th, Format2 format2) {
            super(th);
            this.format = format2;
        }

        public ConfigurationException(String str, Format2 format2) {
            super(str);
            this.format = format2;
        }
    }
}
