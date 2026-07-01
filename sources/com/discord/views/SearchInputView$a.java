package com.discord.views;

import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: SearchInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchInputView$a<T> implements Action1<String> {
    public final /* synthetic */ SearchInputView j;
    public final /* synthetic */ Function1 k;

    public SearchInputView$a(SearchInputView searchInputView, Function1 function1) {
        this.j = searchInputView;
        this.k = function1;
    }

    @Override // rx.functions.Action1
    public void call(String str) {
        String str2 = str;
        Function1 function1 = this.k;
        m.checkNotNullExpressionValue(str2, "searchQuery");
        function1.invoke(str2);
        SearchInputView searchInputView = this.j;
        int i = SearchInputView.j;
        searchInputView.b(str2);
    }
}
