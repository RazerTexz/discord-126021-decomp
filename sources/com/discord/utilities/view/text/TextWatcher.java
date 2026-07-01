package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TextWatcher implements android.text.TextWatcher {
    public static final TextWatcher$Companion Companion = new TextWatcher$Companion(null);
    private final Function1<Editable, Unit> onAfterTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> onBeforeTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> onTextChanged;

    public TextWatcher() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextWatcher(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function5, Function1<? super Editable, Unit> function1) {
        this.onBeforeTextChanged = function4;
        this.onTextChanged = function5;
        this.onAfterTextChanged = function1;
    }

    public static final void addBindedTextWatcher(Fragment fragment, TextView textView, Action1<String> action1) {
        Companion.addBindedTextWatcher(fragment, textView, action1);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        m.checkNotNullParameter(s2, "s");
        Function1<Editable, Unit> function1 = this.onAfterTextChanged;
        if (function1 != null) {
            function1.invoke(s2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        m.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.onBeforeTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
        m.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.onTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public /* synthetic */ TextWatcher(Function4 function4, Function4 function5, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function4, (i & 2) != 0 ? null : function5, (i & 4) != 0 ? null : function1);
    }
}
