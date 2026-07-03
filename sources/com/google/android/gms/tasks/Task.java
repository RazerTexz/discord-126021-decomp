package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4355b;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4359d;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Task<TResult> {
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<TResult> mo6006a(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4355b interfaceC4355b) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public Task<TResult> mo6007b(@RecentlyNonNull InterfaceC4357c<TResult> interfaceC4357c) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    /* JADX INFO: renamed from: c */
    public Task<TResult> mo6008c(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4357c<TResult> interfaceC4357c) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    /* JADX INFO: renamed from: d */
    public abstract Task<TResult> mo6009d(@RecentlyNonNull InterfaceC4359d interfaceC4359d);

    @NonNull
    /* JADX INFO: renamed from: e */
    public abstract Task<TResult> mo6010e(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4359d interfaceC4359d);

    @NonNull
    /* JADX INFO: renamed from: f */
    public abstract Task<TResult> mo6011f(@RecentlyNonNull InterfaceC4361e<? super TResult> interfaceC4361e);

    @NonNull
    /* JADX INFO: renamed from: g */
    public abstract Task<TResult> mo6012g(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4361e<? super TResult> interfaceC4361e);

    @NonNull
    /* JADX INFO: renamed from: h */
    public <TContinuationResult> Task<TContinuationResult> mo6013h(@RecentlyNonNull InterfaceC4353a<TResult, TContinuationResult> interfaceC4353a) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    /* JADX INFO: renamed from: i */
    public <TContinuationResult> Task<TContinuationResult> mo6014i(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4353a<TResult, TContinuationResult> interfaceC4353a) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    /* JADX INFO: renamed from: j */
    public <TContinuationResult> Task<TContinuationResult> mo6015j(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4353a<TResult, Task<TContinuationResult>> interfaceC4353a) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @RecentlyNullable
    /* JADX INFO: renamed from: k */
    public abstract Exception mo6016k();

    @RecentlyNonNull
    /* JADX INFO: renamed from: l */
    public abstract TResult mo6017l();

    @RecentlyNonNull
    /* JADX INFO: renamed from: m */
    public abstract <X extends Throwable> TResult mo6018m(@RecentlyNonNull Class<X> cls) throws Throwable;

    /* JADX INFO: renamed from: n */
    public abstract boolean mo6019n();

    /* JADX INFO: renamed from: o */
    public abstract boolean mo6020o();

    /* JADX INFO: renamed from: p */
    public abstract boolean mo6021p();

    @NonNull
    /* JADX INFO: renamed from: q */
    public <TContinuationResult> Task<TContinuationResult> mo6022q(@RecentlyNonNull InterfaceC4362f<TResult, TContinuationResult> interfaceC4362f) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @NonNull
    /* JADX INFO: renamed from: r */
    public <TContinuationResult> Task<TContinuationResult> mo6023r(@RecentlyNonNull Executor executor, @RecentlyNonNull InterfaceC4362f<TResult, TContinuationResult> interfaceC4362f) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
