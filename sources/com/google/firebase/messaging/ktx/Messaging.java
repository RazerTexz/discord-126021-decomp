package com.google.firebase.messaging.ktx;

import b.i.a.f.e.o.f;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import d0.t.CollectionsJVM;
import java.util.List;

/* JADX INFO: renamed from: com.google.firebase.messaging.ktx.FirebaseMessagingKtxRegistrar, reason: use source file name */
/* JADX INFO: compiled from: Messaging.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Messaging implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        return CollectionsJVM.listOf(f.N("fire-fcm-ktx", "21.0.0"));
    }
}
