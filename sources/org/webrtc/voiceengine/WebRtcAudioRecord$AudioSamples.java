package org.webrtc.voiceengine;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioRecord$AudioSamples {
    private final int audioFormat;
    private final int channelCount;
    private final byte[] data;
    private final int sampleRate;

    public /* synthetic */ WebRtcAudioRecord$AudioSamples(AudioRecord audioRecord, byte[] bArr, WebRtcAudioRecord$1 webRtcAudioRecord$1) {
        this(audioRecord, bArr);
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

    private WebRtcAudioRecord$AudioSamples(AudioRecord audioRecord, byte[] bArr) {
        this.audioFormat = audioRecord.getAudioFormat();
        this.channelCount = audioRecord.getChannelCount();
        this.sampleRate = audioRecord.getSampleRate();
        this.data = bArr;
    }
}
