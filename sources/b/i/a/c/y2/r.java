package b.i.a.c.y2;

import android.media.MediaCodec;
import android.util.Log;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.i.a.c.f3.e0;
import java.io.IOException;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: DefaultMediaCodecAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements t$b {
    @Override // b.i.a.c.y2.t$b
    public t a(t$a t_a) throws Throwable {
        String string;
        if (e0.a >= 31) {
            int iG = b.i.a.c.f3.t.g(t_a.c.w);
            int i = e0.a;
            switch (iG) {
                case -2:
                    string = "none";
                    break;
                case -1:
                default:
                    if (iG < 10000) {
                        string = "?";
                    } else {
                        StringBuilder sb = new StringBuilder(20);
                        sb.append("custom (");
                        sb.append(iG);
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
                    string = NotificationCompat$MessagingStyle$Message.KEY_TEXT;
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
            return new l$b(iG, false).b(t_a);
        }
        MediaCodec mediaCodec = null;
        try {
            Objects.requireNonNull(t_a.a);
            String str = t_a.a.a;
            String strValueOf2 = String.valueOf(str);
            b.c.a.a0.d.f(strValueOf2.length() != 0 ? "createCodec:".concat(strValueOf2) : new String("createCodec:"));
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            b.c.a.a0.d.d0();
            try {
                b.c.a.a0.d.f("configureCodec");
                mediaCodecCreateByCodecName.configure(t_a.f1314b, t_a.d, t_a.e, 0);
                b.c.a.a0.d.d0();
                b.c.a.a0.d.f("startCodec");
                mediaCodecCreateByCodecName.start();
                b.c.a.a0.d.d0();
                return new w(mediaCodecCreateByCodecName, null, null);
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
