package org.webrtc.audio;

/* JADX INFO: loaded from: classes3.dex */
public class JavaAudioDeviceModule$AudioSamples {
    private final int audioFormat;
    private final int channelCount;
    private final byte[] data;
    private final int sampleRate;

    public JavaAudioDeviceModule$AudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.audioFormat = i;
        this.channelCount = i2;
        this.sampleRate = i3;
        this.data = bArr;
    }

    public int getAudioFormat() {
        return this.audioFormat;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }
}
