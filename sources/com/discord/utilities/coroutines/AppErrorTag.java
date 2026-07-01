package com.discord.utilities.coroutines;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Element$a;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppErrorTag implements CoroutineContext$Element {
    private final String errorTag;
    private final CoroutineContext$Key<AppErrorTag> key;

    public AppErrorTag(String str) {
        m.checkNotNullParameter(str, "errorTag");
        this.errorTag = str;
        this.key = AppErrorTag$Key.INSTANCE;
    }

    public static /* synthetic */ AppErrorTag copy$default(AppErrorTag appErrorTag, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appErrorTag.errorTag;
        }
        return appErrorTag.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getErrorTag() {
        return this.errorTag;
    }

    public final AppErrorTag copy(String errorTag) {
        m.checkNotNullParameter(errorTag, "errorTag");
        return new AppErrorTag(errorTag);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AppErrorTag) && m.areEqual(this.errorTag, ((AppErrorTag) other).errorTag);
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext$Element, ? extends R> function2) {
        m.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext$Element$a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        return (E) CoroutineContext$Element$a.get(this, coroutineContext$Key);
    }

    public final String getErrorTag() {
        return this.errorTag;
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Key<AppErrorTag> getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.errorTag;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        return CoroutineContext$Element$a.minusKey(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext$Element$a.plus(this, coroutineContext);
    }

    public String toString() {
        return a.J(a.U("AppErrorTag(errorTag="), this.errorTag, ")");
    }
}
