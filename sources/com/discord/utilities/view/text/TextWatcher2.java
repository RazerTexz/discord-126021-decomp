package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnLifecycleEvent;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.view.text.FragmentLifecycleTextWatcher, reason: use source file name */
/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcher2 implements android.text.TextWatcher, LifecycleObserver {
    private final Function1<Editable, Unit> afterTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> beforeTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> textChanged;
    private final TextView textView;

    /* JADX WARN: Multi-variable type inference failed */
    public TextWatcher2(Fragment fragment, TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function5, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.beforeTextChanged = function4;
        this.textChanged = function5;
        this.afterTextChanged = function1;
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics3.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        viewLifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function1<Editable, Unit> function1 = this.afterTextChanged;
        if (function1 != null) {
            function1.invoke(s2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.beforeTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroyView() {
        this.textView.removeTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.textChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public /* synthetic */ TextWatcher2(Fragment fragment, TextView textView, Function4 function4, Function4 function5, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, textView, (i & 4) != 0 ? null : function4, (i & 8) != 0 ? null : function5, (i & 16) != 0 ? null : function1);
    }
}
