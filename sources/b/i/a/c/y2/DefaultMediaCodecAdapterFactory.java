package b.i.a.c.y2;

import android.media.MediaCodec;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.y2.AsynchronousMediaCodecAdapter;
import b.i.a.c.y2.MediaCodecAdapter;
import java.io.IOException;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: renamed from: b.i.a.c.y2.r, reason: use source file name */
/* JADX INFO: compiled from: DefaultMediaCodecAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.b {
    @Override // b.i.a.c.y2.MediaCodecAdapter.b
    public MediaCodecAdapter a(MediaCodecAdapter.a aVar) throws Throwable {
        String string;
        if (Util2.a >= 31) {
            int iG = MimeTypes.g(aVar.c.w);
            int i = Util2.a;
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
            return new AsynchronousMediaCodecAdapter.b(iG, false).a(aVar);
        }
        MediaCodec mediaCodec = null;
        try {
            Objects.requireNonNull(aVar.a);
            String str = aVar.a.a;
            String strValueOf2 = String.valueOf(str);
            AnimatableValueParser.f(strValueOf2.length() != 0 ? "createCodec:".concat(strValueOf2) : new String("createCodec:"));
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            AnimatableValueParser.d0();
            try {
                AnimatableValueParser.f("configureCodec");
                mediaCodecCreateByCodecName.configure(aVar.f1314b, aVar.d, aVar.e, 0);
                AnimatableValueParser.d0();
                AnimatableValueParser.f("startCodec");
                mediaCodecCreateByCodecName.start();
                AnimatableValueParser.d0();
                return new SynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, null, null);
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
