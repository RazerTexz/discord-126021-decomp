package com.discord.utilities.views;

import android.view.View;
import android.view.ViewTreeObserver;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;
import s.a.h1;

/* JADX INFO: renamed from: com.discord.utilities.views.ViewCoroutineScopeKt, reason: use source file name */
/* JADX INFO: compiled from: ViewCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewCoroutineScope {
    private static final int SCOPE_TAG_KEY = -53661613;

    /* JADX WARN: Type inference failed for: r1v4, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.CoroutineScope] */
    public static final CoroutineScope getCoroutineScope(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$coroutineScope");
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
        Job jobD = f.d(null, 1);
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        ref$ObjectRef.element = f.c(CoroutineContext.Element.a.plus((h1) jobD, MainDispatchers.f3830b.H()));
        view.getViewTreeObserver().addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: com.discord.utilities.views.ViewCoroutineScopeKt$coroutineScope$1
            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowAttached() {
            }

            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowDetached() {
                f.r((CoroutineScope) ref$ObjectRef.element, new CancellationException("view detached from window"));
            }
        });
        view.setTag(i, (CoroutineScope) ref$ObjectRef.element);
        return (CoroutineScope) ref$ObjectRef.element;
    }
}
