package com.discord.utilities.views;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13116h1;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: ViewCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewCoroutineScopeKt {
    private static final int SCOPE_TAG_KEY = -53661613;

    /* JADX WARN: Type inference failed for: r1v4, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.CoroutineScope] */
    public static final CoroutineScope getCoroutineScope(View view) {
        C12238m.checkNotNullParameter(view, "$this$coroutineScope");
        if (!view.isAttachedToWindow()) {
            return null;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        int i = SCOPE_TAG_KEY;
        Object tag = view.getTag(i);
        if (!(tag instanceof CoroutineScope)) {
            tag = null;
        }
        ?? r3 = (CoroutineScope) tag;
        ref$ObjectRef.element = r3;
        if (((CoroutineScope) r3) != null) {
            return (CoroutineScope) r3;
        }
        Job jobM4279d = C3404f.m4279d(null, 1);
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        ref$ObjectRef.element = C3404f.m4275c(CoroutineContext.Element.C12790a.plus((C13116h1) jobM4279d, C13031n.f27700b.mo11194H()));
        view.getViewTreeObserver().addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: com.discord.utilities.views.ViewCoroutineScopeKt$coroutineScope$1
            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowAttached() {
            }

            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowDetached() {
                C3404f.m4335r((CoroutineScope) ref$ObjectRef.element, new CancellationException("view detached from window"));
            }
        });
        view.setTag(i, (CoroutineScope) ref$ObjectRef.element);
        return (CoroutineScope) ref$ObjectRef.element;
    }
}
