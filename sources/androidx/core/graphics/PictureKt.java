package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12237l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        C12238m.checkNotNullParameter(picture, "<this>");
        C12238m.checkNotNullParameter(function1, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        C12238m.checkNotNullExpressionValue(canvasBeginRecording, "beginRecording(width, height)");
        try {
            function1.invoke(canvasBeginRecording);
            return picture;
        } finally {
            C12237l.finallyStart(1);
            picture.endRecording();
            C12237l.finallyEnd(1);
        }
    }
}
