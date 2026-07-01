package b.i.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings$Global;
import b.i.a.c.t2.p$a;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink$d;
import java.util.ArrayList;

/* JADX INFO: compiled from: DefaultRenderersFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class b1 implements i2 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.y2.r f836b = new b.i.a.c.y2.r();
    public b.i.a.c.y2.v c;

    public b1(Context context) {
        this.a = context;
        int i = b.i.a.c.y2.v.a;
        this.c = b.i.a.c.y2.k.f1305b;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:9:0x004a  */
    @Override // b.i.a.c.i2
    public f2[] a(Handler handler, b.i.a.c.g3.x xVar, b.i.a.c.t2.r rVar, b.i.a.c.b3.l lVar, b.i.a.c.z2.e eVar) {
        boolean z2;
        b.i.a.c.t2.p pVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b.i.a.c.g3.r(this.a, this.f836b, this.c, 5000L, false, handler, xVar, 50));
        Context context = this.a;
        b.i.a.c.t2.p pVar2 = b.i.a.c.t2.p.a;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int i = b.i.a.c.f3.e0.a;
        if (i >= 17) {
            String str = b.i.a.c.f3.e0.c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (z2 && Settings$Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            pVar = b.i.a.c.t2.p.f1125b;
        } else if (i >= 29) {
            if (!b.i.a.c.f3.e0.A(context)) {
                if (!(i >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"))) {
                    if (intentRegisterReceiver != null) {
                        pVar = b.i.a.c.t2.p.a;
                    } else {
                        pVar = b.i.a.c.t2.p.a;
                    }
                }
            }
            pVar = new b.i.a.c.t2.p(p$a.a(), 8);
        } else if (intentRegisterReceiver != null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            pVar = b.i.a.c.t2.p.a;
        } else {
            pVar = new b.i.a.c.t2.p(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        arrayList.add(new b.i.a.c.t2.z(this.a, this.f836b, this.c, false, handler, rVar, new DefaultAudioSink(pVar, new DefaultAudioSink$d(new AudioProcessor[0]), false, false, 0)));
        arrayList.add(new b.i.a.c.b3.m(lVar, handler.getLooper()));
        arrayList.add(new b.i.a.c.z2.f(eVar, handler.getLooper()));
        arrayList.add(new b.i.a.c.g3.z.e());
        return (f2[]) arrayList.toArray(new f2[0]);
    }
}
