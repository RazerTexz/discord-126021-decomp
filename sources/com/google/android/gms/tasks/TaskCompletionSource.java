package com.google.android.gms.tasks;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p340n.C4358c0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCompletionSource<TResult> {

    /* JADX INFO: renamed from: a */
    public final C4358c0<TResult> f20845a = new C4358c0<>();

    /* JADX INFO: renamed from: a */
    public boolean m9125a(@RecentlyNonNull Exception exc) {
        C4358c0<TResult> c4358c0 = this.f20845a;
        Objects.requireNonNull(c4358c0);
        C1460d.m595z(exc, "Exception must not be null");
        synchronized (c4358c0.f11471a) {
            if (c4358c0.f11473c) {
                return false;
            }
            c4358c0.f11473c = true;
            c4358c0.f11476f = exc;
            c4358c0.f11472b.m6032b(c4358c0);
            return true;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m9126b(@Nullable TResult tresult) {
        C4358c0<TResult> c4358c0 = this.f20845a;
        synchronized (c4358c0.f11471a) {
            if (c4358c0.f11473c) {
                return false;
            }
            c4358c0.f11473c = true;
            c4358c0.f11475e = tresult;
            c4358c0.f11472b.m6032b(c4358c0);
            return true;
        }
    }
}
