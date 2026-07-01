package com.google.android.material.floatingactionbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.g.e.f$e;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton$c<T extends FloatingActionButton> implements f$e {

    @NonNull
    public final TransformationCallback<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatingActionButton f3041b;

    public FloatingActionButton$c(@NonNull FloatingActionButton floatingActionButton, TransformationCallback<T> transformationCallback) {
        this.f3041b = floatingActionButton;
        this.a = transformationCallback;
    }

    @Override // b.i.a.g.e.f$e
    public void a() {
        this.a.onTranslationChanged(this.f3041b);
    }

    @Override // b.i.a.g.e.f$e
    public void b() {
        this.a.onScaleChanged(this.f3041b);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof FloatingActionButton$c) && ((FloatingActionButton$c) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
