package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import b.f.d.e.a;

/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class BasePool$a {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2897b;

    public void a(int i) {
        int i2;
        int i3 = this.f2897b;
        if (i3 < i || (i2 = this.a) <= 0) {
            a.p("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.f2897b), Integer.valueOf(this.a));
        } else {
            this.a = i2 - 1;
            this.f2897b = i3 - i;
        }
    }

    public void b(int i) {
        this.a++;
        this.f2897b += i;
    }
}
