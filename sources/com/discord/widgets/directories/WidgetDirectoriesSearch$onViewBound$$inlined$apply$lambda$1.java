package com.discord.widgets.directories;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.m;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$onViewBound$$inlined$apply$lambda$1 implements TextWatcher {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch$onViewBound$$inlined$apply$lambda$1(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
        FloatingActionButton floatingActionButton = this.this$0.getBinding().f;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.search");
        WidgetDirectoriesSearchViewModel viewModel = this.this$0.getViewModel();
        if (text == null) {
            text = "";
        }
        floatingActionButton.setVisibility(viewModel.shouldNotSearch(text) ^ true ? 0 : 8);
    }
}
