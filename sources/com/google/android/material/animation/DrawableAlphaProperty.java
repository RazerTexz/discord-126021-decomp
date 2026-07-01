package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    private final WeakHashMap<Drawable, Integer> alphaCache;

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.alphaCache = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    public /* bridge */ /* synthetic */ Integer get(@NonNull Drawable drawable) {
        return get2(drawable);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull Drawable drawable, @NonNull Integer num) {
        set2(drawable, num);
    }

    @Nullable
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
