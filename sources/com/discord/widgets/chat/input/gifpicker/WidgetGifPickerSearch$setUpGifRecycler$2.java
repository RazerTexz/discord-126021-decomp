package com.discord.widgets.chat.input.gifpicker;

import com.discord.views.SearchInputView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifPickerSearch$setUpGifRecycler$2 extends k implements Function1<String, Unit> {
    public WidgetGifPickerSearch$setUpGifRecycler$2(SearchInputView searchInputView) {
        super(1, searchInputView, SearchInputView.class, "setText", "setText(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "p1");
        ((SearchInputView) this.receiver).setText(str);
    }
}
