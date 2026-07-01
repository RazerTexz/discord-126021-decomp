package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioProcessor {
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    boolean a();

    boolean b();

    void c(ByteBuffer byteBuffer);

    AudioProcessor$a d(AudioProcessor$a audioProcessor$a) throws AudioProcessor$UnhandledAudioFormatException;

    void e();

    void flush();

    ByteBuffer getOutput();

    void reset();
}
