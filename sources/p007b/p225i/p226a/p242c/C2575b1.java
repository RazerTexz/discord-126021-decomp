package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p242c.p245b3.C2589m;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2588l;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p260g3.C2781r;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x;
import p007b.p225i.p226a.p242c.p260g3.p261z.C2793e;
import p007b.p225i.p226a.p242c.p263t2.C2932p;
import p007b.p225i.p226a.p242c.p263t2.C2942z;
import p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r;
import p007b.p225i.p226a.p242c.p278y2.C3146r;
import p007b.p225i.p226a.p242c.p278y2.InterfaceC3150v;
import p007b.p225i.p226a.p242c.p279z2.C3160f;
import p007b.p225i.p226a.p242c.p279z2.InterfaceC3159e;

/* JADX INFO: renamed from: b.i.a.c.b1 */
/* JADX INFO: compiled from: DefaultRenderersFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2575b1 implements InterfaceC2808i2 {

    /* JADX INFO: renamed from: a */
    public final Context f5739a;

    /* JADX INFO: renamed from: b */
    public final C3146r f5740b = new C3146r();

    /* JADX INFO: renamed from: c */
    public InterfaceC3150v f5741c;

    public C2575b1(Context context) {
        this.f5739a = context;
        int i = InterfaceC3150v.f9119a;
        this.f5741c = new InterfaceC3150v() { // from class: b.i.a.c.y2.k
            @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3150v
            /* JADX INFO: renamed from: a */
            public final List mo3831a(String str, boolean z2, boolean z3) {
                return MediaCodecUtil.m8866e(str, z2, z3);
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:9:0x004a  */
    @Override // p007b.p225i.p226a.p242c.InterfaceC2808i2
    /* JADX INFO: renamed from: a */
    public InterfaceC2728f2[] mo2596a(Handler handler, InterfaceC2787x interfaceC2787x, InterfaceC2934r interfaceC2934r, InterfaceC2588l interfaceC2588l, InterfaceC3159e interfaceC3159e) {
        boolean z2;
        C2932p c2932p;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C2781r(this.f5739a, this.f5740b, this.f5741c, 5000L, false, handler, interfaceC2787x, 50));
        Context context = this.f5739a;
        C2932p c2932p2 = C2932p.f7785a;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int i = C2738e0.f6708a;
        if (i >= 17) {
            String str = C2738e0.f6710c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (z2 && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            c2932p = C2932p.f7786b;
        } else if (i >= 29) {
            if (!C2738e0.m2980A(context)) {
                if (!(i >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"))) {
                    if (intentRegisterReceiver != null) {
                        c2932p = C2932p.f7785a;
                    } else {
                        c2932p = C2932p.f7785a;
                    }
                }
            }
            c2932p = new C2932p(C2932p.a.m3496a(), 8);
        } else if (intentRegisterReceiver != null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            c2932p = C2932p.f7785a;
        } else {
            c2932p = new C2932p(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        arrayList.add(new C2942z(this.f5739a, this.f5740b, this.f5741c, false, handler, interfaceC2934r, new DefaultAudioSink(c2932p, new DefaultAudioSink.C10690d(new AudioProcessor[0]), false, false, 0)));
        arrayList.add(new C2589m(interfaceC2588l, handler.getLooper()));
        arrayList.add(new C3160f(interfaceC3159e, handler.getLooper()));
        arrayList.add(new C2793e());
        return (InterfaceC2728f2[]) arrayList.toArray(new InterfaceC2728f2[0]);
    }
}
