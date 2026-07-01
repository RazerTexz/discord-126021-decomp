package com.discord.widgets.search;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.TextView;
import com.discord.app.AppFragment;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$configureSearchInput$1 extends o implements Function3<TextView, Integer, KeyEvent, Boolean> {
    public final /* synthetic */ WidgetSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearch$configureSearchInput$1(WidgetSearch widgetSearch) {
        super(3);
        this.this$0 = widgetSearch;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
        return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
    }

    public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
        m.checkNotNullParameter(textView, "textView");
        if (i != 2 && i != 3 && i != 6) {
            return false;
        }
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
        StoreSearch search = StoreStream.Companion.getSearch();
        TextInputLayout textInputLayout = WidgetSearch.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "textView.context");
        search.loadInitial(textOrEmpty, new ContextSearchStringProvider(context));
        return true;
    }
}
