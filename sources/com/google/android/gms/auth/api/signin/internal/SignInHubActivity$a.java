package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.app.LoaderManager$LoaderCallbacks;
import androidx.loader.content.Loader;
import b.i.a.f.c.a.f.b.d;
import b.i.a.f.c.a.f.b.t;
import b.i.a.f.e.h.c;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class SignInHubActivity$a implements LoaderManager$LoaderCallbacks<Void> {
    public final /* synthetic */ SignInHubActivity a;

    public SignInHubActivity$a(SignInHubActivity signInHubActivity, t tVar) {
        this.a = signInHubActivity;
    }

    @Override // androidx.loader.app.LoaderManager$LoaderCallbacks
    public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
        SignInHubActivity signInHubActivity = this.a;
        Set<c> set = c.a;
        synchronized (set) {
        }
        return new d(signInHubActivity, set);
    }

    @Override // androidx.loader.app.LoaderManager$LoaderCallbacks
    public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r3) {
        SignInHubActivity signInHubActivity = this.a;
        signInHubActivity.setResult(signInHubActivity.n, signInHubActivity.o);
        this.a.finish();
    }

    @Override // androidx.loader.app.LoaderManager$LoaderCallbacks
    public final void onLoaderReset(Loader<Void> loader) {
    }
}
