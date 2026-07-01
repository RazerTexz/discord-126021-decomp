package com.discord.utilities.apng;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import b.i.a.f.e.o.f;
import b.l.a.a;
import d0.z.d.m;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: ApngUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApngUtils {
    public static final ApngUtils INSTANCE = new ApngUtils();

    private ApngUtils() {
    }

    public static /* synthetic */ Job renderApngFromFile$default(ApngUtils apngUtils, File file, ImageView imageView, Integer num, Integer num2, boolean z2, int i, Object obj) {
        return apngUtils.renderApngFromFile(file, imageView, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z2);
    }

    public final void pauseApngAnimation(Drawable drawable) {
        if (drawable instanceof a) {
            ((a) drawable).stop();
        }
    }

    public final void playApngAnimation(Drawable drawable) {
        if (drawable instanceof a) {
            ((a) drawable).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.ref.WeakReference] */
    public final Job renderApngFromFile(File file, ImageView imageView, Integer maxWidth, Integer maxHeight, boolean autoPlay) {
        m.checkNotNullParameter(file, "file");
        m.checkNotNullParameter(imageView, "imageView");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new WeakReference(imageView);
        if (maxHeight != null) {
            int iIntValue = maxHeight.intValue();
            ImageView imageView2 = (ImageView) ((WeakReference) ref$ObjectRef.element).get();
            if (imageView2 != null) {
                imageView2.setMaxHeight(iIntValue);
            }
        }
        if (maxWidth != null) {
            int iIntValue2 = maxWidth.intValue();
            ImageView imageView3 = (ImageView) ((WeakReference) ref$ObjectRef.element).get();
            if (imageView3 != null) {
                imageView3.setMaxWidth(iIntValue2);
            }
        }
        return f.H0(x0.j, k0.f3842b, null, new ApngUtils$renderApngFromFile$3(file, maxHeight, maxWidth, ref$ObjectRef, autoPlay, null), 2, null);
    }
}
