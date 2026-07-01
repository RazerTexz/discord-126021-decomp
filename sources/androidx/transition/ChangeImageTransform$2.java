package androidx.transition;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform$2 extends Property<ImageView, Matrix> {
    public ChangeImageTransform$2(Class cls, String str) {
        super(cls, str);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(ImageView imageView) {
        return null;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Matrix get(ImageView imageView) {
        return get2(imageView);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ImageView imageView, Matrix matrix) {
        set2(imageView, matrix);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ImageView imageView, Matrix matrix) {
        ImageViewUtils.animateTransform(imageView, matrix);
    }
}
