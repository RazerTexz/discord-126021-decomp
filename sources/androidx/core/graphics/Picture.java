package androidx.core.graphics;

import android.graphics.Canvas;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.graphics.PictureKt, reason: use source file name */
/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Picture {
    public static final android.graphics.Picture record(android.graphics.Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(picture, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        Intrinsics3.checkNotNullExpressionValue(canvasBeginRecording, "beginRecording(width, height)");
        try {
            function1.invoke(canvasBeginRecording);
            return picture;
        } finally {
            InlineMarker.finallyStart(1);
            picture.endRecording();
            InlineMarker.finallyEnd(1);
        }
    }
}
