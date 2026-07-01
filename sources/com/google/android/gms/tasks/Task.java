package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.i.a.f.n.a;
import b.i.a.f.n.b;
import b.i.a.f.n.c;
import b.i.a.f.n.d;
import b.i.a.f.n.e;
import b.i.a.f.n.f;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Task<TResult> {
    @NonNull
    public Task<TResult> a(@RecentlyNonNull Executor executor, @RecentlyNonNull b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    public Task<TResult> b(@RecentlyNonNull c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public Task<TResult> c(@RecentlyNonNull Executor executor, @RecentlyNonNull c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public abstract Task<TResult> d(@RecentlyNonNull d dVar);

    @NonNull
    public abstract Task<TResult> e(@RecentlyNonNull Executor executor, @RecentlyNonNull d dVar);

    @NonNull
    public abstract Task<TResult> f(@RecentlyNonNull e<? super TResult> eVar);

    @NonNull
    public abstract Task<TResult> g(@RecentlyNonNull Executor executor, @RecentlyNonNull e<? super TResult> eVar);

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> h(@RecentlyNonNull a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> i(@RecentlyNonNull Executor executor, @RecentlyNonNull a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> j(@RecentlyNonNull Executor executor, @RecentlyNonNull a<TResult, Task<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @RecentlyNullable
    public abstract Exception k();

    @RecentlyNonNull
    public abstract TResult l();

    @RecentlyNonNull
    public abstract <X extends Throwable> TResult m(@RecentlyNonNull Class<X> cls) throws Throwable;

    public abstract boolean n();

    public abstract boolean o();

    public abstract boolean p();

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> q(@RecentlyNonNull f<TResult, TContinuationResult> fVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> r(@RecentlyNonNull Executor executor, @RecentlyNonNull f<TResult, TContinuationResult> fVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
