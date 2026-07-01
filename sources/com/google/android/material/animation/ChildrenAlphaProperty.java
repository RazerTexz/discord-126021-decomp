package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R$id;

/* JADX INFO: loaded from: classes3.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Float get(@NonNull ViewGroup viewGroup) {
        return get2(viewGroup);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ViewGroup viewGroup, @NonNull Float f) {
        set2(viewGroup, f);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(@NonNull ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(R$id.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ViewGroup viewGroup, @NonNull Float f) {
        float fFloatValue = f.floatValue();
        viewGroup.setTag(R$id.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(fFloatValue);
        }
    }
}
