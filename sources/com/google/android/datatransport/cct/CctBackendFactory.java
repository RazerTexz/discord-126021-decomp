package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import b.i.a.b.i.CctTransportBackend3;
import b.i.a.b.j.q.BackendFactory;
import b.i.a.b.j.q.CreationContext;
import b.i.a.b.j.q.TransportBackend;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CctBackendFactory implements BackendFactory {
    @Override // b.i.a.b.j.q.BackendFactory
    public TransportBackend create(CreationContext creationContext) {
        return new CctTransportBackend3(creationContext.a(), creationContext.d(), creationContext.c());
    }
}
