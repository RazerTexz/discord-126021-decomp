package p007b.p008a.p041q.p044m0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Build;
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
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.CapturerObserver;
import org.webrtc.JniCommon;
import org.webrtc.ScreenCapturerAndroid;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.TimestampAligner;
import org.webrtc.VideoFrame;
import p507d0.p592z.p594d.C12238m;
import p637j0.p638j.p640b.C12586a;
import p637j0.p638j.p640b.C12587b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.m0.b */
/* JADX INFO: compiled from: ScreenCapturer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1222b extends ScreenCapturerAndroid {

    /* JADX INFO: renamed from: j */
    public static final a f1676j = new a(null);

    /* JADX INFO: renamed from: k */
    public final b f1677k;

    /* JADX INFO: renamed from: l */
    public NativeCapturerObserver f1678l;

    /* JADX INFO: renamed from: m */
    public SurfaceTextureHelper f1679m;

    /* JADX INFO: renamed from: n */
    public Context f1680n;

    /* JADX INFO: renamed from: o */
    public final SoundshareAudioSource f1681o;

    /* JADX INFO: renamed from: p */
    public int f1682p;

    /* JADX INFO: renamed from: q */
    public int f1683q;

    /* JADX INFO: renamed from: r */
    public Long f1684r;

    /* JADX INFO: renamed from: s */
    public final Rect f1685s;

    /* JADX INFO: renamed from: t */
    public final Rect f1686t;

    /* JADX INFO: renamed from: u */
    public final Point f1687u;

    /* JADX INFO: renamed from: v */
    public int f1688v;

    /* JADX INFO: renamed from: w */
    public Subscription f1689w;

    /* JADX INFO: renamed from: x */
    public final Logger f1690x;

    /* JADX INFO: renamed from: y */
    public final ThumbnailEmitter f1691y;

    /* JADX INFO: renamed from: b.a.q.m0.b$a */
    /* JADX INFO: compiled from: ScreenCapturer.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.b$b */
    /* JADX INFO: compiled from: ScreenCapturer.kt */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1222b c1222b = C1222b.this;
            if (c1222b.f1682p > 0) {
                Long l = c1222b.f1684r;
                if (l != null) {
                    long rtcTimeNanos = TimestampAligner.getRtcTimeNanos() - l.longValue();
                    C1222b c1222b2 = C1222b.this;
                    if (rtcTimeNanos > c1222b2.f1683q) {
                        NativeCapturerObserver nativeCapturerObserver = c1222b2.f1678l;
                        if (nativeCapturerObserver == null) {
                            C12238m.throwUninitializedPropertyAccessException("nativeObserver");
                        }
                        nativeCapturerObserver.repeatLastFrame();
                    }
                }
                C1222b.this.m292c();
            }
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.b$c */
    /* JADX INFO: compiled from: ScreenCapturer.kt */
    public static final class c<T> implements Action1<Long> {
        public c() {
        }

        @Override // p658rx.functions.Action1
        public void call(Long l) {
            C1222b.this.f1677k.run();
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.b$d */
    /* JADX INFO: compiled from: ScreenCapturer.kt */
    public static final class d<T> implements Action1<Throwable> {

        /* JADX INFO: renamed from: j */
        public static final d f1694j = new d();

        @Override // p658rx.functions.Action1
        public void call(Throwable th) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1222b(Intent intent, MediaProjection.Callback callback, Logger logger, ThumbnailEmitter thumbnailEmitter) {
        super(intent, callback);
        C12238m.checkNotNullParameter(intent, "mediaProjectionPermissionResultData");
        C12238m.checkNotNullParameter(callback, "mediaProjectionCallback");
        C12238m.checkNotNullParameter(logger, "logger");
        this.f1690x = logger;
        this.f1691y = thumbnailEmitter;
        this.f1677k = new b();
        this.f1681o = new SoundshareAudioSource();
        this.f1685s = new Rect();
        this.f1686t = new Rect();
        this.f1687u = new Point();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m290a(Rect rect, int i) {
        C12238m.checkNotNullParameter(rect, "measuredSize");
        int iMax = Math.max(rect.width(), rect.height());
        if (iMax > 0) {
            float f = i / iMax;
            this.f1687u.set((int) (rect.width() * f), (int) (rect.height() * f));
            Point point = this.f1687u;
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
            Point point2 = this.f1687u;
            super.changeCaptureFormat(point2.x, point2.y, this.f1682p);
        }
    }

    @RequiresApi(29)
    /* JADX INFO: renamed from: b */
    public final AudioRecord m291b() {
        MediaProjection mediaProjection = this.mediaProjection;
        if (mediaProjection == null) {
            return null;
        }
        AudioPlaybackCaptureConfiguration audioPlaybackCaptureConfigurationBuild = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection).addMatchingUsage(1).addMatchingUsage(14).addMatchingUsage(0).build();
        C12238m.checkNotNullExpressionValue(audioPlaybackCaptureConfigurationBuild, "AudioPlaybackCaptureConf…KNOWN)\n          .build()");
        try {
            return new AudioRecord.Builder().setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(44100).setChannelMask(16).build()).setAudioPlaybackCaptureConfig(audioPlaybackCaptureConfigurationBuild).build();
        } catch (SecurityException unused) {
            Log.w(C1222b.class.getName(), "Failed to record audio");
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m292c() {
        if (this.f1682p > 0) {
            Subscription subscription = this.f1689w;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableM11068d0 = Observable.m11068d0(((long) this.f1683q) / 1000000, TimeUnit.MILLISECONDS);
            SurfaceTextureHelper surfaceTextureHelper = this.f1679m;
            if (surfaceTextureHelper == null) {
                C12238m.throwUninitializedPropertyAccessException("surfaceTextureHelper");
            }
            Handler handler = surfaceTextureHelper.getHandler();
            C12238m.checkNotNullExpressionValue(handler, "surfaceTextureHelper.handler");
            Looper looper = handler.getLooper();
            AtomicReference<C12586a> atomicReference = C12586a.f26701a;
            Objects.requireNonNull(looper, "looper == null");
            this.f1689w = observableM11068d0.m11098X(new C12587b(looper)).m11097W(new c(), d.f1694j);
        }
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void changeCaptureFormat(int i, int i2, int i3) {
        m290a(this.f1685s, Math.max(i, i2));
        m293d(i3);
    }

    @Override // org.webrtc.ScreenCapturerAndroid
    public void createVirtualDisplay() {
        try {
            super.createVirtualDisplay();
        } catch (Throwable th) {
            Logger.e$default(this.f1690x, "ScreenCapturer", "error in createVirtualDisplay", th, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m293d(int i) {
        if (i <= 0) {
            this.f1682p = 0;
            this.f1683q = 0;
        } else {
            this.f1682p = i;
            this.f1683q = 1000000000 / Math.max(10, i / 2);
        }
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public void dispose() {
        stopCapture();
        ThumbnailEmitter thumbnailEmitter = this.f1691y;
        if (thumbnailEmitter != null) {
            synchronized (thumbnailEmitter) {
                thumbnailEmitter.frameDrawer.release();
                thumbnailEmitter.rectDrawer.release();
                JniCommon.nativeFreeByteBuffer(thumbnailEmitter.outputByteBuffer);
                thumbnailEmitter.lastTimestampNs = RecyclerView.FOREVER_NS;
            }
        }
        this.f1681o.release();
        super.dispose();
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        C12238m.checkNotNullParameter(surfaceTextureHelper, "surfaceTextureHelper");
        C12238m.checkNotNullParameter(context, "applicationContext");
        C12238m.checkNotNullParameter(capturerObserver, "capturerObserver");
        this.f1679m = surfaceTextureHelper;
        this.f1680n = context;
        this.f1678l = (NativeCapturerObserver) capturerObserver;
        super.initialize(surfaceTextureHelper, context, capturerObserver);
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Rect rect = this.f1686t;
        Context context = this.f1680n;
        if (context == null) {
            C12238m.throwUninitializedPropertyAccessException("context");
        }
        rect.set(DisplayUtils.getScreenSize(context));
        if (!C12238m.areEqual(this.f1686t, this.f1685s)) {
            this.f1685s.set(this.f1686t);
            m290a(this.f1686t, this.f1688v);
        }
        this.f1684r = Long.valueOf(videoFrame.getTimestampNs());
        ThumbnailEmitter thumbnailEmitter = this.f1691y;
        if (thumbnailEmitter != null) {
            synchronized (thumbnailEmitter) {
                C12238m.checkNotNullParameter(videoFrame, "frame");
                long jCurrentTimeMillis = thumbnailEmitter.clock.currentTimeMillis() - thumbnailEmitter.initializationTimeMs;
                long timestampNs = videoFrame.getTimestampNs() - thumbnailEmitter.lastTimestampNs;
                if (jCurrentTimeMillis > thumbnailEmitter.initialDelayMs) {
                    long j = 1000;
                    if (timestampNs > thumbnailEmitter.periodMs * j * j) {
                        thumbnailEmitter.lastTimestampNs = videoFrame.getTimestampNs();
                        thumbnailEmitter.onNextThumbnail.invoke(thumbnailEmitter.m8502a(videoFrame));
                    }
                }
            }
        }
        super.onFrame(videoFrame);
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void startCapture(int i, int i2, int i3) {
        AudioRecord audioRecordM291b;
        super.startCapture(i, i2, i3);
        this.f1688v = Math.max(i, i2);
        m293d(i3);
        if (Build.VERSION.SDK_INT >= 29 && (audioRecordM291b = m291b()) != null) {
            this.f1681o.startRecording(audioRecordM291b);
        }
        m292c();
    }

    @Override // org.webrtc.ScreenCapturerAndroid, org.webrtc.VideoCapturer
    public synchronized void stopCapture() {
        super.stopCapture();
        this.f1681o.stopRecording();
        this.f1682p = 0;
        this.f1684r = null;
    }
}
