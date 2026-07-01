package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RenderContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RenderContext {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Map<String, String> args = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Hook> hooks = new HashMap();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public List<? extends Object> orderedArguments;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @ColorInt
    public Integer boldColor;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @ColorInt
    public Integer strikethroughColor;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean uppercase;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean hasClickables;

    public final void a(String key, Function1<? super Hook, Unit> hookInitializer) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(hookInitializer, "hookInitializer");
        Map<String, Hook> map = this.hooks;
        Hook hook = new Hook();
        hookInitializer.invoke(hook);
        map.put(key, hook);
    }

    public final void b(String key, Function1<? super View, Unit> onClick) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(onClick, "onClick");
        a(key, new RenderContext$a(onClick));
    }
}
