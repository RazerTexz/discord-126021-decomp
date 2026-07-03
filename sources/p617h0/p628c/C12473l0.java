package p617h0.p628c;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import org.webrtc.TextureBufferImpl;
import org.webrtc.VideoFrame;

/* JADX INFO: renamed from: h0.c.l0 */
/* JADX INFO: compiled from: CameraSession.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12473l0 {
    /* JADX INFO: renamed from: a */
    public static VideoFrame.TextureBuffer m10658a(TextureBufferImpl textureBufferImpl, boolean z2, int i) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z2) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
    }

    /* JADX INFO: renamed from: b */
    public static int m10659b(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }
}
