package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcherKt {
    private static final HashMap<Fragment, HashMap<TextView, ArrayList<android.text.TextWatcher>>> bindedTextWatchers = new HashMap<>();

    /* JADX INFO: renamed from: com.discord.utilities.view.text.TextWatcherKt$addLifecycleAwareTextWatcher$1 */
    /* JADX INFO: compiled from: TextWatcher.kt */
    public static final class C70131 extends AbstractC12240o implements Function1<Editable, Unit> {
        public final /* synthetic */ Function1 $afterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70131(Function1 function1) {
            super(1);
            this.$afterTextChanged = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            this.$afterTextChanged.invoke(editable.toString());
        }
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, android.text.TextWatcher textWatcher) {
        C12238m.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(textWatcher, "textWatcher");
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
        C12238m.checkNotNullParameter(textView, "$this$addLifecycleAwareTextWatcher");
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(function1, "afterTextChanged");
        textView.addTextChangedListener(new FragmentLifecycleTextWatcher(fragment, textView, null, null, new C70131(function1), 12, null));
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, Function1<? super Editable, Unit> function1) {
        C12238m.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(function1, "onAfterTextChanged");
        addBindedTextWatcher(textView, fragment, new TextWatcher(null, null, function1, 3, null));
    }
}
