package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.graphics.CanvasKt, reason: use source file name */
/* JADX INFO: compiled from: Canvas.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Canvas {
    public static final void withClip(android.graphics.Canvas canvas, Rect rect, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "clipRect");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withMatrix(android.graphics.Canvas canvas, Matrix matrix, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(matrix, "matrix");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withMatrix$default(android.graphics.Canvas canvas, Matrix matrix, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(matrix, "matrix");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withRotation(android.graphics.Canvas canvas, float f, float f2, float f3, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withRotation$default(android.graphics.Canvas canvas, float f, float f2, float f3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withSave(android.graphics.Canvas canvas, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withScale(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withScale$default(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withSkew(android.graphics.Canvas canvas, float f, float f2, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withSkew$default(android.graphics.Canvas canvas, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withTranslation(android.graphics.Canvas canvas, float f, float f2, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withTranslation$default(android.graphics.Canvas canvas, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, RectF rectF, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(rectF, "clipRect");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, int i, int i2, int i3, int i4, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, Path path, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(path, "clipPath");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }
}
