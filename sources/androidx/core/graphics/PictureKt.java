package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import d0.z.d.l;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        m.checkNotNullParameter(picture, "<this>");
        m.checkNotNullParameter(function1, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        m.checkNotNullExpressionValue(canvasBeginRecording, "beginRecording(width, height)");
        try {
            function1.invoke(canvasBeginRecording);
            return picture;
        } finally {
            l.finallyStart(1);
            picture.endRecording();
            l.finallyEnd(1);
        }
    }
}
