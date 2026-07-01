package b.a.q.m0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioFormat$Builder;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioPlaybackCaptureConfiguration$Builder;
import android.media.AudioRecord;
import android.media.AudioRecord$Builder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection$Callback;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import co.discord.media_engine.NativeCapturerObserver;
import co.discord.media_engine.SoundshareAudioSource;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.webrtc.CapturerObserver;
import org.webrtc.JniCommon;
import org.webrtc.ScreenCapturerAndroid;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoFrame;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ScreenCapturer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ScreenCapturerAndroid {
    public static final b$a j = new b$a(null);
    public final b$b k;
    public NativeCapturerObserver l;
    public SurfaceTextureHelper m;
    public Context n;
    public final SoundshareAudioSource o;
    public int p;
    public int q;
    public Long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f267s;
    public final Rect t;
    public final Point u;
    public int v;
    public Subscription w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Logger f268x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ThumbnailEmitter f269y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Intent intent, MediaProjection$Callback mediaProjection$Callback, Logger logger, ThumbnailEmitter thumbnailEmitter) {
        super(intent, mediaProjection$Callback);
        m.checkNotNullParameter(intent, "mediaProjectionPermissionResultData");
        m.checkNotNullParameter(mediaProjection$Callback, "mediaProjectionCallback");
        m.checkNotNullParameter(logger, "logger");
        this.f268x = logger;
        this.f269y = thumbnailEmitter;
        this.k = new b$b(this);
        this.o = new SoundshareAudioSource();
        this.f267s = new Rect();
        this.t = new Rect();
        this.u = new Point();
    }

    public final synchronized void a(Rect rect, int i) {
        m.checkNotNullParameter(rect, "measuredSize");
        int iMax = Math.max(rect.width(), rect.height());
        if (iMax > 0) {
            float f = i / iMax;
            this.u.set((int) (rect.width() * f), (int) (rect.height() * f));
            Point point = this.u;
            int i2 = point.x;
            int i3 = i2 % 16;
            if (i3 >= 8) {
                i2 += 16;
            }
            int i4 = i2 - i3;
            int i5 = point.y;
            int i6 = i5 % 16;
            if (i6 >= 8) {
                i5 += 16;
            }
            point.set(i4, i5 - i6);
            Point point2 = this.u;
            super.changeCaptureFormat(point2.x, point2.y, this.p);
        }
    }

    @RequiresApi(29)
    public final AudioRecord b() {
        MediaProjection mediaProjection = this.mediaProjection;
        if (mediaProjection == null) {
            return null;
        }
        AudioPlaybackCaptureConfiguration audioPlaybackCaptureConfigurationBuild = new AudioPlaybackCaptureConfiguration$Builder(mediaProjection).addMatchingUsage(1).addMatchingUsage(14).addMatchingUsage(0).build();
        m.checkNotNullExpressionValue(audioPlaybackCaptureConfigurationBuild, "AudioPlaybackCaptureConf…KNOWN)\n          .build()");
        try {
            return new AudioRecord$Builder().setAudioFormat(new AudioFormat$Builder().setEncoding(2).setSampleRate(44100).setChannelMask(16).build()).setAudioPlaybackCaptureConfig(audioPlaybackCaptureConfigurationBuild).build();
        } catch (SecurityException unused) {
            Log.w(b.class.getName(), "Failed to record audio");
            return null;
        }
    }

    public final void c() {
        if (this.p > 0) {
            Subscription subscription = this.w;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableD0 = Observable.d0(((long) this.q) / 1000000, TimeUnit.MILLISECONDS);
            SurfaceTextureHelper surfaceTextureHelper = this.m;
            if (surfaceTextureHelper == null) {
                m.throwUninitializedPropertyAccessException("surfaceTextureHelper");
            }
            Handler handler = surfaceTextureHelper.getHandler();
            m.checkNotNullExpressionValue(handler, "surfaceTextureHelper.handler");
            Looper looper = handler.getLooper();
            AtomicReference<j0.j.b.a> atomicReference = j0.j.b.a.a;
            Objects.requireNonNull(looper, "looper == null");
            this.w = observableD0.X(new j0.j.b.b(looper)).W(new b$c(this), b$d.j);
        }
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void changeCaptureFormat(int i, int i2, int i3) {
        a(this.f267s, Math.max(i, i2));
        d(i3);
    }

    @Override // org.webrtc.ScreenCapturerAndroid
    public void createVirtualDisplay() {
        try {
            super.createVirtualDisplay();
        } catch (Throwable th) {
            Logger.e$default(this.f268x, "ScreenCapturer", "error in createVirtualDisplay", th, null, 8, null);
        }
    }

    public final void d(int i) {
        if (i <= 0) {
            this.p = 0;
            this.q = 0;
        } else {
            this.p = i;
            this.q = 1000000000 / Math.max(10, i / 2);
        }
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public void dispose() {
        stopCapture();
        ThumbnailEmitter thumbnailEmitter = this.f269y;
        if (thumbnailEmitter != null) {
            synchronized (thumbnailEmitter) {
                thumbnailEmitter.frameDrawer.release();
                thumbnailEmitter.rectDrawer.release();
                JniCommon.nativeFreeByteBuffer(thumbnailEmitter.outputByteBuffer);
                thumbnailEmitter.lastTimestampNs = RecyclerView.FOREVER_NS;
            }
        }
        this.o.release();
        super.dispose();
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        m.checkNotNullParameter(surfaceTextureHelper, "surfaceTextureHelper");
        m.checkNotNullParameter(context, "applicationContext");
        m.checkNotNullParameter(capturerObserver, "capturerObserver");
        this.m = surfaceTextureHelper;
        this.n = context;
        this.l = (NativeCapturerObserver) capturerObserver;
        super.initialize(surfaceTextureHelper, context, capturerObserver);
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Rect rect = this.t;
        Context context = this.n;
        if (context == null) {
            m.throwUninitializedPropertyAccessException("context");
        }
        rect.set(DisplayUtils.getScreenSize(context));
        if (!m.areEqual(this.t, this.f267s)) {
            this.f267s.set(this.t);
            a(this.t, this.v);
        }
        this.r = Long.valueOf(videoFrame.getTimestampNs());
        ThumbnailEmitter thumbnailEmitter = this.f269y;
        if (thumbnailEmitter != null) {
            synchronized (thumbnailEmitter) {
                m.checkNotNullParameter(videoFrame, "frame");
                long jCurrentTimeMillis = thumbnailEmitter.clock.currentTimeMillis() - thumbnailEmitter.initializationTimeMs;
                long timestampNs = videoFrame.getTimestampNs() - thumbnailEmitter.lastTimestampNs;
                if (jCurrentTimeMillis > thumbnailEmitter.initialDelayMs) {
                    long j2 = 1000;
                    if (timestampNs > thumbnailEmitter.periodMs * j2 * j2) {
                        thumbnailEmitter.lastTimestampNs = videoFrame.getTimestampNs();
                        thumbnailEmitter.onNextThumbnail.invoke(thumbnailEmitter.a(videoFrame));
                    }
                }
            }
        }
        super.onFrame(videoFrame);
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void startCapture(int i, int i2, int i3) {
        AudioRecord audioRecordB;
        super.startCapture(i, i2, i3);
        this.v = Math.max(i, i2);
        d(i3);
        if (Build$VERSION.SDK_INT >= 29 && (audioRecordB = b()) != null) {
            this.o.startRecording(audioRecordB);
        }
        c();
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void stopCapture() {
        super.stopCapture();
        this.o.stopRecording();
        this.p = 0;
        this.r = null;
    }
}
