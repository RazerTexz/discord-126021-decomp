package com.discord.widgets.debugging;

import android.content.Context;
import android.os.Build;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetFatalCrash.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFatalCrash extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFatalCrash.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFatalCrashBinding;", 0)};
    public static final WidgetFatalCrash$Companion Companion = new WidgetFatalCrash$Companion(null);
    private static final String INTENT_EXTRA_CRASH_SOURCE = "INTENT_EXTRA_CRASH_SOURCE";
    private static final String INTENT_EXTRA_CRASH_TIME = "INTENT_EXTRA_CRASH_TIME";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetFatalCrash() {
        super(R$layout.widget_fatal_crash);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFatalCrash$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetFatalCrashBinding getBinding() {
        return (WidgetFatalCrashBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, Throwable th, String str) {
        Companion.launch(context, th, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.fatalCrashTestersInvite");
        linkifiedTextView.setText(b.k(this, 2131888214, new Object[]{"https://discord.gg/discord-testers"}, null, 4));
        Bundle extras = getMostRecentIntent().getExtras();
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.fatalCrashSource");
        Object[] objArr = new Object[1];
        objArr[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_SOURCE, getString(2131895919)) : null;
        textView.setText(b.k(this, 2131888213, objArr, null, 4));
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.fatalCrashTime");
        Object[] objArr2 = new Object[1];
        objArr2[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_TIME) : null;
        textView2.setText(b.k(this, 2131888215, objArr2, null, 4));
        TextView textView3 = getBinding().f2384b;
        m.checkNotNullExpressionValue(textView3, "binding.fatalCrashAppVersion");
        textView3.setText(b.k(this, 2131888208, new Object[]{BuildConfig.VERSION_NAME}, null, 4));
        TextView textView4 = getBinding().d;
        m.checkNotNullExpressionValue(textView4, "binding.fatalCrashOsVersion");
        textView4.setText(b.k(this, 2131888211, new Object[]{String.valueOf(Build$VERSION.SDK_INT)}, null, 4));
        TextView textView5 = getBinding().c;
        m.checkNotNullExpressionValue(textView5, "binding.fatalCrashDevice");
        textView5.setText(b.k(this, 2131888210, new Object[]{Build.MODEL + ' ' + Build.PRODUCT}, null, 4));
    }
}
