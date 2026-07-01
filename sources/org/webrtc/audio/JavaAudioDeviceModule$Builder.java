package org.webrtc.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build$VERSION;
import java.util.concurrent.ScheduledExecutorService;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: loaded from: classes3.dex */
public class JavaAudioDeviceModule$Builder {
    private AudioAttributes audioAttributes;
    private int audioFormat;
    private final AudioManager audioManager;
    private JavaAudioDeviceModule$AudioRecordErrorCallback audioRecordErrorCallback;
    private JavaAudioDeviceModule$AudioRecordStateCallback audioRecordStateCallback;
    private int audioSource;
    private JavaAudioDeviceModule$AudioTrackErrorCallback audioTrackErrorCallback;
    private JavaAudioDeviceModule$AudioTrackStateCallback audioTrackStateCallback;
    private final Context context;
    private int inputSampleRate;
    private int outputSampleRate;
    private JavaAudioDeviceModule$SamplesReadyCallback samplesReadyCallback;
    private ScheduledExecutorService scheduler;
    private boolean useHardwareAcousticEchoCanceler;
    private boolean useHardwareNoiseSuppressor;
    private boolean useLowLatency;
    private boolean useStereoInput;
    private boolean useStereoOutput;

    public /* synthetic */ JavaAudioDeviceModule$Builder(Context context, JavaAudioDeviceModule$1 javaAudioDeviceModule$1) {
        this(context);
    }

    public JavaAudioDeviceModule createAudioDeviceModule() {
        Logging.d("JavaAudioDeviceModule", "createAudioDeviceModule");
        if (this.useHardwareNoiseSuppressor) {
            Logging.d("JavaAudioDeviceModule", "HW NS will be used.");
        } else {
            if (JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                Logging.d("JavaAudioDeviceModule", "Overriding default behavior; now using WebRTC NS!");
            }
            Logging.d("JavaAudioDeviceModule", "HW NS will not be used.");
        }
        if (this.useHardwareAcousticEchoCanceler) {
            Logging.d("JavaAudioDeviceModule", "HW AEC will be used.");
        } else {
            if (JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                Logging.d("JavaAudioDeviceModule", "Overriding default behavior; now using WebRTC AEC!");
            }
            Logging.d("JavaAudioDeviceModule", "HW AEC will not be used.");
        }
        if (this.useLowLatency && Build$VERSION.SDK_INT >= 26) {
            Logging.d("JavaAudioDeviceModule", "Low latency mode will be used.");
        }
        ScheduledExecutorService scheduledExecutorServiceNewDefaultScheduler = this.scheduler;
        if (scheduledExecutorServiceNewDefaultScheduler == null) {
            scheduledExecutorServiceNewDefaultScheduler = WebRtcAudioRecord.newDefaultScheduler();
        }
        return new JavaAudioDeviceModule(this.context, this.audioManager, new WebRtcAudioRecord(this.context, scheduledExecutorServiceNewDefaultScheduler, this.audioManager, this.audioSource, this.audioFormat, this.audioRecordErrorCallback, this.audioRecordStateCallback, this.samplesReadyCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor), new WebRtcAudioTrack(this.context, this.audioManager, this.audioAttributes, this.audioTrackErrorCallback, this.audioTrackStateCallback, this.useLowLatency), this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput, null);
    }

    public JavaAudioDeviceModule$Builder setAudioAttributes(AudioAttributes audioAttributes) {
        this.audioAttributes = audioAttributes;
        return this;
    }

    public JavaAudioDeviceModule$Builder setAudioFormat(int i) {
        this.audioFormat = i;
        return this;
    }

    public JavaAudioDeviceModule$Builder setAudioRecordErrorCallback(JavaAudioDeviceModule$AudioRecordErrorCallback javaAudioDeviceModule$AudioRecordErrorCallback) {
        this.audioRecordErrorCallback = javaAudioDeviceModule$AudioRecordErrorCallback;
        return this;
    }

    public JavaAudioDeviceModule$Builder setAudioRecordStateCallback(JavaAudioDeviceModule$AudioRecordStateCallback javaAudioDeviceModule$AudioRecordStateCallback) {
        this.audioRecordStateCallback = javaAudioDeviceModule$AudioRecordStateCallback;
        return this;
    }

    public JavaAudioDeviceModule$Builder setAudioSource(int i) {
        this.audioSource = i;
        return this;
    }

    public JavaAudioDeviceModule$Builder setAudioTrackErrorCallback(JavaAudioDeviceModule$AudioTrackErrorCallback javaAudioDeviceModule$AudioTrackErrorCallback) {
        this.audioTrackErrorCallback = javaAudioDeviceModule$AudioTrackErrorCallback;
        return this;
    }

    public JavaAudioDeviceModule$Builder setAudioTrackStateCallback(JavaAudioDeviceModule$AudioTrackStateCallback javaAudioDeviceModule$AudioTrackStateCallback) {
        this.audioTrackStateCallback = javaAudioDeviceModule$AudioTrackStateCallback;
        return this;
    }

    public JavaAudioDeviceModule$Builder setInputSampleRate(int i) {
        Logging.d("JavaAudioDeviceModule", "Input sample rate overridden to: " + i);
        this.inputSampleRate = i;
        return this;
    }

    public JavaAudioDeviceModule$Builder setOutputSampleRate(int i) {
        Logging.d("JavaAudioDeviceModule", "Output sample rate overridden to: " + i);
        this.outputSampleRate = i;
        return this;
    }

    public JavaAudioDeviceModule$Builder setSampleRate(int i) {
        Logging.d("JavaAudioDeviceModule", "Input/Output sample rate overridden to: " + i);
        this.inputSampleRate = i;
        this.outputSampleRate = i;
        return this;
    }

    public JavaAudioDeviceModule$Builder setSamplesReadyCallback(JavaAudioDeviceModule$SamplesReadyCallback javaAudioDeviceModule$SamplesReadyCallback) {
        this.samplesReadyCallback = javaAudioDeviceModule$SamplesReadyCallback;
        return this;
    }

    public JavaAudioDeviceModule$Builder setScheduler(ScheduledExecutorService scheduledExecutorService) {
        this.scheduler = scheduledExecutorService;
        return this;
    }

    public JavaAudioDeviceModule$Builder setUseHardwareAcousticEchoCanceler(boolean z2) {
        if (z2 && !JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
            Logging.e("JavaAudioDeviceModule", "HW AEC not supported");
            z2 = false;
        }
        this.useHardwareAcousticEchoCanceler = z2;
        return this;
    }

    public JavaAudioDeviceModule$Builder setUseHardwareNoiseSuppressor(boolean z2) {
        if (z2 && !JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
            Logging.e("JavaAudioDeviceModule", "HW NS not supported");
            z2 = false;
        }
        this.useHardwareNoiseSuppressor = z2;
        return this;
    }

    public JavaAudioDeviceModule$Builder setUseLowLatency(boolean z2) {
        this.useLowLatency = z2;
        return this;
    }

    public JavaAudioDeviceModule$Builder setUseStereoInput(boolean z2) {
        this.useStereoInput = z2;
        return this;
    }

    public JavaAudioDeviceModule$Builder setUseStereoOutput(boolean z2) {
        this.useStereoOutput = z2;
        return this;
    }

    private JavaAudioDeviceModule$Builder(Context context) {
        this.audioSource = 7;
        this.audioFormat = 2;
        this.useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
        this.useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
        this.context = context;
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.audioManager = audioManager;
        this.inputSampleRate = WebRtcAudioManager.getSampleRate(audioManager);
        this.outputSampleRate = WebRtcAudioManager.getSampleRate(audioManager);
        this.useLowLatency = false;
    }
}
