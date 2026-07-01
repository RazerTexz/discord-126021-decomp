package b.i.a.c;

import android.os.Handler;
import b.i.a.c.b3.TextOutput;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.z2.MetadataOutput;

/* JADX INFO: renamed from: b.i.a.c.i2, reason: use source file name */
/* JADX INFO: compiled from: RenderersFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface RenderersFactory {
    Renderer2[] a(Handler handler, VideoRendererEventListener2 videoRendererEventListener2, AudioRendererEventListener2 audioRendererEventListener2, TextOutput textOutput, MetadataOutput metadataOutput);
}
