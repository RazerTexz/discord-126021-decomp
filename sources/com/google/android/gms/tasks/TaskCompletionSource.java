package com.google.android.gms.tasks;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.d;
import b.i.a.f.n.c0;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCompletionSource<TResult> {
    public final c0<TResult> a = new c0<>();

    public boolean a(@RecentlyNonNull Exception exc) {
        c0<TResult> c0Var = this.a;
        Objects.requireNonNull(c0Var);
        d.z(exc, "Exception must not be null");
        synchronized (c0Var.a) {
            if (c0Var.c) {
                return false;
            }
            c0Var.c = true;
            c0Var.f = exc;
            c0Var.f1592b.b(c0Var);
            return true;
        }
    }

    public boolean b(@Nullable TResult tresult) {
        c0<TResult> c0Var = this.a;
        synchronized (c0Var.a) {
            if (c0Var.c) {
                return false;
            }
            c0Var.c = true;
            c0Var.e = tresult;
            c0Var.f1592b.b(c0Var);
            return true;
        }
    }
}
