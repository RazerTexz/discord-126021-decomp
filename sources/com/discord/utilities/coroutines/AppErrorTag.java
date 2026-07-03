package com.discord.utilities.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppErrorTag implements CoroutineContext.Element {
    private final String errorTag;
    private final CoroutineContext.Key<AppErrorTag> key;

    /* JADX INFO: compiled from: AppCoroutineScope.kt */
    public static final class Key implements CoroutineContext.Key<AppErrorTag> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    public AppErrorTag(String str) {
        C12238m.checkNotNullParameter(str, "errorTag");
        this.errorTag = str;
        this.key = Key.INSTANCE;
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
        C12238m.checkNotNullParameter(errorTag, "errorTag");
        return new AppErrorTag(errorTag);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AppErrorTag) && C12238m.areEqual(this.errorTag, ((AppErrorTag) other).errorTag);
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        C12238m.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.C12790a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        C12238m.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.C12790a.get(this, key);
    }

    public final String getErrorTag() {
        return this.errorTag;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<AppErrorTag> getKey() {
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
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        C12238m.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.C12790a.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.C12790a.plus(this, coroutineContext);
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("AppErrorTag(errorTag="), this.errorTag, ")");
    }
}
