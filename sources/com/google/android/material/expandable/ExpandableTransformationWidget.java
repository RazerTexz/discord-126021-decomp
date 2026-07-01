package com.google.android.material.expandable;

import androidx.annotation.IdRes;

/* JADX INFO: loaded from: classes3.dex */
public interface ExpandableTransformationWidget extends ExpandableWidget {
    @IdRes
    int getExpandedComponentIdHint();

    void setExpandedComponentIdHint(@IdRes int i);
}
