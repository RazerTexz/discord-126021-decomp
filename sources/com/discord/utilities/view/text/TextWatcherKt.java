package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcherKt {
    private static final HashMap<Fragment, HashMap<TextView, ArrayList<android.text.TextWatcher>>> bindedTextWatchers = new HashMap<>();

    public static final /* synthetic */ HashMap access$getBindedTextWatchers$p() {
        return bindedTextWatchers;
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, android.text.TextWatcher textWatcher) {
        m.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(textWatcher, "textWatcher");
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
        m.checkNotNullParameter(textView, "$this$addLifecycleAwareTextWatcher");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(function1, "afterTextChanged");
        textView.addTextChangedListener(new FragmentLifecycleTextWatcher(fragment, textView, null, null, new TextWatcherKt$addLifecycleAwareTextWatcher$1(function1), 12, null));
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, Function1<? super Editable, Unit> function1) {
        m.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(function1, "onAfterTextChanged");
        addBindedTextWatcher(textView, fragment, new TextWatcher(null, null, function1, 3, null));
    }
}
