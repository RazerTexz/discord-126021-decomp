package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.view.text.TextWatcherKt, reason: use source file name */
/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcher4 {
    private static final HashMap<Fragment, HashMap<TextView, ArrayList<android.text.TextWatcher>>> bindedTextWatchers = new HashMap<>();

    /* JADX INFO: renamed from: com.discord.utilities.view.text.TextWatcherKt$addLifecycleAwareTextWatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextWatcher.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public final /* synthetic */ Function1 $afterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$afterTextChanged = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            this.$afterTextChanged.invoke(editable.toString());
        }
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, android.text.TextWatcher textWatcher) {
        Intrinsics3.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(textWatcher, "textWatcher");
        HashMap<Fragment, HashMap<TextView, ArrayList<android.text.TextWatcher>>> map = bindedTextWatchers;
        HashMap<TextView, ArrayList<android.text.TextWatcher>> map2 = map.get(fragment);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        ArrayList<android.text.TextWatcher> arrayList = map2.get(textView);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        map.put(fragment, map2);
        HashMap<TextView, ArrayList<android.text.TextWatcher>> map3 = map.get(fragment);
        if (map3 != null) {
            map3.put(textView, arrayList);
        }
        arrayList.add(textWatcher);
        textView.addTextChangedListener(textWatcher);
    }

    public static final void addLifecycleAwareTextWatcher(TextView textView, Fragment fragment, Function1<? super String, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "$this$addLifecycleAwareTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "afterTextChanged");
        textView.addTextChangedListener(new TextWatcher2(fragment, textView, null, null, new AnonymousClass1(function1), 12, null));
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "onAfterTextChanged");
        addBindedTextWatcher(textView, fragment, new TextWatcher(null, null, function1, 3, null));
    }
}
