package com.google.android.material.transition.platform;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialContainerTransformSharedElementCallback$ShapeableViewShapeProvider implements MaterialContainerTransformSharedElementCallback$ShapeProvider {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback$ShapeProvider
    @Nullable
    public ShapeAppearanceModel provideShape(@NonNull View view) {
        if (view instanceof Shapeable) {
            return ((Shapeable) view).getShapeAppearanceModel();
        }
        return null;
    }
}
