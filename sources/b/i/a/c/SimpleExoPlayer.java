package b.i.a.c;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.AudioBecomingNoisyManager;
import b.i.a.c.AudioFocusManager;
import b.i.a.c.ExoPlayer2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.Player2;
import b.i.a.c.PlayerMessage;
import b.i.a.c.StreamVolumeManager;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.TextOutput;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.f3.ConditionVariable;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.SystemHandlerWrapper;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoDecoderOutputBufferRenderer;
import b.i.a.c.g3.VideoFrameMetadataListener;
import b.i.a.c.g3.VideoRendererEventListener;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.g3.VideoSize;
import b.i.a.c.g3.z.CameraMotionListener;
import b.i.a.c.g3.z.SphericalGLSurfaceView;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.t2.AudioAttributes;
import b.i.a.c.t2.AudioRendererEventListener;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import b.i.a.c.z2.MetadataOutput;
import com.discord.utilities.rest.SendUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: renamed from: b.i.a.c.k2, reason: use source file name */
/* JADX INFO: compiled from: SimpleExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer2 {
    public AudioAttributes A;
    public float B;
    public boolean C;
    public List<Cue> D;
    public boolean E;
    public boolean F;
    public boolean G;
    public DeviceInfo2 H;
    public VideoSize I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Renderer2[] f1028b;
    public final ConditionVariable c = new ConditionVariable();
    public final Context d;
    public final ExoPlayerImpl e;
    public final b f;
    public final c g;
    public final CopyOnWriteArraySet<Player2.e> h;
    public final AnalyticsCollector i;
    public final AudioBecomingNoisyManager j;
    public final AudioFocusManager k;
    public final StreamVolumeManager l;
    public final WakeLockManager m;
    public final WifiLockManager n;
    public final long o;

    @Nullable
    public AudioTrack p;

    @Nullable
    public Object q;

    @Nullable
    public Surface r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public SurfaceHolder f1029s;

    @Nullable
    public SphericalGLSurfaceView t;
    public boolean u;

    @Nullable
    public TextureView v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1031y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1032z;

    /* JADX INFO: renamed from: b.i.a.c.k2$b */
    /* JADX INFO: compiled from: SimpleExoPlayer.java */
    public final class b implements VideoRendererEventListener2, AudioRendererEventListener2, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, AudioFocusManager.b, AudioBecomingNoisyManager.b, StreamVolumeManager.b, Player2.c, ExoPlayer2.a {
        public b(a aVar) {
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void A(MediaMetadata mediaMetadata) {
            Player3.f(this, mediaMetadata);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void B(String str) {
            SimpleExoPlayer.this.i.B(str);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void C(String str, long j, long j2) {
            SimpleExoPlayer.this.i.C(str, j, j2);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void D(boolean z2) {
            Player3.p(this, z2);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void E(Player2 player2, Player2.d dVar) {
            Player3.b(this, player2, dVar);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void F(int i, long j) {
            SimpleExoPlayer.this.i.F(i, j);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void H(boolean z2, int i) {
            Player3.k(this, z2, i);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void I(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.i.I(format2, decoderReuseEvaluation);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void K(Object obj, long j) {
            SimpleExoPlayer.this.i.K(obj, j);
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.q == obj) {
                Iterator<Player2.e> it = simpleExoPlayer.h.iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
            }
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void L(int i) {
            Player3.n(this, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void M(MediaItem2 mediaItem2, int i) {
            Player3.e(this, mediaItem2, i);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void N(Exception exc) {
            SimpleExoPlayer.this.i.N(exc);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public /* synthetic */ void O(Format2 format2) {
            VideoRendererEventListener.a(this, format2);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void P(DecoderCounters decoderCounters) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.i.P(decoderCounters);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void Q(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.i.Q(format2, decoderReuseEvaluation);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void R(long j) {
            SimpleExoPlayer.this.i.R(j);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void T(Exception exc) {
            SimpleExoPlayer.this.i.T(exc);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public /* synthetic */ void U(Format2 format2) {
            AudioRendererEventListener.a(this, format2);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void V(Exception exc) {
            SimpleExoPlayer.this.i.V(exc);
        }

        @Override // b.i.a.c.Player2.c
        public void W(boolean z2, int i) {
            SimpleExoPlayer.d0(SimpleExoPlayer.this);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player3.r(this, trackGroupArray, trackSelectionArray);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void Z(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.i.Z(decoderCounters);
            Objects.requireNonNull(SimpleExoPlayer.this);
            Objects.requireNonNull(SimpleExoPlayer.this);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void a() {
            Player3.o(this);
        }

        @Override // b.i.a.c.z2.MetadataOutput
        public void b(Metadata metadata) {
            SimpleExoPlayer.this.i.b(metadata);
            final ExoPlayerImpl exoPlayerImpl = SimpleExoPlayer.this.e;
            MediaMetadata.b bVarA = exoPlayerImpl.E.a();
            int i = 0;
            while (true) {
                Metadata.Entry[] entryArr = metadata.j;
                if (i >= entryArr.length) {
                    break;
                }
                entryArr[i].n(bVarA);
                i++;
            }
            exoPlayerImpl.E = bVarA.a();
            MediaMetadata mediaMetadataE0 = exoPlayerImpl.e0();
            if (!mediaMetadataE0.equals(exoPlayerImpl.D)) {
                exoPlayerImpl.D = mediaMetadataE0;
                ListenerSet<Player2.c> listenerSet = exoPlayerImpl.j;
                listenerSet.b(14, new ListenerSet.a() { // from class: b.i.a.c.j
                    @Override // b.i.a.c.f3.ListenerSet.a
                    public final void invoke(Object obj) {
                        ((Player2.c) obj).A(exoPlayerImpl.D);
                    }
                });
                listenerSet.a();
            }
            Iterator<Player2.e> it = SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                it.next().b(metadata);
            }
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void b0(PlaybackParameters playbackParameters) {
            Player3.g(this, playbackParameters);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void d(boolean z2) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.C == z2) {
                return;
            }
            simpleExoPlayer.C = z2;
            simpleExoPlayer.i.d(z2);
            Iterator<Player2.e> it = simpleExoPlayer.h.iterator();
            while (it.hasNext()) {
                it.next().d(simpleExoPlayer.C);
            }
        }

        @Override // b.i.a.c.b3.TextOutput
        public void e(List<Cue> list) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.D = list;
            Iterator<Player2.e> it = simpleExoPlayer.h.iterator();
            while (it.hasNext()) {
                it.next().e(list);
            }
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void e0(int i, long j, long j2) {
            SimpleExoPlayer.this.i.e0(i, j, j2);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void f(VideoSize videoSize) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.I = videoSize;
            simpleExoPlayer.i.f(videoSize);
            Iterator<Player2.e> it = SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                it.next().f(videoSize);
            }
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void f0(PlaybackException playbackException) {
            Player3.j(this, playbackException);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void g(Player2.f fVar, Player2.f fVar2, int i) {
            Player3.m(this, fVar, fVar2, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void h(int i) {
            Player3.h(this, i);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void h0(long j, int i) {
            SimpleExoPlayer.this.i.h0(j, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void i(boolean z2) {
            Player3.d(this, z2);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void j(int i) {
            Player3.l(this, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void j0(boolean z2) {
            Player3.c(this, z2);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void k(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.i.k(decoderCounters);
            Objects.requireNonNull(SimpleExoPlayer.this);
            Objects.requireNonNull(SimpleExoPlayer.this);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void l(String str) {
            SimpleExoPlayer.this.i.l(str);
        }

        @Override // b.i.a.c.t2.AudioRendererEventListener2
        public void m(DecoderCounters decoderCounters) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.i.m(decoderCounters);
        }

        @Override // b.i.a.c.g3.VideoRendererEventListener2
        public void n(String str, long j, long j2) {
            SimpleExoPlayer.this.i.n(str, j, j2);
        }

        @Override // b.i.a.c.ExoPlayer2.a
        public void o(boolean z2) {
            SimpleExoPlayer.d0(SimpleExoPlayer.this);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            Objects.requireNonNull(simpleExoPlayer);
            Surface surface = new Surface(surfaceTexture);
            simpleExoPlayer.l0(surface);
            simpleExoPlayer.r = surface;
            SimpleExoPlayer.this.h0(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.l0(null);
            SimpleExoPlayer.this.h0(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.h0(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void p(TracksInfo tracksInfo) {
            Player3.s(this, tracksInfo);
        }

        @Override // b.i.a.c.g3.z.SphericalGLSurfaceView.b
        public void q(Surface surface) {
            SimpleExoPlayer.this.l0(null);
        }

        @Override // b.i.a.c.Player2.c
        public void r(boolean z2) {
            Objects.requireNonNull(SimpleExoPlayer.this);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void s(PlaybackException playbackException) {
            Player3.i(this, playbackException);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SimpleExoPlayer.this.h0(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.u) {
                simpleExoPlayer.l0(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.u) {
                simpleExoPlayer.l0(null);
            }
            SimpleExoPlayer.this.h0(0, 0);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void t(Player2.b bVar) {
            Player3.a(this, bVar);
        }

        @Override // b.i.a.c.g3.z.SphericalGLSurfaceView.b
        public void u(Surface surface) {
            SimpleExoPlayer.this.l0(surface);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void v(Timeline timeline, int i) {
            Player3.q(this, timeline, i);
        }

        @Override // b.i.a.c.ExoPlayer2.a
        public /* synthetic */ void x(boolean z2) {
            ExoPlayer.a(this, z2);
        }

        @Override // b.i.a.c.Player2.c
        public void y(int i) {
            SimpleExoPlayer.d0(SimpleExoPlayer.this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.k2$c */
    /* JADX INFO: compiled from: SimpleExoPlayer.java */
    public static final class c implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.b {

        @Nullable
        public VideoFrameMetadataListener j;

        @Nullable
        public CameraMotionListener k;

        @Nullable
        public VideoFrameMetadataListener l;

        @Nullable
        public CameraMotionListener m;

        public c(a aVar) {
        }

        @Override // b.i.a.c.g3.z.CameraMotionListener
        public void a(long j, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.m;
            if (cameraMotionListener != null) {
                cameraMotionListener.a(j, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.k;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.a(j, fArr);
            }
        }

        @Override // b.i.a.c.g3.z.CameraMotionListener
        public void c() {
            CameraMotionListener cameraMotionListener = this.m;
            if (cameraMotionListener != null) {
                cameraMotionListener.c();
            }
            CameraMotionListener cameraMotionListener2 = this.k;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.c();
            }
        }

        @Override // b.i.a.c.g3.VideoFrameMetadataListener
        public void e(long j, long j2, Format2 format2, @Nullable MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.l;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.e(j, j2, format2, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.j;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.e(j, j2, format2, mediaFormat);
            }
        }

        @Override // b.i.a.c.PlayerMessage.b
        public void r(int i, @Nullable Object obj) {
            if (i == 7) {
                this.j = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i == 8) {
                this.k = (CameraMotionListener) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.l = null;
                this.m = null;
            } else {
                this.l = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.m = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    public SimpleExoPlayer(ExoPlayer2.b bVar) throws Throwable {
        SimpleExoPlayer simpleExoPlayer;
        try {
            Context applicationContext = bVar.a.getApplicationContext();
            this.d = applicationContext;
            this.i = bVar.h.get();
            this.A = bVar.j;
            this.w = bVar.k;
            this.C = false;
            this.o = bVar.r;
            b bVar2 = new b(null);
            this.f = bVar2;
            this.g = new c(null);
            this.h = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(bVar.i);
            this.f1028b = bVar.c.get().a(handler, bVar2, bVar2, bVar2, bVar2);
            this.B = 1.0f;
            if (Util2.a < 21) {
                AudioTrack audioTrack = this.p;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.p.release();
                    this.p = null;
                }
                if (this.p == null) {
                    this.p = new AudioTrack(3, SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, 4, 2, 2, 0, 0);
                }
                this.f1032z = this.p.getAudioSessionId();
            } else {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.f1032z = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            }
            this.D = Collections.emptyList();
            this.E = true;
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {21, 22, 23, 24, 25, 26, 27, 28};
            for (int i = 0; i < 8; i++) {
                int i2 = iArr[i];
                AnimatableValueParser.D(!false);
                sparseBooleanArray.append(i2, true);
            }
            AnimatableValueParser.D(!false);
            try {
                ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(this.f1028b, bVar.e.get(), bVar.d.get(), bVar.f.get(), bVar.g.get(), this.i, bVar.l, bVar.m, bVar.n, bVar.o, bVar.p, bVar.q, false, bVar.f923b, bVar.i, this, new Player2.b(new FlagSet(sparseBooleanArray, null), null));
                simpleExoPlayer = this;
                try {
                    simpleExoPlayer.e = exoPlayerImpl;
                    exoPlayerImpl.d0(simpleExoPlayer.f);
                    exoPlayerImpl.k.add(simpleExoPlayer.f);
                    AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(bVar.a, handler, simpleExoPlayer.f);
                    simpleExoPlayer.j = audioBecomingNoisyManager;
                    audioBecomingNoisyManager.a(false);
                    AudioFocusManager audioFocusManager = new AudioFocusManager(bVar.a, handler, simpleExoPlayer.f);
                    simpleExoPlayer.k = audioFocusManager;
                    audioFocusManager.c(null);
                    StreamVolumeManager streamVolumeManager = new StreamVolumeManager(bVar.a, handler, simpleExoPlayer.f);
                    simpleExoPlayer.l = streamVolumeManager;
                    streamVolumeManager.c(Util2.t(simpleExoPlayer.A.m));
                    WakeLockManager wakeLockManager = new WakeLockManager(bVar.a);
                    simpleExoPlayer.m = wakeLockManager;
                    wakeLockManager.c = false;
                    wakeLockManager.a();
                    WifiLockManager wifiLockManager = new WifiLockManager(bVar.a);
                    simpleExoPlayer.n = wifiLockManager;
                    wifiLockManager.c = false;
                    wifiLockManager.a();
                    simpleExoPlayer.H = f0(streamVolumeManager);
                    simpleExoPlayer.I = VideoSize.j;
                    simpleExoPlayer.j0(1, 10, Integer.valueOf(simpleExoPlayer.f1032z));
                    simpleExoPlayer.j0(2, 10, Integer.valueOf(simpleExoPlayer.f1032z));
                    simpleExoPlayer.j0(1, 3, simpleExoPlayer.A);
                    simpleExoPlayer.j0(2, 4, Integer.valueOf(simpleExoPlayer.w));
                    simpleExoPlayer.j0(2, 5, 0);
                    simpleExoPlayer.j0(1, 9, Boolean.valueOf(simpleExoPlayer.C));
                    simpleExoPlayer.j0(2, 7, simpleExoPlayer.g);
                    simpleExoPlayer.j0(6, 8, simpleExoPlayer.g);
                    simpleExoPlayer.c.b();
                } catch (Throwable th) {
                    th = th;
                    simpleExoPlayer.c.b();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                simpleExoPlayer = this;
            }
        } catch (Throwable th3) {
            th = th3;
            simpleExoPlayer = this;
        }
    }

    public static void d0(SimpleExoPlayer simpleExoPlayer) {
        int iY = simpleExoPlayer.y();
        if (iY != 1) {
            if (iY == 2 || iY == 3) {
                simpleExoPlayer.n0();
                boolean z2 = simpleExoPlayer.e.F.q;
                WakeLockManager wakeLockManager = simpleExoPlayer.m;
                wakeLockManager.d = simpleExoPlayer.j() && !z2;
                wakeLockManager.a();
                WifiLockManager wifiLockManager = simpleExoPlayer.n;
                wifiLockManager.d = simpleExoPlayer.j();
                wifiLockManager.a();
                return;
            }
            if (iY != 4) {
                throw new IllegalStateException();
            }
        }
        WakeLockManager wakeLockManager2 = simpleExoPlayer.m;
        wakeLockManager2.d = false;
        wakeLockManager2.a();
        WifiLockManager wifiLockManager2 = simpleExoPlayer.n;
        wifiLockManager2.d = false;
        wifiLockManager2.a();
    }

    public static DeviceInfo2 f0(StreamVolumeManager streamVolumeManager) {
        Objects.requireNonNull(streamVolumeManager);
        return new DeviceInfo2(0, Util2.a >= 28 ? streamVolumeManager.d.getStreamMinVolume(streamVolumeManager.f) : 0, streamVolumeManager.d.getStreamMaxVolume(streamVolumeManager.f));
    }

    public static int g0(boolean z2, int i) {
        return (!z2 || i == 1) ? 1 : 2;
    }

    @Override // b.i.a.c.Player2
    public List<Cue> A() {
        n0();
        return this.D;
    }

    @Override // b.i.a.c.Player2
    public int B() {
        n0();
        return this.e.B();
    }

    @Override // b.i.a.c.Player2
    public int C() {
        n0();
        return this.e.C();
    }

    @Override // b.i.a.c.Player2
    public void E(int i) {
        n0();
        this.e.E(i);
    }

    @Override // b.i.a.c.Player2
    public void F(@Nullable SurfaceView surfaceView) {
        n0();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        n0();
        if (holder == null || holder != this.f1029s) {
            return;
        }
        e0();
    }

    @Override // b.i.a.c.Player2
    public int G() {
        n0();
        return this.e.F.n;
    }

    @Override // b.i.a.c.Player2
    public TracksInfo H() {
        n0();
        return this.e.H();
    }

    @Override // b.i.a.c.Player2
    public int I() {
        n0();
        return this.e.v;
    }

    @Override // b.i.a.c.Player2
    public long J() {
        n0();
        return this.e.J();
    }

    @Override // b.i.a.c.Player2
    public Timeline K() {
        n0();
        return this.e.F.f1146b;
    }

    @Override // b.i.a.c.Player2
    public Looper L() {
        return this.e.q;
    }

    @Override // b.i.a.c.Player2
    public boolean M() {
        n0();
        return this.e.w;
    }

    @Override // b.i.a.c.Player2
    public long N() {
        n0();
        return this.e.N();
    }

    @Override // b.i.a.c.Player2
    public void Q(@Nullable TextureView textureView) {
        n0();
        if (textureView == null) {
            e0();
            return;
        }
        i0();
        this.v = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            l0(null);
            h0(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            l0(surface);
            this.r = surface;
            h0(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // b.i.a.c.Player2
    public MediaMetadata S() {
        return this.e.D;
    }

    @Override // b.i.a.c.Player2
    public long T() {
        n0();
        return this.e.T();
    }

    @Override // b.i.a.c.Player2
    public long U() {
        n0();
        return this.e.f959s;
    }

    @Override // b.i.a.c.Player2
    public void a() {
        n0();
        boolean zJ = j();
        int iE = this.k.e(zJ, 2);
        m0(zJ, iE, g0(zJ, iE));
        this.e.a();
    }

    @Override // b.i.a.c.Player2
    public PlaybackParameters c() {
        n0();
        return this.e.F.o;
    }

    public void e0() {
        n0();
        i0();
        l0(null);
        h0(0, 0);
    }

    @Override // b.i.a.c.Player2
    public boolean f() {
        n0();
        return this.e.f();
    }

    @Override // b.i.a.c.Player2
    public long g() {
        n0();
        return Util2.M(this.e.F.f1147s);
    }

    @Override // b.i.a.c.Player2
    public void h(int i, long j) {
        n0();
        AnalyticsCollector analyticsCollector = this.i;
        if (!analyticsCollector.r) {
            final AnalyticsListener.a aVarK0 = analyticsCollector.k0();
            analyticsCollector.r = true;
            ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.o
                @Override // b.i.a.c.f3.ListenerSet.a
                public final void invoke(Object obj) {
                    ((AnalyticsListener) obj).j0();
                }
            };
            analyticsCollector.n.put(-1, aVarK0);
            ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.o;
            listenerSet.b(-1, aVar);
            listenerSet.a();
        }
        this.e.h(i, j);
    }

    public final void h0(int i, int i2) {
        if (i == this.f1030x && i2 == this.f1031y) {
            return;
        }
        this.f1030x = i;
        this.f1031y = i2;
        this.i.a0(i, i2);
        Iterator<Player2.e> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a0(i, i2);
        }
    }

    @Override // b.i.a.c.Player2
    public Player2.b i() {
        n0();
        return this.e.C;
    }

    public final void i0() {
        if (this.t != null) {
            PlayerMessage playerMessageF0 = this.e.f0(this.g);
            playerMessageF0.f(10000);
            playerMessageF0.e(null);
            playerMessageF0.d();
            SphericalGLSurfaceView sphericalGLSurfaceView = this.t;
            sphericalGLSurfaceView.j.remove(this.f);
            this.t = null;
        }
        TextureView textureView = this.v;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.v.setSurfaceTextureListener(null);
            }
            this.v = null;
        }
        SurfaceHolder surfaceHolder = this.f1029s;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f);
            this.f1029s = null;
        }
    }

    @Override // b.i.a.c.Player2
    public boolean j() {
        n0();
        return this.e.F.m;
    }

    public final void j0(int i, int i2, @Nullable Object obj) {
        for (Renderer2 renderer2 : this.f1028b) {
            if (renderer2.x() == i) {
                PlayerMessage playerMessageF0 = this.e.f0(renderer2);
                AnimatableValueParser.D(!playerMessageF0.i);
                playerMessageF0.e = i2;
                AnimatableValueParser.D(!playerMessageF0.i);
                playerMessageF0.f = obj;
                playerMessageF0.d();
            }
        }
    }

    @Override // b.i.a.c.Player2
    public void k(boolean z2) {
        n0();
        this.e.k(z2);
    }

    public final void k0(SurfaceHolder surfaceHolder) {
        this.u = false;
        this.f1029s = surfaceHolder;
        surfaceHolder.addCallback(this.f);
        Surface surface = this.f1029s.getSurface();
        if (surface == null || !surface.isValid()) {
            h0(0, 0);
        } else {
            Rect surfaceFrame = this.f1029s.getSurfaceFrame();
            h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // b.i.a.c.Player2
    public long l() {
        n0();
        Objects.requireNonNull(this.e);
        return 3000L;
    }

    public final void l0(@Nullable Object obj) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (Renderer2 renderer2 : this.f1028b) {
            if (renderer2.x() == 2) {
                PlayerMessage playerMessageF0 = this.e.f0(renderer2);
                playerMessageF0.f(1);
                AnimatableValueParser.D(true ^ playerMessageF0.i);
                playerMessageF0.f = obj;
                playerMessageF0.d();
                arrayList.add(playerMessageF0);
            }
        }
        Object obj2 = this.q;
        if (obj2 == null || obj2 == obj) {
            z2 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).a(this.o);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z2 = true;
            }
            z2 = false;
            Object obj3 = this.q;
            Surface surface = this.r;
            if (obj3 == surface) {
                surface.release();
                this.r = null;
            }
        }
        this.q = obj;
        if (z2) {
            ExoPlayerImpl exoPlayerImpl = this.e;
            ExoPlaybackException exoPlaybackExceptionB = ExoPlaybackException.b(new ExoTimeoutException(3), PointerIconCompat.TYPE_HELP);
            PlaybackInfo playbackInfo = exoPlayerImpl.F;
            PlaybackInfo playbackInfoA = playbackInfo.a(playbackInfo.c);
            playbackInfoA.r = playbackInfoA.t;
            playbackInfoA.f1147s = 0L;
            PlaybackInfo playbackInfoE = playbackInfoA.f(1).e(exoPlaybackExceptionB);
            exoPlayerImpl.f960x++;
            ((SystemHandlerWrapper.b) exoPlayerImpl.i.q.c(6)).b();
            exoPlayerImpl.s0(playbackInfoE, 0, 1, false, playbackInfoE.f1146b.q() && !exoPlayerImpl.F.f1146b.q(), 4, exoPlayerImpl.g0(playbackInfoE), -1);
        }
    }

    @Override // b.i.a.c.Player2
    public int m() {
        n0();
        return this.e.m();
    }

    public final void m0(boolean z2, int i, int i2) {
        int i3 = 0;
        boolean z3 = z2 && i != -1;
        if (z3 && i != 1) {
            i3 = 1;
        }
        this.e.q0(z3, i3, i2);
    }

    @Override // b.i.a.c.Player2
    public void n(@Nullable TextureView textureView) {
        n0();
        if (textureView == null || textureView != this.v) {
            return;
        }
        e0();
    }

    public final void n0() {
        ConditionVariable conditionVariable = this.c;
        synchronized (conditionVariable) {
            boolean z2 = false;
            while (!conditionVariable.f971b) {
                try {
                    conditionVariable.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread() != this.e.q.getThread()) {
            String strK = Util2.k("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.e.q.getThread().getName());
            if (this.E) {
                throw new IllegalStateException(strK);
            }
            Log2.c("SimpleExoPlayer", strK, this.F ? null : new IllegalStateException());
            this.F = true;
        }
    }

    @Override // b.i.a.c.Player2
    public VideoSize o() {
        return this.I;
    }

    @Override // b.i.a.c.Player2
    public void p(Player2.e eVar) {
        Objects.requireNonNull(eVar);
        this.h.remove(eVar);
        this.e.o0(eVar);
    }

    @Override // b.i.a.c.Player2
    public int q() {
        n0();
        return this.e.q();
    }

    @Override // b.i.a.c.Player2
    public void r(@Nullable SurfaceView surfaceView) {
        n0();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            i0();
            l0(surfaceView);
            k0(surfaceView.getHolder());
            return;
        }
        if (surfaceView instanceof SphericalGLSurfaceView) {
            i0();
            this.t = (SphericalGLSurfaceView) surfaceView;
            PlayerMessage playerMessageF0 = this.e.f0(this.g);
            playerMessageF0.f(10000);
            playerMessageF0.e(this.t);
            playerMessageF0.d();
            this.t.j.add(this.f);
            l0(this.t.getVideoSurface());
            k0(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        n0();
        if (holder == null) {
            e0();
            return;
        }
        i0();
        this.u = true;
        this.f1029s = holder;
        holder.addCallback(this.f);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            l0(null);
            h0(0, 0);
        } else {
            l0(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // b.i.a.c.Player2
    @Nullable
    public PlaybackException t() {
        n0();
        return this.e.F.g;
    }

    @Override // b.i.a.c.Player2
    public void u(boolean z2) {
        n0();
        int iE = this.k.e(z2, y());
        m0(z2, iE, g0(z2, iE));
    }

    @Override // b.i.a.c.Player2
    public long v() {
        n0();
        return this.e.t;
    }

    @Override // b.i.a.c.Player2
    public long w() {
        n0();
        return this.e.w();
    }

    @Override // b.i.a.c.Player2
    public void x(Player2.e eVar) {
        Objects.requireNonNull(eVar);
        this.h.add(eVar);
        this.e.d0(eVar);
    }

    @Override // b.i.a.c.Player2
    public int y() {
        n0();
        return this.e.F.f;
    }
}
