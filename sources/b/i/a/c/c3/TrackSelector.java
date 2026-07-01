package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.RendererCapabilities;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.e3.BandwidthMeter;
import com.google.android.exoplayer2.ExoPlaybackException;

/* JADX INFO: renamed from: b.i.a.c.c3.q, reason: use source file name */
/* JADX INFO: compiled from: TrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TrackSelector {

    @Nullable
    public BandwidthMeter a;

    public abstract void a(@Nullable Object obj);

    public abstract TrackSelectorResult b(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource2.a aVar, Timeline timeline) throws ExoPlaybackException;
}
