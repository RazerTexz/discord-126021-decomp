package androidx.activity;

import androidx.annotation.NonNull;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NonNull
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
