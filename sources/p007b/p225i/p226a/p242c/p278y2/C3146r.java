package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;

/* JADX INFO: renamed from: b.i.a.c.y2.r */
/* JADX INFO: compiled from: DefaultMediaCodecAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3146r implements InterfaceC3148t.b {
    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t.b
    /* JADX INFO: renamed from: a */
    public InterfaceC3148t mo3845a(InterfaceC3148t.a aVar) throws Throwable {
        String string;
        if (C2738e0.f6708a >= 31) {
            int iM3049g = C2753t.m3049g(aVar.f9109c.f7155w);
            int i = C2738e0.f6708a;
            switch (iM3049g) {
                case -2:
                    string = "none";
                    break;
                case -1:
                default:
                    if (iM3049g < 10000) {
                        string = "?";
                    } else {
                        StringBuilder sb = new StringBuilder(20);
                        sb.append("custom (");
                        sb.append(iM3049g);
                        sb.append(")");
                        string = sb.toString();
                    }
                    break;
                case 0:
                    string = "default";
                    break;
                case 1:
                    string = MediaStreamTrack.AUDIO_TRACK_KIND;
                    break;
                case 2:
                    string = MediaStreamTrack.VIDEO_TRACK_KIND;
                    break;
                case 3:
                    string = NotificationCompat.MessagingStyle.Message.KEY_TEXT;
                    break;
                case 4:
                    string = "image";
                    break;
                case 5:
                    string = "metadata";
                    break;
                case 6:
                    string = "camera motion";
                    break;
            }
            String strValueOf = String.valueOf(string);
            Log.i("DefaultMediaCodecAdapterFactory", strValueOf.length() != 0 ? "Creating an asynchronous MediaCodec adapter for track type ".concat(strValueOf) : new String("Creating an asynchronous MediaCodec adapter for track type "));
            return new C3140l.b(iM3049g, false).mo3845a(aVar);
        }
        MediaCodec mediaCodec = null;
        try {
            Objects.requireNonNull(aVar.f9107a);
            String str = aVar.f9107a.f9112a;
            String strValueOf2 = String.valueOf(str);
            C1460d.m515f(strValueOf2.length() != 0 ? "createCodec:".concat(strValueOf2) : new String("createCodec:"));
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            C1460d.m508d0();
            try {
                C1460d.m515f("configureCodec");
                mediaCodecCreateByCodecName.configure(aVar.f9108b, aVar.f9110d, aVar.f9111e, 0);
                C1460d.m508d0();
                C1460d.m515f("startCodec");
                mediaCodecCreateByCodecName.start();
                C1460d.m508d0();
                return new C3151w(mediaCodecCreateByCodecName, null, null);
            } catch (IOException | RuntimeException e) {
                e = e;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (RuntimeException e3) {
            e = e3;
        }
    }
}
